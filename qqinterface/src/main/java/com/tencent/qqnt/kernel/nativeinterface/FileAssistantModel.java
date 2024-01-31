package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class FileAssistantModel {
    int chatType;
    long expTime;
    String fileName;
    ArrayList<SearchHitInfo> fileNameHits;
    String filePath;
    long fileSize;
    FileAssistantStatus fileStatus;
    long fileTime;
    String id;
    boolean isSend;
    long msgId;
    String peerUid;
    FileAssistantSession session;
    FileAssistantSource source;
    String thumbPath;

    public FileAssistantModel() {
        this.id = "";
        this.fileName = "";
        this.fileNameHits = new ArrayList<>();
        this.fileStatus = FileAssistantStatus.values()[0];
        this.source = FileAssistantSource.values()[0];
        this.session = new FileAssistantSession();
        this.thumbPath = "";
        this.filePath = "";
        this.peerUid = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public long getExpTime() {
        return this.expTime;
    }

    public String getFileName() {
        return this.fileName;
    }

    public ArrayList<SearchHitInfo> getFileNameHits() {
        return this.fileNameHits;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public FileAssistantStatus getFileStatus() {
        return this.fileStatus;
    }

    public long getFileTime() {
        return this.fileTime;
    }

    public String getId() {
        return this.id;
    }

    public boolean getIsSend() {
        return this.isSend;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public FileAssistantSession getSession() {
        return this.session;
    }

    public FileAssistantSource getSource() {
        return this.source;
    }

    public String getThumbPath() {
        return this.thumbPath;
    }

    public String toString() {
        return "FileAssistantModel{id=" + this.id + ",fileName=" + this.fileName + ",fileNameHits=" + this.fileNameHits + ",fileStatus=" + this.fileStatus + ",fileSize=" + this.fileSize + ",isSend=" + this.isSend + ",source=" + this.source + ",fileTime=" + this.fileTime + ",expTime=" + this.expTime + ",session=" + this.session + ",thumbPath=" + this.thumbPath + ",filePath=" + this.filePath + ",msgId=" + this.msgId + ",chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",}";
    }

    public FileAssistantModel(String str, String str2, ArrayList<SearchHitInfo> arrayList, FileAssistantStatus fileAssistantStatus, long j2, boolean z, FileAssistantSource fileAssistantSource, long j3, long j4, FileAssistantSession fileAssistantSession, String str3, String str4, long j5, int i2, String str5) {
        this.id = "";
        this.fileName = "";
        this.fileNameHits = new ArrayList<>();
        this.fileStatus = FileAssistantStatus.values()[0];
        this.source = FileAssistantSource.values()[0];
        this.session = new FileAssistantSession();
        this.thumbPath = "";
        this.filePath = "";
        this.peerUid = "";
        this.id = str;
        this.fileName = str2;
        this.fileNameHits = arrayList;
        this.fileStatus = fileAssistantStatus;
        this.fileSize = j2;
        this.isSend = z;
        this.source = fileAssistantSource;
        this.fileTime = j3;
        this.expTime = j4;
        this.session = fileAssistantSession;
        this.thumbPath = str3;
        this.filePath = str4;
        this.msgId = j5;
        this.chatType = i2;
        this.peerUid = str5;
    }
}
