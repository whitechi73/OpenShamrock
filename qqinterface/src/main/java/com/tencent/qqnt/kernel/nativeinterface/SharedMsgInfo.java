package com.tencent.qqnt.kernel.nativeinterface;



public final class SharedMsgInfo {
    boolean isSharedMsg;

    public SharedMsgInfo() {
    }

    public boolean getIsSharedMsg() {
        return this.isSharedMsg;
    }

    public String toString() {
        return "SharedMsgInfo{isSharedMsg=" + this.isSharedMsg + ",}";
    }

    public SharedMsgInfo(boolean z) {
        this.isSharedMsg = z;
    }
}
