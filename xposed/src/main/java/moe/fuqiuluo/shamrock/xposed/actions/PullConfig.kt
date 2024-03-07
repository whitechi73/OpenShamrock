package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.symbols.Process
import moe.fuqiuluo.symbols.XposedHook

@XposedHook(Process.MAIN, priority = 1)
class PullConfig: IAction {
    override fun invoke(ctx: Context) {
        if (!PlatformUtils.isMainProcess()) return

    }
}