package com.tencent.qqnt.kernel.nativeinterface;


public final class SearchMsgWithKeywordsParams {
    int chatType;
    int pageLimit;
    String peerUid;
    int searchFields;

    public SearchMsgWithKeywordsParams() {
        this.peerUid = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public int getPageLimit() {
        return this.pageLimit;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public int getSearchFields() {
        return this.searchFields;
    }

    public String toString() {
        return "SearchMsgWithKeywordsParams{chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",searchFields=" + this.searchFields + ",pageLimit=" + this.pageLimit + ",}";
    }

    public SearchMsgWithKeywordsParams(int i2, String str, int i3, int i4) {
        this.peerUid = "";
        this.chatType = i2;
        this.peerUid = str;
        this.searchFields = i3;
        this.pageLimit = i4;
    }
}
