package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProGuildMemberCountInfo {
    long adminCount;
    String errMsg;
    long guildId;
    boolean isFromServer;
    long maxCount;
    long normalCount;
    int result;
    long robotCount;

    public GProGuildMemberCountInfo() {
        this.errMsg = "";
    }

    public long getAdminCount() {
        return this.adminCount;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getIsFromServer() {
        return this.isFromServer;
    }

    public long getMaxCount() {
        return this.maxCount;
    }

    public long getNormalCount() {
        return this.normalCount;
    }

    public int getResult() {
        return this.result;
    }

    public long getRobotCount() {
        return this.robotCount;
    }

    public String toString() {
        return "GProGuildMemberCountInfo{guildId=" + this.guildId + ",maxCount=" + this.maxCount + ",normalCount=" + this.normalCount + ",adminCount=" + this.adminCount + ",robotCount=" + this.robotCount + ",isFromServer=" + this.isFromServer + ",result=" + this.result + ",errMsg=" + this.errMsg + ",}";
    }

    public GProGuildMemberCountInfo(long j2, long j3, long j4, long j5, long j6, boolean z, int i2, String str) {
        this.errMsg = "";
        this.guildId = j2;
        this.maxCount = j3;
        this.normalCount = j4;
        this.adminCount = j5;
        this.robotCount = j6;
        this.isFromServer = z;
        this.result = i2;
        this.errMsg = str;
    }
}
