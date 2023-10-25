package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProClientPresence implements Serializable {
    String bigIcon;
    int clientId;
    String clientName;
    String details;
    long endTimeStamp;
    long expireTimeStamp;
    long partyMax;
    long partySize;
    String role;
    long serialVersionUID;
    String smallIcon;
    long startTimeStamp;
    String state;

    public GProClientPresence() {
        this.serialVersionUID = 1L;
        this.clientName = "";
        this.bigIcon = "";
        this.state = "";
        this.details = "";
        this.role = "";
        this.smallIcon = "";
    }

    public String getBigIcon() {
        return this.bigIcon;
    }

    public int getClientId() {
        return this.clientId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getDetails() {
        return this.details;
    }

    public long getEndTimeStamp() {
        return this.endTimeStamp;
    }

    public long getExpireTimeStamp() {
        return this.expireTimeStamp;
    }

    public long getPartyMax() {
        return this.partyMax;
    }

    public long getPartySize() {
        return this.partySize;
    }

    public String getRole() {
        return this.role;
    }

    public String getSmallIcon() {
        return this.smallIcon;
    }

    public long getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public String getState() {
        return this.state;
    }

    public String toString() {
        return "GProClientPresence{clientId=" + this.clientId + ",clientName=" + this.clientName + ",bigIcon=" + this.bigIcon + ",state=" + this.state + ",details=" + this.details + ",partySize=" + this.partySize + ",partyMax=" + this.partyMax + ",role=" + this.role + ",startTimeStamp=" + this.startTimeStamp + ",endTimeStamp=" + this.endTimeStamp + ",expireTimeStamp=" + this.expireTimeStamp + ",smallIcon=" + this.smallIcon + ",}";
    }

    public GProClientPresence(int i2, String str, String str2, String str3, String str4, long j2, long j3, String str5, long j4, long j5, long j6, String str6) {
        this.serialVersionUID = 1L;
        this.clientName = "";
        this.bigIcon = "";
        this.state = "";
        this.details = "";
        this.role = "";
        this.smallIcon = "";
        this.clientId = i2;
        this.clientName = str;
        this.bigIcon = str2;
        this.state = str3;
        this.details = str4;
        this.partySize = j2;
        this.partyMax = j3;
        this.role = str5;
        this.startTimeStamp = j4;
        this.endTimeStamp = j5;
        this.expireTimeStamp = j6;
        this.smallIcon = str6;
    }
}
