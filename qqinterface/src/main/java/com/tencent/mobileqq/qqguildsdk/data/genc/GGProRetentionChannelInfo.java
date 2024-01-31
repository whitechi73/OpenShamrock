package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRetentionChannelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRetentionChannelLabel;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRetentionChannelInfo implements IGProRetentionChannelInfo {
    public final GProRetentionChannelInfo mInfo;

    public GGProRetentionChannelInfo(GProRetentionChannelInfo gProRetentionChannelInfo) {
        this.mInfo = gProRetentionChannelInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionChannelInfo
    public String getGuildCover() {
        return this.mInfo.getGuildCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionChannelInfo
    public String getGuildIcon() {
        return this.mInfo.getGuildIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionChannelInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionChannelInfo
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionChannelInfo
    public String getGuildProfile() {
        return this.mInfo.getGuildProfile();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionChannelInfo
    public String getJoinSig() {
        return this.mInfo.getJoinSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionChannelInfo
    public ArrayList<IGProRetentionChannelLabel> getTagList() {
        ArrayList<GProRetentionChannelLabel> tagList = this.mInfo.getTagList();
        ArrayList<IGProRetentionChannelLabel> arrayList = new ArrayList<>();
        Iterator<GProRetentionChannelLabel> it = tagList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRetentionChannelLabel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionChannelInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
