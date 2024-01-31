package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProRecommendNewCardRsp implements Serializable {
    int nextTs;
    long serialVersionUID = 1;
    boolean updateFlag;

    public GProRecommendNewCardRsp() {
    }

    public int getNextTs() {
        return this.nextTs;
    }

    public boolean getUpdateFlag() {
        return this.updateFlag;
    }

    public String toString() {
        return "GProRecommendNewCardRsp{updateFlag=" + this.updateFlag + ",nextTs=" + this.nextTs + ",}";
    }

    public GProRecommendNewCardRsp(boolean z, int i2) {
        this.updateFlag = z;
        this.nextTs = i2;
    }
}
