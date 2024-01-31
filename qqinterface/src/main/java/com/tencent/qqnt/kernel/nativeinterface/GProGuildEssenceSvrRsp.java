package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProGuildEssenceSvrRsp implements Serializable {
    int canModify;
    long serialVersionUID;
    String tips;
    GProUnifiedEssenceInfo unifiedEssenceInfo;
    int visitorEdit;

    public GProGuildEssenceSvrRsp() {
        this.serialVersionUID = 1L;
        this.unifiedEssenceInfo = new GProUnifiedEssenceInfo();
        this.tips = "";
    }

    public int getCanModify() {
        return this.canModify;
    }

    public String getTips() {
        return this.tips;
    }

    public GProUnifiedEssenceInfo getUnifiedEssenceInfo() {
        return this.unifiedEssenceInfo;
    }

    public int getVisitorEdit() {
        return this.visitorEdit;
    }

    public String toString() {
        return "GProGuildEssenceSvrRsp{unifiedEssenceInfo=" + this.unifiedEssenceInfo + ",visitorEdit=" + this.visitorEdit + ",canModify=" + this.canModify + ",tips=" + this.tips + ",}";
    }

    public GProGuildEssenceSvrRsp(GProUnifiedEssenceInfo gProUnifiedEssenceInfo, int i2, int i3, String str) {
        this.serialVersionUID = 1L;
        this.unifiedEssenceInfo = new GProUnifiedEssenceInfo();
        this.tips = "";
        this.unifiedEssenceInfo = gProUnifiedEssenceInfo;
        this.visitorEdit = i2;
        this.canModify = i3;
        this.tips = str;
    }
}
