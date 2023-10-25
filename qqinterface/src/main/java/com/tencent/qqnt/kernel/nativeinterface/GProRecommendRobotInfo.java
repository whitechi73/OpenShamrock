package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes22.dex */
public final class GProRecommendRobotInfo implements Serializable {
    String avatar;
    String desc;
    ArrayList<String> introduceList;
    String name;
    long robotUin;
    long serialVersionUID;

    public GProRecommendRobotInfo() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.desc = "";
        this.avatar = "";
        this.introduceList = new ArrayList<>();
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getDesc() {
        return this.desc;
    }

    public ArrayList<String> getIntroduceList() {
        return this.introduceList;
    }

    public String getName() {
        return this.name;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String toString() {
        return "GProRecommendRobotInfo{name=" + this.name + ",desc=" + this.desc + ",avatar=" + this.avatar + ",introduceList=" + this.introduceList + ",robotUin=" + this.robotUin + ",}";
    }

    public GProRecommendRobotInfo(String str, String str2, String str3, ArrayList<String> arrayList, long j2) {
        this.serialVersionUID = 1L;
        this.name = "";
        this.desc = "";
        this.avatar = "";
        this.introduceList = new ArrayList<>();
        this.name = str;
        this.desc = str2;
        this.avatar = str3;
        this.introduceList = arrayList;
        this.robotUin = j2;
    }
}
