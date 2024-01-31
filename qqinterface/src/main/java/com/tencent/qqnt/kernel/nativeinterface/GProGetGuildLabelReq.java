package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGetGuildLabelReq {
    String code;

    public GProGetGuildLabelReq() {
        this.code = "";
    }

    public String getCode() {
        return this.code;
    }

    public String toString() {
        return "GProGetGuildLabelReq{code=" + this.code + ",}";
    }

    public GProGetGuildLabelReq(String str) {
        this.code = "";
        this.code = str;
    }
}
