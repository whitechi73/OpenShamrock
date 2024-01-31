package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProClientPresence;

import org.jetbrains.annotations.NotNull;

public  class GProClientPresenceInfo implements IGProClientPresenceInfo {
    private final GProClientPresence presence;

    public GProClientPresenceInfo(GProClientPresence gProClientPresence) {
        this.presence = gProClientPresence;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo
    public String getBigIcon() {
        return this.presence.getBigIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo
    public int getClientId() {
        return this.presence.getClientId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo
    public String getClientName() {
        return this.presence.getClientName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo
    public String getDetails() {
        return this.presence.getDetails();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo
    public long getEndTimeStamp() {
        return this.presence.getEndTimeStamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo
    public long getExpireTimeStamp() {
        return this.presence.getExpireTimeStamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo
    public long getPartyMax() {
        return this.presence.getPartyMax();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo
    public long getPartySize() {
        return this.presence.getPartySize();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo
    public String getRole() {
        return this.presence.getRole();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo
    public String getSmallIcon() {
        return this.presence.getSmallIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo
    public long getStartTimeStamp() {
        return this.presence.getStartTimeStamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo
    public String getState() {
        return this.presence.getState();
    }

    @NotNull
    public String toString() {
        return "GProClientPresenceInfo{presence=" + this.presence + "}";
    }
}
