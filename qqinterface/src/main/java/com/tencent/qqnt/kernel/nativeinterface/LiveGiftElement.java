package com.tencent.qqnt.kernel.nativeinterface;


public  final class LiveGiftElement {
    int effectLevel;
    String kStrGiftName;
    String kStrReceiverTinyId;
    long kUInt64GiftId;
    long kUInt64GiftNum;
    int materialId;
    LiveGiftMemberInfo receiverMemberInfo;
    int sendType;
    LiveGiftMemberInfo senderMemberInfo;
    String senderTinyId;

    public LiveGiftElement() {
        this.kStrReceiverTinyId = "";
        this.kStrGiftName = "";
        this.senderTinyId = "";
        this.senderMemberInfo = new LiveGiftMemberInfo();
        this.receiverMemberInfo = new LiveGiftMemberInfo();
    }

    public int getEffectLevel() {
        return this.effectLevel;
    }

    public String getKStrGiftName() {
        return this.kStrGiftName;
    }

    public String getKStrReceiverTinyId() {
        return this.kStrReceiverTinyId;
    }

    public long getKUInt64GiftId() {
        return this.kUInt64GiftId;
    }

    public long getKUInt64GiftNum() {
        return this.kUInt64GiftNum;
    }

    public int getMaterialId() {
        return this.materialId;
    }

    public LiveGiftMemberInfo getReceiverMemberInfo() {
        return this.receiverMemberInfo;
    }

    public int getSendType() {
        return this.sendType;
    }

    public LiveGiftMemberInfo getSenderMemberInfo() {
        return this.senderMemberInfo;
    }

    public String getSenderTinyId() {
        return this.senderTinyId;
    }

    public String toString() {
        return "LiveGiftElement{kStrReceiverTinyId=" + this.kStrReceiverTinyId + ",kUInt64GiftNum=" + this.kUInt64GiftNum + ",kUInt64GiftId=" + this.kUInt64GiftId + ",kStrGiftName=" + this.kStrGiftName + ",materialId=" + this.materialId + ",effectLevel=" + this.effectLevel + ",sendType=" + this.sendType + ",senderTinyId=" + this.senderTinyId + ",senderMemberInfo=" + this.senderMemberInfo + ",receiverMemberInfo=" + this.receiverMemberInfo + ",}";
    }

    public LiveGiftElement(String str, long j2, long j3, String str2, int i2, int i3, int i4, String str3, LiveGiftMemberInfo liveGiftMemberInfo, LiveGiftMemberInfo liveGiftMemberInfo2) {
        this.kStrReceiverTinyId = "";
        this.kStrGiftName = "";
        this.senderTinyId = "";
        this.senderMemberInfo = new LiveGiftMemberInfo();
        this.receiverMemberInfo = new LiveGiftMemberInfo();
        this.kStrReceiverTinyId = str;
        this.kUInt64GiftNum = j2;
        this.kUInt64GiftId = j3;
        this.kStrGiftName = str2;
        this.materialId = i2;
        this.effectLevel = i3;
        this.sendType = i4;
        this.senderTinyId = str3;
        this.senderMemberInfo = liveGiftMemberInfo;
        this.receiverMemberInfo = liveGiftMemberInfo2;
    }
}
