package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProAppChnnPreInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProChannelPresenceInfo;

import java.util.ArrayList;
import java.util.Iterator;


public class GGProAppChnnPreInfo implements IGProAppChnnPreInfo {
    public final GProAppChnnPreInfo mInfo;

    public GGProAppChnnPreInfo(GProAppChnnPreInfo gProAppChnnPreInfo) {
        this.mInfo = gProAppChnnPreInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo
    public long getAppid() {
        return this.mInfo.getAppid();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo
    public ArrayList<IGProChannelPresenceInfo> getChnnPreList() {
        ArrayList<GProChannelPresenceInfo> chnnPreList = this.mInfo.getChnnPreList();
        ArrayList<IGProChannelPresenceInfo> arrayList = new ArrayList<>();
        Iterator<GProChannelPresenceInfo> it = chnnPreList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProChannelPresenceInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo
    public String getChnnPreSeq() {
        return this.mInfo.getChnnPreSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo
    public IGProJoinCondition getJoinCondition() {
        return new GGProJoinCondition(this.mInfo.getJoinCondition());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo
    public int getJumpType() {
        return this.mInfo.getJumpType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo
    public String getJumpUrl() {
        return this.mInfo.getJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo
    public int getNextTimeStamp() {
        return this.mInfo.getNextTimeStamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo
    public int getResult() {
        return this.mInfo.getResult();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo
    public String getText() {
        return this.mInfo.getText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
