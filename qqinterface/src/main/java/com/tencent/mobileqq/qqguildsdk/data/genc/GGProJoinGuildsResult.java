package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProSecurityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qqnt.kernel.nativeinterface.GProJoinGuildsResult;


public class GGProJoinGuildsResult implements IGProJoinGuildsResult {
    public final GProJoinGuildsResult mInfo;

    public GGProJoinGuildsResult(GProJoinGuildsResult gProJoinGuildsResult) {
        this.mInfo = gProJoinGuildsResult;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildsResult
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildsResult
    public IGProGuildInfo getGuildInfo() {
        return new GProGuildInfo(this.mInfo.getGuildInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildsResult
    public IGProGuildInit getGuildInit() {
        return new GGProGuildInit(this.mInfo.getGuildInit());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildsResult
    public int getIsOpenTab() {
        return this.mInfo.getIsOpenTab();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildsResult
    public int getQqMsgInList() {
        return this.mInfo.getQqMsgInList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildsResult
    public int getResultCode() {
        return this.mInfo.getResultCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildsResult
    public IGProSecurityResult getSecResult() {
        return new GProSecurityInfo(this.mInfo.getSecResult());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildsResult
    public String toString() {
        return this.mInfo.toString();
    }
}
