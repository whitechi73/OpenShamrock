package moe.fuqiuluo.shamrock.xposed.hooks

import android.content.Context

internal interface IAction {

    operator fun invoke(ctx: Context)

}