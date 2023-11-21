package com.tencent.mobileqq.relation.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qroute.QRouteApi;
import java.util.ArrayList;
import java.util.HashMap;
import tencent.mobileim.structmsg.*;

public interface IAddFriendTempApi extends QRouteApi {
    public static final int ENTER_FROM_CONTACT_TAB = 1;

    public static final int ENTER_FROM_DEFAULT = 0;

    public static final int ENTER_FROM_MESSAGE_TAB = 2;

    public static final int ENTER_FROM_NEW_FRIEND = 3;

    public static final int ENTER_FROM_NEW_FRIEND_MORE = 4;

//    void addBatchQIMFriends(List<QIMNotifyAddFriend> paramList, AppInterface paramAppInterface);

    void addFriendToFriendList(AppInterface paramAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong);

    void addListener(Object paramObject, AppInterface paramAppInterface);

    void cancelMayKnowRecommend(String paramString, AppInterface paramAppInterface);

//    void changeStructMsgActions(structmsg.StructMsg paramStructMsg, int paramInt1, String paramString, int paramInt2);

//    boolean changeStructMsgActionsWhenFail(structmsg.StructMsg paramStructMsg, int paramInt, String paramString1, String paramString2);

    void checkReadContactPermission(Runnable paramRunnable, AppInterface paramAppInterface);

    void checkUpdate(AppInterface paramAppInterface, String paramString);

    void clearAllSystemMsg(AppInterface paramAppInterface);

    void clickQIMSource(Context paramContext, MessageRecord paramMessageRecord, AppInterface paramAppInterface);

    Intent composeReturnIntent(Class<?> paramClass, String paramString, Activity paramActivity);

    void deleteAllSuspiciousMsg(AppInterface paramAppInterface);

//    void deleteQIMNotifyAddFriendData(QIMNotifyAddFriend paramQIMNotifyAddFriend, AppInterface paramAppInterface);

    boolean enableCheckPermission();

    void followUser(String paramString, boolean paramBoolean);

    Intent getAddRequestIntent(Context paramContext);

    Intent getBindNumberIntent(Context paramContext);

    Intent getChatActivityIntent(Context paramContext);

//    ArrayList<MayKnowRecommend> getConnectionsPersonLocal(int paramInt, AppInterface paramAppInterface);

    void getConnectionsPersonRemoteNextPage(int paramInt, AppInterface paramAppInterface);

//    ArrayList<a> getConnectionsTabInfoListLocal(AppInterface paramAppInterface);

    void getDiscussInfo(long paramLong, AppInterface paramAppInterface);

    String getDiscussionNameCanNull(AppInterface paramAppInterface, String paramString);

    int getForwardSelectionRequest();

    Intent getFriendProfileMoreInfoIntent(Context paramContext);

    int getMayKnowLoadConnectionBizTypeFirstLoad();

    int getMayKnowPersonNum(AppInterface paramAppInterface);

    boolean getMayKnowRecommendRemoteFromNewFrd(AppInterface paramAppInterface);

    String getQIMNewFriendSource(AppInterface paramAppInterface);

//    ArrayList<s> getQIMNotifyAddFriendsMsg(boolean paramBoolean, AppInterface paramAppInterface);

    String getQQInfoFromQQUin(long paramLong1, long paramLong2, AppInterface paramAppInterface);

    HashMap<String, String> getQidianExternal(HashMap<String, Object> paramHashMap);

//    String getRecommendLabelString(List<MayKnowRecommend.MayKnowRecommendLabel> paramList);

    int getRequestForSetting();

    int getSizeSmall();

    void getSuspiciousFriendsUnreadNum(AppInterface paramAppInterface);

    int getTypeSetConnectionsSwitch();

    Object getValue(String paramString1, String paramString2, int paramInt1, int paramInt2);

    void gotoFriendSettingBrowser(Context paramContext);

    boolean hasQidianExternal(HashMap<String, Object> paramHashMap);

    boolean hasQimSource(AppInterface paramAppInterface);

    void insertCommonHobbyIfNeeded(AppInterface paramAppInterface, String paramString);

    boolean isMayKnowConnectionsUserClosed(AppInterface paramAppInterface);

    boolean isNewFrdMiniCardSwitchOn(AppInterface paramAppInterface);

    boolean isPhoneContactEnabled(AppInterface paramAppInterface);

    boolean isQidianMaster(AppInterface paramAppInterface, String paramString);

    boolean isStudyMode(AppInterface paramAppInterface);

    boolean isSuspiciousSwitchOpen();

//    void jumpToMoveGroup(Activity paramActivity, QBaseFragment paramQBaseFragment, String paramString, int paramInt1, int paramInt2);

    void jumpToNewFriendMoreSysMsgSuspiciousFragment(Context paramContext);

    void jumpToNewFriendMoreSysMsgSuspiciousFragment(Context paramContext, Intent paramIntent, int paramInt);

    void jumpToQidianProfile(String paramString, Activity paramActivity);

    void jumpToSplash(Activity paramActivity);

    void launchPluginBroadcastWhenToggleSwitch(String paramString, AppInterface paramAppInterface, boolean paramBoolean);

    void loadConnectionsTabData(AppInterface paramAppInterface, int paramInt1, int paramInt2);

    void markQIMNotifyAddFriendsRead(AppInterface paramAppInterface);

//    void openSecCheckWebForFragment(AppInterface paramAppInterface, Context paramContext, QBaseFragment paramQBaseFragment, int paramInt, String paramString1, String paramString2);

//    void recordStartExpose(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3, AppInterface paramAppInterface);

//    void recordStopExpose(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3, AppInterface paramAppInterface);

    void removeListener(Object paramObject, AppInterface paramAppInterface);

    void reportExtendFriend(int paramInt, String paramString, Intent paramIntent);

    void reportRecommend(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, byte[] paramArrayOfbyte, String paramString4, int paramInt4);

    void reportRecommendExpose(AppInterface paramAppInterface, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Integer> paramArrayList, ArrayList<byte[]> paramArrayList3, int paramInt2);

    void sendAddFriendNoticeForBaby(AppInterface paramAppInterface, Intent paramIntent);

//    void sendDelSingleSystemMsg(structmsg.StructMsg paramStructMsg, String paramString, int paramInt, long paramLong, AppInterface paramAppInterface);

    void sendFriendSystemMsgAction(int msg_type, long msg_seq, long req_uin, int sub_type, int src_id, int sub_src_id, int group_msg_type, structmsg$SystemMsgActionInfo action_info, int system_msg_action_type, structmsg$StructMsg paramStructMsg, boolean isUncommonlyUsedFrd, AppInterface paramAppInterface);

    void sendFriendSystemMsgReadedReport(AppInterface paramAppInterface);

    void sendGetNextFriendSystemMsg(AppInterface paramAppInterface);

    void sendPokeMsg(AppInterface paramAppInterface, Context paramContext, String paramString);

    void setConnectionsSwitch(boolean paramBoolean, AppInterface paramAppInterface);

    boolean shouldShowMayKnowInNewFriend(AppInterface paramAppInterface);

//    void startAddContactsPage(Context paramContext, int paramInt1, int paramInt2, LaunchMode paramLaunchMode, @Nullable Bundle paramBundle);

    void startAddContactsPageForResult(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3);

    void startAddRequestPage(Context paramContext, Intent paramIntent);

    void startAddRequestPageForResult(Activity paramActivity, Intent paramIntent, int paramInt);

    void startAddRequestSuspiciousPage(Context paramContext, Intent paramIntent);

    void startContactBindFromOther(AppInterface paramAppInterface, int paramInt1, int paramInt2, Intent paramIntent);

    void startContactBindFromOther(AppInterface paramAppInterface, int paramInt, ArrayList<PhoneContact> paramArrayList);

    void startRemarkAfterAgree(Activity paramActivity, int paramInt, String paramString, long paramLong, Bundle paramBundle);

    void updateCustomNoteTxt(TextView paramTextView, int paramInt1, int paramInt2);
}
