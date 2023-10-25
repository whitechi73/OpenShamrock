package moe.fuqiuluo.shamrock.remote.action.handlers

import com.tencent.mobileqq.data.Card
import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.SimpleTroopMemberInfo
import moe.fuqiuluo.shamrock.remote.service.data.push.MemberRole
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty

internal object GetTroopMemberInfo : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val uin = session.getString("user_id")
        val groupId = session.getString("group_id")
        val refresh = session.getBooleanOrDefault("refresh", false)

        return invoke(groupId, uin, refresh, session.echo)
    }

    suspend operator fun invoke(
        groupId: String,
        uin: String,
        refresh: Boolean,
        echo: JsonElement = EmptyJsonString
    ): String {
        val info = GroupSvc.getTroopMemberInfoByUin(groupId, uin, refresh).onFailure {
            return error(it.message ?: "unknown error", echo)
        }.getOrThrow()

        return ok(
            SimpleTroopMemberInfo(
                uin = info.memberuin.toLong(),
                name = info.friendnick.ifNullOrEmpty(info.autoremark) ?: "",
                showName = info.troopnick.ifNullOrEmpty(info.troopColorNick),
                cardName = info.troopnick.ifNullOrEmpty(info.troopColorNick),
                distance = info.distance,
                honor = GroupSvc.parseHonor(info.honorList),
                joinTime = info.join_time,
                lastActiveTime = info.last_active_time,
                uniqueName = info.mUniqueTitle,
                groupId = groupId.toLong(),
                nick = info.friendnick.ifNullOrEmpty(info.autoremark) ?: "",
                sex = when (info.sex.toShort()) {
                    Card.FEMALE -> "female"
                    Card.MALE -> "male"
                    else -> "unknown"
                },
                area = info.alias ?: "",
                lastSentTime = info.last_active_time,
                level = info.level,
                role = when {
                    GroupSvc.getOwner(groupId).toString() == uin -> MemberRole.Owner
                    uin.toLong() in GroupSvc.getAdminList(groupId) -> MemberRole.Admin
                    else -> MemberRole.Member
                },
                unfriendly = false,
                title = info.mUniqueTitle ?: "",
                titleExpireTime = info.mUniqueTitleExpire,
                cardChangeable = GroupSvc.isAdmin(groupId)
            ), echo
        )
    }

    override val requiredParams: Array<String> = arrayOf("user_id", "group_id")

    override fun path(): String = "get_group_member_info"
}

