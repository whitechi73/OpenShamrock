package com.tencent.qqnt.kernel.nativeinterface;


public  final class KingHonor {
    Integer groupInfoFlagEx4;
    byte[] groupMsgBusiBuf;
    Integer kingHonorLevel;

    public KingHonor() {
    }

    public Integer getGroupInfoFlagEx4() {
        return this.groupInfoFlagEx4;
    }

    public byte[] getGroupMsgBusiBuf() {
        return this.groupMsgBusiBuf;
    }

    public Integer getKingHonorLevel() {
        return this.kingHonorLevel;
    }

    public String toString() {
        return "KingHonor{kingHonorLevel=" + this.kingHonorLevel + ",groupInfoFlagEx4=" + this.groupInfoFlagEx4 + ",groupMsgBusiBuf=" + this.groupMsgBusiBuf + ",}";
    }

    public KingHonor(Integer num, Integer num2, byte[] bArr) {
        this.kingHonorLevel = num;
        this.groupInfoFlagEx4 = num2;
        this.groupMsgBusiBuf = bArr;
    }
}
