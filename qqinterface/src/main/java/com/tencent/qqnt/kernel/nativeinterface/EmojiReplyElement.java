package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class EmojiReplyElement implements Serializable {
    int emojiId;
    int emojiType;
    long msgId;
    long msgSeq;
    long serialVersionUID = 1;
    long tinyId;

    public EmojiReplyElement() {
    }

    public int getEmojiId() {
        return this.emojiId;
    }

    public int getEmojiType() {
        return this.emojiType;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "EmojiReplyElement{tinyId=" + this.tinyId + ",msgSeq=" + this.msgSeq + ",msgId=" + this.msgId + ",emojiId=" + this.emojiId + ",emojiType=" + this.emojiType + ",}";
    }

    public EmojiReplyElement(long j2, long j3, long j4, int i2, int i3) {
        this.tinyId = j2;
        this.msgSeq = j3;
        this.msgId = j4;
        this.emojiId = i2;
        this.emojiType = i3;
    }
}
