package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchChatSummaryItem {
    ArrayList<SearchBuddyChatInfo> buddyChatInfo;
    SearchChatInfo chatInfo;
    int chatType;
    ArrayList<SearchDataLineChatInfo> dataLineChatInfo;
    ArrayList<SearchDiscussChatInfo> discussChatInfo;
    ArrayList<SearchGroupChatInfo> groupChatInfo;
    int msgCount;
    ArrayList<SearchMsgItem> msgItem;
    long msgTime;
    String peerUid;
    ArrayList<TempChatGameSession> tmpChatInfo;

    public SearchChatSummaryItem() {
        this.peerUid = "";
        this.chatInfo = new SearchChatInfo();
        this.buddyChatInfo = new ArrayList<>();
        this.discussChatInfo = new ArrayList<>();
        this.groupChatInfo = new ArrayList<>();
        this.dataLineChatInfo = new ArrayList<>();
        this.tmpChatInfo = new ArrayList<>();
        this.msgItem = new ArrayList<>();
    }

    public ArrayList<SearchBuddyChatInfo> getBuddyChatInfo() {
        return this.buddyChatInfo;
    }

    public SearchChatInfo getChatInfo() {
        return this.chatInfo;
    }

    public int getChatType() {
        return this.chatType;
    }

    public ArrayList<SearchDataLineChatInfo> getDataLineChatInfo() {
        return this.dataLineChatInfo;
    }

    public ArrayList<SearchDiscussChatInfo> getDiscussChatInfo() {
        return this.discussChatInfo;
    }

    public ArrayList<SearchGroupChatInfo> getGroupChatInfo() {
        return this.groupChatInfo;
    }

    public int getMsgCount() {
        return this.msgCount;
    }

    public ArrayList<SearchMsgItem> getMsgItem() {
        return this.msgItem;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public ArrayList<TempChatGameSession> getTmpChatInfo() {
        return this.tmpChatInfo;
    }

    public String toString() {
        return "SearchChatSummaryItem{chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",chatInfo=" + this.chatInfo + ",buddyChatInfo=" + this.buddyChatInfo + ",discussChatInfo=" + this.discussChatInfo + ",groupChatInfo=" + this.groupChatInfo + ",dataLineChatInfo=" + this.dataLineChatInfo + ",tmpChatInfo=" + this.tmpChatInfo + ",msgCount=" + this.msgCount + ",msgTime=" + this.msgTime + ",msgItem=" + this.msgItem + ",}";
    }

    public SearchChatSummaryItem(int i2, String str, SearchChatInfo searchChatInfo, ArrayList<SearchBuddyChatInfo> arrayList, ArrayList<SearchDiscussChatInfo> arrayList2, ArrayList<SearchGroupChatInfo> arrayList3, ArrayList<SearchDataLineChatInfo> arrayList4, ArrayList<TempChatGameSession> arrayList5, int i3, long j2, ArrayList<SearchMsgItem> arrayList6) {
        this.peerUid = "";
        this.chatInfo = new SearchChatInfo();
        this.buddyChatInfo = new ArrayList<>();
        this.discussChatInfo = new ArrayList<>();
        this.groupChatInfo = new ArrayList<>();
        this.dataLineChatInfo = new ArrayList<>();
        this.tmpChatInfo = new ArrayList<>();
        this.msgItem = new ArrayList<>();
        this.chatType = i2;
        this.peerUid = str;
        this.chatInfo = searchChatInfo;
        this.buddyChatInfo = arrayList;
        this.discussChatInfo = arrayList2;
        this.groupChatInfo = arrayList3;
        this.dataLineChatInfo = arrayList4;
        this.tmpChatInfo = arrayList5;
        this.msgCount = i3;
        this.msgTime = j2;
        this.msgItem = arrayList6;
    }
}
