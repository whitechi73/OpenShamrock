package com.tencent.qqnt.kernel.nativeinterface;


public  final class ImportOldDbMsgNotifyInfo {
    int chatType;

    /* renamed from: msg  reason: collision with root package name */
    String f305543msg;
    float progress;
    int result;
    String uid;

    public ImportOldDbMsgNotifyInfo() {
        this.uid = "";
        this.f305543msg = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getMsg() {
        return this.f305543msg;
    }

    public float getProgress() {
        return this.progress;
    }

    public int getResult() {
        return this.result;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "ImportOldDbMsgNotifyInfo{progress=" + this.progress + ",chatType=" + this.chatType + ",uid=" + this.uid + ",result=" + this.result + ",msg=" + this.f305543msg + ",}";
    }

    public ImportOldDbMsgNotifyInfo(float f2, int i2, String str, int i3, String str2) {
        this.uid = "";
        this.f305543msg = "";
        this.progress = f2;
        this.chatType = i2;
        this.uid = str;
        this.result = i3;
        this.f305543msg = str2;
    }
}
