package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.SimpleTroopMemberInfo
import moe.fuqiuluo.shamrock.remote.service.data.push.MemberRole
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler
import tencent.im.troop.honor.troop_honor

@OneBotHandler("get_group_member_list")
internal object GetTroopMemberList : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val refresh = session.getBooleanOrDefault("refresh", session.getBooleanOrDefault("no_cache", false))
        return invoke(groupId, refresh, session.echo)
    }

    suspend operator fun invoke(
        groupId: Long,
        refresh: Boolean,
        echo: JsonElement = EmptyJsonString
    ): String {
        val memberList = GroupSvc.getGroupMemberList(groupId, refresh).onFailure {
            return error(it.message ?: "unknown error", echo, arrayResult = true)
        }.getOrThrow()
//        val prohibitedMemberList = GroupSvc.getProhibitedMemberList(groupId)
//            .getOrDefault(arrayListOf())
//            .associate { it.memberUin to it.shutuptimestap.toLong() }
        return ok(arrayListOf<SimpleTroopMemberInfo>().apply {
            memberList.values.forEach { info ->
                add(
                    SimpleTroopMemberInfo(
                        uin = info.uin,
                        name = info.nick ?: "",
                        showName = info.cardName,
                        cardName = info.cardName,
                        distance = 0,
                        honor = info.groupHonor.let { bytes ->
                            val honor = troop_honor.GroupUserCardHonor()
                            honor.mergeFrom(bytes)
                            honor.id.get()
                        },
                        joinTime = info.joinTime.toLong(),
                        lastActiveTime = info.lastSpeakTime.toLong(),
                        uniqueName = info.memberSpecialTitle,
                        groupId = groupId,
                        nick = info.nick ?: "",
                        sex = "unknown",
                        area = "",
                        lastSentTime = info.lastSpeakTime.toLong(),
                        level = info.memberLevel,
                        role = info.role.let { role ->
                            when (role) {
                                com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole.OWNER -> MemberRole.Owner
                                com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole.ADMIN -> MemberRole.Admin
                                else -> MemberRole.Member
                            }
                        },
                        unfriendly = false,
                        title = info.memberSpecialTitle ?: "",
                        titleExpireTime = info.specialTitleExpireTime.toInt(),
                        cardChangeable = info.role == com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole.ADMIN,
                        age = 0,
                        shutUpTimestamp = info.shutUpTime.toLong()
                    )
                )

            }
        }, echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id")
}

