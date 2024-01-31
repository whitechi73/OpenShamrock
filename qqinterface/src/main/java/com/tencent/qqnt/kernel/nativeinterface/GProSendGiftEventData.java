package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProSendGiftEventData implements Serializable {
    long channelId;
    String eventId;
    GProGiftInfo giftInfo;
    long guildId;
    GProUser receiverMember;
    GProUser senderMember;
    long serialVersionUID;

    public GProSendGiftEventData() {
        this.serialVersionUID = 1L;
        this.eventId = "";
        this.senderMember = new GProUser();
        this.receiverMember = new GProUser();
        this.giftInfo = new GProGiftInfo();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getEventId() {
        return this.eventId;
    }

    public GProGiftInfo getGiftInfo() {
        return this.giftInfo;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProUser getReceiverMember() {
        return this.receiverMember;
    }

    public GProUser getSenderMember() {
        return this.senderMember;
    }

    public String toString() {
        return "GProSendGiftEventData{guildId=" + this.guildId + ",channelId=" + this.channelId + ",eventId=" + this.eventId + ",senderMember=" + this.senderMember + ",receiverMember=" + this.receiverMember + ",giftInfo=" + this.giftInfo + ",}";
    }

    public GProSendGiftEventData(long j2, long j3, String str, GProUser gProUser, GProUser gProUser2, GProGiftInfo gProGiftInfo) {
        this.serialVersionUID = 1L;
        this.eventId = "";
        this.senderMember = new GProUser();
        this.receiverMember = new GProUser();
        this.giftInfo = new GProGiftInfo();
        this.guildId = j2;
        this.channelId = j3;
        this.eventId = str;
        this.senderMember = gProUser;
        this.receiverMember = gProUser2;
        this.giftInfo = gProGiftInfo;
    }
}
