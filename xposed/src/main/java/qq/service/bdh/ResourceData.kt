package qq.service.bdh

import com.tencent.mobileqq.data.MessageRecord
import java.io.File

internal enum class ContactType {
    TROOP,
    PRIVATE,
}

internal interface TransTarget {
    val id: String
    val type: ContactType

    val mRec: MessageRecord?
}

internal class Troop(
    override val id: String,
    override val mRec: MessageRecord? = null
): TransTarget {
    override val type: ContactType = ContactType.TROOP
}

internal class Private(
    override val id: String,
    override val mRec: MessageRecord? = null
): TransTarget {
    override val type: ContactType = ContactType.PRIVATE
}

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