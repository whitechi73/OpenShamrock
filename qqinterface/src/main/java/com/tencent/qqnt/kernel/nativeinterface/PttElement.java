package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class PttElement implements IKernelModel {
    int autoConvertText;
    boolean canConvert2Text;
    int duration;
    Integer fileBizId;
    Integer fileId;
    String fileName;
    String filePath;
    long fileSize;
    String fileSubId;
    String fileUuid;
    int formatType;
    byte[] importRichMediaContext;
    Integer invalidState;
    String md5HexStr;
    Integer playState;
    Integer progress;
    String text;
    Integer transferStatus;
    Integer translateStatus;
    int voiceChangeType;
    int voiceType;
    ArrayList<Byte> waveAmplitudes;

    public PttElement() {
        this.fileName = "";
        this.filePath = "";
        this.md5HexStr = "";
        this.waveAmplitudes = new ArrayList<>();
        this.fileSubId = "";
    }

    public int getAutoConvertText() {
        return this.autoConvertText;
    }

    public boolean getCanConvert2Text() {
        return this.canConvert2Text;
    }

    public int getDuration() {
        return this.duration;
    }

    public Integer getFileBizId() {
        return this.fileBizId;
    }

    public Integer getFileId() {
        return this.fileId;
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

    public String getFileUuid() {
        return this.fileUuid;
    }

    public int getFormatType() {
        return this.formatType;
    }

    public byte[] getImportRichMediaContext() {
        return this.importRichMediaContext;
    }

    public Integer getInvalidState() {
        return this.invalidState;
    }

    public String getMd5HexStr() {
        return this.md5HexStr;
    }

    public Integer getPlayState() {
        return this.playState;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public String getText() {
        return this.text;
    }

    public Integer getTransferStatus() {
        return this.transferStatus;
    }

    public Integer getTranslateStatus() {
        return this.translateStatus;
    }

    public int getVoiceChangeType() {
        return this.voiceChangeType;
    }

    public int getVoiceType() {
        return this.voiceType;
    }

    public ArrayList<Byte> getWaveAmplitudes() {
        return this.waveAmplitudes;
    }

    public void setAutoConvertText(int i2) {
        this.autoConvertText = i2;
    }

    public void setCanConvert2Text(boolean z) {
        this.canConvert2Text = z;
    }

    public void setDuration(int i2) {
        this.duration = i2;
    }

    public void setFileBizId(Integer num) {
        this.fileBizId = num;
    }

    public void setFileId(Integer num) {
        this.fileId = num;
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

    public void setFileUuid(String str) {
        this.fileUuid = str;
    }

    public void setFormatType(int i2) {
        this.formatType = i2;
    }

    public void setImportRichMediaContext(byte[] bArr) {
        this.importRichMediaContext = bArr;
    }

    public void setInvalidState(Integer num) {
        this.invalidState = num;
    }

    public void setMd5HexStr(String str) {
        this.md5HexStr = str;
    }

    public void setPlayState(Integer num) {
        this.playState = num;
    }

    public void setProgress(Integer num) {
        this.progress = num;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTransferStatus(Integer num) {
        this.transferStatus = num;
    }

    public void setTranslateStatus(Integer num) {
        this.translateStatus = num;
    }

    public void setVoiceChangeType(int i2) {
        this.voiceChangeType = i2;
    }

    public void setVoiceType(int i2) {
        this.voiceType = i2;
    }

    public void setWaveAmplitudes(ArrayList<Byte> arrayList) {
        this.waveAmplitudes = arrayList;
    }

    public String toString() {
        return "PttElement{fileName=" + this.fileName + ",filePath=" + this.filePath + ",md5HexStr=" + this.md5HexStr + ",fileSize=" + this.fileSize + ",duration=" + this.duration + ",formatType=" + this.formatType + ",voiceType=" + this.voiceType + ",autoConvertText=" + this.autoConvertText + ",voiceChangeType=" + this.voiceChangeType + ",canConvert2Text=" + this.canConvert2Text + ",fileId=" + this.fileId + ",fileUuid=" + this.fileUuid + ",text=" + this.text + ",translateStatus=" + this.translateStatus + ",transferStatus=" + this.transferStatus + ",progress=" + this.progress + ",playState=" + this.playState + ",waveAmplitudes=" + this.waveAmplitudes + ",invalidState=" + this.invalidState + ",fileSubId=" + this.fileSubId + ",fileBizId=" + this.fileBizId + ",importRichMediaContext=" + this.importRichMediaContext + ",}";
    }

    public PttElement(String str, String str2, String str3, long j2, int i2, int i3, int i4, int i5, int i6, boolean z, Integer num, String str4, String str5, Integer num2, Integer num3, Integer num4, Integer num5, ArrayList<Byte> arrayList, Integer num6, String str6, Integer num7, byte[] bArr) {
        this.fileName = "";
        this.filePath = "";
        this.md5HexStr = "";
        this.waveAmplitudes = new ArrayList<>();
        this.fileSubId = "";
        this.fileName = str;
        this.filePath = str2;
        this.md5HexStr = str3;
        this.fileSize = j2;
        this.duration = i2;
        this.formatType = i3;
        this.voiceType = i4;
        this.autoConvertText = i5;
        this.voiceChangeType = i6;
        this.canConvert2Text = z;
        this.fileId = num;
        this.fileUuid = str4;
        this.text = str5;
        this.translateStatus = num2;
        this.transferStatus = num3;
        this.progress = num4;
        this.playState = num5;
        this.waveAmplitudes = arrayList;
        this.invalidState = num6;
        this.fileSubId = str6;
        this.fileBizId = num7;
        this.importRichMediaContext = bArr;
    }
}
