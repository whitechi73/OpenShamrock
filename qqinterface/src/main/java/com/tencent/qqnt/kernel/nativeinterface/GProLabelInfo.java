package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProLabelInfo implements Serializable {
    String content;
    String detailsAvUrl;
    String detailsImageUrl;
    String friendJoinNumTag;
    ArrayList<GProGuildInfoInLabel> guildInfos;
    String introduceAvUrl;
    String introduceImageUrl;
    String labelTopPicture;
    String labelTopWord;
    String name;
    String selectedCntTag;
    long serialVersionUID;

    public GProLabelInfo() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.introduceImageUrl = "";
        this.introduceAvUrl = "";
        this.detailsImageUrl = "";
        this.detailsAvUrl = "";
        this.content = "";
        this.guildInfos = new ArrayList<>();
        this.selectedCntTag = "";
        this.labelTopWord = "";
        this.labelTopPicture = "";
        this.friendJoinNumTag = "";
    }

    public String getContent() {
        return this.content;
    }

    public String getDetailsAvUrl() {
        return this.detailsAvUrl;
    }

    public String getDetailsImageUrl() {
        return this.detailsImageUrl;
    }

    public String getFriendJoinNumTag() {
        return this.friendJoinNumTag;
    }

    public ArrayList<GProGuildInfoInLabel> getGuildInfos() {
        return this.guildInfos;
    }

    public String getIntroduceAvUrl() {
        return this.introduceAvUrl;
    }

    public String getIntroduceImageUrl() {
        return this.introduceImageUrl;
    }

    public String getLabelTopPicture() {
        return this.labelTopPicture;
    }

    public String getLabelTopWord() {
        return this.labelTopWord;
    }

    public String getName() {
        return this.name;
    }

    public String getSelectedCntTag() {
        return this.selectedCntTag;
    }

    public String toString() {
        return "GProLabelInfo{name=" + this.name + ",introduceImageUrl=" + this.introduceImageUrl + ",introduceAvUrl=" + this.introduceAvUrl + ",detailsImageUrl=" + this.detailsImageUrl + ",detailsAvUrl=" + this.detailsAvUrl + ",content=" + this.content + ",guildInfos=" + this.guildInfos + ",selectedCntTag=" + this.selectedCntTag + ",labelTopWord=" + this.labelTopWord + ",labelTopPicture=" + this.labelTopPicture + ",friendJoinNumTag=" + this.friendJoinNumTag + ",}";
    }

    public GProLabelInfo(String str, String str2, String str3, String str4, String str5, String str6, ArrayList<GProGuildInfoInLabel> arrayList, String str7, String str8, String str9, String str10) {
        this.serialVersionUID = 1L;
        this.name = "";
        this.introduceImageUrl = "";
        this.introduceAvUrl = "";
        this.detailsImageUrl = "";
        this.detailsAvUrl = "";
        this.content = "";
        this.guildInfos = new ArrayList<>();
        this.selectedCntTag = "";
        this.labelTopWord = "";
        this.labelTopPicture = "";
        this.friendJoinNumTag = "";
        this.name = str;
        this.introduceImageUrl = str2;
        this.introduceAvUrl = str3;
        this.detailsImageUrl = str4;
        this.detailsAvUrl = str5;
        this.content = str6;
        this.guildInfos = arrayList;
        this.selectedCntTag = str7;
        this.labelTopWord = str8;
        this.labelTopPicture = str9;
        this.friendJoinNumTag = str10;
    }
}
