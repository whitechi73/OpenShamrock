package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes4.dex */
public final class GProCategoryAdminDisplayInfo {
    long categoryAdminNum;
    long categoryId;
    String categoryName;

    public GProCategoryAdminDisplayInfo() {
        this.categoryName = "";
    }

    public long getCategoryAdminNum() {
        return this.categoryAdminNum;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String toString() {
        return "GProCategoryAdminDisplayInfo{categoryId=" + this.categoryId + ",categoryName=" + this.categoryName + ",categoryAdminNum=" + this.categoryAdminNum + ",}";
    }

    public GProCategoryAdminDisplayInfo(long j2, String str, long j3) {
        this.categoryName = "";
        this.categoryId = j2;
        this.categoryName = str;
        this.categoryAdminNum = j3;
    }
}
