package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProConfirmNode {
    String buttonMsg;
    boolean cancelOpt;
    String confirmExt;

    public GProConfirmNode() {
        this.buttonMsg = "";
        this.confirmExt = "";
    }

    public String getButtonMsg() {
        return this.buttonMsg;
    }

    public boolean getCancelOpt() {
        return this.cancelOpt;
    }

    public String getConfirmExt() {
        return this.confirmExt;
    }

    public String toString() {
        return "GProConfirmNode{buttonMsg=" + this.buttonMsg + ",confirmExt=" + this.confirmExt + ",cancelOpt=" + this.cancelOpt + ",}";
    }

    public GProConfirmNode(String str, String str2, boolean z) {
        this.buttonMsg = "";
        this.confirmExt = "";
        this.buttonMsg = str;
        this.confirmExt = str2;
        this.cancelOpt = z;
    }
}
