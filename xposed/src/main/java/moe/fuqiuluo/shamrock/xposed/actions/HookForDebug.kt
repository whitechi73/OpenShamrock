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
        // MessageHelper.hookSendMessageOldChannel()
        val oldHttpEngineProcessor = QRoute.api(IOldHttpEngineProcessor::class.java)
        oldHttpEngineProcessor.javaClass.hookMethod("sendReq").before {
            if (it.args[0] is HttpNetReq) {
                LogCenter.log("已记录一个IOldHttpEngineProcessor请求")
                val req = it.args[0] as HttpNetReq
                if (req.mReqUrl.startsWith("https://")) {
                    req.mReqUrl = req.mReqUrl.replace("https://", "http://")
                }
            }
        }
        val httpEngineService = AppRuntimeFetcher.appRuntime
            .getRuntimeService(IHttpEngineService::class.java, "all")
        httpEngineService.javaClass.hookMethod("sendReq").before {
            if (it.args[0] is HttpNetReq) {
                LogCenter.log("已记录一个IHttpEngineService请求")
                val req = it.args[0] as HttpNetReq
                if (req.mReqUrl == null || req.mReqUrl.isBlank()) {
                    val host = req.mReqProperties["host"] ?: "collector.weiyun.com"
                    req.mReqUrl = "http://$host"
                } else if (req.mReqUrl.startsWith("https://")) {
                    req.mReqUrl = req.mReqUrl.replace("https://", "http://")
                }
            }
        }

    }
}