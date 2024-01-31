package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProExposeRecommedsReq {
    ArrayList<GProExposeItem> exposeItems;
    String stage;
    String traceId;
    String user;

    public GProExposeRecommedsReq() {
        this.user = "";
        this.traceId = "";
        this.stage = "";
        this.exposeItems = new ArrayList<>();
    }

    public ArrayList<GProExposeItem> getExposeItems() {
        return this.exposeItems;
    }

    public String getStage() {
        return this.stage;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getUser() {
        return this.user;
    }

    public String toString() {
        return "GProExposeRecommedsReq{user=" + this.user + ",traceId=" + this.traceId + ",stage=" + this.stage + ",exposeItems=" + this.exposeItems + ",}";
    }

    public GProExposeRecommedsReq(String str, String str2, String str3, ArrayList<GProExposeItem> arrayList) {
        this.user = "";
        this.traceId = "";
        this.stage = "";
        this.exposeItems = new ArrayList<>();
        this.user = str;
        this.traceId = str2;
        this.stage = str3;
        this.exposeItems = arrayList;
    }
}
