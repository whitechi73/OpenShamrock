package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProAnchorPrepareRsp {
    String defaultRoomName;
    GProAnchorRoomInfo info;
    Integer logoNum;
    Integer uploadCodecType;

    public GProAnchorPrepareRsp() {
    }

    public String getDefaultRoomName() {
        return this.defaultRoomName;
    }

    public GProAnchorRoomInfo getInfo() {
        return this.info;
    }

    public Integer getLogoNum() {
        return this.logoNum;
    }

    public Integer getUploadCodecType() {
        return this.uploadCodecType;
    }

    public String toString() {
        return "GProAnchorPrepareRsp{info=" + this.info + ",defaultRoomName=" + this.defaultRoomName + ",logoNum=" + this.logoNum + ",uploadCodecType=" + this.uploadCodecType + ",}";
    }

    public GProAnchorPrepareRsp(GProAnchorRoomInfo gProAnchorRoomInfo, String str, Integer num, Integer num2) {
        this.info = gProAnchorRoomInfo;
        this.defaultRoomName = str;
        this.logoNum = num;
        this.uploadCodecType = num2;
    }
}
