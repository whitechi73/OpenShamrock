package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class FirstViewDirectMsgNotifyInfo {
    String CmtId;
    int DirectMsgSwitch;
    ArrayList<Integer> FeedAtTypes;
    int FeedCommentsSwitch;
    String FeedId;
    long FeedsChannelId;
    long FeedsEventIsValid;
    byte[] FeedsEventLastId;
    long FeedsEventLastTime;
    byte[] FeedsEventMsgSummary;
    long FeedsEventNnreadNum;
    long FeedsGuildId;
    boolean FeedsNeedNofity;
    String ReplyId;

    public FirstViewDirectMsgNotifyInfo() {
        this.FeedsEventMsgSummary = new byte[0];
        this.FeedsEventLastId = new byte[0];
        this.FeedAtTypes = new ArrayList<>();
        this.FeedId = "";
        this.CmtId = "";
        this.ReplyId = "";
    }

    public String getCmtId() {
        return this.CmtId;
    }

    public int getDirectMsgSwitch() {
        return this.DirectMsgSwitch;
    }

    public ArrayList<Integer> getFeedAtTypes() {
        return this.FeedAtTypes;
    }

    public int getFeedCommentsSwitch() {
        return this.FeedCommentsSwitch;
    }

    public String getFeedId() {
        return this.FeedId;
    }

    public long getFeedsChannelId() {
        return this.FeedsChannelId;
    }

    public long getFeedsEventIsValid() {
        return this.FeedsEventIsValid;
    }

    public byte[] getFeedsEventLastId() {
        return this.FeedsEventLastId;
    }

    public long getFeedsEventLastTime() {
        return this.FeedsEventLastTime;
    }

    public byte[] getFeedsEventMsgSummary() {
        return this.FeedsEventMsgSummary;
    }

    public long getFeedsEventNnreadNum() {
        return this.FeedsEventNnreadNum;
    }

    public long getFeedsGuildId() {
        return this.FeedsGuildId;
    }

    public boolean getFeedsNeedNofity() {
        return this.FeedsNeedNofity;
    }

    public String getReplyId() {
        return this.ReplyId;
    }

    public String toString() {
        return "FirstViewDirectMsgNotifyInfo{DirectMsgSwitch=" + this.DirectMsgSwitch + ",FeedsEventIsValid=" + this.FeedsEventIsValid + ",FeedsEventNnreadNum=" + this.FeedsEventNnreadNum + ",FeedsEventMsgSummary=" + this.FeedsEventMsgSummary + ",FeedsEventLastTime=" + this.FeedsEventLastTime + ",FeedsEventLastId=" + this.FeedsEventLastId + ",FeedsNeedNofity=" + this.FeedsNeedNofity + ",FeedsGuildId=" + this.FeedsGuildId + ",FeedsChannelId=" + this.FeedsChannelId + ",FeedCommentsSwitch=" + this.FeedCommentsSwitch + ",FeedAtTypes=" + this.FeedAtTypes + ",FeedId=" + this.FeedId + ",CmtId=" + this.CmtId + ",ReplyId=" + this.ReplyId + ",}";
    }

    public FirstViewDirectMsgNotifyInfo(int i2, long j2, long j3, byte[] bArr, long j4, byte[] bArr2, boolean z, long j5, long j6, int i3, ArrayList<Integer> arrayList, String str, String str2, String str3) {
        this.FeedsEventMsgSummary = new byte[0];
        this.FeedsEventLastId = new byte[0];
        this.FeedAtTypes = new ArrayList<>();
        this.FeedId = "";
        this.CmtId = "";
        this.ReplyId = "";
        this.DirectMsgSwitch = i2;
        this.FeedsEventIsValid = j2;
        this.FeedsEventNnreadNum = j3;
        this.FeedsEventMsgSummary = bArr;
        this.FeedsEventLastTime = j4;
        this.FeedsEventLastId = bArr2;
        this.FeedsNeedNofity = z;
        this.FeedsGuildId = j5;
        this.FeedsChannelId = j6;
        this.FeedCommentsSwitch = i3;
        this.FeedAtTypes = arrayList;
        this.FeedId = str;
        this.CmtId = str2;
        this.ReplyId = str3;
    }
}
