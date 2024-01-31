package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProChannelActivity;
import com.tencent.qqnt.kernel.nativeinterface.GProGetChannelActivityRsp;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetChannelActivityRsp implements IGProGetChannelActivityRsp {
    public final GProGetChannelActivityRsp mInfo;

    public GGProGetChannelActivityRsp(GProGetChannelActivityRsp gProGetChannelActivityRsp) {
        this.mInfo = gProGetChannelActivityRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetChannelActivityRsp
    public ArrayList<IGProChannelActivity> getChannelActivities() {
        ArrayList<GProChannelActivity> channelActivities = this.mInfo.getChannelActivities();
        ArrayList<IGProChannelActivity> arrayList = new ArrayList<>();
        Iterator<GProChannelActivity> it = channelActivities.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProChannelActivity(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetChannelActivityRsp
    public int getCloseOption() {
        return this.mInfo.getCloseOption();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetChannelActivityRsp
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetChannelActivityRsp
    public boolean getIsShow() {
        return this.mInfo.getIsShow();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetChannelActivityRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
