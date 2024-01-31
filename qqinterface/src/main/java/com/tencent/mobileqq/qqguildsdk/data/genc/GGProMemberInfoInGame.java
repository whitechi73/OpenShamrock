package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProMemberInfoInGame;

import java.util.ArrayList;

public  class GGProMemberInfoInGame implements IGProMemberInfoInGame {
    public final GProMemberInfoInGame mInfo;

    public GGProMemberInfoInGame(GProMemberInfoInGame gProMemberInfoInGame) {
        this.mInfo = gProMemberInfoInGame;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public String getBackgroundPic() {
        return this.mInfo.getBackgroundPic();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public int getGameIdentity() {
        return this.mInfo.getGameIdentity();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public int getGameStatus() {
        return this.mInfo.getGameStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public long getGameStatusUpdateTimestampMs() {
        return this.mInfo.getGameStatusUpdateTimestampMs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public ArrayList<String> getGoodHeroIconList() {
        return this.mInfo.getGoodHeroIconList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public int getGradeLevel() {
        return this.mInfo.getGradeLevel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public String getGradeLevelIcon() {
        return this.mInfo.getGradeLevelIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public String getHeroName() {
        return this.mInfo.getHeroName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public String getHeroPic() {
        return this.mInfo.getHeroPic();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public String getHonorDesc() {
        return this.mInfo.getHonorDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public String getHonorIcon() {
        return this.mInfo.getHonorIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public String getIdentityDesc() {
        return this.mInfo.getIdentityDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public long getJoinTimestampMs() {
        return this.mInfo.getJoinTimestampMs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public String getRecord() {
        return this.mInfo.getRecord();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public long getRoomId() {
        return this.mInfo.getRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public String getSchema() {
        return this.mInfo.getSchema();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame
    public String toString() {
        return this.mInfo.toString();
    }
}
