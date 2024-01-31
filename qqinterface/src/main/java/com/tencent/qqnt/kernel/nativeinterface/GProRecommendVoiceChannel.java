package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProRecommendVoiceChannel implements Serializable {
    GProRecommendCoverInfo cover;
    long serialVersionUID;
    GProChannelMemberInfos voiceChannel;

    public GProRecommendVoiceChannel() {
        this.serialVersionUID = 1L;
        this.voiceChannel = new GProChannelMemberInfos();
        this.cover = new GProRecommendCoverInfo();
    }

    public GProRecommendCoverInfo getCover() {
        return this.cover;
    }

    public GProChannelMemberInfos getVoiceChannel() {
        return this.voiceChannel;
    }

    public String toString() {
        return "GProRecommendVoiceChannel{voiceChannel=" + this.voiceChannel + ",cover=" + this.cover + ",}";
    }

    public GProRecommendVoiceChannel(GProChannelMemberInfos gProChannelMemberInfos, GProRecommendCoverInfo gProRecommendCoverInfo) {
        this.serialVersionUID = 1L;
        this.voiceChannel = new GProChannelMemberInfos();
        this.cover = new GProRecommendCoverInfo();
        this.voiceChannel = gProChannelMemberInfos;
        this.cover = gProRecommendCoverInfo;
    }
}
