package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProRolePermissionDesc {
    String desc;
    int rootId;
    String title;

    public GProRolePermissionDesc() {
        this.title = "";
        this.desc = "";
    }

    public String getDesc() {
        return this.desc;
    }

    public int getRootId() {
        return this.rootId;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProRolePermissionDesc{rootId=" + this.rootId + ",title=" + this.title + ",desc=" + this.desc + ",}";
    }

    public GProRolePermissionDesc(int i2, String str, String str2) {
        this.title = "";
        this.desc = "";
        this.rootId = i2;
        this.title = str;
        this.desc = str2;
    }
}
