@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.qqinterface.servlet

import com.tencent.common.app.AppInterface
import com.tencent.mobileqq.app.BusinessHandlerFactory
import com.tencent.mobileqq.app.QQAppInterface
import com.tencent.mobileqq.data.troop.TroopInfo
import com.tencent.mobileqq.data.troop.TroopMemberInfo
import com.tencent.mobileqq.pb.ByteStringMicro
import com.tencent.mobileqq.qroute.QRoute
import com.tencent.mobileqq.relation.api.IAddFriendTempApi
import com.tencent.mobileqq.troop.api.ITroopInfoService
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService
import com.tencent.protofile.join_group_link.join_group_link
import com.tencent.qphone.base.remote.ToServiceMsg
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo
import friendlist.stUinInfo
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.proto.ProtoUtils
import moe.fuqiuluo.proto.asInt
import moe.fuqiuluo.proto.asList
import moe.fuqiuluo.proto.asLong
import moe.fuqiuluo.proto.asUtf8String
import moe.fuqiuluo.proto.protobufOf
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import moe.fuqiuluo.shamrock.tools.putBuf32Long
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import mqq.app.MobileQQ
import tencent.im.oidb.cmd0x89a.oidb_0x89a
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc
import tencent.im.oidb.oidb_sso
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.nio.ByteBuffer
import kotlin.coroutines.resume
import tencent.mobileim.structmsg.`structmsg$ReqSystemMsgNew` as ReqSystemMsgNew
import tencent.mobileim.structmsg.`structmsg$FlagInfo` as FlagInfo
import tencent.mobileim.structmsg.`structmsg$RspSystemMsgNew` as RspSystemMsgNew
import tencent.mobileim.structmsg.`structmsg$StructMsg` as StructMsg
internal object GroupSvc: BaseSvc() {
    private val RefreshTroopMemberInfoLock by lazy {
        Mutex()
    }
    private val RefreshTroopMemberListLock by lazy {
        Mutex()
    }

    private lateinit var METHOD_REQ_MEMBER_INFO: Method
    private lateinit var METHOD_REQ_MEMBER_INFO_V2: Method
    private lateinit var METHOD_REQ_TROOP_LIST: Method
    private lateinit var METHOD_REQ_TROOP_MEM_LIST: Method
    private lateinit var METHOD_REQ_MODIFY_GROUP_NAME: Method

    fun poke(groupId: String, userId: String) {
        sendOidb("OidbSvc.0xed3", 3795, 1, protobufOf(
            1 to userId.toLong(),
            2 to groupId.toLong(),
            3 to 0
        ).toByteArray())
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

    suspend fun getGroupList(refresh: Boolean): Result<List<TroopInfo>> {
        val service = app.getRuntimeService(ITroopInfoService::class.java, "all")

        var troopList = service.allTroopList
        if(refresh || !service.isTroopCacheInited || troopList == null) {
            if(!requestGroupList(service)) {
                return Result.failure(Exception("获取群列表失败"))
            } else {
                troopList = service.allTroopList
            }
        }
        return Result.success(troopList)
    }

    suspend fun getGroupInfo(groupId: String, refresh: Boolean): Result<TroopInfo> {
        val service = app
            .getRuntimeService(ITroopInfoService::class.java, "all")

        var groupInfo = getGroupInfo(groupId)

        if(refresh || !service.isTroopCacheInited || groupInfo.troopuin.isNullOrBlank()) {
            groupInfo = requestGroupList(service, groupId.toLong()).onFailure {
                return Result.failure(it)
            }.getOrThrow()
        }

        return Result.success(groupInfo)
    }

    suspend fun setGroupUniqueTitle(groupId: String, userId: String, title: String) {
        val localMemberInfo = getTroopMemberInfoByUin(groupId, userId, true).getOrThrow()
        val req = Oidb_0x8fc.ReqBody()
        req.uint64_group_code.set(groupId.toLong())
        val memberInfo = Oidb_0x8fc.MemberInfo()
        memberInfo.uint64_uin.set(userId.toLong())
        memberInfo.bytes_uin_name.set(ByteStringMicro.copyFromUtf8(localMemberInfo.troopnick.ifBlank {
            localMemberInfo.troopremark.ifNullOrEmpty("")
        }))
        memberInfo.bytes_special_title.set(ByteStringMicro.copyFromUtf8(title))
        memberInfo.uint32_special_title_expire_time.set(-1)
        req.rpt_mem_level_info.add(memberInfo)
        sendOidb("OidbSvc.0x8fc_2", 2300, 2, req.toByteArray())
    }

    fun modifyGroupMemberCard(groupId: Long, userId: Long, name: String): Boolean {
        val createToServiceMsg: ToServiceMsg = createToServiceMsg("friendlist.ModifyGroupCardReq")
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
        send(createToServiceMsg)
        return true
    }

    suspend fun setEssenceMessage(groupId: Long, seq: Long, rand: Long): Pair<Boolean, String> {
        val array = protobufOf(
            1 to groupId,
            2 to seq,
            3 to rand
        ).toByteArray()
        val buffer = sendOidbAW("OidbSvc.0xeac_1", 3756, 1, array)
        val body = oidb_sso.OIDBSSOPkg()
        if (buffer == null) {
            return Pair(false, "unknown error")
        }
        body.mergeFrom(buffer.slice(4))
        val result = ProtoUtils.decodeFromByteArray(body.bytes_bodybuffer.get().toByteArray())
        return if (result.has(1)) {
            LogCenter.log("设置群精华失败: ${result[1].asUtf8String}")
            Pair(false, "设置群精华失败: ${result[1].asUtf8String}")
        } else {
            LogCenter.log("设置群精华 -> $groupId:$seq")
            Pair(true, "ok")
        }
    }

    suspend fun deleteEssenceMessage(groupId: Long, seq: Long, rand: Long): Pair<Boolean, String> {
        val array = protobufOf(
            1 to groupId,
            2 to seq,
            3 to rand
        ).toByteArray()
        val buffer = sendOidbAW("OidbSvc.0xeac_2", 3756, 2, array)
        val body = oidb_sso.OIDBSSOPkg()
        if (buffer == null) {
            return Pair(false, "unknown error")
        }
        body.mergeFrom(buffer.slice(4))
        val result = ProtoUtils.decodeFromByteArray(body.bytes_bodybuffer.get().toByteArray())
        return if (result.has(1)) {
            LogCenter.log("移除群精华失败: ${result[1].asUtf8String}")
            Pair(false, "移除群精华失败: ${result[1].asUtf8String}")
        } else {
            LogCenter.log("移除群精华 -> $groupId:$seq")
            Pair(true, "ok")
        }

    }

    fun setGroupAdmin(groupId: Long, userId: Long, enable: Boolean) {
        val buffer = ByteBuffer.allocate(9)
        buffer.putBuf32Long(groupId)
        buffer.putBuf32Long(userId)
        buffer.put(if (enable) 1 else 0)
        val array = buffer.array()
        sendOidb("OidbSvc.0x55c_1", 1372, 1, array)
    }

    fun setGroupWholeBan(groupId: Long, enable: Boolean) {
        val reqBody = oidb_0x89a.ReqBody()
        reqBody.uint64_group_code.set(groupId)
        reqBody.st_group_info.set(oidb_0x89a.groupinfo().apply {
            uint32_shutup_time.set(if (enable) 268435455 else 0)
        })
        sendOidb("OidbSvc.0x89a_0", 2202, 0, reqBody.toByteArray())
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

    fun kickMember(groupId: Long, rejectAddRequest: Boolean, vararg memberUin: Long) {
        val reqBody = oidb_0x8a0.ReqBody()
        reqBody.opt_uint64_group_code.set(groupId)

        memberUin.forEach {
            val memberInfo = oidb_0x8a0.KickMemberInfo()
            memberInfo.opt_uint32_operate.set(5)
            memberInfo.opt_uint64_member_uin.set(it)
            memberInfo.opt_uint32_flag.set(if (rejectAddRequest) 1 else 0)
            reqBody.rpt_msg_kick_list.add(memberInfo)
        }

        sendOidb("OidbSvc.0x8a0_0", 2208, 0, reqBody.toByteArray())
    }

    fun getGroupInfo(groupId: String): TroopInfo {
        val runtime = AppRuntimeFetcher.appRuntime as QQAppInterface

        val service = runtime
            .getRuntimeService(ITroopInfoService::class.java, "all")

        return service.getTroopInfo(groupId)
    }

    fun getAdminList(
        groupId: String,
        withOwner: Boolean = false
    ): List<Long> {
        val groupInfo = getGroupInfo(groupId)
        return (groupInfo.Administrator ?: "")
            .split("|", ",")
            .also {
                if (withOwner && it is ArrayList<String>) {
                    it.add(0, groupInfo.troopowneruin)
                }
            }
            .map { (it.ifNullOrEmpty("0")!!).toLong() }
            .filter { it != 0L }
    }

    fun getOwner(groupId: String): Long {
        val groupInfo = getGroupInfo(groupId)
        return groupInfo.troopowneruin.toLong()
    }

    fun isOwner(groupId: String): Boolean {
        val groupInfo = getGroupInfo(groupId)
        return groupInfo.troopowneruin == app.account
    }

    fun isAdmin(groupId: String): Boolean {
        val service = app
            .getRuntimeService(ITroopInfoService::class.java, "all")

        val groupInfo = service.getTroopInfo(groupId)

        return groupInfo.isAdmin || groupInfo.troopowneruin == app.account
    }

    fun resignTroop(groupId: Long) {
        sendExtra("ProfileService.GroupMngReq") {
            it.putInt("groupreqtype", 2)
            it.putString("troop_uin", groupId.toString())
            it.putString("uin", currentUin)
        }
    }

    fun modifyTroopName(groupId: String, name: String) {
         val businessHandler = app.getBusinessHandler(BusinessHandlerFactory.TROOP_MODIFY_HANDLER)

        if (!GroupSvc::METHOD_REQ_MODIFY_GROUP_NAME.isInitialized) {
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

    fun parseHonor(honor: String?): List<Int> {
        return (honor ?: "")
            .split("|")
            .filter { it.isNotBlank() }
            .map { it.toInt() }
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

    suspend fun getShareTroopArkMsg(groupId: Long): String {
        val reqBody = join_group_link.ReqBody()
        reqBody.get_ark.set(true)
        reqBody.type.set(1)
        reqBody.group_code.set(groupId)
        val buffer = sendBufferAW("GroupSvc.JoinGroupLink", true, reqBody.toByteArray())
            ?: error("unable to fetch contact ark_json_text")
        val body = join_group_link.RspBody()
        body.mergeFrom(buffer.slice(4))
        return body.signed_ark.get().toStringUtf8()
    }

    suspend fun getTroopMemberInfoByUin(
        groupId: String,
        uin: String,
        refresh: Boolean = false
    ): Result<TroopMemberInfo> {
        val service = app.getRuntimeService(ITroopMemberInfoService::class.java, "all")
        var info = service.getTroopMember(groupId, uin)
        if (refresh || !service.isMemberInCache(groupId, uin) || info == null || info.troopnick == null) {
            info = requestTroopMemberInfo(service, groupId.toLong(), uin.toLong()).getOrNull()
        }
        if (info == null) {
            info = getTroopMemberInfoByUinViaNt(groupId, uin.toLong()).getOrNull()?.let {
                TroopMemberInfo().apply {
                    troopnick = it.cardName
                    friendnick = it.nick
                }
            }
        }
        return if (info != null) {
            Result.success(info)
        } else {
            Result.failure(Exception("获取群成员信息失败"))
        }
    }

    private suspend fun getTroopMemberInfoByUinViaNt(groupId: String, qq: Long): Result<MemberInfo> {
        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession
        val groupService = sessionService.groupService
        val info = suspendCancellableCoroutine {
            groupService.getTransferableMemberInfo(groupId.toLong()) { code, _, data ->
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
        return if (info != null) {
            Result.success(info)
        } else {
            Result.failure(Exception("获取群成员信息失败"))
        }
    }

    suspend fun getTroopMemberInfoByUid(groupId: String, uid: String): Result<MemberInfo> {
        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession
        val groupService = sessionService.groupService
        val info = suspendCancellableCoroutine {
            groupService.getTransferableMemberInfo(groupId.toLong()) { code, _, data ->
                if (code != 0) {
                    it.resume(null)
                    return@getTransferableMemberInfo
                }
                data.forEach { (tmpUid, info) ->
                    if (tmpUid == uid) {
                        it.resume(info)
                        return@forEach
                    }
                }
            }
        }
        return if (info != null) {
            Result.success(info)
        } else {
            Result.failure(Exception("获取群成员信息失败"))
        }
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

    private suspend fun requestGroupList(
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

    private fun refreshTroopMemberList(groupId: String) {
        val app = AppRuntimeFetcher.appRuntime
        if (app !is AppInterface)
            throw RuntimeException("AppRuntime cannot cast to AppInterface")
        val businessHandler = app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)

        // void C(boolean foreRefresh, String groupId, String troopcode, int reqType); // RequestedTroopList/refreshMemberListFromServer
        if (!GroupSvc::METHOD_REQ_TROOP_MEM_LIST.isInitialized) {
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
        val app = AppRuntimeFetcher.appRuntime
        if (app !is AppInterface)
            throw RuntimeException("AppRuntime cannot cast to AppInterface")
        val businessHandler = app.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)

        if (!GroupSvc::METHOD_REQ_TROOP_LIST.isInitialized) {
            METHOD_REQ_TROOP_LIST = businessHandler.javaClass.declaredMethods.first {
                it.parameterCount == 0 && !Modifier.isPrivate(it.modifiers) && it.returnType == Void.TYPE
            }
        }

        METHOD_REQ_TROOP_LIST.invoke(businessHandler)
    }

    private fun requestMemberInfo(groupId: Long, memberUin: Long) {
        val app = AppRuntimeFetcher.appRuntime
        if (app !is AppInterface)
            throw RuntimeException("AppRuntime cannot cast to AppInterface")
        val businessHandler = app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER)

        if (!GroupSvc::METHOD_REQ_MEMBER_INFO.isInitialized) {
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
        val app = AppRuntimeFetcher.appRuntime
        if (app !is AppInterface)
            throw RuntimeException("AppRuntime cannot cast to AppInterface")
        val businessHandler = app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER)

        if (!GroupSvc::METHOD_REQ_MEMBER_INFO_V2.isInitialized) {
            METHOD_REQ_MEMBER_INFO_V2 = businessHandler.javaClass.declaredMethods.first {
                it.parameterCount == 3 &&
                        it.parameterTypes[0] == String::class.java &&
                        it.parameterTypes[1] == String::class.java &&
                        !Modifier.isPrivate(it.modifiers)
            }
        }

        METHOD_REQ_MEMBER_INFO_V2.invoke(businessHandler, groupId.toString(), groupUin2GroupCode(groupId).toString(), arrayListOf(memberUin.toString()))
    }

    private suspend fun requestGroupList(dataService: ITroopInfoService, uin: Long): Result<TroopInfo> {
        val strUin = uin.toString()
        val list = withTimeoutOrNull(5000) {
            var troopInfo: TroopInfo?
            do {
                troopInfo = dataService.getTroopInfo(strUin)
                delay(100)
            } while (troopInfo == null || troopInfo.troopuin.isNullOrBlank())
            return@withTimeoutOrNull troopInfo
        }
        return if (list != null) {
            Result.success(list)
        } else {
            Result.failure(Exception("获取群列表失败"))
        }
    }

    private suspend fun requestTroopMemberInfo(service: ITroopMemberInfoService, groupId: Long, memberUin: Long): Result<TroopMemberInfo> {
        val info = RefreshTroopMemberInfoLock.withLock {
            val groupIdStr = groupId.toString()
            val memberUinStr = memberUin.toString()

            service.deleteTroopMember(groupIdStr, memberUinStr)

            requestMemberInfoV2(groupId, memberUin)
            requestMemberInfo(groupId, memberUin)

            withTimeoutOrNull(10000) {
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

    // ProfileService.Pb.ReqSystemMsgAction.Group
    suspend fun requestGroupRequest(msgSeq: Long, uin: Long, gid: Long, msg: String? = "", approve: Boolean? = true, notSee: Boolean? = false): Result<String>{
//        val app = AppRuntimeFetcher.appRuntime
//        if (app !is AppInterface)
//            throw RuntimeException("AppRuntime cannot cast to AppInterface")
//        val service = QRoute.api(IAddFriendTempApi::class.java)
//        val action = `structmsg$SystemMsgActionInfo`()
//        action.type.set(if (approve != false) 11 else 12)
//        action.group_code.set(gid)
//        action.msg.set(msg)
//        val snInfo = `structmsg$AddFrdSNInfo`()
//        snInfo.uint32_not_see_dynamic.set(if (notSee != false) 1 else 0)
////        snInfo.uint32_set_sn.set(0)
//        action.addFrdSNInfo.set(snInfo)
//        service.sendFriendSystemMsgAction(2, msgSeq * 1000, uin, 1, 2, 30024, 1, action, 0, `structmsg$StructMsg`(), false,
//            app
//        )
        // 实在找不到接口了 发pb吧
        val buffer = protobufOf(
            1 to 2,
            2 to msgSeq,
            3 to uin,
            4 to 1,
            5 to 2,
            6 to 30024,
            7 to 1,
            8 to mapOf(
                1 to if (approve != false) 11 else 12,
                2 to gid
            ),
            9 to 1000
        ).toByteArray()
        val respBuffer = sendBufferAW("ProfileService.Pb.ReqSystemMsgAction.Group", true, buffer)
            ?: return Result.failure(Exception("操作失败"))
        val result = ProtoUtils.decodeFromByteArray(respBuffer.slice(4))
        return if (result.has(1, 1)) {
            if (result[1, 1].asInt == 0) {
                Result.success(result[2].asUtf8String)
            } else {
                Result.failure(Exception(result[2].asUtf8String))
            }
        } else {
            Result.failure(Exception("操作失败"))
        }
    }

    suspend fun requestGroupSystemMsgNew(msgNum: Int, latestFriendSeq: Long, latestGroupSeq: Long): List<StructMsg>? {
        val req = ReqSystemMsgNew()
        req.msg_num.set(msgNum)
        req.latest_friend_seq.set(latestFriendSeq)
        req.latest_group_seq.set(latestGroupSeq)
        req.version.set(1000)
        req.checktype.set(3)
        val flag = FlagInfo()
        flag.GrpMsg_Kick_Admin.set(1)
        flag.GrpMsg_HiddenGrp.set(1)
        flag.GrpMsg_WordingDown.set(1)
//        flag.FrdMsg_GetBusiCard.set(1)
        flag.GrpMsg_GetOfficialAccount.set(1)
        flag.GrpMsg_GetPayInGroup.set(1)
        flag.FrdMsg_Discuss2ManyChat.set(1)
        flag.GrpMsg_NotAllowJoinGrp_InviteNotFrd.set(1)
        flag.FrdMsg_NeedWaitingMsg.set(1)
//        flag.FrdMsg_uint32_need_all_unread_msg.set(1)
        flag.GrpMsg_NeedAutoAdminWording.set(1)
        flag.GrpMsg_get_transfer_group_msg_flag.set(1)
        flag.GrpMsg_get_quit_pay_group_msg_flag.set(1)
        flag.GrpMsg_support_invite_auto_join.set(1)
        flag.GrpMsg_mask_invite_auto_join.set(1)
        flag.GrpMsg_GetDisbandedByAdmin.set(1)
        flag.GrpMsg_GetC2cInviteJoinGroup.set(1)
        req.flag.set(flag)
        req.is_get_frd_ribbon.set(false)
        req.is_get_grp_ribbon.set(false)
        req.friend_msg_type_flag.set(1)
        req.uint32_req_msg_type.set(1)
        req.uint32_need_uid.set(1)
        val respBuffer = sendBufferAW("ProfileService.Pb.ReqSystemMsgNew.Group", true, req.toByteArray())
            ?: return ArrayList()
        val msg = RspSystemMsgNew()
        msg.mergeFrom(respBuffer.slice(4))
        return msg.groupmsgs.get()
    }
}