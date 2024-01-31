package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProAVMemberGroupListRsp;


public class GGProAVMemberGroupListRsp implements IGProAVMemberGroupListRsp {
    public final GProAVMemberGroupListRsp mInfo;

    public GGProAVMemberGroupListRsp(GProAVMemberGroupListRsp gProAVMemberGroupListRsp) {
        this.mInfo = gProAVMemberGroupListRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVMemberGroupListRsp
    public IGProChannelUserNum getChannelUserNum() {
        return new GGProChannelUserNum(this.mInfo.getChannelUserNum());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVMemberGroupListRsp
    public IGProGroupTypeList getGroupTypeList() {
        return new GGProGroupTypeList(this.mInfo.getGroupTypeList());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVMemberGroupListRsp
    public long getNextReadInterval() {
        return this.mInfo.getNextReadInterval();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVMemberGroupListRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
