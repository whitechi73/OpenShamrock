package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProChannelCreateInfo {
    long appid;
    ArrayList<GProAuthControlSwitchInfo> authControlSwitchInfoList;
    ArrayList<GProBindMembers> bindMembersList;
    ArrayList<GProBindRoleGroups> bindRoleGroupsList;
    String linkChannelMetaData;
    ArrayList<Long> liveableMemberList;
    ArrayList<Long> liveableRoleList;
    int liveableType;
    int msgNotifyType;
    String name;
    int talkPermission;
    int textChannelSubtypeId;
    int type;
    ArrayList<Long> visibleMemberList;
    ArrayList<Long> visibleRoleList;
    int visibleType;

    public GProChannelCreateInfo() {
        this.name = "";
        this.visibleMemberList = new ArrayList<>();
        this.visibleRoleList = new ArrayList<>();
        this.liveableMemberList = new ArrayList<>();
        this.liveableRoleList = new ArrayList<>();
    }

    public long getAppid() {
        return this.appid;
    }

    public ArrayList<GProAuthControlSwitchInfo> getAuthControlSwitchInfoList() {
        return this.authControlSwitchInfoList;
    }

    public ArrayList<GProBindMembers> getBindMembersList() {
        return this.bindMembersList;
    }

    public ArrayList<GProBindRoleGroups> getBindRoleGroupsList() {
        return this.bindRoleGroupsList;
    }

    public String getLinkChannelMetaData() {
        return this.linkChannelMetaData;
    }

    public ArrayList<Long> getLiveableMemberList() {
        return this.liveableMemberList;
    }

    public ArrayList<Long> getLiveableRoleList() {
        return this.liveableRoleList;
    }

    public int getLiveableType() {
        return this.liveableType;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public String getName() {
        return this.name;
    }

    public int getTalkPermission() {
        return this.talkPermission;
    }

    public int getTextChannelSubtypeId() {
        return this.textChannelSubtypeId;
    }

    public int getType() {
        return this.type;
    }

    public ArrayList<Long> getVisibleMemberList() {
        return this.visibleMemberList;
    }

    public ArrayList<Long> getVisibleRoleList() {
        return this.visibleRoleList;
    }

    public int getVisibleType() {
        return this.visibleType;
    }

    public String toString() {
        return "GProChannelCreateInfo{name=" + this.name + ",type=" + this.type + ",talkPermission=" + this.talkPermission + ",msgNotifyType=" + this.msgNotifyType + ",appid=" + this.appid + ",visibleType=" + this.visibleType + ",visibleMemberList=" + this.visibleMemberList + ",visibleRoleList=" + this.visibleRoleList + ",liveableType=" + this.liveableType + ",liveableMemberList=" + this.liveableMemberList + ",liveableRoleList=" + this.liveableRoleList + ",textChannelSubtypeId=" + this.textChannelSubtypeId + ",authControlSwitchInfoList=" + this.authControlSwitchInfoList + ",bindRoleGroupsList=" + this.bindRoleGroupsList + ",bindMembersList=" + this.bindMembersList + ",linkChannelMetaData=" + this.linkChannelMetaData + ",}";
    }

    public GProChannelCreateInfo(String str, int i2, int i3, int i4, long j2, int i5, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i6, ArrayList<Long> arrayList3, ArrayList<Long> arrayList4, int i7, ArrayList<GProAuthControlSwitchInfo> arrayList5, ArrayList<GProBindRoleGroups> arrayList6, ArrayList<GProBindMembers> arrayList7, String str2) {
        this.name = "";
        this.visibleMemberList = new ArrayList<>();
        this.visibleRoleList = new ArrayList<>();
        this.liveableMemberList = new ArrayList<>();
        this.liveableRoleList = new ArrayList<>();
        this.name = str;
        this.type = i2;
        this.talkPermission = i3;
        this.msgNotifyType = i4;
        this.appid = j2;
        this.visibleType = i5;
        this.visibleMemberList = arrayList;
        this.visibleRoleList = arrayList2;
        this.liveableType = i6;
        this.liveableMemberList = arrayList3;
        this.liveableRoleList = arrayList4;
        this.textChannelSubtypeId = i7;
        this.authControlSwitchInfoList = arrayList5;
        this.bindRoleGroupsList = arrayList6;
        this.bindMembersList = arrayList7;
        this.linkChannelMetaData = str2;
    }
}
