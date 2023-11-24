package moe.fuqiuluo.shamrock.remote.service.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GroupAnnouncement (
    @SerialName("sender_id") val senderId: Long = 0,
    @SerialName("publish_time") val publishTime: Long,
    @SerialName("message") val message: GroupAnnouncementMessage,
)

@Serializable
internal data class GroupAnnouncementMessage (
    @SerialName("text") val text: String,
    @SerialName("images") val images: List<GroupAnnouncementMessageImage>,
)

@Serializable
internal data class GroupAnnouncementMessageImage (
    @SerialName("height") val height: String,
    @SerialName("width") val width: String,
    @SerialName("id") val id: String,
)

