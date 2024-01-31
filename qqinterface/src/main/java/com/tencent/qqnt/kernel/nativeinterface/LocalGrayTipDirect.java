package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;


public  final class LocalGrayTipDirect implements Serializable {
    String robotName;
    long robotTid;
    long robotUin;
    long serialVersionUID;

    public LocalGrayTipDirect() {
        this.serialVersionUID = 1L;
        this.robotName = "";
    }

    public String getRobotName() {
        return this.robotName;
    }

    public long getRobotTid() {
        return this.robotTid;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String toString() {
        return "LocalGrayTipDirect{robotTid=" + this.robotTid + ",robotUin=" + this.robotUin + ",robotName=" + this.robotName + ",}";
    }

    public LocalGrayTipDirect(long j2, long j3, String str) {
        this.serialVersionUID = 1L;
        this.robotName = "";
        this.robotTid = j2;
        this.robotUin = j3;
        this.robotName = str;
    }
}
