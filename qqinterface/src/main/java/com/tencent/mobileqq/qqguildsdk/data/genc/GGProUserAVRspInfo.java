package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProSecurityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qqnt.kernel.nativeinterface.GProAVRoomCtrlOptInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProUserAVRspInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProUserAVRspInfo implements IGProUserAVRspInfo {
    public final GProUserAVRspInfo mInfo;

    public GGProUserAVRspInfo(GProUserAVRspInfo gProUserAVRspInfo) {
        this.mInfo = gProUserAVRspInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo
    public IGProAVDevOptInfo getDevOpt() {
        return new GGProAVDevOptInfo(this.mInfo.getDevOpt());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo
    public ArrayList<IGProAVRoomCtrlOptInfo> getRoomDevOpts() {
        ArrayList<GProAVRoomCtrlOptInfo> roomDevOpts = this.mInfo.getRoomDevOpts();
        ArrayList<IGProAVRoomCtrlOptInfo> arrayList = new ArrayList<>();
        Iterator<GProAVRoomCtrlOptInfo> it = roomDevOpts.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProAVRoomCtrlOptInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo
    public IGProSecurityResult getSecResult() {
        return new GProSecurityInfo(this.mInfo.getSecResult());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo
    public String getTipMsg() {
        return this.mInfo.getTipMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo
    public String getTrtcKey() {
        return this.mInfo.getTrtcKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo
    public int getUserState() {
        return this.mInfo.getUserState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
