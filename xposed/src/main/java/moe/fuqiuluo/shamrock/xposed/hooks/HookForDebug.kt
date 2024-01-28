package moe.fuqiuluo.shamrock.xposed.hooks

import android.content.Context
import moe.fuqiuluo.symbols.XposedHook

@XposedHook(priority = -1)
internal class HookForDebug: IAction {
    override fun invoke(ctx: Context) {
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
        }*/

    }
}