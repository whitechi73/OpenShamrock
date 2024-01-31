package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProRoleManagementTag implements Serializable {
    long color;
    long roleId;
    long serialVersionUID;
    String tagName;

    public GProRoleManagementTag() {
        this.serialVersionUID = 1L;
        this.tagName = "";
    }

    public long getColor() {
        return this.color;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public String getTagName() {
        return this.tagName;
    }

    public String toString() {
        return "GProRoleManagementTag{roleId=" + this.roleId + ",tagName=" + this.tagName + ",color=" + this.color + ",}";
    }

    public GProRoleManagementTag(long j2, String str, long j3) {
        this.serialVersionUID = 1L;
        this.tagName = "";
        this.roleId = j2;
        this.tagName = str;
        this.color = j3;
    }
}
