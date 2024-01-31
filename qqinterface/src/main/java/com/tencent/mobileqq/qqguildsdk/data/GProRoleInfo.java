package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProRole;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;


public class GProRoleInfo {
    private final GProRole role;

    public GProRoleInfo(GProRole gProRole) {
        this.role = gProRole;
    }
}
