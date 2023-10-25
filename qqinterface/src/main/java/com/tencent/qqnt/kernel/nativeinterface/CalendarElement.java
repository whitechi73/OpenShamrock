package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class CalendarElement implements Serializable {
    long expireTimeMs;

    /* renamed from: msg  reason: collision with root package name */
    String msg;
    String schema;
    int schemaType;
    long serialVersionUID;
    String summary;

    public CalendarElement() {
        this.serialVersionUID = 1L;
        this.summary = "";
        this.msg = "";
        this.schema = "";
    }

    public long getExpireTimeMs() {
        return this.expireTimeMs;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getSchema() {
        return this.schema;
    }

    public int getSchemaType() {
        return this.schemaType;
    }

    public String getSummary() {
        return this.summary;
    }

    public String toString() {
        return "CalendarElement{summary=" + this.summary + ",msg=" + this.msg + ",expireTimeMs=" + this.expireTimeMs + ",schemaType=" + this.schemaType + ",schema=" + this.schema + ",}";
    }

    public CalendarElement(String str, String str2, long j2, int i2, String str3) {
        this.serialVersionUID = 1L;
        this.summary = str;
        this.msg = str2;
        this.expireTimeMs = j2;
        this.schemaType = i2;
        this.schema = str3;
    }
}
