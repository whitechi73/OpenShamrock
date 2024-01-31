package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendGuildState;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendV2Channel;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendV2Label;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRecommendV2Channel implements IGProRecommendV2Channel {
    public final GProRecommendV2Channel mInfo;

    public GGProRecommendV2Channel(GProRecommendV2Channel gProRecommendV2Channel) {
        this.mInfo = gProRecommendV2Channel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public long getBrowseTimeStamp() {
        return this.mInfo.getBrowseTimeStamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public String getCoverUrl() {
        return this.mInfo.getCoverUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public String getGuildIcon() {
        return this.mInfo.getGuildIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public String getGuildProfile() {
        return this.mInfo.getGuildProfile();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public String getJoinGuildSig() {
        return this.mInfo.getJoinGuildSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public int getJoinedGuild() {
        return this.mInfo.getJoinedGuild();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public ArrayList<Object> getLabelList() {
        ArrayList<GProRecommendV2Label> labelList = this.mInfo.getLabelList();
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProRecommendV2Label> it = labelList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendV2Label(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public int getMemberRole() {
        return this.mInfo.getMemberRole();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public long getOwnerUin() {
        return this.mInfo.getOwnerUin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public ArrayList<IGProRecommendGuildState> getStateList() {
        ArrayList<GProRecommendGuildState> stateList = this.mInfo.getStateList();
        ArrayList<IGProRecommendGuildState> arrayList = new ArrayList<>();
        Iterator<GProRecommendGuildState> it = stateList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendGuildState(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public ArrayList<String> getTagList() {
        return this.mInfo.getTagList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public long getUniqueId() {
        return this.mInfo.getUniqueId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Channel
    public String toString() {
        return this.mInfo.toString();
    }
}
