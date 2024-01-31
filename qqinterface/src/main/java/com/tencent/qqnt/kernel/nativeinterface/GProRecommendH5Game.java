package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProRecommendH5Game {
    GProRecommendGameInfo game;
    ArrayList<GProRecommendMsg> members;
    long readyExpireTime;
    long teamId;
    int teamStatus;

    public GProRecommendH5Game() {
        this.game = new GProRecommendGameInfo();
        this.members = new ArrayList<>();
    }

    public GProRecommendGameInfo getGame() {
        return this.game;
    }

    public ArrayList<GProRecommendMsg> getMembers() {
        return this.members;
    }

    public long getReadyExpireTime() {
        return this.readyExpireTime;
    }

    public long getTeamId() {
        return this.teamId;
    }

    public int getTeamStatus() {
        return this.teamStatus;
    }

    public String toString() {
        return "GProRecommendH5Game{teamId=" + this.teamId + ",teamStatus=" + this.teamStatus + ",game=" + this.game + ",members=" + this.members + ",readyExpireTime=" + this.readyExpireTime + ",}";
    }

    public GProRecommendH5Game(long j2, int i2, GProRecommendGameInfo gProRecommendGameInfo, ArrayList<GProRecommendMsg> arrayList, long j3) {
        this.game = new GProRecommendGameInfo();
        this.members = new ArrayList<>();
        this.teamId = j2;
        this.teamStatus = i2;
        this.game = gProRecommendGameInfo;
        this.members = arrayList;
        this.readyExpireTime = j3;
    }
}
