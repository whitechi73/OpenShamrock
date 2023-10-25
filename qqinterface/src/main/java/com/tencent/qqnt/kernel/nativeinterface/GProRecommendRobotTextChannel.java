package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes22.dex */
public final class GProRecommendRobotTextChannel {
    ArrayList<String> avatars;
    GProRecommendChannelInfo channelInfo;
    ArrayList<MsgAbstract> msgAbstracts;

    public GProRecommendRobotTextChannel() {
        this.channelInfo = new GProRecommendChannelInfo();
        this.msgAbstracts = new ArrayList<>();
        this.avatars = new ArrayList<>();
    }

    public ArrayList<String> getAvatars() {
        return this.avatars;
    }

    public GProRecommendChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public ArrayList<MsgAbstract> getMsgAbstracts() {
        return this.msgAbstracts;
    }

    public String toString() {
        return "GProRecommendRobotTextChannel{channelInfo=" + this.channelInfo + ",msgAbstracts=" + this.msgAbstracts + ",avatars=" + this.avatars + ",}";
    }

    public GProRecommendRobotTextChannel(GProRecommendChannelInfo gProRecommendChannelInfo, ArrayList<MsgAbstract> arrayList, ArrayList<String> arrayList2) {
        this.channelInfo = new GProRecommendChannelInfo();
        this.msgAbstracts = new ArrayList<>();
        this.avatars = new ArrayList<>();
        this.channelInfo = gProRecommendChannelInfo;
        this.msgAbstracts = arrayList;
        this.avatars = arrayList2;
    }
}
