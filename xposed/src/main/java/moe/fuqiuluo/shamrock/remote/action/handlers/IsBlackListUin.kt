package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi
import com.tencent.mobileqq.qroute.QRoute
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@OneBotHandler("is_blacklist_uin")
internal object IsBlackListUin: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val userId = session.getString("user_id")
        return invoke(userId, session.echo)
    }

    suspend operator fun invoke(uin: String, echo: JsonElement = EmptyJsonString): String {
        val blacklistApi = QRoute.api(IProfileCardBlacklistApi::class.java)
        val isBlack = withTimeoutOrNull(5000) {
            suspendCoroutine { continuation ->
                blacklistApi.isBlackOrBlackedUin(uin) {
                    continuation.resume(it)
                }
            }
        } ?: false
        return ok(data = IsBlackListUinResult(isBlack), echo)
    }

    override val requiredParams: Array<String> = arrayOf("user_id")

    @Serializable
    data class IsBlackListUinResult(
        @SerialName("is") val isBlack: Boolean
    )
}