package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

public interface IKernelGroupListener {
    void onGetGroupBulletinListResult(long j2, String str, GroupBulletinListResult groupBulletinListResult);

    void onGroupAvatarUrlChange(long j2, String str);

    void onGroupBulletinChange(long j2, GroupBulletin groupBulletin);

    void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo);

    void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo);

    void onGroupConfMemberChange(long j2, ArrayList<String> arrayList);

    void onGroupDetailInfoChange(GroupDetailInfo groupDetailInfo);

    void onGroupListUpdate(GroupListUpdateType groupListUpdateType, ArrayList<GroupSimpleInfo> arrayList);

    void onGroupNotifiesUnreadCountUpdated(boolean z, long j2, int i2);

    void onGroupNotifiesUpdated(boolean z, ArrayList<GroupNotifyMsg> arrayList);

    void onGroupPortraitChange(long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2);

    void onGroupSingleScreenNotifies(boolean z, long j2, ArrayList<GroupNotifyMsg> arrayList);

    void onGroupStatisticInfoChange(long j2, GroupStatisticInfo groupStatisticInfo);

    void onGroupsMsgMaskResult(ArrayList<GroupMsgMaskInfo> arrayList);

    void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg);

    void onMemberInfoChange(long j2, DataSource dataSource, HashMap<String, MemberInfo> hashMap);

    void onMemberListChange(GroupMemberListChangeInfo groupMemberListChangeInfo);

    void onSearchMemberChange(String str, String str2, ArrayList<GroupMemberInfoListId> arrayList, HashMap<String, MemberInfo> hashMap);

    void onShutUpMemberListChanged(long j2, ArrayList<MemberInfo> arrayList);
}
