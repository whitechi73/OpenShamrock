package moe.fuqiuluo.shamrock.remote.api

import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import moe.fuqiuluo.shamrock.remote.action.handlers.GetWeather
import moe.fuqiuluo.shamrock.remote.action.handlers.GetWeatherCityCode
import moe.fuqiuluo.shamrock.tools.*

fun Routing.weatherAction() {
    getOrPost("/get_weather") {
        val cityCode = fetchOrNull("code")
        if (cityCode == null) {
            val city = fetchOrThrow("city")
            call.respondText(GetWeather(city))
            return@getOrPost
        }
        call.respondText(GetWeather(cityCode.toInt()))
    }

    getOrPost("/get_weather_city_code") {
        val city = fetchOrThrow("city")
        call.respondText(GetWeatherCityCode(city))
    }
}