package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.GroupAllHonor
import moe.fuqiuluo.shamrock.remote.service.data.GroupMemberHonor
import moe.fuqiuluo.shamrock.remote.service.data.HONOR_GROUP_FIRE
import moe.fuqiuluo.shamrock.remote.service.data.HONOR_GROUP_FLAME
import moe.fuqiuluo.shamrock.remote.service.data.HONOR_HAPPY
import moe.fuqiuluo.shamrock.remote.service.data.HONOR_NEWBIE
import moe.fuqiuluo.shamrock.remote.service.data.HONOR_TALKATIVE
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object GetTroopHonor: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        val refresh = session.getBooleanOrDefault("refresh", false)
        return invoke(groupId, refresh, session.echo)
    }

    suspend operator fun invoke(groupId: String, refresh: Boolean, echo: JsonElement = EmptyJsonString): String {
        val honorInfo = ArrayList<GroupMemberHonor>()

        GroupSvc.getGroupMemberList(groupId, refresh).onFailure {
            return error(it.message ?: "unknown error", echo)
        }.onSuccess { memberList ->
            memberList.forEach { member ->
                GroupSvc.parseHonor(member.honorList).forEach {
                    val honor = nativeDecodeHonor(member.memberuin, it, member.mHonorRichFlag)
                    if (honor != null) {
                        honor.nick = member.troopnick.ifEmpty { member.friendnick }
                        honorInfo.add(honor)
                    }
                }
            }
        }

        return ok(GroupAllHonor(
            groupId = groupId.toLong(),
            currentTalkActive = honorInfo.firstOrNull {
                it.id == HONOR_TALKATIVE
            },
            talkativeList = honorInfo.filter { it.id == HONOR_TALKATIVE },
            performerList = honorInfo.filter { it.id == HONOR_GROUP_FIRE },
            legendList = honorInfo.filter { it.id == HONOR_GROUP_FLAME },
            strongNewbieList = honorInfo.filter { it.id == HONOR_NEWBIE },
            emotionList = honorInfo.filter { it.id == HONOR_HAPPY },
            all = honorInfo
        ), echo)
    }

    override val requiredParams: Array<String> = arrayOf("group_id", "refresh")

    override fun path(): String = "get_group_honor_info"

    private external fun nativeDecodeHonor(userId: String, honorId: Int, honorFlag: Byte): GroupMemberHonor?
}