package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

public interface IKernelGetUinInfoCallback {
    void onResult(HashMap<String, Long> hashMap);
}