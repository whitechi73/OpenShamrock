package com.tencent.qqnt.kernel.nativeinterface;


public  final class InputStatusInfo {
    int chatType;
    int eventType;
    String fromUin;
    long interval;
    long showTime;
    String statusText;
    long timestamp;
    String toUin;

    public InputStatusInfo() {
        this.fromUin = "";
        this.toUin = "";
        this.statusText = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public int getEventType() {
        return this.eventType;
    }

    public String getFromUin() {
        return this.fromUin;
    }

    public long getInterval() {
        return this.interval;
    }

    public long getShowTime() {
        return this.showTime;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getToUin() {
        return this.toUin;
    }

    public String toString() {
        return "InputStatusInfo{chatType=" + this.chatType + ",fromUin=" + this.fromUin + ",toUin=" + this.toUin + ",interval=" + this.interval + ",showTime=" + this.showTime + ",eventType=" + this.eventType + ",statusText=" + this.statusText + ",timestamp=" + this.timestamp + ",}";
    }

    public InputStatusInfo(int i2, String str, String str2, long j2, long j3, int i3, String str3, long j4) {
        this.fromUin = "";
        this.toUin = "";
        this.statusText = "";
        this.chatType = i2;
        this.fromUin = str;
        this.toUin = str2;
        this.interval = j2;
        this.showTime = j3;
        this.eventType = i3;
        this.statusText = str3;
        this.timestamp = j4;
    }
}
