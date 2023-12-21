package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.app.QQAppInterface
import com.tencent.mobileqq.transfile.HttpNetReq
import com.tencent.mobileqq.transfile.INetEngineListener
import com.tencent.mobileqq.transfile.NetReq
import com.tencent.mobileqq.transfile.NetResp
import com.tencent.mobileqq.transfile.ServerAddr
import com.tencent.mobileqq.transfile.api.IHttpEngineService
import kotlinx.coroutines.suspendCancellableCoroutine
import moe.fuqiuluo.proto.protobufMapOf
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.EMPTY_BYTE_ARRAY
import moe.fuqiuluo.shamrock.tools.toInnerValuesString
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.manager.TicketManager
import oicq.wlogin_sdk.request.Ticket
import oicq.wlogin_sdk.request.WtTicketPromise
import oicq.wlogin_sdk.tools.ErrMsg
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import kotlin.coroutines.resume


/**
 * QQ收藏相关接口
 */
internal object QFavSvc: BaseSvc() {
    private val SERVER_LIST = listOf(ServerAddr().also {
        it.isIpv6 = false
        it.mIp = "collector.weiyun.com"
        it.port = 80
    })
    private const val VT = 27
    private const val VERSION = 12820
    private const val APPID = 30244
    private const val SUB_APPID = 538116905
    private const val MAJOR_VERSION = 8
    private const val MINOR_VERSION = 9
    private var seq = 1

    suspend fun addRichMediaMsg(
        uin: Long,
        name: String,
        groupId: Long = 0,
        groupName: String = "",
        time: Long = System.currentTimeMillis(),
        content: String
    ): Result<NetResp> {
        val data = protobufMapOf {
            it[1] = mapOf(
                20009 to mapOf(
                    1 to mapOf(
                        /**
                         * 1 => bid
                         * 2 => category
                         * 3 => author
                         * 4 => create_time
                         * 5 => sequence
                         * 6 => biz_key
                         * 7 => biz_data_list
                         * 8 => share_url
                         * 9 => original_app_id
                         * 10 => custom_group_id
                         * 506 => modify_time
                         * 507 => qzone_ugc_key
                         */
                        1 to 1, // bid
                        2 to 1, // category
                        3 to mapOf( // author
                            1 to if (groupId == 0L) 1 else 2, // type
                            2 to uin, // num_id
                            3 to name, // str_id
                            4 to groupId, // group_id
                            5 to groupName // group_name
                        ),
                        4 to time - 2000, // create_time
                        5 to time - 1000, // sequence
                        9 to 0, // original_app_id
                        10 to 0 // custom_group_id
                    ),
                    2 to mapOf(
                        /**
                         * 1 => title
                         * 2 => sub_title
                         * 3 => brief
                         * 4 => pic_list
                         * 5 => content_type
                         * 6 => original_uri
                         * 7 => publisher
                         * 8 => rich_media_version
                         */
                        3 to content,
                        5 to 1
                    ),
                    3 to mapOf(
                        /**
                         * 1 => rich_media
                         * 2 => raw_data
                         * 3 => biz_data_list
                         * 4 => pic_list
                         * 5 => file_list
                         */
                        2 to content
                    )
                )
            )
        }.toByteArray()
        return sendWeiyunReq(20009, data)
    }

    suspend fun sendWeiyunReq(cmd: Int, body: ByteArray): Result<NetResp> {
        return suspendCancellableCoroutine {
            val httpNetReq = HttpNetReq()
            httpNetReq.userData = null
            httpNetReq.mCallback = object: INetEngineListener {
                override fun onResp(netResp: NetResp) {
                    if (netResp.mHttpCode != 200 && netResp.mResult != 0 && netResp.mErrDesc.isNullOrEmpty()) {
                        netResp.mErrDesc = netResp.mRespProperties["User-ErrMsg"]
                    }
                    it.resume(Result.success(netResp))
                }

                override fun onUpdateProgeress(netReq: NetReq, curr: Long, final: Long) {}
            }
            val pSKey = getWeiYunPSKey()
            LogCenter.log(pSKey)
            httpNetReq.mHttpMethod = HttpNetReq.HTTP_POST
            httpNetReq.mSendData = DeflateTools.gzip(packData(packHead(cmd, pSKey), body))
            httpNetReq.mOutStream = ByteArrayOutputStream()
            httpNetReq.mStartDownOffset = 0L
            httpNetReq.mReqProperties["Shamrock"] = "true"
            httpNetReq.mReqProperties["Cookie"] = String.format("uin=%s;vt=%d;vi=%s;appid=%d", app.currentAccountUin, VT, pSKey, APPID)
            httpNetReq.mReqProperties["host"] = "collector.weiyun.com"
            httpNetReq.mReqProperties["Range"] = "bytes=0-"
            httpNetReq.mReqProperties["Content-Length"] = httpNetReq.mSendData.size.toString()
            httpNetReq.mReqProperties["Accept-Encoding"] = "gzip"
            httpNetReq.mReqProperties["Content-Encoding"] = "gzip"
            httpNetReq.mPrioty = 1
            httpNetReq.mReqUrl = "https://collector.weiyun.com/collector.fcg"
            httpNetReq.mServerList = SERVER_LIST
            val service = AppRuntimeFetcher.appRuntime
                .getRuntimeService(IHttpEngineService::class.java, "qqfav")
            service.sendReq(httpNetReq)
        }
    }

    private fun packHead(cmd: Int, pskey: String): ByteArray {
        /**
         * 1 => uin
         * 2 => seq
         * 3 => type
         * 4 => cmd
         * 5 => appid
         * 6 => version
         * 7 => nettype
         * 8 => clientip
         * 9 => encrypt
         * 10 => keytype
         * 11 => encryptkey
         * 14 => major_version
         * 15 => minor_version
         * 101 => retcode
         * 102 => retmsg
         * 103 => promptmsg
         * 111 => total_space
         * 112 => used_space
         */
        return protobufMapOf {
            it[1] = app.longAccountUin
            it[2] = seq++ // seq
            it[3] = 1 // type
            it[4] = cmd
            it[5] = APPID
            it[6] = VERSION // VERSION
            it[7] = 3 // nettype
            it[10] = 27 // keytype
            it[11] = pskey
            it[14] = MAJOR_VERSION
            it[15] = MINOR_VERSION
        }.toByteArray()
    }

    private fun packData(head: ByteArray, body: ByteArray): ByteArray {
        val len = 16 + head.size + body.size
        val buf = ByteBuffer.allocate(len)
        buf.putInt(SUB_APPID)
        buf.putShort(1)
        buf.putInt(len)
        buf.putInt(body.size)
        buf.putShort(0)
        buf.put(head)
        buf.put(body)
        return buf.array()
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