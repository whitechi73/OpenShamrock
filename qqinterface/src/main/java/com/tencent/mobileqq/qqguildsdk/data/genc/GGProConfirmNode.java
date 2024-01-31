package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProConfirmNode;

import java.io.Serializable;

public  class GGProConfirmNode implements Serializable {
    public final GProConfirmNode mInfo;

    public GGProConfirmNode(GProConfirmNode gProConfirmNode) {
        this.mInfo = gProConfirmNode;
    }

    public String getButtonMsg() {
        return this.mInfo.getButtonMsg();
    }

    public boolean getCancelOpt() {
        return this.mInfo.getCancelOpt();
    }

    public String getConfirmExt() {
        return this.mInfo.getConfirmExt();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
