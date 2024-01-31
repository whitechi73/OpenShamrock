package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetInvitationGuildRsp;

public  class GGProGetInvitationGuildRsp implements IGProGetInvitationGuildRsp {
    public final GProGetInvitationGuildRsp mInfo;

    public GGProGetInvitationGuildRsp(GProGetInvitationGuildRsp gProGetInvitationGuildRsp) {
        this.mInfo = gProGetInvitationGuildRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetInvitationGuildRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetInvitationGuildRsp
    public IGProRecommendItem getItem() {
        return new GGProRecommendItem(this.mInfo.getItem());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetInvitationGuildRsp
    public int getNextTs() {
        return this.mInfo.getNextTs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetInvitationGuildRsp
    public String getTraceId() {
        return this.mInfo.getTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetInvitationGuildRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
