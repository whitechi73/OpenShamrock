package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSecurityResult;
import com.tencent.qqnt.kernel.nativeinterface.GProSecurityResult;

import java.io.Serializable;


public class GProSecurityInfo extends GGProSecurityResult implements IGProSecurityResult, Serializable {
    private final GProSecurityResult result;

    public GProSecurityInfo(GProSecurityResult gProSecurityResult) {
        super(gProSecurityResult);
        this.result = gProSecurityResult;
    }

    public static GProSecurityInfo createDefault() {
        return new GProSecurityInfo(new GProSecurityResult(true, 0L, "", ""));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProSecurityResult, com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
    public long getActionCode() {
        return this.result.getActionCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProSecurityResult, com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
    public String getStrDetail() {
        return this.result.getStrDetail();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProSecurityResult, com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
    public String getStrPrompt() {
        return this.result.getStrPrompt();
    }

    public boolean isValid() {
        return this.result.getIsValidSecResult();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProSecurityResult
    @NonNull
    public String toString() {
        return "{code=" + getActionCode() + ", prompt=" + getStrPrompt() + ", detail=" + getStrDetail() + "}";
    }
}
