package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProRoom;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildLiveInfo;

public  class GGProGuildLiveInfo implements IGProGuildLiveInfo {
    public final GProGuildLiveInfo mInfo;

    public GGProGuildLiveInfo(GProGuildLiveInfo gProGuildLiveInfo) {
        this.mInfo = gProGuildLiveInfo;
    }


    @Override
    public ILiveRoomAnchorInfo getAnchorInfo() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLiveInfo
    public String getErrMsg() {
        return this.mInfo.getErrMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLiveInfo
    public int getLiveType() {
        return this.mInfo.getLiveType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLiveInfo
    public int getPlatform() {
        return this.mInfo.getPlatform();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLiveInfo
    public long getQueryId() {
        return this.mInfo.getQueryId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLiveInfo
    public int getQueryIdType() {
        return this.mInfo.getQueryIdType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLiveInfo
    public int getResultCode() {
        return this.mInfo.getResultCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLiveInfo
    public IGProRoomInfo getRoomInfo() {
        return new GProRoom(this.mInfo.getRoomInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLiveInfo
    public IGProLiveStreamInfo getStreamInfo() {
        return new GGProLiveStreamInfo(this.mInfo.getStreamInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLiveInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
