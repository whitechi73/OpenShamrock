package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildOnlineReportRsp;

public  class GGProGuildOnlineReportRsp implements IGProGuildOnlineReportRsp {
    public final GProGuildOnlineReportRsp mInfo;

    public GGProGuildOnlineReportRsp(GProGuildOnlineReportRsp gProGuildOnlineReportRsp) {
        this.mInfo = gProGuildOnlineReportRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineReportRsp
    public long getNextReportInterval() {
        return this.mInfo.getNextReportInterval();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineReportRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
