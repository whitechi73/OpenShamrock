package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProProgramInfo;

public  class GGProProgramInfo implements IGProProgramInfo {
    public final GProProgramInfo mInfo;

    public GGProProgramInfo(GProProgramInfo gProProgramInfo) {
        this.mInfo = gProProgramInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProProgramInfo
    public String getAnchorName() {
        return this.mInfo.getAnchorName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProProgramInfo
    public String getLiveTitle() {
        return this.mInfo.getLiveTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProProgramInfo
    public String getProgramId() {
        return this.mInfo.getProgramId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProProgramInfo
    public long getTabId() {
        return this.mInfo.getTabId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProProgramInfo
    public String getThirdPartyLogo() {
        return this.mInfo.getThirdPartyLogo();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProProgramInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
