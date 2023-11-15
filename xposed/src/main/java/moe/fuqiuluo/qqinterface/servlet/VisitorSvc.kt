package moe.fuqiuluo.qqinterface.servlet

internal object VisitorSvc: BaseSvc() {
    const val FROM_C2C_AIO = 2
    const val FROM_CONDITION_SEARCH = 9
    const val FROM_CONTACTS_TAB = 5
    const val FROM_FACE_2_FACE_ADD_FRIEND = 11
    const val FROM_MAYKNOW_FRIEND = 3
    const val FROM_QCIRCLE = 4
    const val FROM_QQ_TROOP = 1
    const val FROM_QZONE = 7
    const val FROM_SCAN = 6
    const val FROM_SEARCH = 8
    const val FROM_SETTING_ME = 12
    const val FROM_SHARE_CARD = 10

    const val IS_BLACK_LIST = "is_blacklist_user_profile"
    const val PROFILE_CARD_IS_BLACK = 2
    const val PROFILE_CARD_IS_BLACKED = 1
    const val PROFILE_CARD_NOT_BLACK = 3

    const val SUB_FROM_C2C_AIO = 21
    const val SUB_FROM_C2C_INTERACTIVE_LOGO = 25
    const val SUB_FROM_C2C_LEFT_SLIDE = 23
    const val SUB_FROM_C2C_OTHER = 24
    const val SUB_FROM_C2C_SETTING = 22
    const val SUB_FROM_C2C_TOFU = 26
    const val SUB_FROM_CONDITION_SEARCH_OTHER = 99
    const val SUB_FROM_CONDITION_SEARCH_RESULT = 91
    const val SUB_FROM_CONTACTS_FRIEND_TAB = 51
    const val SUB_FROM_CONTACTS_TAB = 55
    const val SUB_FROM_FACE_2_FACE_ADD_FRIEND_RESULT_AVATAR = 111
    const val SUB_FROM_FACE_2_FACE_OTHER = 119
    const val SUB_FROM_FRIEND_APPLY = 56
    const val SUB_FROM_FRIEND_NOTIFY_MORE = 57
    const val SUB_FROM_FRIEND_NOTIFY_TAB = 54
    const val SUB_FROM_GROUPING_TAB = 52
    const val SUB_FROM_MAYKNOW_FRIEND_CONTACT_TAB = 31
    const val SUB_FROM_MAYKNOW_FRIEND_CONTACT_TAB_MORE = 37
    const val SUB_FROM_MAYKNOW_FRIEND_FIND_PEOPLE = 34
    const val SUB_FROM_MAYKNOW_FRIEND_FIND_PEOPLE_MORE = 39
    const val SUB_FROM_MAYKNOW_FRIEND_FIND_PEOPLE_SEARCH = 36
    const val SUB_FROM_MAYKNOW_FRIEND_NEW_FRIEND_PAGE = 32
    const val SUB_FROM_MAYKNOW_FRIEND_OTHER = 35
    const val SUB_FROM_MAYKNOW_FRIEND_SEARCH = 33
    const val SUB_FROM_MAYKNOW_FRIEND_SEARCH_MORE = 38
    const val SUB_FROM_PHONE_LIST_TAB = 53
    const val SUB_FROM_QCIRCLE_OTHER = 42
    const val SUB_FROM_QCIRCLE_PROFILE = 41
    const val SUB_FROM_QQ_TROOP_ACTIVE_MEMBER = 15
    const val SUB_FROM_QQ_TROOP_ADMIN = 16
    const val SUB_FROM_QQ_TROOP_AIO = 11
    const val SUB_FROM_QQ_TROOP_MEMBER = 12
    const val SUB_FROM_QQ_TROOP_OTHER = 14
    const val SUB_FROM_QQ_TROOP_SETTING_MEMBER_LIST = 17
    const val SUB_FROM_QQ_TROOP_TEMP_SESSION = 13
    const val SUB_FROM_QRCODE_SCAN_DRAWER = 64
    const val SUB_FROM_QRCODE_SCAN_NEW = 61
    const val SUB_FROM_QRCODE_SCAN_OLD = 62
    const val SUB_FROM_QRCODE_SCAN_OTHER = 69
    const val SUB_FROM_QRCODE_SCAN_PROFILE = 63
    const val SUB_FROM_QZONE_HOME = 71
    const val SUB_FROM_QZONE_OTHER = 79
    const val SUB_FROM_SEARCH_CONTACT_TAB_MORE_FIND_PROFILE = 83
    const val SUB_FROM_SEARCH_FIND_PROFILE_TAB = 82
    const val SUB_FROM_SEARCH_MESSAGE_TAB_MORE_FIND_PROFILE = 84
    const val SUB_FROM_SEARCH_NEW_FRIEND_MORE_FIND_PROFILE = 85
    const val SUB_FROM_SEARCH_OTHER = 89
    const val SUB_FROM_SEARCH_TAB = 81
    const val SUB_FROM_SETTING_ME_AVATAR = 121
    const val SUB_FROM_SETTING_ME_OTHER = 129
    const val SUB_FROM_SHARE_CARD_C2C = 101
    const val SUB_FROM_SHARE_CARD_OTHER = 109
    const val SUB_FROM_SHARE_CARD_TROOP = 102
    const val SUB_FROM_TYPE_DEFAULT = 0

    suspend fun vote(target: Long, count: Int): Result<Unit> {
        if(count !in 1 .. 20) {
            return Result.failure(IllegalArgumentException("vote count must be in 1 .. 20"))
        }
        val card = CardSvc.getProfileCard(target.toString()).onFailure {
            return Result.failure(RuntimeException("unable to fetch contact info"))
        }.getOrThrow()
        sendExtra("VisitorSvc.ReqFavorite") {
            it.putLong(moe.fuqiuluo.shamrock.remote.service.data.profile.ProfileProtocolConst.PARAM_SELF_UIN, currentUin.toLong())
            it.putLong(moe.fuqiuluo.shamrock.remote.service.data.profile.ProfileProtocolConst.PARAM_TARGET_UIN, target)
            it.putByteArray("vCookies", card.vCookies)
            it.putBoolean("nearby_people", true)
            it.putInt("favoriteSource", FROM_CONTACTS_TAB)
            it.putInt("iCount", count)
            it.putInt("from", FROM_CONTACTS_TAB)
        }
        return Result.success(Unit)
    }
}
