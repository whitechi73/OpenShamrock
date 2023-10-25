package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProGetCategoryGuildsReq implements Serializable {
    int businessType;
    int categoryId;
    byte[] cookies;
    String name;
    long serialVersionUID;
    GProBottomTabSourceInfo source;

    public GProGetCategoryGuildsReq() {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        this.name = "";
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public String getName() {
        return this.name;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String toString() {
        return "GProGetCategoryGuildsReq{businessType=" + this.businessType + ",cookies=" + this.cookies + ",source=" + this.source + ",name=" + this.name + ",categoryId=" + this.categoryId + ",}";
    }

    public GProGetCategoryGuildsReq(int i2, byte[] bArr, GProBottomTabSourceInfo gProBottomTabSourceInfo, String str, int i3) {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        this.name = "";
        this.businessType = i2;
        this.cookies = bArr;
        this.source = gProBottomTabSourceInfo;
        this.name = str;
        this.categoryId = i3;
    }
}
