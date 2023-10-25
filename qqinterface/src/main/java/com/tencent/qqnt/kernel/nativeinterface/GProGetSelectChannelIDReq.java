package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGetSelectChannelIDReq {
    String code;
    ArrayList<GProSelectChannel> selectChannels;

    public GProGetSelectChannelIDReq() {
        this.code = "";
        this.selectChannels = new ArrayList<>();
    }

    public String getCode() {
        return this.code;
    }

    public ArrayList<GProSelectChannel> getSelectChannels() {
        return this.selectChannels;
    }

    public String toString() {
        return "GProGetSelectChannelIDReq{code=" + this.code + ",selectChannels=" + this.selectChannels + ",}";
    }

    public GProGetSelectChannelIDReq(String str, ArrayList<GProSelectChannel> arrayList) {
        this.code = "";
        this.selectChannels = new ArrayList<>();
        this.code = str;
        this.selectChannels = arrayList;
    }
}
