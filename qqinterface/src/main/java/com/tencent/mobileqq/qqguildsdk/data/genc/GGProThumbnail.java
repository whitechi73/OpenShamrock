package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProThumbnail;

public  class GGProThumbnail implements IGProThumbnail {
    public final GProThumbnail mInfo;

    public GGProThumbnail(GProThumbnail gProThumbnail) {
        this.mInfo = gProThumbnail;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProThumbnail
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProThumbnail
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProThumbnail
    public String toString() {
        return this.mInfo.toString();
    }
}
