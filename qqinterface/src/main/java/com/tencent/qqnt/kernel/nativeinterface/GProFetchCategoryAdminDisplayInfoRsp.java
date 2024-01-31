package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProFetchCategoryAdminDisplayInfoRsp {
    ArrayList<GProCategoryAdminDisplayInfo> categoryAdminDisplayList;
    int categoryAdminMaxNum;

    public GProFetchCategoryAdminDisplayInfoRsp() {
        this.categoryAdminDisplayList = new ArrayList<>();
    }

    public ArrayList<GProCategoryAdminDisplayInfo> getCategoryAdminDisplayList() {
        return this.categoryAdminDisplayList;
    }

    public int getCategoryAdminMaxNum() {
        return this.categoryAdminMaxNum;
    }

    public String toString() {
        return "GProFetchCategoryAdminDisplayInfoRsp{categoryAdminDisplayList=" + this.categoryAdminDisplayList + ",categoryAdminMaxNum=" + this.categoryAdminMaxNum + ",}";
    }

    public GProFetchCategoryAdminDisplayInfoRsp(ArrayList<GProCategoryAdminDisplayInfo> arrayList, int i2) {
        this.categoryAdminDisplayList = new ArrayList<>();
        this.categoryAdminDisplayList = arrayList;
        this.categoryAdminMaxNum = i2;
    }
}
