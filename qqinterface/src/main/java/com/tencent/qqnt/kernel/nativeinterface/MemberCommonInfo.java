package com.tencent.qqnt.kernel.nativeinterface;

public class MemberCommonInfo {
    public long memberUin;
    public int privilege;
    public int shutUpTime;
    public int uinFlag;
    public int uinFlagExt;
    public int uinMobileFlag;

    public long getMemberUin() {
        return this.memberUin;
    }

    public int getPrivilege() {
        return this.privilege;
    }

    public int getShutUpTime() {
        return this.shutUpTime;
    }

    public int getUinFlag() {
        return this.uinFlag;
    }

    public int getUinFlagExt() {
        return this.uinFlagExt;
    }

    public int getUinMobileFlag() {
        return this.uinMobileFlag;
    }

    public void setMemberUin(long j2) {
        this.memberUin = j2;
    }

    public void setPrivilege(int i2) {
        this.privilege = i2;
    }

    public void setShutUpTime(int i2) {
        this.shutUpTime = i2;
    }

    public void setUinFlag(int i2) {
        this.uinFlag = i2;
    }

    public void setUinFlagExt(int i2) {
        this.uinFlagExt = i2;
    }

    public void setUinMobileFlag(int i2) {
        this.uinMobileFlag = i2;
    }

    public String toString() {
        return "MemberCommonInfo{memberUin=" + this.memberUin + ",uinFlag=" + this.uinFlag + ",uinFlagExt=" + this.uinFlagExt + ",uinMobileFlag=" + this.uinMobileFlag + ",shutUpTime=" + this.shutUpTime + ",privilege=" + this.privilege + ",}";
    }

}
