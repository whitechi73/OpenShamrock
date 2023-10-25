package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProGetSubjectGuildsReq implements Serializable {
    String blockId;
    String blockName;
    int blockType;
    int businessType;
    byte[] cookies;
    int limit;
    long serialVersionUID;
    GProBottomTabSourceInfo source;

    public GProGetSubjectGuildsReq() {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        this.blockId = "";
        this.blockName = "";
    }

    public String getBlockId() {
        return this.blockId;
    }

    public String getBlockName() {
        return this.blockName;
    }

    public int getBlockType() {
        return this.blockType;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public int getLimit() {
        return this.limit;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String toString() {
        return "GProGetSubjectGuildsReq{businessType=" + this.businessType + ",cookies=" + this.cookies + ",source=" + this.source + ",blockId=" + this.blockId + ",blockType=" + this.blockType + ",blockName=" + this.blockName + ",limit=" + this.limit + ",}";
    }

    public GProGetSubjectGuildsReq(int i2, byte[] bArr, GProBottomTabSourceInfo gProBottomTabSourceInfo, String str, int i3, String str2, int i4) {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        this.blockId = "";
        this.blockName = "";
        this.businessType = i2;
        this.cookies = bArr;
        this.source = gProBottomTabSourceInfo;
        this.blockId = str;
        this.blockType = i3;
        this.blockName = str2;
        this.limit = i4;
    }
}
