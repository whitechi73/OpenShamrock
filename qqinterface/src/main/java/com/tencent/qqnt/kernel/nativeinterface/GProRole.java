package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProRole implements Serializable {
    boolean isBind;
    String roleDescribe;
    String roleId;
    String roleName;
    long serialVersionUID;

    public GProRole() {
        this.serialVersionUID = 1L;
        this.roleId = "";
        this.roleName = "";
        this.roleDescribe = "";
    }

    public boolean getIsBind() {
        return this.isBind;
    }

    public String getRoleDescribe() {
        return this.roleDescribe;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public String toString() {
        return "GProRole{roleId=" + this.roleId + ",roleName=" + this.roleName + ",roleDescribe=" + this.roleDescribe + ",isBind=" + this.isBind + ",}";
    }

    public GProRole(String str, String str2, String str3, boolean z) {
        this.serialVersionUID = 1L;
        this.roleId = "";
        this.roleName = "";
        this.roleDescribe = "";
        this.roleId = str;
        this.roleName = str2;
        this.roleDescribe = str3;
        this.isBind = z;
    }
}
