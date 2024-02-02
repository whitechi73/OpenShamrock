package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IGProFetchMemberRolesCallback {
    void onFetchMemberRolesCallback(int code, String reason, ArrayList<GProGuildRole> roles);
}
