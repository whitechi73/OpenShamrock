package com.tencent.mobileqq.qqguildsdk.observer;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import com.tencent.mobileqq.qqguildsdk.data.GProScreenShareUserData;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProAVRoomOptPushInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProAVUserStateChangeInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProDailyRecommendPush;
import com.tencent.mobileqq.qqguildsdk.data.IGProDiscoveryStateChangedMsg;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildData;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProHeartbeatRsq;
import com.tencent.mobileqq.qqguildsdk.data.IGProOnlineMember;
import com.tencent.mobileqq.qqguildsdk.data.IGProPollingData;
import com.tencent.mobileqq.qqguildsdk.data.IGProRecommendGuildPersonalSetting;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData;
import com.tencent.mobileqq.qqguildsdk.data.IGProStickyChannel;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserGiftRankInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserGuideMsg;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProVoiceSmobaGameRoomManageSysMsg;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSchemaConfig;
import com.tencent.mobileqq.qqguildsdk.data.ILiveProgramInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEssenceSvrRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTaskInfo;
import com.tencent.mobileqq.transfile.FileMsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;


public class GPServiceObserver implements Observer {
    private static final Map<Integer, String> eventName = initEventName();

    private void doLog(int i2, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("【sdk-ui notify】：");
        Map<Integer, String> map = eventName;
        sb.append(map.containsKey(Integer.valueOf(i2)) ? map.get(Integer.valueOf(i2)) : "error");
        sb.append(" from ");
        sb.append(str);
        //QLog.d("[gpro_sdk]", 1, sb.toString());
    }

    public static Map<Integer, String> getEventNameMap() {
        return eventName;
    }

    private static Map<Integer, String> initEventName() {
        HashMap hashMap = new HashMap();
        hashMap.put(1, "onGuildListUpdated");
        hashMap.put(2, "onChannelListUpdated");
        hashMap.put(4, "onGuildInfoUpdated");
        hashMap.put(5, "onChannelInfoUpdated");
        hashMap.put(3, "onUserListUpdated");
        hashMap.put(6, "onCreateChannel");
        hashMap.put(7, "onCreateGuild");
        hashMap.put(8, "onAddGuildNotInfo");
        hashMap.put(43, "onAddGuildWithInfo");
        hashMap.put(9, "onRemoveGuild");
        hashMap.put(10, "onBeKickFromGuild");
        hashMap.put(11, "onDestoryGuild");
        hashMap.put(12, "onMsgRecvTypeChanged");
        hashMap.put(13, "onAdminChanged");
        hashMap.put(14, "onUserNickUpdate");
        hashMap.put(15, "onGetUserAvatarUrl");
        hashMap.put(24, "onGuildUserMedalUpdate");
        hashMap.put(16, "onUserProfileInfoUpdate");
        hashMap.put(17, "onPushChannelDestroy");
        hashMap.put(18, "onDeleteGuild");
        hashMap.put(19, "onGetFinalGuildList");
        hashMap.put(20, "onChannelTopMsgUpdated");
        hashMap.put(22, "onSwitchFollowAdminMsgNotify");
        hashMap.put(3101, "onAudioChannelPollingSimpleInfoUpdate");
        hashMap.put(3102, "onPushUserHandUpResult");
        hashMap.put(3103, "onPushInvitedToSpeak");
        hashMap.put(3112, "onPushCanceledSpeak");
        hashMap.put(3109, "onPushInvitationRefused");
        hashMap.put(3104, "onUserHandUpRequestNotifyForAll");
        hashMap.put(3105, "onUserWaitingToSpeakNotifyForAll");
        hashMap.put(3106, "onUserSpeakingNotifyForAll");
        hashMap.put(3107, "onUserAVStateResetNotifyForAll");
        hashMap.put(3115, "onUserEnterListNotifyForAll");
        hashMap.put(3116, "onUserLeaveListNotifyForAll");
        hashMap.put(3108, "onSmobaGameUserChangeNotifyForAll");
        hashMap.put(3123, "onRobotStateChangeNotifyForAll");
        hashMap.put(3110, "onPushAVHeartbeatRsp");
        hashMap.put(3117, "onPushAVForceKickOut");
        hashMap.put(3118, "onPushAVForceStopScreenShare");
        hashMap.put(3120, "onPushAVChannelConfigUpdate");
        //hashMap.put(Integer.valueOf((int) g.T0), "onAVUserLobbyStateChangeNotifyForAll");
        hashMap.put(34, "onAudioChannelUserPlatSwith");
        hashMap.put(35, "onPushKickOutAudioChannel");
        hashMap.put(222, "onPushInviteMemberEvent");
        hashMap.put(37, "onUserMuteSeatInGuild");
        hashMap.put(38, "doOnPushUserScreenShare");
        hashMap.put(39, "onPushAllowScreenShareInGuild");
        hashMap.put(3111, "onPushPermissionInGuild");
        hashMap.put(40, "onMemberCountUpdate");
        hashMap.put(42, "onGuildMemberClientIdentityUpdate");
        hashMap.put(74, "GUILD_NOTICE_LIST_UPDATE");
        hashMap.put(52, "onAppChnnPreInfoListUpdated");
        hashMap.put(53, "onVoiceHeartbeatTimeout");
        hashMap.put(54, "onGuildOnlineMemberUpdated");
        hashMap.put(44, "onLiveRoomStatusChange");
        hashMap.put(45, "onLiveRoomUserChange");
        hashMap.put(46, "onLiveChannelAnchorIdentifyChange");
        hashMap.put(47, "onSelfBannedSpeakChange");
        hashMap.put(48, "onLiveRoomInfoChange");
        hashMap.put(60, "onBatchGuildUserNickUpdate");
        hashMap.put(62, "onBatchGuildMemberNameUpdate");
        hashMap.put(73, "onChannelVisibleChanged");
        hashMap.put(75, "onCreateRole");
        hashMap.put(76, "onDeleteRole");
        hashMap.put(77, "onModifyRole");
        hashMap.put(78, "onSortRole");
        hashMap.put(79, "onChangeRoleMember");
        hashMap.put(80, "onMemberTopRoleChanged");
        hashMap.put(96, "onUserLevelRoleIdChanged");
        hashMap.put(81, "onGuildListSortUpdated");
        hashMap.put(82, "onSecurityResult");
        hashMap.put(83, "onPollingLiveChannelPresence");
        hashMap.put(84, "onChannelSpeakPermissionChange");
        hashMap.put(85, "onChannelAdminChange");
        hashMap.put(92, "onGuildCreateGuideTaskChange");
        hashMap.put(93, "onPollingWorldChannelPresence");
        hashMap.put(95, "onPollingActiveChannel");
        hashMap.put(100, "onDirectMsgSessionCreate");
        hashMap.put(101, "onDirectMsgBlackChanged");
        hashMap.put(102, "onDirectMsgSwitchStatus");
        hashMap.put(103, "onDirectMsgNotifyTypeChanged");
        hashMap.put(107, "onDirectMsgGuildNotifyTypeChanged");
        hashMap.put(108, "onPushDirectMsgSwitchUpdate");
        hashMap.put(109, "onPushDirectMsgNotifyUpdate");
        hashMap.put(94, "onPollingRecommendEssences");
        hashMap.put(104, "onCreateSchedule");
        hashMap.put(105, "onEditSchedule");
        hashMap.put(106, "onModifyScheduleInviteStatus");
        hashMap.put(110, "onGetSelfTinyId");
        hashMap.put(120, "onUserDisplayNameUpdate");
        hashMap.put(160, "onShutUpStateChanged");
        hashMap.put(161, "onBannedStatusChanged");
        hashMap.put(162, "onSpeakLimitChanged");
        hashMap.put(223, "onChannelUserPermissionChanged");
        hashMap.put(227, "onSpeakableThresholdUpdate");
        hashMap.put(300, "onGPROInitCompleted");
        hashMap.put(301, "onTabRedPointPollingResult");
        hashMap.put(302, "onDiscoveryStateChanged");
        hashMap.put(303, "onUserGuidePush");
        hashMap.put(228, "onVoiceSmobaGameUserActionUpdate");
        hashMap.put(229, "onVoiceSmobaGameRooManageUpdate");
        hashMap.put(230, "onAVChannelThemeUpdate");
        hashMap.put(231, "onPollingYLGameTeamInfo");
        hashMap.put(232, "onPushBussinessConfig");
        hashMap.put(9001, "onGlobalBannerUpdated");
        hashMap.put(9002, "onGlobalBannerRemoved");
        hashMap.put(9010, "onStickyChannelAdded");
        hashMap.put(9011, "onStickyChannelUpdated");
        hashMap.put(9012, "onStickyChannelRemoved");
        //hashMap.put(Integer.valueOf((int) AppConstants.RichMediaErrorCode.ERROR_EXP_ILLEGAL_ARGUMENT), "onRecommendGuildInfoUpdate");
        hashMap.put(9021, "onRecommendGuildChannelListUpdate");
        //hashMap.put(Integer.valueOf((int) AppConstants.RichMediaErrorCode.ERROR_EXP_SECURITY), "onRecommendGuildPersonalSettingUpdate");
        //hashMap.put(Integer.valueOf((int) FileMsg.RESULT_CODE_HTTPDECODE_EXCEPTION), "onRecommendGuildPollingResult");
        hashMap.put(9024, "onRecommendGuildStickyTopAdd");
        hashMap.put(9025, "onRecommendGuildStickTopyUpdate");
        hashMap.put(9026, "onRecommendGuildStickyTopRemove");
        hashMap.put(9027, "onRecommendGuildJumpChannelNotify");
        hashMap.put(9030, "onChangeGuildNumber");
        hashMap.put(9031, "onRecommendGuildEntryUpdateNotify");
        // hashMap.put(Integer.valueOf((int) AppConstants.RichMediaErrorCode.ERROR_NET_CONNECT_TIMEOUT), "onPushUserGiftRankChangeNotify");
        //hashMap.put(Integer.valueOf((int) AppConstants.RichMediaErrorCode.ERROR_NET_SOCKET_EXCEPTION), "onPushSendGiftEventNotify");
        hashMap.put(3125, "onEnterSpeakQueueNotifyForAll");
        hashMap.put(3126, "onAVUserInfoChangeNotifyForAll");
        hashMap.put(3127, "onPushAVUserStateChange");
        hashMap.put(3129, "onPushAVChannelPlayListChange");
        hashMap.put(1501, "onGuildUserAvatarPendantUpdate");
        hashMap.put(3210, "onPushAVChannelAppMsg");
        hashMap.put(3221, "onPushAVRoomOptChange");
        hashMap.put(233, "onAddGuildFail");
        hashMap.put(3220, "doOnPushPreventAddictionInstructions");
        hashMap.put(23, "onChannelSubscribeBubbleShow");
        hashMap.put(9100, "onAllGuildChannelListFetchCompleted");
        hashMap.put(9200, "onGuildStateListUpdate");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdate(Object obj) {
        if (obj == null) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        int intValue = ((Integer) objArr[0]).intValue();
        String str = (String) objArr[1];
        Object[] objArr2 = (Object[]) objArr[2];
        if (objArr2 == null) {
            return;
        }
        if (intValue == 1) {
            onGuildListUpdated();
        } else if (intValue == 2) {
            onChannelListUpdated((String) objArr2[0]);
        } else if (intValue == 3) {
            onUserListUpdated((String) objArr2[0]);
        } else if (intValue == 4) {
            onGuildInfoUpdated((String) objArr2[0]);
        } else if (intValue == 5) {
            onChannelInfoUpdated((String) objArr2[0]);
        } else if (intValue != 6) {
            if (intValue != 7) {
                if (intValue == 34) {
                    onAudioChannelUserPlatSwith((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), (String) objArr2[4]);
                    return;
                } else if (intValue != 35) {
                    switch (intValue) {
                        case 7:
                            break;
                        case 8:
                            onAddGuildNotInfo((String) objArr2[0]);
                            return;
                        case 9:
                            onRemoveGuild((String) objArr2[0]);
                            return;
                        case 10:
                            onBeKickFromGuild((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                            return;
                        case 11:
                            onDestoryGuild((String) objArr2[0]);
                            return;
                        case 12:
                            onMsgRecvTypeChanged((String) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                            return;
                        case 13:
                            onAdminChanged((String) objArr2[0], (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                            return;
                        case 14:
                            onUserNickUpdate((String) objArr2[0], (String) objArr2[1]);
                            return;
                        case 15:
                            onGuildUserAvatarUrlUpdate((String) objArr2[0], (String) objArr2[1]);
                            return;
                        case 16:
                            //onUserProfileInfoUpdate(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (em) objArr2[4]);
                            return;
                        case 17:
                            onPushChannelDestroy((String) objArr2[0], (List) objArr2[1]);
                            return;
                        case 18:
                            onDeleteGuild((String) objArr2[0]);
                            return;
                        case 19:
                            onGetFinalGuildList((List) objArr2[0]);
                            return;
                        case 20:
                            onChannelTopMsgUpdated((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (ArrayList) objArr2[3], (ArrayList) objArr2[4]);
                            return;
                        case 21:
                            onChannelListAdded((String) objArr2[0], (List) objArr2[1]);
                            return;
                        case 22:
                            onSwitchFollowAdminMsgNotify((String) objArr2[0]);
                            return;
                        case 23:
                            onChannelSubscribeBubbleShow((String) objArr2[0], (String) objArr2[1]);
                            return;
                        case 24:
                            onGuildUserMedalsUpdated((String) objArr2[0], (String) objArr2[1]);
                            return;
                        case 50:
                            onGuildListRefreshed(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                            return;
                        case 60:
                            //onBatchGuildUserNickUpdate((List) objArr2[0]);
                            return;
                        case 62:
                            //onBatchGuildMemberNameUpdate((String) objArr2[0], (List) objArr2[1]);
                            return;
                        case 160:
                            onShutUpStateChanged((String) objArr2[0], ((Long) objArr2[1]).longValue());
                            return;
                        case 161:
                            onBannedStatusChanged((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), ((Long) objArr2[4]).longValue());
                            return;
                        case 162:
                            onSpeakLimitChanged((String) objArr2[0], (String) objArr2[1]);
                            return;
                        case 222:
                            onPushInviteMemberEvent((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (IGuildSchemaConfig) objArr2[3]);
                            return;
                        case 223:
                            onChannelUserPermissionChanged((String) objArr2[0], (List) objArr2[1]);
                            return;
                        case 225:
                            onSessionInitComplete(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (String) objArr2[2]);
                            return;
                        case 227:
                            //onSpeakableThresholdUpdate((List) objArr2[0], (List) objArr2[1]);
                            return;
                        case 228:
                            //onVoiceSmobaGameUserActionUpdate((eo) objArr2[0]);
                            return;
                        case 229:
                            onVoiceSmobaGameRooManageUpdate((IGProVoiceSmobaGameRoomManageSysMsg) objArr2[0]);
                            return;
                        case 230:
                            onAVChannelThemeUpdate((String) objArr2[0], (String) objArr2[1], (IGProAVChannelConfig) objArr2[2]);
                            return;
                        case 231:
                            //onYLGameTeamInfoUpdate((ep) objArr2[0]);
                            return;
                        case 232:
                            onPushBussinessConfig(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1]);
                            return;
                        case 233:
                            //onAddGuildFail((cn) objArr2[0]);
                            return;
                        case 300:
                            onGPROInitCompleted();
                            return;
                        case 301:
                            onTabRedPointPollingResult(((Boolean) objArr2[0]).booleanValue(), (String) objArr2[1]);
                            return;
                        case 302:
                            onDiscoveryStateChanged((IGProDiscoveryStateChangedMsg) objArr2[0]);
                            return;
                        case 303:
                            onUserGuidePush((IGProUserGuideMsg) objArr2[0]);
                            return;
                        case 1501:
                            onGuildUserAvatarPendantUpdate((String) objArr2[0], (String) objArr2[1]);
                            return;
                        case 3101:
                            onAudioChannelPollingSimpleInfoUpdate((String) objArr2[0], (List) objArr2[1]);
                            return;
                        case 3102:
                            onPushUserHandUpResult((IGProAVUserStateChangeInfo) objArr2[0]);
                            return;
                        case 3103:
                            onPushInvitedToSpeak((IGProAVUserStateChangeInfo) objArr2[0]);
                            return;
                        case 3104:
                            onUserHandUpRequestNotifyForAll((String) objArr2[0], (String) objArr2[1], (ArrayList) objArr2[2], (IGProChannelUserNum) objArr2[3]);
                            return;
                        case 3105:
                            onUserWaitingToSpeakNotifyForAll((String) objArr2[0], (String) objArr2[1], (ArrayList) objArr2[2], (IGProChannelUserNum) objArr2[3]);
                            return;
                        case 3106:
                            onUserSpeakingNotifyForAll((String) objArr2[0], (String) objArr2[1], (ArrayList) objArr2[2], (IGProChannelUserNum) objArr2[3]);
                            return;
                        case 3107:
                            onUserAVStateResetNotifyForAll((String) objArr2[0], (String) objArr2[1], (ArrayList) objArr2[2], (IGProChannelUserNum) objArr2[3]);
                            return;
                        case 3108:
                            onSmobaGameUserChangeNotifyForAll((String) objArr2[0], (String) objArr2[1], (ArrayList) objArr2[2], (IGProChannelUserNum) objArr2[3]);
                            return;
                        case 3109:
                            onPushInvitationRefused((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                            return;
                        case 3110:
                            onPushAVHeartbeatRsp(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (IGProHeartbeatRsq) objArr2[2]);
                            return;
                        case 3111:
                            onPushPermissionInGuild((String) objArr2[0], (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Long) objArr2[3]).longValue());
                            return;
                        case 3112:
                            onPushCanceledSpeak((IGProAVUserStateChangeInfo) objArr2[0]);
                            return;
                        case 3115:
                            onUserEnterListNotifyForAll((String) objArr2[0], (String) objArr2[1], (ArrayList) objArr2[2], (IGProChannelUserNum) objArr2[3]);
                            return;
                        case 3116:
                            onUserLeaveListNotifyForAll((String) objArr2[0], (String) objArr2[1], (ArrayList) objArr2[2], (IGProChannelUserNum) objArr2[3]);
                            return;
                        case 3117:
                            onPushAVForceKickOut((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                            return;
                        case 3118:
                            onPushAVForceStopScreenShare((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                            return;
                        case 3120:
                            onPushAVChannelConfigUpdate((String) objArr2[0], (String) objArr2[1], (IGProAVChannelConfig) objArr2[2]);
                            return;
                        case 3123:
                            onRobotStateChangeNotifyForAll((String) objArr2[0], (String) objArr2[1], (ArrayList) objArr2[2], (IGProChannelUserNum) objArr2[3]);
                            return;
                        case 3125:
                            onEnterSpeakQueueNotifyForAll((String) objArr2[0], (String) objArr2[1], (ArrayList) objArr2[2], (IGProChannelUserNum) objArr2[3]);
                            return;
                        case 3126:
                            onAVUserInfoChangeNotifyForAll((String) objArr2[0], (String) objArr2[1], (ArrayList) objArr2[2], (ArrayList) objArr2[3], (IGProChannelUserNum) objArr2[4]);
                            return;
                        case 3127:
                            onPushAVUserStateChange((IGProAVUserStateChangeInfo) objArr2[0]);
                            return;
                        case 3129:
                            onPushAVChannelPlayListChange((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), (String) objArr2[4]);
                            return;
                        //case g.T0 /* 3200 */:
                            //onAVUserLobbyStateChangeNotifyForAll((String) objArr2[0], (String) objArr2[1], (ArrayList) objArr2[2], (IGProChannelUserNum) objArr2[3]);
                            //return;
                        case 3210:
                            onPushAVChannelAppMsg((String) objArr2[0]);
                            return;
                        case 3220:
                            //doOnPushPreventAddictionInstructions((du) objArr2[0]);
                            return;
                        case 3221:
                            onPushAVRoomOptChange((IGProAVRoomOptPushInfo) objArr2[0]);
                            return;
                        case 9001:
                            onGlobalBannerUpdated((IGProGlobalBanner) objArr2[0]);
                            return;
                        case 9002:
                            onGlobalBannerRemoved((IGProGlobalBanner) objArr2[0]);
                            return;
                        case 9010:
                            onStickyChannelAdded((List) objArr2[0]);
                            return;
                        case 9011:
                            onStickyChannelUpdated((List) objArr2[0]);
                            return;
                        case 9012:
                            onStickyChannelRemoved((List) objArr2[0]);
                            return;
                        //case AppConstants.RichMediaErrorCode.ERROR_EXP_ILLEGAL_ARGUMENT /* 9020 */:
                        //    onRecommendGuildInfoUpdate((IGProRecommendGuildInfo) objArr2[0]);
                        //    return;
                        case 9021:
                            onRecommendGuildChannelListUpdate((IGProGuildData) objArr2[0]);
                            return;
                       // case AppConstants.RichMediaErrorCode.ERROR_EXP_SECURITY /* 9022 */:
                         //   onRecommendGuildPersonalSettingUpdate((IGProRecommendGuildPersonalSetting) objArr2[0]);
                        //    return;
                        //case FileMsg.RESULT_CODE_HTTPDECODE_EXCEPTION /* 9023 */:
                        //    onRecommendGuildPollingResult((List) objArr2[0]);
                        //    return;
                        case 9024:
                            onRecommendGuildStickyTopAdd((List) objArr2[0]);
                            return;
                        case 9025:
                            onRecommendGuildStickyTopUpdate((List) objArr2[0]);
                            return;
                        case 9026:
                            onRecommendGuildStickyTopRemove((List) objArr2[0]);
                            return;
                        case 9027:
                            onRecommendGuildJumpChannelNotify((IGProDailyRecommendPush) objArr2[0]);
                            return;
                        case 9030:
                            onChangeGuildNumber(((Long) objArr2[0]).longValue(), (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                            return;
                        case 9031:
                            onRecommendGuildEntryUpdateNotify();
                            return;
                       // case AppConstants.RichMediaErrorCode.ERROR_NET_CONNECT_TIMEOUT /* 9050 */:
                        //    onPushUserGiftRankChangeNotify((String) objArr2[0], (String) objArr2[1], (IGProUserGiftRankInfo) objArr2[2]);
                        //    return;
                       // case AppConstants.RichMediaErrorCode.ERROR_NET_SOCKET_EXCEPTION /* 9051 */:
                        //    onPushSendGiftEventNotify((String) objArr2[0], (String) objArr2[1], (IGProSendGiftEventData) objArr2[2]);
                        //    return;
                        case 9100:
                            onAllGuildChannelListFetchCompleted();
                            return;
                        case 9200:
                           // onGuildStateListUpdate((List) objArr2[0]);
                            return;
                        default:
                            switch (intValue) {
                                case 37:
                                    onUserMuteSeatInGuild((String) objArr2[0], (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Long) objArr2[3]).longValue());
                                    return;
                                case 38:
                                    onPushUserScreenShare((String) objArr2[0], (String) objArr2[1], (List) objArr2[2], (String) objArr2[3]);
                                    return;
                                case 39:
                                    onPushAllowScreenShareInGuild((String) objArr2[0], (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Long) objArr2[3]).longValue());
                                    return;
                                case 40:
                                   // onMemberCountUpdate((et) objArr2[0]);
                                    return;
                                default:
                                    switch (intValue) {
                                        case 42:
                                            onGuildMemberClientIdentityUpdate((String) objArr2[0], (String) objArr2[1]);
                                            return;
                                        case 43:
                                            onAddGuildWithInfo((IGProGuildInfo) objArr2[0], ((Integer) objArr2[1]).intValue());
                                            return;
                                        case 44:
                                            onLiveRoomStatusChange((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (String) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue(), (ILiveProgramInfo) objArr2[7], ((Long) objArr2[8]).longValue(), (ILiveRoomInfo) objArr2[9]);
                                            return;
                                        case 45:
                                            onLiveRoomUserChange((String) objArr2[0], (String) objArr2[1], (List) objArr2[2], ((Integer) objArr2[3]).intValue());
                                            return;
                                        case 46:
                                            onLiveChannelAnchorIdentityChange((String) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                                            return;
                                        case 47:
                                            onSelfBannedSpeakChange((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue());
                                            return;
                                        case 48:
                                            onLiveRoomInfoChange((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                                            return;
                                        default:
                                            switch (intValue) {
                                                case 52:
                                                    onAppChnnPreInfoListUpdated((String) objArr2[0], (List) objArr2[1], (List) objArr2[2]);
                                                    return;
                                                case 53:
                                                    onVoiceHeartbeatTimeout((String) objArr2[0], (String) objArr2[1]);
                                                    return;
                                                case 54:
                                                    onGuildOnlineMemberUpdated((List) objArr2[0]);
                                                    return;
                                                default:
                                                    switch (intValue) {
                                                        case 73:
                                                            onChannelVisibleChanged((String) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                                                            return;
                                                        case 74:
                                                            //onGuildNoticeListUpdate((cg) objArr2[0], (byte[]) objArr2[1]);
                                                            return;
                                                        case 75:
                                                            onCreateRole((String) objArr2[0], (List) objArr2[1]);
                                                            return;
                                                        case 76:
                                                            onDeleteRole((String) objArr2[0], (List) objArr2[1]);
                                                            return;
                                                        case 77:
                                                            onModifyRole((String) objArr2[0], (String) objArr2[1], (IGProGuildRoleInfo) objArr2[2]);
                                                            return;
                                                        case 78:
                                                            onSortRole((String) objArr2[0]);
                                                            return;
                                                        case 79:
                                                            onChangeRoleMember((String) objArr2[0], (List) objArr2[1]);
                                                            return;
                                                        case 80:
                                                            onMemberTopRoleChanged((String) objArr2[0], (String) objArr2[1]);
                                                            return;
                                                        case 81:
                                                            onGuildListSortUpdated();
                                                            return;
                                                        case 82:
                                                            onSecurityResult((IGProSecurityResult) objArr2[0]);
                                                            return;
                                                        case 83:
                                                            onPollingLiveChannelPresence((ArrayList) objArr2[0]);
                                                            return;
                                                        case 84:
                                                            onChannelSpeakPermissionChange((String) objArr2[0], (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                                                            return;
                                                        case 85:
                                                            onChannelAdminChange((String) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (List) objArr2[3]);
                                                            return;
                                                        default:
                                                            switch (intValue) {
                                                                case 92:
                                                                    onGuildCreatorGuideTaskChange((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), (ArrayList) objArr2[5]);
                                                                    return;
                                                                case 93:
                                                                    onPollingWorldChannelPresence((String) objArr2[0], (String) objArr2[1]);
                                                                    return;
                                                                case 94:
                                                                    onPollingRecommendEssences((List) objArr2[0], (List) objArr2[1], (List) objArr2[2]);
                                                                    return;
                                                                case 95:
                                                                    //onPollingActiveChannel((String) objArr2[0], (cr) objArr2[1]);
                                                                    return;
                                                                case 96:
                                                                    onUserLevelRoleIdChanged((String) objArr2[0], (String) objArr2[1]);
                                                                    return;
                                                                default:
                                                                    switch (intValue) {
                                                                        case 100:
                                                                            //onDirectMsgSessionCreate((l) objArr2[0]);
                                                                            return;
                                                                        case 101:
                                                                            onDirectMsgBlackChanged((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                                                                            return;
                                                                        case 102:
                                                                            onDirectMsgSwitchStatus(((Integer) objArr2[0]).intValue());
                                                                            return;
                                                                        case 103:
                                                                            onDirectMsgNotifyTypeChanged((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                                                                            return;
                                                                        case 104:
                                                                            onCreateSchedule((String) objArr2[0], (String) objArr2[1], (GuildScheduleInfo) objArr2[2]);
                                                                            return;
                                                                        case 105:
                                                                            onEditSchedule((String) objArr2[0], (String) objArr2[1], (GuildScheduleInfo) objArr2[2], ((Integer) objArr2[3]).intValue());
                                                                            return;
                                                                        case 106:
                                                                            onModifyScheduleInviteStatus((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue());
                                                                            return;
                                                                        case 107:
                                                                            onDirectMsgGuildNotifyTypeChanged(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                                                                            return;
                                                                        case 108:
                                                                            onPushDirectMsgSwitchUpdate(((Integer) objArr2[0]).intValue());
                                                                            return;
                                                                        case 109:
                                                                            onPushDirectMsgNotifyUpdate((String) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                                                                            return;
                                                                        case 110:
                                                                            onGetSelfTinyId((String) objArr2[0]);
                                                                            return;
                                                                        case 111:
                                                                            onDirectFeedsSwitchChange(((Integer) objArr2[0]).intValue());
                                                                            return;
                                                                        default:
                                                                            switch (intValue) {
                                                                                case 120:
                                                                                    onUserDisplayNameUpdate((String) objArr2[0]);
                                                                                    return;
                                                                                case 121:
                                                                                    //onGuildPermissionChanged((String) objArr2[0], (ds) objArr2[1]);
                                                                                    return;
                                                                                case 122:
                                                                                    //onChannelPermissionChanged((String) objArr2[0], (String) objArr2[1], (ds) objArr2[2]);
                                                                                    return;
                                                                                default:
                                                                                    switch (intValue) {
                                                                                        case 148:
                                                                                            //onQQMsgListGuildUpdated((List) objArr2[0], (List) objArr2[1]);
                                                                                            return;
                                                                                        case 149:
                                                                                            onQQMsgListChannelDataReady();
                                                                                            return;
                                                                                        case 150:
                                                                                            onQQMsgListChannelUpdated();
                                                                                            //onQQMsgListChannelUpdated((List) objArr2[0], (List) objArr2[1]);
                                                                                            return;
                                                                                        default:
                                                                                            return;
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    Object[] objArr3 = (Object[]) objArr2[3];
                    onPushKickOutAudioChannel((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr3[0], ((Integer) objArr3[1]).intValue(), (String) objArr3[2], ((Integer) objArr3[3]).intValue());
                    return;
                }
            }
            onCreateGuild((IGProGuildInfo) objArr2[0]);
        } else {
            onCreateChannel((IGProChannelInfo) objArr2[0]);
        }
    }

    //protected void doOnPushPreventAddictionInstructions(du duVar) {
    //}

    protected void onAVChannelThemeUpdate(String str, String str2, IGProAVChannelConfig iGProAVChannelConfig) {
    }

    protected void onAVUserInfoChangeNotifyForAll(String str, String str2, ArrayList<IGProUserInfo> arrayList, ArrayList<IGProUserInfo> arrayList2, IGProChannelUserNum iGProChannelUserNum) {
    }

    protected void onAVUserLobbyStateChangeNotifyForAll(String str, String str2, ArrayList<IGProUserInfo> arrayList, IGProChannelUserNum iGProChannelUserNum) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    //public void onAddGuildFail(cn cnVar) {
    //}

    protected void onAddGuildNotInfo(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAddGuildWithInfo(IGProGuildInfo iGProGuildInfo, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAdminChanged(String str, String str2, boolean z) {
    }

    protected void onAllGuildChannelListFetchCompleted() {
    }

    protected void onAppChnnPreInfoListUpdated(String str, List<String> list, List<String> list2) {
    }

    protected void onAudioChannelPollingSimpleInfoUpdate(String str, List<String> list) {
    }

    protected void onAudioChannelUserPlatSwith(String str, String str2, String str3, int i2, String str4) {
    }

    protected void onBannedStatusChanged(String str, boolean z, boolean z2, boolean z3, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    //public void onBatchGuildMemberNameUpdate(String str, List<ez> list) {
    //}

    /* JADX INFO: Access modifiers changed from: protected */
    //public void onBatchGuildUserNickUpdate(List<ez> list) {
    //}

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBeKickFromGuild(String str, int i2) {
    }

    protected void onChangeGuildNumber(long j2, String str, int i2) {
    }

    protected void onChangeRoleMember(String str, List<Object> list) {
    }

    protected void onChannelAdminChange(String str, String str2, int i2, List<String> list) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChannelInfoUpdated(String str) {
    }

    protected void onChannelListAdded(String str, @NonNull List<String> list) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChannelListUpdated(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    //public void onChannelPermissionChanged(String str, String str2, ds dsVar) {
    //}

    protected void onChannelSpeakPermissionChange(String str, String str2, boolean z) {
    }

    protected void onChannelSubscribeBubbleShow(String str, String str2) {
    }

    protected void onChannelTopMsgUpdated(String str, String str2, String str3, ArrayList<IGProTopMsg> arrayList, ArrayList<IGProTopMsg> arrayList2) {
    }

    protected void onChannelUserPermissionChanged(String str, List<String> list) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChannelVisibleChanged(String str, String str2, int i2, int i3) {
    }

    protected void onCreateChannel(IGProChannelInfo iGProChannelInfo) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreateGuild(IGProGuildInfo iGProGuildInfo) {
    }

    protected void onCreateRole(String str, List<IGProGuildRoleInfo> list) {
    }

    protected void onCreateSchedule(String str, String str2, GuildScheduleInfo guildScheduleInfo) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDeleteGuild(String str) {
    }

    protected void onDeleteRole(String str, List<IGProGuildRoleInfo> list) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestoryGuild(String str) {
    }

    protected void onDirectFeedsSwitchChange(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDirectMsgBlackChanged(String str, boolean z) {
    }

    protected void onDirectMsgGuildNotifyTypeChanged(int i2, boolean z) {
    }

    protected void onDirectMsgNotifyTypeChanged(String str, int i2) {
    }

    //protected void onDirectMsgSessionCreate(@NonNull l lVar) {
    //}

    protected void onDirectMsgSwitchStatus(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDiscoveryStateChanged(IGProDiscoveryStateChangedMsg iGProDiscoveryStateChangedMsg) {
    }

    protected void onEditSchedule(String str, String str2, GuildScheduleInfo guildScheduleInfo, int i2) {
    }

    protected void onEnterSpeakQueueNotifyForAll(String str, String str2, ArrayList<IGProUserInfo> arrayList, IGProChannelUserNum iGProChannelUserNum) {
    }

    protected void onGPROInitCompleted() {
    }

    protected void onGetFinalGuildList(List<String> list) {
    }

    protected void onGetSelfTinyId(String str) {
    }

    //@Deprecated
    //protected void onGetUserAvatarUrl(String str, cm cmVar) {
    //}

    protected void onGlobalBannerRemoved(IGProGlobalBanner iGProGlobalBanner) {
    }

    protected void onGlobalBannerUpdated(IGProGlobalBanner iGProGlobalBanner) {
    }

    protected void onGuildCreatorGuideTaskChange(String str, int i2, boolean z, int i3, int i4, List<IGProTaskInfo> list) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGuildInfoUpdated(String str) {
    }

    protected void onGuildListRefreshed(int i2, String str) {
    }

    protected void onGuildListSortUpdated() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGuildListUpdated() {
    }

    protected void onGuildMemberClientIdentityUpdate(String str, String str2) {
    }

    //protected void onGuildNoticeListUpdate(cg cgVar, byte[] bArr) {
    //}

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGuildOnlineMemberUpdated(List<IGProOnlineMember> list) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    //public void onGuildPermissionChanged(String str, ds dsVar) {
   // }

   // protected void onGuildStateListUpdate(List<dn> list) {
    //}

    protected void onGuildUserAvatarPendantUpdate(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGuildUserAvatarUrlUpdate(String str, String str2) {
    }

    protected void onGuildUserMedalsUpdated(String str, String str2) {
    }

    protected void onLiveChannelAnchorIdentityChange(String str, String str2, int i2) {
    }

    protected void onLiveRoomInfoChange(String str, String str2, String str3, String str4) {
    }

    protected void onLiveRoomStatusChange(String str, String str2, String str3, String str4, String str5, int i2, int i3, ILiveProgramInfo iLiveProgramInfo, long j2, ILiveRoomInfo iLiveRoomInfo) {
    }

    protected void onLiveRoomUserChange(String str, String str2, List<Object> list, int i2) {
    }

    //protected void onMemberCountUpdate(et etVar) {
    //}

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMemberTopRoleChanged(String str, String str2) {
    }

    protected void onModifyRole(String str, String str2, IGProGuildRoleInfo iGProGuildRoleInfo) {
    }

    protected void onModifyScheduleInviteStatus(String str, String str2, String str3, int i2) {
    }

    protected void onMsgRecvTypeChanged(String str, String str2, int i2) {
    }

   // protected void onPollingActiveChannel(String str, cr crVar) {
    //}

    protected void onPollingLiveChannelPresence(List<ILiveRoomInfo> list) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPollingRecommendEssences(List<String> list, List<String> list2, List<IGProRecommendEssenceSvrRsp> list3) {
    }

    protected void onPollingWorldChannelPresence(String str, String str2) {
    }

    protected void onPushAVChannelAppMsg(String str) {
    }

    protected void onPushAVChannelConfigUpdate(String str, String str2, IGProAVChannelConfig iGProAVChannelConfig) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPushAVChannelPlayListChange(String str, String str2, String str3, int i2, String str4) {
    }

    protected void onPushAVForceKickOut(String str, String str2, String str3) {
    }

    protected void onPushAVForceStopScreenShare(String str, String str2, String str3) {
    }

    protected void onPushAVHeartbeatRsp(int i2, String str, IGProHeartbeatRsq iGProHeartbeatRsq) {
    }

    protected void onPushAVRoomOptChange(IGProAVRoomOptPushInfo iGProAVRoomOptPushInfo) {
    }

    public void onPushAVUserStateChange(IGProAVUserStateChangeInfo iGProAVUserStateChangeInfo) {
    }

    protected void onPushAllowScreenShareInGuild(String str, String str2, boolean z, long j2) {
    }

    protected void onPushBussinessConfig(int i2, byte[] bArr) {
    }

    protected void onPushCanceledSpeak(IGProAVUserStateChangeInfo iGProAVUserStateChangeInfo) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPushChannelDestroy(String str, List<String> list) {
    }

    protected void onPushDirectMsgNotifyUpdate(String str, String str2, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPushDirectMsgSwitchUpdate(int i2) {
    }

    protected void onPushInvitationRefused(String str, String str2, String str3, String str4) {
    }

    protected void onPushInviteMemberEvent(String str, String str2, String str3, IGuildSchemaConfig iGuildSchemaConfig) {
    }

    protected void onPushInvitedToSpeak(IGProAVUserStateChangeInfo iGProAVUserStateChangeInfo) {
    }

    protected void onPushKickOutAudioChannel(String str, String str2, String str3, String str4, int i2, String str5, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPushPermissionInGuild(String str, String str2, boolean z, long j2) {
    }

    protected void onPushSendGiftEventNotify(String str, String str2, IGProSendGiftEventData iGProSendGiftEventData) {
    }

    protected void onPushUserGiftRankChangeNotify(String str, String str2, IGProUserGiftRankInfo iGProUserGiftRankInfo) {
    }

    protected void onPushUserHandUpResult(IGProAVUserStateChangeInfo iGProAVUserStateChangeInfo) {
    }

    protected void onPushUserScreenShare(String str, String str2, List<GProScreenShareUserData> list, String str3) {
    }

    protected void onQQMsgListChannelDataReady() {
    }

    @Deprecated
    protected void onQQMsgListChannelUpdated() {
    }

   // protected void onQQMsgListChannelUpdated(List<Integer> list, List<fc> list2) {
   // }

   // protected void onQQMsgListGuildUpdated(List<Integer> list, List<fd> list2) {
   // }

    protected void onRecommendGuildChannelListUpdate(IGProGuildData iGProGuildData) {
    }

    protected void onRecommendGuildEntryUpdateNotify() {
    }

    protected void onRecommendGuildInfoUpdate(IGProRecommendGuildInfo iGProRecommendGuildInfo) {
    }

    protected void onRecommendGuildJumpChannelNotify(IGProDailyRecommendPush iGProDailyRecommendPush) {
    }

    protected void onRecommendGuildPersonalSettingUpdate(IGProRecommendGuildPersonalSetting iGProRecommendGuildPersonalSetting) {
    }

    protected void onRecommendGuildPollingResult(List<IGProPollingData> list) {
    }

    protected void onRecommendGuildStickyTopAdd(List<IGProStickyChannel> list) {
    }

    protected void onRecommendGuildStickyTopRemove(List<IGProStickyChannel> list) {
    }

    protected void onRecommendGuildStickyTopUpdate(List<IGProStickyChannel> list) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRemoveGuild(String str) {
    }

    protected void onRobotStateChangeNotifyForAll(String str, String str2, ArrayList<IGProUserInfo> arrayList, IGProChannelUserNum iGProChannelUserNum) {
    }

    protected void onSecurityResult(IGProSecurityResult iGProSecurityResult) {
    }

    protected void onSelfBannedSpeakChange(String str, String str2, String str3, int i2) {
    }

    protected void onSessionInitComplete(int i2, String str, String str2) {
    }

    protected void onShutUpStateChanged(String str, long j2) {
    }

    protected void onSmobaGameUserChangeNotifyForAll(String str, String str2, ArrayList<IGProUserInfo> arrayList, IGProChannelUserNum iGProChannelUserNum) {
    }

    protected void onSortRole(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSpeakLimitChanged(String str, String str2) {
    }

    //protected void onSpeakableThresholdUpdate(List<String> list, List<eu> list2) {
   // }

    protected void onStickyChannelAdded(List<IGProStickyChannel> list) {
    }

    protected void onStickyChannelRemoved(List<IGProStickyChannel> list) {
    }

    protected void onStickyChannelUpdated(List<IGProStickyChannel> list) {
    }

    protected void onSwitchFollowAdminMsgNotify(String str) {
    }

    protected void onTabRedPointPollingResult(boolean z, String str) {
    }

    protected void onUserAVStateResetNotifyForAll(String str, String str2, ArrayList<IGProUserInfo> arrayList, IGProChannelUserNum iGProChannelUserNum) {
    }

    protected void onUserDisplayNameUpdate(String str) {
    }

    protected void onUserEnterListNotifyForAll(String str, String str2, ArrayList<IGProUserInfo> arrayList, IGProChannelUserNum iGProChannelUserNum) {
    }

    protected void onUserGuidePush(IGProUserGuideMsg iGProUserGuideMsg) {
    }

    protected void onUserHandUpRequestNotifyForAll(String str, String str2, ArrayList<IGProUserInfo> arrayList, IGProChannelUserNum iGProChannelUserNum) {
    }

    protected void onUserLeaveListNotifyForAll(String str, String str2, ArrayList<IGProUserInfo> arrayList, IGProChannelUserNum iGProChannelUserNum) {
    }

    protected void onUserLevelRoleIdChanged(String str, String str2) {
    }

    protected void onUserListUpdated(String str) {
    }

    protected void onUserMuteSeatInGuild(String str, String str2, boolean z, long j2) {
    }

    protected void onUserNickUpdate(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    //public void onUserProfileInfoUpdate(int i2, String str, String str2, String str3, em emVar) {
    //}

    protected void onUserSpeakingNotifyForAll(String str, String str2, ArrayList<IGProUserInfo> arrayList, IGProChannelUserNum iGProChannelUserNum) {
    }

    protected void onUserWaitingToSpeakNotifyForAll(String str, String str2, ArrayList<IGProUserInfo> arrayList, IGProChannelUserNum iGProChannelUserNum) {
    }

    protected void onVoiceHeartbeatTimeout(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onVoiceSmobaGameRooManageUpdate(IGProVoiceSmobaGameRoomManageSysMsg iGProVoiceSmobaGameRoomManageSysMsg) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    //public void onVoiceSmobaGameUserActionUpdate(eo eoVar) {
    //}

    //protected void onYLGameTeamInfoUpdate(ep epVar) {
    //}

    @Override // java.util.Observer
    public void update(Observable observable, final Object obj) {
        if (obj == null) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    GPServiceObserver.this.onUpdate(obj);
                }
            });
        } else {
            onUpdate(obj);
        }
    }
}
