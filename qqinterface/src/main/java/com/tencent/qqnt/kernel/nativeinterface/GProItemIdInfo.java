package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProItemIdInfo implements Serializable {
    long channelId;
    long guildId;
    long itemIdI64;
    String itemIdStr;
    int itemType;
    String originId;
    long serialVersionUID;

    public GProItemIdInfo() {
        this.serialVersionUID = 1L;
        this.itemIdStr = "";
        this.originId = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getItemIdI64() {
        return this.itemIdI64;
    }

    public String getItemIdStr() {
        return this.itemIdStr;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getOriginId() {
        return this.originId;
    }

    public String toString() {
        return "GProItemIdInfo{itemIdStr=" + this.itemIdStr + ",itemIdI64=" + this.itemIdI64 + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",itemType=" + this.itemType + ",originId=" + this.originId + ",}";
    }

    public GProItemIdInfo(String str, long j2, long j3, long j4, int i2, String str2) {
        this.serialVersionUID = 1L;
        this.itemIdStr = "";
        this.originId = "";
        this.itemIdStr = str;
        this.itemIdI64 = j2;
        this.guildId = j3;
        this.channelId = j4;
        this.itemType = i2;
        this.originId = str2;
    }
}
