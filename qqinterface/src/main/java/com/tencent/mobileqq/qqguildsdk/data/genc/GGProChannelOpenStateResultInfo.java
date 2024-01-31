package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProChannelOpenStateResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProSwitchInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProChannelOpenStateResultInfo implements IGProChannelOpenStateResultInfo {
    public final GProChannelOpenStateResultInfo mInfo;

    public GGProChannelOpenStateResultInfo(GProChannelOpenStateResultInfo gProChannelOpenStateResultInfo) {
        this.mInfo = gProChannelOpenStateResultInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelOpenStateResultInfo
    public boolean getPeakActivityGuildFlag() {
        return this.mInfo.getPeakActivityGuildFlag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelOpenStateResultInfo
    public ArrayList<IGProSwitchInfo> getSwitchInfoList() {
        ArrayList<GProSwitchInfo> switchInfoList = this.mInfo.getSwitchInfoList();
        ArrayList<IGProSwitchInfo> arrayList = new ArrayList<>();
        Iterator<GProSwitchInfo> it = switchInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProSwitchInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelOpenStateResultInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
