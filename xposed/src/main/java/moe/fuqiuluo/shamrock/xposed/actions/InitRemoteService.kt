@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context
import kotlinx.coroutines.DelicateCoroutinesApi
import moe.fuqiuluo.symbols.Process
import moe.fuqiuluo.symbols.XposedHook

@XposedHook(Process.MAIN, priority = 10)
internal class InitRemoteService : IAction {
    override fun invoke(ctx: Context) {

    }
}
