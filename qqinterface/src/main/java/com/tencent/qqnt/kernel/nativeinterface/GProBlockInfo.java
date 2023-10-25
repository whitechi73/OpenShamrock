package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProBlockInfo implements Serializable {
    String blockId;
    int blockIndex;
    String blockName;
    int blockType;
    ArrayList<GProRecommendCategory> categories;
    boolean hasMore;
    int isWhole;
    ArrayList<GProRecommendItem> items;
    long serialVersionUID;

    public GProBlockInfo() {
        this.serialVersionUID = 1L;
        this.blockId = "";
        this.blockName = "";
        this.items = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public String getBlockId() {
        return this.blockId;
    }

    public int getBlockIndex() {
        return this.blockIndex;
    }

    public String getBlockName() {
        return this.blockName;
    }

    public int getBlockType() {
        return this.blockType;
    }

    public ArrayList<GProRecommendCategory> getCategories() {
        return this.categories;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public int getIsWhole() {
        return this.isWhole;
    }

    public ArrayList<GProRecommendItem> getItems() {
        return this.items;
    }

    public String toString() {
        return "GProBlockInfo{blockId=" + this.blockId + ",blockType=" + this.blockType + ",blockIndex=" + this.blockIndex + ",blockName=" + this.blockName + ",items=" + this.items + ",hasMore=" + this.hasMore + ",categories=" + this.categories + ",isWhole=" + this.isWhole + ",}";
    }

    public GProBlockInfo(String str, int i2, int i3, String str2, ArrayList<GProRecommendItem> arrayList, boolean z, ArrayList<GProRecommendCategory> arrayList2, int i4) {
        this.serialVersionUID = 1L;
        this.blockId = "";
        this.blockName = "";
        this.items = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.blockId = str;
        this.blockType = i2;
        this.blockIndex = i3;
        this.blockName = str2;
        this.items = arrayList;
        this.hasMore = z;
        this.categories = arrayList2;
        this.isWhole = i4;
    }
}
