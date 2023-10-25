package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

public interface IKernelGuildListener {
    void onAVChannelThemeUpdate(long j2, long j3, GProAVChannelConfig gProAVChannelConfig);

    void onAVUserInfoChangeNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onAllGuildChannelListFetchCompleted();

    void onAnchorStatusChange(long j2, long j3, int i2);

    void onAppChannelPreInfosUpdated(long j2, ArrayList<Long> arrayList, ArrayList<Long> arrayList2);

    void onAppInfosUpdated();

    void onBatchChannelListUpdated(ArrayList<Long> arrayList);

    void onBatchFetchRoleListUpdate(long j2, ArrayList<GProGuildRole> arrayList);

    void onBroadcastRoomClose(long j2, int i2, String str);

    void onBroadcastUserCountUpdate(long j2, int i2);

    void onChangeGuildNumber(long j2, String str, int i2);

    void onChannelInfoUpdated(int i2, String str, GProChannel gProChannel);

    void onChannelListUpdated(int i2, String str, long j2, int i3, HashMap<Long, GProChannel> hashMap, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList);

    void onChannelUserPermissionChange(long j2, ArrayList<Long> arrayList);

    void onDiscoveryStateChanged(GProDiscoveryStateChangedMsg gProDiscoveryStateChangedMsg);

    void onEnterSpeakQueueNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onGetSelfTinyId(long j2);

    void onGlobalBannerRemoved(GProGlobalBanner gProGlobalBanner);

    void onGlobalBannerUpdated(GProGlobalBanner gProGlobalBanner);

    void onGuildCreatorGuideUpdated(GProCreateGuildGuideInfo gProCreateGuildGuideInfo);

    void onGuildInfoUpdated(int i2, String str, GProGuild gProGuild, boolean z);

    void onGuildListUpdated(int i2, String str, boolean z, ArrayList<Long> arrayList, ArrayList<GProGuild> arrayList2, GProGuildListSortInfo gProGuildListSortInfo);

    void onGuildUserAvatarMetasUpdated(long j2, ArrayList<Long> arrayList);

    void onGuildUserAvatarPendantsUpdated(HashMap<Long, String> hashMap);

    void onGuildUserChannelCategoryAdminListUpdated(long j2, ArrayList<Long> arrayList);

    void onGuildUserClientIdentitiesUpdated(long j2, ArrayList<Long> arrayList);

    void onGuildUserLevelRolesChanged(long j2, HashMap<Long, Integer> hashMap);

    void onGuildUserMedalsUpdated(HashMap<Long, String> hashMap);

    void onGuildUserMemberNamesUpdated(long j2, HashMap<Long, String> hashMap);

    void onGuildUserNicknamesUpdated(HashMap<Long, String> hashMap);

    void onGuildUserTopRolesChanged(long j2, ArrayList<Long> arrayList);

    void onLocalMemberCountUpdate(long j2, long j3);

    void onMemberCountUpdate(GProGuildMemberCountInfo gProGuildMemberCountInfo);

    void onNativeUpdateSimpleProfileByMsg(long j2, long j3, long j4, long j5, long j6, long j7, int i2, String str, String str2, String str3, GProClientIdentity gProClientIdentity, long j8, String str4, GProMedal gProMedal);

    void onNoticeListUpdate(GProNoticeRedPoint gProNoticeRedPoint, byte[] bArr);

    void onOpenTelemetryMetricCountReport(String str, HashMap<String, String> hashMap, boolean z);

    void onOpenTelemetryMetricTimeCostReport(String str, HashMap<String, String> hashMap, long j2);

    void onOpenTelemetryTraceReport(String str, HashMap<String, String> hashMap);

    void onPollingResult(ArrayList<GProPollingChannelState> arrayList);

    void onPollingYLGameTeamInfo(GProYLGameTeamInfo gProYLGameTeamInfo);

    void onPushAVChannelAppMsg(String str);

    void onPushAVChannelConfigUpdate(long j2, long j3, GProAVChannelConfig gProAVChannelConfig);

    void onPushAVChannelPlayListChange(long j2, long j3, String str, int i2, String str2);

    void onPushAVHeartbeatRsp(int i2, String str, GProHeartbeatRsq gProHeartbeatRsq);

    void onPushAVRoomOptChange(GProAVRoomOptPushInfo gProAVRoomOptPushInfo);

    void onPushAVUserStateChange(GProAVUserStateChangeInfo gProAVUserStateChangeInfo);

    void onPushAddChannelSpeakPermission(long j2, long j3);

    void onPushAdminChanged(long j2, boolean z, long j3, long j4);

    void onPushAllowScreenShareInGuild(long j2, long j3, boolean z, long j4);

    void onPushAudioChannelUserEnter(long j2, long j3, GProUser gProUser, long j4);

    void onPushAudioChannelUserExit(long j2, long j3, long j4, long j5);

    void onPushAudioChannelUserPlatSwitch(long j2, long j3, long j4, int i2, int i3, String str, long j5);

    void onPushBannedStatusChanged(long j2, boolean z, boolean z2, boolean z3, long j3);

    void onPushBatchJoinChannel(long j2, ArrayList<Long> arrayList);

    void onPushBatchLeaveChannel(long j2, ArrayList<Long> arrayList);

    void onPushBussinessConfig(int i2, byte[] bArr);

    void onPushCanceledSpeak(GProAVUserStateChangeInfo gProAVUserStateChangeInfo);

    void onPushChangeRoleMember(long j2, ArrayList<GProRoleMemberChangeInfo> arrayList);

    void onPushChannelAdminChange(long j2, long j3, int i2, ArrayList<Long> arrayList);

    void onPushChannelCategoryChanged(GProGuildInit gProGuildInit);

    void onPushChannelCreated(long j2, long j3, GProGuildInit gProGuildInit);

    void onPushChannelDestroy(long j2, ArrayList<Long> arrayList, long j3);

    void onPushChannelStateChange(ArrayList<GProChannelState> arrayList);

    void onPushChannelTopMsgUpdated(long j2, long j3, long j4, ArrayList<GProTopMsg> arrayList, ArrayList<GProTopMsg> arrayList2);

    void onPushChannelVisibleChanged(long j2, long j3, int i2, int i3);

    void onPushCreateGuild(long j2, GProGuild gProGuild, HashMap<Long, GProChannel> hashMap, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList);

    void onPushCreateRole(long j2, ArrayList<GProGuildRole> arrayList);

    void onPushDeleteRole(long j2, ArrayList<GProGuildRole> arrayList);

    void onPushDestroyGuild(long j2);

    void onPushDirectMsgSwitchUpdate(int i2);

    void onPushGuildPermissionChanged(long j2, ArrayList<Integer> arrayList);

    void onPushGuildStateChange(int i2, String str, GProGuildStateRspInfo gProGuildStateRspInfo);

    void onPushInvitationRefused(long j2, long j3, long j4, String str);

    void onPushInviteMemberEvent(long j2, long j3, long j4, GProSchemeConfig gProSchemeConfig);

    void onPushInvitedToSpeak(GProAVUserStateChangeInfo gProAVUserStateChangeInfo);

    void onPushJoinChannel(long j2, long j3, ArrayList<Long> arrayList);

    void onPushJoinGuild(long j2, long j3, long j4, int i2, GProGuild gProGuild, HashMap<Long, GProChannel> hashMap, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList, int i3);

    void onPushJoinGuildFail(long j2, long j3, int i2, int i3, String str);

    void onPushKickOffGuild(long j2, long j3, long j4, int i2);

    void onPushKickOutAudioChannel(long j2, long j3, long j4, long j5, int i2, String str, int i3, long j6);

    void onPushLeaveChannel(long j2, long j3, ArrayList<Long> arrayList);

    void onPushLiveChannelAnchorIdentityChange(long j2, long j3, int i2);

    void onPushLiveRoomInfoChange(long j2, long j3, String str, String str2);

    void onPushLiveRoomStatusChangeMsg(long j2, long j3, long j4, String str, long j5, int i2, int i3, GProProgramInfo gProProgramInfo, long j6, GProLiveRoomInfo gProLiveRoomInfo);

    void onPushMemberTopRoleChanged(long j2, long j3, GProGuildRole gProGuildRole);

    void onPushMemberTopRoleInChannelChanged(long j2, long j3, long j4, GProGuildRole gProGuildRole);

    void onPushModifyRole(long j2, long j3, GProGuildRole gProGuildRole);

    void onPushMsgRecvTypeChanged(long j2, long j3, long j4, int i2);

    void onPushNotifySwitchUpdate(long j2, long j3, int i2);

    void onPushPermissionInGuild(long j2, long j3, boolean z, long j4);

    void onPushPreventAddictionInstructions(GProPreventAddictionPushInfo gProPreventAddictionPushInfo);

    void onPushQuitGuild(long j2, long j3);

    void onPushRemoveChannelSpeakPermission(long j2, long j3);

    void onPushSecurityResult(GProSecurityResult gProSecurityResult);

    void onPushSelfBannedSpeakChange(long j2, long j3, long j4, int i2);

    void onPushSendGiftEventNotify(GProSendGiftEventData gProSendGiftEventData);

    void onPushShutUpStateChanged(long j2, long j3);

    void onPushSortRole(long j2);

    void onPushSwitchLiveRoom(long j2, long j3, ArrayList<GProMember> arrayList, int i2);

    void onPushUserChannelStateChange(GProUserChannelState gProUserChannelState);

    void onPushUserGiftRankChangeNotify(GProUserGiftRankInfo gProUserGiftRankInfo);

    void onPushUserHandUpResult(GProAVUserStateChangeInfo gProAVUserStateChangeInfo);

    void onPushUserMuteSeatInGuild(long j2, long j3, boolean z, long j4);

    void onPushUserScreenShare(long j2, long j3, ArrayList<GProScreenShareUser> arrayList, byte[] bArr);

    void onPushWorldStateChange(GProWorldState gProWorldState);

    void onQQMsgListChannelDataReady();

    void onQQMsgListChannelUpdated(ArrayList<Integer> arrayList, ArrayList<GProQQMsgListChannel> arrayList2);

    void onQQMsgListGuildUpdated(ArrayList<Integer> arrayList, ArrayList<GProQQMsgListGuild> arrayList2);

    void onRecommendGuildChannelListUpdate(GProGuildData gProGuildData);

    void onRecommendGuildEntryUpdateNotify();

    void onRecommendGuildInfoUpdate(GProRecommendGuildInfo gProRecommendGuildInfo);

    void onRecommendGuildJumpChannelNotify(GProDailyRecommendPush gProDailyRecommendPush);

    void onRecommendGuildPersonalSettingUpdate(GProRecommendGuildPersonalSetting gProRecommendGuildPersonalSetting);

    void onRecommendGuildPollingResult(ArrayList<GProPollingData> arrayList);

    void onRecommendGuildStickyTopUpdated(ArrayList<GProStickyChannel> arrayList, ArrayList<GProStickyChannel> arrayList2, ArrayList<GProStickyChannel> arrayList3);

    void onRefreshGuildUserProfileInfo(int i2, String str, long j2, long j3, GProGuildUserProfile gProGuildUserProfile);

    void onReportSqliteError(int i2, String str);

    void onRobotStateChangeNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onSessionInitComplete(int i2, long j2);

    void onSmobaGameUserChangeNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onSpeakableThresholdUpdate(ArrayList<Long> arrayList, ArrayList<GProGuildSpeakableThreshold> arrayList2);

    void onStickyChannelUpdated(long j2, ArrayList<GProStickyChannel> arrayList, ArrayList<GProStickyChannel> arrayList2, ArrayList<GProStickyChannel> arrayList3);

    void onTabRedPointPollingResult(boolean z, String str);

    void onUserAVStateResetNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onUserEnterListNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onUserHandUpRequestNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onUserLeaveListNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onUserListFetchFinish(int i2, String str, long j2);

    void onUserSpeakingNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onUserWaitingToSpeakNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onVoiceHeartbeatTimeout(long j2, long j3);

    void onVoiceSmobaGameRooManageUpdate(GProVoiceSmobaGameRoomManageSysMsg gProVoiceSmobaGameRoomManageSysMsg);

    void onVoiceSmobaGameUserActionUpdate(GProVoiceSmobaGameUserActionPush gProVoiceSmobaGameUserActionPush);
}
