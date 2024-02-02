package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IGProGetUserInfoCallback {
    void onGetUserInfo(int code, String reason, ArrayList<GProUser> userList, ArrayList<Long> tinyIdList);
}
