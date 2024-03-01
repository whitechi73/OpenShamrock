package moe.fuqiuluo.qqinterface.servlet.ark

import moe.fuqiuluo.qqinterface.servlet.BaseSvc
import moe.fuqiuluo.qqinterface.servlet.ark.data.ArkAppInfo
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.symbols.decodeProtobuf
import protobuf.auto.toByteArray
import protobuf.lightapp.AdaptShareInfoReq
import protobuf.lightapp.AdaptShareInfoResp
import protobuf.qweb.DEFAULT_DEVICE_INFO
import protobuf.qweb.QWebReq
import protobuf.qweb.QWebRsp

internal object LightAppSvc: BaseSvc() {
    suspend fun adaptShareJumpUrl(
        arkAppInfo: ArkAppInfo,
        coverUrl: String,
        desc: String,
        url: String
    ): Result<String> {
        val rsp = sendBufferAW("LightAppSvc.mini_app_share.AdaptShareInfo", true, QWebReq(
            seq = 10,
            qua = PlatformUtils.getQUA(),
            deviceInfo = DEFAULT_DEVICE_INFO,
            buffer = AdaptShareInfoReq(
                appid = arkAppInfo.miniAppId.toString(),
                title = arkAppInfo.appName,
                desc = desc,
                time = (System.currentTimeMillis() * 0.001).toULong(),
                scene = 3u,
                templetType = 1u,
                businessType = 0u,
                picUrl = coverUrl,
                jumpUrl = "pages",
                verType = 3u,
                withShareTicket = 0u,
                webURL = url,
            ).toByteArray(),
            traceId = app.account + "_0_0",
        ).toByteArray())?.decodeProtobuf<QWebRsp>()?.buffer?.decodeProtobuf<AdaptShareInfoResp>()
        if (rsp == null || rsp.json.isNullOrEmpty())
            return Result.failure(Exception("unable to adapt ShareInfo"))
        return Result.success(rsp.json!!)
    }
}