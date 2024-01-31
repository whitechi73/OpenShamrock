package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGuildSearchInfo {
    String coverUrl;
    long guildId;
    String guildNumber;
    ArrayList<GProGuildChannelState> guildStates;
    String headUrl;
    ArrayList<String> highlightWords;
    String joinGuildSig;
    int joinedGuild;
    ArrayList<GProRecommendLabel> labelList;
    ArrayList<GProMedalInfo> medalInfoList;
    int medalLevel;
    String name;
    GProRecommendLabel peopleLabel;
    String profile;
    ArrayList<GProSearchRankInfo> rankList;
    GProRecallInfo recallInfo;
    GProRecommendLabel recommendReason;
    int showType;
    GProSuggestedSearch suggestedSearchInfo;
    ArrayList<String> tags;

    public GProGuildSearchInfo() {
        this.name = "";
        this.profile = "";
        this.coverUrl = "";
        this.joinGuildSig = "";
        this.headUrl = "";
        this.guildStates = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.guildNumber = "";
        this.recallInfo = new GProRecallInfo();
        this.medalInfoList = new ArrayList<>();
        this.labelList = new ArrayList<>();
        this.rankList = new ArrayList<>();
        this.peopleLabel = new GProRecommendLabel();
        this.recommendReason = new GProRecommendLabel();
        this.highlightWords = new ArrayList<>();
        this.suggestedSearchInfo = new GProSuggestedSearch();
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildNumber() {
        return this.guildNumber;
    }

    public ArrayList<GProGuildChannelState> getGuildStates() {
        return this.guildStates;
    }

    public String getHeadUrl() {
        return this.headUrl;
    }

    public ArrayList<String> getHighlightWords() {
        return this.highlightWords;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public int getJoinedGuild() {
        return this.joinedGuild;
    }

    public ArrayList<GProRecommendLabel> getLabelList() {
        return this.labelList;
    }

    public ArrayList<GProMedalInfo> getMedalInfoList() {
        return this.medalInfoList;
    }

    public int getMedalLevel() {
        return this.medalLevel;
    }

    public String getName() {
        return this.name;
    }

    public GProRecommendLabel getPeopleLabel() {
        return this.peopleLabel;
    }

    public String getProfile() {
        return this.profile;
    }

    public ArrayList<GProSearchRankInfo> getRankList() {
        return this.rankList;
    }

    public GProRecallInfo getRecallInfo() {
        return this.recallInfo;
    }

    public GProRecommendLabel getRecommendReason() {
        return this.recommendReason;
    }

    public int getShowType() {
        return this.showType;
    }

    public GProSuggestedSearch getSuggestedSearchInfo() {
        return this.suggestedSearchInfo;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public String toString() {
        return "GProGuildSearchInfo{joinedGuild=" + this.joinedGuild + ",name=" + this.name + ",profile=" + this.profile + ",coverUrl=" + this.coverUrl + ",joinGuildSig=" + this.joinGuildSig + ",guildId=" + this.guildId + ",headUrl=" + this.headUrl + ",guildStates=" + this.guildStates + ",tags=" + this.tags + ",guildNumber=" + this.guildNumber + ",recallInfo=" + this.recallInfo + ",medalLevel=" + this.medalLevel + ",medalInfoList=" + this.medalInfoList + ",labelList=" + this.labelList + ",rankList=" + this.rankList + ",peopleLabel=" + this.peopleLabel + ",recommendReason=" + this.recommendReason + ",highlightWords=" + this.highlightWords + ",suggestedSearchInfo=" + this.suggestedSearchInfo + ",showType=" + this.showType + ",}";
    }

    public GProGuildSearchInfo(int i2, String str, String str2, String str3, String str4, long j2, String str5, ArrayList<GProGuildChannelState> arrayList, ArrayList<String> arrayList2, String str6, GProRecallInfo gProRecallInfo, int i3, ArrayList<GProMedalInfo> arrayList3, ArrayList<GProRecommendLabel> arrayList4, ArrayList<GProSearchRankInfo> arrayList5, GProRecommendLabel gProRecommendLabel, GProRecommendLabel gProRecommendLabel2, ArrayList<String> arrayList6, GProSuggestedSearch gProSuggestedSearch, int i4) {
        this.name = "";
        this.profile = "";
        this.coverUrl = "";
        this.joinGuildSig = "";
        this.headUrl = "";
        this.guildStates = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.guildNumber = "";
        this.recallInfo = new GProRecallInfo();
        this.medalInfoList = new ArrayList<>();
        this.labelList = new ArrayList<>();
        this.rankList = new ArrayList<>();
        this.peopleLabel = new GProRecommendLabel();
        this.recommendReason = new GProRecommendLabel();
        this.highlightWords = new ArrayList<>();
        this.suggestedSearchInfo = new GProSuggestedSearch();
        this.joinedGuild = i2;
        this.name = str;
        this.profile = str2;
        this.coverUrl = str3;
        this.joinGuildSig = str4;
        this.guildId = j2;
        this.headUrl = str5;
        this.guildStates = arrayList;
        this.tags = arrayList2;
        this.guildNumber = str6;
        this.recallInfo = gProRecallInfo;
        this.medalLevel = i3;
        this.medalInfoList = arrayList3;
        this.labelList = arrayList4;
        this.rankList = arrayList5;
        this.peopleLabel = gProRecommendLabel;
        this.recommendReason = gProRecommendLabel2;
        this.highlightWords = arrayList6;
        this.suggestedSearchInfo = gProSuggestedSearch;
        this.showType = i4;
    }
}
