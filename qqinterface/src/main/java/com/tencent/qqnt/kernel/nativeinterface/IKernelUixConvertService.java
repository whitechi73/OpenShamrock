package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashSet;

public interface IKernelUixConvertService {

    void getUid(HashSet<Long> hashSet, IKernelGetUidInfoCallback iKernelGetUidInfoCallback);

    void getUin(HashSet<String> hashSet, IKernelGetUinInfoCallback iKernelGetUinInfoCallback);
}