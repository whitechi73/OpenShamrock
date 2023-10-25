package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context

internal class HookForDebug: IAction {
    override fun invoke(ctx: Context) {
        // MessageHelper.hookSendMessageOldChannel()
    }
}