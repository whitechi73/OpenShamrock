package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProAVMemberGroupListRsp implements Serializable {
    GProChannelUserNum channelUserNum;
    GProGroupTypeList groupTypeList;
    long nextReadInterval;
    long serialVersionUID;

    public GProAVMemberGroupListRsp() {
        this.serialVersionUID = 1L;
        this.channelUserNum = new GProChannelUserNum();
        this.groupTypeList = new GProGroupTypeList();
    }

    public GProChannelUserNum getChannelUserNum() {
        return this.channelUserNum;
    }

    public GProGroupTypeList getGroupTypeList() {
        return this.groupTypeList;
    }

    public long getNextReadInterval() {
        return this.nextReadInterval;
    }

    public String toString() {
        return "GProAVMemberGroupListRsp{channelUserNum=" + this.channelUserNum + ",groupTypeList=" + this.groupTypeList + ",nextReadInterval=" + this.nextReadInterval + ",}";
    }

    public GProAVMemberGroupListRsp(GProChannelUserNum gProChannelUserNum, GProGroupTypeList gProGroupTypeList, long j2) {
        this.serialVersionUID = 1L;
        this.channelUserNum = new GProChannelUserNum();
        this.groupTypeList = new GProGroupTypeList();
        this.channelUserNum = gProChannelUserNum;
        this.groupTypeList = gProGroupTypeList;
        this.nextReadInterval = j2;
    }
}
