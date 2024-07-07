package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;

public final class MemberInfo implements IKernelModel {
    public int bigClubFlag;
    public int bigClubLevel;
    public int cardNameId;
    public int cardType;
    public int creditLevel;
    public int globalGroupLevel;
    public int globalGroupPoint;
    public boolean isDelete;
    public boolean isRobot;
    public boolean isSpecialConcerned;
    public boolean isSpecialShielded;
    public int joinTime;
    public int lastSpeakTime;
    public int memberFlag;
    public int memberFlagExt;
    public int memberFlagExt2;
    public int memberLevel;
    public int memberMobileFlag;
    public int memberTitleId;
    public int mssVipType;
    public int richFlag;
    public int shutUpTime;
    public long specialTitleExpireTime;
    public long uin;
    public int userShowFlag;
    public int userShowFlagNew;
    long serialVersionUID = 1;
    public String uid = "";
    public String qid = "";
    public String nick = "";
    public String remark = "";
    public String cardName = "";
    public MemberRole role = MemberRole.values()[0];
    public String avatarPath = "";
    public byte[] groupHonor = new byte[0];
    public String memberSpecialTitle = "";
    public String autoRemark = "";

    public String getAutoRemark() {
        return this.autoRemark;
    }

    public String getAvatarPath() {
        return this.avatarPath;
    }

    public int getBigClubFlag() {
        return this.bigClubFlag;
    }

    public int getBigClubLevel() {
        return this.bigClubLevel;
    }

    public String getCardName() {
        return this.cardName;
    }

    public int getCardNameId() {
        return this.cardNameId;
    }

    public int getCardType() {
        return this.cardType;
    }

    public int getCreditLevel() {
        return this.creditLevel;
    }

    public int getGlobalGroupLevel() {
        return this.globalGroupLevel;
    }

    public int getGlobalGroupPoint() {
        return this.globalGroupPoint;
    }

    public byte[] getGroupHonor() {
        return this.groupHonor;
    }

    public boolean getIsDelete() {
        return this.isDelete;
    }

    public boolean getIsRobot() {
        return this.isRobot;
    }

    public boolean getIsSpecialConcerned() {
        return this.isSpecialConcerned;
    }

    public boolean getIsSpecialShielded() {
        return this.isSpecialShielded;
    }

    public int getJoinTime() {
        return this.joinTime;
    }

    public int getLastSpeakTime() {
        return this.lastSpeakTime;
    }

    public int getMemberFlag() {
        return this.memberFlag;
    }

    public int getMemberFlagExt() {
        return this.memberFlagExt;
    }

    public int getMemberFlagExt2() {
        return this.memberFlagExt2;
    }

    public int getMemberLevel() {
        return this.memberLevel;
    }

    public int getMemberMobileFlag() {
        return this.memberMobileFlag;
    }

    public String getMemberSpecialTitle() {
        return this.memberSpecialTitle;
    }

    public int getMemberTitleId() {
        return this.memberTitleId;
    }

    public int getMssVipType() {
        return this.mssVipType;
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

    public int getRichFlag() {
        return this.richFlag;
    }

    public MemberRole getRole() {
        return this.role;
    }

    public int getShutUpTime() {
        return this.shutUpTime;
    }

    public long getSpecialTitleExpireTime() {
        return this.specialTitleExpireTime;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public int getUserShowFlag() {
        return this.userShowFlag;
    }

    public int getUserShowFlagNew() {
        return this.userShowFlagNew;
    }

    public void setAutoRemark(String str) {
        this.autoRemark = str;
    }

    public void setAvatarPath(String str) {
        this.avatarPath = str;
    }

    public void setBigClubFlag(int i2) {
        this.bigClubFlag = i2;
    }

    public void setBigClubLevel(int i2) {
        this.bigClubLevel = i2;
    }

    public void setCardName(String str) {
        this.cardName = str;
    }

    public void setCardNameId(int i2) {
        this.cardNameId = i2;
    }

    public void setCardType(int i2) {
        this.cardType = i2;
    }

    public void setCreditLevel(int i2) {
        this.creditLevel = i2;
    }

    public void setGlobalGroupLevel(int i2) {
        this.globalGroupLevel = i2;
    }

    public void setGlobalGroupPoint(int i2) {
        this.globalGroupPoint = i2;
    }

    public void setGroupHonor(byte[] bArr) {
        this.groupHonor = bArr;
    }

    public void setIsDelete(boolean z) {
        this.isDelete = z;
    }

    public void setIsRobot(boolean z) {
        this.isRobot = z;
    }

    public void setIsSpecialConcerned(boolean z) {
        this.isSpecialConcerned = z;
    }

    public void setIsSpecialShielded(boolean z) {
        this.isSpecialShielded = z;
    }

    public void setJoinTime(int i2) {
        this.joinTime = i2;
    }

    public void setLastSpeakTime(int i2) {
        this.lastSpeakTime = i2;
    }

    public void setMemberFlag(int i2) {
        this.memberFlag = i2;
    }

    public void setMemberFlagExt(int i2) {
        this.memberFlagExt = i2;
    }

    public void setMemberFlagExt2(int i2) {
        this.memberFlagExt2 = i2;
    }

    public void setMemberLevel(int i2) {
        this.memberLevel = i2;
    }

    public void setMemberMobileFlag(int i2) {
        this.memberMobileFlag = i2;
    }

    public void setMemberSpecialTitle(String str) {
        this.memberSpecialTitle = str;
    }

    public void setMemberTitleId(int i2) {
        this.memberTitleId = i2;
    }

    public void setMssVipType(int i2) {
        this.mssVipType = i2;
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

    public void setRichFlag(int i2) {
        this.richFlag = i2;
    }

    public void setRole(MemberRole memberRole) {
        this.role = memberRole;
    }

    public void setShutUpTime(int i2) {
        this.shutUpTime = i2;
    }

    public void setSpecialTitleExpireTime(long j2) {
        this.specialTitleExpireTime = j2;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUin(long j2) {
        this.uin = j2;
    }

    public void setUserShowFlag(int i2) {
        this.userShowFlag = i2;
    }

    public void setUserShowFlagNew(int i2) {
        this.userShowFlagNew = i2;
    }

    public String toString() {
        return "MemberInfo{uid=" + this.uid + ",qid=" + this.qid + ",uin=" + this.uin + ",nick=" + this.nick + ",remark=" + this.remark + ",cardType=" + this.cardType + ",cardName=" + this.cardName + ",role=" + this.role + ",avatarPath=" + this.avatarPath + ",shutUpTime=" + this.shutUpTime + ",isDelete=" + this.isDelete + ",isSpecialConcerned=" + this.isSpecialConcerned + ",isRobot=" + this.isRobot + ",groupHonor=" + this.groupHonor + ",memberLevel=" + this.memberLevel + ",globalGroupLevel=" + this.globalGroupLevel + ",globalGroupPoint=" + this.globalGroupPoint + ",memberTitleId=" + this.memberTitleId + ",memberSpecialTitle=" + this.memberSpecialTitle + ",specialTitleExpireTime=" + this.specialTitleExpireTime + ",userShowFlag=" + this.userShowFlag + ",userShowFlagNew=" + this.userShowFlagNew + ",richFlag=" + this.richFlag + ",mssVipType=" + this.mssVipType + ",bigClubLevel=" + this.bigClubLevel + ",bigClubFlag=" + this.bigClubFlag + ",autoRemark=" + this.autoRemark + ",creditLevel=" + this.creditLevel + ",joinTime=" + this.joinTime + ",lastSpeakTime=" + this.lastSpeakTime + ",memberFlag=" + this.memberFlag + ",memberFlagExt=" + this.memberFlagExt + ",memberMobileFlag=" + this.memberMobileFlag + ",memberFlagExt2=" + this.memberFlagExt2 + ",isSpecialShielded=" + this.isSpecialShielded + ",cardNameId=" + this.cardNameId + ",}";
    }

}