package moe.fuqiuluo.shamrock.remote.service.data

import kotlinx.serialization.Serializable
import java.util.Base64

@Serializable internal data class OutResource(
    val file: String, val url: String
)

@Serializable internal data class OutResourceByBase64(
    val file: String,
    val base64String: String,
)