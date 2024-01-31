package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProAudioLiveUserListRsp implements Serializable {
    GProChannelMemberInfos channelMemberInfo;
    GProChannelUserNum channelUserNum;
    GProChannelMemberInfos handUpMemberInfo;
    boolean isEndPage;
    long nextReadInterval;
    long serialVersionUID;
    GProChannelMemberInfos speakOrderMemberInfo;

    public GProAudioLiveUserListRsp() {
        this.serialVersionUID = 1L;
        this.channelMemberInfo = new GProChannelMemberInfos();
        this.handUpMemberInfo = new GProChannelMemberInfos();
        this.speakOrderMemberInfo = new GProChannelMemberInfos();
        this.channelUserNum = new GProChannelUserNum();
    }

    public GProChannelMemberInfos getChannelMemberInfo() {
        return this.channelMemberInfo;
    }

    public GProChannelUserNum getChannelUserNum() {
        return this.channelUserNum;
    }

    public GProChannelMemberInfos getHandUpMemberInfo() {
        return this.handUpMemberInfo;
    }

    public boolean getIsEndPage() {
        return this.isEndPage;
    }

    public long getNextReadInterval() {
        return this.nextReadInterval;
    }

    public GProChannelMemberInfos getSpeakOrderMemberInfo() {
        return this.speakOrderMemberInfo;
    }

    public String toString() {
        return "GProAudioLiveUserListRsp{channelMemberInfo=" + this.channelMemberInfo + ",handUpMemberInfo=" + this.handUpMemberInfo + ",nextReadInterval=" + this.nextReadInterval + ",isEndPage=" + this.isEndPage + ",speakOrderMemberInfo=" + this.speakOrderMemberInfo + ",channelUserNum=" + this.channelUserNum + ",}";
    }

    public GProAudioLiveUserListRsp(GProChannelMemberInfos gProChannelMemberInfos, GProChannelMemberInfos gProChannelMemberInfos2, long j2, boolean z, GProChannelMemberInfos gProChannelMemberInfos3, GProChannelUserNum gProChannelUserNum) {
        this.serialVersionUID = 1L;
        this.channelMemberInfo = new GProChannelMemberInfos();
        this.handUpMemberInfo = new GProChannelMemberInfos();
        this.speakOrderMemberInfo = new GProChannelMemberInfos();
        this.channelUserNum = new GProChannelUserNum();
        this.channelMemberInfo = gProChannelMemberInfos;
        this.handUpMemberInfo = gProChannelMemberInfos2;
        this.nextReadInterval = j2;
        this.isEndPage = z;
        this.speakOrderMemberInfo = gProChannelMemberInfos3;
        this.channelUserNum = gProChannelUserNum;
    }
}
