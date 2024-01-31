package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class Video implements IKernelModel {
    Integer approvalStatus;
    byte[] busiData;
    Image cover;
    int displayIndex;
    Integer duration;
    String fileId;
    Integer fileSize;
    int height;
    Boolean isQuic;
    Integer mediaQualityRank;
    Float mediaQualityScore;
    Integer orientation;
    String patternId;
    String playUrl;
    Integer transStatus;
    ArrayList<VideoUrl> vecVideoUrl;
    String videoMD5;
    Integer videoPrior;
    Integer videoRate;
    Integer videoSource;
    int width;

    public Video() {
        this.fileId = "";
        this.playUrl = "";
        this.patternId = "";
    }

    public Integer getApprovalStatus() {
        return this.approvalStatus;
    }

    public byte[] getBusiData() {
        return this.busiData;
    }

    public Image getCover() {
        return this.cover;
    }

    public int getDisplayIndex() {
        return this.displayIndex;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public String getFileId() {
        return this.fileId;
    }

    public Integer getFileSize() {
        return this.fileSize;
    }

    public int getHeight() {
        return this.height;
    }

    public Boolean getIsQuic() {
        return this.isQuic;
    }

    public Integer getMediaQualityRank() {
        return this.mediaQualityRank;
    }

    public Float getMediaQualityScore() {
        return this.mediaQualityScore;
    }

    public Integer getOrientation() {
        return this.orientation;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public Integer getTransStatus() {
        return this.transStatus;
    }

    public ArrayList<VideoUrl> getVecVideoUrl() {
        return this.vecVideoUrl;
    }

    public String getVideoMD5() {
        return this.videoMD5;
    }

    public Integer getVideoPrior() {
        return this.videoPrior;
    }

    public Integer getVideoRate() {
        return this.videoRate;
    }

    public Integer getVideoSource() {
        return this.videoSource;
    }

    public int getWidth() {
        return this.width;
    }

    public void setApprovalStatus(Integer num) {
        this.approvalStatus = num;
    }

    public void setBusiData(byte[] bArr) {
        this.busiData = bArr;
    }

    public void setCover(Image image) {
        this.cover = image;
    }

    public void setDisplayIndex(int i2) {
        this.displayIndex = i2;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setFileSize(Integer num) {
        this.fileSize = num;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setIsQuic(Boolean bool) {
        this.isQuic = bool;
    }

    public void setMediaQualityRank(Integer num) {
        this.mediaQualityRank = num;
    }

    public void setMediaQualityScore(Float f2) {
        this.mediaQualityScore = f2;
    }

    public void setOrientation(Integer num) {
        this.orientation = num;
    }

    public void setPatternId(String str) {
        this.patternId = str;
    }

    public void setPlayUrl(String str) {
        this.playUrl = str;
    }

    public void setTransStatus(Integer num) {
        this.transStatus = num;
    }

    public void setVecVideoUrl(ArrayList<VideoUrl> arrayList) {
        this.vecVideoUrl = arrayList;
    }

    public void setVideoMD5(String str) {
        this.videoMD5 = str;
    }

    public void setVideoPrior(Integer num) {
        this.videoPrior = num;
    }

    public void setVideoRate(Integer num) {
        this.videoRate = num;
    }

    public void setVideoSource(Integer num) {
        this.videoSource = num;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    public String toString() {
        return "Video{fileId=" + this.fileId + ",fileSize=" + this.fileSize + ",duration=" + this.duration + ",width=" + this.width + ",height=" + this.height + ",playUrl=" + this.playUrl + ",transStatus=" + this.transStatus + ",videoPrior=" + this.videoPrior + ",videoRate=" + this.videoRate + ",vecVideoUrl=" + this.vecVideoUrl + ",busiData=" + this.busiData + ",approvalStatus=" + this.approvalStatus + ",videoSource=" + this.videoSource + ",mediaQualityRank=" + this.mediaQualityRank + ",mediaQualityScore=" + this.mediaQualityScore + ",videoMD5=" + this.videoMD5 + ",isQuic=" + this.isQuic + ",orientation=" + this.orientation + ",cover=" + this.cover + ",patternId=" + this.patternId + ",displayIndex=" + this.displayIndex + ",}";
    }

    public Video(String str, Integer num, Integer num2, int i2, int i3, String str2, Integer num3, Integer num4, Integer num5, ArrayList<VideoUrl> arrayList, byte[] bArr, Integer num6, Integer num7, Integer num8, Float f2, String str3, Boolean bool, Integer num9, Image image, String str4, int i4) {
        this.fileId = "";
        this.playUrl = "";
        this.patternId = "";
        this.fileId = str;
        this.fileSize = num;
        this.duration = num2;
        this.width = i2;
        this.height = i3;
        this.playUrl = str2;
        this.transStatus = num3;
        this.videoPrior = num4;
        this.videoRate = num5;
        this.vecVideoUrl = arrayList;
        this.busiData = bArr;
        this.approvalStatus = num6;
        this.videoSource = num7;
        this.mediaQualityRank = num8;
        this.mediaQualityScore = f2;
        this.videoMD5 = str3;
        this.isQuic = bool;
        this.orientation = num9;
        this.cover = image;
        this.patternId = str4;
        this.displayIndex = i4;
    }
}
