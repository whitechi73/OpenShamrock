package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IGProGetUserInfoCallback {
    void onGetUserInfo(int i2, String str, ArrayList<GProUser> arrayList, ArrayList<Long> arrayList2);
}
