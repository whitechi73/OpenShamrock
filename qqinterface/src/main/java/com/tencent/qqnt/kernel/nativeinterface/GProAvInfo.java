package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProAvInfo {
    Integer avType;
    Integer bitrate;
    String extInfo;
    GProOpenSdkUrl flv;
    GProOpenSdkUrl hls;
    Integer mode;
    Integer pixelsX;
    Integer pixelsY;
    GProOpenSdkUrl rtmp;
    String sig;
    GProStreamIDInfo streamIdInfo;
    GProDesignatedStreamInfo streamInfo;
    Integer time;
    GProTimeShiftInfo timeShiftInfo;
    GProTrtcInfo trtcInfo;
    Integer videoStatus;

    public GProAvInfo() {
    }

    public Integer getAvType() {
        return this.avType;
    }

    public Integer getBitrate() {
        return this.bitrate;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public GProOpenSdkUrl getFlv() {
        return this.flv;
    }

    public GProOpenSdkUrl getHls() {
        return this.hls;
    }

    public Integer getMode() {
        return this.mode;
    }

    public Integer getPixelsX() {
        return this.pixelsX;
    }

    public Integer getPixelsY() {
        return this.pixelsY;
    }

    public GProOpenSdkUrl getRtmp() {
        return this.rtmp;
    }

    public String getSig() {
        return this.sig;
    }

    public GProStreamIDInfo getStreamIdInfo() {
        return this.streamIdInfo;
    }

    public GProDesignatedStreamInfo getStreamInfo() {
        return this.streamInfo;
    }

    public Integer getTime() {
        return this.time;
    }

    public GProTimeShiftInfo getTimeShiftInfo() {
        return this.timeShiftInfo;
    }

    public GProTrtcInfo getTrtcInfo() {
        return this.trtcInfo;
    }

    public Integer getVideoStatus() {
        return this.videoStatus;
    }

    public String toString() {
        return "GProAvInfo{videoStatus=" + this.videoStatus + ",mode=" + this.mode + ",sig=" + this.sig + ",time=" + this.time + ",extInfo=" + this.extInfo + ",rtmp=" + this.rtmp + ",hls=" + this.hls + ",flv=" + this.flv + ",streamInfo=" + this.streamInfo + ",avType=" + this.avType + ",bitrate=" + this.bitrate + ",pixelsX=" + this.pixelsX + ",pixelsY=" + this.pixelsY + ",trtcInfo=" + this.trtcInfo + ",streamIdInfo=" + this.streamIdInfo + ",timeShiftInfo=" + this.timeShiftInfo + ",}";
    }

    public GProAvInfo(Integer num, Integer num2, String str, Integer num3, String str2, GProOpenSdkUrl gProOpenSdkUrl, GProOpenSdkUrl gProOpenSdkUrl2, GProOpenSdkUrl gProOpenSdkUrl3, GProDesignatedStreamInfo gProDesignatedStreamInfo, Integer num4, Integer num5, Integer num6, Integer num7, GProTrtcInfo gProTrtcInfo, GProStreamIDInfo gProStreamIDInfo, GProTimeShiftInfo gProTimeShiftInfo) {
        this.videoStatus = num;
        this.mode = num2;
        this.sig = str;
        this.time = num3;
        this.extInfo = str2;
        this.rtmp = gProOpenSdkUrl;
        this.hls = gProOpenSdkUrl2;
        this.flv = gProOpenSdkUrl3;
        this.streamInfo = gProDesignatedStreamInfo;
        this.avType = num4;
        this.bitrate = num5;
        this.pixelsX = num6;
        this.pixelsY = num7;
        this.trtcInfo = gProTrtcInfo;
        this.streamIdInfo = gProStreamIDInfo;
        this.timeShiftInfo = gProTimeShiftInfo;
    }
}
