package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class NewBuddyGrayElement implements Serializable {
    String friendNick;
    boolean isInitiator;
    long serialVersionUID;
    int sourceId;
    int subSourceId;
    long time;

    public NewBuddyGrayElement() {
        this.serialVersionUID = 1L;
        this.friendNick = "";
    }

    public String getFriendNick() {
        return this.friendNick;
    }

    public boolean getIsInitiator() {
        return this.isInitiator;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public int getSubSourceId() {
        return this.subSourceId;
    }

    public long getTime() {
        return this.time;
    }

    public String toString() {
        return "NewBuddyGrayElement{time=" + this.time + ",sourceId=" + this.sourceId + ",subSourceId=" + this.subSourceId + ",isInitiator=" + this.isInitiator + ",friendNick=" + this.friendNick + ",}";
    }

    public NewBuddyGrayElement(long j2, int i2, int i3, boolean z, String str) {
        this.serialVersionUID = 1L;
        this.friendNick = "";
        this.time = j2;
        this.sourceId = i2;
        this.subSourceId = i3;
        this.isInitiator = z;
        this.friendNick = str;
    }
}