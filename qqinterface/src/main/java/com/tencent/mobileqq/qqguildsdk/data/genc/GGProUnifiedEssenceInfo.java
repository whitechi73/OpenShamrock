package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProEssenceChannel;
import com.tencent.qqnt.kernel.nativeinterface.GProUnifiedEssenceInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProUnifiedEssenceInfo implements IGProUnifiedEssenceInfo {
    public final GProUnifiedEssenceInfo mInfo;

    public GGProUnifiedEssenceInfo(GProUnifiedEssenceInfo gProUnifiedEssenceInfo) {
        this.mInfo = gProUnifiedEssenceInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnifiedEssenceInfo
    public ArrayList<IGProEssenceChannel> getChannels() {
        ArrayList<GProEssenceChannel> channels = this.mInfo.getChannels();
        ArrayList<IGProEssenceChannel> arrayList = new ArrayList<>();
        Iterator<GProEssenceChannel> it = channels.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProEssenceChannel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnifiedEssenceInfo
    public String getContent() {
        return this.mInfo.getContent();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnifiedEssenceInfo
    public long getOperatorName() {
        return this.mInfo.getOperatorName().longValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnifiedEssenceInfo
    public int getStatus() {
        return this.mInfo.getStatus().intValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnifiedEssenceInfo
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnifiedEssenceInfo
    public int getType() {
        return this.mInfo.getType().intValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnifiedEssenceInfo
    public long getUniqueId() {
        return this.mInfo.getUniqueId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnifiedEssenceInfo
    public String getVisitorMsg() {
        return this.mInfo.getVisitorMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnifiedEssenceInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
