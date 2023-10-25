package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class BlockGrayTipElement implements Serializable {
    boolean block;
    boolean isBuddy;
    String peerUid;
    long serialVersionUID;

    public BlockGrayTipElement() {
        this.serialVersionUID = 1L;
        this.peerUid = "";
    }

    public boolean getBlock() {
        return this.block;
    }

    public boolean getIsBuddy() {
        return this.isBuddy;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String toString() {
        return "BlockGrayTipElement{peerUid=" + this.peerUid + ",block=" + this.block + ",isBuddy=" + this.isBuddy + ",}";
    }

    public BlockGrayTipElement(String str, boolean z, boolean z2) {
        this.serialVersionUID = 1L;
        this.peerUid = "";
        this.peerUid = str;
        this.block = z;
        this.isBuddy = z2;
    }
}