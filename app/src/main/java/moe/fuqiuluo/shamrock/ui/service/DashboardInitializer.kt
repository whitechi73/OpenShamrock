@file:OptIn(DelicateCoroutinesApi::class)
package moe.fuqiuluo.shamrock.ui.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import moe.fuqiuluo.shamrock.remote.entries.CommonResult
import moe.fuqiuluo.shamrock.remote.entries.CurrentAccount
import moe.fuqiuluo.shamrock.remote.entries.Status
import moe.fuqiuluo.shamrock.tools.GlobalClient
import moe.fuqiuluo.shamrock.ui.app.AppRuntime.AccountInfo
import moe.fuqiuluo.shamrock.ui.app.AppRuntime.log
import moe.fuqiuluo.shamrock.ui.app.AppRuntime.state
import moe.fuqiuluo.shamrock.ui.app.Level
import moe.fuqiuluo.shamrock.ui.app.ShamrockConfig
import moe.fuqiuluo.shamrock.ui.service.internal.broadcastToModule
import java.net.ConnectException
import java.util.Timer
import kotlin.concurrent.timer

object DashboardInitializer {
    private  var servicePort: Int = 0
    private lateinit var heartbeatTimer: Timer

    operator fun invoke(context: Context, port: Int) {
        servicePort = port
        initHeartbeat(true, context)
    }

    private fun initHeartbeat(reload: Boolean, context: Context) {
        if (::heartbeatTimer.isInitialized && !reload) {
            return
        }
        if (::heartbeatTimer.isInitialized) {
            heartbeatTimer.cancel()
        }
        heartbeatTimer = timer("heartbeat", false, 0, 1000L * 30) {
            checkService(context)
        }
    }

    private fun checkService(context: Context) {
        GlobalScope.launch {
            try {
                GlobalClient.get {
                    url("http://127.0.0.1:$servicePort/get_account_info")
                    val token = ShamrockConfig.getToken(context)
                    if (token.isNotBlank()) {
                        header("Authorization", "Bearer $token")
                    }
                }.let {
                    if (it.status == HttpStatusCode.OK) {
                        val result: CommonResult<CurrentAccount> = Json.decodeFromString(it.bodyAsText())
                        state.isFined.value = result.retcode == 0
                        if (result.retcode == Status.InternalHandlerError.code) {
                            log("账号未登录。", Level.WARN)
                        } else if (result.retcode != 0) {
                            log("尝试从接口获取账号信息失败，未知错误。", Level.ERROR)
                        } else {
                            AccountInfo.let { account ->
                                account.uin.value = result.data.uin.toString()
                                account.nick.value = result.data.nick
                            }
                        }
                    } else {
                        state.isFined.value = false
                        log("尝试从接口获取账号信息失败，服务运行异常。", Level.ERROR)
                    }
                }
            } catch (e: ConnectException) {
                state.isFined.value = false
                context.broadcastToModule {
                    putExtra("__cmd", "checkAndStartService")
                }

                if (ShamrockConfig.enableAutoStart(context)) {
                    log("检测到Service死亡，正在尝试重新启动！")
                    GlobalScope.launch(Dispatchers.Main) {
                        val packageName = "com.tencent.mobileqq"
                        val className = "com.tencent.mobileqq.activity.SplashActivity"

                        val intent = Intent()
                        intent.component = ComponentName(packageName, className)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        intent.putExtra("from", "shamrock")
                        startActivity(context, intent, Bundle.EMPTY)
                    }
                }
            } catch (e: Throwable) {
                state.isFined.value = false
                log(e.stackTraceToString(), Level.ERROR)
            }
        }
    }
}