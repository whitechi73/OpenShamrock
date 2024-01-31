package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProSecurityResult;

import java.io.Serializable;


public class GGProSecurityResult implements Serializable {
    public final GProSecurityResult mInfo;

    public GGProSecurityResult(GProSecurityResult gProSecurityResult) {
        this.mInfo = gProSecurityResult;
    }

    public long getActionCode() {
        return this.mInfo.getActionCode();
    }

    public boolean getIsValidSecResult() {
        return this.mInfo.getIsValidSecResult();
    }

    public String getStrDetail() {
        return this.mInfo.getStrDetail();
    }

    public String getStrPrompt() {
        return this.mInfo.getStrPrompt();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
