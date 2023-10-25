package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProStickyTextChannel implements Serializable {
    String activeMemberCount;
    ArrayList<GProUser> activeMemberList;
    ArrayList<MsgAbstract> msgAbstracts;
    ArrayList<GProMsgSummary> msgList;
    long serialVersionUID;

    public GProStickyTextChannel() {
        this.serialVersionUID = 1L;
        this.activeMemberCount = "";
        this.msgList = new ArrayList<>();
        this.msgAbstracts = new ArrayList<>();
        this.activeMemberList = new ArrayList<>();
    }

    public String getActiveMemberCount() {
        return this.activeMemberCount;
    }

    public ArrayList<GProUser> getActiveMemberList() {
        return this.activeMemberList;
    }

    public ArrayList<MsgAbstract> getMsgAbstracts() {
        return this.msgAbstracts;
    }

    public ArrayList<GProMsgSummary> getMsgList() {
        return this.msgList;
    }

    public String toString() {
        return "GProStickyTextChannel{activeMemberCount=" + this.activeMemberCount + ",msgList=" + this.msgList + ",msgAbstracts=" + this.msgAbstracts + ",activeMemberList=" + this.activeMemberList + ",}";
    }

    public GProStickyTextChannel(String str, ArrayList<GProMsgSummary> arrayList, ArrayList<MsgAbstract> arrayList2, ArrayList<GProUser> arrayList3) {
        this.serialVersionUID = 1L;
        this.activeMemberCount = "";
        this.msgList = new ArrayList<>();
        this.msgAbstracts = new ArrayList<>();
        this.activeMemberList = new ArrayList<>();
        this.activeMemberCount = str;
        this.msgList = arrayList;
        this.msgAbstracts = arrayList2;
        this.activeMemberList = arrayList3;
    }
}
