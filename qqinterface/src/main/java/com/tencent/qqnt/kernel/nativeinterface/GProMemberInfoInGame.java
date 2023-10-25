package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProMemberInfoInGame implements Serializable {
    String backgroundPic;
    int gameIdentity;
    int gameStatus;
    long gameStatusUpdateTimestampMs;
    ArrayList<String> goodHeroIconList;
    int gradeLevel;
    String gradeLevelIcon;
    String heroName;
    String heroPic;
    String honorDesc;
    String honorIcon;
    String identityDesc;
    long joinTimestampMs;
    String nickName;
    String record;
    long roomId;
    String schema;
    long serialVersionUID;
    long tinyId;

    public GProMemberInfoInGame() {
        this.serialVersionUID = 1L;
        this.nickName = "";
        this.heroName = "";
        this.heroPic = "";
        this.record = "";
        this.schema = "";
        this.goodHeroIconList = new ArrayList<>();
        this.honorIcon = "";
        this.honorDesc = "";
        this.identityDesc = "";
        this.backgroundPic = "";
        this.gradeLevelIcon = "";
    }

    public String getBackgroundPic() {
        return this.backgroundPic;
    }

    public int getGameIdentity() {
        return this.gameIdentity;
    }

    public int getGameStatus() {
        return this.gameStatus;
    }

    public long getGameStatusUpdateTimestampMs() {
        return this.gameStatusUpdateTimestampMs;
    }

    public ArrayList<String> getGoodHeroIconList() {
        return this.goodHeroIconList;
    }

    public int getGradeLevel() {
        return this.gradeLevel;
    }

    public String getGradeLevelIcon() {
        return this.gradeLevelIcon;
    }

    public String getHeroName() {
        return this.heroName;
    }

    public String getHeroPic() {
        return this.heroPic;
    }

    public String getHonorDesc() {
        return this.honorDesc;
    }

    public String getHonorIcon() {
        return this.honorIcon;
    }

    public String getIdentityDesc() {
        return this.identityDesc;
    }

    public long getJoinTimestampMs() {
        return this.joinTimestampMs;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getRecord() {
        return this.record;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getSchema() {
        return this.schema;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProMemberInfoInGame{tinyId=" + this.tinyId + ",roomId=" + this.roomId + ",nickName=" + this.nickName + ",heroName=" + this.heroName + ",heroPic=" + this.heroPic + ",gameStatus=" + this.gameStatus + ",record=" + this.record + ",joinTimestampMs=" + this.joinTimestampMs + ",gameIdentity=" + this.gameIdentity + ",gameStatusUpdateTimestampMs=" + this.gameStatusUpdateTimestampMs + ",schema=" + this.schema + ",goodHeroIconList=" + this.goodHeroIconList + ",honorIcon=" + this.honorIcon + ",honorDesc=" + this.honorDesc + ",identityDesc=" + this.identityDesc + ",gradeLevel=" + this.gradeLevel + ",backgroundPic=" + this.backgroundPic + ",gradeLevelIcon=" + this.gradeLevelIcon + ",}";
    }

    public GProMemberInfoInGame(long j2, long j3, String str, String str2, String str3, int i2, String str4, long j4, int i3, long j5, String str5, ArrayList<String> arrayList, String str6, String str7, String str8, int i4, String str9, String str10) {
        this.serialVersionUID = 1L;
        this.nickName = "";
        this.heroName = "";
        this.heroPic = "";
        this.record = "";
        this.schema = "";
        this.goodHeroIconList = new ArrayList<>();
        this.honorIcon = "";
        this.honorDesc = "";
        this.identityDesc = "";
        this.backgroundPic = "";
        this.gradeLevelIcon = "";
        this.tinyId = j2;
        this.roomId = j3;
        this.nickName = str;
        this.heroName = str2;
        this.heroPic = str3;
        this.gameStatus = i2;
        this.record = str4;
        this.joinTimestampMs = j4;
        this.gameIdentity = i3;
        this.gameStatusUpdateTimestampMs = j5;
        this.schema = str5;
        this.goodHeroIconList = arrayList;
        this.honorIcon = str6;
        this.honorDesc = str7;
        this.identityDesc = str8;
        this.gradeLevel = i4;
        this.backgroundPic = str9;
        this.gradeLevelIcon = str10;
    }
}
