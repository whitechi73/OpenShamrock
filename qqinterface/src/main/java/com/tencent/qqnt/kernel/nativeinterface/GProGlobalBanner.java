package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProGlobalBanner {
    GProGuildBannerGameDownloadInfo bannerGameDownloadeInfo;
    String bannerId;
    GProGuildBannerBizId bizId;
    byte[] content;
    String guildId;
    long operateTime;
    long operatorTinyId;

    public GProGlobalBanner() {
        this.guildId = "";
        this.bannerId = "";
        this.bizId = new GProGuildBannerBizId();
        this.content = new byte[0];
        this.bannerGameDownloadeInfo = new GProGuildBannerGameDownloadInfo();
    }

    public GProGuildBannerGameDownloadInfo getBannerGameDownloadeInfo() {
        return this.bannerGameDownloadeInfo;
    }

    public String getBannerId() {
        return this.bannerId;
    }

    public GProGuildBannerBizId getBizId() {
        return this.bizId;
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public long getOperateTime() {
        return this.operateTime;
    }

    public long getOperatorTinyId() {
        return this.operatorTinyId;
    }

    public String toString() {
        return "GProGlobalBanner{guildId=" + this.guildId + ",operateTime=" + this.operateTime + ",operatorTinyId=" + this.operatorTinyId + ",bannerId=" + this.bannerId + ",bizId=" + this.bizId + ",content=" + this.content + ",bannerGameDownloadeInfo=" + this.bannerGameDownloadeInfo + ",}";
    }

    public GProGlobalBanner(String str, long j2, long j3, String str2, GProGuildBannerBizId gProGuildBannerBizId, byte[] bArr, GProGuildBannerGameDownloadInfo gProGuildBannerGameDownloadInfo) {
        this.guildId = "";
        this.bannerId = "";
        this.bizId = new GProGuildBannerBizId();
        this.content = new byte[0];
        this.bannerGameDownloadeInfo = new GProGuildBannerGameDownloadInfo();
        this.guildId = str;
        this.operateTime = j2;
        this.operatorTinyId = j3;
        this.bannerId = str2;
        this.bizId = gProGuildBannerBizId;
        this.content = bArr;
        this.bannerGameDownloadeInfo = gProGuildBannerGameDownloadInfo;
    }
}
