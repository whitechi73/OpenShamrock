package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProLobbyMemberInfo implements Serializable {
    String avatar;
    String nickName;
    boolean playing;
    long serialVersionUID;
    long tinyId;
    long uin;

    public GProLobbyMemberInfo() {
        this.serialVersionUID = 1L;
        this.nickName = "";
        this.avatar = "";
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNickName() {
        return this.nickName;
    }

    public boolean getPlaying() {
        return this.playing;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProLobbyMemberInfo{uin=" + this.uin + ",tinyId=" + this.tinyId + ",nickName=" + this.nickName + ",avatar=" + this.avatar + ",playing=" + this.playing + ",}";
    }

    public GProLobbyMemberInfo(long j2, long j3, String str, String str2, boolean z) {
        this.serialVersionUID = 1L;
        this.nickName = "";
        this.avatar = "";
        this.uin = j2;
        this.tinyId = j3;
        this.nickName = str;
        this.avatar = str2;
        this.playing = z;
    }
}
