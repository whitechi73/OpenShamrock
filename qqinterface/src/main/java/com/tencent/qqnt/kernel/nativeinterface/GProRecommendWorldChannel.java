package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProRecommendWorldChannel implements Serializable {
    GProRecommendCoverInfo cover;
    long serialVersionUID;
    GProChannelMemberInfos worldChannel;

    public GProRecommendWorldChannel() {
        this.serialVersionUID = 1L;
        this.worldChannel = new GProChannelMemberInfos();
        this.cover = new GProRecommendCoverInfo();
    }

    public GProRecommendCoverInfo getCover() {
        return this.cover;
    }

    public GProChannelMemberInfos getWorldChannel() {
        return this.worldChannel;
    }

    public String toString() {
        return "GProRecommendWorldChannel{worldChannel=" + this.worldChannel + ",cover=" + this.cover + ",}";
    }

    public GProRecommendWorldChannel(GProChannelMemberInfos gProChannelMemberInfos, GProRecommendCoverInfo gProRecommendCoverInfo) {
        this.serialVersionUID = 1L;
        this.worldChannel = new GProChannelMemberInfos();
        this.cover = new GProRecommendCoverInfo();
        this.worldChannel = gProChannelMemberInfos;
        this.cover = gProRecommendCoverInfo;
    }
}
