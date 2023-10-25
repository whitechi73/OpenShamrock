package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public final class CreateGroupGrayElement implements Serializable {
    ArrayList<GrayTipMember> memberInfo;
    long serialVersionUID;

    public CreateGroupGrayElement() {
        this.serialVersionUID = 1L;
        this.memberInfo = new ArrayList<>();
    }

    public ArrayList<GrayTipMember> getMemberInfo() {
        return this.memberInfo;
    }

    public String toString() {
        return "CreateGroupGrayElement{memberInfo=" + this.memberInfo + ",}";
    }

    public CreateGroupGrayElement(ArrayList<GrayTipMember> arrayList) {
        this.serialVersionUID = 1L;
        this.memberInfo = new ArrayList<>();
        this.memberInfo = arrayList;
    }
}