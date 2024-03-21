package moe.fuqiuluo.shamrock.xposed.actions

import android.content.Context

internal interface IAction {

    operator fun invoke(ctx: Context)

}