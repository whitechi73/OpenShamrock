package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetSelectChannelIDRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildInfoInLabel;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetSelectChannelIDRsp implements IGProGetSelectChannelIDRsp {
    public final GProGetSelectChannelIDRsp mInfo;

    public GGProGetSelectChannelIDRsp(GProGetSelectChannelIDRsp gProGetSelectChannelIDRsp) {
        this.mInfo = gProGetSelectChannelIDRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetSelectChannelIDRsp
    public ArrayList<Long> getGuildIds() {
        return this.mInfo.getGuildIds();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetSelectChannelIDRsp
    public ArrayList<IGProGuildInfoInLabel> getGuildInfos() {
        ArrayList<GProGuildInfoInLabel> guildInfos = this.mInfo.getGuildInfos();
        ArrayList<IGProGuildInfoInLabel> arrayList = new ArrayList<>();
        Iterator<GProGuildInfoInLabel> it = guildInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildInfoInLabel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetSelectChannelIDRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
