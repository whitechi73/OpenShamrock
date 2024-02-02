package com.tencent.qqnt.kernel.nativeinterface;

public interface IGProResultCallback {
    void onResult(int code, String msg, GProSecurityResult result);
}
