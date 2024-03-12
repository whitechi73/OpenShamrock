package qq.service.group

import KQQ.RespBatchProcess
import com.qq.jce.wup.UniPacket
import com.tencent.mobileqq.app.BusinessHandlerFactory
import com.tencent.mobileqq.data.troop.TroopInfo
import com.tencent.mobileqq.data.troop.TroopMemberInfo
import com.tencent.mobileqq.pb.ByteStringMicro
import com.tencent.mobileqq.troop.api.ITroopInfoService
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo
import friendlist.stUinInfo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.internals.NTServiceFetcher
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import moe.fuqiuluo.shamrock.tools.putBuf32Long
import moe.fuqiuluo.shamrock.tools.slice
import protobuf.auto.toByteArray
import protobuf.oidb.cmd0xf16.Oidb0xf16
import protobuf.oidb.cmd0xf16.SetGroupRemarkReq
import qq.service.QQInterfaces
import tencent.im.group.group_member_info
import tencent.im.oidb.cmd0x88d.oidb_0x88d
import tencent.im.oidb.cmd0x899.oidb_0x899
import tencent.im.oidb.cmd0x89a.oidb_0x89a
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0
import tencent.im.oidb.cmd0x8a7.cmd0x8a7
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc
import tencent.im.oidb.cmd0xed3.oidb_cmd0xed3
import tencent.im.oidb.oidb_sso
import tencent.im.troop.honor.troop_honor
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.nio.ByteBuffer
import kotlin.coroutines.resume

internal object GroupHelper: QQInterfaces() {
    private val RefreshTroopMemberInfoLock by lazy { Mutex() }
    private val RefreshTroopMemberListLock by lazy { Mutex() }

    private lateinit var METHOD_REQ_MEMBER_INFO: Method
    private lateinit var METHOD_REQ_MEMBER_INFO_V2: Method
    private lateinit var METHOD_REQ_TROOP_LIST: Method
    private lateinit var METHOD_REQ_TROOP_MEM_LIST: Method
    private lateinit var METHOD_REQ_MODIFY_GROUP_NAME: Method

    fun getGroupInfo(groupId: String): TroopInfo {
        val service = app
            .getRuntimeService(ITroopInfoService::class.java, "all")

        return service.getTroopInfo(groupId)
    }

    fun isAdmin(groupId: String): Boolean {
        val groupInfo = getGroupInfo(groupId)

        return groupInfo.isAdmin || groupInfo.troopowneruin == app.account
    }

    fun isOwner(groupId: String): Boolean {
        val groupInfo = getGroupInfo(groupId)
        return groupInfo.troopowneruin == app.account
    }

    fun getAdminList(
        groupId: Long,
        withOwner: Boolean = false
    ): List<Long> {
        val groupInfo = getGroupInfo(groupId.toString())
        return (groupInfo.Administrator ?: "")
            .split("|", ",")
            .also {
                if (withOwner && it is ArrayList<String>) {
                    it.add(0, groupInfo.troopowneruin)
                }
            }.mapNotNull { it.ifNullOrEmpty { null }?.toLong() }
    }

    suspend fun getGroupList(refresh: Boolean): Result<List<TroopInfo>> {
        val service = app.getRuntimeService(ITroopInfoService::class.java, "all")

        var troopList = service.allTroopList
        if(refresh || !service.isTroopCacheInited || troopList == null) {
            if(!requestGroupInfo(service)) {
                return Result.failure(Exception("获取群列表失败"))
            } else {
                troopList = service.allTroopList
            }
        }
        return Result.success(troopList)
    }

    private suspend fun requestGroupInfo(
        service: ITroopInfoService
    ): Boolean {
        refreshTroopList()

        return suspendCancellableCoroutine { continuation ->
            val waiter = GlobalScope.launch {
                do {
                    delay(1000)
                } while (
                    !service.isTroopCacheInited
                )
                continuation.resume(true)
            }
            continuation.invokeOnCancellation {
                waiter.cancel()
                continuation.resume(false)
            }
        }
    }

    fun banMember(groupId: Long, memberUin: Long, time: Int) {
        val buffer = ByteBuffer.allocate(1 * 8 + 7)
        buffer.putBuf32Long(groupId)
        buffer.put(32.toByte())
        buffer.putShort(1)
        buffer.putBuf32Long(memberUin)
        buffer.putInt(time)
        val array = buffer.array()
        sendOidb("OidbSvc.0x570_8", 1392, 8, array)
    }

    fun pokeMember(groupId: Long, memberUin: Long) {
        val req = oidb_cmd0xed3.ReqBody().apply {
            uint64_group_code.set(groupId)
            uint64_to_uin.set(memberUin)
            uint32_msg_seq.set(0)
        }
        sendOidb("OidbSvc.0xed3", 3795, 1, req.toByteArray())
    }

    fun kickMember(groupId: Long, rejectAddRequest: Boolean, kickMsg: String, vararg memberUin: Long) {
        val reqBody = oidb_0x8a0.ReqBody()
        reqBody.opt_uint64_group_code.set(groupId)
        memberUin.forEach {
            val memberInfo = oidb_0x8a0.KickMemberInfo()
            memberInfo.opt_uint32_operate.set(5)
            memberInfo.opt_uint64_member_uin.set(it)
            memberInfo.opt_uint32_flag.set(if (rejectAddRequest) 1 else 0)
            reqBody.rpt_msg_kick_list.add(memberInfo)
        }
        if (kickMsg.isNotEmpty()) {
            reqBody.bytes_kick_msg.set(ByteStringMicro.copyFrom(kickMsg.toByteArray()))
        }
        sendOidb("OidbSvc.0x8a0_0", 2208, 0, reqBody.toByteArray())
    }

    fun resignTroop(groupId: String) {
        sendExtra("ProfileService.GroupMngReq") {
            it.putInt("groupreqtype", 2)
            it.putString("troop_uin", groupId)
            it.putString("uin", app.currentUin)
        }
    }

    fun modifyGroupMemberCard(groupId: Long, userId: Long, name: String): Boolean {
        val createToServiceMsg = createToServiceMsg("friendlist.ModifyGroupCardReq")
        createToServiceMsg.extraData.putLong("dwZero", 0L)
        createToServiceMsg.extraData.putLong("dwGroupCode", groupId)
        val info = stUinInfo()
        info.cGender = -1
        info.dwuin = userId
        info.sEmail = ""
        info.sName = name
        info.sPhone = ""
        info.sRemark = ""
        info.dwFlag = 1
        createToServiceMsg.extraData.putSerializable("vecUinInfo", arrayListOf(info))
        createToServiceMsg.extraData.putLong("dwNewSeq", 0L)
        sendToServiceMsg(createToServiceMsg)
        return true
    }

    fun modifyTroopName(groupId: String, name: String) {
        val businessHandler = app.getBusinessHandler(BusinessHandlerFactory.TROOP_MODIFY_HANDLER)

        if (!::METHOD_REQ_MODIFY_GROUP_NAME.isInitialized) {
            METHOD_REQ_MODIFY_GROUP_NAME = businessHandler.javaClass.declaredMethods.first {
                it.parameterCount == 3
                        && it.parameterTypes[0] == String::class.java
                        && it.parameterTypes[1] == String::class.java
                        && it.parameterTypes[2] == Boolean::class.java
                        && !Modifier.isPrivate(it.modifiers)
            }
        }

        METHOD_REQ_MODIFY_GROUP_NAME.invoke(businessHandler, groupId, name, false)
    }

    fun modifyGroupRemark(groupId: Long, remark: String): Boolean {
        sendOidb("OidbSvc.0xf16_1", 3862, 1, Oidb0xf16(
            setGroupRemarkReq = SetGroupRemarkReq(
                groupCode = groupId.toULong(),
                groupUin = groupCode2GroupUin(groupId).toULong(),
                groupRemark = remark
            )
        ).toByteArray())
        return true
    }

    fun setGroupAdmin(groupId: Long, userId: Long, enable: Boolean) {
        val buffer = ByteBuffer.allocate(9)
        buffer.putBuf32Long(groupId)
        buffer.putBuf32Long(userId)
        buffer.put(if (enable) 1 else 0)
        val array = buffer.array()
        sendOidb("OidbSvc.0x55c_1", 1372, 1, array)
    }

    suspend fun setGroupUniqueTitle(groupId: Long, userId: Long, title: String) {
        val localMemberInfo = getTroopMemberInfoByUin(groupId, userId, true).getOrThrow()
        val req = Oidb_0x8fc.ReqBody()
        req.uint64_group_code.set(groupId)
        val memberInfo = Oidb_0x8fc.MemberInfo()
        memberInfo.uint64_uin.set(userId)
        memberInfo.bytes_uin_name.set(ByteStringMicro.copyFromUtf8(localMemberInfo.troopnick.ifEmpty {
            localMemberInfo.troopremark.ifNullOrEmpty { "" }
        }))
        memberInfo.bytes_special_title.set(ByteStringMicro.copyFromUtf8(title))
        memberInfo.uint32_special_title_expire_time.set(-1)
        req.rpt_mem_level_info.add(memberInfo)
        sendOidb("OidbSvc.0x8fc_2", 2300, 2, req.toByteArray())
    }

    fun setGroupWholeBan(groupId: Long, enable: Boolean) {
        val reqBody = oidb_0x89a.ReqBody()
        reqBody.uint64_group_code.set(groupId)
        reqBody.st_group_info.set(oidb_0x89a.groupinfo().apply {
            uint32_shutup_time.set(if (enable) 268435455 else 0)
        })
        sendOidb("OidbSvc.0x89a_0", 2202, 0, reqBody.toByteArray())
    }

    suspend fun getGroupMemberList(groupId: String, refresh: Boolean): Result<List<TroopMemberInfo>> {
        val service = app.getRuntimeService(ITroopMemberInfoService::class.java, "all")
        var memberList = service.getAllTroopMembers(groupId)
        if (refresh || memberList == null) {
            memberList = requestTroopMemberInfo(service, groupId).onFailure {
                return Result.failure(Exception("获取群成员列表失败"))
            }.getOrThrow()
        }

        getGroupInfo(groupId, true).onSuccess {
            if(it.wMemberNum > memberList.size) {
                return getGroupMemberList(groupId, true)
            }
        }

        return Result.success(memberList)
    }

    suspend fun getProhibitedMemberList(groupId: Long): Result<List<ProhibitedMemberInfo>> {
        val fromServiceMsg = sendOidbAW("OidbSvc.0x899_0", 2201, 0, oidb_0x899.ReqBody().apply {
            uint64_group_code.set(groupId)
            uint64_start_uin.set(0)
            uint32_identify_flag.set(6)
            memberlist_opt.set(oidb_0x899.memberlist().apply {
                uint64_member_uin.set(0)
                uint32_shutup_timestap.set(0)
            })
        }.toByteArray()) ?: return Result.failure(RuntimeException("[oidb] timeout"))
        if (!fromServiceMsg.isSuccess) {
            return Result.failure(RuntimeException("[oidb] failed"))
        }
        val body = oidb_sso.OIDBSSOPkg()
        body.mergeFrom(fromServiceMsg.wupBuffer.slice(4))
        if(body.uint32_result.get() != 0) {
            return Result.failure(RuntimeException(body.str_error_msg.get()))
        }
        val resp = oidb_0x899.RspBody().mergeFrom(body.bytes_bodybuffer.get().toByteArray())
        return Result.success(resp.rpt_memberlist.get().map {
            ProhibitedMemberInfo(it.uint64_member_uin.get(), it.uint32_shutup_timestap.get())
        })
    }

    suspend fun getGroupRemainAtAllRemain (groupId: Long): Result<cmd0x8a7.RspBody> {
        val fromServiceMsg = sendOidbAW("OidbSvcTrpcTcp.0x8a7_0", 2215, 0, cmd0x8a7.ReqBody().apply {
            uint32_sub_cmd.set(1)
            uint32_limit_interval_type_for_uin.set(2)
            uint32_limit_interval_type_for_group.set(1)
            uint64_uin.set(app.longAccountUin)
            uint64_group_code.set(groupId)
        }.toByteArray(), trpc = true) ?: return Result.failure(RuntimeException("[oidb] timeout"))
        if (!fromServiceMsg.isSuccess) {
            return Result.failure(RuntimeException("[oidb] failed"))
        }
        val body = oidb_sso.OIDBSSOPkg()
        body.mergeFrom(fromServiceMsg.wupBuffer.slice(4))
        if(body.uint32_result.get() != 0) {
            return Result.failure(RuntimeException(body.str_error_msg.get()))
        }

        val resp = cmd0x8a7.RspBody().mergeFrom(body.bytes_bodybuffer.get().toByteArray())
        return Result.success(resp)
    }

    suspend fun getNotJoinedGroupInfo(groupId: Long): Result<NotJoinedGroupInfo> {
        return withTimeoutOrNull(5000) timeout@{
            val toServiceMsg = createToServiceMsg("ProfileService.ReqBatchProcess")
            toServiceMsg.extraData.putLong("troop_code", groupId)
            toServiceMsg.extraData.putBoolean("is_admin", false)
            toServiceMsg.extraData.putInt("from", 0)
            val fromServiceMsg = sendToServiceMsgAW(toServiceMsg) ?: return@timeout Result.failure(Exception("获取群信息超时"))
            if (!fromServiceMsg.isSuccess) {
                return@timeout Result.failure(Exception("获取群信息失败"))
            }
            val uniPacket = UniPacket(true)
            uniPacket.encodeName = "utf-8"
            uniPacket.decode(fromServiceMsg.wupBuffer)
            val respBatchProcess = uniPacket.getByClass("RespBatchProcess", RespBatchProcess())
            val batchRespInfo = oidb_0x88d.RspBody().mergeFrom(oidb_sso.OIDBSSOPkg()
                .mergeFrom(respBatchProcess.batch_response_list.first().buffer)
                .bytes_bodybuffer.get().toByteArray()).stzrspgroupinfo.get().firstOrNull()
                ?: return@timeout Result.failure(Exception("获取群信息失败"))
            val info = batchRespInfo.stgroupinfo
            Result.success(NotJoinedGroupInfo(
                groupId = batchRespInfo.uint64_group_code.get(),
                maxMember = info.uint32_group_member_max_num.get(),
                memberCount = info.uint32_group_member_num.get(),
                groupName = info.string_group_name.get().toStringUtf8(),
                groupDesc = info.string_group_finger_memo.get().toStringUtf8(),
                owner = info.uint64_group_owner.get(),
                createTime = info.uint32_group_create_time.get().toLong(),
                groupFlag = info.uint32_group_flag.get(),
                groupFlagExt = info.uint32_group_flag_ext.get()
            ))
        } ?: Result.failure(Exception("获取群信息超时"))
    }

    suspend fun getGroupInfo(groupId: String, refresh: Boolean): Result<TroopInfo> {
        val service = app
            .getRuntimeService(ITroopInfoService::class.java, "all")

        val groupInfo = getGroupInfo(groupId)

        return if(refresh || !service.isTroopCacheInited || groupInfo.troopuin.isNullOrBlank()) {
            requestGroupInfo(service, groupId)
        } else {
            Result.success(groupInfo)
        }
    }

    private suspend fun requestGroupInfo(dataService: ITroopInfoService, uin: String): Result<TroopInfo> {
        val info = withTimeoutOrNull(1000) {
            var troopInfo: TroopInfo?
            do {
                troopInfo = dataService.getTroopInfo(uin)
                delay(100)
            } while (troopInfo == null || troopInfo.troopuin.isNullOrBlank())
            return@withTimeoutOrNull troopInfo
        }
        return if (info != null) {
            Result.success(info)
        } else {
            Result.failure(Exception("获取群列表失败"))
        }
    }

    suspend fun getTroopMemberInfoByUin(
        groupId: Long,
        uin: Long,
        refresh: Boolean = false
    ): Result<TroopMemberInfo> {
        val service = app.getRuntimeService(ITroopMemberInfoService::class.java, "all")
        var info = service.getTroopMember(groupId.toString(), uin.toString())
        if (refresh || !service.isMemberInCache(groupId.toString(), uin.toString()) || info == null || info.troopnick == null) {
            info = requestTroopMemberInfo(service, groupId, uin).getOrNull()
        }
        if (info == null) {
            info = getTroopMemberInfoByUinViaNt(groupId, uin).getOrNull()?.let {
                TroopMemberInfo().apply {
                    troopnick = it.cardName
                    friendnick = it.nick
                }
            }
        }
        try {
            if (info != null && (info.alias == null || info.alias.isBlank())) {
                val req = group_member_info.ReqBody()
                req.uint64_group_code.set(groupId)
                req.uint64_uin.set(uin)
                req.bool_new_client.set(true)
                req.uint32_client_type.set(1)
                req.uint32_rich_card_name_ver.set(1)
                val fromServiceMsg = sendBufferAW("group_member_card.get_group_member_card_info", true, req.toByteArray())
                if (fromServiceMsg != null && fromServiceMsg.isSuccess) {
                    val rsp = group_member_info.RspBody()
                    rsp.mergeFrom(fromServiceMsg.wupBuffer.slice(4))
                    if (rsp.msg_meminfo.str_location.has()) {
                        info.alias = rsp.msg_meminfo.str_location.get().toStringUtf8()
                    }
                    if (rsp.msg_meminfo.uint32_age.has()) {
                        info.age = rsp.msg_meminfo.uint32_age.get().toByte()
                    }
                    if (rsp.msg_meminfo.bytes_group_honor.has()) {
                        val honorBytes = rsp.msg_meminfo.bytes_group_honor.get().toByteArray()
                        val honor = troop_honor.GroupUserCardHonor()
                        honor.mergeFrom(honorBytes)
                        info.level = honor.level.get()
                        // 10315: medal_id not real group level
                    }
                }
            }
        } catch (err: Throwable) {
            LogCenter.log("getTroopMemberInfoByUin: " + err.stackTraceToString(), Level.WARN)
        }
        return if (info != null) {
            Result.success(info)
        } else {
            Result.failure(Exception("获取群成员信息失败"))
        }
    }

    suspend fun getTroopMemberInfoByUinViaNt(
        groupId: Long,
        qq: Long,
        timeout: Long = 5000L
    ): Result<MemberInfo> {
        return runCatching {
            val kernelService = NTServiceFetcher.kernelService
            val sessionService = kernelService.wrapperSession
            val groupService = sessionService.groupService
            val info = withTimeoutOrNull(timeout) {
                suspendCancellableCoroutine {
                    groupService.getTransferableMemberInfo(groupId) { code, _, data ->
                        if (code != 0) {
                            it.resume(null)
                            return@getTransferableMemberInfo
                        }
                        data.forEach { (_, info) ->
                            if (info.uin == qq) {
                                it.resume(info)
                                return@forEach
                            }
                        }
                        it.resume(null)
                    }
                }
            }
            return if (info != null) {
                Result.success(info)
            } else {
                Result.failure(Exception("获取群成员信息失败"))
            }
        }
    }

    private suspend fun requestTroopMemberInfo(service: ITroopMemberInfoService, groupId: Long, memberUin: Long, timeout: Long = 10_000): Result<TroopMemberInfo> {
        val info = RefreshTroopMemberInfoLock.withLock {
            val groupIdStr = groupId.toString()
            val memberUinStr = memberUin.toString()

            service.deleteTroopMember(groupIdStr, memberUinStr)

            requestMemberInfoV2(groupId, memberUin)
            requestMemberInfo(groupId, memberUin)

            withTimeoutOrNull(timeout) {
                while (!service.isMemberInCache(groupIdStr, memberUinStr)) {
                    delay(200)
                }
                return@withTimeoutOrNull service.getTroopMember(groupIdStr, memberUinStr)
            }
        }
        return if (info != null) {
            Result.success(info)
        } else {
            Result.failure(Exception("获取群成员信息失败"))
        }
    }

    private fun requestMemberInfo(groupId: Long, memberUin: Long) {
        val businessHandler = app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER)

        if (!::METHOD_REQ_MEMBER_INFO.isInitialized) {
            METHOD_REQ_MEMBER_INFO = businessHandler.javaClass.declaredMethods.first {
                it.parameterCount == 2 &&
                        it.parameterTypes[0] == Long::class.java &&
                        it.parameterTypes[1] == Long::class.java &&
                        !Modifier.isPrivate(it.modifiers)
            }
        }

        METHOD_REQ_MEMBER_INFO.invoke(businessHandler, groupId, memberUin)
    }

    private fun requestMemberInfoV2(groupId: Long, memberUin: Long) {
        val businessHandler = app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER)

        if (!::METHOD_REQ_MEMBER_INFO_V2.isInitialized) {
            METHOD_REQ_MEMBER_INFO_V2 = businessHandler.javaClass.declaredMethods.first {
                it.parameterCount == 3 &&
                        it.parameterTypes[0] == String::class.java &&
                        it.parameterTypes[1] == String::class.java &&
                        !Modifier.isPrivate(it.modifiers)
            }
        }

        METHOD_REQ_MEMBER_INFO_V2.invoke(businessHandler, groupId.toString(), groupUin2GroupCode(groupId).toString(), arrayListOf(memberUin.toString()))
    }

    private suspend fun requestTroopMemberInfo(service: ITroopMemberInfoService, groupId: String): Result<List<TroopMemberInfo>> {
        val info = RefreshTroopMemberListLock.withLock {
            service.deleteTroopMembers(groupId)
            refreshTroopMemberList(groupId)

            withTimeoutOrNull(10000) {
                var memberList: List<TroopMemberInfo>?
                do {
                    delay(100)
                    memberList = service.getAllTroopMembers(groupId)
                } while (memberList.isNullOrEmpty())
                return@withTimeoutOrNull memberList
            }
        }
        return if (info != null) {
            Result.success(info)
        } else {
            Result.failure(Exception("获取群成员信息失败"))
        }
    }

    private fun refreshTroopMemberList(groupId: String) {
        val businessHandler = app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)

        // void C(boolean forceRefresh, String groupId, String troopcode, int reqType); // RequestedTroopList/refreshMemberListFromServer
        if (!::METHOD_REQ_TROOP_MEM_LIST.isInitialized) {
            METHOD_REQ_TROOP_MEM_LIST = businessHandler.javaClass.declaredMethods.first {
                it.parameterCount == 4
                        && it.parameterTypes[0] == Boolean::class.java
                        && it.parameterTypes[1] == String::class.java
                        && it.parameterTypes[2] == String::class.java
                        && it.parameterTypes[3] == Int::class.java
                        && !Modifier.isPrivate(it.modifiers)
            }
        }

        METHOD_REQ_TROOP_MEM_LIST.invoke(businessHandler, true, groupId, groupUin2GroupCode(groupId.toLong()).toString(), 5)
    }

    private fun refreshTroopList() {
        val businessHandler = app.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)

        if (!::METHOD_REQ_TROOP_LIST.isInitialized) {
            METHOD_REQ_TROOP_LIST = businessHandler.javaClass.declaredMethods.first {
                it.parameterCount == 0 && !Modifier.isPrivate(it.modifiers) && it.returnType == Void.TYPE
            }
        }

        METHOD_REQ_TROOP_LIST.invoke(businessHandler)
    }

    fun groupUin2GroupCode(groupuin: Long): Long {
        var calc = groupuin / 1000000L
        while (true) {
            calc -= if (calc >= 0 + 202 && calc + 202 <= 10) {
                (202 - 0).toLong()
            } else if (calc >= 11 + 480 && calc <= 19 + 480) {
                (480 - 11).toLong()
            } else if (calc >= 20 + 2100 && calc <= 66 + 2100) {
                (2100 - 20).toLong()
            } else if (calc >= 67 + 2010 && calc <= 156 + 2010) {
                (2010 - 67).toLong()
            } else if (calc >= 157 + 2147 && calc <= 209 + 2147) {
                (2147 - 157).toLong()
            } else if (calc >= 210 + 4100 && calc <= 309 + 4100) {
                (4100 - 210).toLong()
            } else if (calc >= 310 + 3800 && calc <= 499 + 3800) {
                (3800 - 310).toLong()
            } else {
                break
            }
        }
        return calc * 1000000L + groupuin % 1000000L
    }

    fun groupCode2GroupUin(groupcode: Long): Long {
        var calc = groupcode / 1000000L
        loop@ while (true) calc += when (calc) {
            in 0..10 -> {
                (202 - 0).toLong()
            }
            in 11..19 -> {
                (480 - 11).toLong()
            }
            in 20..66 -> {
                (2100 - 20).toLong()
            }
            in 67..156 -> {
                (2010 - 67).toLong()
            }
            in 157..209 -> {
                (2147 - 157).toLong()
            }
            in 210..309 -> {
                (4100 - 210).toLong()
            }
            in 310..499 -> {
                (3800 - 310).toLong()
            }
            else -> {
                break@loop
            }
        }
        return calc * 1000000L + groupcode % 1000000L
    }
}