package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildRole;

import java.util.ArrayList;

public interface IGProFetchChannelInvisibleRoleListCallback {
    void onFetchChannelInvisibleRoleList(int code, String reason, ArrayList<GProGuildRole> roles);
}