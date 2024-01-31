package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;



public final class User implements Serializable {
    IconInfo icon;
    String id;
    String nick;
    long serialVersionUID;

    public User() {
        this.serialVersionUID = 1L;
        this.id = "";
    }

    public IconInfo getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.id;
    }

    public String getNick() {
        return this.nick;
    }

    public void setIcon(IconInfo iconInfo) {
        this.icon = iconInfo;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setNick(String str) {
        this.nick = str;
    }

    public String toString() {
        return "User{id=" + this.id + ",icon=" + this.icon + ",nick=" + this.nick + ",}";
    }

    public User(String str, IconInfo iconInfo, String str2) {
        this.serialVersionUID = 1L;
        this.id = "";
        this.id = str;
        this.icon = iconInfo;
        this.nick = str2;
    }
}
