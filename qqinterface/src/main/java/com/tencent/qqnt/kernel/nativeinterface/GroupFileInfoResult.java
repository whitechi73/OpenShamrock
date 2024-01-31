package com.tencent.qqnt.kernel.nativeinterface;


public  final class GroupFileInfoResult {
    String clientWording;
    GroupFileInfo fileInfo;
    int retCode;
    String retMsg;

    public GroupFileInfoResult() {
        this.retMsg = "";
        this.clientWording = "";
        this.fileInfo = new GroupFileInfo();
    }

    public String getClientWording() {
        return this.clientWording;
    }

    public GroupFileInfo getFileInfo() {
        return this.fileInfo;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public String toString() {
        return "GroupFileInfoResult{retCode=" + this.retCode + ",retMsg=" + this.retMsg + ",clientWording=" + this.clientWording + ",fileInfo=" + this.fileInfo + ",}";
    }

    public GroupFileInfoResult(int i2, String str, String str2, GroupFileInfo groupFileInfo) {
        this.retMsg = "";
        this.clientWording = "";
        this.fileInfo = new GroupFileInfo();
        this.retCode = i2;
        this.retMsg = str;
        this.clientWording = str2;
        this.fileInfo = groupFileInfo;
    }
}
