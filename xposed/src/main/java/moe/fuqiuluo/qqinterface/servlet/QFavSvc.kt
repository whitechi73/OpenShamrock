package moe.fuqiuluo.qqinterface.servlet

import android.text.TextUtils
import com.tencent.mobileqq.app.QQAppInterface
import com.tencent.mobileqq.transfile.HttpNetReq
import com.tencent.mobileqq.transfile.INetEngineListener
import com.tencent.mobileqq.transfile.NetReq
import com.tencent.mobileqq.transfile.NetResp
import com.tencent.mobileqq.transfile.ServerAddr
import com.tencent.mobileqq.transfile.api.IHttpEngineService
import io.netty.buffer.ByteBuf
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.manager.TicketManager
import oicq.wlogin_sdk.request.Ticket
import oicq.wlogin_sdk.request.WtTicketPromise
import oicq.wlogin_sdk.tools.ErrMsg
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer


/**
 * QQ收藏相关接口
 */
internal object QFavSvc: BaseSvc() {
    private const val VI = 27
    private const val APPID = 30244
    private const val SUB_APPID = 538116905

    fun sendWeiyunReq() {
        val httpNetReq = HttpNetReq()
        httpNetReq.userData = null
        (httpNetReq as NetReq).mCallback = object: INetEngineListener {
            override fun onResp(netResp: NetResp) {

            }

            override fun onUpdateProgeress(netReq: NetReq, j2: Long, j3: Long) {

            }
        }
        val pSKey = getWeiYunPSKey()
        httpNetReq.mHttpMethod = 1
        httpNetReq.mSendData = byteArrayOf()
        val byteArrayOutputStream = ByteArrayOutputStream()
        httpNetReq.mOutStream = byteArrayOutputStream
        httpNetReq.mStartDownOffset = 0L
        httpNetReq.mReqProperties["Cookie"] = String.format("uin=%s;vt=%d;vi=%s;appid=%d", app.longAccountUin, VI, APPID,)
        httpNetReq.mReqProperties["host"] = "collector.weiyun.com"
        httpNetReq.mReqProperties["Range"] = "bytes=" + httpNetReq.mStartDownOffset + "-"
        httpNetReq.mReqProperties["Accept-Encoding"] = "gzip"
        httpNetReq.mReqProperties["Content-Encoding"] = "gzip"
        httpNetReq.mPrioty = 1
        val service = AppRuntimeFetcher.appRuntime
            .getRuntimeService(IHttpEngineService::class.java, "qqfav")
        httpNetReq.mReqUrl = "https://collector.weiyun.com"
        httpNetReq.mServerList = emptyList()
        service.sendReq(httpNetReq)
    }

    private fun packData(head: ByteArray, body: ByteArray): ByteArray {
        val buf = ByteBuffer.allocateDirect(100)
        buf.putInt(SUB_APPID)
        buf.putShort(1)
        buf.putInt(16 + head.size + body.size)
        buf.putInt(body.size)
        buf.putShort(0)
        buf.put(head)
        buf.put(body)
        val ret = buf.array()
        buf.clear()
        return ret
    }

    private fun getWeiYunPSKey(): String {
        val pskey = (app.getManager(QQAppInterface.TICKET_MANAGER) as TicketManager)
            .getPskey(app.currentAccountUin, 16L, arrayOf("weiyun.com"), WeiYunPSKeyPromise)
        return if (pskey != null) pskey.getPSkey("weiyun.com") else ""
    }

    private object WeiYunPSKeyPromise: WtTicketPromise {
        override fun Done(ticket: Ticket) {
            LogCenter.log("Fav: getPskeyPromise: done", Level.DEBUG)
        }

        override fun Failed(errMsg: ErrMsg) {
            LogCenter.log("Fav: getPskeyPromise: failed, $errMsg", Level.DEBUG)
        }

        override fun Timeout(errMsg: ErrMsg) {
            LogCenter.log("Fav: getPskeyPromise: timeout, $errMsg", Level.DEBUG)
        }
    }
}