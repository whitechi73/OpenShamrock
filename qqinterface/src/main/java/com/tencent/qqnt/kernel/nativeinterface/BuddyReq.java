package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class BuddyReq implements IKernelModel, Serializable {
    int commFriendNum;
    Integer curFriendMax;
    String extWords;
    int flag;
    String friendAvatarUrl;
    String friendNick;
    String friendUid;
    Long groupCode;
    boolean isAgreed;
    Boolean isBuddy;
    boolean isDecide;
    boolean isDoubt;
    boolean isInitiator;
    boolean isShowCard;
    boolean isUnread;
    String nameMore;
    int preGroupingId;
    int relation;
    Integer reqSubType;
    long reqTime;
    int reqType;
    long serialVersionUID;
    int sourceId;

    public BuddyReq() {
        this.serialVersionUID = 1L;
        this.friendUid = "";
        this.friendNick = "";
        this.friendAvatarUrl = "";
    }

    public int getCommFriendNum() {
        return this.commFriendNum;
    }

    public Integer getCurFriendMax() {
        return this.curFriendMax;
    }

    public String getExtWords() {
        return this.extWords;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getFriendAvatarUrl() {
        return this.friendAvatarUrl;
    }

    public String getFriendNick() {
        return this.friendNick;
    }

    public String getFriendUid() {
        return this.friendUid;
    }

    public Long getGroupCode() {
        return this.groupCode;
    }

    public boolean getIsAgreed() {
        return this.isAgreed;
    }

    public Boolean getIsBuddy() {
        return this.isBuddy;
    }

    public boolean getIsDecide() {
        return this.isDecide;
    }

    public boolean getIsDoubt() {
        return this.isDoubt;
    }

    public boolean getIsInitiator() {
        return this.isInitiator;
    }

    public boolean getIsShowCard() {
        return this.isShowCard;
    }

    public boolean getIsUnread() {
        return this.isUnread;
    }

    public String getNameMore() {
        return this.nameMore;
    }

    public int getPreGroupingId() {
        return this.preGroupingId;
    }

    public int getRelation() {
        return this.relation;
    }

    public Integer getReqSubType() {
        return this.reqSubType;
    }

    public long getReqTime() {
        return this.reqTime;
    }

    public int getReqType() {
        return this.reqType;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public void setCommFriendNum(int i2) {
        this.commFriendNum = i2;
    }

    public void setCurFriendMax(Integer num) {
        this.curFriendMax = num;
    }

    public void setExtWords(String str) {
        this.extWords = str;
    }

    public void setFlag(int i2) {
        this.flag = i2;
    }

    public void setFriendAvatarUrl(String str) {
        this.friendAvatarUrl = str;
    }

    public void setFriendNick(String str) {
        this.friendNick = str;
    }

    public void setFriendUid(String str) {
        this.friendUid = str;
    }

    public void setGroupCode(Long l2) {
        this.groupCode = l2;
    }

    public void setIsAgreed(boolean z) {
        this.isAgreed = z;
    }

    public void setIsBuddy(Boolean bool) {
        this.isBuddy = bool;
    }

    public void setIsDecide(boolean z) {
        this.isDecide = z;
    }

    public void setIsDoubt(boolean z) {
        this.isDoubt = z;
    }

    public void setIsInitiator(boolean z) {
        this.isInitiator = z;
    }

    public void setIsShowCard(boolean z) {
        this.isShowCard = z;
    }

    public void setIsUnread(boolean z) {
        this.isUnread = z;
    }

    public void setNameMore(String str) {
        this.nameMore = str;
    }

    public void setPreGroupingId(int i2) {
        this.preGroupingId = i2;
    }

    public void setRelation(int i2) {
        this.relation = i2;
    }

    public void setReqSubType(Integer num) {
        this.reqSubType = num;
    }

    public void setReqTime(long j2) {
        this.reqTime = j2;
    }

    public void setReqType(int i2) {
        this.reqType = i2;
    }

    public void setSourceId(int i2) {
        this.sourceId = i2;
    }

    public String toString() {
        return "BuddyReq{isDecide=" + this.isDecide + ",isInitiator=" + this.isInitiator + ",friendUid=" + this.friendUid + ",reqType=" + this.reqType + ",reqSubType=" + this.reqSubType + ",reqTime=" + this.reqTime + ",extWords=" + this.extWords + ",flag=" + this.flag + ",preGroupingId=" + this.preGroupingId + ",commFriendNum=" + this.commFriendNum + ",curFriendMax=" + this.curFriendMax + ",isShowCard=" + this.isShowCard + ",isUnread=" + this.isUnread + ",isDoubt=" + this.isDoubt + ",nameMore=" + this.nameMore + ",friendNick=" + this.friendNick + ",friendAvatarUrl=" + this.friendAvatarUrl + ",sourceId=" + this.sourceId + ",groupCode=" + this.groupCode + ",isBuddy=" + this.isBuddy + ",isAgreed=" + this.isAgreed + ",relation=" + this.relation + ",}";
    }

    public BuddyReq(boolean z, boolean z2, String str, int i2, Integer num, long j2, String str2, int i3, int i4, int i5, Integer num2, boolean z3, boolean z4, boolean z5, String str3, String str4, String str5, int i6, Long l2, Boolean bool, boolean z6, int i7) {
        this.serialVersionUID = 1L;
        this.friendUid = "";
        this.friendNick = "";
        this.friendAvatarUrl = "";
        this.isDecide = z;
        this.isInitiator = z2;
        this.friendUid = str;
        this.reqType = i2;
        this.reqSubType = num;
        this.reqTime = j2;
        this.extWords = str2;
        this.flag = i3;
        this.preGroupingId = i4;
        this.commFriendNum = i5;
        this.curFriendMax = num2;
        this.isShowCard = z3;
        this.isUnread = z4;
        this.isDoubt = z5;
        this.nameMore = str3;
        this.friendNick = str4;
        this.friendAvatarUrl = str5;
        this.sourceId = i6;
        this.groupCode = l2;
        this.isBuddy = bool;
        this.isAgreed = z6;
        this.relation = i7;
    }
}