package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;

import java.util.ArrayList;

public  class GGProGuildMemberSearchResult implements IGProGuildMemberSearchResult {

    @Override
    public ArrayList<IGProUserInfo> getMembers() {
        return null;
    }

    @Override
    public long getNextPos() {
        return 0;
    }

    @Override
    public ArrayList<IGProGuildRoleInfo> getRoles() {
        return null;
    }
}
