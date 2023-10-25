package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.ark.WeatherSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object GetWeather: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        session.getIntOrNull("code")?.let {
            return invoke(it, session.echo)
        }
        session.getString("city").let {
            return invoke(it, session.echo)
        }
    }

    suspend operator fun invoke(code: Int, echo: JsonElement = EmptyJsonString): String {
        val result = WeatherSvc.fetchWeatherCard(code)
        if (result.isFailure) {
            return error("fetch weather failed", echo)
        }
        return ok(result.getOrThrow(), echo)
    }

    suspend operator fun invoke(city: String, echo: JsonElement = EmptyJsonString): String {
        val code = WeatherSvc.searchCity(city)
        if (code.isFailure || code.getOrThrow().isEmpty()) {
            return error("search city failed", echo)
        }
        return invoke(code.getOrThrow().first().adcode, echo)
    }

    override fun path(): String = "get_weather"
}