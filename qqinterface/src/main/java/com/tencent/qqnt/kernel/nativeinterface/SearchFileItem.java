package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchFileItem {
    ArrayList<SearchBuddyChatInfo> buddyChatInfo;
    int chatType;
    ArrayList<SearchDataLineChatInfo> dataLineChatInfo;
    ArrayList<SearchDiscussChatInfo> discussChatInfo;
    long elemId;
    int elemType;
    String fileName;
    String filePath;
    long fileSize;
    ArrayList<SearchGroupChatInfo> groupChatInfo;
    ArrayList<SearchHitInfo> hits;
    long msgId;
    long msgSeq;
    long msgTime;
    String senderCard;
    String senderNick;
    String senderRemark;
    String senderUid;
    ArrayList<TempChatGameSession> tmpChatInfo;

    public SearchFileItem() {
        this.buddyChatInfo = new ArrayList<>();
        this.discussChatInfo = new ArrayList<>();
        this.groupChatInfo = new ArrayList<>();
        this.dataLineChatInfo = new ArrayList<>();
        this.tmpChatInfo = new ArrayList<>();
        this.senderUid = "";
        this.senderNick = "";
        this.senderRemark = "";
        this.senderCard = "";
        this.filePath = "";
        this.fileName = "";
        this.hits = new ArrayList<>();
    }

    public ArrayList<SearchBuddyChatInfo> getBuddyChatInfo() {
        return this.buddyChatInfo;
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

    public long getElemId() {
        return this.elemId;
    }

    public int getElemType() {
        return this.elemType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public ArrayList<SearchGroupChatInfo> getGroupChatInfo() {
        return this.groupChatInfo;
    }

    public ArrayList<SearchHitInfo> getHits() {
        return this.hits;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public String getSenderCard() {
        return this.senderCard;
    }

    public String getSenderNick() {
        return this.senderNick;
    }

    public String getSenderRemark() {
        return this.senderRemark;
    }

    public String getSenderUid() {
        return this.senderUid;
    }

    public ArrayList<TempChatGameSession> getTmpChatInfo() {
        return this.tmpChatInfo;
    }

    public String toString() {
        return "SearchFileItem{chatType=" + this.chatType + ",buddyChatInfo=" + this.buddyChatInfo + ",discussChatInfo=" + this.discussChatInfo + ",groupChatInfo=" + this.groupChatInfo + ",dataLineChatInfo=" + this.dataLineChatInfo + ",tmpChatInfo=" + this.tmpChatInfo + ",msgId=" + this.msgId + ",msgSeq=" + this.msgSeq + ",msgTime=" + this.msgTime + ",senderUid=" + this.senderUid + ",senderNick=" + this.senderNick + ",senderRemark=" + this.senderRemark + ",senderCard=" + this.senderCard + ",elemId=" + this.elemId + ",elemType=" + this.elemType + ",fileSize=" + this.fileSize + ",filePath=" + this.filePath + ",fileName=" + this.fileName + ",hits=" + this.hits + ",}";
    }

    public SearchFileItem(int i2, ArrayList<SearchBuddyChatInfo> arrayList, ArrayList<SearchDiscussChatInfo> arrayList2, ArrayList<SearchGroupChatInfo> arrayList3, ArrayList<SearchDataLineChatInfo> arrayList4, ArrayList<TempChatGameSession> arrayList5, long j2, long j3, long j4, String str, String str2, String str3, String str4, long j5, int i3, long j6, String str5, String str6, ArrayList<SearchHitInfo> arrayList6) {
        this.buddyChatInfo = new ArrayList<>();
        this.discussChatInfo = new ArrayList<>();
        this.groupChatInfo = new ArrayList<>();
        this.dataLineChatInfo = new ArrayList<>();
        this.tmpChatInfo = new ArrayList<>();
        this.senderUid = "";
        this.senderNick = "";
        this.senderRemark = "";
        this.senderCard = "";
        this.filePath = "";
        this.fileName = "";
        this.hits = new ArrayList<>();
        this.chatType = i2;
        this.buddyChatInfo = arrayList;
        this.discussChatInfo = arrayList2;
        this.groupChatInfo = arrayList3;
        this.dataLineChatInfo = arrayList4;
        this.tmpChatInfo = arrayList5;
        this.msgId = j2;
        this.msgSeq = j3;
        this.msgTime = j4;
        this.senderUid = str;
        this.senderNick = str2;
        this.senderRemark = str3;
        this.senderCard = str4;
        this.elemId = j5;
        this.elemType = i3;
        this.fileSize = j6;
        this.filePath = str5;
        this.fileName = str6;
        this.hits = arrayList6;
    }
}
