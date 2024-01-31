package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class SearchChatMsgsParams {
    ChatInfo chatInfo;
    long filterMsgFromTime;
    long filterMsgToTime;
    ArrayList<MsgTypeFilter> filterMsgType;
    ArrayList<String> filterSendersUid;
    int pageLimit;
    int searchFields;

    public SearchChatMsgsParams() {
        this.chatInfo = new ChatInfo();
        this.filterMsgType = new ArrayList<>();
        this.filterSendersUid = new ArrayList<>();
    }

    public ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    public long getFilterMsgFromTime() {
        return this.filterMsgFromTime;
    }

    public long getFilterMsgToTime() {
        return this.filterMsgToTime;
    }

    public ArrayList<MsgTypeFilter> getFilterMsgType() {
        return this.filterMsgType;
    }

    public ArrayList<String> getFilterSendersUid() {
        return this.filterSendersUid;
    }

    public int getPageLimit() {
        return this.pageLimit;
    }

    public int getSearchFields() {
        return this.searchFields;
    }

    public String toString() {
        return "SearchChatMsgsParams{chatInfo=" + this.chatInfo + ",searchFields=" + this.searchFields + ",filterMsgType=" + this.filterMsgType + ",filterSendersUid=" + this.filterSendersUid + ",filterMsgFromTime=" + this.filterMsgFromTime + ",filterMsgToTime=" + this.filterMsgToTime + ",pageLimit=" + this.pageLimit + ",}";
    }

    public SearchChatMsgsParams(ChatInfo chatInfo, int i2, ArrayList<MsgTypeFilter> arrayList, ArrayList<String> arrayList2, long j2, long j3, int i3) {
        this.chatInfo = new ChatInfo();
        this.filterMsgType = new ArrayList<>();
        this.filterSendersUid = new ArrayList<>();
        this.chatInfo = chatInfo;
        this.searchFields = i2;
        this.filterMsgType = arrayList;
        this.filterSendersUid = arrayList2;
        this.filterMsgFromTime = j2;
        this.filterMsgToTime = j3;
        this.pageLimit = i3;
    }
}
