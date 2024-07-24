package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

public interface IGProFetchRoleListPermissionCallback {
    void onFetchRoleListPermissionCallback(int code, String msg, ArrayList<GProGuildRole> roles, ArrayList<GProGuildRole> lvRoles, ArrayList<Long> myRoles, long unused);
}
