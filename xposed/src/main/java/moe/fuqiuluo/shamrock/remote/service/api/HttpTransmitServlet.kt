package moe.fuqiuluo.shamrock.remote.service.api

import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.Job
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.GlobalClient
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.ShamrockVersion
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.app.MobileQQ
import java.net.SocketException

internal abstract class HttpTransmitServlet : BaseTransmitServlet {
    override val address: String  by lazy { ShamrockConfig.getWebHookAddress() }

    override fun allowTransmit(): Boolean {
        return ShamrockConfig.allowWebHook()
    }

    protected suspend inline fun <reified T> pushTo(body: T): HttpResponse? {
        if (!allowTransmit()) return null
        try {
            if (address.startsWith("http://") || address.startsWith("https://")) {
                return GlobalClient.post(address) {
                    contentType(ContentType.Application.Json)
                    setBody(body)

                    header("User-Agent", "Shamrock/$ShamrockVersion")
                    header("X-QQ-Version", PlatformUtils.getClientVersion(MobileQQ.getContext()))
                    val runtime = AppRuntimeFetcher.appRuntime
                    val curUin = runtime.currentAccountUin
                    header("X-Self-ID", curUin)
                    header("X-OneBot-Version", "11")
                    header("X-Impl", "Shamrock")
                    header("X-Client-Role", "Universal")
                    header("Sec-WebSocket-Protocol", "11.Shamrock")
                }
            } else {
                LogCenter.log("HTTP推送地址错误: ${address}。", Level.ERROR)
            }
        } catch (e: ConnectTimeoutException) {
            LogCenter.log("HTTP推送失败: 请检查你的推送服务器。", Level.ERROR)
        } catch (e: SocketException) {
            LogCenter.log("HTTP推送失败: 网络波动。", Level.ERROR)
        } catch (e: HttpRequestTimeoutException) {
            LogCenter.log("HTTP推送失败: 推送服务器无法连接。", Level.ERROR)
        } catch (e: Throwable) {
            LogCenter.log("HTTP推送失败: ${e.stackTraceToString()}", Level.ERROR)
        }
        return null
    }
}