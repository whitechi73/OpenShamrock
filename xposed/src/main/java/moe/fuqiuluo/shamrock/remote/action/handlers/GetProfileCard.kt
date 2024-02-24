package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.mobileqq.data.Card
import moe.fuqiuluo.qqinterface.servlet.CardSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.structures.Status
import moe.fuqiuluo.shamrock.remote.structures.resultToString
import moe.fuqiuluo.shamrock.remote.service.data.VipInfo
import moe.fuqiuluo.shamrock.remote.service.data.VipType
import moe.fuqiuluo.shamrock.remote.service.data.profile.Location
import moe.fuqiuluo.shamrock.remote.service.data.profile.ProfileCard
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_user_info",  ["get_profile_card"])
internal object GetProfileCard: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val uin = session.getLong("user_id")
        val refresh = session.getBooleanOrDefault("refresh", session.getBooleanOrDefault("no_cache", false))

        var card: Card? = CardSvc.getProfileCard(uin).getOrNull()
        if (refresh || !card.ok()) {
            card = CardSvc.refreshAndGetProfileCard(uin).getOrNull()
        }
        if (!card.ok()) {
            return logic("get profilecard error, please check your user_id or network", session.echo)
        }
        requireNotNull(card)

        return resultToString(true, Status.Ok, ProfileCard(
            uin = card.uin.toLong(),
            name = card.strNick,
            mail = card.strShowName ?: card.strEmail ?: "",
            remark = card.strReMark.let { if (it.isNullOrEmpty()) card.strAutoRemark else it },
            findMethod = card.addSrcName,
            displayName = card.strContactName,
            maxVoteCnt = card.bAvailVoteCnt,
            haveVoteCnt = card.bHaveVotedCnt,
            vipList = arrayListOf<VipInfo>().apply {
                if (card.bQQVipOpen == 1.toByte()) {
                    add(VipInfo(VipType.QQ_VIP, card.iQQVipLevel, card.iQQVipType, 0))
                }
                if (card.bSuperQQOpen == 1.toByte()) {
                    add(VipInfo(VipType.SUPER_QQ, card.iSuperQQLevel, card.iSuperQQType, 0))
                }
                if (card.bSuperVipOpen == 1.toByte()) {
                    add(VipInfo(VipType.SUPER_VIP, card.iSuperVipLevel, card.iSuperVipType, card.lSuperVipTemplateId))
                }
                if (card.bHollywoodVipOpen == 1.toByte()) {
                    add(VipInfo(VipType.QQ_VIDEO, card.iHollywoodVipLevel, card.iHollywoodVipType, 0))
                }
                if (card.bBigClubVipOpen == 1.toByte()) {
                    add(VipInfo(VipType.BIG_VIP, card.iBigClubVipLevel, card.iBigClubVipType, card.lBigClubTemplateId))
                }
                if (card.isYellowDiamond || card.isSuperYellowDiamond) {
                    add(VipInfo(VipType.YELLOW_VIP, card.yellowLevel, 0, 0))
                }
            },
            hobbyEntry = card.hobbyEntry,
            level = card.iQQLevel,
            birthday = card.lBirthday,
            loginDay = card.lLoginDays,
            voteCnt = card.lVoteCount,
            qid = card.qid,
            schoolVerified = card.schoolVerifiedFlag,
            location = Location(
                card.strCity, card.strCompany, card.strCountry, card.strProvince, card.strHometownDesc, card.strSchool
            ),
            cookie = card.vCookies
        ), echo = session.echo)
    }

    override val requiredParams: Array<String> = arrayOf("user_id")

    private fun Card?.ok(): Boolean {
        return this != null && !strNick.isNullOrBlank()
    }
}