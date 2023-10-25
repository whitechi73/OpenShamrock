package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.CardSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object GetModelShow: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val uin = session.getLongOrNull("user_id")
        return if (uin == null) {
            invoke(session.echo)
        } else {
            invoke(uin, session.echo)
        }
    }

    suspend operator fun invoke(echo: JsonElement = EmptyJsonString): String {
        return ok(CardSvc.getModelShow(), echo)
    }

    suspend operator fun invoke(uin: Long, echo: JsonElement = EmptyJsonString): String {
        if (uin == 0L) {
            return invoke(echo)
        }
        return ok(CardSvc.getModelShow(uin), echo)
    }

    override fun path(): String = "get_model_show"
}