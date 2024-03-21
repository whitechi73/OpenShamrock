package qq.service.lightapp

import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import qq.service.QQInterfaces
import qq.service.contact.longPeer
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77

internal object ArkMsgHelper: QQInterfaces() {
    suspend fun tryShareMusic(
        contact: Contact,
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
        req.recv_uin.set(contact.longPeer())
        req.rich_msg_body.set(oidb_cmd0xb77.RichMsgBody().also {
            it.title.set(title)
            it.summary.set(singer)
            it.url.set(jumpUrl)
            it.picture_url.set(previewUrl)
            it.music_url.set(musicUrl)
        })
        when (contact.chatType) {
            MsgConstant.KCHATTYPEGROUP -> req.send_type.set(1)
            MsgConstant.KCHATTYPEC2C -> req.send_type.set(0)
            else -> error("不支持该聊天类型发送音乐分享: chatType: ${contact.chatType}")
        }
        sendOidb("OidbSvc.0xb77_9", 0xb77, 9, req.toByteArray())
    }
}