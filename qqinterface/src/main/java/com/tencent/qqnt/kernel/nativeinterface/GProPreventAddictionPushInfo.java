package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProPreventAddictionPushInfo implements Serializable {
    long closeMask;
    long duration;
    String instrTraceId;
    ArrayList<GProPAInstructionInfo> instructions;

    /* renamed from: msg  reason: collision with root package name */
    String f305539msg;
    int ret;
    long serialVersionUID;
    long uin;

    public GProPreventAddictionPushInfo() {
        this.serialVersionUID = 1L;
        this.f305539msg = "";
        this.instructions = new ArrayList<>();
        this.instrTraceId = "";
    }

    public long getCloseMask() {
        return this.closeMask;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getInstrTraceId() {
        return this.instrTraceId;
    }

    public ArrayList<GProPAInstructionInfo> getInstructions() {
        return this.instructions;
    }

    public String getMsg() {
        return this.f305539msg;
    }

    public int getRet() {
        return this.ret;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProPreventAddictionPushInfo{uin=" + this.uin + ",ret=" + this.ret + ",msg=" + this.f305539msg + ",instructions=" + this.instructions + ",duration=" + this.duration + ",instrTraceId=" + this.instrTraceId + ",closeMask=" + this.closeMask + ",}";
    }

    public GProPreventAddictionPushInfo(long j2, int i2, String str, ArrayList<GProPAInstructionInfo> arrayList, long j3, String str2, long j4) {
        this.serialVersionUID = 1L;
        this.f305539msg = "";
        this.instructions = new ArrayList<>();
        this.instrTraceId = "";
        this.uin = j2;
        this.ret = i2;
        this.f305539msg = str;
        this.instructions = arrayList;
        this.duration = j3;
        this.instrTraceId = str2;
        this.closeMask = j4;
    }
}
