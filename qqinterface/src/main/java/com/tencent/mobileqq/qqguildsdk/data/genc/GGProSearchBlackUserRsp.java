package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBlackUserInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProSearchBlackUserRsp implements IGProSearchBlackUserRsp {

    @Override
    public byte[] getBuf() {
        return new byte[0];
    }

    @Override
    public long getGuildId() {
        return 0;
    }

    @Override
    public String getKeyword() {
        return null;
    }

    @Override
    public ArrayList<IGProBlackUserInfo> getMemberList() {
        return null;
    }

    @Override
    public long getNextPos() {
        return 0;
    }

    @Override
    public String getTraceId() {
        return null;
    }
}
