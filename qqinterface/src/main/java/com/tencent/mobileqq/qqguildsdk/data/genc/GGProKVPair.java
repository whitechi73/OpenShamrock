package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProKVPair;

import java.io.Serializable;

public  class GGProKVPair implements Serializable {
    public final GProKVPair mInfo;

    public GGProKVPair(GProKVPair gProKVPair) {
        this.mInfo = gProKVPair;
    }

    public String getKey() {
        return this.mInfo.getKey();
    }

    public byte[] getValue() {
        return this.mInfo.getValue();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
