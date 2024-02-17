@file:Suppress("UNUSED_VARIABLE", "LocalVariableName")

package moe.fuqiuluo.shamrock.xposed.hooks

import android.content.Context
import com.tencent.mobileqq.perf.block.BinderMethodProxy
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity
import com.tencent.mobileqq.qroute.QRoute
import com.tencent.qqnt.aio.api.IAIOPicDownloaderProvider
import de.robv.android.xposed.XposedBridge
import epic.EIPCClient
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.beforeHook
import moe.fuqiuluo.shamrock.tools.hookMethod
import moe.fuqiuluo.shamrock.tools.toInnerValuesString
import moe.fuqiuluo.shamrock.xposed.loader.LuoClassloader
import moe.fuqiuluo.symbols.Process
import moe.fuqiuluo.symbols.XposedHook
import java.lang.reflect.Modifier

@XposedHook(priority = -1, process = Process.ALL)
internal class HookForDebug: IAction {
    override fun invoke(ctx: Context) {
        //val LibraDownloader = QRoute.api(IAIOPicDownloaderProvider::class.java).provideDownloader().javaClass
        //LibraDownloader.hookMethod("downLoad").before {
        //    val option = it.args[0]
        //    LogCenter.log("LibraDownloader.downLoad(${option.toInnerValuesString()})")
        //}
    }
}

/*val NtDnsManager = LuoClassloader.load("com.tencent.qqnt.dns.NtDnsManager")!!
        val NtDnsInternal = NtDnsManager.declaredMethods.first {
            !Modifier.isStatic(it.modifiers) && it.parameterCount == 0
        }.returnType
        XposedBridge.hookMethod(NtDnsInternal.declaredMethods.first {
            it.parameterCount == 2
                    && it.parameterTypes[0] == String::class.java
                    && it.parameterTypes[1] == Int::class.java
                    && it.returnType == ArrayList::class.java
        }, beforeHook {
            val domain = it.args[0] as String
            val type = it.args[1] as Int
            LogCenter.log("NtDnsManager: reqDomain2IpList($domain, $type)")
            LogCenter.log(Exception().stackTraceToString())
        })*/
/*
        val httpEngineService = AppRuntimeFetcher.appRuntime
            .getRuntimeService(IHttpEngineService::class.java, "all")
        httpEngineService.javaClass.hookMethod("sendReq").before {
            if (it.args[0] is HttpNetReq) {
                val req = it.args[0] as HttpNetReq
                if (req.mReqProperties["Shamrock"] == "true") {
                    return@before
                }
                LogCenter.log("已记录一个IHttpEngineService请求")
                LogCenter.log("请求地址: ${req.mReqUrl}")
                LogCenter.log("请求: ${req.toInnerValuesString(NetReq::class.java)}")
            }
        }
        BinderMethodProxy::class.java.hookMethod("callServer").before {
            val action = it.args[2] as String
            if (action == "reqDomain2IpList") {
                LogCenter.log(Exception().stackTraceToString())
            }
        }
        EIPCClient::class.java.hookMethod("callServer").before {
            val module = it.args[0] as String
            val action = it.args[1] as String
            if (action == "reqDomain2IpList" || module.contains("dns", ignoreCase = true)) {
                LogCenter.log(Exception().stackTraceToString())
            }
        }*/
