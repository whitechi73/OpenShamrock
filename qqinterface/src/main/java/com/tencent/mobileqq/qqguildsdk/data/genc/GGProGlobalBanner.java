package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProGuildBannerGameDownload;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildGameDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGlobalBanner;


public class GGProGlobalBanner implements IGProGlobalBanner {
    public final GProGlobalBanner mInfo;

    public GGProGlobalBanner(GProGlobalBanner gProGlobalBanner) {
        this.mInfo = gProGlobalBanner;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner
    public IGProGuildGameDownloadInfo getBannerGameDownloadeInfo() {
        return new GProGuildBannerGameDownload(this.mInfo.getBannerGameDownloadeInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner
    public String getBannerId() {
        return this.mInfo.getBannerId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner
    public IGProGuildBannerBizId getBizId() {
        return new GGProGuildBannerBizId(this.mInfo.getBizId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner
    public byte[] getContent() {
        return this.mInfo.getContent();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner
    public String getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner
    public long getOperateTime() {
        return this.mInfo.getOperateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner
    public long getOperatorTinyId() {
        return this.mInfo.getOperatorTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner
    public String toString() {
        return this.mInfo.toString();
    }
}
