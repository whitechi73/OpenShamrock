package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProAVShowMsgInfo;

import java.util.ArrayList;

public  class GGProAVShowMsgInfo implements IGProAVShowMsgInfo {
    public final GProAVShowMsgInfo mInfo;

    public GGProAVShowMsgInfo(GProAVShowMsgInfo gProAVShowMsgInfo) {
        this.mInfo = gProAVShowMsgInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVShowMsgInfo
    public ArrayList<String> getButtonMsgs() {
        return this.mInfo.getButtonMsgs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVShowMsgInfo
    public String getShowMsg() {
        return this.mInfo.getShowMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVShowMsgInfo
    public int getShowSeconds() {
        return this.mInfo.getShowSeconds();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVShowMsgInfo
    public int getShowType() {
        return this.mInfo.getShowType();
    }
}
