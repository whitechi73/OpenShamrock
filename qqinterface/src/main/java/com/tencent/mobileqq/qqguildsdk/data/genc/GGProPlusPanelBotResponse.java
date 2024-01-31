package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProPlusPanelBotFeature;
import com.tencent.qqnt.kernel.nativeinterface.GProPlusPanelBotResponse;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProPlusPanelBotResponse implements IGProPlusPanelBotResponse {
    public final GProPlusPanelBotResponse mInfo;

    public GGProPlusPanelBotResponse(GProPlusPanelBotResponse gProPlusPanelBotResponse) {
        this.mInfo = gProPlusPanelBotResponse;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlusPanelBotResponse
    public int getNextPage() {
        return this.mInfo.getNextPage();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlusPanelBotResponse
    public ArrayList<IGProPlusPanelBotFeature> getPlusPanelFeatures() {
        ArrayList<GProPlusPanelBotFeature> plusPanelFeatures = this.mInfo.getPlusPanelFeatures();
        ArrayList<IGProPlusPanelBotFeature> arrayList = new ArrayList<>();
        Iterator<GProPlusPanelBotFeature> it = plusPanelFeatures.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProPlusPanelBotFeature(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlusPanelBotResponse
    public String toString() {
        return this.mInfo.toString();
    }
}
