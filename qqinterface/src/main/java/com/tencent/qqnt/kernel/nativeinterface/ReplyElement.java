package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public final class ReplyElement implements IKernelModel, Serializable {
    String anonymousNickName;
    Integer originalMsgState;
    long replayMsgId;
    Long replayMsgRootCommentCnt;
    Long replayMsgRootMsgId;
    Long replayMsgRootSeq;
    Long replayMsgSeq;
    Long replyMsgClientSeq;
    int replyMsgRevokeType;
    Long replyMsgTime;
    Long senderUid;
    String senderUidStr;
    long serialVersionUID;
    boolean sourceMsgExpired;
    Long sourceMsgIdInRecords;
    boolean sourceMsgIsIncPic;
    String sourceMsgText;
    ArrayList<ReplyAbsElement> sourceMsgTextElems;

    public ReplyElement() {
        this.serialVersionUID = 1L;
        this.sourceMsgTextElems = new ArrayList<>();
    }

    public String getAnonymousNickName() {
        return this.anonymousNickName;
    }

    public Integer getOriginalMsgState() {
        return this.originalMsgState;
    }

    public long getReplayMsgId() {
        return this.replayMsgId;
    }

    public Long getReplayMsgRootCommentCnt() {
        return this.replayMsgRootCommentCnt;
    }

    public Long getReplayMsgRootMsgId() {
        return this.replayMsgRootMsgId;
    }

    public Long getReplayMsgRootSeq() {
        return this.replayMsgRootSeq;
    }

    public Long getReplayMsgSeq() {
        return this.replayMsgSeq;
    }

    public Long getReplyMsgClientSeq() {
        return this.replyMsgClientSeq;
    }

    public int getReplyMsgRevokeType() {
        return this.replyMsgRevokeType;
    }

    public Long getReplyMsgTime() {
        return this.replyMsgTime;
    }

    public Long getSenderUid() {
        return this.senderUid;
    }

    public String getSenderUidStr() {
        return this.senderUidStr;
    }

    public boolean getSourceMsgExpired() {
        return this.sourceMsgExpired;
    }

    public Long getSourceMsgIdInRecords() {
        return this.sourceMsgIdInRecords;
    }

    public boolean getSourceMsgIsIncPic() {
        return this.sourceMsgIsIncPic;
    }

    public String getSourceMsgText() {
        return this.sourceMsgText;
    }

    public ArrayList<ReplyAbsElement> getSourceMsgTextElems() {
        return this.sourceMsgTextElems;
    }

    public void setAnonymousNickName(String str) {
        this.anonymousNickName = str;
    }

    public void setOriginalMsgState(Integer num) {
        this.originalMsgState = num;
    }

    public void setReplayMsgId(long j2) {
        this.replayMsgId = j2;
    }

    public void setReplayMsgRootCommentCnt(Long l2) {
        this.replayMsgRootCommentCnt = l2;
    }

    public void setReplayMsgRootMsgId(Long l2) {
        this.replayMsgRootMsgId = l2;
    }

    public void setReplayMsgRootSeq(Long l2) {
        this.replayMsgRootSeq = l2;
    }

    public void setReplayMsgSeq(Long l2) {
        this.replayMsgSeq = l2;
    }

    public void setReplyMsgClientSeq(Long l2) {
        this.replyMsgClientSeq = l2;
    }

    public void setReplyMsgRevokeType(int i2) {
        this.replyMsgRevokeType = i2;
    }

    public void setReplyMsgTime(Long l2) {
        this.replyMsgTime = l2;
    }

    public void setSenderUid(Long l2) {
        this.senderUid = l2;
    }

    public void setSenderUidStr(String str) {
        this.senderUidStr = str;
    }

    public void setSourceMsgExpired(boolean z) {
        this.sourceMsgExpired = z;
    }

    public void setSourceMsgIdInRecords(Long l2) {
        this.sourceMsgIdInRecords = l2;
    }

    public void setSourceMsgIsIncPic(boolean z) {
        this.sourceMsgIsIncPic = z;
    }

    public void setSourceMsgText(String str) {
        this.sourceMsgText = str;
    }

    public void setSourceMsgTextElems(ArrayList<ReplyAbsElement> arrayList) {
        this.sourceMsgTextElems = arrayList;
    }

    public String toString() {
        return "ReplyElement{replayMsgId=" + this.replayMsgId + ",replayMsgSeq=" + this.replayMsgSeq + ",replayMsgRootSeq=" + this.replayMsgRootSeq + ",replayMsgRootMsgId=" + this.replayMsgRootMsgId + ",replayMsgRootCommentCnt=" + this.replayMsgRootCommentCnt + ",sourceMsgIdInRecords=" + this.sourceMsgIdInRecords + ",sourceMsgText=" + this.sourceMsgText + ",sourceMsgTextElems=" + this.sourceMsgTextElems + ",senderUid=" + this.senderUid + ",senderUidStr=" + this.senderUidStr + ",replyMsgClientSeq=" + this.replyMsgClientSeq + ",replyMsgTime=" + this.replyMsgTime + ",replyMsgRevokeType=" + this.replyMsgRevokeType + ",sourceMsgIsIncPic=" + this.sourceMsgIsIncPic + ",sourceMsgExpired=" + this.sourceMsgExpired + ",anonymousNickName=" + this.anonymousNickName + ",originalMsgState=" + this.originalMsgState + ",}";
    }

    public ReplyElement(long j2, Long l2, Long l3, Long l4, Long l5, Long l6, String str, ArrayList<ReplyAbsElement> arrayList, Long l7, String str2, Long l8, Long l9, int i2, boolean z, boolean z2, String str3, Integer num) {
        this.serialVersionUID = 1L;
        this.sourceMsgTextElems = new ArrayList<>();
        this.replayMsgId = j2;
        this.replayMsgSeq = l2;
        this.replayMsgRootSeq = l3;
        this.replayMsgRootMsgId = l4;
        this.replayMsgRootCommentCnt = l5;
        this.sourceMsgIdInRecords = l6;
        this.sourceMsgText = str;
        this.sourceMsgTextElems = arrayList;
        this.senderUid = l7;
        this.senderUidStr = str2;
        this.replyMsgClientSeq = l8;
        this.replyMsgTime = l9;
        this.replyMsgRevokeType = i2;
        this.sourceMsgIsIncPic = z;
        this.sourceMsgExpired = z2;
        this.anonymousNickName = str3;
        this.originalMsgState = num;
    }
}
