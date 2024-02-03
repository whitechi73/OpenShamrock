package com.tencent.qqnt.kernel.nativeinterface;

public interface IGProCreateRoleCallback {
    void onCreateRoleResult(int code, String msg, GProSecurityResult result, GProGuildRole role);
}