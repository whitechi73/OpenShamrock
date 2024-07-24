package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildRole;

import java.util.ArrayList;

public interface IGProFetchChannelLiveableRoleListCallback {
    void onFetchChannelLiveableRoleList(int code, String reason, int seq, ArrayList<GProGuildRole> roles);
}