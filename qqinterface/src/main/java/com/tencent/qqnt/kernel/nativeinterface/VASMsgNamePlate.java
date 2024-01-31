package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public final class VASMsgNamePlate {
    ArrayList<Integer> carouselNamePlateIds;
    Integer extendNamePlateId;
    Integer gameNamePlateId;
    Integer grayNamePlate;
    Integer msgBigClubFlag;
    Integer msgBigClubLevel;
    Integer msgVipLevel;
    Integer msgVipType;
    Integer namePlateId;
    Integer namePlateType;
    Integer vipStarFlag;

    public VASMsgNamePlate() {
        this.carouselNamePlateIds = new ArrayList<>();
    }

    public ArrayList<Integer> getCarouselNamePlateIds() {
        return this.carouselNamePlateIds;
    }

    public Integer getExtendNamePlateId() {
        return this.extendNamePlateId;
    }

    public Integer getGameNamePlateId() {
        return this.gameNamePlateId;
    }

    public Integer getGrayNamePlate() {
        return this.grayNamePlate;
    }

    public Integer getMsgBigClubFlag() {
        return this.msgBigClubFlag;
    }

    public Integer getMsgBigClubLevel() {
        return this.msgBigClubLevel;
    }

    public Integer getMsgVipLevel() {
        return this.msgVipLevel;
    }

    public Integer getMsgVipType() {
        return this.msgVipType;
    }

    public Integer getNamePlateId() {
        return this.namePlateId;
    }

    public Integer getNamePlateType() {
        return this.namePlateType;
    }

    public Integer getVipStarFlag() {
        return this.vipStarFlag;
    }

    public String toString() {
        return "VASMsgNamePlate{msgVipType=" + this.msgVipType + ",msgVipLevel=" + this.msgVipLevel + ",msgBigClubFlag=" + this.msgBigClubFlag + ",msgBigClubLevel=" + this.msgBigClubLevel + ",grayNamePlate=" + this.grayNamePlate + ",namePlateType=" + this.namePlateType + ",vipStarFlag=" + this.vipStarFlag + ",namePlateId=" + this.namePlateId + ",carouselNamePlateIds=" + this.carouselNamePlateIds + ",extendNamePlateId=" + this.extendNamePlateId + ",gameNamePlateId=" + this.gameNamePlateId + ",}";
    }

    public VASMsgNamePlate(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, ArrayList<Integer> arrayList, Integer num9, Integer num10) {
        this.carouselNamePlateIds = new ArrayList<>();
        this.msgVipType = num;
        this.msgVipLevel = num2;
        this.msgBigClubFlag = num3;
        this.msgBigClubLevel = num4;
        this.grayNamePlate = num5;
        this.namePlateType = num6;
        this.vipStarFlag = num7;
        this.namePlateId = num8;
        this.carouselNamePlateIds = arrayList;
        this.extendNamePlateId = num9;
        this.gameNamePlateId = num10;
    }
}
