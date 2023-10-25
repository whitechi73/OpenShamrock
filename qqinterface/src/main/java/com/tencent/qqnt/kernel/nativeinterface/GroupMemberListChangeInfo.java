package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

public final class GroupMemberListChangeInfo {
    boolean hasNext;
    boolean hasPrev;
    ArrayList<GroupMemberInfoListId> ids;
    HashMap<String, MemberInfo> infos;
    String sceneId;

    public GroupMemberListChangeInfo() {
        this.sceneId = "";
        this.ids = new ArrayList<>();
        this.infos = new HashMap<>();
    }

    public boolean getHasNext() {
        return this.hasNext;
    }

    public boolean getHasPrev() {
        return this.hasPrev;
    }

    public ArrayList<GroupMemberInfoListId> getIds() {
        return this.ids;
    }

    public HashMap<String, MemberInfo> getInfos() {
        return this.infos;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public String toString() {
        return "GroupMemberListChangeInfo{sceneId=" + this.sceneId + ",ids=" + this.ids + ",infos=" + this.infos + ",hasPrev=" + this.hasPrev + ",hasNext=" + this.hasNext + ",}";
    }

    public GroupMemberListChangeInfo(String str, ArrayList<GroupMemberInfoListId> arrayList, HashMap<String, MemberInfo> hashMap, boolean z, boolean z2) {
        this.sceneId = "";
        this.ids = new ArrayList<>();
        this.infos = new HashMap<>();
        this.sceneId = str;
        this.ids = arrayList;
        this.infos = hashMap;
        this.hasPrev = z;
        this.hasNext = z2;
    }
}