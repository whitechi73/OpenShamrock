package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.ark.LightAppSvc
import moe.fuqiuluo.qqinterface.servlet.ark.data.ArkAppInfo
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("adapt_share_json")
internal object AdaptShareJson: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        //val json = if(session.isString("json")) session.getString("json")
        //else session.getJsonElement("json").toString()
        val cover = session.getString("cover")
        val desc = session.getString("desc")
        val url = session.getStringOrNull("url") ?: ""
        return invoke(cover, desc, url, session.echo)
    }

    suspend operator fun invoke(cover: String, desc: String, url: String, echo: JsonElement = EmptyJsonString): String {
        /*
        ArkMsgSvc.tryShareJsonMessage(json).onSuccess {
            return ok(SignArkMessageResult(it), echo = echo)
        }.onFailure {
            return error(it.message ?: it.toString(), echo)
        }*/
        LightAppSvc.adaptShareJumpUrl(ArkAppInfo.DanMaKu, cover, desc, url).onSuccess {
            return ok(AdaptShareInfo(it), echo = echo)
        }.onFailure {
            return error(it.message ?: it.toString(), echo)
        }
        return logic("logic error", echo)
    }

    override val requiredParams: Array<String> = arrayOf("cover", "desc")

    @Serializable
    data class AdaptShareInfo(
        val result: String
    )
}