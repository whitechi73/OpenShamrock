package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProRecommendCategory implements Serializable {
    int categoryId;
    int categoryType;
    String groupId;
    boolean hasMore;
    String name;
    long serialVersionUID;
    String type;

    public GProRecommendCategory() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.groupId = "";
        this.type = "";
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "GProRecommendCategory{name=" + this.name + ",categoryId=" + this.categoryId + ",groupId=" + this.groupId + ",hasMore=" + this.hasMore + ",type=" + this.type + ",categoryType=" + this.categoryType + ",}";
    }

    public GProRecommendCategory(String str, int i2, String str2, boolean z, String str3, int i3) {
        this.serialVersionUID = 1L;
        this.name = "";
        this.groupId = "";
        this.type = "";
        this.name = str;
        this.categoryId = i2;
        this.groupId = str2;
        this.hasMore = z;
        this.type = str3;
        this.categoryType = i3;
    }
}
