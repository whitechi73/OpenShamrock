package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProBatchGetBlockItemReq implements Serializable {
    int businessType;
    ArrayList<GProBlockItem> itemList;
    long serialVersionUID;
    GProBottomTabSourceInfo source;

    public GProBatchGetBlockItemReq() {
        this.serialVersionUID = 1L;
        this.itemList = new ArrayList<>();
        this.source = new GProBottomTabSourceInfo();
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public ArrayList<GProBlockItem> getItemList() {
        return this.itemList;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String toString() {
        return "GProBatchGetBlockItemReq{businessType=" + this.businessType + ",itemList=" + this.itemList + ",source=" + this.source + ",}";
    }

    public GProBatchGetBlockItemReq(int i2, ArrayList<GProBlockItem> arrayList, GProBottomTabSourceInfo gProBottomTabSourceInfo) {
        this.serialVersionUID = 1L;
        this.itemList = new ArrayList<>();
        this.source = new GProBottomTabSourceInfo();
        this.businessType = i2;
        this.itemList = arrayList;
        this.source = gProBottomTabSourceInfo;
    }
}
