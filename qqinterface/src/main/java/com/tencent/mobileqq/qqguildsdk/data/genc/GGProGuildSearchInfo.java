package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProRecallInfoData;
import com.tencent.mobileqq.qqguildsdk.data.IRecallInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildChannelState;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildSearchInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProMedalInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendLabel;
import com.tencent.qqnt.kernel.nativeinterface.GProSearchRankInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGuildSearchInfo implements Serializable {
    public final GProGuildSearchInfo mInfo;

    public GGProGuildSearchInfo(GProGuildSearchInfo gProGuildSearchInfo) {
        this.mInfo = gProGuildSearchInfo;
    }

    public String getCoverUrl() {
        return this.mInfo.getCoverUrl();
    }

    public long getGuildIdLong() {
        return this.mInfo.getGuildId();
    }

    public String getGuildNumber() {
        return this.mInfo.getGuildNumber();
    }

    public ArrayList<Object> getGuildStates() {
        ArrayList<GProGuildChannelState> guildStates = this.mInfo.getGuildStates();
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProGuildChannelState> it = guildStates.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildChannelState(it.next()));
        }
        return arrayList;
    }

    public String getHeadUrl() {
        return this.mInfo.getHeadUrl();
    }

    public ArrayList<String> getHighlightWords() {
        return this.mInfo.getHighlightWords();
    }

    public String getJoinGuildSig() {
        return this.mInfo.getJoinGuildSig();
    }

    public int getJoinedGuild() {
        return this.mInfo.getJoinedGuild();
    }

    public ArrayList<IGProRecommendLabel> getLabelList() {
        ArrayList<GProRecommendLabel> labelList = this.mInfo.getLabelList();
        ArrayList<IGProRecommendLabel> arrayList = new ArrayList<>();
        Iterator<GProRecommendLabel> it = labelList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendLabel(it.next()));
        }
        return arrayList;
    }

    public ArrayList<IGProMedalInfo> getMedalInfoList() {
        ArrayList<GProMedalInfo> medalInfoList = this.mInfo.getMedalInfoList();
        ArrayList<IGProMedalInfo> arrayList = new ArrayList<>();
        Iterator<GProMedalInfo> it = medalInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMedalInfo(it.next()));
        }
        return arrayList;
    }

    public int getMedalLevel() {
        return this.mInfo.getMedalLevel();
    }

    public String getName() {
        return this.mInfo.getName();
    }

    public IGProRecommendLabel getPeopleLabel() {
        return new GGProRecommendLabel(this.mInfo.getPeopleLabel());
    }

    public String getProfile() {
        return this.mInfo.getProfile();
    }

    public ArrayList<IGProSearchRankInfo> getRankList() {
        ArrayList<GProSearchRankInfo> rankList = this.mInfo.getRankList();
        ArrayList<IGProSearchRankInfo> arrayList = new ArrayList<>();
        Iterator<GProSearchRankInfo> it = rankList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProSearchRankInfo(it.next()));
        }
        return arrayList;
    }

    public IRecallInfo getRecallInfo() {
        return new GProRecallInfoData(this.mInfo.getRecallInfo());
    }

    public IGProRecommendLabel getRecommendReason() {
        return new GGProRecommendLabel(this.mInfo.getRecommendReason());
    }

    public int getShowType() {
        return this.mInfo.getShowType();
    }

    public IGProSuggestedSearch getSuggestedSearchInfo() {
        return new GGProSuggestedSearch(this.mInfo.getSuggestedSearchInfo());
    }

    public ArrayList<String> getTags() {
        return this.mInfo.getTags();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
