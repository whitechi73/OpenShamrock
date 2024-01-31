package com.tencent.qqnt.kernel.nativeinterface;


public  final class JoinGroupNotifyMsg {
    String joinPrompt;
    int result;
    String securityTransUrl;
    JoinGroupVerifyInfo verifyInfo;

    public JoinGroupNotifyMsg() {
        this.verifyInfo = new JoinGroupVerifyInfo();
        this.joinPrompt = "";
        this.securityTransUrl = "";
    }

    public String getJoinPrompt() {
        return this.joinPrompt;
    }

    public int getResult() {
        return this.result;
    }

    public String getSecurityTransUrl() {
        return this.securityTransUrl;
    }

    public JoinGroupVerifyInfo getVerifyInfo() {
        return this.verifyInfo;
    }

    public String toString() {
        return "JoinGroupNotifyMsg{result=" + this.result + ",verifyInfo=" + this.verifyInfo + ",joinPrompt=" + this.joinPrompt + ",securityTransUrl=" + this.securityTransUrl + ",}";
    }

    public JoinGroupNotifyMsg(int i2, JoinGroupVerifyInfo joinGroupVerifyInfo, String str, String str2) {
        this.verifyInfo = new JoinGroupVerifyInfo();
        this.joinPrompt = "";
        this.securityTransUrl = "";
        this.result = i2;
        this.verifyInfo = joinGroupVerifyInfo;
        this.joinPrompt = str;
        this.securityTransUrl = str2;
    }
}
