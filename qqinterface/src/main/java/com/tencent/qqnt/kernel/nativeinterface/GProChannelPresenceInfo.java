package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProChannelPresenceInfo {
    ArrayList<GProChannelPresenceItemInfo> itemList;
    long playSpeed;
    int templateId;

    public GProChannelPresenceInfo() {
        this.itemList = new ArrayList<>();
    }

    public ArrayList<GProChannelPresenceItemInfo> getItemList() {
        return this.itemList;
    }

    public long getPlaySpeed() {
        return this.playSpeed;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public String toString() {
        return "GProChannelPresenceInfo{templateId=" + this.templateId + ",itemList=" + this.itemList + ",playSpeed=" + this.playSpeed + ",}";
    }

    public GProChannelPresenceInfo(int i2, ArrayList<GProChannelPresenceItemInfo> arrayList, long j2) {
        this.itemList = new ArrayList<>();
        this.templateId = i2;
        this.itemList = arrayList;
        this.playSpeed = j2;
    }
}
