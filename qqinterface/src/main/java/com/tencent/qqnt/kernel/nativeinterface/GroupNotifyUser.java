package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;


public  final class GroupNotifyUser implements Serializable {
    String nickName;
    long serialVersionUID;
    String uid;

    public GroupNotifyUser() {
        this.serialVersionUID = 1L;
        this.uid = "";
        this.nickName = "";
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "GroupNotifyUser{uid=" + this.uid + ",nickName=" + this.nickName + ",}";
    }

    public GroupNotifyUser(String str, String str2) {
        this.serialVersionUID = 1L;
        this.uid = "";
        this.nickName = "";
        this.uid = str;
        this.nickName = str2;
    }
}
