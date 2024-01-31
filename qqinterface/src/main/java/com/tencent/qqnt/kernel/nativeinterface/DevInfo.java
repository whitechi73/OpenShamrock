package com.tencent.qqnt.kernel.nativeinterface;


public  final class DevInfo implements IKernelModel {
    int clientType;
    String devUid;
    int instanceId;

    public DevInfo() {
        this.devUid = "";
    }

    public int getClientType() {
        return this.clientType;
    }

    public String getDevUid() {
        return this.devUid;
    }

    public int getInstanceId() {
        return this.instanceId;
    }

    public void setClientType(int i2) {
        this.clientType = i2;
    }

    public void setDevUid(String str) {
        this.devUid = str;
    }

    public void setInstanceId(int i2) {
        this.instanceId = i2;
    }

    public String toString() {
        return "DevInfo{instanceId=" + this.instanceId + ",clientType=" + this.clientType + ",devUid=" + this.devUid + ",}";
    }

    public DevInfo(int i2, int i3, String str) {
        this.devUid = "";
        this.instanceId = i2;
        this.clientType = i3;
        this.devUid = str;
    }
}
