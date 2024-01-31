package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProAnchorRoomInfo {
    ArrayList<GProAnchorRoomNoticeItem> beginRoomNoticeTime;
    Integer continueLiveStatus;
    String coverUrl169;
    String coverUrl34;
    Integer giftFlag;
    Integer goodsNum;
    String goodsUrl;
    Integer id;
    String logo;
    String name;
    String programId;
    Integer roomGameType;
    String roomPrepareNotify;
    String systemNotice;
    GProLiveRoomRichTitle tags;
    Boolean todayHasRoomNotice;

    public GProAnchorRoomInfo() {
        this.beginRoomNoticeTime = new ArrayList<>();
    }

    public ArrayList<GProAnchorRoomNoticeItem> getBeginRoomNoticeTime() {
        return this.beginRoomNoticeTime;
    }

    public Integer getContinueLiveStatus() {
        return this.continueLiveStatus;
    }

    public String getCoverUrl169() {
        return this.coverUrl169;
    }

    public String getCoverUrl34() {
        return this.coverUrl34;
    }

    public Integer getGiftFlag() {
        return this.giftFlag;
    }

    public Integer getGoodsNum() {
        return this.goodsNum;
    }

    public String getGoodsUrl() {
        return this.goodsUrl;
    }

    public Integer getId() {
        return this.id;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getName() {
        return this.name;
    }

    public String getProgramId() {
        return this.programId;
    }

    public Integer getRoomGameType() {
        return this.roomGameType;
    }

    public String getRoomPrepareNotify() {
        return this.roomPrepareNotify;
    }

    public String getSystemNotice() {
        return this.systemNotice;
    }

    public GProLiveRoomRichTitle getTags() {
        return this.tags;
    }

    public Boolean getTodayHasRoomNotice() {
        return this.todayHasRoomNotice;
    }

    public String toString() {
        return "GProAnchorRoomInfo{id=" + this.id + ",name=" + this.name + ",logo=" + this.logo + ",programId=" + this.programId + ",giftFlag=" + this.giftFlag + ",goodsUrl=" + this.goodsUrl + ",goodsNum=" + this.goodsNum + ",tags=" + this.tags + ",coverUrl169=" + this.coverUrl169 + ",coverUrl34=" + this.coverUrl34 + ",roomPrepareNotify=" + this.roomPrepareNotify + ",roomGameType=" + this.roomGameType + ",systemNotice=" + this.systemNotice + ",continueLiveStatus=" + this.continueLiveStatus + ",beginRoomNoticeTime=" + this.beginRoomNoticeTime + ",todayHasRoomNotice=" + this.todayHasRoomNotice + ",}";
    }

    public GProAnchorRoomInfo(Integer num, String str, String str2, String str3, Integer num2, String str4, Integer num3, GProLiveRoomRichTitle gProLiveRoomRichTitle, String str5, String str6, String str7, Integer num4, String str8, Integer num5, ArrayList<GProAnchorRoomNoticeItem> arrayList, Boolean bool) {
        this.beginRoomNoticeTime = new ArrayList<>();
        this.id = num;
        this.name = str;
        this.logo = str2;
        this.programId = str3;
        this.giftFlag = num2;
        this.goodsUrl = str4;
        this.goodsNum = num3;
        this.tags = gProLiveRoomRichTitle;
        this.coverUrl169 = str5;
        this.coverUrl34 = str6;
        this.roomPrepareNotify = str7;
        this.roomGameType = num4;
        this.systemNotice = str8;
        this.continueLiveStatus = num5;
        this.beginRoomNoticeTime = arrayList;
        this.todayHasRoomNotice = bool;
    }
}
