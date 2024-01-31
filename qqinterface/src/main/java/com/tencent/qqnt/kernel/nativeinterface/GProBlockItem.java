package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProBlockItem implements Serializable {
    String blockId;
    String blockName;
    int blockType;
    ArrayList<GProItemIdInfo> itemList;
    long serialVersionUID;

    public GProBlockItem() {
        this.serialVersionUID = 1L;
        this.blockId = "";
        this.blockName = "";
        this.itemList = new ArrayList<>();
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

    public ArrayList<GProItemIdInfo> getItemList() {
        return this.itemList;
    }

    public String toString() {
        return "GProBlockItem{blockId=" + this.blockId + ",blockType=" + this.blockType + ",blockName=" + this.blockName + ",itemList=" + this.itemList + ",}";
    }

    public GProBlockItem(String str, int i2, String str2, ArrayList<GProItemIdInfo> arrayList) {
        this.serialVersionUID = 1L;
        this.blockId = "";
        this.blockName = "";
        this.itemList = new ArrayList<>();
        this.blockId = str;
        this.blockType = i2;
        this.blockName = str2;
        this.itemList = arrayList;
    }
}
