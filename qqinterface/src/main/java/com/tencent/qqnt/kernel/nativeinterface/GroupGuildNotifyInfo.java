package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class GroupGuildNotifyInfo {
    long channelId;
    int muteSwitch;
    Contact peer;
    ArrayList<SceneDetailInfo> sceneDetailInfo;
    long senderUin;
    Summary summary;
    long timeStamp;

    public GroupGuildNotifyInfo() {
        this.peer = new Contact();
        this.sceneDetailInfo = new ArrayList<>();
        this.summary = new Summary();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getMuteSwitch() {
        return this.muteSwitch;
    }

    public Contact getPeer() {
        return this.peer;
    }

    public ArrayList<SceneDetailInfo> getSceneDetailInfo() {
        return this.sceneDetailInfo;
    }

    public long getSenderUin() {
        return this.senderUin;
    }

    public Summary getSummary() {
        return this.summary;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String toString() {
        return "GroupGuildNotifyInfo{peer=" + this.peer + ",sceneDetailInfo=" + this.sceneDetailInfo + ",timeStamp=" + this.timeStamp + ",muteSwitch=" + this.muteSwitch + ",senderUin=" + this.senderUin + ",summary=" + this.summary + ",channelId=" + this.channelId + ",}";
    }

    public GroupGuildNotifyInfo(Contact contact, ArrayList<SceneDetailInfo> arrayList, long j2, int i2, long j3, Summary summary, long j4) {
        this.peer = new Contact();
        this.sceneDetailInfo = new ArrayList<>();
        this.summary = new Summary();
        this.peer = contact;
        this.sceneDetailInfo = arrayList;
        this.timeStamp = j2;
        this.muteSwitch = i2;
        this.senderUin = j3;
        this.summary = summary;
        this.channelId = j4;
    }
}
