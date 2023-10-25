package com.tencent.qqnt.msg.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.kernel.nativeinterface.*;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

import kotlin.Pair;
import kotlinx.coroutines.flow.Flow;

public interface IMsgService extends QRouteApi {
    void addLocalGrayTipMsg(@NotNull Contact contact, @NotNull LocalGrayTipElement localGrayTipElement, boolean z, @Nullable IOperateCallback iOperateCallback);

    void addLocalTofuRecordMsg(@NotNull Contact contact, @NotNull TofuRecordElement tofuRecordElement, @Nullable IOperateCallback iOperateCallback);

    void addSendMsg(@NotNull Contact contact, @NotNull ArrayList<MsgElement> msgElements);

    //void cancelGetRichMediaElement(@NotNull RichMediaElementGetReq richMediaElementGetReq);

    void cancelSendMsg(long j2, @NotNull String str, int i2);

    void clickInlineKeyboardButton(@NotNull InlineKeyboardClickInfo inlineKeyboardClickInfo, @NotNull IClickInlineKeyboardButtonCallback iClickInlineKeyboardButtonCallback);

    @NotNull
    Flow<ArrayList<ContactMsgBoxInfo>> contactMsgBoxChangedFlow();

    void deleteDraft(@NotNull Contact contact, @Nullable IOperateCallback iOperateCallback);

    void deleteMsg(@NotNull Contact contact, @Nullable ArrayList<Long> arrayList, @Nullable IOperateCallback iOperateCallback);

    void deleteRecallMsg(@Nullable Contact contact, long j2, @Nullable IOperateCallback iOperateCallback);

    void deleteRecallMsgForLocal(@Nullable Contact contact, long j2, @Nullable IOperateCallback iOperateCallback);

    void deleteReplyDraft(@NotNull Contact contact, long j2, @Nullable IOperateCallback iOperateCallback);

    //@NotNull
    //Flow<FeedsBoxEvent> feedsEventFlow();

    void fetchGroupGuildUnread(@NotNull Contact contact, boolean z, @Nullable IOperateCallback iOperateCallback);

    void forwardFile(@NotNull TargetFileInfo targetFileInfo, @NotNull Contact contact, @NotNull IOperateCallback iOperateCallback);

    void forwardMsg(@NotNull ArrayList<Long> arrayList, @NotNull Contact contact, @NotNull ArrayList<Contact> arrayList2, @Nullable ArrayList<MsgElement> arrayList3, @NotNull IForwardOperateCallback iForwardOperateCallback);

    //void getABatchOfContactMsgBoxInfo(@NotNull ArrayList<Contact> arrayList, @NotNull IGetMsgsBoxesCallback iGetMsgsBoxesCallback);

    //void getAioFirstViewLatestMsgs(@NotNull Contact contact, int i2, @NotNull IGetAioFirstViewLatestMsgCallback iGetAioFirstViewLatestMsgCallback);

    void getAllDirectSessionUnreadCntInfo(@Nullable IUnreadCntCallback iUnreadCntCallback);

    void getAllGuildUnreadCntInfo(@Nullable IUnreadCntCallback iUnreadCntCallback);

    @Nullable
    GroupAnonymousInfo getAnonymousInfo(@Nullable String str);

    void getCategoryUnreadCntInfo(@Nullable Contact contact, @Nullable IUnreadCntCallback iUnreadCntCallback);

    void getChannelEventFlow(@Nullable Contact contact);

    void getChannelEventFlow(@Nullable String str, @Nullable String str2, @Nullable Integer num);

    void getChannelFreqLimitInfo(@Nullable Contact contact);

    void getContactUnreadCnt(@Nullable IOperateCallback iOperateCallback);

    //void getDraft(@NotNull Contact contact, @Nullable IGetDraftOperateCallback iGetDraftOperateCallback);

    //void getFirstUnreadAtallMsg(@Nullable Contact contact, @Nullable IFetchChannelLatestSeqCallback iFetchChannelLatestSeqCallback);

    //void getFirstUnreadAtmeMsg(@Nullable Contact contact, @Nullable IFetchChannelLatestSeqCallback iFetchChannelLatestSeqCallback);

    //void getFirstUnreadCommonMsg(@Nullable Contact contact, @Nullable IFetchChannelLatestSeqCallback iFetchChannelLatestSeqCallback);

    //void getFirstUnreadMsgSeq(@NotNull Contact contact, @NotNull IGetMsgSeqCallback iGetMsgSeqCallback);

    //void getGuestMsgAbstracts(@NotNull String str, @NotNull ArrayList<String> arrayList, int i2, @Nullable IGuestGetMsgAbstractsCallback iGuestGetMsgAbstractsCallback);

    //void getGuestMsgByRange(@Nullable Contact contact, long j2, int i2, boolean z, int i3, @Nullable IGuestMsgOperateCallback iGuestMsgOperateCallback);

    void getGuildFeedsUnreadCntInfo(@Nullable Contact contact, @Nullable IUnreadCntCallback iUnreadCntCallback);

   // void getGuildGroupBubble(@NotNull Contact contact, boolean z, @Nullable IGetGuildGroupBubbleCallback iGetGuildGroupBubbleCallback);

    //void getGuildGroupTransData(@Nullable Contact contact, @Nullable IGetGuildBinaryDataCallback iGetGuildBinaryDataCallback);

   // void getGuildUnreadCntInfo(@Nullable Contact contact, @Nullable IUnreadCntCallback iUnreadCntCallback);

    //@NotNull
    //Flow<f> getLatestDbMsgList(@NotNull Contact contact, int i2);

    //void getLatestDbMsgs(@NotNull Contact contact, int i2, @NotNull IMsgOperateCallback iMsgOperateCallback);

    void getMsgAbstract(@NotNull Contact contact, long j2, @Nullable IGProGetMsgAbstractsCallback iGProGetMsgAbstractsCallback);

    void getMsgAbstracts(@Nullable String str, @Nullable ArrayList<String> arrayList, @Nullable IGProGetMsgAbstractsCallback iGProGetMsgAbstractsCallback);

    void getMsgByClientSeqAndTime(@Nullable Contact contact, long clientSeq, long time, @Nullable IMsgOperateCallback iMsgOperateCallback);

    //void getMsgEmojiLikesList(@Nullable Contact contact, long j2, @Nullable String str, long j3, @Nullable String str2, boolean z, int i2, @Nullable IGProGetMsgEmojiLikesListCallback iGProGetMsgEmojiLikesListCallback);

    //@NotNull
    //Flow<f> getMsgList(@NotNull Contact contact, long j2, int i2, boolean z);

    void getMsgSetting(@Nullable IOperateCallback iOperateCallback);

    void getMsgs(@NotNull Contact contact, long msgId, int cnt, boolean z, @NotNull IMsgOperateCallback iMsgOperateCallback);

    void getMsgsByMsgId(@Nullable Contact contact, @Nullable ArrayList<Long> msgIds, @Nullable IMsgOperateCallback callback);

    void getMsgsBySeqAndCount(@Nullable Contact contact, long seq, int cnt, boolean z, @Nullable IMsgOperateCallback cb);

    void getMsgsBySeqRange(@Nullable Contact contact, long start, long end, @Nullable IMsgOperateCallback cb);

    void getMsgsBySeqs(@Nullable Contact contact, @NotNull ArrayList<Long> seqs, @Nullable IMsgOperateCallback cb);

    //@Nullable
    //Object getMsgsBySeqsSuspend(@NotNull Contact contact, long j2, boolean z, @NotNull Continuation<? super c<ArrayList<MsgRecord>>> continuation);

    void getMsgsByTypeFilters(@Nullable Contact contact, long j2, int i2, boolean z, @Nullable ArrayList<MsgTypeFilter> arrayList, @Nullable IMsgOperateCallback iMsgOperateCallback);

    //void getNavigateInfo(@Nullable Contact contact, @Nullable IFetchNavigateInfoCallback iFetchNavigateInfoCallback);

    @NotNull
    Flow<InputStatusInfo> getOnInputStatusPush();

    void getOnLineDev(@Nullable IOperateCallback iOperateCallback);

    void getRecallMsgsByMsgId(@Nullable Contact contact, @NotNull ArrayList<Long> arrayList, @Nullable IMsgOperateCallback iMsgOperateCallback);

    //void getRecentUseEmojiList(@Nullable IGProGetRecentUseEmojiListCallback iGProGetRecentUseEmojiListCallback);

   // void getReplyDraft(@NotNull Contact contact, long j2, @Nullable IGetDraftOperateCallback iGetDraftOperateCallback);

    //void getRichMediaElement(@NotNull RichMediaElementGetReq richMediaElementGetReq);

    void getSingleMsg(@Nullable Contact contact, long j2, @Nullable IMsgOperateCallback iMsgOperateCallback);

    void getSourceOfReplyMsg(@Nullable Contact contact, long j2, long j3, @Nullable IMsgOperateCallback iMsgOperateCallback);

    void getUnreadCntInfo(@Nullable Contact contact, @Nullable IUnreadCntCallback iUnreadCntCallback);

    void getUnreadCntInfo(@Nullable ArrayList<Contact> arrayList, @Nullable IUnreadCntCallback iUnreadCntCallback);

   // void init(@Nullable k kVar);

    void insertGameResultAsMsgToDb(@Nullable MsgRecord msgRecord, @Nullable IOperateCallback iOperateCallback);

    //void isGuildChannelSync(@Nullable MatchKey matchKey, @Nullable IMatchedOperateCallback iMatchedOperateCallback);

    void kickOffLine(@NotNull DevInfo devInfo, @Nullable IOperateCallback iOperateCallback);

    void onScenesChangeForSilenceMode(int i2);

   // void queryMsgsWithFilterEx(long j2, long j3, long j4, @NotNull QueryMsgsParams queryMsgsParams, @NotNull IMsgOperateCallback iMsgOperateCallback);

    void recallMsg(@NotNull Contact contact, long j2, @Nullable IOperateCallback iOperateCallback);

    @NotNull
    Flow<Contact> receiveClearMsgRecordsFlow();

    @NotNull
    //Flow<i> receiveSysMsgNotificationFlow();

    void reeditRecallMsg(@Nullable Contact contact, long j2, @Nullable IOperateCallback iOperateCallback);

    void refreshMsgAbstracts(@NotNull String str, @Nullable ArrayList<String> arrayList);

   // @NotNull
   // Flow<com.tencent.qqnt.msg.data.c> registerChannelFreqLimitInfoUpdateNotificationFlow();

    @NotNull
    Flow<CustomWithdrawConfig> registerCustomWithdrawConfigUpdateFlow();

    //@NotNull
  //  Flow<e> registerDeleteMsgNotificationFlow();

   // @NotNull
  //  Flow<d> registerDraftUpdateNotificationFlow();

   // @NotNull
    //Flow<List<com.tencent.qqnt.msg.e>> registerFileComeNotificationFlow();

   // @NotNull
    //Flow<com.tencent.qqnt.msg.data.a> registerMsgAbstractUpdateNotificationFlow();

   // @NotNull
    //Flow<ArrayList<com.tencent.qqnt.msg.e>> registerMsgInfoListAddNotificationFlow();

   // @NotNull
   // Flow<ArrayList<com.tencent.qqnt.msg.e>> registerMsgStatusUpdateNotificationFlow();

    @NotNull
    Flow<ArrayList<Long>> registerOnMsgDeleteNotificationFlow();

    //@NotNull
    //Flow<List<com.tencent.qqnt.msg.e>> registerReceiveMsgNotificationFlow();

    @NotNull
    Flow<FileTransNotifyInfo> registerRichMediaDownloadCompleteFlow();

    @NotNull
    Flow<FileTransNotifyInfo> registerRichMediaDownloadProgressFlow();

    @NotNull
    Flow<FileTransNotifyInfo> registerRichMediaUploadCompleteFlow();

    //@NotNull
    //Flow<com.tencent.qqnt.msg.e> registerSecurityNotificationFlow();

    //@NotNull
    //Flow<com.tencent.qqnt.msg.e> registerSendMsgNotificationFlow();

    void registerSysMsgNotification(int i2, long j2, @NotNull ArrayList<Long> arrayList, @Nullable IOperateCallback iOperateCallback);

    //@NotNull
    //Flow<j> registerUnreadCntInfoUpdateFlow();

    //void renameAnonyChatNick(@Nullable String str, @Nullable IRenameAnonymousChatNickCallback iRenameAnonymousChatNickCallback);

    void resendMsg(@NotNull Contact contact, long j2, @Nullable IOperateCallback iOperateCallback);

    void sendInputStatusReq(int i2, int i3, @NotNull String str, @NotNull IOperateCallback iOperateCallback);

    void sendMsg(@NotNull Contact contact, long msgId, @NotNull ArrayList<MsgElement> arrayList, @Nullable IOperateCallback iOperateCallback);

    void sendMsg(@NotNull Contact contact, @NotNull ArrayList<MsgElement> arrayList, @Nullable IOperateCallback iOperateCallback);

    void sendMsg(@NotNull Contact contact, @NotNull ArrayList<MsgElement> arrayList, @NotNull HashMap<Integer, MsgAttributeInfo> msgAttributes, @Nullable IOperateCallback callback);

   // @NotNull
   // Flow<g> sendMsgErrorNotificationFlow();

    void sendMsgWithMsgId(@NotNull Contact contact, long msgId, @NotNull ArrayList<MsgElement> arrayList, @Nullable IOperateCallback iOperateCallback);

    void sendSummonMsg(@NotNull Contact contact, @NotNull ArrayList<MsgElement> arrayList, @Nullable IOperateCallback iOperateCallback);

    void setAllGuildMsgRead(@Nullable IOperateCallback iOperateCallback);

    void setBuildMode(int i2);

    void setConfigurationServiceData(@NotNull HashMap<Long, String> hashMap);

    void setCurOnScreenMsg(@NotNull Contact contact, int i2, @NotNull ArrayList<Long> arrayList);

    void setDraft(@NotNull Contact contact, @NotNull ArrayList<MsgElement> arrayList, @Nullable IOperateCallback iOperateCallback);

    void setFocusOnGuild(boolean z);

    void setFocusSession(@NotNull Contact contact, boolean z, int i2);

    void setGroupGuildBubbleRead(@NotNull Contact contact, @Nullable IOperateCallback iOperateCallback);

    void setGroupGuildFlag(int i2);

    //void setGroupGuildMsgRead(@NotNull Contact contact, @NotNull ArrayList<SceneInfoParam> arrayList, boolean z, boolean z2, @Nullable IOperateCallback iOperateCallback);

    void setGuildMsgRead(@Nullable String str, @Nullable IOperateCallback iOperateCallback);

    void setGuildTabUserFlag(int i2);

    void setGuildUDCFlag(int i2);

    void setLocalMsgRead(@NotNull Contact contact, @Nullable IOperateCallback iOperateCallback);

   // void setMsgEmojiLikes(@Nullable Contact contact, long j2, @Nullable String str, long j3, boolean z, @Nullable IGProSetMsgEmojiLikesCallback iGProSetMsgEmojiLikesCallback);

  //  void setMsgEmojiLikesForRole(@Nullable Contact contact, long j2, @Nullable String str, long j3, long j4, long j5, boolean z, boolean z2, @Nullable IGProSetMsgEmojiLikesForRoleCallback iGProSetMsgEmojiLikesForRoleCallback);

    void setMsgRead(@NotNull Contact contact, @Nullable IOperateCallback iOperateCallback);

    void setMsgReadAndReport(@NotNull Contact contact, @NotNull MsgRecord msgRecord, @Nullable IOperateCallback iOperateCallback);

    void setMsgSetting(@NotNull MsgSetting msgSetting, @Nullable IOperateCallback iOperateCallback);

    void setReplyDraft(@NotNull Contact contact, long j2, @NotNull ArrayList<MsgElement> arrayList, @Nullable IOperateCallback iOperateCallback);

    void startGuildMsgSync();

   // void switchAnonymousChat(@Nullable String str, boolean z, @Nullable ISwitchAnonymousChatCallback iSwitchAnonymousChatCallback);

    void unregisterSysMsgNotification(int i2, long j2, @NotNull ArrayList<Long> arrayList, @Nullable IOperateCallback iOperateCallback);

    void updateElementExtBufForUI(@NotNull Contact contact, long j2, long j3, @NotNull byte[] bArr, @Nullable IOperateCallback iOperateCallback);
}
