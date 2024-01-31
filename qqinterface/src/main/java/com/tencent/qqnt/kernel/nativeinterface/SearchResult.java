package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchResult {
    long context;
    byte[] cookie;
    boolean isEnd;
    ArrayList<SearchResultGroup> resultGroup;

    public SearchResult() {
        this.cookie = new byte[0];
        this.resultGroup = new ArrayList<>();
    }

    public long getContext() {
        return this.context;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<SearchResultGroup> getResultGroup() {
        return this.resultGroup;
    }

    public String toString() {
        return "SearchResult{context=" + this.context + ",isEnd=" + this.isEnd + ",cookie=" + this.cookie + ",resultGroup=" + this.resultGroup + ",}";
    }

    public SearchResult(long j2, boolean z, byte[] bArr, ArrayList<SearchResultGroup> arrayList) {
        this.cookie = new byte[0];
        this.resultGroup = new ArrayList<>();
        this.context = j2;
        this.isEnd = z;
        this.cookie = bArr;
        this.resultGroup = arrayList;
    }
}
