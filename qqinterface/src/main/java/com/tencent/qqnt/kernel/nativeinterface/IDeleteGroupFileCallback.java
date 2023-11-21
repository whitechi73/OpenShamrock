package com.tencent.qqnt.kernel.nativeinterface;

public interface IDeleteGroupFileCallback {
    void onResult(int code, String why, DeleteGroupFileResult result);
}