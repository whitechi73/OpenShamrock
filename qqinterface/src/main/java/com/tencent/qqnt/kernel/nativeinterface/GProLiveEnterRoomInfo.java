package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProLiveEnterRoomInfo {
    String businessPid;
    Integer gameType;
    Integer giftFlag;
    Integer goodsFlag;
    String logo;
    String name;
    Long ownerUid;
    Integer payFlag;
    String programId;
    Long roomId;
    GProLiveRoomRichTitle roomLabels;
    String sid;
    String systemNotice;

    public GProLiveEnterRoomInfo() {
    }

    public String getBusinessPid() {
        return this.businessPid;
    }

    public Integer getGameType() {
        return this.gameType;
    }

    public Integer getGiftFlag() {
        return this.giftFlag;
    }

    public Integer getGoodsFlag() {
        return this.goodsFlag;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getName() {
        return this.name;
    }

    public Long getOwnerUid() {
        return this.ownerUid;
    }

    public Integer getPayFlag() {
        return this.payFlag;
    }

    public String getProgramId() {
        return this.programId;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public GProLiveRoomRichTitle getRoomLabels() {
        return this.roomLabels;
    }

    public String getSid() {
        return this.sid;
    }

    public String getSystemNotice() {
        return this.systemNotice;
    }

    public String toString() {
        return "GProLiveEnterRoomInfo{roomId=" + this.roomId + ",ownerUid=" + this.ownerUid + ",logo=" + this.logo + ",name=" + this.name + ",gameType=" + this.gameType + ",roomLabels=" + this.roomLabels + ",giftFlag=" + this.giftFlag + ",goodsFlag=" + this.goodsFlag + ",programId=" + this.programId + ",systemNotice=" + this.systemNotice + ",sid=" + this.sid + ",payFlag=" + this.payFlag + ",businessPid=" + this.businessPid + ",}";
    }

    public GProLiveEnterRoomInfo(Long l2, Long l3, String str, String str2, Integer num, GProLiveRoomRichTitle gProLiveRoomRichTitle, Integer num2, Integer num3, String str3, String str4, String str5, Integer num4, String str6) {
        this.roomId = l2;
        this.ownerUid = l3;
        this.logo = str;
        this.name = str2;
        this.gameType = num;
        this.roomLabels = gProLiveRoomRichTitle;
        this.giftFlag = num2;
        this.goodsFlag = num3;
        this.programId = str3;
        this.systemNotice = str4;
        this.sid = str5;
        this.payFlag = num4;
        this.businessPid = str6;
    }
}
