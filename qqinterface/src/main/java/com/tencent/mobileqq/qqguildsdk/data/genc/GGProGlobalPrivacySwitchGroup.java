package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGlobalPrivacySwitchGroup;

public  class GGProGlobalPrivacySwitchGroup implements IGProGlobalPrivacySwitchGroup {
    public final GProGlobalPrivacySwitchGroup mInfo;

    public GGProGlobalPrivacySwitchGroup(GProGlobalPrivacySwitchGroup gProGlobalPrivacySwitchGroup) {
        this.mInfo = gProGlobalPrivacySwitchGroup;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalPrivacySwitchGroup
    public int getAddFriendSwitch() {
        return this.mInfo.getAddFriendSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalPrivacySwitchGroup
    public int getAllSwitch() {
        return this.mInfo.getAllSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalPrivacySwitchGroup
    public int getJoinedGuildShowSwitch() {
        return this.mInfo.getJoinedGuildShowSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalPrivacySwitchGroup
    public int getPublishedFeedShowSwitch() {
        return this.mInfo.getPublishedFeedShowSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalPrivacySwitchGroup
    public int getQqProfileShowSwitch() {
        return this.mInfo.getQqProfileShowSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalPrivacySwitchGroup
    public int getRoomStateShowSwitch() {
        return this.mInfo.getRoomStateShowSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalPrivacySwitchGroup
    public String toString() {
        return this.mInfo.toString();
    }
}
