package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.mobileqq.data.Card
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.qqinterface.servlet.CardSvc
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object GetStrangerInfo: IActionHandler() {
    override fun path(): String = "_get_stranger_info"

    override val alias: Array<String> = arrayOf("get_stranger_info")

    override suspend fun internalHandle(session: ActionSession): String {
        val uid = session.getString("user_id")
        return invoke(uid, session.echo)
    }

    suspend operator fun invoke(userId: String, echo: JsonElement = EmptyJsonString): String {
        val info = CardSvc.refreshAndGetProfileCard(userId).onFailure {
            return logic("unable to fetch stranger info", echo)
        }.getOrThrow()

        return ok(info.run {
            StrangerInfo(
                uid = userId,
                nickname = strNick,
                age = age,
                sex = when(shGender) {
                    Card.FEMALE -> "female"
                    Card.MALE -> "male"
                    else -> "unknown"
                },
                level = iQQLevel,
                loginDays = lLoginDays,
                qid = qid ?: "",
                vote = lVoteCount,
                wzryHonor = wzryHonorInfo?.toHexString(),
                ext = StrangerInfoExt(
                    addSrcId, addSrcName, addSubSrcId,

                    allowCalInteractive, allowClick, allowPeopleSee, authState,

                    bBigClubVipOpen, bHollywoodVipOpen, bQQVipOpen, bSuperQQOpen, bSuperVipOpen,

                    bVoted, babyQSwitch, bindPhoneInfo, cardId, cardType, category, clothesId,

                    coverUrl, declaration, defaultCardId, diyComplicatedInfo, diyDefaultText,

                    diyText, diyTextDegree, diyTextFontId, diyTextHeight, diyTextWidth,

                    diyTextLocX, diyTextLocY, dressUpIsOn, encId, enlargeQzonePic,

                    extendFriendEntryAddFriend, extendFriendEntryContact, extendFriendFlag,

                    extendFriendQuestion, extendFriendVoiceDuration, favoriteSource, feedPreviewTime,

                    fontId, fontType, qidBgUrl, qidColor, qidLogoUrl, qqCardIsOn, schoolId,

                    schoolName, schoolVerifiedFlag, showPublishButton, singer, songDuration,

                    songId, songName
                )
            )
        }, echo)
    }

    override val requiredParams: Array<String> = arrayOf("user_id")

    @Serializable
    data class StrangerInfo(
        @SerialName("user_id") val uid: String,
        @SerialName("nickname") val nickname: String,
        @SerialName("age") val age: Byte,
        @SerialName("sex") val sex: String,
        @SerialName("level") val level: Int,
        @SerialName("login_days") val loginDays: Long,
        @SerialName("qid") val qid: String?,
        @SerialName("vote") val vote: Long,
        @SerialName("wzry_honor") val wzryHonor: String?,
        @SerialName("ext") val ext: StrangerInfoExt
    )

    @Serializable
    data class StrangerInfoExt(
        @SerialName("add_src_id") val addSrcId: Long,
        @SerialName("add_src_name") val addSrcName: String?,
        @SerialName("add_sub_src_id") val addSubSrcId: Long,

        @SerialName("allow_cal_interactive") val allowCalInteractive: Boolean,
        @SerialName("allow_click") val allowClick: Boolean,
        @SerialName("allow_people_see") val allowPeopleSee: Boolean,
        @SerialName("auth_state") val authState: Long,

        @SerialName("big_club_vip_open") val bBigClubVipOpen: Byte,
        @SerialName("hollywood_vip_open") val bHollywoodVipOpen: Byte,
        @SerialName("qq_vip_open") val bQQVipOpen: Byte,
        @SerialName("super_qq_open") val bSuperQQOpen: Byte,
        @SerialName("super_vip_open") val bSuperVipOpen: Byte,

        @SerialName("voted") val bVoted: Byte,
        @SerialName("baby_q_switch") val babyQSwitch: Boolean,

        @SerialName("bind_phone_info") val bindPhoneInfo: String?,

        @SerialName("card_id") val cardId: Long,
        @SerialName("card_type") val cardType: Int,
        @SerialName("category") val category: Int,
        @SerialName("clothes_id") val clothesId: Int,

        @SerialName("cover_url") val coverUrl: String?,
        @SerialName("declaration") val declaration: String?,
        @SerialName("default_card_id") val defaultCardId: Int,

        @SerialName("diy_complicated_info") val diyComplicatedInfo: String?,
        @SerialName("diy_default_text") val diyDefaultText: String?,
        @SerialName("diy_text") val diyText: String?,
        @SerialName("diy_text_degree") val diyTextDegree: Float,
        @SerialName("diy_text_font_id") val diyTextFontId: Int,
        @SerialName("diy_text_height") val diyTextHeight: Float,
        @SerialName("diy_text_width") val diyTextWidth: Float,
        @SerialName("diy_text_loc_x") val diyTextLocX: Float,
        @SerialName("diy_text_loc_y") val diyTextLocY: Float,

        @SerialName("dress_up_is_on") val dressUpIsOn: Boolean,
        @SerialName("enc_id") val encId: String?,
        @SerialName("enlarge_qzone_pic") val enlargeQzonePic: Int,
        @SerialName("extend_friend_entry_add_friend") val extendFriendEntryAddFriend: Short,
        @SerialName("extend_friend_entry_contact") val extendFriendEntryContact: Short,
        @SerialName("extend_friend_flag") val extendFriendFlag: Int,
        @SerialName("extend_friend_question") val extendFriendQuestion: Short,
        @SerialName("extend_friend_voice_duration") val extendFriendVoiceDuration: Int,
        @SerialName("favorite_source") val favoriteSource: Int,
        @SerialName("feed_preview_time") val feedPreviewTime: Long,
        @SerialName("font_id") val fontId: Int,
        @SerialName("font_type") val fontType: Int,

        @SerialName("qid_bg_url") val qidBgUrl: String?,
        @SerialName("qid_color") val qidColor: String?,
        @SerialName("qid_logo_url") val qidLogoUrl: String?,

        @SerialName("qq_card_is_on") val qqCardIsOn: Boolean,

        @SerialName("school_id") val schoolId: String?,
        @SerialName("school_name") val schoolName: String?,
        @SerialName("school_verified_flag") val schoolVerifiedFlag: Boolean,

        @SerialName("show_publish_button") val showPublishButton: Boolean,

        @SerialName("singer") val singer: String?,
        @SerialName("song_dura") val songDuration: Long,

        @SerialName("song_id") val songId: String?,
        @SerialName("song_name") val songName: String?,


    )
}