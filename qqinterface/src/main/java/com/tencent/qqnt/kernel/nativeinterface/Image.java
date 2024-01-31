package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class Image {
    byte[] busiData;
    int displayIndex;
    int height;
    String imageMD5;
    String layerPicUrl;
    String patternId;
    String picId;
    String picUrl;
    ArrayList<ImageUrl> vecImageUrl;
    int width;

    public Image() {
        this.picUrl = "";
        this.picId = "";
        this.patternId = "";
    }

    public byte[] getBusiData() {
        return this.busiData;
    }

    public int getDisplayIndex() {
        return this.displayIndex;
    }

    public int getHeight() {
        return this.height;
    }

    public String getImageMD5() {
        return this.imageMD5;
    }

    public String getLayerPicUrl() {
        return this.layerPicUrl;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public String getPicId() {
        return this.picId;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public ArrayList<ImageUrl> getVecImageUrl() {
        return this.vecImageUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "Image{width=" + this.width + ",height=" + this.height + ",picUrl=" + this.picUrl + ",vecImageUrl=" + this.vecImageUrl + ",picId=" + this.picId + ",busiData=" + this.busiData + ",imageMD5=" + this.imageMD5 + ",layerPicUrl=" + this.layerPicUrl + ",patternId=" + this.patternId + ",displayIndex=" + this.displayIndex + ",}";
    }

    public Image(int i2, int i3, String str, ArrayList<ImageUrl> arrayList, String str2, byte[] bArr, String str3, String str4, String str5, int i4) {
        this.picUrl = "";
        this.picId = "";
        this.patternId = "";
        this.width = i2;
        this.height = i3;
        this.picUrl = str;
        this.vecImageUrl = arrayList;
        this.picId = str2;
        this.busiData = bArr;
        this.imageMD5 = str3;
        this.layerPicUrl = str4;
        this.patternId = str5;
        this.displayIndex = i4;
    }
}
