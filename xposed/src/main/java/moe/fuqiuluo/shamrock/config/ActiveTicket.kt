package moe.fuqiuluo.shamrock.config

object ActiveTicket: ConfigKey<String>() {
    override fun name(): String = "active_ticket"

    override fun default(): String = ""
}