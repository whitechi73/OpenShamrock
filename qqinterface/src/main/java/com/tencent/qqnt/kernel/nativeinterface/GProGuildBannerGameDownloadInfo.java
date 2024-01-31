package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProGuildBannerGameDownloadInfo implements Serializable {
    String content;
    String gameId;
    String jumpText;
    ArrayList<GProGameDownloadLink> links;
    ArrayList<String> picUrl;
    long serialVersionUID;
    String tagText;
    String title;

    public GProGuildBannerGameDownloadInfo() {
        this.serialVersionUID = 1L;
        this.gameId = "";
        this.title = "";
        this.content = "";
        this.picUrl = new ArrayList<>();
        this.links = new ArrayList<>();
        this.jumpText = "";
        this.tagText = "";
    }

    public String getContent() {
        return this.content;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getJumpText() {
        return this.jumpText;
    }

    public ArrayList<GProGameDownloadLink> getLinks() {
        return this.links;
    }

    public ArrayList<String> getPicUrl() {
        return this.picUrl;
    }

    public String getTagText() {
        return this.tagText;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProGuildBannerGameDownloadInfo{gameId=" + this.gameId + ",title=" + this.title + ",content=" + this.content + ",picUrl=" + this.picUrl + ",links=" + this.links + ",jumpText=" + this.jumpText + ",tagText=" + this.tagText + ",}";
    }

    public GProGuildBannerGameDownloadInfo(String str, String str2, String str3, ArrayList<String> arrayList, ArrayList<GProGameDownloadLink> arrayList2, String str4, String str5) {
        this.serialVersionUID = 1L;
        this.gameId = "";
        this.title = "";
        this.content = "";
        this.picUrl = new ArrayList<>();
        this.links = new ArrayList<>();
        this.jumpText = "";
        this.tagText = "";
        this.gameId = str;
        this.title = str2;
        this.content = str3;
        this.picUrl = arrayList;
        this.links = arrayList2;
        this.jumpText = str4;
        this.tagText = str5;
    }
}
