package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

public interface IKernelMsgListener {
    void onAddSendMsg(MsgRecord msgRecord);

    void onBroadcastHelperDownloadComplete(BroadcastHelperTransNotifyInfo broadcastHelperTransNotifyInfo);

    void onBroadcastHelperProgerssUpdate(BroadcastHelperTransNotifyInfo broadcastHelperTransNotifyInfo);

    void onChannelFreqLimitInfoUpdate(Contact contact, boolean z, FreqLimitInfo freqLimitInfo);

    void onContactUnreadCntUpdate(HashMap<Integer, HashMap<String, UnreadCntInfo>> hashMap);

    void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig);

    void onDraftUpdate(Contact contact, ArrayList<MsgElement> arrayList, long j2);

    void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo);

    void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo);

    void onFeedEventUpdate(FirstViewDirectMsgNotifyInfo firstViewDirectMsgNotifyInfo);

    void onFileMsgCome(ArrayList<MsgRecord> arrayList);

    void onFirstViewDirectMsgUpdate(FirstViewDirectMsgNotifyInfo firstViewDirectMsgNotifyInfo);

    void onFirstViewGroupGuildMapping(ArrayList<FirstViewGroupGuildInfo> arrayList);

    void onGrabPasswordRedBag(int i2, String str, int i3, RecvdOrder recvdOrder, MsgRecord msgRecord);

    void onGroupFileInfoAdd(GroupItem groupItem);

    void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult);

    void onGroupGuildUpdate(GroupGuildNotifyInfo groupGuildNotifyInfo);

    void onGroupTransferInfoAdd(GroupItem groupItem);

    void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult);

    void onGuildInteractiveUpdate(GuildInteractiveNotificationItem guildInteractiveNotificationItem);

    void onGuildNotificationAbstractUpdate(GuildNotificationAbstractInfo guildNotificationAbstractInfo);

    void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo);

    void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult);

    void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo);

    void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo);

    void onInputStatusPush(InputStatusInfo inputStatusInfo);

    void onKickedOffLine(KickedInfo kickedInfo);

    void onLineDev(ArrayList<DevInfo> arrayList);

    void onLogLevelChanged(long j2);

    void onMsgAbstractUpdate(ArrayList<MsgAbstract> arrayList);

    void onMsgBoxChanged(ArrayList<ContactMsgBoxInfo> arrayList);

    void onMsgDelete(Contact contact, ArrayList<Long> arrayList);

    void onMsgEventListUpdate(HashMap<String, ArrayList<Long>> hashMap);

    void onMsgInfoListAdd(ArrayList<MsgRecord> arrayList);

    void onMsgInfoListUpdate(ArrayList<MsgRecord> arrayList);

    void onMsgQRCodeStatusChanged(int i2);

    void onMsgRecall(int i2, String str, long j2);

    void onMsgSecurityNotify(MsgRecord msgRecord);

    void onMsgSettingUpdate(MsgSetting msgSetting);

    void onNtFirstViewMsgSyncEnd();

    void onNtMsgSyncEnd();

    void onNtMsgSyncStart();

    void onReadFeedEventUpdate(FirstViewDirectMsgNotifyInfo firstViewDirectMsgNotifyInfo);

    void onRecvGroupGuildFlag(int i2);

    void onRecvMsg(ArrayList<MsgRecord> arrayList);

    void onRecvMsgSvrRspTransInfo(long j2, Contact contact, int i2, int i3, String str, byte[] bArr);

    void onRecvOnlineFileMsg(ArrayList<MsgRecord> arrayList);

    void onRecvS2CMsg(ArrayList<Byte> arrayList);

    void onRecvSysMsg(ArrayList<Byte> arrayList);

    void onRecvUDCFlag(int i2);

    void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo);

    void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo);

    void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo);

    void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult);

    void onSendMsgError(long j2, Contact contact, int i2, String str);

    void onSysMsgNotification(int i2, long j2, long j3, ArrayList<Byte> arrayList);

    void onTempChatInfoUpdate(TempChatInfo tempChatInfo);

    void onUnreadCntAfterFirstView(HashMap<Integer, ArrayList<UnreadCntInfo>> hashMap);

    void onUnreadCntUpdate(HashMap<Integer, ArrayList<UnreadCntInfo>> hashMap);

    void onUserChannelTabStatusChanged(boolean z);

    void onUserOnlineStatusChanged(boolean z);

    void onUserTabStatusChanged(ArrayList<TabStatusInfo> arrayList);

    void onlineStatusBigIconDownloadPush(int i2, long j2, String str);

    void onlineStatusSmallIconDownloadPush(int i2, long j2, String str);
}
