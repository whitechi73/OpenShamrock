@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("IllegalIdentifier")
package moe.fuqiuluo.qqinterface.servlet

import com.tencent.common.app.AppInterface
import com.tencent.mobileqq.data.Friends
import com.tencent.mobileqq.friend.api.IFriendDataService
import com.tencent.mobileqq.friend.api.IFriendHandlerService
import com.tencent.mobileqq.qroute.QRoute
import com.tencent.mobileqq.relation.api.IAddFriendTempApi
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.app.AppRuntime
import tencent.mobileim.structmsg.`structmsg$FlagInfo`
import tencent.mobileim.structmsg.`structmsg$ReqSystemMsgNew`
import tencent.mobileim.structmsg.`structmsg$RspSystemMsgNew`
import kotlin.coroutines.resume
import tencent.mobileim.structmsg.`structmsg$SystemMsgActionInfo` as ActionInfo
import tencent.mobileim.structmsg.`structmsg$AddFrdSNInfo` as AddFrdSNInfo
import tencent.mobileim.structmsg.`structmsg$StructMsg` as StructMsg

internal object FriendSvc: BaseSvc() {

    suspend fun getFriendList(refresh: Boolean): Result<List<Friends>> {
        val runtime = AppRuntimeFetcher.appRuntime
        val service = runtime.getRuntimeService(IFriendDataService::class.java, "all")
        if(refresh || !service.isInitFinished) {
            if(!requestFriendList(runtime, service)) {
                return Result.failure(Exception("获取好友列表失败"))
            }
        }
        return Result.success(service.allFriends)
    }

    // ProfileService.Pb.ReqSystemMsgAction.Friend
    fun requestFriendRequest(msgSeq: Long, uin: Long, remark: String = "", approve: Boolean? = true, notSee: Boolean? = false) {
        val app = AppRuntimeFetcher.appRuntime
        if (app !is AppInterface)
            throw RuntimeException("AppRuntime cannot cast to AppInterface")
        val service = QRoute.api(IAddFriendTempApi::class.java)
        val action = ActionInfo()
        action.type.set(if (approve != false) 2 else 3)
        action.group_id.set(0)
        action.remark.set(remark)
        val snInfo = AddFrdSNInfo()
        snInfo.uint32_not_see_dynamic.set(if (notSee != false) 1 else 0)
        snInfo.uint32_set_sn.set(0)
        action.addFrdSNInfo.set(snInfo)
        service.sendFriendSystemMsgAction(1, msgSeq, uin, 1, 2004, 11, 0, action, 0, StructMsg(), false,
            app
        )
    }

    suspend fun requestFriendSystemMsgNew(msgNum: Int, latestFriendSeq: Long = 0, latestGroupSeq: Long = 0, retryCnt: Int = 3): List<StructMsg>? {
        if (retryCnt < 0) {
            return ArrayList()
        }
        val req = `structmsg$ReqSystemMsgNew`()
        req.msg_num.set(msgNum)
        req.latest_friend_seq.set(latestFriendSeq)
        req.latest_group_seq.set(latestGroupSeq)
        req.version.set(1000)
        req.checktype.set(2)
        val flag = `structmsg$FlagInfo`()
//        flag.GrpMsg_Kick_Admin.set(1)
//        flag.GrpMsg_HiddenGrp.set(1)
//        flag.GrpMsg_WordingDown.set(1)
        flag.FrdMsg_GetBusiCard.set(1)
//        flag.GrpMsg_GetOfficialAccount.set(1)
//        flag.GrpMsg_GetPayInGroup.set(1)
        flag.FrdMsg_Discuss2ManyChat.set(1)
//        flag.GrpMsg_NotAllowJoinGrp_InviteNotFrd.set(1)
        flag.FrdMsg_NeedWaitingMsg.set(1)
        flag.FrdMsg_uint32_need_all_unread_msg.set(1)
//        flag.GrpMsg_NeedAutoAdminWording.set(1)
//        flag.GrpMsg_get_transfer_group_msg_flag.set(1)
//        flag.GrpMsg_get_quit_pay_group_msg_flag.set(1)
//        flag.GrpMsg_support_invite_auto_join.set(1)
//        flag.GrpMsg_mask_invite_auto_join.set(1)
//        flag.GrpMsg_GetDisbandedByAdmin.set(1)
        flag.GrpMsg_GetC2cInviteJoinGroup.set(1)
        req.flag.set(flag)
        req.is_get_frd_ribbon.set(false)
        req.is_get_grp_ribbon.set(false)
        req.friend_msg_type_flag.set(1)
        req.uint32_req_msg_type.set(1)
        req.uint32_need_uid.set(1)
        val respBuffer = sendBufferAW("ProfileService.Pb.ReqSystemMsgNew.Friend", true, req.toByteArray())
        return if (respBuffer == null) {
            ArrayList()
        } else {
            try {
                val msg = `structmsg$RspSystemMsgNew`()
                msg.mergeFrom(respBuffer.slice(4))
                return msg.friendmsgs.get()
            } catch (err: Throwable) {
                requestFriendSystemMsgNew(msgNum, latestFriendSeq, latestGroupSeq, retryCnt - 1)
            }

        }
    }


    private suspend fun requestFriendList(runtime: AppRuntime, dataService: IFriendDataService): Boolean {
        val service = runtime.getRuntimeService(IFriendHandlerService::class.java, "all")
        service.requestFriendList(true, 0)
        return suspendCancellableCoroutine { continuation ->
            val waiter = GlobalScope.launch {
                while (!dataService.isInitFinished) {
                    delay(200)
                }
                continuation.resume(true)
            }
            continuation.invokeOnCancellation {
                waiter.cancel()
                continuation.resume(false)
            }
        }
    }
}