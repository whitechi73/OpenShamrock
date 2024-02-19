package moe.fuqiuluo.shamrock.remote.service.api

import com.tencent.mobileqq.app.QQAppInterface
import kotlinx.coroutines.Job
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import oicq.wlogin_sdk.tools.MD5

internal interface BaseTransmitServlet {
    val address: String

    fun transmitAccess(): Boolean

    fun subscribe(job: Job)

    fun unsubscribe()

    fun init()

    val app: QQAppInterface
        get() = AppRuntimeFetcher.appRuntime as QQAppInterface

    val id: String
        get() = MD5.getMD5String(address.toByteArray())
}