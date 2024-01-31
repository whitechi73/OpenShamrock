package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  interface IUnreadCntCallback {
    void onResult(int i2, String str, ArrayList<UnreadCntInfo> arrayList);
}
