package com.tencent.qqnt.kernel.nativeinterface;



import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProMedal implements Serializable {
    String desc;
    long endTime;
    long serialVersionUID;
    long startTime;
    String url;

    public GProMedal() {
        this.serialVersionUID = 1L;
        this.url = "";
        this.desc = "";
    }

    public String getDesc() {
        return this.desc;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProMedal{startTime=" + this.startTime + ",endTime=" + this.endTime + ",url = " + this.url + ",desc=" + this.desc + ",}";
    }

    public GProMedal(long j2, long j3, String str, String str2) {
        this.serialVersionUID = 1L;
        this.url = "";
        this.desc = "";
        this.startTime = j2;
        this.endTime = j3;
        this.url = str;
        this.desc = str2;
    }
}
