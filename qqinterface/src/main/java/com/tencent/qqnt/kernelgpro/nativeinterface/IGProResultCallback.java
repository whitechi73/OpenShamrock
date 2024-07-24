package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.qqnt.kernel.nativeinterface.GProSecurityResult;

public interface IGProResultCallback {
    void onResult(int code, String msg, GProSecurityResult result);
}
