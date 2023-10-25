package com.tencent.qqnt.kernel.nativeinterface;

public final class AnonymousExtInfo {
    int anonymousFlag;
    byte[] anonymousId;
    String anonymousNick;
    long bubbleId;
    long expireTime;
    long headPicIndex;
    String rankColor;

    public AnonymousExtInfo() {
        this.anonymousId = new byte[0];
        this.anonymousNick = "";
        this.rankColor = "";
    }

    public int getAnonymousFlag() {
        return this.anonymousFlag;
    }

    public byte[] getAnonymousId() {
        return this.anonymousId;
    }

    public String getAnonymousNick() {
        return this.anonymousNick;
    }

    public long getBubbleId() {
        return this.bubbleId;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public long getHeadPicIndex() {
        return this.headPicIndex;
    }

    public String getRankColor() {
        return this.rankColor;
    }

    public String toString() {
        return "AnonymousExtInfo{anonymousFlag=" + this.anonymousFlag + ",anonymousId=" + this.anonymousId + ",anonymousNick=" + this.anonymousNick + ",headPicIndex=" + this.headPicIndex + ",expireTime=" + this.expireTime + ",bubbleId=" + this.bubbleId + ",rankColor=" + this.rankColor + ",}";
    }

    public AnonymousExtInfo(int i2, byte[] bArr, String str, long j2, long j3, long j4, String str2) {
        this.anonymousId = new byte[0];
        this.anonymousNick = "";
        this.rankColor = "";
        this.anonymousFlag = i2;
        this.anonymousId = bArr;
        this.anonymousNick = str;
        this.headPicIndex = j2;
        this.expireTime = j3;
        this.bubbleId = j4;
        this.rankColor = str2;
    }
}
