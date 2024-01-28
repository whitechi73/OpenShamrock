package moe.fuqiuluo.shamrock.remote.api

import com.tencent.mobileqq.app.QQAppInterface
import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import moe.fuqiuluo.shamrock.remote.action.ActionManager
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.handlers.GetLoginInfo
import moe.fuqiuluo.shamrock.remote.structures.CommonResult
import moe.fuqiuluo.shamrock.remote.structures.CurrentAccount
import moe.fuqiuluo.shamrock.remote.structures.Status
import moe.fuqiuluo.shamrock.tools.*
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.app.MobileQQ

fun Routing.profileRouter() {
    getOrPost("/set_qq_profile") {
        val nickName = fetchOrThrow("nickname")
        val company = fetchOrThrow("company")
        val email = fetchOrThrow("email")
        val college = fetchOrThrow("college")
        val personalNote = fetchOrThrow("personal_note")

        val age = fetchOrNull("age")
        val birthday = fetchOrNull("birthday")

        val handler = ActionManager["set_qq_profile"]!!

        call.respondText(
            handler.handle(
                ActionSession(
                    mapOf(
                        "nickname" to nickName,
                        "company" to company,
                        "email" to email,
                        "college" to college,
                        "personal_note" to personalNote,
                        "age" to age,
                        "birthday" to birthday
                    )
                )
            ), ContentType.Application.Json
        )
    }

    getOrPost("/get_account_info") {
        val accounts = MobileQQ.getMobileQQ().allAccounts
        val runtime = AppRuntimeFetcher.appRuntime
        val curUin = runtime.currentAccountUin
        val account = accounts?.firstOrNull { it.uin == curUin }
        if (!runtime.isLogin || account == null || !account.isLogined) {
            this.call.respond(
                CommonResult(
                    "ok", Status.InternalHandlerError.code, CurrentAccount(
                        1094950020L, false, "未登录"
                    )
                )
            )
        } else {
            this.call.respond(
                CommonResult(
                    "ok", 0, CurrentAccount(
                        curUin.toLong(),
                        runtime.isLogin,
                        if (runtime is QQAppInterface) runtime.currentNickname else "unknown"
                    )
                )
            )
        }
    }

    getOrPost("/get_history_account_info") {
        val accounts = MobileQQ.getMobileQQ().allAccounts
        val accountList = accounts.map {
            CurrentAccount(it.uin.toLong(), it.isLogined)
        }
        respond(true, Status.Ok, accountList)
    }

    getOrPost("/get_login_info") {
        call.respondText(GetLoginInfo(), ContentType.Application.Json)
    }
}