package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProSearchPermissionOption {
    boolean authorized;
    boolean relatedMember;
    boolean relatedRoleMember;

    public GProSearchPermissionOption() {
    }

    public boolean getAuthorized() {
        return this.authorized;
    }

    public boolean getRelatedMember() {
        return this.relatedMember;
    }

    public boolean getRelatedRoleMember() {
        return this.relatedRoleMember;
    }

    public String toString() {
        return "GProSearchPermissionOption{relatedRoleMember=" + this.relatedRoleMember + ",relatedMember=" + this.relatedMember + ",authorized=" + this.authorized + ",}";
    }

    public GProSearchPermissionOption(boolean z, boolean z2, boolean z3) {
        this.relatedRoleMember = z;
        this.relatedMember = z2;
        this.authorized = z3;
    }
}
