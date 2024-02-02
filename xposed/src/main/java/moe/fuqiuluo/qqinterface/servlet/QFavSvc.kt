@file:OptIn(ExperimentalSerializationApi::class)

package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.app.QQAppInterface
import com.tencent.mobileqq.transfile.HttpNetReq
import com.tencent.mobileqq.transfile.INetEngineListener
import com.tencent.mobileqq.transfile.NetReq
import com.tencent.mobileqq.transfile.NetResp
import com.tencent.mobileqq.transfile.ServerAddr
import com.tencent.mobileqq.transfile.api.IHttpEngineService
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.io.core.BytePacketBuilder
import kotlinx.io.core.readBytes
import kotlinx.io.core.writeFully
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.hex2ByteArray
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.shamrock.utils.MD5
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import protobuf.fav.WeiyunAddRichMediaReq
import protobuf.fav.WeiyunAuthor
import protobuf.fav.WeiyunCollectCommInfo
import protobuf.fav.WeiyunComm
import protobuf.fav.WeiyunCommonReq
import protobuf.fav.WeiyunFastUploadResourceReq
import protobuf.fav.WeiyunGetFavContentReq
import protobuf.fav.WeiyunGetFavListReq
import protobuf.fav.WeiyunMsgHead
import protobuf.fav.WeiyunPicInfo
import protobuf.fav.WeiyunRichMediaContent
import protobuf.fav.WeiyunRichMediaSummary
import mqq.manager.TicketManager
import oicq.wlogin_sdk.request.Ticket
import oicq.wlogin_sdk.request.WtTicketPromise
import oicq.wlogin_sdk.tools.ErrMsg
import java.io.ByteArrayOutputStream
import java.io.File
import java.nio.ByteBuffer
import kotlin.coroutines.resume


/**
 * QQ收藏相关接口
 */
internal object QFavSvc: BaseSvc() {
    private val SERVER_LIST_COLLECTOR = listOf(ServerAddr().also {
        it.isIpv6 = false
        it.mIp = "collector.weiyun.com"
        it.port = 80
    })
    private val SERVER_LIST_PICUP = listOf(ServerAddr().also {
        it.isIpv6 = false
        it.mIp = "pic.pieceup.qq.com"
        it.port = 80
    })
    private const val VERSION = 12820
    private const val APPID = 30244
    private const val SUB_APPID = 538116905
    private const val MAJOR_VERSION = 8
    private const val MINOR_VERSION = 9
    private var seq = 1

    suspend fun getItemList(
        category: Int,
        startPos: Int,
        pageSize: Int,
    ): Result<NetResp> {
        val baseReq = WeiyunCommonReq(
            getFavListReq = WeiyunGetFavListReq(
                type = 0u,
                bid = 0u,
                category = category.toUInt(),
                startTime = 0u,
                orderType = 0u,
                startPos = startPos.toUInt(),
                pageSize = pageSize.toUInt(),
                syncPolicy = 0u,
                reqSource = 0u
            )
        )
        return sendWeiyunReq(20000, baseReq)
    }

    suspend fun getItemContent(
        id: String
    ): Result<NetResp> {
        return sendWeiyunReq(20001, WeiyunCommonReq(
            getFavContentReq = WeiyunGetFavContentReq(
                cidList = arrayListOf(id)
            )
        )
        )
    }

    suspend fun addImageMsg(
        uin: Long,
        name: String,
        groupId: Long = 0,
        groupName: String = "",
        picUrl: String,
        pid: String,
        width: Int, height: Int,
        size: Long,
        md5: String,
    ): Result<NetResp> {
        val md5Bytes = md5.hex2ByteArray()
        return sendWeiyunReq(20009, WeiyunCommonReq(
            addRichMediaReq = WeiyunAddRichMediaReq(
                commInfo = WeiyunCollectCommInfo(
                    bid = 1u,
                    category = 1u,
                    author = WeiyunAuthor(
                        type = if (groupId == 0L) 1u else 2u,
                        numId = uin.toULong(),
                        strId = name,
                        groupId = groupId.toULong(),
                        groupName = groupName
                    ),
                    createTime = System.currentTimeMillis().toULong() - 2000u,
                    seq = System.currentTimeMillis().toULong() - 1000u,
                    bizDataList = arrayListOf("""{"recordAudioOnly":false,"audioOnly":false,"fileOnly":false}""".toByteArray()),
                    originalAppId = 0u,
                    customGroupId = 0u
                ),
                summary = WeiyunRichMediaSummary(
                    title = "",
                    brief = "[图片]",
                    picList = arrayListOf(
                        WeiyunPicInfo(
                            uri = picUrl,
                            md5 = md5Bytes,
                            sha1 = md5.toByteArray(),
                            name = "",
                            note = "",
                            width = width.toUInt(),
                            height = height.toUInt(),
                            size = size.toULong(),
                            type = 0u,
                            picId = pid
                        )
                    ),
                    contentType = 1u
                ),
                richMediaContent = listOf(
                    WeiyunRichMediaContent(
                    rawData = """<img src="$picUrl" />""".toByteArray(),
                    picList = listOf(
                        WeiyunPicInfo(
                        uri = picUrl,
                        md5 = md5Bytes,
                        sha1 = md5.toByteArray(),
                        name = "",
                        note = "",
                        width = width.toUInt(),
                        height = height.toUInt(),
                        size = size.toULong(),
                        type = 0u,
                        picId = pid
                    )
                    )
                )
                )
            )
        )
        )
    }

    suspend fun applyUpImageMsg(
        uin: Long,
        name: String,
        groupId: Long = 0,
        groupName: String = "",
        width: Int, height: Int,
        image: File
    ): Result<NetResp> {
        if (!image.exists()) {
            return Result.failure(IllegalArgumentException("image file not exists"))
        }
        val md5 = MD5.genFileMd5(image.absolutePath)
        return sendWeiyunReq(20010, WeiyunCommonReq(
            fastUploadResourceReq = WeiyunFastUploadResourceReq(
                picInfoList = listOf(
                    WeiyunPicInfo(
                    md5 = md5,
                    name = md5.toHexString(),
                    width = width.toUInt(),
                    height = height.toUInt(),
                    size = image.length().toULong(),
                    type = 1u,
                    picId = "/storage/emulated/0/DCIM/temp.jpeg",
                    owner = WeiyunAuthor(
                        type = if (groupId == 0L) 1u else 2u,
                        numId = uin.toULong(),
                        strId = name,
                        groupId = groupId.toULong(),
                        groupName = groupName
                    )
                )
                ),
            )
        )
        )
    }

    suspend fun addRichMediaMsg(
        uin: Long,
        name: String,
        groupId: Long = 0,
        groupName: String = "",
        time: Long = System.currentTimeMillis(),
        content: String
    ): Result<NetResp> {
        return sendWeiyunReq(20009, WeiyunCommonReq(
            addRichMediaReq = WeiyunAddRichMediaReq(
                commInfo = WeiyunCollectCommInfo(
                    bid = 1u,
                    category = 1u,
                    author = WeiyunAuthor(
                        type = if (groupId == 0L) 1u else 2u,
                        numId = uin.toULong(),
                        strId = name,
                        groupId = groupId.toULong(),
                        groupName = groupName
                    ),
                    createTime = time.toULong() - 2000u,
                    seq = time.toULong() - 1000u,
                    originalAppId = 0u,
                    customGroupId = 0u
                ),
                summary = WeiyunRichMediaSummary(
                    brief = content,
                    contentType = 1u
                ),
                richMediaContent = listOf(
                    WeiyunRichMediaContent(
                    rawData = content.textToHtml().toByteArray(),
                )
                )
            )
        )
        )
    }

    private fun String.textToHtml(): String {
        return replace("\n", "<div><br/></div>")
    }

    suspend fun sendPicUpBlock(
        fileSize: Long,
        offset: Long,
        block: ByteArray,
        blockSize: Long,
        sha: ByteArray,
        pid: String,
        outputStream: ByteArrayOutputStream = ByteArrayOutputStream(),
    ): Result<NetResp> {
        return suspendCancellableCoroutine {
            val httpNetReq = HttpNetReq()
            httpNetReq.userData = null
            httpNetReq.mCallback = object: INetEngineListener {
                override fun onResp(netResp: NetResp) {
                    if (netResp.mHttpCode != 200 && netResp.mResult != 0 && netResp.mErrDesc.isNullOrEmpty()) {
                        netResp.mErrDesc = netResp.mRespProperties["User-ErrMsg"]
                    }
                    netResp.mRespData = outputStream.toByteArray().copyOf()
                    it.resume(Result.success(netResp))
                }

                override fun onUpdateProgeress(netReq: NetReq, curr: Long, final: Long) {}
            }
            val vi = (app.getManager(QQAppInterface.TICKET_MANAGER) as TicketManager).getA2(app.currentAccountUin)
            //LogCenter.log(pSKey)
            httpNetReq.mHttpMethod = HttpNetReq.HTTP_POST
            httpNetReq.mSendData = BytePacketBuilder().apply {
                writeInt(-1412589450)
                writeInt(10000)
                writeInt(0)
                writeInt(sha.size + 16 + blockSize.toInt())
                writeShort(0)
                writeShort(sha.size.toShort())
                writeFully(sha)
                writeInt(fileSize.toInt())
                writeInt(offset.toInt())
                writeInt(blockSize.toInt())
                writeFully(block)
            }.build().readBytes()
            httpNetReq.mOutStream = outputStream
            httpNetReq.mStartDownOffset = 0L
            httpNetReq.mReqProperties["Shamrock"] = "true"
            httpNetReq.mReqProperties["Cookie"] = String.format("uin=%s;vt=%d;vi=%s;pid=%s;appid=%d", app.currentAccountUin, 8, vi, pid, APPID)
            httpNetReq.mReqProperties["host"] = "pic.pieceup.qq.com"
            httpNetReq.mReqProperties["Range"] = "bytes=0-"
            httpNetReq.mReqProperties["Content-Length"] = httpNetReq.mSendData.size.toString()
            httpNetReq.mReqProperties["Accept-Encoding"] = "gzip"
            httpNetReq.mReqProperties["Content-Encoding"] = "gzip"
            httpNetReq.mPrioty = 1
            httpNetReq.mReqUrl = "https://pic.pieceup.qq.com/"
            httpNetReq.mServerList = SERVER_LIST_PICUP
            val service = AppRuntimeFetcher.appRuntime
                .getRuntimeService(IHttpEngineService::class.java, "qqfav")
            service.sendReq(httpNetReq)
        }
    }

    suspend fun sendWeiyunReq(
        cmd: Int,
        req: WeiyunCommonReq,
        outputStream: ByteArrayOutputStream = ByteArrayOutputStream(),
    ): Result<NetResp> {
        return suspendCancellableCoroutine {
            val httpNetReq = HttpNetReq()
            httpNetReq.userData = null
            httpNetReq.mCallback = object: INetEngineListener {
                override fun onResp(netResp: NetResp) {
                    if (netResp.mHttpCode != 200 && netResp.mResult != 0 && netResp.mErrDesc.isNullOrEmpty()) {
                        netResp.mErrDesc = netResp.mRespProperties["User-ErrMsg"]
                    }
                    netResp.mRespData = outputStream.toByteArray().copyOf()
                    it.resume(Result.success(netResp))
                }

                override fun onUpdateProgeress(netReq: NetReq, curr: Long, final: Long) {}
            }
            val pSKey = getWeiYunPSKey()
            httpNetReq.mHttpMethod = HttpNetReq.HTTP_POST
            httpNetReq.mSendData = DeflateTools.gzip(packData(packHead(cmd, pSKey), ProtoBuf.encodeToByteArray(
                WeiyunComm(req = req)
            )))
            httpNetReq.mOutStream = outputStream
            httpNetReq.mStartDownOffset = 0L
            httpNetReq.mReqProperties["Shamrock"] = "true"
            httpNetReq.mReqProperties["Cookie"] = String.format("uin=%s;vt=%d;vi=%s;appid=%d", app.currentAccountUin, 27, pSKey, APPID)
            httpNetReq.mReqProperties["host"] = "collector.weiyun.com"
            httpNetReq.mReqProperties["Range"] = "bytes=0-"
            httpNetReq.mReqProperties["Content-Length"] = httpNetReq.mSendData.size.toString()
            httpNetReq.mReqProperties["Accept-Encoding"] = "gzip"
            httpNetReq.mReqProperties["Content-Encoding"] = "gzip"
            httpNetReq.mPrioty = 1
            httpNetReq.mReqUrl = "https://collector.weiyun.com/collector.fcg"
            httpNetReq.mServerList = SERVER_LIST_COLLECTOR
            val service = AppRuntimeFetcher.appRuntime
                .getRuntimeService(IHttpEngineService::class.java, "qqfav")
            service.sendReq(httpNetReq)
        }
    }

    private fun packHead(cmd: Int, pskey: String): ByteArray {
        return ProtoBuf.encodeToByteArray(
            WeiyunMsgHead(
            uin = app.longAccountUin.toULong(),
            seq = seq++.toUInt(),
            type = 1u,
            cmd = cmd.toUInt(),
            appId = APPID.toUInt(),
            version = VERSION.toUInt(),
            netType = 3u,
            keyType = 27u,
            key = pskey.toByteArray(),
            majorVersion = MAJOR_VERSION.toUInt(),
            minorVersion = MINOR_VERSION.toUInt(),
        )
        )
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