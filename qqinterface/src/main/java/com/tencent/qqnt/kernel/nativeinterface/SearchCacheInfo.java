package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class SearchCacheInfo {
    ArrayList<String> fields;
    String id;

    public SearchCacheInfo() {
        this.id = "";
        this.fields = new ArrayList<>();
    }

    public ArrayList<String> getFields() {
        return this.fields;
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "SearchCacheInfo{id=" + this.id + ",fields=" + this.fields + ",}";
    }

    public SearchCacheInfo(String str, ArrayList<String> arrayList) {
        this.id = "";
        this.fields = new ArrayList<>();
        this.id = str;
        this.fields = arrayList;
    }
}
