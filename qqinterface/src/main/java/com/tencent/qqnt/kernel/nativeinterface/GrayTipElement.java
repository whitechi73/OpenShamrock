package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class GrayTipElement implements Serializable {
    AioOperateGrayTipElement aioOpGrayTipElement;
    BlockGrayTipElement blockGrayTipElement;
    BuddyGrayElement buddyElement;
    BuddyReq buddyNotifyElement;
    EmojiReplyElement emojiReplyElement;
    EssenceElement essenceElement;
    FeedMsgElement feedMsgElement;
    FileReceiptElement fileReceiptElement;
    GroupGrayElement groupElement;
    GroupNotifyMsg groupNotifyElement;
    JsonGrayElement jsonGrayTipElement;
    LocalGrayTipElement localGrayTipElement;
    ProclamationElement proclamationElement;
    RevokeElement revokeElement;
    int subElementType;
    WalletGrayTipElement walletGrayTipElement;
    XmlElement xmlElement;

    public GrayTipElement() {
    }

    public AioOperateGrayTipElement getAioOpGrayTipElement() {
        return this.aioOpGrayTipElement;
    }

    public BlockGrayTipElement getBlockGrayTipElement() {
        return this.blockGrayTipElement;
    }

    public BuddyGrayElement getBuddyElement() {
        return this.buddyElement;
    }

    public BuddyReq getBuddyNotifyElement() {
        return this.buddyNotifyElement;
    }

    public EmojiReplyElement getEmojiReplyElement() {
        return this.emojiReplyElement;
    }

    public EssenceElement getEssenceElement() {
        return this.essenceElement;
    }

    public FeedMsgElement getFeedMsgElement() {
        return this.feedMsgElement;
    }

    public FileReceiptElement getFileReceiptElement() {
        return this.fileReceiptElement;
    }

    public GroupGrayElement getGroupElement() {
        return this.groupElement;
    }

    public GroupNotifyMsg getGroupNotifyElement() {
        return this.groupNotifyElement;
    }

    public JsonGrayElement getJsonGrayTipElement() {
        return this.jsonGrayTipElement;
    }

    public LocalGrayTipElement getLocalGrayTipElement() {
        return this.localGrayTipElement;
    }

    public ProclamationElement getProclamationElement() {
        return this.proclamationElement;
    }

    public RevokeElement getRevokeElement() {
        return this.revokeElement;
    }

    public int getSubElementType() {
        return this.subElementType;
    }

    public WalletGrayTipElement getWalletGrayTipElement() {
        return this.walletGrayTipElement;
    }

    public XmlElement getXmlElement() {
        return this.xmlElement;
    }

    public String toString() {
        return "GrayTipElement{subElementType=" + this.subElementType + ",revokeElement=" + this.revokeElement + ",proclamationElement=" + this.proclamationElement + ",emojiReplyElement=" + this.emojiReplyElement + ",groupElement=" + this.groupElement + ",buddyElement=" + this.buddyElement + ",feedMsgElement=" + this.feedMsgElement + ",essenceElement=" + this.essenceElement + ",groupNotifyElement=" + this.groupNotifyElement + ",buddyNotifyElement=" + this.buddyNotifyElement + ",xmlElement=" + this.xmlElement + ",fileReceiptElement=" + this.fileReceiptElement + ",localGrayTipElement=" + this.localGrayTipElement + ",blockGrayTipElement=" + this.blockGrayTipElement + ",aioOpGrayTipElement=" + this.aioOpGrayTipElement + ",jsonGrayTipElement=" + this.jsonGrayTipElement + ",walletGrayTipElement=" + this.walletGrayTipElement + ",}";
    }

    public GrayTipElement(int i2, RevokeElement revokeElement, ProclamationElement proclamationElement, EmojiReplyElement emojiReplyElement, GroupGrayElement groupGrayElement, BuddyGrayElement buddyGrayElement, FeedMsgElement feedMsgElement, EssenceElement essenceElement, GroupNotifyMsg groupNotifyMsg, BuddyReq buddyReq, XmlElement xmlElement, FileReceiptElement fileReceiptElement, LocalGrayTipElement localGrayTipElement, BlockGrayTipElement blockGrayTipElement, AioOperateGrayTipElement aioOperateGrayTipElement, JsonGrayElement jsonGrayElement, WalletGrayTipElement walletGrayTipElement) {
        this.subElementType = i2;
        this.revokeElement = revokeElement;
        this.proclamationElement = proclamationElement;
        this.emojiReplyElement = emojiReplyElement;
        this.groupElement = groupGrayElement;
        this.buddyElement = buddyGrayElement;
        this.feedMsgElement = feedMsgElement;
        this.essenceElement = essenceElement;
        this.groupNotifyElement = groupNotifyMsg;
        this.buddyNotifyElement = buddyReq;
        this.xmlElement = xmlElement;
        this.fileReceiptElement = fileReceiptElement;
        this.localGrayTipElement = localGrayTipElement;
        this.blockGrayTipElement = blockGrayTipElement;
        this.aioOpGrayTipElement = aioOperateGrayTipElement;
        this.jsonGrayTipElement = jsonGrayElement;
        this.walletGrayTipElement = walletGrayTipElement;
    }
}