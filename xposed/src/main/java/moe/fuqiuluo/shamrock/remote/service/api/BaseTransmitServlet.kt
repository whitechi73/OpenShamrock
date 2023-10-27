package moe.fuqiuluo.shamrock.remote.service.api

import com.tencent.mobileqq.app.QQAppInterface
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import kotlinx.coroutines.Job
import moe.fuqiuluo.shamrock.remote.service.data.push.NoticeSubType
import moe.fuqiuluo.shamrock.remote.service.data.push.NoticeType
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import oicq.wlogin_sdk.tools.MD5

internal interface BaseTransmitServlet {
    val address: String

    fun allowTransmit(): Boolean

    fun submitFlowJob(job: Job)

    fun cancelFlowJobs()

    fun initTransmitter()

    val app: QQAppInterface
        get() = AppRuntimeFetcher.appRuntime as QQAppInterface

    val id: String
        get() = MD5.getMD5String(address.toByteArray())
}