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
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_group_member_list")
internal object GetTroopMemberList : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        val refresh = session.getBooleanOrDefault("refresh", session.getBooleanOrDefault("no_cache", false))
        return invoke(groupId, refresh, session.echo)
    }

    suspend operator fun invoke(
        groupId: String,
        refresh: Boolean,
        echo: JsonElement = EmptyJsonString
    ): String {
        val memberList = GroupSvc.getGroupMemberList(groupId, refresh).onFailure {
            return error(it.message ?: "unknown error", echo, arrayResult = true)
        }.getOrThrow()
        val prohibitedMemberList = GroupSvc.getProhibitedMemberList(groupId.toLong())
            .getOrDefault(arrayListOf())
            .associate { it.memberUin to it.shutuptimestap.toLong() }
        return ok(arrayListOf<SimpleTroopMemberInfo>().apply {
            memberList.forEach { info ->
                if (info.memberuin != "0") {
                    add(
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
                                GroupSvc.getOwner(groupId)
                                    .toString() == info.memberuin -> MemberRole.Owner
                                info.memberuin.toLong() in GroupSvc.getAdminList(groupId) -> MemberRole.Admin
                                else -> MemberRole.Member
                            },
                            unfriendly = false,
                            title = info.mUniqueTitle ?: "",
                            titleExpireTime = info.mUniqueTitleExpire,
                            cardChangeable = GroupSvc.isAdmin(groupId),
                            age = 0,
                            shutUpTimestamp = prohibitedMemberList[info.memberuin.toLong()] ?: 0L
                        )
                    )
                }
            }
        }, echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id")
}

