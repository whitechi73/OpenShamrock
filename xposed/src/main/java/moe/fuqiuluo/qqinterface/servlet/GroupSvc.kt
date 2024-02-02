@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.qqinterface.servlet

import KQQ.RespBatchProcess
import androidx.core.text.HtmlCompat
import com.qq.jce.wup.UniPacket
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
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import friendlist.stUinInfo
import io.ktor.client.call.body
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.http.headers
import io.ktor.http.parameters
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.protobuf.ProtoBuf
import moe.fuqiuluo.qqinterface.servlet.TicketSvc.getLongUin
import moe.fuqiuluo.qqinterface.servlet.TicketSvc.getUin
import moe.fuqiuluo.qqinterface.servlet.structures.GroupAtAllRemainInfo
import moe.fuqiuluo.qqinterface.servlet.structures.NotJoinedGroupInfo
import moe.fuqiuluo.qqinterface.servlet.structures.ProhibitedMemberInfo
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.MessageHelper
import moe.fuqiuluo.shamrock.remote.service.data.EssenceMessage
import moe.fuqiuluo.shamrock.remote.service.data.GroupAnnouncement
import moe.fuqiuluo.shamrock.remote.service.data.GroupAnnouncementMessage
import moe.fuqiuluo.shamrock.remote.service.data.GroupAnnouncementMessageImage
import moe.fuqiuluo.shamrock.tools.EmptyJsonArray
import moe.fuqiuluo.shamrock.tools.GlobalClient
import moe.fuqiuluo.shamrock.tools.asInt
import moe.fuqiuluo.shamrock.tools.asJsonArrayOrNull
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asLong
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.tools.asStringOrNull
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import moe.fuqiuluo.shamrock.tools.putBuf32Long
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import protobuf.oidb.cmd0xf16.Oidb0xf16
import protobuf.oidb.cmd0xf16.SetGroupRemarkReq
import mqq.app.MobileQQ
import tencent.im.group.group_member_info
import tencent.im.oidb.cmd0x88d.oidb_0x88d
import tencent.im.oidb.cmd0x899.oidb_0x899
import tencent.im.oidb.cmd0x89a.oidb_0x89a
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0
import tencent.im.oidb.cmd0x8a7.cmd0x8a7
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc
import tencent.im.oidb.cmd0xeac.oidb_0xeac
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7
import tencent.im.oidb.cmd0xed3.oidb_cmd0xed3
import tencent.im.oidb.oidb_sso
import tencent.im.troop.honor.troop_honor
import tencent.mobileim.structmsg.structmsg
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

    suspend fun getGroupRemainAtAllRemain (groupId: Long): Result<GroupAtAllRemainInfo> {
        val buffer = sendOidbAW("OidbSvcTrpcTcp.0x8a7_0", 2215, 0, cmd0x8a7.ReqBody().apply {
            uint32_sub_cmd.set(1)
            uint32_limit_interval_type_for_uin.set(2)
            uint32_limit_interval_type_for_group.set(1)
            uint64_uin.set(getLongUin())
            uint64_group_code.set(groupId)
        }.toByteArray(), trpc = true) ?: return Result.failure(RuntimeException("[oidb] timeout"))
        val body = oidb_sso.OIDBSSOPkg()
        body.mergeFrom(buffer.slice(4))
        if(body.uint32_result.get() != 0) {
            return Result.failure(RuntimeException(body.str_error_msg.get()))
        }

        val resp = cmd0x8a7.RspBody().mergeFrom(body.bytes_bodybuffer.get().toByteArray())
        return Result.success(GroupAtAllRemainInfo(
            canAtAll = resp.bool_can_at_all.get(),
            remainAtAllCountForGroup = resp.uint32_remain_at_all_count_for_group.get(),
            remainAtAllCountForUin = resp.uint32_remain_at_all_count_for_uin.get()
        ))
    }
    suspend fun getProhibitedMemberList(groupId: Long): Result<List<ProhibitedMemberInfo>> {
        val buffer = sendOidbAW("OidbSvc.0x899_0", 2201, 0, oidb_0x899.ReqBody().apply {
            uint64_group_code.set(groupId)
            uint64_start_uin.set(0)
            uint32_identify_flag.set(6)
            memberlist_opt.set(oidb_0x899.memberlist().apply {
                uint64_member_uin.set(0)
                uint32_shutup_timestap.set(0)
            })
        }.toByteArray()) ?: return Result.failure(RuntimeException("[oidb] timeout"))
        val body = oidb_sso.OIDBSSOPkg()
        body.mergeFrom(buffer.slice(4))
        if(body.uint32_result.get() != 0) {
            return Result.failure(RuntimeException(body.str_error_msg.get()))
        }

        val resp = oidb_0x899.RspBody().mergeFrom(body.bytes_bodybuffer.get().toByteArray())
        return Result.success(resp.rpt_memberlist.get().map {
            ProhibitedMemberInfo(it.uint64_member_uin.get(), it.uint32_shutup_timestap.get())
        })
    }

    fun poke(groupId: String, userId: String) {
        val req = oidb_cmd0xed3.ReqBody().apply {
            uint64_group_code.set(groupId.toLong())
            uint64_to_uin.set(userId.toLong())
            uint32_msg_seq.set(0)
        }
        sendOidb("OidbSvc.0xed3", 3795, 1, req.toByteArray())
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
            if(!requestGroupInfo(service)) {
                return Result.failure(Exception("获取群列表失败"))
            } else {
                troopList = service.allTroopList
            }
        }
        return Result.success(troopList)
    }

    suspend fun getNotJoinedGroupInfo(groupId: Long): Result<NotJoinedGroupInfo> {
        return withTimeoutOrNull(5000) timeout@{
            val toServiceMsg = createToServiceMsg("ProfileService.ReqBatchProcess")
            toServiceMsg.extraData.putLong("troop_code", groupId)
            toServiceMsg.extraData.putBoolean("is_admin", false)
            toServiceMsg.extraData.putInt("from", 0)
            val buffer = sendAW(toServiceMsg)
            val uniPacket = UniPacket(true)
            uniPacket.encodeName = "utf-8"
            uniPacket.decode(buffer)
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
            requestGroupInfo(service, groupId.toLong())
        } else {
            Result.success(groupInfo)
        }

    }

    suspend fun setGroupUniqueTitle(groupId: String, userId: String, title: String) {
        val localMemberInfo = getTroopMemberInfoByUin(groupId, userId, true).getOrThrow()
        val req = Oidb_0x8fc.ReqBody()
        req.uint64_group_code.set(groupId.toLong())
        val memberInfo = Oidb_0x8fc.MemberInfo()
        memberInfo.uint64_uin.set(userId.toLong())
        memberInfo.bytes_uin_name.set(ByteStringMicro.copyFromUtf8(localMemberInfo.troopnick.ifEmpty {
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

    fun modifyGroupRemark(groupId: Long, remark: String): Boolean {
        sendOidb("OidbSvc.0xf16_1", 3862, 1, ProtoBuf.encodeToByteArray(
            Oidb0xf16(
            setGroupRemarkReq = SetGroupRemarkReq(
                groupCode = groupId.toULong(),
                groupUin = groupCode2GroupUin(groupId).toULong(),
                groupRemark = remark
            )
        )
        ))
        return true
    }

    suspend fun setEssenceMessage(groupId: Long, seq: Long, rand: Long): Pair<Boolean, String> {
        val buffer = sendOidbAW("OidbSvc.0xeac_1", 3756, 1, oidb_0xeac.ReqBody().apply {
            group_code.set(groupId)
            msg_seq.set(seq.toInt())
            msg_random.set(rand.toInt())
        }.toByteArray()) ?: return Pair(false, "unknown error")
        val body = oidb_sso.OIDBSSOPkg()
        body.mergeFrom(buffer.slice(4))
        val result = oidb_0xeac.RspBody().mergeFrom(body.bytes_bodybuffer.get().toByteArray())
        return if (result.wording.has()) {
            LogCenter.log("设置群精华失败: ${result.wording.get()}")
            Pair(false, "设置群精华失败: ${result.wording.get()}")
        } else {
            LogCenter.log("设置群精华 -> $groupId: $seq")
            Pair(true, "ok")
        }
    }

    suspend fun deleteEssenceMessage(groupId: Long, seq: Long, rand: Long): Pair<Boolean, String> {
        val buffer = sendOidbAW("OidbSvc.0xeac_2", 3756, 2, oidb_0xeac.ReqBody().apply {
            group_code.set(groupId)
            msg_seq.set(seq.toInt())
            msg_random.set(rand.toInt())
        }.toByteArray())
        val body = oidb_sso.OIDBSSOPkg()
        if (buffer == null) {
            return Pair(false, "unknown error")
        }
        body.mergeFrom(buffer.slice(4))
        val result = oidb_0xeac.RspBody().mergeFrom(body.bytes_bodybuffer.get().toByteArray())
        return if (result.wording.has()) {
            LogCenter.log("移除群精华失败: ${result.wording.get()}")
            Pair(false, "移除群精华失败: ${result.wording.get()}")
        } else {
            LogCenter.log("移除群精华 -> $groupId: $seq")
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
        return groupInfo.troopowneruin?.toLong() ?: 0
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
        try {
            if (info != null && (info.alias == null || info.alias.isBlank())) {
                val req = group_member_info.ReqBody()
                req.uint64_group_code.set(groupId.toLong())
                req.uint64_uin.set(uin.toLong())
                req.bool_new_client.set(true)
                req.uint32_client_type.set(1)
                req.uint32_rich_card_name_ver.set(1)
                val respBuffer = sendBufferAW("group_member_card.get_group_member_card_info", true, req.toByteArray())
                if (respBuffer != null) {
                    val rsp = group_member_info.RspBody()
                    rsp.mergeFrom(respBuffer.slice(4))
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
            LogCenter.log(err.stackTraceToString(), Level.WARN)
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

    suspend fun getTroopMemberInfoByUid(groupId: Long, uid: String): Result<MemberInfo> {
        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession
        val groupService = sessionService.groupService
        val info = suspendCancellableCoroutine {
            groupService.getTransferableMemberInfo(groupId) { code, _, data ->
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

    private fun refreshTroopMemberList(groupId: String) {
        val app = AppRuntimeFetcher.appRuntime
        if (app !is AppInterface)
            throw RuntimeException("AppRuntime cannot cast to AppInterface")
        val businessHandler = app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)

        // void C(boolean forceRefresh, String groupId, String troopcode, int reqType); // RequestedTroopList/refreshMemberListFromServer
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

    private suspend fun requestGroupInfo(dataService: ITroopInfoService, uin: Long): Result<TroopInfo> {
        val strUin = uin.toString()
        val info = withTimeoutOrNull(1000) {
            var troopInfo: TroopInfo?
            do {
                troopInfo = dataService.getTroopInfo(strUin)
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
    suspend fun requestGroupRequest(
        msgSeq: Long,
        uin: Long,
        gid: Long,
        msg: String? = "",
        approve: Boolean? = true,
        notSee: Boolean? = false,
        subType: String
    ): Result<String>{
        val req = structmsg.ReqSystemMsgAction().apply {
            if (subType == "invite") {
                msg_type.set(1)
                src_id.set(3)
                sub_src_id.set(10016)
                group_msg_type.set(2)
            } else {
                msg_type.set(2)
                src_id.set(2)
                sub_src_id.set(30024)
                group_msg_type.set(1)
            }
            msg_seq.set(msgSeq)
            req_uin.set(uin)
            sub_type.set(1)
            action_info.set(structmsg.SystemMsgActionInfo().apply {
                type.set(if (approve != false) 11 else 12)
                group_code.set(gid)
                if (subType == "add") {
                    this.msg.set(msg)
                    this.blacklist.set(notSee != false)
                }
            })
            language.set(1000)
        }
        val respBuffer = sendBufferAW("ProfileService.Pb.ReqSystemMsgAction.Group", true, req.toByteArray())
            ?: return Result.failure(Exception("操作失败"))
        val rsp = structmsg.RspSystemMsgAction().mergeFrom(respBuffer.slice(4))
        return if (rsp.head.result.has()) {
            if (rsp.head.result.get() == 0) {
                Result.success(rsp.msg_detail.get())
            } else {
                Result.failure(Exception(rsp.head.msg_fail.get()))
            }
        } else {
            Result.failure(Exception("操作失败"))
        }
    }

    suspend fun requestGroupSystemMsgNew(msgNum: Int, reqMsgType: Int = 1, latestFriendSeq: Long = 0, latestGroupSeq: Long = 0, retryCnt: Int = 5): List<structmsg.StructMsg> {
        if (retryCnt < 0) {
            return ArrayList()
        }
        val req = structmsg.ReqSystemMsgNew()
        req.msg_num.set(msgNum)
        req.latest_friend_seq.set(latestFriendSeq)
        req.latest_group_seq.set(latestGroupSeq)
        req.version.set(1000)
        req.checktype.set(3)
        val flag = structmsg.FlagInfo()
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
        req.uint32_req_msg_type.set(reqMsgType)
        req.uint32_need_uid.set(1)
        val respBuffer = sendBufferAW("ProfileService.Pb.ReqSystemMsgNew.Group", true, req.toByteArray())
        return if (respBuffer == null) {
            ArrayList()
        } else {
            try {
                val msg = structmsg.RspSystemMsgNew()
                msg.mergeFrom(respBuffer.slice(4))
                return msg.groupmsgs.get().orEmpty()
            } catch (err: Throwable) {
                requestGroupSystemMsgNew(msgNum, reqMsgType, latestFriendSeq, latestGroupSeq, retryCnt - 1)
            }
        }
    }


    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getEssenceMessageList(groupId: Long, page: Int = 0, pageSize: Int = 20): Result<List<EssenceMessage>>{
//        GlobalClient.get()
        val cookie = TicketSvc.getCookie("qun.qq.com")
        val bkn = TicketSvc.getBkn(TicketSvc.getRealSkey(TicketSvc.getUin()))
        val url = "https://qun.qq.com/cgi-bin/group_digest/digest_list?bkn=${bkn}&group_code=${groupId}&page_start=${page}&page_limit=${pageSize}"
        val response = GlobalClient.get(url) {
            header("Cookie", cookie)
        }
        val body = Json.decodeFromStream<JsonElement>(response.body())
        if (body.jsonObject["retcode"].asInt == 0) {
            val data = body.jsonObject["data"].asJsonObject
            val list = data["msg_list"].asJsonArrayOrNull
                ?: // is_end
                return Result.success(ArrayList())
            return Result.success(list.map {
                val obj = it.jsonObject
                val msgSeq = obj["msg_seq"].asInt
                val msg = EssenceMessage(
                    senderId = obj["sender_uin"].asString.toLong(),
                    senderNick = obj["sender_nick"].asString,
                    senderTime = obj["sender_time"].asLong,
                    operatorId = obj["add_digest_uin"].asString.toLong(),
                    operatorNick = obj["add_digest_nick"].asString,
                    operatorTime = obj["add_digest_time"].asLong,
                    messageId = 0,
                    messageSeq = msgSeq,
                    messageContent = obj["msg_content"] ?: EmptyJsonArray
                )
                val mapping = MessageHelper.getMsgMappingBySeq(MsgConstant.KCHATTYPEGROUP, groupId.toString(), msgSeq)
                if (mapping != null) {
                    msg.messageId = mapping.msgHashId
                }
                msg
            })
        } else {
            return Result.failure(Exception(body.jsonObject["retmsg"].asStringOrNull))
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getGroupAnnouncements(groupId: Long): Result<List<GroupAnnouncement>>{
        val cookie = TicketSvc.getCookie("qun.qq.com")
        val bkn = TicketSvc.getBkn(TicketSvc.getRealSkey(TicketSvc.getUin()))
        val url = "https://web.qun.qq.com/cgi-bin/announce/get_t_list?bkn=${bkn}&qid=${groupId}&ft=23&s=-1&n=20"
        val response = GlobalClient.get(url) {
            header("Cookie", cookie)
        }
        val body = Json.decodeFromStream<JsonElement>(response.body())
        if (body.jsonObject["ec"].asInt == 0) {
            val list = body.jsonObject["feeds"].asJsonArrayOrNull
                ?: return Result.success(ArrayList())
            return Result.success(list.map {
                val obj = it.jsonObject
                GroupAnnouncement(
                    senderId = obj["u"].asLong,
                    publishTime = obj["pubt"].asLong,
                    message = GroupAnnouncementMessage(
//                        text = obj["msg"].asJsonObject["text"].asString,
                        text = fromHtml(obj["msg"].asJsonObject["text"].asString),
                        images = obj["msg"].asJsonObject["pics"].asJsonArrayOrNull?.map { pic ->
                            GroupAnnouncementMessageImage(
                                id = pic.jsonObject["id"].asString,
                                width = pic.jsonObject["w"].asString,
                                height = pic.jsonObject["h"].asString,
                            )
                        } ?: ArrayList()
                    )
                )
            })
        } else {
            return Result.failure(Exception(body.jsonObject["em"].asStringOrNull))
        }
    }

    private fun fromHtml(htmlString: String): String {
        return HtmlCompat
            // 特殊处理&#10;，目的是替换为换行符，否则会被fromHtml忽略并移除
            .fromHtml(htmlString.replace("&#10;", "[shamrockplaceholder]"), HtmlCompat.FROM_HTML_MODE_LEGACY)
            .toString()
            .replace("[shamrockplaceholder]", "\n")
    }

    @OptIn(ExperimentalSerializationApi::class)
    suspend fun uploadImageTroopNotice(image: String): Result<GroupAnnouncementMessageImage> {
        val file = FileUtils.parseAndSave(image)
        val cookie = TicketSvc.getCookie("qun.qq.com")
        val bkn = TicketSvc.getBkn(TicketSvc.getRealSkey(TicketSvc.getUin()))
        val response = GlobalClient.post("https://web.qun.qq.com/cgi-bin/announce/upload_img") {
            headers {
                header("Cookie", cookie)
            }
            contentType(ContentType.MultiPart.FormData)
            setBody(MultiPartFormDataContent(
                // 黑人问号 ktor默认formdata传的tx不认。默认是name=bkn，非要写成name="bkn"才认？
                formData {
                    append("filename", "001.png", Headers.build {
                        append(HttpHeaders.ContentDisposition, "name=\"filename\"")
                    })
                    append("source", "troopNotice", Headers.build {
                        append(HttpHeaders.ContentDisposition, "name=\"source\"")
                    })
                    append("bkn", bkn, Headers.build {
                        append(HttpHeaders.ContentDisposition, "name=\"bkn\"")
                    })
                    append("m", "0", Headers.build {
                        append(HttpHeaders.ContentDisposition, "name=\"m\"")
                    })
                    append("pic_up", file.readBytes(), Headers.build {
                        append(HttpHeaders.ContentType, "image/png")
                        append(HttpHeaders.ContentDisposition, "name=\"pic_up\" filename=\"001.png\"")

                    })
                }
            ))
        }
        val body = Json.decodeFromStream<JsonElement>(response.body())
        if (body.jsonObject["ec"].asInt == 0) {
            var idJsonStr = body.jsonObject["id"].asStringOrNull
            return if (idJsonStr != null) {
                idJsonStr = idJsonStr.replace("&quot;", "\"")
                val idJson = Json.decodeFromString<JsonElement>(idJsonStr)
                LogCenter.log(idJson.toString())
                Result.success(GroupAnnouncementMessageImage(
                    height = idJson.asJsonObject["h"].asString,
                    width = idJson.asJsonObject["w"].asString,
                    id = idJson.asJsonObject["id"].asString,
                ))
            } else {
                Result.failure(Exception("图片上传失败"))
            }
        } else {
            return Result.failure(Exception(body.jsonObject["em"].asStringOrNull))
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    suspend fun addQunNotice(groupId: Long, text: String, image: GroupAnnouncementMessageImage?) : Result<Boolean> {
        val cookie = TicketSvc.getCookie("qun.qq.com")
        val bkn = TicketSvc.getBkn(TicketSvc.getRealSkey(TicketSvc.getUin()))
        val response = GlobalClient.submitForm(
            url = "https://web.qun.qq.com/cgi-bin/announce/add_qun_notice",
            formParameters = parameters {
                append("qid", groupId.toString())
                append("bkn", bkn)
                append("text", text)
                append("pinned", "0")
                append("type", "1")
                // todo allow custom settings
                append("settings", "{\"is_show_edit_card:\"1,\"tip_window_type\":1,\"confirm_required\":1}")
                if (null != image) {
                    append("pic", image.id)
                    append("imgWidth", image.width)
                    append("imgHeight", image.height)
                }
            },
            block = {
                headers {
                    header("Cookie", cookie)
                }
            }
        )
        val body = Json.decodeFromStream<JsonElement>(response.body())
        return if (body.jsonObject["ec"].asInt == 0) {
            Result.success(true)
        } else {
            Result.failure(Exception(body.jsonObject["em"].asStringOrNull))
        }
    }

    suspend fun groupSign(groupId: Long): Result<String> {
        val req = oidb_0xeb7.ReqBody()
        val signInWriteReq = oidb_0xeb7.StSignInWriteReq()
        signInWriteReq.groupId.set(groupId.toString())
        signInWriteReq.uid.set(getUin())
        var version = PlatformUtils.getClientVersion(MobileQQ.getContext())
        version = version.replace("android", "").trimStart()
        signInWriteReq.clientVersion.set(version)
        req.signInWriteReq.set(signInWriteReq)
        val buffer = sendOidbAW("OidbSvc.0xeb7", 3767, 1, req.toByteArray())
        return if (buffer == null) {
            Result.failure(Exception("操作失败"))
        } else {
            val body = oidb_sso.OIDBSSOPkg()
            body.mergeFrom(buffer.slice(4))
            val rsp = oidb_0xeb7.RspBody()
            rsp.mergeFrom(body.bytes_bodybuffer.get().toByteArray())
            val doneInfo = rsp.signInWriteRsp.doneInfo
            LogCenter.log(rsp.toString(), Level.DEBUG)
            Result.success("${doneInfo.leftTitleWrod.get()} ${doneInfo.rightDescWord.get()} ${doneInfo.belowPortraitWords.get().joinToString(" ")}")
        }
    }
}