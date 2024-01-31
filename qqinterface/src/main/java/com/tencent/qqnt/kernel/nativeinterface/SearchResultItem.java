package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SearchResultItem {
    String extension;
    String jmpUrl;
    ArrayList<Mean> means;
    String name;
    String picUrl;
    String resultId;

    public SearchResultItem() {
        this.resultId = "";
        this.name = "";
        this.picUrl = "";
        this.jmpUrl = "";
        this.means = new ArrayList<>();
        this.extension = "";
    }

    public String getExtension() {
        return this.extension;
    }

    public String getJmpUrl() {
        return this.jmpUrl;
    }

    public ArrayList<Mean> getMeans() {
        return this.means;
    }

    public String getName() {
        return this.name;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getResultId() {
        return this.resultId;
    }

    public String toString() {
        return "SearchResultItem{resultId=" + this.resultId + ",name=" + this.name + ",picUrl=" + this.picUrl + ",jmpUrl=" + this.jmpUrl + ",means=" + this.means + ",extension=" + this.extension + ",}";
    }

    public SearchResultItem(String str, String str2, String str3, String str4, ArrayList<Mean> arrayList, String str5) {
        this.resultId = "";
        this.name = "";
        this.picUrl = "";
        this.jmpUrl = "";
        this.means = new ArrayList<>();
        this.extension = "";
        this.resultId = str;
        this.name = str2;
        this.picUrl = str3;
        this.jmpUrl = str4;
        this.means = arrayList;
        this.extension = str5;
    }
}
