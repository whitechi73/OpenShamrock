package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProUnionResult {
    byte[] feedCookie;
    boolean feedIsEnd;
    long feedTotal;
    ArrayList<GProGuildFeedSearchRes> guildFeeds;
    ArrayList<GProGuildMsgSearchRes> guildMsgs;
    byte[] msgCookie;
    boolean msgIsEnd;
    long msgTotal;

    public GProUnionResult() {
        this.guildMsgs = new ArrayList<>();
        this.msgCookie = new byte[0];
        this.guildFeeds = new ArrayList<>();
        this.feedCookie = new byte[0];
    }

    public byte[] getFeedCookie() {
        return this.feedCookie;
    }

    public boolean getFeedIsEnd() {
        return this.feedIsEnd;
    }

    public long getFeedTotal() {
        return this.feedTotal;
    }

    public ArrayList<GProGuildFeedSearchRes> getGuildFeeds() {
        return this.guildFeeds;
    }

    public ArrayList<GProGuildMsgSearchRes> getGuildMsgs() {
        return this.guildMsgs;
    }

    public byte[] getMsgCookie() {
        return this.msgCookie;
    }

    public boolean getMsgIsEnd() {
        return this.msgIsEnd;
    }

    public long getMsgTotal() {
        return this.msgTotal;
    }

    public String toString() {
        return "GProUnionResult{msgTotal=" + this.msgTotal + ",guildMsgs=" + this.guildMsgs + ",msgCookie=" + this.msgCookie + ",msgIsEnd=" + this.msgIsEnd + ",feedTotal=" + this.feedTotal + ",guildFeeds=" + this.guildFeeds + ",feedCookie=" + this.feedCookie + ",feedIsEnd=" + this.feedIsEnd + ",}";
    }

    public GProUnionResult(long j2, ArrayList<GProGuildMsgSearchRes> arrayList, byte[] bArr, boolean z, long j3, ArrayList<GProGuildFeedSearchRes> arrayList2, byte[] bArr2, boolean z2) {
        this.guildMsgs = new ArrayList<>();
        this.msgCookie = new byte[0];
        this.guildFeeds = new ArrayList<>();
        this.feedCookie = new byte[0];
        this.msgTotal = j2;
        this.guildMsgs = arrayList;
        this.msgCookie = bArr;
        this.msgIsEnd = z;
        this.feedTotal = j3;
        this.guildFeeds = arrayList2;
        this.feedCookie = bArr2;
        this.feedIsEnd = z2;
    }
}
