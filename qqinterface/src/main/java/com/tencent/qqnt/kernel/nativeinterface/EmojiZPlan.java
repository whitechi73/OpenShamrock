package com.tencent.qqnt.kernel.nativeinterface;

public  final class EmojiZPlan {
    int actionId;
    String actionName;
    int actionType;
    String bytesReserveInfo;
    long peerUid;
    int playerNumber;

    public EmojiZPlan() {
        this.actionName = "";
        this.bytesReserveInfo = "";
    }

    public int getActionId() {
        return this.actionId;
    }

    public String getActionName() {
        return this.actionName;
    }

    public int getActionType() {
        return this.actionType;
    }

    public String getBytesReserveInfo() {
        return this.bytesReserveInfo;
    }

    public long getPeerUid() {
        return this.peerUid;
    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public String toString() {
        return "EmojiZPlan{actionId=" + this.actionId + ",actionName=" + this.actionName + ",actionType=" + this.actionType + ",playerNumber=" + this.playerNumber + ",peerUid=" + this.peerUid + ",bytesReserveInfo=" + this.bytesReserveInfo + ",}";
    }

    public EmojiZPlan(int i2, String str, int i3, int i4, long j2, String str2) {
        this.actionName = "";
        this.bytesReserveInfo = "";
        this.actionId = i2;
        this.actionName = str;
        this.actionType = i3;
        this.playerNumber = i4;
        this.peerUid = j2;
        this.bytesReserveInfo = str2;
    }
}
