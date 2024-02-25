package moe.fuqiuluo.qqinterface.servlet.transfile.data

import java.io.File

internal enum class ResourceType {
    Picture,
    Video,
    Voice
}

internal interface Resource {
    val type: ResourceType
}

internal data class PictureResource(
    val src: File
): Resource {
    override val type = ResourceType.Picture
}

internal data class VideoResource(
    val src: File, val thumb: File
): Resource {
    override val type = ResourceType.Video
}

internal data class VoiceResource(
    val src: File
): Resource {
    override val type = ResourceType.Voice
}