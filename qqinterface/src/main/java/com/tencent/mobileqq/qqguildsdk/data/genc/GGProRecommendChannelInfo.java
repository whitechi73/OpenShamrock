package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProMedalInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendChannelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendGuildState;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendLabel;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRecommendChannelInfo implements IGProRecommendChannelInfo {
    public final GProRecommendChannelInfo mInfo;

    public GGProRecommendChannelInfo(GProRecommendChannelInfo gProRecommendChannelInfo) {
        this.mInfo = gProRecommendChannelInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public String getChannelName() {
        return this.mInfo.getChannelName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public int getChannelType() {
        return this.mInfo.getChannelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public String getCoverUrl() {
        return this.mInfo.getCoverUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public String getGuildIcon() {
        return this.mInfo.getGuildIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public String getGuildNumber() {
        return this.mInfo.getGuildNumber();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public String getGuildProfile() {
        return this.mInfo.getGuildProfile();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public int getIsWhole() {
        return this.mInfo.getIsWhole();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public String getItemId() {
        return this.mInfo.getItemId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public String getJoinGuildSig() {
        return this.mInfo.getJoinGuildSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public int getJoinedGuild() {
        return this.mInfo.getJoinedGuild();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public ArrayList<IGProMedalInfo> getMedalInfoList() {
        ArrayList<GProMedalInfo> medalInfoList = this.mInfo.getMedalInfoList();
        ArrayList<IGProMedalInfo> arrayList = new ArrayList<>();
        Iterator<GProMedalInfo> it = medalInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMedalInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public int getMedalLevel() {
        return this.mInfo.getMedalLevel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public int getMemberRole() {
        return this.mInfo.getMemberRole();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public IGProRecommendSeqInfo getSeqInfo() {
        return new GGProRecommendSeqInfo(this.mInfo.getSeqInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public String getShareLink() {
        return this.mInfo.getShareLink();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public int getShareTag() {
        return this.mInfo.getShareTag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public ArrayList<IGProRecommendGuildState> getStateList() {
        ArrayList<GProRecommendGuildState> stateList = this.mInfo.getStateList();
        ArrayList<IGProRecommendGuildState> arrayList = new ArrayList<>();
        Iterator<GProRecommendGuildState> it = stateList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendGuildState(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public ArrayList<IGProRecommendLabel> getTagList() {
        ArrayList<GProRecommendLabel> tagList = this.mInfo.getTagList();
        ArrayList<IGProRecommendLabel> arrayList = new ArrayList<>();
        Iterator<GProRecommendLabel> it = tagList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendLabel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public String getTitleName() {
        return this.mInfo.getTitleName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public long getUnreadAtMeCount() {
        return this.mInfo.getUnreadAtMeCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
