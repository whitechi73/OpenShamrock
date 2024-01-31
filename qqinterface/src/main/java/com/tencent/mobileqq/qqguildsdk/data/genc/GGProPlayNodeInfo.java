package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProPlayNodeInfo;

import java.util.ArrayList;

public  class GGProPlayNodeInfo implements IGProPlayNodeInfo {
    public final GProPlayNodeInfo mInfo;

    public GGProPlayNodeInfo(GProPlayNodeInfo gProPlayNodeInfo) {
        this.mInfo = gProPlayNodeInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public int getAccessFlag() {
        return this.mInfo.getAccessFlag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public long getAddTime() {
        return this.mInfo.getAddTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public long getAddTinyId() {
        return this.mInfo.getAddTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public String getAddUserAvatarMeta() {
        return this.mInfo.getAddUserAvatarMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public String getAddUserName() {
        return this.mInfo.getAddUserName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public ArrayList<String> getBackgroundColorList() {
        return this.mInfo.getBackgroundColorList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public long getOrderNum() {
        return this.mInfo.getOrderNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public String getPlayNodeId() {
        return this.mInfo.getPlayNodeId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public int getPlaySourceDuration() {
        return this.mInfo.getPlaySourceDuration();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public String getPlaySourceId() {
        return this.mInfo.getPlaySourceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public String getPlaySourceName() {
        return this.mInfo.getPlaySourceName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public String getPlaySourcePic() {
        return this.mInfo.getPlaySourcePic();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public String getPlaySourceShowName() {
        return this.mInfo.getPlaySourceShowName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public String getSingerList() {
        return this.mInfo.getSingerList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public String getThirdSourceIcon() {
        return this.mInfo.getThirdSourceIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public String getThirdSourceId() {
        return this.mInfo.getThirdSourceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
