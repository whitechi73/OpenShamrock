package moe.fuqiuluo.qqinterface.servlet.transfile

internal enum class ContactType {
    TROOP,
    PRIVATE,
}

internal interface TransTarget {
    val id: String
    val type: ContactType
}

internal class Troop(override val id: String): TransTarget {
    override val type: ContactType = ContactType.TROOP
}

internal class Private(override val id: String): TransTarget {
    override val type: ContactType = ContactType.PRIVATE
}
