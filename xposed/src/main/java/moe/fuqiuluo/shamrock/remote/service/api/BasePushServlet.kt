package moe.fuqiuluo.shamrock.remote.service.api

import com.tencent.mobileqq.app.QQAppInterface
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import moe.fuqiuluo.shamrock.remote.service.data.push.NoticeSubType
import moe.fuqiuluo.shamrock.remote.service.data.push.NoticeType
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.app.MobileQQ
import oicq.wlogin_sdk.tools.MD5

internal interface BasePushServlet {
    val address: String

    fun allowPush(): Boolean

    fun pushSelfPrivateSentMsg(
        record: MsgRecord,
        elements: List<MsgElement>,
        raw: String,
        msgHash: Int
    )

    fun pushSelfGroupSentMsg(
        record: MsgRecord,
        elements: List<MsgElement>,
        raw: String,
        msgHash: Int
    )

    fun pushPrivateMsg(
        record: MsgRecord,
        elements: List<MsgElement>,
        raw: String,
        msgHash: Int
    )

    fun pushGroupMsg(
        record: MsgRecord,
        elements: List<MsgElement>,
        raw: String,
        msgHash: Int
    )

    fun pushGroupPoke(time: Long, operation: Long, userId: Long, groupId: Long)

    //fun pushPrivatePoke(time: Long, operation: Long, userId: Long, sender: Long)

    fun pushPrivateMsgRecall(time: Long, operation: Long, msgHash: Int, tip: String)

    fun pushGroupMsgRecall(
        time: Long,
        operation: Long,
        userId: Long,
        groupId: Long,
        msgHash: Int,
        tip: String
    )

    fun pushGroupBan(
        time: Long,
        operation: Long,
        userId: Long,
        groupId: Long,
        duration: Int
    )

    fun pushGroupMemberDecreased(
        time: Long,
        target: Long,
        groupId: Long,
        operation: Long = 0,
        type: NoticeType,
        subType: NoticeSubType
    )

    fun pushGroupAdminChange(time: Long, target: Long, groupId: Long, setAdmin: Boolean)

    fun pushGroupFileCome(
        time: Long,
        userId: Long,
        groupId: Long,
        fileId: String,
        fileName: String,
        fileSize: Long,
        bizId: Int,
        url: String
    )

    fun pushC2CPoke(time: Long, userId: Long, targetId: Long)

    fun pushC2CFileCome(
        msgTime: Long,
        sender: Long,
        fileId: String,
        fileSubId: String,
        fileName: String,
        fileSize: Long,
        expireTime: Long,
        url: String
    )

    val app: QQAppInterface
        get() = AppRuntimeFetcher.appRuntime as QQAppInterface

    val id: String
        get() = MD5.getMD5String(address.toByteArray())
}