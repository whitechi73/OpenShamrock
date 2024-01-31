package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRetentionChannelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRetentionGuildListRsp;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRetentionGuildListRsp implements IGProRetentionGuildListRsp {
    public final GProRetentionGuildListRsp mInfo;

    public GGProRetentionGuildListRsp(GProRetentionGuildListRsp gProRetentionGuildListRsp) {
        this.mInfo = gProRetentionGuildListRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionGuildListRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionGuildListRsp
    public boolean getIsEnd() {
        return this.mInfo.getIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionGuildListRsp
    public int getNextTs() {
        return this.mInfo.getNextTs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionGuildListRsp
    public ArrayList<IGProRetentionChannelInfo> getRecommendChannels() {
        ArrayList<GProRetentionChannelInfo> recommendChannels = this.mInfo.getRecommendChannels();
        ArrayList<IGProRetentionChannelInfo> arrayList = new ArrayList<>();
        Iterator<GProRetentionChannelInfo> it = recommendChannels.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRetentionChannelInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRetentionGuildListRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
