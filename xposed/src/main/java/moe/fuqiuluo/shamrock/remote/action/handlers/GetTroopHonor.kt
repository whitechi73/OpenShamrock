package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.helper.TroopHonorHelper.decodeHonor
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
import moe.fuqiuluo.symbols.OneBotHandler
import tencent.im.troop.honor.troop_honor

@OneBotHandler("get_group_honor_info", ["get_troop_honor_info"])
internal object GetTroopHonor: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getLong("group_id")
        val refresh = session.getBooleanOrDefault("refresh", session.getBooleanOrDefault("no_cache", false))
        return invoke(groupId, refresh, session.echo)
    }

    suspend operator fun invoke(groupId: Long, refresh: Boolean, echo: JsonElement = EmptyJsonString): String {
        val honorInfo = ArrayList<GroupMemberHonor>()

        GroupSvc.getGroupMemberList(groupId, refresh).onFailure {
            return error(it.message ?: "unknown error", echo)
        }.onSuccess { memberList ->
            memberList.values.forEach { info ->
                info.groupHonor.let { bytes ->
                    val honor = troop_honor.GroupUserCardHonor()
                    honor.mergeFrom(bytes)
                    honor.id.get()
                }.forEach {
                    val honor = decodeHonor(info.uin, it, 0)
                    if (honor != null) {
                        honor.nick = info.nick.ifEmpty { info.cardName }
                        honorInfo.add(honor)
                    }
                }
            }
        }

        return ok(GroupAllHonor(
            groupId = groupId,
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

    override val requiredParams: Array<String> = arrayOf("group_id")
}