package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProBotInfo {
    long appid;
    int inlineSearch;
    long mark;
    String name;
    long tinyid;
    long uin;

    public GProBotInfo() {
        this.name = "";
    }

    public long getAppid() {
        return this.appid;
    }

    public int getInlineSearch() {
        return this.inlineSearch;
    }

    public long getMark() {
        return this.mark;
    }

    public String getName() {
        return this.name;
    }

    public long getTinyid() {
        return this.tinyid;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProBotInfo{tinyid=" + this.tinyid + ",uin=" + this.uin + ",name=" + this.name + ",inlineSearch=" + this.inlineSearch + ",appid=" + this.appid + ",mark=" + this.mark + ",}";
    }

    public GProBotInfo(long j2, long j3, String str, int i2, long j4, long j5) {
        this.name = "";
        this.tinyid = j2;
        this.uin = j3;
        this.name = str;
        this.inlineSearch = i2;
        this.appid = j4;
        this.mark = j5;
    }
}
