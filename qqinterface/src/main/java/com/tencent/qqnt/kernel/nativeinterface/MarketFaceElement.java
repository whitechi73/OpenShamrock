package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class MarketFaceElement {
    ArrayList<MarketFaceSupportSize> apngSupportSize;
    String backColor;
    String dynamicFacePath;
    String emojiId;
    int emojiPackageId;
    Integer emojiType;
    Integer endTime;
    int faceInfo;
    String faceName;
    Integer hasIpProduct;
    int imageHeight;
    int imageWidth;
    int itemType;
    String key;
    int mediaType;
    byte[] mobileParam;
    byte[] param;
    String sourceJumpUrl;
    String sourceName;
    Integer sourceType;
    String sourceTypeName;
    Integer startTime;
    String staticFacePath;
    int subType;
    ArrayList<MarketFaceSupportSize> supportSize;
    ArrayList<Integer> voiceItemHeightArr;
    String volumeColor;

    public MarketFaceElement() {
    }

    public ArrayList<MarketFaceSupportSize> getApngSupportSize() {
        return this.apngSupportSize;
    }

    public String getBackColor() {
        return this.backColor;
    }

    public String getDynamicFacePath() {
        return this.dynamicFacePath;
    }

    public String getEmojiId() {
        return this.emojiId;
    }

    public int getEmojiPackageId() {
        return this.emojiPackageId;
    }

    public Integer getEmojiType() {
        return this.emojiType;
    }

    public Integer getEndTime() {
        return this.endTime;
    }

    public int getFaceInfo() {
        return this.faceInfo;
    }

    public String getFaceName() {
        return this.faceName;
    }

    public Integer getHasIpProduct() {
        return this.hasIpProduct;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getKey() {
        return this.key;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public byte[] getMobileParam() {
        return this.mobileParam;
    }

    public byte[] getParam() {
        return this.param;
    }

    public String getSourceJumpUrl() {
        return this.sourceJumpUrl;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public Integer getSourceType() {
        return this.sourceType;
    }

    public String getSourceTypeName() {
        return this.sourceTypeName;
    }

    public Integer getStartTime() {
        return this.startTime;
    }

    public String getStaticFacePath() {
        return this.staticFacePath;
    }

    public int getSubType() {
        return this.subType;
    }

    public ArrayList<MarketFaceSupportSize> getSupportSize() {
        return this.supportSize;
    }

    public ArrayList<Integer> getVoiceItemHeightArr() {
        return this.voiceItemHeightArr;
    }

    public String getVolumeColor() {
        return this.volumeColor;
    }

    public String toString() {
        return "MarketFaceElement{itemType=" + this.itemType + ",faceInfo=" + this.faceInfo + ",emojiPackageId=" + this.emojiPackageId + ",subType=" + this.subType + ",mediaType=" + this.mediaType + ",imageWidth=" + this.imageWidth + ",imageHeight=" + this.imageHeight + ",faceName=" + this.faceName + ",emojiId=" + this.emojiId + ",key=" + this.key + ",param=" + this.param + ",mobileParam=" + this.mobileParam + ",sourceType=" + this.sourceType + ",startTime=" + this.startTime + ",endTime=" + this.endTime + ",emojiType=" + this.emojiType + ",hasIpProduct=" + this.hasIpProduct + ",voiceItemHeightArr=" + this.voiceItemHeightArr + ",sourceName=" + this.sourceName + ",sourceJumpUrl=" + this.sourceJumpUrl + ",sourceTypeName=" + this.sourceTypeName + ",backColor=" + this.backColor + ",volumeColor=" + this.volumeColor + ",staticFacePath=" + this.staticFacePath + ",dynamicFacePath=" + this.dynamicFacePath + ",supportSize=" + this.supportSize + ",apngSupportSize=" + this.apngSupportSize + ",}";
    }

    public MarketFaceElement(int itemType, int faceInfo, int packageId, int subtype, int mediaType,
                             int width, int height, String faceName, String emojiId, String key,
                             byte[] param, byte[] mobileParam,
                             Integer sourceType, Integer startTime, Integer endTime,
                             Integer emojiType, Integer hasIpProduct,
                             ArrayList<Integer> voiceItemHeightArr,
                             String sourceName, String jumpurl, String sourceTypeName,
                             String backgroundColor, String volumColor,
                             String staticPath, String dynamicPath,
                             ArrayList<MarketFaceSupportSize> supportSize,
                             ArrayList<MarketFaceSupportSize> apngSupportSize) {
        this.itemType = itemType;
        this.faceInfo = faceInfo;
        this.emojiPackageId = packageId;
        this.subType = subtype;
        this.mediaType = mediaType;
        this.imageWidth = width;
        this.imageHeight = height;
        this.faceName = faceName;
        this.emojiId = emojiId;
        this.key = key;
        this.param = param;
        this.mobileParam = mobileParam;
        this.sourceType = sourceType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.emojiType = emojiType;
        this.hasIpProduct = hasIpProduct;
        this.voiceItemHeightArr = voiceItemHeightArr;
        this.sourceName = sourceName;
        this.sourceJumpUrl = jumpurl;
        this.sourceTypeName = sourceTypeName;
        this.backColor = backgroundColor;
        this.volumeColor = volumColor;
        this.staticFacePath = staticPath;
        this.dynamicFacePath = dynamicPath;
        this.supportSize = supportSize;
        this.apngSupportSize = apngSupportSize;
    }
}
