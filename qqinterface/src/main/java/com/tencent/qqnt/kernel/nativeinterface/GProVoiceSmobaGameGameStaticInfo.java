package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProVoiceSmobaGameGameStaticInfo implements Serializable {
    String coverUrl;
    String gameMode;
    String gameName;
    ArrayList<String> gradeNames;
    String iconUrl;
    long maxNum;
    long serialVersionUID;

    public GProVoiceSmobaGameGameStaticInfo() {
        this.serialVersionUID = 1L;
        this.gameName = "";
        this.gameMode = "";
        this.iconUrl = "";
        this.coverUrl = "";
        this.gradeNames = new ArrayList<>();
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getGameMode() {
        return this.gameMode;
    }

    public String getGameName() {
        return this.gameName;
    }

    public ArrayList<String> getGradeNames() {
        return this.gradeNames;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public long getMaxNum() {
        return this.maxNum;
    }

    public String toString() {
        return "GProVoiceSmobaGameGameStaticInfo{gameName=" + this.gameName + ",gameMode=" + this.gameMode + ",iconUrl=" + this.iconUrl + ",coverUrl=" + this.coverUrl + ",maxNum=" + this.maxNum + ",gradeNames=" + this.gradeNames + ",}";
    }

    public GProVoiceSmobaGameGameStaticInfo(String str, String str2, String str3, String str4, long j2, ArrayList<String> arrayList) {
        this.serialVersionUID = 1L;
        this.gameName = "";
        this.gameMode = "";
        this.iconUrl = "";
        this.coverUrl = "";
        this.gradeNames = new ArrayList<>();
        this.gameName = str;
        this.gameMode = str2;
        this.iconUrl = str3;
        this.coverUrl = str4;
        this.maxNum = j2;
        this.gradeNames = arrayList;
    }
}
