package com.tencent.qqnt.kernel.nativeinterface;



public final class UinInfoAttr {
    Long uin;

    public UinInfoAttr() {
    }

    public Long getUin() {
        return this.uin;
    }

    public String toString() {
        return "UinInfoAttr{uin=" + this.uin + ",}";
    }

    public UinInfoAttr(Long l2) {
        this.uin = l2;
    }
}
