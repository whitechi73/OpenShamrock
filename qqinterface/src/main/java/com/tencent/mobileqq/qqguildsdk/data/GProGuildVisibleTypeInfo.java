package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProVisibleTypeInfo;

import java.io.Serializable;


public class GProGuildVisibleTypeInfo implements Serializable {
    private final GProVisibleTypeInfo mInfo;

    public GProGuildVisibleTypeInfo(GProVisibleTypeInfo gProVisibleTypeInfo) {
        this.mInfo = gProVisibleTypeInfo;
    }

    public int getVisibleType() {
        return this.mInfo.getVisibleType();
    }

    public String getVisibleTypeText() {
        return this.mInfo.getVisibleTypeText();
    }
}
