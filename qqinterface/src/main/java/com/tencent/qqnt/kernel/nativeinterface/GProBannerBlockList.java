package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProBannerBlockList implements Serializable {
    String blockName;
    ArrayList<GProBlockBaseInfo> list;
    long serialVersionUID;

    public GProBannerBlockList() {
        this.serialVersionUID = 1L;
        this.blockName = "";
        this.list = new ArrayList<>();
    }

    public String getBlockName() {
        return this.blockName;
    }

    public ArrayList<GProBlockBaseInfo> getList() {
        return this.list;
    }

    public String toString() {
        return "GProBannerBlockList{blockName=" + this.blockName + ",list=" + this.list + ",}";
    }

    public GProBannerBlockList(String str, ArrayList<GProBlockBaseInfo> arrayList) {
        this.serialVersionUID = 1L;
        this.blockName = "";
        this.list = new ArrayList<>();
        this.blockName = str;
        this.list = arrayList;
    }
}
