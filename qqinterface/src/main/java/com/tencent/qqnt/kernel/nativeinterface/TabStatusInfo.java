package com.tencent.qqnt.kernel.nativeinterface;

public final class TabStatusInfo {
    boolean isExistence;
    long tabId;

    public TabStatusInfo() {
    }

    public boolean getIsExistence() {
        return this.isExistence;
    }

    public long getTabId() {
        return this.tabId;
    }

    public String toString() {
        return "TabStatusInfo{tabId=" + this.tabId + ",isExistence=" + this.isExistence + ",}";
    }

    public TabStatusInfo(long j2, boolean z) {
        this.tabId = j2;
        this.isExistence = z;
    }
}