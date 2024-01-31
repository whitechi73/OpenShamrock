package com.tencent.qqnt.kernel.nativeinterface;



public final class SearchDiscussChatInfo {
    long discussCode;
    String discussName;

    public SearchDiscussChatInfo() {
        this.discussName = "";
    }

    public long getDiscussCode() {
        return this.discussCode;
    }

    public String getDiscussName() {
        return this.discussName;
    }

    public String toString() {
        return "SearchDiscussChatInfo{discussCode=" + this.discussCode + ",discussName=" + this.discussName + ",}";
    }

    public SearchDiscussChatInfo(long j2, String str) {
        this.discussName = "";
        this.discussCode = j2;
        this.discussName = str;
    }
}
