package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.SimpleTroopInfo
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.symbols.OneBotHandler

@OneBotHandler("get_group_list")
internal object GetTroopList : IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val refresh = session.getBooleanOrDefault("refresh", session.getBooleanOrDefault("no_cache", true))
        return invoke(refresh, session.echo)
    }

    suspend operator fun invoke(refresh: Boolean, echo: JsonElement = EmptyJsonString): String {
        val troopList = arrayListOf<SimpleTroopInfo>()
        GroupSvc.getGroupList(refresh).onFailure {
            return error(it.message ?: "unknown error", echo, arrayResult = true)
        }.onSuccess { troops ->
            troops.forEach { groupInfo ->
                if (groupInfo.troopcode.isNullOrEmpty()) return@forEach

                troopList.add(
                    SimpleTroopInfo(
                        groupId = groupInfo.troopuin.toLong(),
                        groupUin = groupInfo.troopcode.toLong(),
                        groupName = groupInfo.troopname ?: groupInfo.newTroopName
                        ?: groupInfo.oldTroopName,
                        groupRemark = groupInfo.troopRemark,
                        adminList = GroupSvc.getAdminList(groupInfo.troopuin.toLong(), true),
                        classText = groupInfo.mGroupClassExtText,
                        isFrozen = groupInfo.mIsFreezed != 0,
                        maxMember = groupInfo.wMemberMax,
                        memNum = groupInfo.wMemberNum,
                        memCount = groupInfo.wMemberNum,
                        maxNum = groupInfo.wMemberMax
                    )
                )
            }
        }
        return ok(troopList, echo)
    }
}