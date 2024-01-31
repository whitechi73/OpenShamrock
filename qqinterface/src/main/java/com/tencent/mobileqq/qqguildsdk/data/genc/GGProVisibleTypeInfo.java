package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProVisibleTypeInfo;

import java.io.Serializable;

public  class GGProVisibleTypeInfo implements Serializable {
    public final GProVisibleTypeInfo mInfo;

    public GGProVisibleTypeInfo(GProVisibleTypeInfo gProVisibleTypeInfo) {
        this.mInfo = gProVisibleTypeInfo;
    }

    public int getVisibleType() {
        return this.mInfo.getVisibleType();
    }

    public String getVisibleTypeText() {
        return this.mInfo.getVisibleTypeText();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
