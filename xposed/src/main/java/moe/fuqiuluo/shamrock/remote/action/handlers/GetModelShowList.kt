package moe.fuqiuluo.shamrock.remote.action.handlers

import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.request
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.GlobalClient
import moe.fuqiuluo.shamrock.tools.GlobalJson
import moe.fuqiuluo.shamrock.tools.json
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.qqinterface.servlet.TicketSvc
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("_get_model_show")
internal object GetModelShowList : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        return invoke(session.getString("model"), session.echo)
    }

    suspend operator fun invoke(model: String, echo: JsonElement = EmptyJsonString): String {
        val ts = System.currentTimeMillis() / 1000
        val csrf = TicketSvc.getCSRF(TicketSvc.getUin(), "vip.qq.com")

        val req = mapOf(
            "13030" to mapOf(
                "req" to mapOf(
                    "lUin" to TicketSvc.getUin().toLong(),
                    "sModel" to model.replace("+", "%20"),
                    "iAppType" to 0,
                    "sIMei" to "",
                    "bShowInfo" to true,
                    "sModelShow" to "",
                    "bRecoverDefault" to false
                )
            )
        ).json.toString()

        val resp = GlobalClient.get("https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi") {
            parameter("ts", ts)
            parameter("daid", 18)
            parameter("g_tk", csrf)
            parameter("pt4_token", "")
            parameter("data", req)
            val cookie = TicketSvc.getCookie("vip.qq.com")
            header("Cookie", cookie)
        }

        if (resp.status != HttpStatusCode.OK) {
            LogCenter.log({ "unable to fetch model show list: ${resp.request.url} => ${resp.status}" }, Level.DEBUG)
            return error("unable to fetch model show list: ${resp.status}", echo)
        }

        val json = kotlin.runCatching {
            GlobalJson.decodeFromString<ModelShowStruct>(resp.bodyAsText())
        }.onFailure {
           it.printStackTrace()
        }.getOrNull()

        if (json?.resp == null) {
            return error("unable to fetch model show list", echo)
        }

        return ok(GetModelListResp(json.resp.data.rsp.vItemList.map {
            Model(it.sModelShow, it.bNeedPay)
        }), echo)
    }

    override val requiredParams: Array<String> = arrayOf("model")

    @Serializable
    data class GetModelListResp(
        @SerialName("variants") val resp: List<Model>
    )

    @Serializable
    data class Model(
        @SerialName("model_show") val model: String,
        @SerialName("need_pay") val needPay: Boolean
    )

    @Serializable
    data class ModelShowStruct(
        @SerialName("13030") val resp: ModelGetResp? = null
    )

    @Serializable
    data class ModelGetResp(
        @SerialName("data") val data: ModelGetData
    )

    @Serializable
    data class ModelGetData(
        @SerialName("rsp") val rsp: ModelGetRsp
    )

    @Serializable
    data class ModelGetRsp(
        @SerialName("vItemList") val vItemList: List<ModelGetItem>
    )

    @Serializable
    data class ModelGetItem(
        @SerialName("sModelShow") val sModelShow: String,
        @SerialName("bNeedPay") val bNeedPay: Boolean
    )
}