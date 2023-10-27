@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.qqinterface.servlet

import com.tencent.common.app.AppInterface
import com.tencent.mobileqq.app.BusinessHandlerFactory
import com.tencent.mobileqq.app.QQAppInterface
import com.tencent.mobileqq.data.troop.TroopInfo
import com.tencent.mobileqq.data.troop.TroopMemberInfo
import com.tencent.mobileqq.pb.ByteStringMicro
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
import moe.fuqiuluo.proto.protobufOf
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import moe.fuqiuluo.shamrock.tools.putBuf32Long
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import mqq.app.MobileQQ
import tencent.im.oidb.cmd0x89a.oidb_0x89a
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.nio.ByteBuffer
import kotlin.coroutines.resume

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
            localMemberInfo.troopremark
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
}