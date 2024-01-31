package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProYLGameTeamInfo {
    long channelId;
    int curMemmberNum;
    String gameAppid;
    String gameEnvVersion;
    String gameExtraData;
    int gameId;
    String gamePath;
    long guildId;
    String icon;
    boolean isPk;
    int modeId;
    long readyExpireTime;
    long teamId;
    int teamStatus;
    int totalMemberNum;

    public GProYLGameTeamInfo() {
        this.icon = "";
        this.gameAppid = "";
        this.gamePath = "";
        this.gameExtraData = "";
        this.gameEnvVersion = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getCurMemmberNum() {
        return this.curMemmberNum;
    }

    public String getGameAppid() {
        return this.gameAppid;
    }

    public String getGameEnvVersion() {
        return this.gameEnvVersion;
    }

    public String getGameExtraData() {
        return this.gameExtraData;
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getGamePath() {
        return this.gamePath;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getIcon() {
        return this.icon;
    }

    public boolean getIsPk() {
        return this.isPk;
    }

    public int getModeId() {
        return this.modeId;
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

    public int getTotalMemberNum() {
        return this.totalMemberNum;
    }

    public String toString() {
        return "GProYLGameTeamInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",teamId=" + this.teamId + ",teamStatus=" + this.teamStatus + ",readyExpireTime=" + this.readyExpireTime + ",icon=" + this.icon + ",totalMemberNum=" + this.totalMemberNum + ",curMemmberNum=" + this.curMemmberNum + ",gameId=" + this.gameId + ",gameAppid=" + this.gameAppid + ",gamePath=" + this.gamePath + ",gameExtraData=" + this.gameExtraData + ",gameEnvVersion=" + this.gameEnvVersion + ",modeId=" + this.modeId + ",isPk=" + this.isPk + ",}";
    }

    public GProYLGameTeamInfo(long j2, long j3, long j4, int i2, long j5, String str, int i3, int i4, int i5, String str2, String str3, String str4, String str5, int i6, boolean z) {
        this.icon = "";
        this.gameAppid = "";
        this.gamePath = "";
        this.gameExtraData = "";
        this.gameEnvVersion = "";
        this.guildId = j2;
        this.channelId = j3;
        this.teamId = j4;
        this.teamStatus = i2;
        this.readyExpireTime = j5;
        this.icon = str;
        this.totalMemberNum = i3;
        this.curMemmberNum = i4;
        this.gameId = i5;
        this.gameAppid = str2;
        this.gamePath = str3;
        this.gameExtraData = str4;
        this.gameEnvVersion = str5;
        this.modeId = i6;
        this.isPk = z;
    }
}
