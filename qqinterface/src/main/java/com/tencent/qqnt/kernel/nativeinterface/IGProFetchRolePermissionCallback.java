package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IGProFetchRolePermissionCallback {
    void onFetchRolePermissionCallback(int code, String msg, GProGuildRole role, GProRolePermission permission, ArrayList<GProRolePermissionDesc> permissionDescs, ArrayList<GProRolePermissionCategory> permissionCategories);
}
