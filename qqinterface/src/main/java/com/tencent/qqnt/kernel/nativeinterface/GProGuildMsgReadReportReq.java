package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGuildMsgReadReportReq {
    ArrayList<GProMyChannelInfo> rptMsgMyChannelList;
    int uint32Type;
    long uint64MemberId;

    public GProGuildMsgReadReportReq() {
        this.rptMsgMyChannelList = new ArrayList<>();
    }

    public ArrayList<GProMyChannelInfo> getRptMsgMyChannelList() {
        return this.rptMsgMyChannelList;
    }

    public int getUint32Type() {
        return this.uint32Type;
    }

    public long getUint64MemberId() {
        return this.uint64MemberId;
    }

    public String toString() {
        return "GProGuildMsgReadReportReq{uint64MemberId=" + this.uint64MemberId + ",rptMsgMyChannelList=" + this.rptMsgMyChannelList + ",uint32Type=" + this.uint32Type + ",}";
    }

    public GProGuildMsgReadReportReq(long j2, ArrayList<GProMyChannelInfo> arrayList, int i2) {
        this.rptMsgMyChannelList = new ArrayList<>();
        this.uint64MemberId = j2;
        this.rptMsgMyChannelList = arrayList;
        this.uint32Type = i2;
    }
}
