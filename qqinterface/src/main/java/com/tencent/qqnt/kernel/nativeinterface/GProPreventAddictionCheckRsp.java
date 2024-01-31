package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProPreventAddictionCheckRsp implements Serializable {
    String context;
    String instrTraceId;
    ArrayList<GProPAInstructionInfo> instructions;

    /* renamed from: msg  reason: collision with root package name */
    String f305538msg;
    int ret;
    long serialVersionUID;

    public GProPreventAddictionCheckRsp() {
        this.serialVersionUID = 1L;
        this.f305538msg = "";
        this.context = "";
        this.instrTraceId = "";
        this.instructions = new ArrayList<>();
    }

    public String getContext() {
        return this.context;
    }

    public String getInstrTraceId() {
        return this.instrTraceId;
    }

    public ArrayList<GProPAInstructionInfo> getInstructions() {
        return this.instructions;
    }

    public String getMsg() {
        return this.f305538msg;
    }

    public int getRet() {
        return this.ret;
    }

    public String toString() {
        return "GProPreventAddictionCheckRsp{ret=" + this.ret + ",msg=" + this.f305538msg + ",context=" + this.context + ",instrTraceId=" + this.instrTraceId + ",instructions=" + this.instructions + ",}";
    }

    public GProPreventAddictionCheckRsp(int i2, String str, String str2, String str3, ArrayList<GProPAInstructionInfo> arrayList) {
        this.serialVersionUID = 1L;
        this.f305538msg = "";
        this.context = "";
        this.instrTraceId = "";
        this.instructions = new ArrayList<>();
        this.ret = i2;
        this.f305538msg = str;
        this.context = str2;
        this.instrTraceId = str3;
        this.instructions = arrayList;
    }
}
