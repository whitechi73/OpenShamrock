package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class SpecificEventTypeInfoInMsgBox {
    int eventTypeInMsgBox;
    ArrayList<MsgBoxNecessaryMsgInfo> msgInfos;

    public SpecificEventTypeInfoInMsgBox() {
        this.msgInfos = new ArrayList<>();
    }

    public int getEventTypeInMsgBox() {
        return this.eventTypeInMsgBox;
    }

    public ArrayList<MsgBoxNecessaryMsgInfo> getMsgInfos() {
        return this.msgInfos;
    }

    public String toString() {
        return "SpecificEventTypeInfoInMsgBox{eventTypeInMsgBox=" + this.eventTypeInMsgBox + ",msgInfos=" + this.msgInfos + ",}";
    }

    public SpecificEventTypeInfoInMsgBox(int i2, ArrayList<MsgBoxNecessaryMsgInfo> arrayList) {
        this.msgInfos = new ArrayList<>();
        this.eventTypeInMsgBox = i2;
        this.msgInfos = arrayList;
    }
}
