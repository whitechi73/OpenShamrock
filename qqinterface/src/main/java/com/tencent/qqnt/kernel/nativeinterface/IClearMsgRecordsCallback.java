package com.tencent.qqnt.kernel.nativeinterface;

public interface IClearMsgRecordsCallback {
    void onResult(int code, String reason, long lastMsgId);
}
