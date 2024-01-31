package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProMsgSearchRsp {
    String cookie;
    GProDocHit docHit;
    boolean hasMore;
    ArrayList<GProGuildMsg> results;

    public GProMsgSearchRsp() {
        this.results = new ArrayList<>();
        this.cookie = "";
        this.docHit = new GProDocHit();
    }

    public String getCookie() {
        return this.cookie;
    }

    public GProDocHit getDocHit() {
        return this.docHit;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<GProGuildMsg> getResults() {
        return this.results;
    }

    public String toString() {
        return "GProMsgSearchRsp{results=" + this.results + ",cookie=" + this.cookie + ",hasMore=" + this.hasMore + ",docHit=" + this.docHit + ",}";
    }

    public GProMsgSearchRsp(ArrayList<GProGuildMsg> arrayList, String str, boolean z, GProDocHit gProDocHit) {
        this.results = new ArrayList<>();
        this.cookie = "";
        this.docHit = new GProDocHit();
        this.results = arrayList;
        this.cookie = str;
        this.hasMore = z;
        this.docHit = gProDocHit;
    }
}
