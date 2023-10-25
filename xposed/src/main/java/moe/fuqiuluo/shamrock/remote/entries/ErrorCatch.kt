package moe.fuqiuluo.shamrock.remote.entries

import kotlinx.serialization.Serializable

@Serializable
data class ErrorCatch(
    var url: String,
    var error: String
)
