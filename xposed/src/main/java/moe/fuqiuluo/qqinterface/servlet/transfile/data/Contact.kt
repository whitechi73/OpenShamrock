package moe.fuqiuluo.qqinterface.servlet.transfile.data

import com.tencent.mobileqq.data.MessageRecord

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
