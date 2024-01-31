package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProPAInstructionInfo;

public  class GGProPAInstructionInfo implements IGProPAInstructionInfo {
    public final GProPAInstructionInfo mInfo;

    public GGProPAInstructionInfo(GProPAInstructionInfo gProPAInstructionInfo) {
        this.mInfo = gProPAInstructionInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAInstructionInfo
    public String getData() {
        return this.mInfo.getData();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAInstructionInfo
    public long getLogoutTime() {
        return this.mInfo.getLogoutTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAInstructionInfo
    public int getLogoutType() {
        return this.mInfo.getLogoutType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAInstructionInfo
    public int getModal() {
        return this.mInfo.getModal();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAInstructionInfo
    public String getMsg() {
        return this.mInfo.getMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAInstructionInfo
    public String getRuleFamily() {
        return this.mInfo.getRuleFamily();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAInstructionInfo
    public String getRuleName() {
        return this.mInfo.getRuleName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAInstructionInfo
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAInstructionInfo
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAInstructionInfo
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAInstructionInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
