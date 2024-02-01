package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IGProFetchMemberListWithRoleCallback {
    void onFetchMemberListWithRoleCallback(int result, String reason, boolean finish, long nextIndex, long nextRoleIdIndex, boolean isSmallGuild, int seq, ArrayList<GProRoleMemberList> roleList);
}
