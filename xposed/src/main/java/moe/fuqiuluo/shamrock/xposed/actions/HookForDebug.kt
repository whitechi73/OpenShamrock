package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService
import com.tencent.mobileqq.qroute.QRoute
import com.tencent.mobileqq.qroute.QRouteApi
import com.tencent.mobileqq.transfile.HttpNetReq
import com.tencent.mobileqq.transfile.NetReq
import com.tencent.mobileqq.transfile.api.IHttpEngineService
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.hookMethod
import moe.fuqiuluo.shamrock.tools.toInnerValuesString
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.app.MobileQQ

internal class HookForDebug: IAction {
    override fun invoke(ctx: Context) {
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

    }
}