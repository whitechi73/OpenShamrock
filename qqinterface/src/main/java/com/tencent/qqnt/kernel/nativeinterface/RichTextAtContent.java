package com.tencent.qqnt.kernel.nativeinterface;


public  final class RichTextAtContent {
    FeedGuildInfo guildInfo;
    RoleGroupInfo roleGroupId;
    ATTYPE type;
    User user;

    public RichTextAtContent() {
        this.type = ATTYPE.values()[0];
    }

    public FeedGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    public RoleGroupInfo getRoleGroupId() {
        return this.roleGroupId;
    }

    public ATTYPE getType() {
        return this.type;
    }

    public User getUser() {
        return this.user;
    }

    public String toString() {
        return "RichTextAtContent{type=" + this.type + ",guildInfo=" + this.guildInfo + ",roleGroupId=" + this.roleGroupId + ",user=" + this.user + ",}";
    }

    public RichTextAtContent(ATTYPE attype, FeedGuildInfo feedGuildInfo, RoleGroupInfo roleGroupInfo, User user) {
        this.type = ATTYPE.values()[0];
        this.type = attype;
        this.guildInfo = feedGuildInfo;
        this.roleGroupId = roleGroupInfo;
        this.user = user;
    }
}
