package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IGProFetchChannelLiveableRoleListCallback {
    void onFetchChannelLiveableRoleList(int code, String reason, int seq, ArrayList<GProGuildRole> roles);
}