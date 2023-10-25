package com.tencent.qqnt.kernel.nativeinterface;

public final class FaceElement implements IKernelModel {
    Integer doubleHit;
    Integer faceBubbleCount;
    int faceIndex;
    String faceText;
    int faceType;
    Integer imageType;
    Integer msgType;
    String oldVersionStr;
    String packId;
    Integer pokeFlag;
    Integer pokeStrength;
    Integer pokeType;
    Integer randomType;
    String resultId;
    Integer sourceType;
    String spokeSummary;
    String stickerId;
    Integer stickerType;
    String surpriseId;
    Integer vaspokeId;
    String vaspokeMinver;
    String vaspokeName;

    public FaceElement() {
    }

    public Integer getDoubleHit() {
        return this.doubleHit;
    }

    public Integer getFaceBubbleCount() {
        return this.faceBubbleCount;
    }

    public int getFaceIndex() {
        return this.faceIndex;
    }

    public String getFaceText() {
        return this.faceText;
    }

    public int getFaceType() {
        return this.faceType;
    }

    public Integer getImageType() {
        return this.imageType;
    }

    public Integer getMsgType() {
        return this.msgType;
    }

    public String getOldVersionStr() {
        return this.oldVersionStr;
    }

    public String getPackId() {
        return this.packId;
    }

    public Integer getPokeFlag() {
        return this.pokeFlag;
    }

    public Integer getPokeStrength() {
        return this.pokeStrength;
    }

    public Integer getPokeType() {
        return this.pokeType;
    }

    public Integer getRandomType() {
        return this.randomType;
    }

    public String getResultId() {
        return this.resultId;
    }

    public Integer getSourceType() {
        return this.sourceType;
    }

    public String getSpokeSummary() {
        return this.spokeSummary;
    }

    public String getStickerId() {
        return this.stickerId;
    }

    public Integer getStickerType() {
        return this.stickerType;
    }

    public String getSurpriseId() {
        return this.surpriseId;
    }

    public Integer getVaspokeId() {
        return this.vaspokeId;
    }

    public String getVaspokeMinver() {
        return this.vaspokeMinver;
    }

    public String getVaspokeName() {
        return this.vaspokeName;
    }

    public void setDoubleHit(Integer num) {
        this.doubleHit = num;
    }

    public void setFaceBubbleCount(Integer num) {
        this.faceBubbleCount = num;
    }

    public void setFaceIndex(int i2) {
        this.faceIndex = i2;
    }

    public void setFaceText(String str) {
        this.faceText = str;
    }

    public void setFaceType(int i2) {
        this.faceType = i2;
    }

    public void setImageType(Integer num) {
        this.imageType = num;
    }

    public void setMsgType(Integer num) {
        this.msgType = num;
    }

    public void setOldVersionStr(String str) {
        this.oldVersionStr = str;
    }

    public void setPackId(String str) {
        this.packId = str;
    }

    public void setPokeFlag(Integer num) {
        this.pokeFlag = num;
    }

    public void setPokeStrength(Integer num) {
        this.pokeStrength = num;
    }

    public void setPokeType(Integer num) {
        this.pokeType = num;
    }

    public void setRandomType(Integer num) {
        this.randomType = num;
    }

    public void setResultId(String str) {
        this.resultId = str;
    }

    public void setSourceType(Integer num) {
        this.sourceType = num;
    }

    public void setSpokeSummary(String str) {
        this.spokeSummary = str;
    }

    public void setStickerId(String str) {
        this.stickerId = str;
    }

    public void setStickerType(Integer num) {
        this.stickerType = num;
    }

    public void setSurpriseId(String str) {
        this.surpriseId = str;
    }

    public void setVaspokeId(Integer num) {
        this.vaspokeId = num;
    }

    public void setVaspokeMinver(String str) {
        this.vaspokeMinver = str;
    }

    public void setVaspokeName(String str) {
        this.vaspokeName = str;
    }

    public String toString() {
        return "FaceElement{faceIndex=" + this.faceIndex + ",faceText=" + this.faceText + ",faceType=" + this.faceType + ",packId=" + this.packId + ",stickerId=" + this.stickerId + ",sourceType=" + this.sourceType + ",stickerType=" + this.stickerType + ",resultId=" + this.resultId + ",surpriseId=" + this.surpriseId + ",randomType=" + this.randomType + ",imageType=" + this.imageType + ",pokeType=" + this.pokeType + ",spokeSummary=" + this.spokeSummary + ",doubleHit=" + this.doubleHit + ",vaspokeId=" + this.vaspokeId + ",vaspokeName=" + this.vaspokeName + ",vaspokeMinver=" + this.vaspokeMinver + ",pokeStrength=" + this.pokeStrength + ",msgType=" + this.msgType + ",faceBubbleCount=" + this.faceBubbleCount + ",oldVersionStr=" + this.oldVersionStr + ",pokeFlag=" + this.pokeFlag + ",}";
    }

    public FaceElement(int i2, String str, int i3, String str2, String str3, Integer num, Integer num2, String str4, String str5, Integer num3, Integer num4, Integer num5, String str6, Integer num6, Integer num7, String str7, String str8, Integer num8, Integer num9, Integer num10, String str9, Integer num11) {
        this.faceIndex = i2;
        this.faceText = str;
        this.faceType = i3;
        this.packId = str2;
        this.stickerId = str3;
        this.sourceType = num;
        this.stickerType = num2;
        this.resultId = str4;
        this.surpriseId = str5;
        this.randomType = num3;
        this.imageType = num4;
        this.pokeType = num5;
        this.spokeSummary = str6;
        this.doubleHit = num6;
        this.vaspokeId = num7;
        this.vaspokeName = str7;
        this.vaspokeMinver = str8;
        this.pokeStrength = num8;
        this.msgType = num9;
        this.faceBubbleCount = num10;
        this.oldVersionStr = str9;
        this.pokeFlag = num11;
    }
}
