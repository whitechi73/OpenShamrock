package com.tencent.qqnt.kernel.nativeinterface;



public final class WalletGrayTipElement {
    byte[] authkey;
    byte[] broadcastRichContent;
    int hideFlag;
    int icon;
    byte[] idiom;
    byte[] idiomAlpha;
    int idiomSeq;
    String jumpUrl;
    int luckyFlag;
    long luckyUin;
    int msgType;
    byte[] pcBody;
    byte[] poemRule;
    int random;
    byte[] receiverRichContent;
    long receiverUin;
    byte[] senderRichContent;
    long senderUin;
    int showLastest;
    int subchannel;
    int time;

    public WalletGrayTipElement() {
        this.senderRichContent = new byte[0];
        this.receiverRichContent = new byte[0];
        this.authkey = new byte[0];
        this.pcBody = new byte[0];
        this.broadcastRichContent = new byte[0];
        this.idiom = new byte[0];
        this.idiomAlpha = new byte[0];
        this.jumpUrl = "";
        this.poemRule = new byte[0];
    }

    public byte[] getAuthkey() {
        return this.authkey;
    }

    public byte[] getBroadcastRichContent() {
        return this.broadcastRichContent;
    }

    public int getHideFlag() {
        return this.hideFlag;
    }

    public int getIcon() {
        return this.icon;
    }

    public byte[] getIdiom() {
        return this.idiom;
    }

    public byte[] getIdiomAlpha() {
        return this.idiomAlpha;
    }

    public int getIdiomSeq() {
        return this.idiomSeq;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getLuckyFlag() {
        return this.luckyFlag;
    }

    public long getLuckyUin() {
        return this.luckyUin;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public byte[] getPcBody() {
        return this.pcBody;
    }

    public byte[] getPoemRule() {
        return this.poemRule;
    }

    public int getRandom() {
        return this.random;
    }

    public byte[] getReceiverRichContent() {
        return this.receiverRichContent;
    }

    public long getReceiverUin() {
        return this.receiverUin;
    }

    public byte[] getSenderRichContent() {
        return this.senderRichContent;
    }

    public long getSenderUin() {
        return this.senderUin;
    }

    public int getShowLastest() {
        return this.showLastest;
    }

    public int getSubchannel() {
        return this.subchannel;
    }

    public int getTime() {
        return this.time;
    }

    public String toString() {
        return "WalletGrayTipElement{showLastest=" + this.showLastest + ",senderUin=" + this.senderUin + ",receiverUin=" + this.receiverUin + ",senderRichContent=" + this.senderRichContent + ",receiverRichContent=" + this.receiverRichContent + ",authkey=" + this.authkey + ",msgType=" + this.msgType + ",luckyFlag=" + this.luckyFlag + ",hideFlag=" + this.hideFlag + ",pcBody=" + this.pcBody + ",icon=" + this.icon + ",luckyUin=" + this.luckyUin + ",time=" + this.time + ",random=" + this.random + ",broadcastRichContent=" + this.broadcastRichContent + ",idiom=" + this.idiom + ",idiomSeq=" + this.idiomSeq + ",idiomAlpha=" + this.idiomAlpha + ",jumpUrl=" + this.jumpUrl + ",subchannel=" + this.subchannel + ",poemRule=" + this.poemRule + ",}";
    }

    public WalletGrayTipElement(int i2, long j2, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, int i3, int i4, int i5, byte[] bArr4, int i6, long j4, int i7, int i8, byte[] bArr5, byte[] bArr6, int i9, byte[] bArr7, String str, int i10, byte[] bArr8) {
        this.senderRichContent = new byte[0];
        this.receiverRichContent = new byte[0];
        this.authkey = new byte[0];
        this.pcBody = new byte[0];
        this.broadcastRichContent = new byte[0];
        this.idiom = new byte[0];
        this.idiomAlpha = new byte[0];
        this.jumpUrl = "";
        this.poemRule = new byte[0];
        this.showLastest = i2;
        this.senderUin = j2;
        this.receiverUin = j3;
        this.senderRichContent = bArr;
        this.receiverRichContent = bArr2;
        this.authkey = bArr3;
        this.msgType = i3;
        this.luckyFlag = i4;
        this.hideFlag = i5;
        this.pcBody = bArr4;
        this.icon = i6;
        this.luckyUin = j4;
        this.time = i7;
        this.random = i8;
        this.broadcastRichContent = bArr5;
        this.idiom = bArr6;
        this.idiomSeq = i9;
        this.idiomAlpha = bArr7;
        this.jumpUrl = str;
        this.subchannel = i10;
        this.poemRule = bArr8;
    }
}
