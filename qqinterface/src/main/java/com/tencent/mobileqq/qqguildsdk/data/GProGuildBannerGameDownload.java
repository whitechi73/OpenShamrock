package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProGameDownloadLink;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildBannerGameDownloadInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GProGuildBannerGameDownload implements IGProGuildGameDownloadInfo {
    private String content;
    private String gameId;
    private String jumpText;
    private ArrayList<Object> links;
    private ArrayList<String> picUrls;
    private String tagText;
    private String title;

    public GProGuildBannerGameDownload(GProGuildBannerGameDownloadInfo gProGuildBannerGameDownloadInfo) {
        this.gameId = gProGuildBannerGameDownloadInfo.getGameId();
        this.title = gProGuildBannerGameDownloadInfo.getTitle();
        this.content = gProGuildBannerGameDownloadInfo.getContent();
        this.picUrls = gProGuildBannerGameDownloadInfo.getPicUrl();
        ArrayList<GProGameDownloadLink> links = gProGuildBannerGameDownloadInfo.getLinks();
        this.links = new ArrayList<>();
        if (links != null) {
            Iterator<GProGameDownloadLink> it = links.iterator();
            while (it.hasNext()) {
                GProGameDownloadLink next = it.next();
                //an anVar = new an();
                //anVar.a(next.getPlatform());
                //anVar.b(next.getUrl());
                //this.links.add(anVar);
            }
        }
        this.jumpText = gProGuildBannerGameDownloadInfo.getJumpText();
        this.tagText = gProGuildBannerGameDownloadInfo.getTagText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildGameDownloadInfo
    public String getContent() {
        return this.content;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildGameDownloadInfo
    public String getGameId() {
        return this.gameId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildGameDownloadInfo
    public String getJumpText() {
        return this.jumpText;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildGameDownloadInfo
    public ArrayList<Object> getLinks() {
        return this.links;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildGameDownloadInfo
    public ArrayList<String> getPicUrls() {
        return this.picUrls;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildGameDownloadInfo
    public String getTagText() {
        return this.tagText;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildGameDownloadInfo
    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setLinks(ArrayList<Object> arrayList) {
        this.links = arrayList;
    }

    public void setPicUrls(ArrayList<String> arrayList) {
        this.picUrls = arrayList;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "GProGuildBannerGameDownload{gameId='" + this.gameId + "', title='" + this.title + "', content='" + this.content + "', picUrls=" + this.picUrls + ", links=" + this.links + ", jumpText='" + this.jumpText + "', tagText='" + this.tagText + "'}";
    }
}
