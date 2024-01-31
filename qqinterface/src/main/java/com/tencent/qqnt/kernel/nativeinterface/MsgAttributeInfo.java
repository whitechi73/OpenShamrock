package com.tencent.qqnt.kernel.nativeinterface;


public  final class MsgAttributeInfo {
    long attrId;
    int attrType;
    TempChatGameSession gameChatSession;
    GroupHonor groupHonor;
    KingHonor kingHonor;
    LongMsgAttr longMsgAttr;
    PublicAccountAttrs publicAccountAttrs;
    RobotMsgExt robotExt;
    SharedMsgInfo sharedMsgInfo;
    UinInfoAttr uinInfoAttr;
    VASMsgElement vasMsgInfo;
    VASAIOPersonalElement vasPersonalInfo;

    public MsgAttributeInfo() {
    }

    public long getAttrId() {
        return this.attrId;
    }

    public int getAttrType() {
        return this.attrType;
    }

    public TempChatGameSession getGameChatSession() {
        return this.gameChatSession;
    }

    public GroupHonor getGroupHonor() {
        return this.groupHonor;
    }

    public KingHonor getKingHonor() {
        return this.kingHonor;
    }

    public LongMsgAttr getLongMsgAttr() {
        return this.longMsgAttr;
    }

    public PublicAccountAttrs getPublicAccountAttrs() {
        return this.publicAccountAttrs;
    }

    public RobotMsgExt getRobotExt() {
        return this.robotExt;
    }

    public SharedMsgInfo getSharedMsgInfo() {
        return this.sharedMsgInfo;
    }

    public UinInfoAttr getUinInfoAttr() {
        return this.uinInfoAttr;
    }

    public VASMsgElement getVasMsgInfo() {
        return this.vasMsgInfo;
    }

    public VASAIOPersonalElement getVasPersonalInfo() {
        return this.vasPersonalInfo;
    }

    public String toString() {
        return "MsgAttributeInfo{attrType=" + this.attrType + ",attrId=" + this.attrId + ",vasMsgInfo=" + this.vasMsgInfo + ",vasPersonalInfo=" + this.vasPersonalInfo + ",groupHonor=" + this.groupHonor + ",kingHonor=" + this.kingHonor + ",publicAccountAttrs=" + this.publicAccountAttrs + ",sharedMsgInfo=" + this.sharedMsgInfo + ",gameChatSession=" + this.gameChatSession + ",uinInfoAttr=" + this.uinInfoAttr + ",longMsgAttr=" + this.longMsgAttr + ",robotExt=" + this.robotExt + ",}";
    }

    public MsgAttributeInfo(int i2, long j2, VASMsgElement vASMsgElement, VASAIOPersonalElement vASAIOPersonalElement, GroupHonor groupHonor, KingHonor kingHonor, PublicAccountAttrs publicAccountAttrs, SharedMsgInfo sharedMsgInfo, TempChatGameSession tempChatGameSession, UinInfoAttr uinInfoAttr, LongMsgAttr longMsgAttr, RobotMsgExt robotMsgExt) {
        this.attrType = i2;
        this.attrId = j2;
        this.vasMsgInfo = vASMsgElement;
        this.vasPersonalInfo = vASAIOPersonalElement;
        this.groupHonor = groupHonor;
        this.kingHonor = kingHonor;
        this.publicAccountAttrs = publicAccountAttrs;
        this.sharedMsgInfo = sharedMsgInfo;
        this.gameChatSession = tempChatGameSession;
        this.uinInfoAttr = uinInfoAttr;
        this.longMsgAttr = longMsgAttr;
        this.robotExt = robotMsgExt;
    }
}
