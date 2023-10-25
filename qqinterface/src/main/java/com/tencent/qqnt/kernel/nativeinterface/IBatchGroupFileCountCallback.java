package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IBatchGroupFileCountCallback {
    void onResult(int i2, String str, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2);
}