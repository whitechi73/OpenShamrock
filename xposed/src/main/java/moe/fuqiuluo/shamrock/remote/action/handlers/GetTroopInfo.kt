package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.remote.service.data.SimpleTroopInfo
import moe.fuqiuluo.shamrock.tools.EmptyJsonString

internal object GetTroopInfo: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        val groupId = session.getString("group_id")
        val refresh = session.getBooleanOrDefault("refresh", false)
        return invoke(groupId, refresh, session.echo)
    }

    suspend operator fun invoke(groupId: String, refresh: Boolean, echo: JsonElement = EmptyJsonString): String {
        val groupInfo = GroupSvc.getGroupInfo(groupId, refresh).getOrNull()
        return if ( groupInfo == null || groupInfo.troopuin.isNullOrBlank()) {
            logic("Unable to obtain group information", echo)
        } else {
            ok(SimpleTroopInfo(
                groupId = groupInfo.troopuin.toLong(),
                groupUin = groupInfo.troopcode.toLong(),
                groupName = groupInfo.troopname ?: groupInfo.newTroopName ?: groupInfo.oldTroopName,
                groupRemark = groupInfo.troopRemark,
                adminList = GroupSvc.getAdminList(groupId, true),
                classText = groupInfo.mGroupClassExtText,
                isFrozen = groupInfo.mIsFreezed != 0,
                maxMember = groupInfo.wMemberMax,
                memNum = groupInfo.wMemberNum,
                memCount = groupInfo.wMemberNum,
                maxNum = groupInfo.wMemberMax,
            ), echo)
        }
    }

    override val requiredParams: Array<String> = arrayOf("group_id")

    override fun path(): String = "get_group_info"
}