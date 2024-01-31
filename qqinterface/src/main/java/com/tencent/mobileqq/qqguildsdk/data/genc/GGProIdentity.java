package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProIdentity;

import java.io.Serializable;

public  class GGProIdentity implements Serializable {
    public final GProIdentity mInfo;

    public GGProIdentity(GProIdentity gProIdentity) {
        this.mInfo = gProIdentity;
    }

    public int getIdentityType() {
        return this.mInfo.getIdentityType();
    }

    public byte[] getPlateData() {
        return this.mInfo.getPlateData();
    }

    public int getType() {
        return this.mInfo.getType();
    }

    public String getValue() {
        return this.mInfo.getValue();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
