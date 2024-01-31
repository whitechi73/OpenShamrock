package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildEssenceSvrRsp;

public  class GGProGuildEssenceSvrRsp implements IGProGuildEssenceSvrRsp {
    public final GProGuildEssenceSvrRsp mInfo;

    public GGProGuildEssenceSvrRsp(GProGuildEssenceSvrRsp gProGuildEssenceSvrRsp) {
        this.mInfo = gProGuildEssenceSvrRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildEssenceSvrRsp
    public int getCanModify() {
        return this.mInfo.getCanModify();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildEssenceSvrRsp
    public String getTips() {
        return this.mInfo.getTips();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildEssenceSvrRsp
    public IGProUnifiedEssenceInfo getUnifiedEssenceInfo() {
        return new GGProUnifiedEssenceInfo(this.mInfo.getUnifiedEssenceInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildEssenceSvrRsp
    public int getVisitorEdit() {
        return this.mInfo.getVisitorEdit();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildEssenceSvrRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
