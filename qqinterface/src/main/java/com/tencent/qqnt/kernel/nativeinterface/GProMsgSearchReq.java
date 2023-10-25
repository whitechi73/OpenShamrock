package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProMsgSearchReq {
    GProMsgSearchCond cond;
    String cookie;
    Integer count;
    long guildId;
    String query;
    long tinyId;
    Integer type;

    public GProMsgSearchReq() {
        this.cookie = "";
    }

    public GProMsgSearchCond getCond() {
        return this.cond;
    }

    public String getCookie() {
        return this.cookie;
    }

    public Integer getCount() {
        return this.count;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getQuery() {
        return this.query;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public Integer getType() {
        return this.type;
    }

    public String toString() {
        return "GProMsgSearchReq{tinyId=" + this.tinyId + ",guildId=" + this.guildId + ",query=" + this.query + ",type=" + this.type + ",cond=" + this.cond + ",cookie=" + this.cookie + ",count=" + this.count + ",}";
    }

    public GProMsgSearchReq(long j2, long j3, String str, Integer num, GProMsgSearchCond gProMsgSearchCond, String str2, Integer num2) {
        this.cookie = "";
        this.tinyId = j2;
        this.guildId = j3;
        this.query = str;
        this.type = num;
        this.cond = gProMsgSearchCond;
        this.cookie = str2;
        this.count = num2;
    }
}
