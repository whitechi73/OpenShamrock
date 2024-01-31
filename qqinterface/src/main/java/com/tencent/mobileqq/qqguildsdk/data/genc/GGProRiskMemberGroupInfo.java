package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBlackUserInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRiskMemberGroupInfo implements IGProRiskMemberGroupInfo {

    @Override
    public long getGroupId() {
        return 0;
    }

    @Override
    public String getGroupName() {
        return null;
    }

    @Override
    public ArrayList<IGProBlackUserInfo> getRptMemberList() {
        return null;
    }

    @Override
    public int getTotalNum() {
        return 0;
    }
}
