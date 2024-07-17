package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.mobileqq.data.Card
import com.tencent.mobileqq.data.troop.TroopMemberInfo
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole as NtMemberRole
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.SimpleTroopMemberInfo
import moe.fuqiuluo.shamrock.remote.service.data.push.MemberRole
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.utils.PlatformUtils.QQ_9_0_65_VER
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_group_member_info")
internal object GetTroopMemberInfo : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val userId = session.getLong("user_id")
        val groupId = session.getLong("group_id")
        val refresh = session.getBooleanOrDefault("refresh", session.getBooleanOrDefault("no_cache", false))

        return invoke(groupId, userId, refresh, session.echo)
    }

    suspend operator fun invoke(
        groupId: Long,
        userId: Long,
        refresh: Boolean,
        echo: JsonElement = EmptyJsonString
    ): String {
        val info = GroupSvc.getTroopMemberInfoByUinV2(groupId, userId, refresh).onFailure {
            return error(it.message ?: "unknown error", echo)
        }.getOrThrow()

        val code = PlatformUtils.getQQVersionCode()
        return ok(when {
            (code >= QQ_9_0_65_VER) -> ntQQApiData(groupId, userId, info)
            else -> oldQQApiData(groupId, userId, info)
        }, echo)
    }

    private suspend fun ntQQApiData(groupId: Long, userId: Long, info: TroopMemberInfo): SimpleTroopMemberInfo {
        return SimpleTroopMemberInfo(
            uin = info.memberuin.toLong(),
            name = info.friendnick.ifNullOrEmpty(info.autoremark) ?: "",
            showName = info.troopnick.ifNullOrEmpty(info.troopColorNick),
            cardName = info.troopnick.ifNullOrEmpty(info.troopColorNick),
            distance = 0,
            honor = GroupSvc.parseHonor(info.honorList),
            joinTime = info.join_time,
            lastActiveTime = info.last_active_time,
            uniqueName = null,
            groupId = groupId,
            nick = info.friendnick.ifNullOrEmpty(info.autoremark) ?: "",
            sex = "unknown",
            area = "",
            lastSentTime = info.last_active_time,
            level = info.level,
            role = when(info.role) {
                NtMemberRole.UNSPECIFIED -> MemberRole.Unknown
                NtMemberRole.STRANGER -> MemberRole.Stranger
                NtMemberRole.MEMBER -> MemberRole.Member
                NtMemberRole.ADMIN -> MemberRole.Admin
                NtMemberRole.OWNER -> MemberRole.Owner
                null -> MemberRole.Unknown
            },
            unfriendly = false,
            title = "",
            titleExpireTime = 0,
            cardChangeable = info.role == NtMemberRole.OWNER || info.role == NtMemberRole.ADMIN,
            age = 0,
            shutUpTimestamp = 0L
        ).also {
            if (info.specialTitleInfo != null) {
                it.uniqueName = info.specialTitleInfo?.specialTitle ?: ""
                it.title = info.specialTitleInfo?.specialTitle ?: ""
                it.titleExpireTime = info.specialTitleInfo?.expireTimeSec ?: 0
            }
        }
    }

    private suspend fun oldQQApiData(groupId: Long, userId: Long, info: TroopMemberInfo): SimpleTroopMemberInfo {
        return SimpleTroopMemberInfo(
            uin = info.memberuin.toLong(),
            name = info.friendnick.ifNullOrEmpty(info.autoremark) ?: "",
            showName = info.troopnick.ifNullOrEmpty(info.troopColorNick),
            cardName = info.troopnick.ifNullOrEmpty(info.troopColorNick),
            distance = 0,
            honor = GroupSvc.parseHonor(info.honorList),
            joinTime = info.join_time,
            lastActiveTime = info.last_active_time,
            uniqueName = info.mUniqueTitle,
            groupId = groupId,
            nick = info.friendnick.ifNullOrEmpty(info.autoremark) ?: "",
            sex = when (info.sex.toShort()) {
                Card.FEMALE -> "female"
                Card.MALE -> "male"
                else -> "unknown"
            },
            area = "",
            lastSentTime = info.last_active_time,
            level = info.level,
            role = GroupSvc.getMemberRole(groupId, userId),
            unfriendly = false,
            title = info.mUniqueTitle ?: "",
            titleExpireTime = info.mUniqueTitleExpire,
            cardChangeable = GroupSvc.isAdmin(groupId),
            age = info.age.toInt(),
            shutUpTimestamp = 0L
        ).also {
            if (PlatformUtils.getQQVersionCode() <= QQ_9_0_65_VER) {
                it.distance = info.distance
                it.area = info.alias
            }
        }
    }

    override val requiredParams: Array<String> = arrayOf("user_id", "group_id")
}

