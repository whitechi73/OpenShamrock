package moe.fuqiuluo.shamrock.xposed.actions.interacts

import android.content.Intent

interface IInteract {
    operator fun invoke(intent: Intent)
}