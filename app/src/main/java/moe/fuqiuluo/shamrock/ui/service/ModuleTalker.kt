package moe.fuqiuluo.shamrock.ui.service

import moe.fuqiuluo.shamrock.ui.service.handlers.ModuleHandler

object ModuleTalker {
    val HandlerMap = mutableMapOf<String, ModuleHandler>()

    fun register(handler: ModuleHandler) {
        HandlerMap[handler.cmd] = handler
    }

    fun register(cmd: String, handler: ModuleHandler) {
        HandlerMap[cmd] = handler
    }
}