package com.tencent.qqnt.kernel.nativeinterface;

public final class GroupAnonymousInfo {
    byte[] anonyId;
    String anonyNick;
    AnonyStatus anonyStatus;
    int bubbleId;
    int expiredTime;
    int headPicIndex;
    boolean isAnonymousChat;
    String rankColor;

    public GroupAnonymousInfo() {
        this.anonyId = new byte[0];
        this.anonyNick = "";
        this.anonyStatus = new AnonyStatus();
        this.rankColor = "";
    }

    public byte[] getAnonyId() {
        return this.anonyId;
    }

    public String getAnonyNick() {
        return this.anonyNick;
    }

    public AnonyStatus getAnonyStatus() {
        return this.anonyStatus;
    }

    public int getBubbleId() {
        return this.bubbleId;
    }

    public int getExpiredTime() {
        return this.expiredTime;
    }

    public int getHeadPicIndex() {
        return this.headPicIndex;
    }

    public boolean getIsAnonymousChat() {
        return this.isAnonymousChat;
    }

    public String getRankColor() {
        return this.rankColor;
    }

    public String toString() {
        return "GroupAnonymousInfo{isAnonymousChat=" + this.isAnonymousChat + ",anonyId=" + this.anonyId + ",anonyNick=" + this.anonyNick + ",headPicIndex=" + this.headPicIndex + ",bubbleId=" + this.bubbleId + ",expiredTime=" + this.expiredTime + ",anonyStatus=" + this.anonyStatus + ",rankColor=" + this.rankColor + ",}";
    }

    public GroupAnonymousInfo(boolean z, byte[] bArr, String str, int i2, int i3, int i4, AnonyStatus anonyStatus, String str2) {
        this.anonyId = new byte[0];
        this.anonyNick = "";
        this.anonyStatus = new AnonyStatus();
        this.rankColor = "";
        this.isAnonymousChat = z;
        this.anonyId = bArr;
        this.anonyNick = str;
        this.headPicIndex = i2;
        this.bubbleId = i3;
        this.expiredTime = i4;
        this.anonyStatus = anonyStatus;
        this.rankColor = str2;
    }
}
