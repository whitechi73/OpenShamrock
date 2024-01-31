package com.tencent.qqnt.kernel.nativeinterface;



public final class VASMsgBubble {
    Integer bubbleDiyTextId;
    Integer bubbleId;
    Integer canConvertToText;
    Integer subBubbleId;

    public VASMsgBubble() {
    }

    public Integer getBubbleDiyTextId() {
        return this.bubbleDiyTextId;
    }

    public Integer getBubbleId() {
        return this.bubbleId;
    }

    public Integer getCanConvertToText() {
        return this.canConvertToText;
    }

    public Integer getSubBubbleId() {
        return this.subBubbleId;
    }

    public String toString() {
        return "VASMsgBubble{bubbleId=" + this.bubbleId + ",bubbleDiyTextId=" + this.bubbleDiyTextId + ",subBubbleId=" + this.subBubbleId + ",canConvertToText=" + this.canConvertToText + ",}";
    }

    public VASMsgBubble(Integer num, Integer num2, Integer num3, Integer num4) {
        this.bubbleId = num;
        this.bubbleDiyTextId = num2;
        this.subBubbleId = num3;
        this.canConvertToText = num4;
    }
}
