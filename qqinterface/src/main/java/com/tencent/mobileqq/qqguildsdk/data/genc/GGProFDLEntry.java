package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProFDLEntry;

import java.io.Serializable;

public  class GGProFDLEntry implements Serializable {
    public final GProFDLEntry mInfo;

    public GGProFDLEntry(GProFDLEntry gProFDLEntry) {
        this.mInfo = gProFDLEntry;
    }

    public String getKey() {
        return this.mInfo.getKey();
    }

    public String getValue() {
        return this.mInfo.getValue();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
