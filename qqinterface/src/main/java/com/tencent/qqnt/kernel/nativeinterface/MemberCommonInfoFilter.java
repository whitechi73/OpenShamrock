package com.tencent.qqnt.kernel.nativeinterface;

public class MemberCommonInfoFilter {
    public int memberUin;
    public int privilege;
    public int shutUpTime;
    public int uinFlag;
    public int uinFlagExt;
    public int uinMobileFlag;

    public int getMemberUin() {
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

    public void setMemberUin(int i2) {
        this.memberUin = i2;
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
        return "MemberCommonInfoFilter{memberUin=" + this.memberUin + ",uinFlag=" + this.uinFlag + ",uinFlagExt=" + this.uinFlagExt + ",uinMobileFlag=" + this.uinMobileFlag + ",shutUpTime=" + this.shutUpTime + ",privilege=" + this.privilege + ",}";
    }

}
