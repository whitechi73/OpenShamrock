package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IOperateTransferInfoCallback {
    void onResult(int i2, String str, ArrayList<Long> arrayList);
}