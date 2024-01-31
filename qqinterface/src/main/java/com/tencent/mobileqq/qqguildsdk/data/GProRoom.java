package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAudienceInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudienceInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProAudienceInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRoomInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public  class GProRoom implements IGProRoomInfo {
    public final GProRoomInfo mInfo;

    public GProRoom(GProRoomInfo gProRoomInfo) {
        this.mInfo = gProRoomInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo
    public ArrayList<IGProAudienceInfo> getAudienceInfo() {
        ArrayList<GProAudienceInfo> audienceInfos = this.mInfo.getAudienceInfos();
        ArrayList<IGProAudienceInfo> arrayList = new ArrayList<>();
        Iterator<GProAudienceInfo> it = audienceInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProAudienceInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo
    public int getFakeNum() {
        return this.mInfo.getViewerExt().getFakeNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo
    public String getProgramId() {
        return this.mInfo.getProgramId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo
    public int getRealNum() {
        return this.mInfo.getViewerExt().getRealNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo
    public int getRobotNum() {
        return this.mInfo.getViewerExt().getRebotNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo
    public HashMap<String, String> getRoomIcons() {
        return this.mInfo.getRoomIcons();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo
    public long getRoomId() {
        return this.mInfo.getRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo
    public String getRoomName() {
        return this.mInfo.getRoomName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo
    public String getRoomPv() {
        return this.mInfo.getRoomPv();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo
    public int getRoomState() {
        return this.mInfo.getRoomState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo
    public long getViewer() {
        return this.mInfo.getViewer();
    }
}
