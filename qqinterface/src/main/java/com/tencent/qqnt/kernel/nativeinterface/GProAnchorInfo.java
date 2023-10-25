package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProAnchorInfo implements Serializable {
    String anchorIcon;
    String anchorName;
    String avatarMeta;
    long idVerifyTimestamp;
    long serialVersionUID;
    long tinyId;

    public GProAnchorInfo() {
        this.serialVersionUID = 1L;
        this.anchorName = "";
        this.anchorIcon = "";
        this.avatarMeta = "";
    }

    public String getAnchorIcon() {
        return this.anchorIcon;
    }

    public String getAnchorName() {
        return this.anchorName;
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public long getIdVerifyTimestamp() {
        return this.idVerifyTimestamp;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProAnchorInfo{anchorName=" + this.anchorName + ",anchorIcon=" + this.anchorIcon + ",idVerifyTimestamp=" + this.idVerifyTimestamp + ",tinyId=" + this.tinyId + ",avatarMeta=" + this.avatarMeta + ",}";
    }

    public GProAnchorInfo(String str, String str2, long j2, long j3, String str3) {
        this.serialVersionUID = 1L;
        this.anchorName = "";
        this.anchorIcon = "";
        this.avatarMeta = "";
        this.anchorName = str;
        this.anchorIcon = str2;
        this.idVerifyTimestamp = j2;
        this.tinyId = j3;
        this.avatarMeta = str3;
    }
}
