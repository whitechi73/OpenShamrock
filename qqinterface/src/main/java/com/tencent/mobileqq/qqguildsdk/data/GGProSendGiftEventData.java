package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProUser;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser;
import com.tencent.qqnt.kernel.nativeinterface.GProSendGiftEventData;


public class GGProSendGiftEventData implements IGProSendGiftEventData {
    public final GProSendGiftEventData mInfo;

    public GGProSendGiftEventData(GProSendGiftEventData gProSendGiftEventData) {
        this.mInfo = gProSendGiftEventData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData
    public String getEventId() {
        return this.mInfo.getEventId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData
    public IGProGiftInfo getGiftInfo() {
        return new GGProGiftInfo(this.mInfo.getGiftInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData
    public IGProUser getReceiverMember() {
        return new GGProUser(this.mInfo.getReceiverMember());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData
    public IGProUser getSenderMember() {
        return new GGProUser(this.mInfo.getSenderMember());
    }
}
