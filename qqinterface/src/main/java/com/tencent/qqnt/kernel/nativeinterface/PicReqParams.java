package com.tencent.qqnt.kernel.nativeinterface;

public  final class PicReqParams {
    int chatType;
    boolean isGif;
    String peerUid;
    int picSize;

    public PicReqParams() {
        this.peerUid = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public boolean getIsGif() {
        return this.isGif;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public int getPicSize() {
        return this.picSize;
    }

    public String toString() {
        return "PicReqParams{chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",picSize=" + this.picSize + ",isGif=" + this.isGif + ",}";
    }

    public PicReqParams(int i2, String str, int i3, boolean z) {
        this.peerUid = "";
        this.chatType = i2;
        this.peerUid = str;
        this.picSize = i3;
        this.isGif = z;
    }
}
