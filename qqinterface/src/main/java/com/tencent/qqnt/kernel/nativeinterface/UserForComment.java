package com.tencent.qqnt.kernel.nativeinterface;



public final class UserForComment {
    String iconUrl;
    String id;
    String nick;

    public UserForComment() {
        this.id = "";
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getNick() {
        return this.nick;
    }

    public String toString() {
        return "UserForComment{id=" + this.id + ",nick=" + this.nick + ",iconUrl=" + this.iconUrl + ",}";
    }

    public UserForComment(String str, String str2, String str3) {
        this.id = "";
        this.id = str;
        this.nick = str2;
        this.iconUrl = str3;
    }
}
