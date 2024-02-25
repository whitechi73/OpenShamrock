package moe.fuqiuluo.qqinterface.servlet.ark

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.qqinterface.servlet.BaseSvc
import moe.fuqiuluo.qqinterface.servlet.ark.data.ArkAppInfo
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77

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

    /*
    suspend fun tryShareJsonMessage(
        jsonString: String,
        arkAppInfo: ArkAppInfo = ArkAppInfo.DanMaKu,
    ): Result<String> {
        val msgSeq = MessageHelper.generateMsgId(MsgConstant.KCHATTYPEC2C).qqMsgId
        val req = oidb_cmd0xb77.ReqBody()
        req.appid.set(arkAppInfo.appId)
        req.app_type.set(1)
        req.msg_style.set(10)
        req.client_info.set(oidb_cmd0xb77.ClientInfo().also {
            it.platform.set(1)
            it.sdk_version.set(arkAppInfo.version)
            it.android_package_name.set(arkAppInfo.packageName)
            it.android_signature.set(arkAppInfo.signature)
        })
        req.ext_info.set(oidb_cmd0xb77.ExtInfo().also {
            it.tag_name.set(ByteStringMicro.copyFromUtf8("shamrock"))
            it.msg_seq.set(msgSeq)
        })
        req.send_type.set(0)
        req.recv_uin.set(TicketSvc.getLongUin())
        req.mini_app_msg_body.set(oidb_cmd0xb77.MiniAppMsgBody().also {
            it.mini_app_appid.set(arkAppInfo.miniAppId)
            it.mini_app_path.set("pages")
            it.web_page_url.set("https://im.qq.com/index/")
            it.title.set("title")
            it.desc.set("desc")
            it.json_str.set(jsonString)
        })
        sendOidb("OidbSvc.0xb77_9", 0xb77, 9, req.toByteArray())
        val signedJson: String = withTimeoutOrNull(5.seconds) {
            suspendCancellableCoroutine {
                AioListener.registerTemporaryMsgListener(msgSeq) {
                    it.resume(elements.first {
                        it.elementType == MsgConstant.KELEMTYPEARKSTRUCT
                    }.arkElement.bytesData)
                }
                it.invokeOnCancellation {
                    AioListener.unregisterTemporaryMsgListener(msgSeq)
                }
            }
        } ?: return Result.failure(Exception("unable to sign json"))
        return Result.success(signedJson)
    }*/
}