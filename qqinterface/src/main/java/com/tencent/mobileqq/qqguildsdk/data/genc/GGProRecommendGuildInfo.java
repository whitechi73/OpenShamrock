package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProNavigationInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProTextMedalInfo;

import java.util.ArrayList;
import java.util.Iterator;


public class GGProRecommendGuildInfo implements IGProRecommendGuildInfo {
    public final GProRecommendGuildInfo mInfo;

    public GGProRecommendGuildInfo(GProRecommendGuildInfo gProRecommendGuildInfo) {
        this.mInfo = gProRecommendGuildInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public String getCover() {
        return this.mInfo.getCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public String getFace() {
        return this.mInfo.getFace();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public String getFaceAnimationOnIdle() {
        return this.mInfo.getFaceAnimationOnIdle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public String getFaceAnimationOnUpdate() {
        return this.mInfo.getFaceAnimationOnUpdate();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public long getFontColorId() {
        return this.mInfo.getFontColorId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public String getGuildCode() {
        return this.mInfo.getGuildCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public String getIntroduction() {
        return this.mInfo.getIntroduction();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public int getLocationType() {
        return this.mInfo.getLocationType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public ArrayList<IGProNavigationInfo> getNavigationInfoList() {
        ArrayList<GProNavigationInfo> navigationInfoList = this.mInfo.getNavigationInfoList();
        ArrayList<IGProNavigationInfo> arrayList = new ArrayList<>();
        Iterator<GProNavigationInfo> it = navigationInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProNavigationInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public IGProPlayFaceAnimationPolicy getPlayFaceAnimationPolicy() {
        return new GGProPlayFaceAnimationPolicy(this.mInfo.getPlayFaceAnimationPolicy());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public long getSeq() {
        return this.mInfo.getSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public String getSubTitle() {
        return this.mInfo.getSubTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public ArrayList<IGProTextMedalInfo> getTextMedalInfoList() {
        ArrayList<GProTextMedalInfo> textMedalInfoList = this.mInfo.getTextMedalInfoList();
        ArrayList<IGProTextMedalInfo> arrayList = new ArrayList<>();
        Iterator<GProTextMedalInfo> it = textMedalInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProTextMedalInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
