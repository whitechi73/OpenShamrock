@file:OptIn(DelicateCoroutinesApi::class)
package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context
import com.tencent.msf.service.protocol.pb.SSOLoginMerge
import com.tencent.qphone.base.remote.FromServiceMsg
import com.tencent.qphone.base.remote.ToServiceMsg
import com.tencent.qphone.base.util.CodecWarpper
import kotlinx.atomicfu.atomic
import kotlinx.coroutines.DelicateCoroutinesApi
import moe.fuqiuluo.shamrock.remote.service.PacketReceiver
import moe.fuqiuluo.shamrock.remote.service.config.ShamrockConfig
import moe.fuqiuluo.shamrock.tools.EMPTY_BYTE_ARRAY
import moe.fuqiuluo.shamrock.tools.hookMethod
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.utils.PlatformUtils

internal class HookWrapperCodec: IAction {
    private val IgnoredCmd = arrayOf(
        "trpc.sq_adv.official_account_adv_push.OfficialAccountAdvPush.AdvPush",
        "LightAppSvc.mini_app_report_transfer.DataReport",
        "JsApiSvr.webview.whitelist",
        "trpc.commercial.access.access_sso.SsoAdGet",
        "trpc.qpay.homepage2.Homepage2.SsoGetHomepage",
        "trpc.qpay.value_added_info.Query.SsoGetPrivilege",
        "trpc.qqshop.qgghomepage.Config.SsoGetBottomTab",
        "ClubInfoSvc.queryPrivExt",
        "OidbSvc.0xcf8",
        "LbsSvc.lbs_report",
        "OidbSvcTrpcTcp.0x88d_0",
        "trpc.down.game_switch.GameSwitch.SsoGetDownloadConfig",
        "trpc.zplan.aio_avatar.Mobile.SsoBatchGetSceneConfig",
        "OidbSvcTrpcTcp.0x1127_5",
        "OidbSvcTrpcTcp.0x10aa",
        "WalletConfigSvr.getConfig",
        "LightAppSvc.mini_app_userapp.GetDropdownAppList",
        "LightAppSvc.mini_app_ad.GetAd",
        "SQQzoneSvc.advReport",
        //"ConfigurationService.ReqGetConfig"
    )

    override fun invoke(ctx: Context) {
        try {
            ToServiceMsg::class.java.hookMethod("setRequestSsoSeq").before {
                val to = it.thisObject as ToServiceMsg
                to.getAttribute("shamrock_seq")?.let { seq ->
                    it.args[0] = seq
                }
            }

            val isInit = atomic(false)
            CodecWarpper::class.java.hookMethod("init").after {
                if (isInit.value) return@after
                hookReceive(it.thisObject.javaClass)
                isInit.lazySet(true)
            }
            CodecWarpper::class.java.hookMethod("nativeOnReceData").before {
                if (isInit.value) return@before
                hookReceive(it.thisObject.javaClass)
                isInit.lazySet(true)
            }
        } catch (e: Exception) {
            LogCenter.log(e.stackTraceToString(), Level.ERROR)
        }
    }

    private fun hookReceive(thizClass: Class<*>) {
        thizClass.hookMethod("onResponse").before {
            val from = it.args[1] as FromServiceMsg
            try {
                if ("SSO.LoginMerge" == from.serviceCmd) {
                    val merge = SSOLoginMerge.BusiBuffData()
                        .mergeFrom(from.wupBuffer.slice(4))
                    val busiBufVec = merge.BusiBuffVec.get()
                    busiBufVec.forEach { item ->
                        if (item.ServiceCmd.get() in IgnoredCmd && ShamrockConfig.isInjectPacket()) {
                            busiBufVec.remove(item)
                        } else {
                            pushOnReceive(FromServiceMsg().apply {
                                this.requestSsoSeq = item.SeqNo.get()
                                this.serviceCmd = item.ServiceCmd.get()
                                putWupBuffer(item.BusiBuff.get().toByteArray())
                            })
                        }
                    }
                    merge.BusiBuffVec.set(busiBufVec)
                    from.putWupBuffer(merge.toByteArray())
                } else {
                    if (from.serviceCmd in IgnoredCmd && ShamrockConfig.isInjectPacket()) {
                        from.serviceCmd = "ShamrockInjectedCmd"
                        from.putWupBuffer(EMPTY_BYTE_ARRAY)
                    } else {
                        pushOnReceive(from)
                    }
                }
            } finally {
                it.args[1] = from
            }
        }
    }

    private fun pushOnReceive(fromServiceMsg: FromServiceMsg) {
        PacketReceiver.internalOnReceive(fromServiceMsg)
    }
}



