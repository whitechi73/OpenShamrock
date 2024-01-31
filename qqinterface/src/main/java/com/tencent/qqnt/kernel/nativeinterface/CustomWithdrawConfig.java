package com.tencent.qqnt.kernel.nativeinterface;


public  final class CustomWithdrawConfig {
    int configVersion;
    long msgBegin;
    long msgEnd;
    long withdrawBegin;
    long withdrawEnd;

    public CustomWithdrawConfig() {
    }

    public int getConfigVersion() {
        return this.configVersion;
    }

    public long getMsgBegin() {
        return this.msgBegin;
    }

    public long getMsgEnd() {
        return this.msgEnd;
    }

    public long getWithdrawBegin() {
        return this.withdrawBegin;
    }

    public long getWithdrawEnd() {
        return this.withdrawEnd;
    }

    public String toString() {
        return "CustomWithdrawConfig{withdrawBegin=" + this.withdrawBegin + ",withdrawEnd=" + this.withdrawEnd + ",msgBegin=" + this.msgBegin + ",msgEnd=" + this.msgEnd + ",configVersion=" + this.configVersion + ",}";
    }

    public CustomWithdrawConfig(long j2, long j3, long j4, long j5, int i2) {
        this.withdrawBegin = j2;
        this.withdrawEnd = j3;
        this.msgBegin = j4;
        this.msgEnd = j5;
        this.configVersion = i2;
    }
}
