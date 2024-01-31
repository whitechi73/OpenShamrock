package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProPlayNodeInfo implements Serializable {
    int accessFlag;
    long addTime;
    long addTinyId;
    String addUserAvatarMeta;
    String addUserName;
    ArrayList<String> backgroundColorList;
    long orderNum;
    String playNodeId;
    int playSourceDuration;
    String playSourceId;
    String playSourceName;
    String playSourcePic;
    String playSourceShowName;
    long serialVersionUID;
    String singerList;
    String thirdSourceIcon;
    String thirdSourceId;

    public GProPlayNodeInfo() {
        this.serialVersionUID = 1L;
        this.playSourceId = "";
        this.thirdSourceId = "";
        this.playSourceShowName = "";
        this.playSourceName = "";
        this.singerList = "";
        this.playSourcePic = "";
        this.thirdSourceIcon = "";
        this.playNodeId = "";
        this.backgroundColorList = new ArrayList<>();
        this.addUserName = "";
        this.addUserAvatarMeta = "";
    }

    public int getAccessFlag() {
        return this.accessFlag;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public long getAddTinyId() {
        return this.addTinyId;
    }

    public String getAddUserAvatarMeta() {
        return this.addUserAvatarMeta;
    }

    public String getAddUserName() {
        return this.addUserName;
    }

    public ArrayList<String> getBackgroundColorList() {
        return this.backgroundColorList;
    }

    public long getOrderNum() {
        return this.orderNum;
    }

    public String getPlayNodeId() {
        return this.playNodeId;
    }

    public int getPlaySourceDuration() {
        return this.playSourceDuration;
    }

    public String getPlaySourceId() {
        return this.playSourceId;
    }

    public String getPlaySourceName() {
        return this.playSourceName;
    }

    public String getPlaySourcePic() {
        return this.playSourcePic;
    }

    public String getPlaySourceShowName() {
        return this.playSourceShowName;
    }

    public String getSingerList() {
        return this.singerList;
    }

    public String getThirdSourceIcon() {
        return this.thirdSourceIcon;
    }

    public String getThirdSourceId() {
        return this.thirdSourceId;
    }

    public String toString() {
        return "GProPlayNodeInfo{playSourceId=" + this.playSourceId + ",thirdSourceId=" + this.thirdSourceId + ",playSourceShowName=" + this.playSourceShowName + ",playSourceName=" + this.playSourceName + ",singerList=" + this.singerList + ",playSourceDuration=" + this.playSourceDuration + ",playSourcePic=" + this.playSourcePic + ",thirdSourceIcon=" + this.thirdSourceIcon + ",playNodeId=" + this.playNodeId + ",backgroundColorList=" + this.backgroundColorList + ",accessFlag=" + this.accessFlag + ",addTinyId=" + this.addTinyId + ",addUserName=" + this.addUserName + ",addUserAvatarMeta=" + this.addUserAvatarMeta + ",addTime=" + this.addTime + ",orderNum=" + this.orderNum + ",}";
    }

    public GProPlayNodeInfo(String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8, ArrayList<String> arrayList, int i3, long j2, String str9, String str10, long j3, long j4) {
        this.serialVersionUID = 1L;
        this.playSourceId = "";
        this.thirdSourceId = "";
        this.playSourceShowName = "";
        this.playSourceName = "";
        this.singerList = "";
        this.playSourcePic = "";
        this.thirdSourceIcon = "";
        this.playNodeId = "";
        this.backgroundColorList = new ArrayList<>();
        this.addUserName = "";
        this.addUserAvatarMeta = "";
        this.playSourceId = str;
        this.thirdSourceId = str2;
        this.playSourceShowName = str3;
        this.playSourceName = str4;
        this.singerList = str5;
        this.playSourceDuration = i2;
        this.playSourcePic = str6;
        this.thirdSourceIcon = str7;
        this.playNodeId = str8;
        this.backgroundColorList = arrayList;
        this.accessFlag = i3;
        this.addTinyId = j2;
        this.addUserName = str9;
        this.addUserAvatarMeta = str10;
        this.addTime = j3;
        this.orderNum = j4;
    }
}
