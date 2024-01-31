package com.tencent.qqnt.kernel.nativeinterface;


public  final class TempChatServiceAssistantSession {
    long appId;
    int appType;
    String appTypeName;

    public TempChatServiceAssistantSession() {
        this.appTypeName = "";
    }

    public long getAppId() {
        return this.appId;
    }

    public int getAppType() {
        return this.appType;
    }

    public String getAppTypeName() {
        return this.appTypeName;
    }

    public String toString() {
        return "TempChatServiceAssistantSession{appType=" + this.appType + ",appId=" + this.appId + ",appTypeName=" + this.appTypeName + ",}";
    }

    public TempChatServiceAssistantSession(int i2, long j2, String str) {
        this.appTypeName = "";
        this.appType = i2;
        this.appId = j2;
        this.appTypeName = str;
    }
}
