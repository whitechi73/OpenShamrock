package com.tencent.qqnt.kernel.nativeinterface;



import java.io.Serializable;

public  final class GProPAInstructionInfo implements Serializable {
    String data;
    long logoutTime;
    int logoutType;
    int modal;

    /* renamed from: msg  reason: collision with root package name */
    String f305536msg;
    String ruleFamily;
    String ruleName;
    long serialVersionUID;
    String title;
    int type;
    String url;

    public GProPAInstructionInfo() {
        this.serialVersionUID = 1L;
        this.title = "";
        this.f305536msg = "";
        this.url = "";
        this.data = "";
        this.ruleName = "";
        this.ruleFamily = "";
    }

    public String getData() {
        return this.data;
    }

    public long getLogoutTime() {
        return this.logoutTime;
    }

    public int getLogoutType() {
        return this.logoutType;
    }

    public int getModal() {
        return this.modal;
    }

    public String getMsg() {
        return this.f305536msg;
    }

    public String getRuleFamily() {
        return this.ruleFamily;
    }

    public String getRuleName() {
        return this.ruleName;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProPAInstructionInfo{type=" + this.type + ",title=" + this.title + ",msg=" + this.f305536msg + ",url = " + this.url + ",modal=" + this.modal + ",data=" + this.data + ",logoutTime=" + this.logoutTime + ",ruleName=" + this.ruleName + ",ruleFamily=" + this.ruleFamily + ",logoutType=" + this.logoutType + ",}";
    }

    public GProPAInstructionInfo(int i2, String str, String str2, String str3, int i3, String str4, long j2, String str5, String str6, int i4) {
        this.serialVersionUID = 1L;
        this.title = "";
        this.f305536msg = "";
        this.url = "";
        this.data = "";
        this.ruleName = "";
        this.ruleFamily = "";
        this.type = i2;
        this.title = str;
        this.f305536msg = str2;
        this.url = str3;
        this.modal = i3;
        this.data = str4;
        this.logoutTime = j2;
        this.ruleName = str5;
        this.ruleFamily = str6;
        this.logoutType = i4;
    }
}
