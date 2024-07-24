package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.qqnt.kernel.nativeinterface.GProRolePermission;
import com.tencent.qqnt.kernel.nativeinterface.GProRolePermissionCategory;
import com.tencent.qqnt.kernel.nativeinterface.GProRolePermissionDesc;

import java.util.ArrayList;

public interface IGProFetchRolePermissionCallback {
    void onFetchRolePermissionCallback(int code, String msg, GProGuildRole role, GProRolePermission permission, ArrayList<GProRolePermissionDesc> permissionDescs, ArrayList<GProRolePermissionCategory> permissionCategories);
}
