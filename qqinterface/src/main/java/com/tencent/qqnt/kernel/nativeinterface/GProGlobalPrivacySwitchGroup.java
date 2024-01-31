package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGlobalPrivacySwitchGroup {
    int addFriendSwitch;
    int allSwitch;
    int joinedGuildShowSwitch;
    int publishedFeedShowSwitch;
    int qqProfileShowSwitch;
    int roomStateShowSwitch;

    public GProGlobalPrivacySwitchGroup() {
    }

    public int getAddFriendSwitch() {
        return this.addFriendSwitch;
    }

    public int getAllSwitch() {
        return this.allSwitch;
    }

    public int getJoinedGuildShowSwitch() {
        return this.joinedGuildShowSwitch;
    }

    public int getPublishedFeedShowSwitch() {
        return this.publishedFeedShowSwitch;
    }

    public int getQqProfileShowSwitch() {
        return this.qqProfileShowSwitch;
    }

    public int getRoomStateShowSwitch() {
        return this.roomStateShowSwitch;
    }

    public String toString() {
        return "GProGlobalPrivacySwitchGroup{addFriendSwitch=" + this.addFriendSwitch + ",allSwitch=" + this.allSwitch + ",qqProfileShowSwitch=" + this.qqProfileShowSwitch + ",roomStateShowSwitch=" + this.roomStateShowSwitch + ",joinedGuildShowSwitch=" + this.joinedGuildShowSwitch + ",publishedFeedShowSwitch=" + this.publishedFeedShowSwitch + ",}";
    }

    public GProGlobalPrivacySwitchGroup(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.addFriendSwitch = i2;
        this.allSwitch = i3;
        this.qqProfileShowSwitch = i4;
        this.roomStateShowSwitch = i5;
        this.joinedGuildShowSwitch = i6;
        this.publishedFeedShowSwitch = i7;
    }
}
