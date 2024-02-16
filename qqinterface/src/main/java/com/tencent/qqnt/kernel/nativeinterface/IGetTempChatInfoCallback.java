package com.tencent.qqnt.kernel.nativeinterface;

public interface IGetTempChatInfoCallback {
    void onResult(int code, String msg, TempChatInfo info);
}