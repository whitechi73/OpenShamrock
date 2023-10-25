package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

public interface IKernelGetUidInfoCallback {
    void onResult(HashMap<Long, String> hashMap);
}