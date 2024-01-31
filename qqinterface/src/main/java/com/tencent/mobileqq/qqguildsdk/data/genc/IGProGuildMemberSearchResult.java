package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGuildMemberSearchResult extends Serializable {
    ArrayList<IGProUserInfo> getMembers();

    long getNextPos();

    ArrayList<IGProGuildRoleInfo> getRoles();

    String toString();
}
