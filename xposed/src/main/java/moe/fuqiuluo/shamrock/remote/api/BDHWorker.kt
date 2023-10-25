package moe.fuqiuluo.shamrock.remote.api

import android.util.Base64
import com.tencent.mobileqq.transfile.TransferRequest
import com.tencent.mobileqq.transfile.api.ITransFileController
import io.ktor.server.routing.Routing
import io.ktor.server.routing.post
import moe.fuqiuluo.shamrock.remote.entries.Status
import moe.fuqiuluo.shamrock.tools.fetchPost
import moe.fuqiuluo.shamrock.tools.respond
import moe.fuqiuluo.shamrock.utils.MD5
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.app.MobileQQ
import kotlin.random.Random
import kotlin.random.nextLong

fun Routing.registerBDH() {
    post("/upload_group_image") {
        val troop = fetchPost("troop")
        val picBytes = Base64.decode(fetchPost("pic"), Base64.DEFAULT)
        val md5Str = MD5.getMd5Hex(picBytes)
        val file = MobileQQ.getContext().cacheDir.resolve("vas_ad").also {
            if (!it.exists()) it.mkdir()
        }.resolve("$md5Str.jpg")
        file.writeBytes(picBytes)
        val sender = fetchPost("sender")

        val runtime = AppRuntimeFetcher.appRuntime
        val transferRequest = TransferRequest()
        transferRequest.needSendMsg = false
        transferRequest.mSelfUin = runtime.account
        transferRequest.mPeerUin = troop
        transferRequest.mSecondId = sender
        transferRequest.mUinType = 1
        transferRequest.mFileType = 1
        transferRequest.mUniseq = Random.nextLong(10000L .. 1000000)
        transferRequest.mIsUp = true
        transferRequest.mBusiType = 1030
        transferRequest.mMd5 = md5Str
        transferRequest.mLocalPath = file.absolutePath
        val picUpExtraInfo = TransferRequest.PicUpExtraInfo()
        picUpExtraInfo.mIsRaw = true
        transferRequest.mPicSendSource = 8
        transferRequest.mExtraObj = picUpExtraInfo
        (runtime.getRuntimeService(ITransFileController::class.java, "all") as ITransFileController)
            .transferAsync(transferRequest)
        respond(isOk = true, Status.Ok, "$md5Str.jpg")
    }

}