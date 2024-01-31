package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBriefAppInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGetGuildBindingInfoRsp;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetGuildBindingInfoRsp implements IGProGetGuildBindingInfoRsp {
    public final GProGetGuildBindingInfoRsp mInfo;

    public GGProGetGuildBindingInfoRsp(GProGetGuildBindingInfoRsp gProGetGuildBindingInfoRsp) {
        this.mInfo = gProGetGuildBindingInfoRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildBindingInfoRsp
    public ArrayList<IGProBriefAppInfo> getBindableApps() {
        ArrayList<GProBriefAppInfo> bindableApps = this.mInfo.getBindableApps();
        ArrayList<IGProBriefAppInfo> arrayList = new ArrayList<>();
        Iterator<GProBriefAppInfo> it = bindableApps.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBriefAppInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildBindingInfoRsp
    public ArrayList<IGProBriefAppInfo> getBoundApps() {
        ArrayList<GProBriefAppInfo> boundApps = this.mInfo.getBoundApps();
        ArrayList<IGProBriefAppInfo> arrayList = new ArrayList<>();
        Iterator<GProBriefAppInfo> it = boundApps.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBriefAppInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildBindingInfoRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
