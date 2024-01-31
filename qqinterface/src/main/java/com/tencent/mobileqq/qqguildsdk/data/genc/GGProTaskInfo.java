package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProTaskInfo;


public class GGProTaskInfo implements IGProTaskInfo {
    public final GProTaskInfo mInfo;

    public GGProTaskInfo(GProTaskInfo gProTaskInfo) {
        this.mInfo = gProTaskInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTaskInfo
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTaskInfo
    public String getId() {
        return this.mInfo.getId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTaskInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTaskInfo
    public String getProgressText() {
        return this.mInfo.getProgressText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTaskInfo
    public int getStatus() {
        return this.mInfo.getStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTaskInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
