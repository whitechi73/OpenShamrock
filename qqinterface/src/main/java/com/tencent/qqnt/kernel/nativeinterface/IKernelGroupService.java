package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IKernelGroupService {
    void getTransferableMemberInfo(long uin, IGetTransferableMemberCallback cb);

    long addKernelGroupListener(IKernelGroupListener ln);

    void getAllMemberList(long groupCode, boolean refresh, IGroupMemberListCallback iGroupMemberListCallback);

    void getMemberCommonInfo(GroupMemberCommonReq groupMemberCommonReq, IGroupMemberCommonCallback iGroupMemberCommonCallback);

    void getMemberExtInfo(GroupMemberExtReq groupMemberExtReq, IGroupMemberExtCallback iGroupMemberExtCallback);

    void getMemberInfo(long j2, ArrayList<String> arrayList, boolean z, IOperateCallback iOperateCallback);

    void getMemberInfoForMqq(long groupCode, ArrayList<String> uids, boolean z, IGroupMemberListCallback iGroupMemberListCallback);

    void getNextMemberList(String sceneId, GroupMemberInfoListId groupMemberInfoListId, int i2, IGroupMemberListCallback iGroupMemberListCallback);

    void getPrevMemberList(String sceneId, GroupMemberInfoListId groupMemberInfoListId, int i2, IGroupMemberListCallback iGroupMemberListCallback);


}
