package moe.fuqiuluo.shamrock.remote.structures

data class SendMsgResult(
    val msgHashId: Int,
    val qqMsgId: Long,
    var msgTime: Long,
    var isTimeout: Boolean = false
)
