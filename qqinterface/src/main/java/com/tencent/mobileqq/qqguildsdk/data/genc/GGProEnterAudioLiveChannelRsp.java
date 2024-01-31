package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission;
import com.tencent.qqnt.kernel.nativeinterface.GProEnterAudioLiveChannelRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProStreamInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProUserBarNodePermission;

import java.util.ArrayList;
import java.util.Iterator;


public class GGProEnterAudioLiveChannelRsp implements IGProEnterAudioLiveChannelRsp {
    public final GProEnterAudioLiveChannelRsp mInfo;

    public GGProEnterAudioLiveChannelRsp(GProEnterAudioLiveChannelRsp gProEnterAudioLiveChannelRsp) {
        this.mInfo = gProEnterAudioLiveChannelRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public String getAuthMeta() {
        return this.mInfo.getAuthMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public IGProAVChannelConfig getAvChannelConfig() {
        return new GGProAVChannelConfig(this.mInfo.getAvChannelConfig());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public boolean getEnableStream() {
        return this.mInfo.getEnableStream();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public int getGlobalMutedFlag() {
        return this.mInfo.getGlobalMutedFlag();
    }

    @Override
    public IEnterChannelPermission getLiveChannelPermission() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public long getNoStreamDisconnectTrtcSecond() {
        return this.mInfo.getNoStreamDisconnectTrtcSecond();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public IGProEnterAVChannelPermissionInfo getPermissionInfo() {
        return new GGProEnterAVChannelPermissionInfo(this.mInfo.getPermissionInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public String getPrivateMapKey() {
        return this.mInfo.getPrivateMapKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public String getRoomSessionId() {
        return this.mInfo.getRoomSessionId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public int getSdkAppId() {
        return this.mInfo.getSdkAppId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public String getShowTips() {
        return this.mInfo.getShowTips();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public long getSigExpiresSecond() {
        return this.mInfo.getSigExpiresSecond();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public ArrayList<Object> getStreamInfoList() {
        ArrayList<GProStreamInfo> streamInfoList = this.mInfo.getStreamInfoList();
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProStreamInfo> it = streamInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProStreamInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public String getTrtcUserSign() {
        return this.mInfo.getTrtcUserSign();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public ArrayList<IGProUserBarNodePermission> getUserBarNodePermission() {
        ArrayList<GProUserBarNodePermission> userBarNodePermission = this.mInfo.getUserBarNodePermission();
        ArrayList<IGProUserBarNodePermission> arrayList = new ArrayList<>();
        Iterator<GProUserBarNodePermission> it = userBarNodePermission.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProUserBarNodePermission(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public int getUserTRTC() {
        return this.mInfo.getUserTRTC();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public long getUserTinyId() {
        return this.mInfo.getUserTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
