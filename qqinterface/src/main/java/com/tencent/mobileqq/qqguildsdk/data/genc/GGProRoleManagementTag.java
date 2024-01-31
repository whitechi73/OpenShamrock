package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRoleManagementTag;

public  class GGProRoleManagementTag implements IGProRoleManagementTag {
    public final GProRoleManagementTag mInfo;

    public GGProRoleManagementTag(GProRoleManagementTag gProRoleManagementTag) {
        this.mInfo = gProRoleManagementTag;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag
    public long getColor() {
        return this.mInfo.getColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag
    public long getRoleId() {
        return this.mInfo.getRoleId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag
    public String getTagName() {
        return this.mInfo.getTagName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag
    public String toString() {
        return this.mInfo.toString();
    }
}
