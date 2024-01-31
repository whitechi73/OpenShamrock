package com.tencent.qqnt.kernel.nativeinterface;



public final class VASRecentContactMsgElement {
    Integer bubbleId;

    public VASRecentContactMsgElement() {
    }

    public Integer getBubbleId() {
        return this.bubbleId;
    }

    public String toString() {
        return "VASRecentContactMsgElement{bubbleId=" + this.bubbleId + ",}";
    }

    public VASRecentContactMsgElement(Integer num) {
        this.bubbleId = num;
    }
}
