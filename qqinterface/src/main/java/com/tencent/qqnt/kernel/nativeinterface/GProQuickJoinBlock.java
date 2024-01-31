package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProQuickJoinBlock implements Serializable {
    ArrayList<String> membersAvatar;
    ArrayList<GProQuickJoinItem> quickJoinItems;
    long serialVersionUID;
    ArrayList<GProQuickJoinCycleStatusTag> statusTag;

    public GProQuickJoinBlock() {
        this.serialVersionUID = 1L;
        this.membersAvatar = new ArrayList<>();
        this.statusTag = new ArrayList<>();
        this.quickJoinItems = new ArrayList<>();
    }

    public ArrayList<String> getMembersAvatar() {
        return this.membersAvatar;
    }

    public ArrayList<GProQuickJoinItem> getQuickJoinItems() {
        return this.quickJoinItems;
    }

    public ArrayList<GProQuickJoinCycleStatusTag> getStatusTag() {
        return this.statusTag;
    }

    public String toString() {
        return "GProQuickJoinBlock{membersAvatar=" + this.membersAvatar + ",statusTag=" + this.statusTag + ",quickJoinItems=" + this.quickJoinItems + ",}";
    }

    public GProQuickJoinBlock(ArrayList<String> arrayList, ArrayList<GProQuickJoinCycleStatusTag> arrayList2, ArrayList<GProQuickJoinItem> arrayList3) {
        this.serialVersionUID = 1L;
        this.membersAvatar = new ArrayList<>();
        this.statusTag = new ArrayList<>();
        this.quickJoinItems = new ArrayList<>();
        this.membersAvatar = arrayList;
        this.statusTag = arrayList2;
        this.quickJoinItems = arrayList3;
    }
}
