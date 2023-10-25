package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class GrayTipGroupMember implements Serializable {
    String card;
    String name;
    MemberRole role;
    long serialVersionUID;
    String uid;

    public GrayTipGroupMember() {
        this.serialVersionUID = 1L;
        this.uid = "";
        this.card = "";
        this.name = "";
        this.role = MemberRole.values()[0];
    }

    public String getCard() {
        return this.card;
    }

    public String getName() {
        return this.name;
    }

    public MemberRole getRole() {
        return this.role;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "GrayTipGroupMember{uid=" + this.uid + ",card=" + this.card + ",name=" + this.name + ",role=" + this.role + ",}";
    }

    public GrayTipGroupMember(String str, String str2, String str3, MemberRole memberRole) {
        this.serialVersionUID = 1L;
        this.uid = "";
        this.card = "";
        this.name = "";
        this.role = MemberRole.values()[0];
        this.uid = str;
        this.card = str2;
        this.name = str3;
        this.role = memberRole;
    }
}