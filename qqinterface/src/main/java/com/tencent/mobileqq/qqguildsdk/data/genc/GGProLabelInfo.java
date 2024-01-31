package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildInfoInLabel;
import com.tencent.qqnt.kernel.nativeinterface.GProLabelInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProLabelInfo implements IGProLabelInfo {
    public final GProLabelInfo mInfo;

    public GGProLabelInfo(GProLabelInfo gProLabelInfo) {
        this.mInfo = gProLabelInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLabelInfo
    public String getContent() {
        return this.mInfo.getContent();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLabelInfo
    public String getDetailsAvUrl() {
        return this.mInfo.getDetailsAvUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLabelInfo
    public String getDetailsImageUrl() {
        return this.mInfo.getDetailsImageUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLabelInfo
    public String getFriendJoinNumTag() {
        return this.mInfo.getFriendJoinNumTag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLabelInfo
    public ArrayList<IGProGuildInfoInLabel> getGuildInfos() {
        ArrayList<GProGuildInfoInLabel> guildInfos = this.mInfo.getGuildInfos();
        ArrayList<IGProGuildInfoInLabel> arrayList = new ArrayList<>();
        Iterator<GProGuildInfoInLabel> it = guildInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildInfoInLabel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLabelInfo
    public String getIntroduceAvUrl() {
        return this.mInfo.getIntroduceAvUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLabelInfo
    public String getIntroduceImageUrl() {
        return this.mInfo.getIntroduceImageUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLabelInfo
    public String getLabelTopPicture() {
        return this.mInfo.getLabelTopPicture();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLabelInfo
    public String getLabelTopWord() {
        return this.mInfo.getLabelTopWord();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLabelInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLabelInfo
    public String getSelectedCntTag() {
        return this.mInfo.getSelectedCntTag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLabelInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
