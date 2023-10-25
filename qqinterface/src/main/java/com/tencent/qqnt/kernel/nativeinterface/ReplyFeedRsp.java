package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ReplyFeedRsp {
    Reply reply;

    public ReplyFeedRsp() {
        this.reply = new Reply();
    }

    public Reply getReply() {
        return this.reply;
    }

    public String toString() {
        return "ReplyFeedRsp{reply=" + this.reply + ",}";
    }

    public ReplyFeedRsp(Reply reply) {
        this.reply = new Reply();
        this.reply = reply;
    }
}
