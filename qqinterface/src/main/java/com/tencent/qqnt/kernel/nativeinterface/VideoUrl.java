package com.tencent.qqnt.kernel.nativeinterface;



public final class VideoUrl {
    byte[] busiData;
    Boolean hasWatermark;
    int levelType;
    String playUrl;
    Integer transStatus;
    Integer videoPrior;
    Integer videoRate;

    public VideoUrl() {
        this.playUrl = "";
    }

    public byte[] getBusiData() {
        return this.busiData;
    }

    public Boolean getHasWatermark() {
        return this.hasWatermark;
    }

    public int getLevelType() {
        return this.levelType;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public Integer getTransStatus() {
        return this.transStatus;
    }

    public Integer getVideoPrior() {
        return this.videoPrior;
    }

    public Integer getVideoRate() {
        return this.videoRate;
    }

    public String toString() {
        return "VideoUrl{levelType=" + this.levelType + ",playUrl=" + this.playUrl + ",videoPrior=" + this.videoPrior + ",videoRate=" + this.videoRate + ",transStatus=" + this.transStatus + ",busiData=" + this.busiData + ",hasWatermark=" + this.hasWatermark + ",}";
    }

    public VideoUrl(int i2, String str, Integer num, Integer num2, Integer num3, byte[] bArr, Boolean bool) {
        this.playUrl = "";
        this.levelType = i2;
        this.playUrl = str;
        this.videoPrior = num;
        this.videoRate = num2;
        this.transStatus = num3;
        this.busiData = bArr;
        this.hasWatermark = bool;
    }
}
