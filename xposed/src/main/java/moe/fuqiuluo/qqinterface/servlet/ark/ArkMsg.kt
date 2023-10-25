package moe.fuqiuluo.qqinterface.servlet.ark

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.qqinterface.servlet.BaseSvc
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77

sealed class ArkAppInfo(
    val appId: Long,
    val version: String,
    val packageName: String,
    val signature: String
) {
    object QQMusic: ArkAppInfo(100497308, "0.0.0", "com.tencent.qqmusic", "cbd27cd7c861227d013a25b2d10f0799")
    object NeteaseMusic: ArkAppInfo(100495085, "0.0.0", "com.netease.cloudmusic", "da6b069da1e2982db3e386233f68d76d")
}

internal object ArkMsgSvc: BaseSvc() {
    fun tryShareMusic(
        chatType: Int,
        peerId: Long,
        msgId: Long,
        arkAppInfo: ArkAppInfo,
        title: String,
        singer: String,
        jumpUrl: String,
        previewUrl: String,
        musicUrl: String,
    ) {
        val req = oidb_cmd0xb77.ReqBody()
        req.appid.set(arkAppInfo.appId)
        req.app_type.set(1)
        req.msg_style.set(4)
        req.client_info.set(oidb_cmd0xb77.ClientInfo().also {
            it.platform.set(1)
            it.sdk_version.set(arkAppInfo.version)
            it.android_package_name.set(arkAppInfo.packageName)
            it.android_signature.set(arkAppInfo.signature)
        })
        req.ext_info.set(oidb_cmd0xb77.ExtInfo().also {
            it.msg_seq.set(msgId)
        })
        req.recv_uin.set(peerId)
        req.rich_msg_body.set(oidb_cmd0xb77.RichMsgBody().also {
            it.title.set(title)
            it.summary.set(singer)
            it.url.set(jumpUrl)
            it.picture_url.set(previewUrl)
            it.music_url.set(musicUrl)
        })
        when (chatType) {
            MsgConstant.KCHATTYPEGROUP -> req.send_type.set(1)
            MsgConstant.KCHATTYPEC2C -> req.send_type.set(0)
            else -> error("不支持该聊天类型发送音乐分享")
        }
        sendOidb("OidbSvc.0xb77_9", 0xb77, 9, req.toByteArray())
    }
}