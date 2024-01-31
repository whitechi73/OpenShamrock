package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProVoiceSmobaGameCaptainUserInfo implements Serializable {
    String avatarMeta;
    String nickName;
    long serialVersionUID;

    public GProVoiceSmobaGameCaptainUserInfo() {
        this.serialVersionUID = 1L;
        this.avatarMeta = "";
        this.nickName = "";
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String toString() {
        return "GProVoiceSmobaGameCaptainUserInfo{avatarMeta=" + this.avatarMeta + ",nickName=" + this.nickName + ",}";
    }

    public GProVoiceSmobaGameCaptainUserInfo(String str, String str2) {
        this.serialVersionUID = 1L;
        this.avatarMeta = "";
        this.nickName = "";
        this.avatarMeta = str;
        this.nickName = str2;
    }
}
