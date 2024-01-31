package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRobotStateInfo;

/* loaded from: classes33.dex */
public class GGProRobotStateInfo implements IGProRobotStateInfo {
    public final GProRobotStateInfo mInfo;

    public GGProRobotStateInfo(GProRobotStateInfo gProRobotStateInfo) {
        this.mInfo = gProRobotStateInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRobotStateInfo
    public long getBotTrtcId() {
        return this.mInfo.getBotTrtcId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRobotStateInfo
    public boolean getNoLoopInfo() {
        return this.mInfo.getNoLoopInfo();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRobotStateInfo
    public int getPlayState() {
        return this.mInfo.getPlayState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRobotStateInfo
    public String getPlayText() {
        return this.mInfo.getPlayText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRobotStateInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
