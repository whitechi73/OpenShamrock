package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class Like {
    Integer count;
    Integer hasLikedCount;
    String id;
    String jumpUrl;
    Integer ownerStatus;
    User postUser;
    Integer status;
    ArrayList<User> vecUser;

    public Like() {
        this.id = "";
    }

    public Integer getCount() {
        return this.count;
    }

    public Integer getHasLikedCount() {
        return this.hasLikedCount;
    }

    public String getId() {
        return this.id;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public Integer getOwnerStatus() {
        return this.ownerStatus;
    }

    public User getPostUser() {
        return this.postUser;
    }

    public Integer getStatus() {
        return this.status;
    }

    public ArrayList<User> getVecUser() {
        return this.vecUser;
    }

    public String toString() {
        return "Like{id=" + this.id + ",count=" + this.count + ",status=" + this.status + ",vecUser=" + this.vecUser + ",postUser=" + this.postUser + ",hasLikedCount=" + this.hasLikedCount + ",ownerStatus=" + this.ownerStatus + ",jumpUrl=" + this.jumpUrl + ",}";
    }

    public Like(String str, Integer num, Integer num2, ArrayList<User> arrayList, User user, Integer num3, Integer num4, String str2) {
        this.id = "";
        this.id = str;
        this.count = num;
        this.status = num2;
        this.vecUser = arrayList;
        this.postUser = user;
        this.hasLikedCount = num3;
        this.ownerStatus = num4;
        this.jumpUrl = str2;
    }
}
