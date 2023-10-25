package com.tencent.qqnt.kernel.nativeinterface;

public final class MemberInfo implements IKernelModel {
    String avatarPath;
    String cardName;
    int cardType;
    boolean isDelete;
    boolean isSpecialConcerned;
    String nick;
    String qid;
    String remark;
    MemberRole role;
    long serialVersionUID;
    int shutUpTime;
    String uid;
    long uin;

    public MemberInfo() {
        this.serialVersionUID = 1L;
        this.uid = "";
        this.qid = "";
        this.nick = "";
        this.remark = "";
        this.cardName = "";
        this.role = MemberRole.values()[0];
        this.avatarPath = "";
    }

    public String getAvatarPath() {
        return this.avatarPath;
    }

    public String getCardName() {
        return this.cardName;
    }

    public int getCardType() {
        return this.cardType;
    }

    public boolean getIsDelete() {
        return this.isDelete;
    }

    public boolean getIsSpecialConcerned() {
        return this.isSpecialConcerned;
    }

    public String getNick() {
        return this.nick;
    }

    public String getQid() {
        return this.qid;
    }

    public String getRemark() {
        return this.remark;
    }

    public MemberRole getRole() {
        return this.role;
    }

    public int getShutUpTime() {
        return this.shutUpTime;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public void setAvatarPath(String str) {
        this.avatarPath = str;
    }

    public void setCardName(String str) {
        this.cardName = str;
    }

    public void setCardType(int i2) {
        this.cardType = i2;
    }

    public void setIsDelete(boolean z) {
        this.isDelete = z;
    }

    public void setIsSpecialConcerned(boolean z) {
        this.isSpecialConcerned = z;
    }

    public void setNick(String str) {
        this.nick = str;
    }

    public void setQid(String str) {
        this.qid = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setRole(MemberRole memberRole) {
        this.role = memberRole;
    }

    public void setShutUpTime(int i2) {
        this.shutUpTime = i2;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUin(long j2) {
        this.uin = j2;
    }

    public String toString() {
        return "MemberInfo{uid=" + this.uid + ",qid=" + this.qid + ",uin=" + this.uin + ",nick=" + this.nick + ",remark=" + this.remark + ",cardType=" + this.cardType + ",cardName=" + this.cardName + ",role=" + this.role + ",avatarPath=" + this.avatarPath + ",shutUpTime=" + this.shutUpTime + ",isDelete=" + this.isDelete + ",isSpecialConcerned=" + this.isSpecialConcerned + ",}";
    }

    public MemberInfo(String str, String str2, long j2, String str3, String str4, int i2, String str5, MemberRole memberRole, String str6, int i3, boolean z, boolean z2) {
        this.serialVersionUID = 1L;
        this.uid = "";
        this.qid = "";
        this.nick = "";
        this.remark = "";
        this.cardName = "";
        this.role = MemberRole.values()[0];
        this.avatarPath = "";
        this.uid = str;
        this.qid = str2;
        this.uin = j2;
        this.nick = str3;
        this.remark = str4;
        this.cardType = i2;
        this.cardName = str5;
        this.role = memberRole;
        this.avatarPath = str6;
        this.shutUpTime = i3;
        this.isDelete = z;
        this.isSpecialConcerned = z2;
    }
}