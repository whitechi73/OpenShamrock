package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.qqnt.kernel.nativeinterface.GProSecurityResult;

public interface IGProCreateRoleCallback {
    void onCreateRoleResult(int code, String msg, GProSecurityResult result, GProGuildRole role);
}