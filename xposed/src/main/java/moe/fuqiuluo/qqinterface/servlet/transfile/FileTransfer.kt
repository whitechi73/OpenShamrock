@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.qqinterface.servlet.transfile

import com.tencent.mobileqq.transfile.FileMsg
import com.tencent.mobileqq.transfile.TransferRequest
import com.tencent.mobileqq.transfile.api.ITransFileController
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import moe.fuqiuluo.shamrock.utils.MD5
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.app.AppRuntime
import mqq.app.MobileQQ
import java.io.File
import kotlin.coroutines.resume
import kotlin.math.abs
import kotlin.random.Random

internal abstract class FileTransfer {
    suspend fun transC2CResource(
        peerId: String,
        file: File,
        fileType: Int, busiType: Int,
        wait: Boolean = true,
        builder: (TransferRequest) -> Unit
    ): Boolean {
        val runtime = AppRuntimeFetcher.appRuntime
        val transferRequest = TransferRequest()
        transferRequest.needSendMsg = false
        transferRequest.mSelfUin = runtime.account
        transferRequest.mPeerUin = peerId
        transferRequest.mSecondId = runtime.currentAccountUin
        transferRequest.mUinType = FileMsg.UIN_BUDDY
        transferRequest.mFileType = fileType
        transferRequest.mUniseq = createMessageUniseq()
        transferRequest.mIsUp = true
        builder(transferRequest)
        transferRequest.mBusiType = busiType
        transferRequest.mMd5 = MD5.genFileMd5Hex(file.absolutePath)
        transferRequest.mLocalPath = file.absolutePath
        return transAndWait(runtime, transferRequest, wait)
    }

    suspend fun transTroopResource(
        groupId: String,
        file: File,
        fileType: Int, busiType: Int,
        wait: Boolean = true,
        builder: (TransferRequest) -> Unit
    ): Boolean {
        val runtime = AppRuntimeFetcher.appRuntime
        val transferRequest = TransferRequest()
        transferRequest.needSendMsg = false
        transferRequest.mSelfUin = runtime.account
        transferRequest.mPeerUin = groupId
        transferRequest.mSecondId = runtime.currentAccountUin
        transferRequest.mUinType = FileMsg.UIN_TROOP
        transferRequest.mFileType = fileType
        transferRequest.mUniseq = createMessageUniseq()
        transferRequest.mIsUp = true
        builder(transferRequest)
        transferRequest.mBusiType = busiType
        transferRequest.mMd5 = MD5.genFileMd5Hex(file.absolutePath)
        transferRequest.mLocalPath = file.absolutePath
        return transAndWait(runtime, transferRequest, wait)
    }

    private suspend fun transAndWait(
        runtime: AppRuntime,
        transferRequest: TransferRequest,
        wait: Boolean
    ): Boolean {
        return withTimeoutOrNull(60_000) {
            val service = runtime.getRuntimeService(ITransFileController::class.java, "all")
            if(service.transferAsync(transferRequest)) {
                if (!wait) { // 如果无需等待直接返回
                    return@withTimeoutOrNull true
                }
                suspendCancellableCoroutine { continuation ->
                    GlobalScope.launch {
                        while (
                        //service.findProcessor(
                        //    transferRequest.keyForTransfer // uin + uniseq
                        //) != null
                            service.containsProcessor(runtime.currentAccountUin, transferRequest.mUniseq)
                            // 如果上传处理器依旧存在，说明没有上传成功
                            && service.isWorking.get()
                        ) {
                            delay(100)
                        }
                        continuation.resume(true)
                    }
                    // 实现取消上传器
                    // 目前没什么用
                    continuation.invokeOnCancellation {
                        continuation.resume(false)
                    }
                }
            } else false
        } ?: false
    }

    companion object {
        const val SEND_MSG_BUSINESS_TYPE_AIO_ALBUM_PIC = 1031
        const val SEND_MSG_BUSINESS_TYPE_AIO_KEY_WORD_PIC = 1046
        const val SEND_MSG_BUSINESS_TYPE_AIO_QZONE_PIC = 1045
        const val SEND_MSG_BUSINESS_TYPE_ALBUM_PIC = 1007
        const val SEND_MSG_BUSINESS_TYPE_BLESS = 1056
        const val SEND_MSG_BUSINESS_TYPE_CAPTURE_PIC = 1008
        const val SEND_MSG_BUSINESS_TYPE_COMMEN_FALSH_PIC = 1040
        const val SEND_MSG_BUSINESS_TYPE_CUSTOM = 1006
        const val SEND_MSG_BUSINESS_TYPE_DOUTU_PIC = 1044
        const val SEND_MSG_BUSINESS_TYPE_FALSH_PIC = 1039
        const val SEND_MSG_BUSINESS_TYPE_FAST_IMAGE = 1037
        const val SEND_MSG_BUSINESS_TYPE_FORWARD_EDIT = 1048
        const val SEND_MSG_BUSINESS_TYPE_FORWARD_PIC = 1009
        const val SEND_MSG_BUSINESS_TYPE_FULL_SCREEN_ESSENCE = 1057
        const val SEND_MSG_BUSINESS_TYPE_GALEERY_PIC = 1041
        const val SEND_MSG_BUSINESS_TYPE_GAME_CENTER_STRATEGY = 1058
        const val SEND_MSG_BUSINESS_TYPE_HOT_PIC = 1042
        const val SEND_MSG_BUSINESS_TYPE_MIXED_PICS = 1043
        const val SEND_MSG_BUSINESS_TYPE_PIC_AIO_ALBUM = 1052
        const val SEND_MSG_BUSINESS_TYPE_PIC_CAMERA = 1050
        const val SEND_MSG_BUSINESS_TYPE_PIC_FAV = 1053
        const val SEND_MSG_BUSINESS_TYPE_PIC_SCREEN = 1027
        const val SEND_MSG_BUSINESS_TYPE_PIC_SHARE = 1030
        const val SEND_MSG_BUSINESS_TYPE_PIC_TAB_CAMERA = 1051
        const val SEND_MSG_BUSINESS_TYPE_QQPINYIN_SEND_PIC = 1038
        const val SEND_MSG_BUSINESS_TYPE_RECOMMENDED_STICKER = 1047
        const val SEND_MSG_BUSINESS_TYPE_RELATED_EMOTION = 1054
        const val SEND_MSG_BUSINESS_TYPE_SHOWLOVE = 1036
        const val SEND_MSG_BUSINESS_TYPE_SOGOU_SEND_PIC = 1034
        const val SEND_MSG_BUSINESS_TYPE_TROOP_BAR = 1035
        const val SEND_MSG_BUSINESS_TYPE_WLAN_RECV_NOTIFY = 1055
        const val SEND_MSG_BUSINESS_TYPE_ZHITU_PIC = 1049
        const val SEND_MSG_BUSINESS_TYPE_ZPLAN_EMOTICON_GIF = 1060
        const val SEND_MSG_BUSINESS_TYPE_ZPLAN_PIC = 1059

        const val VIDEO_FORMAT_AFS = 7
        const val VIDEO_FORMAT_AVI = 1
        const val VIDEO_FORMAT_MKV = 4
        const val VIDEO_FORMAT_MOD = 9
        const val VIDEO_FORMAT_MOV = 8
        const val VIDEO_FORMAT_MP4 = 2
        const val VIDEO_FORMAT_MTS = 11
        const val VIDEO_FORMAT_RM = 6
        const val VIDEO_FORMAT_RMVB = 5
        const val VIDEO_FORMAT_TS = 10
        const val VIDEO_FORMAT_WMV = 3

        const val BUSI_TYPE_GUILD_VIDEO = 4601
        const val BUSI_TYPE_MULTI_FORWARD_VIDEO = 1010
        const val BUSI_TYPE_PUBACCOUNT_PERM_VIDEO = 1009
        const val BUSI_TYPE_PUBACCOUNT_TEMP_VIDEO = 1007
        const val BUSI_TYPE_SHORT_VIDEO = 1
        const val BUSI_TYPE_SHORT_VIDEO_PTV = 2
        const val BUSI_TYPE_VIDEO = 0
        const val BUSI_TYPE_VIDEO_EMOTICON_PIC = 1022
        const val BUSI_TYPE_VIDEO_EMOTICON_VIDEO = 1021

        internal fun createMessageUniseq(time: Long = System.currentTimeMillis()): Long {
            var uniseq = (time / 1000).toInt().toLong()
            uniseq = uniseq shl 32 or abs(Random.nextInt()).toLong()
            return uniseq
        }
    }
}