package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGuildSearchRsp {
    ArrayList<String> highlightWords;
    GProUnionResult unionResult;

    public GProGuildSearchRsp() {
        this.unionResult = new GProUnionResult();
        this.highlightWords = new ArrayList<>();
    }

    public ArrayList<String> getHighlightWords() {
        return this.highlightWords;
    }

    public GProUnionResult getUnionResult() {
        return this.unionResult;
    }

    public String toString() {
        return "GProGuildSearchRsp{unionResult=" + this.unionResult + ",highlightWords=" + this.highlightWords + ",}";
    }

    public GProGuildSearchRsp(GProUnionResult gProUnionResult, ArrayList<String> arrayList) {
        this.unionResult = new GProUnionResult();
        this.highlightWords = new ArrayList<>();
        this.unionResult = gProUnionResult;
        this.highlightWords = arrayList;
    }
}
