package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProAVShowMsgInfo implements Serializable {
    ArrayList<String> buttonMsgs;
    long serialVersionUID;
    String showMsg;
    int showSeconds;
    int showType;

    public GProAVShowMsgInfo() {
        this.serialVersionUID = 1L;
        this.showMsg = "";
        this.buttonMsgs = new ArrayList<>();
    }

    public ArrayList<String> getButtonMsgs() {
        return this.buttonMsgs;
    }

    public String getShowMsg() {
        return this.showMsg;
    }

    public int getShowSeconds() {
        return this.showSeconds;
    }

    public int getShowType() {
        return this.showType;
    }

    public String toString() {
        return "GProAVShowMsgInfo{showType=" + this.showType + ",showMsg=" + this.showMsg + ",showSeconds=" + this.showSeconds + ",buttonMsgs=" + this.buttonMsgs + ",}";
    }

    public GProAVShowMsgInfo(int i2, String str, int i3, ArrayList<String> arrayList) {
        this.serialVersionUID = 1L;
        this.showMsg = "";
        this.buttonMsgs = new ArrayList<>();
        this.showType = i2;
        this.showMsg = str;
        this.showSeconds = i3;
        this.buttonMsgs = arrayList;
    }
}
