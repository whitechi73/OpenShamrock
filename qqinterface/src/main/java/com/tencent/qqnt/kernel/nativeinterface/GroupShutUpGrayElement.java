package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class GroupShutUpGrayElement implements Serializable {
    GrayTipGroupMember admin;
    long curTime;
    long duration;
    GrayTipGroupMember member;
    long serialVersionUID;

    public GroupShutUpGrayElement() {
        this.serialVersionUID = 1L;
        this.admin = new GrayTipGroupMember();
        this.member = new GrayTipGroupMember();
    }

    public GrayTipGroupMember getAdmin() {
        return this.admin;
    }

    public long getCurTime() {
        return this.curTime;
    }

    public long getDuration() {
        return this.duration;
    }

    public GrayTipGroupMember getMember() {
        return this.member;
    }

    public String toString() {
        return "GroupShutUpGrayElement{curTime=" + this.curTime + ",duration=" + this.duration + ",admin=" + this.admin + ",member=" + this.member + ",}";
    }

    public GroupShutUpGrayElement(long j2, long j3, GrayTipGroupMember grayTipGroupMember, GrayTipGroupMember grayTipGroupMember2) {
        this.serialVersionUID = 1L;
        this.admin = new GrayTipGroupMember();
        this.member = new GrayTipGroupMember();
        this.curTime = j2;
        this.duration = j3;
        this.admin = grayTipGroupMember;
        this.member = grayTipGroupMember2;
    }
}