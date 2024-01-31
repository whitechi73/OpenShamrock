package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProRetentionGuildListRsp {
    byte[] cookies;
    boolean isEnd;
    int nextTs;
    ArrayList<GProRetentionChannelInfo> recommendChannels;

    public GProRetentionGuildListRsp() {
        this.recommendChannels = new ArrayList<>();
        this.cookies = new byte[0];
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public int getNextTs() {
        return this.nextTs;
    }

    public ArrayList<GProRetentionChannelInfo> getRecommendChannels() {
        return this.recommendChannels;
    }

    public String toString() {
        return "GProRetentionGuildListRsp{recommendChannels=" + this.recommendChannels + ",nextTs=" + this.nextTs + ",cookies=" + this.cookies + ",isEnd=" + this.isEnd + ",}";
    }

    public GProRetentionGuildListRsp(ArrayList<GProRetentionChannelInfo> arrayList, int i2, byte[] bArr, boolean z) {
        this.recommendChannels = new ArrayList<>();
        this.cookies = new byte[0];
        this.recommendChannels = arrayList;
        this.nextTs = i2;
        this.cookies = bArr;
        this.isEnd = z;
    }
}
