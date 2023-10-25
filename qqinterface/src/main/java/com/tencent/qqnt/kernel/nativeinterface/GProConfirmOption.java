package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProConfirmOption {
    String confirmMsg;
    ArrayList<GProConfirmNode> confirmNodes;

    public GProConfirmOption() {
        this.confirmMsg = "";
        this.confirmNodes = new ArrayList<>();
    }

    public String getConfirmMsg() {
        return this.confirmMsg;
    }

    public ArrayList<GProConfirmNode> getConfirmNodes() {
        return this.confirmNodes;
    }

    public String toString() {
        return "GProConfirmOption{confirmMsg=" + this.confirmMsg + ",confirmNodes=" + this.confirmNodes + ",}";
    }

    public GProConfirmOption(String str, ArrayList<GProConfirmNode> arrayList) {
        this.confirmMsg = "";
        this.confirmNodes = new ArrayList<>();
        this.confirmMsg = str;
        this.confirmNodes = arrayList;
    }
}
