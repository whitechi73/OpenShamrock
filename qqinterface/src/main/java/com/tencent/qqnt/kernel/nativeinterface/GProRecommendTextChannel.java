package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProRecommendTextChannel implements Serializable {
    ArrayList<String> avatars;
    boolean isActive;
    ArrayList<String> memberAvatars;
    ArrayList<MsgAbstract> msgAbstracts;
    String msgSummary;
    int noreadNum;
    long serialVersionUID;
    String tagMsg;

    public GProRecommendTextChannel() {
        this.serialVersionUID = 1L;
        this.msgAbstracts = new ArrayList<>();
        this.avatars = new ArrayList<>();
        this.tagMsg = "";
        this.msgSummary = "";
        this.memberAvatars = new ArrayList<>();
    }

    public ArrayList<String> getAvatars() {
        return this.avatars;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public ArrayList<String> getMemberAvatars() {
        return this.memberAvatars;
    }

    public ArrayList<MsgAbstract> getMsgAbstracts() {
        return this.msgAbstracts;
    }

    public String getMsgSummary() {
        return this.msgSummary;
    }

    public int getNoreadNum() {
        return this.noreadNum;
    }

    public String getTagMsg() {
        return this.tagMsg;
    }

    public String toString() {
        return "GProRecommendTextChannel{msgAbstracts=" + this.msgAbstracts + ",avatars=" + this.avatars + ",noreadNum=" + this.noreadNum + ",isActive=" + this.isActive + ",tagMsg=" + this.tagMsg + ",msgSummary=" + this.msgSummary + ",memberAvatars=" + this.memberAvatars + ",}";
    }

    public GProRecommendTextChannel(ArrayList<MsgAbstract> arrayList, ArrayList<String> arrayList2, int i2, boolean z, String str, String str2, ArrayList<String> arrayList3) {
        this.serialVersionUID = 1L;
        this.msgAbstracts = new ArrayList<>();
        this.avatars = new ArrayList<>();
        this.tagMsg = "";
        this.msgSummary = "";
        this.memberAvatars = new ArrayList<>();
        this.msgAbstracts = arrayList;
        this.avatars = arrayList2;
        this.noreadNum = i2;
        this.isActive = z;
        this.tagMsg = str;
        this.msgSummary = str2;
        this.memberAvatars = arrayList3;
    }
}
