package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProSmobaArchiveTemplate {
    String goodBranch;
    ArrayList<String> goodHeroIconList;
    int gradeLevel;
    String mvpNum;
    int starCnt;
    String winNum;
    String winRate;

    public GProSmobaArchiveTemplate() {
        this.winNum = "";
        this.mvpNum = "";
        this.winRate = "";
        this.goodBranch = "";
        this.goodHeroIconList = new ArrayList<>();
    }

    public String getGoodBranch() {
        return this.goodBranch;
    }

    public ArrayList<String> getGoodHeroIconList() {
        return this.goodHeroIconList;
    }

    public int getGradeLevel() {
        return this.gradeLevel;
    }

    public String getMvpNum() {
        return this.mvpNum;
    }

    public int getStarCnt() {
        return this.starCnt;
    }

    public String getWinNum() {
        return this.winNum;
    }

    public String getWinRate() {
        return this.winRate;
    }

    public String toString() {
        return "GProSmobaArchiveTemplate{gradeLevel=" + this.gradeLevel + ",starCnt=" + this.starCnt + ",winNum=" + this.winNum + ",mvpNum=" + this.mvpNum + ",winRate=" + this.winRate + ",goodBranch=" + this.goodBranch + ",goodHeroIconList=" + this.goodHeroIconList + ",}";
    }

    public GProSmobaArchiveTemplate(int i2, int i3, String str, String str2, String str3, String str4, ArrayList<String> arrayList) {
        this.winNum = "";
        this.mvpNum = "";
        this.winRate = "";
        this.goodBranch = "";
        this.goodHeroIconList = new ArrayList<>();
        this.gradeLevel = i2;
        this.starCnt = i3;
        this.winNum = str;
        this.mvpNum = str2;
        this.winRate = str3;
        this.goodBranch = str4;
        this.goodHeroIconList = arrayList;
    }
}
