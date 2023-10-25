package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProAudienceInfo implements Serializable {
    String avatarMeta;
    String icon;
    long serialVersionUID;
    long uin;

    public GProAudienceInfo() {
        this.serialVersionUID = 1L;
        this.icon = "";
        this.avatarMeta = "";
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getIcon() {
        return this.icon;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProAudienceInfo{uin=" + this.uin + ",icon=" + this.icon + ",avatarMeta=" + this.avatarMeta + ",}";
    }

    public GProAudienceInfo(long j2, String str, String str2) {
        this.serialVersionUID = 1L;
        this.icon = "";
        this.avatarMeta = "";
        this.uin = j2;
        this.icon = str;
        this.avatarMeta = str2;
    }
}
