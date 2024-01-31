package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProAuthControlStatus;

import java.io.Serializable;

public  class GGProAuthControlStatus implements Serializable {
    public final GProAuthControlStatus mInfo;

    public GGProAuthControlStatus(GProAuthControlStatus gProAuthControlStatus) {
        this.mInfo = gProAuthControlStatus;
    }

    public int getAuthControlKey() {
        return this.mInfo.getAuthControlKey();
    }

    public int getAuthControlValue() {
        return this.mInfo.getAuthControlValue();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
