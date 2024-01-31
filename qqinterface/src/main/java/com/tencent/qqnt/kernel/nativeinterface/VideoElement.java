package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;



public final class VideoElement implements IKernelModel {
    int busiType;
    Integer fileBizId;
    int fileFormat;
    String fileName;
    String filePath;
    long fileSize;
    String fileSubId;
    int fileTime;
    String fileUuid;
    byte[] importRichMediaContext;
    Integer invalidState;
    String originVideoMd5;
    Integer progress;
    VideoCodecFormatType sourceVideoCodecFormat;
    int subBusiType;
    int thumbHeight;
    String thumbMd5;
    HashMap<Integer, String> thumbPath;
    int thumbSize;
    int thumbWidth;
    Integer transferStatus;
    String videoMd5;

    public VideoElement() {
        this.filePath = "";
        this.fileName = "";
        this.videoMd5 = "";
        this.thumbMd5 = "";
        this.fileUuid = "";
        this.fileSubId = "";
        this.originVideoMd5 = "";
        this.sourceVideoCodecFormat = VideoCodecFormatType.values()[0];
    }

    public int getBusiType() {
        return this.busiType;
    }

    public Integer getFileBizId() {
        return this.fileBizId;
    }

    public int getFileFormat() {
        return this.fileFormat;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFileSubId() {
        return this.fileSubId;
    }

    public int getFileTime() {
        return this.fileTime;
    }

    public String getFileUuid() {
        return this.fileUuid;
    }

    public byte[] getImportRichMediaContext() {
        return this.importRichMediaContext;
    }

    public Integer getInvalidState() {
        return this.invalidState;
    }

    public String getOriginVideoMd5() {
        return this.originVideoMd5;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public VideoCodecFormatType getSourceVideoCodecFormat() {
        return this.sourceVideoCodecFormat;
    }

    public int getSubBusiType() {
        return this.subBusiType;
    }

    public int getThumbHeight() {
        return this.thumbHeight;
    }

    public String getThumbMd5() {
        return this.thumbMd5;
    }

    public HashMap<Integer, String> getThumbPath() {
        return this.thumbPath;
    }

    public int getThumbSize() {
        return this.thumbSize;
    }

    public int getThumbWidth() {
        return this.thumbWidth;
    }

    public Integer getTransferStatus() {
        return this.transferStatus;
    }

    public String getVideoMd5() {
        return this.videoMd5;
    }

    public void setBusiType(int i2) {
        this.busiType = i2;
    }

    public void setFileBizId(Integer num) {
        this.fileBizId = num;
    }

    public void setFileFormat(int i2) {
        this.fileFormat = i2;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSize(long j2) {
        this.fileSize = j2;
    }

    public void setFileSubId(String str) {
        this.fileSubId = str;
    }

    public void setFileTime(int i2) {
        this.fileTime = i2;
    }

    public void setFileUuid(String str) {
        this.fileUuid = str;
    }

    public void setImportRichMediaContext(byte[] bArr) {
        this.importRichMediaContext = bArr;
    }

    public void setInvalidState(Integer num) {
        this.invalidState = num;
    }

    public void setOriginVideoMd5(String str) {
        this.originVideoMd5 = str;
    }

    public void setProgress(Integer num) {
        this.progress = num;
    }

    public void setSourceVideoCodecFormat(VideoCodecFormatType videoCodecFormatType) {
        this.sourceVideoCodecFormat = videoCodecFormatType;
    }

    public void setSubBusiType(int i2) {
        this.subBusiType = i2;
    }

    public void setThumbHeight(int i2) {
        this.thumbHeight = i2;
    }

    public void setThumbMd5(String str) {
        this.thumbMd5 = str;
    }

    public void setThumbPath(HashMap<Integer, String> hashMap) {
        this.thumbPath = hashMap;
    }

    public void setThumbSize(int i2) {
        this.thumbSize = i2;
    }

    public void setThumbWidth(int i2) {
        this.thumbWidth = i2;
    }

    public void setTransferStatus(Integer num) {
        this.transferStatus = num;
    }

    public void setVideoMd5(String str) {
        this.videoMd5 = str;
    }

    public String toString() {
        return "VideoElement{filePath=" + this.filePath + ",fileName=" + this.fileName + ",videoMd5=" + this.videoMd5 + ",thumbMd5=" + this.thumbMd5 + ",fileTime=" + this.fileTime + ",thumbSize=" + this.thumbSize + ",fileFormat=" + this.fileFormat + ",fileSize=" + this.fileSize + ",thumbWidth=" + this.thumbWidth + ",thumbHeight=" + this.thumbHeight + ",busiType=" + this.busiType + ",subBusiType=" + this.subBusiType + ",thumbPath=" + this.thumbPath + ",transferStatus=" + this.transferStatus + ",progress=" + this.progress + ",invalidState=" + this.invalidState + ",fileUuid=" + this.fileUuid + ",fileSubId=" + this.fileSubId + ",fileBizId=" + this.fileBizId + ",originVideoMd5=" + this.originVideoMd5 + ",importRichMediaContext=" + this.importRichMediaContext + ",sourceVideoCodecFormat=" + this.sourceVideoCodecFormat + ",}";
    }

    public VideoElement(String str, String str2, String str3, String str4, int i2, int i3, int i4, long j2, int i5, int i6, int i7, int i8, HashMap<Integer, String> hashMap, Integer num, Integer num2, Integer num3, String str5, String str6, Integer num4, String str7, byte[] bArr, VideoCodecFormatType videoCodecFormatType) {
        this.filePath = "";
        this.fileName = "";
        this.videoMd5 = "";
        this.thumbMd5 = "";
        this.fileUuid = "";
        this.fileSubId = "";
        this.originVideoMd5 = "";
        this.sourceVideoCodecFormat = VideoCodecFormatType.values()[0];
        this.filePath = str;
        this.fileName = str2;
        this.videoMd5 = str3;
        this.thumbMd5 = str4;
        this.fileTime = i2;
        this.thumbSize = i3;
        this.fileFormat = i4;
        this.fileSize = j2;
        this.thumbWidth = i5;
        this.thumbHeight = i6;
        this.busiType = i7;
        this.subBusiType = i8;
        this.thumbPath = hashMap;
        this.transferStatus = num;
        this.progress = num2;
        this.invalidState = num3;
        this.fileUuid = str5;
        this.fileSubId = str6;
        this.fileBizId = num4;
        this.originVideoMd5 = str7;
        this.importRichMediaContext = bArr;
        this.sourceVideoCodecFormat = videoCodecFormatType;
    }
}
