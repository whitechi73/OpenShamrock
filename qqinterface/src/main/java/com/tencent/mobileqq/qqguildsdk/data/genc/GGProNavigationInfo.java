package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProNavigationInfo;


public class GGProNavigationInfo implements IGProNavigationInfo {
    public final GProNavigationInfo mInfo;

    public GGProNavigationInfo(GProNavigationInfo gProNavigationInfo) {
        this.mInfo = gProNavigationInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
    public String getBubbleDesc() {
        return this.mInfo.getBubbleDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
    public String getJumpUrl() {
        return this.mInfo.getJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
    public int getJumpUrlType() {
        return this.mInfo.getJumpUrlType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
    public boolean getShowBubble() {
        return this.mInfo.getShowBubble();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
