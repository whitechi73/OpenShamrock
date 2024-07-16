package moe.fuqiuluo.shamrock.xposed.hooks.interacts

import android.content.Intent

interface IInteract {
    operator fun invoke(intent: Intent)
}