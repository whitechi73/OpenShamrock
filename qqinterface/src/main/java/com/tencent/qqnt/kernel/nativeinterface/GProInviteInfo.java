package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProInviteInfo {
    String base64Avatar;
    long chnId;
    long guildId;
    String inviteUrl;
    String joinSig;
    String name;
    String nickName;

    public GProInviteInfo() {
        this.name = "";
        this.base64Avatar = "";
        this.joinSig = "";
        this.nickName = "";
        this.inviteUrl = "";
    }

    public String getBase64Avatar() {
        return this.base64Avatar;
    }

    public long getChnId() {
        return this.chnId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getInviteUrl() {
        return this.inviteUrl;
    }

    public String getJoinSig() {
        return this.joinSig;
    }

    public String getName() {
        return this.name;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String toString() {
        return "GProInviteInfo{guildId=" + this.guildId + ",chnId=" + this.chnId + ",name=" + this.name + ",base64Avatar=" + this.base64Avatar + ",joinSig=" + this.joinSig + ",nickName=" + this.nickName + ",inviteUrl=" + this.inviteUrl + ",}";
    }

    public GProInviteInfo(long j2, long j3, String str, String str2, String str3, String str4, String str5) {
        this.name = "";
        this.base64Avatar = "";
        this.joinSig = "";
        this.nickName = "";
        this.inviteUrl = "";
        this.guildId = j2;
        this.chnId = j3;
        this.name = str;
        this.base64Avatar = str2;
        this.joinSig = str3;
        this.nickName = str4;
        this.inviteUrl = str5;
    }
}
