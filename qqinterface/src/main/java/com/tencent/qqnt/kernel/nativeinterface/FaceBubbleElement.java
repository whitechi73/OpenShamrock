package com.tencent.qqnt.kernel.nativeinterface;

public final class FaceBubbleElement {
    String content;
    Integer faceCount;
    Integer faceFlag;
    String faceSummary;
    int faceType;
    String oldVersionStr;
    String others;
    SmallYellowFaceInfo yellowFaceInfo;

    public FaceBubbleElement() {
    }

    public String getContent() {
        return this.content;
    }

    public Integer getFaceCount() {
        return this.faceCount;
    }

    public Integer getFaceFlag() {
        return this.faceFlag;
    }

    public String getFaceSummary() {
        return this.faceSummary;
    }

    public int getFaceType() {
        return this.faceType;
    }

    public String getOldVersionStr() {
        return this.oldVersionStr;
    }

    public String getOthers() {
        return this.others;
    }

    public SmallYellowFaceInfo getYellowFaceInfo() {
        return this.yellowFaceInfo;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFaceCount(Integer num) {
        this.faceCount = num;
    }

    public void setFaceFlag(Integer num) {
        this.faceFlag = num;
    }

    public void setFaceSummary(String str) {
        this.faceSummary = str;
    }

    public void setFaceType(int i2) {
        this.faceType = i2;
    }

    public void setOldVersionStr(String str) {
        this.oldVersionStr = str;
    }

    public void setOthers(String str) {
        this.others = str;
    }

    public void setYellowFaceInfo(SmallYellowFaceInfo smallYellowFaceInfo) {
        this.yellowFaceInfo = smallYellowFaceInfo;
    }

    public String toString() {
        return "FaceBubbleElement{faceType=" + this.faceType + ",faceCount=" + this.faceCount + ",faceSummary=" + this.faceSummary + ",faceFlag=" + this.faceFlag + ",content=" + this.content + ",oldVersionStr=" + this.oldVersionStr + ",others=" + this.others + ",yellowFaceInfo=" + this.yellowFaceInfo + ",}";
    }

    public FaceBubbleElement(int i2, Integer num, String str, Integer num2, String str2, String str3, String str4, SmallYellowFaceInfo smallYellowFaceInfo) {
        this.faceType = i2;
        this.faceCount = num;
        this.faceSummary = str;
        this.faceFlag = num2;
        this.content = str2;
        this.oldVersionStr = str3;
        this.others = str4;
        this.yellowFaceInfo = smallYellowFaceInfo;
    }
}
