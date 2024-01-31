package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProAudioBotStatusInfo {
    long botId;
    long botTrtcId;
    long botUin;
    long channelId;
    int detailType;
    String detailUrl;
    String statusText;
    int statusType;

    public GProAudioBotStatusInfo() {
        this.statusText = "";
        this.detailUrl = "";
    }

    public long getBotId() {
        return this.botId;
    }

    public long getBotTrtcId() {
        return this.botTrtcId;
    }

    public long getBotUin() {
        return this.botUin;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getDetailType() {
        return this.detailType;
    }

    public String getDetailUrl() {
        return this.detailUrl;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public int getStatusType() {
        return this.statusType;
    }

    public String toString() {
        return "GProAudioBotStatusInfo{channelId=" + this.channelId + ",botId=" + this.botId + ",botUin=" + this.botUin + ",statusType=" + this.statusType + ",statusText=" + this.statusText + ",detailUrl=" + this.detailUrl + ",detailType=" + this.detailType + ",botTrtcId=" + this.botTrtcId + ",}";
    }

    public GProAudioBotStatusInfo(long j2, long j3, long j4, int i2, String str, String str2, int i3, long j5) {
        this.statusText = "";
        this.detailUrl = "";
        this.channelId = j2;
        this.botId = j3;
        this.botUin = j4;
        this.statusType = i2;
        this.statusText = str;
        this.detailUrl = str2;
        this.detailType = i3;
        this.botTrtcId = j5;
    }
}
