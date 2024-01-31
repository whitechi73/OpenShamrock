package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetGuildLabelRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProLabelInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetGuildLabelRsp implements IGProGetGuildLabelRsp {
    public final GProGetGuildLabelRsp mInfo;

    public GGProGetGuildLabelRsp(GProGetGuildLabelRsp gProGetGuildLabelRsp) {
        this.mInfo = gProGetGuildLabelRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildLabelRsp
    public ArrayList<IGProLabelInfo> getLabelInfos() {
        ArrayList<GProLabelInfo> labelInfos = this.mInfo.getLabelInfos();
        ArrayList<IGProLabelInfo> arrayList = new ArrayList<>();
        Iterator<GProLabelInfo> it = labelInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProLabelInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildLabelRsp
    public long getMaxAvNums() {
        return this.mInfo.getMaxAvNums();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildLabelRsp
    public long getMaxLabels() {
        return this.mInfo.getMaxLabels();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildLabelRsp
    public String getWelcomeContent() {
        return this.mInfo.getWelcomeContent();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildLabelRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
