package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProChannelToolBar implements Serializable {
    long serialVersionUID;
    String toolbarListStr;

    public GProChannelToolBar() {
        this.serialVersionUID = 1L;
        this.toolbarListStr = "";
    }

    public String getToolbarListStr() {
        return this.toolbarListStr;
    }

    public String toString() {
        return "GProChannelToolBar{toolbarListStr=" + this.toolbarListStr + ",}";
    }

    public GProChannelToolBar(String str) {
        this.serialVersionUID = 1L;
        this.toolbarListStr = "";
        this.toolbarListStr = str;
    }
}
