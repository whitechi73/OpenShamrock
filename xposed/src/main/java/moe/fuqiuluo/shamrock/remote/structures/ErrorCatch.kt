package moe.fuqiuluo.shamrock.remote.structures

import kotlinx.serialization.Serializable

@Serializable
data class ErrorCatch(
    var url: String,
    var error: String
)
