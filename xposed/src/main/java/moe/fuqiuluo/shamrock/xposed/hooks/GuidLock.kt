package moe.fuqiuluo.shamrock.xposed.hooks

import android.content.Context
import com.tencent.beacon.event.open.BeaconReport
import com.tencent.mobileqq.qsec.qsecurity.QSecConfig
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.hex2ByteArray
import moe.fuqiuluo.shamrock.tools.hookMethod
import moe.fuqiuluo.shamrock.utils.MMKVFetcher
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.symbols.XposedHook
import oicq.wlogin_sdk.tools.util

@XposedHook(priority = 10)
internal class GuidLock: IAction {
    companion object {
        var qimei: String = ""
    }

    override fun invoke(ctx: Context) {
        val guildLock = MMKVFetcher.mmkvWithId("guid")
        val utilClass = util::class.java
        utilClass.hookMethod("needChangeGuid").before {
            if (guildLock.getString("guid", null) != null) {
                it.result = false
            }
        }
        utilClass.hookMethod("getGuidFromFile").before {
            val guid = guildLock.getString("guid", null)
            if (guid != null) {
                it.result = guid.hex2ByteArray()
            }
        }
        utilClass.hookMethod("saveGuidToFile").before {
            val guid = guildLock.getString("guid", null)
            if (guid != null) {
                it.args[1] = guid.hex2ByteArray()
            }
        }

        utilClass.hookMethod("get_last_guid").before {
            val guid = guildLock.getString("guid", null)
            if (guid != null) {
                it.result = guid.hex2ByteArray()
            }
        }

        utilClass.hookMethod("generateGuid").before {
            val guid = guildLock.getString("guid", null)
            if (guid != null) {
                it.result = guid.hex2ByteArray()
            }
        }

        QSecConfig::class.java.hookMethod("setupBusinessInfo").before {
            val guid = guildLock.getString("guid", null)
            if (guid != null) {
                it.args[2] = guid.hex2ByteArray()
            }
        }

        if (PlatformUtils.isMqqPackage()) {
            BeaconReport.getInstance().getQimei("0S200MNJT807V3GE", ctx) { qimei ->
                LogCenter.log("QIMEI获取: ${qimei.qimei36}")
                GuidLock.qimei = qimei.qimei36
            }
        } else {
            BeaconReport.getInstance().getQimei { qimei ->
                LogCenter.log("QIMEI获取: ${qimei.qimei36}")
                GuidLock.qimei = qimei.qimei36
            }
        }

    }
}