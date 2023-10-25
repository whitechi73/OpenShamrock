package moe.fuqiuluo.shamrock.remote.service.listener

import com.tencent.qqnt.kernel.nativeinterface.GProAVChannelConfig
import com.tencent.qqnt.kernel.nativeinterface.GProAVRoomOptPushInfo
import com.tencent.qqnt.kernel.nativeinterface.GProAVUserStateChangeInfo
import com.tencent.qqnt.kernel.nativeinterface.GProCategoryChannelIdList
import com.tencent.qqnt.kernel.nativeinterface.GProChannel
import com.tencent.qqnt.kernel.nativeinterface.GProChannelState
import com.tencent.qqnt.kernel.nativeinterface.GProChannelUserChangeInfo
import com.tencent.qqnt.kernel.nativeinterface.GProClientIdentity
import com.tencent.qqnt.kernel.nativeinterface.GProCreateGuildGuideInfo
import com.tencent.qqnt.kernel.nativeinterface.GProDailyRecommendPush
import com.tencent.qqnt.kernel.nativeinterface.GProDiscoveryStateChangedMsg
import com.tencent.qqnt.kernel.nativeinterface.GProGlobalBanner
import com.tencent.qqnt.kernel.nativeinterface.GProGuild
import com.tencent.qqnt.kernel.nativeinterface.GProGuildData
import com.tencent.qqnt.kernel.nativeinterface.GProGuildInit
import com.tencent.qqnt.kernel.nativeinterface.GProGuildListSortInfo
import com.tencent.qqnt.kernel.nativeinterface.GProGuildMemberCountInfo
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRole
import com.tencent.qqnt.kernel.nativeinterface.GProGuildSpeakableThreshold
import com.tencent.qqnt.kernel.nativeinterface.GProGuildStateRspInfo
import com.tencent.qqnt.kernel.nativeinterface.GProGuildUserProfile
import com.tencent.qqnt.kernel.nativeinterface.GProHeartbeatRsq
import com.tencent.qqnt.kernel.nativeinterface.GProLiveRoomInfo
import com.tencent.qqnt.kernel.nativeinterface.GProMedal
import com.tencent.qqnt.kernel.nativeinterface.GProMember
import com.tencent.qqnt.kernel.nativeinterface.GProNoticeRedPoint
import com.tencent.qqnt.kernel.nativeinterface.GProPollingChannelState
import com.tencent.qqnt.kernel.nativeinterface.GProPollingData
import com.tencent.qqnt.kernel.nativeinterface.GProPreventAddictionPushInfo
import com.tencent.qqnt.kernel.nativeinterface.GProProgramInfo
import com.tencent.qqnt.kernel.nativeinterface.GProQQMsgListChannel
import com.tencent.qqnt.kernel.nativeinterface.GProQQMsgListGuild
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendGuildInfo
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendGuildPersonalSetting
import com.tencent.qqnt.kernel.nativeinterface.GProRoleMemberChangeInfo
import com.tencent.qqnt.kernel.nativeinterface.GProSchemeConfig
import com.tencent.qqnt.kernel.nativeinterface.GProScreenShareUser
import com.tencent.qqnt.kernel.nativeinterface.GProSecurityResult
import com.tencent.qqnt.kernel.nativeinterface.GProSendGiftEventData
import com.tencent.qqnt.kernel.nativeinterface.GProStickyChannel
import com.tencent.qqnt.kernel.nativeinterface.GProTopMsg
import com.tencent.qqnt.kernel.nativeinterface.GProUser
import com.tencent.qqnt.kernel.nativeinterface.GProUserChannelState
import com.tencent.qqnt.kernel.nativeinterface.GProUserGiftRankInfo
import com.tencent.qqnt.kernel.nativeinterface.GProVoiceSmobaGameRoomManageSysMsg
import com.tencent.qqnt.kernel.nativeinterface.GProVoiceSmobaGameUserActionPush
import com.tencent.qqnt.kernel.nativeinterface.GProWorldState
import com.tencent.qqnt.kernel.nativeinterface.GProYLGameTeamInfo
import com.tencent.qqnt.kernel.nativeinterface.IKernelGuildListener
import moe.fuqiuluo.shamrock.helper.LogCenter
import java.util.ArrayList
import java.util.HashMap

internal object KernelGuildListener: IKernelGuildListener {
    override fun onAVChannelThemeUpdate(
        j2: Long,
        j3: Long,
        gProAVChannelConfig: GProAVChannelConfig?
    ) {

    }

    override fun onAVUserInfoChangeNotifyForAll(gProChannelUserChangeInfo: GProChannelUserChangeInfo?) {
        
    }

    override fun onAllGuildChannelListFetchCompleted() {
        
    }

    override fun onAnchorStatusChange(j2: Long, j3: Long, i2: Int) {
        
    }

    override fun onAppChannelPreInfosUpdated(
        j2: Long,
        arrayList: ArrayList<Long>?,
        arrayList2: ArrayList<Long>?
    ) {
        
    }

    override fun onAppInfosUpdated() {
        
    }

    override fun onBatchChannelListUpdated(arrayList: ArrayList<Long>?) {
        
    }

    override fun onBatchFetchRoleListUpdate(j2: Long, arrayList: ArrayList<GProGuildRole>?) {
        
    }

    override fun onBroadcastRoomClose(j2: Long, i2: Int, str: String?) {
        
    }

    override fun onBroadcastUserCountUpdate(j2: Long, i2: Int) {
        
    }

    override fun onChangeGuildNumber(j2: Long, str: String?, i2: Int) {
        
    }

    override fun onChannelInfoUpdated(i2: Int, str: String?, gProChannel: GProChannel?) {
        
    }

    override fun onChannelListUpdated(
        i2: Int,
        str: String?,
        j2: Long,
        i3: Int,
        hashMap: HashMap<Long, GProChannel>?,
        gProCategoryChannelIdList: GProCategoryChannelIdList?,
        arrayList: ArrayList<GProCategoryChannelIdList>?
    ) {
        
    }

    override fun onChannelUserPermissionChange(j2: Long, arrayList: ArrayList<Long>?) {
        
    }

    override fun onDiscoveryStateChanged(gProDiscoveryStateChangedMsg: GProDiscoveryStateChangedMsg?) {
        
    }

    override fun onEnterSpeakQueueNotifyForAll(gProChannelUserChangeInfo: GProChannelUserChangeInfo?) {
        
    }

    override fun onGetSelfTinyId(j2: Long) {
        
    }

    override fun onGlobalBannerRemoved(gProGlobalBanner: GProGlobalBanner?) {
        
    }

    override fun onGlobalBannerUpdated(gProGlobalBanner: GProGlobalBanner?) {
        
    }

    override fun onGuildCreatorGuideUpdated(gProCreateGuildGuideInfo: GProCreateGuildGuideInfo?) {
        
    }

    override fun onGuildInfoUpdated(i2: Int, str: String?, gProGuild: GProGuild?, z: Boolean) {
        
    }

    override fun onGuildListUpdated(
        retcode: Int,
        why: String?,
        force: Boolean,
        guildIdList: ArrayList<Long>?,
        guildList: ArrayList<GProGuild>?,
        sortInfo: GProGuildListSortInfo?
    ) {

    }

    override fun onGuildUserAvatarMetasUpdated(j2: Long, arrayList: ArrayList<Long>?) {
        
    }

    override fun onGuildUserAvatarPendantsUpdated(hashMap: HashMap<Long, String>?) {
        
    }

    override fun onGuildUserChannelCategoryAdminListUpdated(j2: Long, arrayList: ArrayList<Long>?) {
        
    }

    override fun onGuildUserClientIdentitiesUpdated(j2: Long, arrayList: ArrayList<Long>?) {
        
    }

    override fun onGuildUserLevelRolesChanged(j2: Long, hashMap: HashMap<Long, Int>?) {
        
    }

    override fun onGuildUserMedalsUpdated(hashMap: HashMap<Long, String>?) {
        
    }

    override fun onGuildUserMemberNamesUpdated(j2: Long, hashMap: HashMap<Long, String>?) {
        
    }

    override fun onGuildUserNicknamesUpdated(hashMap: HashMap<Long, String>?) {
        
    }

    override fun onGuildUserTopRolesChanged(j2: Long, arrayList: ArrayList<Long>?) {
        
    }

    override fun onLocalMemberCountUpdate(j2: Long, j3: Long) {
        
    }

    override fun onMemberCountUpdate(gProGuildMemberCountInfo: GProGuildMemberCountInfo?) {
        
    }

    override fun onNativeUpdateSimpleProfileByMsg(
        j2: Long,
        j3: Long,
        j4: Long,
        j5: Long,
        j6: Long,
        j7: Long,
        i2: Int,
        str: String?,
        str2: String?,
        str3: String?,
        gProClientIdentity: GProClientIdentity?,
        j8: Long,
        str4: String?,
        gProMedal: GProMedal?
    ) {
        
    }

    override fun onNoticeListUpdate(gProNoticeRedPoint: GProNoticeRedPoint?, bArr: ByteArray?) {
        
    }

    override fun onOpenTelemetryMetricCountReport(
        str: String?,
        hashMap: HashMap<String, String>?,
        z: Boolean
    ) {
        
    }

    override fun onOpenTelemetryMetricTimeCostReport(
        str: String?,
        hashMap: HashMap<String, String>?,
        j2: Long
    ) {
        
    }

    override fun onOpenTelemetryTraceReport(str: String?, hashMap: HashMap<String, String>?) {
        
    }

    override fun onPollingResult(arrayList: ArrayList<GProPollingChannelState>?) {
        
    }

    override fun onPollingYLGameTeamInfo(gProYLGameTeamInfo: GProYLGameTeamInfo?) {
        
    }

    override fun onPushAVChannelAppMsg(str: String?) {
        
    }

    override fun onPushAVChannelConfigUpdate(
        j2: Long,
        j3: Long,
        gProAVChannelConfig: GProAVChannelConfig?
    ) {
        
    }

    override fun onPushAVChannelPlayListChange(
        j2: Long,
        j3: Long,
        str: String?,
        i2: Int,
        str2: String?
    ) {
        
    }

    override fun onPushAVHeartbeatRsp(i2: Int, str: String?, gProHeartbeatRsq: GProHeartbeatRsq?) {
        
    }

    override fun onPushAVRoomOptChange(gProAVRoomOptPushInfo: GProAVRoomOptPushInfo?) {
        
    }

    override fun onPushAVUserStateChange(gProAVUserStateChangeInfo: GProAVUserStateChangeInfo?) {
        
    }

    override fun onPushAddChannelSpeakPermission(j2: Long, j3: Long) {
        
    }

    override fun onPushAdminChanged(j2: Long, z: Boolean, j3: Long, j4: Long) {
        
    }

    override fun onPushAllowScreenShareInGuild(j2: Long, j3: Long, z: Boolean, j4: Long) {
        
    }

    override fun onPushAudioChannelUserEnter(j2: Long, j3: Long, gProUser: GProUser?, j4: Long) {
        
    }

    override fun onPushAudioChannelUserExit(j2: Long, j3: Long, j4: Long, j5: Long) {
        
    }

    override fun onPushAudioChannelUserPlatSwitch(
        j2: Long,
        j3: Long,
        j4: Long,
        i2: Int,
        i3: Int,
        str: String?,
        j5: Long
    ) {
        
    }

    override fun onPushBannedStatusChanged(
        j2: Long,
        z: Boolean,
        z2: Boolean,
        z3: Boolean,
        j3: Long
    ) {
        
    }

    override fun onPushBatchJoinChannel(j2: Long, arrayList: ArrayList<Long>?) {
        
    }

    override fun onPushBatchLeaveChannel(j2: Long, arrayList: ArrayList<Long>?) {
        
    }

    override fun onPushBussinessConfig(i2: Int, bArr: ByteArray?) {
        
    }

    override fun onPushCanceledSpeak(gProAVUserStateChangeInfo: GProAVUserStateChangeInfo?) {
        
    }

    override fun onPushChangeRoleMember(j2: Long, arrayList: ArrayList<GProRoleMemberChangeInfo>?) {
        
    }

    override fun onPushChannelAdminChange(
        j2: Long,
        j3: Long,
        i2: Int,
        arrayList: ArrayList<Long>?
    ) {
        
    }

    override fun onPushChannelCategoryChanged(gProGuildInit: GProGuildInit?) {
        
    }

    override fun onPushChannelCreated(j2: Long, j3: Long, gProGuildInit: GProGuildInit?) {
        
    }

    override fun onPushChannelDestroy(j2: Long, arrayList: ArrayList<Long>?, j3: Long) {
        
    }

    override fun onPushChannelStateChange(arrayList: ArrayList<GProChannelState>?) {
        
    }

    override fun onPushChannelTopMsgUpdated(
        j2: Long,
        j3: Long,
        j4: Long,
        arrayList: ArrayList<GProTopMsg>?,
        arrayList2: ArrayList<GProTopMsg>?
    ) {
        
    }

    override fun onPushChannelVisibleChanged(j2: Long, j3: Long, i2: Int, i3: Int) {
        
    }

    override fun onPushCreateGuild(
        j2: Long,
        gProGuild: GProGuild?,
        hashMap: HashMap<Long, GProChannel>?,
        gProCategoryChannelIdList: GProCategoryChannelIdList?,
        arrayList: ArrayList<GProCategoryChannelIdList>?
    ) {
        
    }

    override fun onPushCreateRole(j2: Long, arrayList: ArrayList<GProGuildRole>?) {
        
    }

    override fun onPushDeleteRole(j2: Long, arrayList: ArrayList<GProGuildRole>?) {
        
    }

    override fun onPushDestroyGuild(j2: Long) {
        
    }

    override fun onPushDirectMsgSwitchUpdate(i2: Int) {
        
    }

    override fun onPushGuildPermissionChanged(j2: Long, arrayList: ArrayList<Int>?) {
        
    }

    override fun onPushGuildStateChange(
        i2: Int,
        str: String?,
        gProGuildStateRspInfo: GProGuildStateRspInfo?
    ) {
        
    }

    override fun onPushInvitationRefused(j2: Long, j3: Long, j4: Long, str: String?) {
        
    }

    override fun onPushInviteMemberEvent(
        j2: Long,
        j3: Long,
        j4: Long,
        gProSchemeConfig: GProSchemeConfig?
    ) {
        
    }

    override fun onPushInvitedToSpeak(gProAVUserStateChangeInfo: GProAVUserStateChangeInfo?) {
        
    }

    override fun onPushJoinChannel(j2: Long, j3: Long, arrayList: ArrayList<Long>?) {
        
    }

    override fun onPushJoinGuild(
        j2: Long,
        j3: Long,
        j4: Long,
        i2: Int,
        gProGuild: GProGuild?,
        hashMap: HashMap<Long, GProChannel>?,
        gProCategoryChannelIdList: GProCategoryChannelIdList?,
        arrayList: ArrayList<GProCategoryChannelIdList>?,
        i3: Int
    ) {
        
    }

    override fun onPushJoinGuildFail(j2: Long, j3: Long, i2: Int, i3: Int, str: String?) {
        
    }

    override fun onPushKickOffGuild(j2: Long, j3: Long, j4: Long, i2: Int) {
        
    }

    override fun onPushKickOutAudioChannel(
        j2: Long,
        j3: Long,
        j4: Long,
        j5: Long,
        i2: Int,
        str: String?,
        i3: Int,
        j6: Long
    ) {
        
    }

    override fun onPushLeaveChannel(j2: Long, j3: Long, arrayList: ArrayList<Long>?) {
        
    }

    override fun onPushLiveChannelAnchorIdentityChange(j2: Long, j3: Long, i2: Int) {
        
    }

    override fun onPushLiveRoomInfoChange(j2: Long, j3: Long, str: String?, str2: String?) {
        
    }

    override fun onPushLiveRoomStatusChangeMsg(
        j2: Long,
        j3: Long,
        j4: Long,
        str: String?,
        j5: Long,
        i2: Int,
        i3: Int,
        gProProgramInfo: GProProgramInfo?,
        j6: Long,
        gProLiveRoomInfo: GProLiveRoomInfo?
    ) {
        
    }

    override fun onPushMemberTopRoleChanged(j2: Long, j3: Long, gProGuildRole: GProGuildRole?) {
        
    }

    override fun onPushMemberTopRoleInChannelChanged(
        j2: Long,
        j3: Long,
        j4: Long,
        gProGuildRole: GProGuildRole?
    ) {
        
    }

    override fun onPushModifyRole(j2: Long, j3: Long, gProGuildRole: GProGuildRole?) {
        
    }

    override fun onPushMsgRecvTypeChanged(j2: Long, j3: Long, j4: Long, i2: Int) {
        
    }

    override fun onPushNotifySwitchUpdate(j2: Long, j3: Long, i2: Int) {
        
    }

    override fun onPushPermissionInGuild(j2: Long, j3: Long, z: Boolean, j4: Long) {
        
    }

    override fun onPushPreventAddictionInstructions(gProPreventAddictionPushInfo: GProPreventAddictionPushInfo?) {
        
    }

    override fun onPushQuitGuild(j2: Long, j3: Long) {
        
    }

    override fun onPushRemoveChannelSpeakPermission(j2: Long, j3: Long) {
        
    }

    override fun onPushSecurityResult(gProSecurityResult: GProSecurityResult?) {
        
    }

    override fun onPushSelfBannedSpeakChange(j2: Long, j3: Long, j4: Long, i2: Int) {
        
    }

    override fun onPushSendGiftEventNotify(gProSendGiftEventData: GProSendGiftEventData?) {
        
    }

    override fun onPushShutUpStateChanged(j2: Long, j3: Long) {
        
    }

    override fun onPushSortRole(j2: Long) {
        
    }

    override fun onPushSwitchLiveRoom(
        j2: Long,
        j3: Long,
        arrayList: ArrayList<GProMember>?,
        i2: Int
    ) {
        
    }

    override fun onPushUserChannelStateChange(gProUserChannelState: GProUserChannelState?) {
        
    }

    override fun onPushUserGiftRankChangeNotify(gProUserGiftRankInfo: GProUserGiftRankInfo?) {
        
    }

    override fun onPushUserHandUpResult(gProAVUserStateChangeInfo: GProAVUserStateChangeInfo?) {
        
    }

    override fun onPushUserMuteSeatInGuild(j2: Long, j3: Long, z: Boolean, j4: Long) {
        
    }

    override fun onPushUserScreenShare(
        j2: Long,
        j3: Long,
        arrayList: ArrayList<GProScreenShareUser>?,
        bArr: ByteArray?
    ) {
        
    }

    override fun onPushWorldStateChange(gProWorldState: GProWorldState?) {
        
    }

    override fun onQQMsgListChannelDataReady() {
        
    }

    override fun onQQMsgListChannelUpdated(
        arrayList: ArrayList<Int>?,
        arrayList2: ArrayList<GProQQMsgListChannel>?
    ) {
        
    }

    override fun onQQMsgListGuildUpdated(
        arrayList: ArrayList<Int>?,
        arrayList2: ArrayList<GProQQMsgListGuild>?
    ) {
        
    }

    override fun onRecommendGuildChannelListUpdate(gProGuildData: GProGuildData?) {
        
    }

    override fun onRecommendGuildEntryUpdateNotify() {
        
    }

    override fun onRecommendGuildInfoUpdate(gProRecommendGuildInfo: GProRecommendGuildInfo?) {
        
    }

    override fun onRecommendGuildJumpChannelNotify(gProDailyRecommendPush: GProDailyRecommendPush?) {
        
    }

    override fun onRecommendGuildPersonalSettingUpdate(gProRecommendGuildPersonalSetting: GProRecommendGuildPersonalSetting?) {
        
    }

    override fun onRecommendGuildPollingResult(arrayList: ArrayList<GProPollingData>?) {
        
    }

    override fun onRecommendGuildStickyTopUpdated(
        arrayList: ArrayList<GProStickyChannel>?,
        arrayList2: ArrayList<GProStickyChannel>?,
        arrayList3: ArrayList<GProStickyChannel>?
    ) {
        
    }

    override fun onRefreshGuildUserProfileInfo(
        i2: Int,
        str: String?,
        j2: Long,
        j3: Long,
        gProGuildUserProfile: GProGuildUserProfile?
    ) {
        
    }

    override fun onReportSqliteError(i2: Int, str: String?) {
        
    }

    override fun onRobotStateChangeNotifyForAll(gProChannelUserChangeInfo: GProChannelUserChangeInfo?) {
        
    }

    override fun onSessionInitComplete(i2: Int, j2: Long) {
        
    }

    override fun onSmobaGameUserChangeNotifyForAll(gProChannelUserChangeInfo: GProChannelUserChangeInfo?) {
        
    }

    override fun onSpeakableThresholdUpdate(
        arrayList: ArrayList<Long>?,
        arrayList2: ArrayList<GProGuildSpeakableThreshold>?
    ) {
        
    }

    override fun onStickyChannelUpdated(
        j2: Long,
        arrayList: ArrayList<GProStickyChannel>?,
        arrayList2: ArrayList<GProStickyChannel>?,
        arrayList3: ArrayList<GProStickyChannel>?
    ) {
        
    }

    override fun onTabRedPointPollingResult(z: Boolean, str: String?) {
        
    }

    override fun onUserAVStateResetNotifyForAll(gProChannelUserChangeInfo: GProChannelUserChangeInfo?) {
        
    }

    override fun onUserEnterListNotifyForAll(gProChannelUserChangeInfo: GProChannelUserChangeInfo?) {
        
    }

    override fun onUserHandUpRequestNotifyForAll(gProChannelUserChangeInfo: GProChannelUserChangeInfo?) {
        
    }

    override fun onUserLeaveListNotifyForAll(gProChannelUserChangeInfo: GProChannelUserChangeInfo?) {
        
    }

    override fun onUserListFetchFinish(i2: Int, str: String?, j2: Long) {
        
    }

    override fun onUserSpeakingNotifyForAll(gProChannelUserChangeInfo: GProChannelUserChangeInfo?) {
        
    }

    override fun onUserWaitingToSpeakNotifyForAll(gProChannelUserChangeInfo: GProChannelUserChangeInfo?) {
        
    }

    override fun onVoiceHeartbeatTimeout(j2: Long, j3: Long) {
        
    }

    override fun onVoiceSmobaGameRooManageUpdate(gProVoiceSmobaGameRoomManageSysMsg: GProVoiceSmobaGameRoomManageSysMsg?) {
        
    }

    override fun onVoiceSmobaGameUserActionUpdate(gProVoiceSmobaGameUserActionPush: GProVoiceSmobaGameUserActionPush?) {
        
    }
}