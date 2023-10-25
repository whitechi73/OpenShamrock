package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProSecurityResult implements Serializable {
    long actionCode;
    boolean isValidSecResult;
    long serialVersionUID;
    String strDetail;
    String strPrompt;

    public GProSecurityResult() {
        this.serialVersionUID = 1L;
        this.strPrompt = "";
        this.strDetail = "";
    }

    public long getActionCode() {
        return this.actionCode;
    }

    public boolean getIsValidSecResult() {
        return this.isValidSecResult;
    }

    public String getStrDetail() {
        return this.strDetail;
    }

    public String getStrPrompt() {
        return this.strPrompt;
    }

    public String toString() {
        return "GProSecurityResult{isValidSecResult=" + this.isValidSecResult + ",actionCode=" + this.actionCode + ",strPrompt=" + this.strPrompt + ",strDetail=" + this.strDetail + ",}";
    }

    public GProSecurityResult(boolean z, long j2, String str, String str2) {
        this.serialVersionUID = 1L;
        this.strPrompt = "";
        this.strDetail = "";
        this.isValidSecResult = z;
        this.actionCode = j2;
        this.strPrompt = str;
        this.strDetail = str2;
    }
}
