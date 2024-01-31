package com.tencent.qqnt.kernel.nativeinterface;


public  final class LongMsgAttr {
    Integer fetchLongMsgErrCode;

    public LongMsgAttr() {
    }

    public Integer getFetchLongMsgErrCode() {
        return this.fetchLongMsgErrCode;
    }

    public String toString() {
        return "LongMsgAttr{fetchLongMsgErrCode=" + this.fetchLongMsgErrCode + ",}";
    }

    public LongMsgAttr(Integer num) {
        this.fetchLongMsgErrCode = num;
    }
}
