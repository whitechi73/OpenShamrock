package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProChannelPresenceMemberInfo implements Serializable {
    String bytesAvatarMeta;
    long serialVersionUID;
    long tinyId;

    public GProChannelPresenceMemberInfo() {
        this.serialVersionUID = 1L;
        this.bytesAvatarMeta = "";
    }

    public String getBytesAvatarMeta() {
        return this.bytesAvatarMeta;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProChannelPresenceMemberInfo{tinyId=" + this.tinyId + ",bytesAvatarMeta=" + this.bytesAvatarMeta + ",}";
    }

    public GProChannelPresenceMemberInfo(long j2, String str) {
        this.serialVersionUID = 1L;
        this.bytesAvatarMeta = "";
        this.tinyId = j2;
        this.bytesAvatarMeta = str;
    }
}
