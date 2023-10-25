package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProGuildSpeakableThreshold implements Serializable {
    boolean guildNeedJoinRole;
    long guildNeedJoinTime;
    boolean guildNeedRealName;
    boolean privateNeedJoinRole;
    long privateNeedJoinTime;
    boolean privateNeedRealName;
    long serialVersionUID = 1;

    public GProGuildSpeakableThreshold() {
    }

    public boolean getGuildNeedJoinRole() {
        return this.guildNeedJoinRole;
    }

    public long getGuildNeedJoinTime() {
        return this.guildNeedJoinTime;
    }

    public boolean getGuildNeedRealName() {
        return this.guildNeedRealName;
    }

    public boolean getPrivateNeedJoinRole() {
        return this.privateNeedJoinRole;
    }

    public long getPrivateNeedJoinTime() {
        return this.privateNeedJoinTime;
    }

    public boolean getPrivateNeedRealName() {
        return this.privateNeedRealName;
    }

    public String toString() {
        return "GProGuildSpeakableThreshold{guildNeedRealName=" + this.guildNeedRealName + ",guildNeedJoinRole=" + this.guildNeedJoinRole + ",guildNeedJoinTime=" + this.guildNeedJoinTime + ",privateNeedRealName=" + this.privateNeedRealName + ",privateNeedJoinRole=" + this.privateNeedJoinRole + ",privateNeedJoinTime=" + this.privateNeedJoinTime + ",}";
    }

    public GProGuildSpeakableThreshold(boolean z, boolean z2, long j2, boolean z3, boolean z4, long j3) {
        this.guildNeedRealName = z;
        this.guildNeedJoinRole = z2;
        this.guildNeedJoinTime = j2;
        this.privateNeedRealName = z3;
        this.privateNeedJoinRole = z4;
        this.privateNeedJoinTime = j3;
    }
}
