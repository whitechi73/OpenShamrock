package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProGetInvitationGuildReq implements Serializable {
    int businessType;
    byte[] cookies;
    long serialVersionUID;
    GProBottomTabSourceInfo source;

    public GProGetInvitationGuildReq() {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String toString() {
        return "GProGetInvitationGuildReq{businessType=" + this.businessType + ",cookies=" + this.cookies + ",source=" + this.source + ",}";
    }

    public GProGetInvitationGuildReq(int i2, byte[] bArr, GProBottomTabSourceInfo gProBottomTabSourceInfo) {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        this.businessType = i2;
        this.cookies = bArr;
        this.source = gProBottomTabSourceInfo;
    }
}
