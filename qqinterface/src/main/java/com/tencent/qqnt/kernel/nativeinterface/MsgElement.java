package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class MsgElement implements IKernelModel, Serializable {
    ArkElement arkElement; // JSON MSG
    AVRecordElement avRecordElement; // 录音
    CalendarElement calendarElement;
    long elementId;
    int elementType;
    byte[] extBufForUI;
    FaceBubbleElement faceBubbleElement;
    FaceElement faceElement; // 表情 | Poke
    FileElement fileElement; // 文件
    GiphyElement giphyElement;
    GrayTipElement grayTipElement; // 灰色提示
    InlineKeyboardElement inlineKeyboardElement; // 内联键盘
    LiveGiftElement liveGiftElement; // 直播礼物
    MarkdownElement markdownElement; // MD
    MarketFaceElement marketFaceElement;
    MultiForwardMsgElement multiForwardMsgElement;
    PicElement picElement;
    PttElement pttElement;
    ReplyElement replyElement;
    ShareLocationElement shareLocationElement;
    StructLongMsgElement structLongMsgElement;
    StructMsgElement structMsgElement; // xml
    TextElement textElement;
    TextGiftElement textGiftElement;
    TofuRecordElement tofuRecordElement;
    VideoElement videoElement; // 视频
    WalletElement walletElement;
    YoloGameResultElement yoloGameResultElement;

    public MsgElement() {
    }

    public ArkElement getArkElement() {
        return this.arkElement;
    }

    public AVRecordElement getAvRecordElement() {
        return this.avRecordElement;
    }

    public CalendarElement getCalendarElement() {
        return this.calendarElement;
    }

    public long getElementId() {
        return this.elementId;
    }

    public int getElementType() {
        return this.elementType;
    }

    public byte[] getExtBufForUI() {
        return this.extBufForUI;
    }

    public FaceBubbleElement getFaceBubbleElement() {
        return this.faceBubbleElement;
    }

    public FaceElement getFaceElement() {
        return this.faceElement;
    }

    public FileElement getFileElement() {
        return this.fileElement;
    }

    public GiphyElement getGiphyElement() {
        return this.giphyElement;
    }

    public GrayTipElement getGrayTipElement() {
        return this.grayTipElement;
    }

    public InlineKeyboardElement getInlineKeyboardElement() {
        return this.inlineKeyboardElement;
    }

    public LiveGiftElement getLiveGiftElement() {
        return this.liveGiftElement;
    }

    public MarkdownElement getMarkdownElement() {
        return this.markdownElement;
    }

    public MarketFaceElement getMarketFaceElement() {
        return this.marketFaceElement;
    }

    public MultiForwardMsgElement getMultiForwardMsgElement() {
        return this.multiForwardMsgElement;
    }

    public PicElement getPicElement() {
        return this.picElement;
    }

    public PttElement getPttElement() {
        return this.pttElement;
    }

    public ReplyElement getReplyElement() {
        return this.replyElement;
    }

    public ShareLocationElement getShareLocationElement() {
        return this.shareLocationElement;
    }

    public StructLongMsgElement getStructLongMsgElement() {
        return this.structLongMsgElement;
    }

    public StructMsgElement getStructMsgElement() {
        return this.structMsgElement;
    }

    public TextElement getTextElement() {
        return this.textElement;
    }

    public TextGiftElement getTextGiftElement() {
        return this.textGiftElement;
    }

    public TofuRecordElement getTofuRecordElement() {
        return this.tofuRecordElement;
    }

    public VideoElement getVideoElement() {
        return this.videoElement;
    }

    public WalletElement getWalletElement() {
        return this.walletElement;
    }

    public YoloGameResultElement getYoloGameResultElement() {
        return this.yoloGameResultElement;
    }

    public void setArkElement(ArkElement arkElement) {
        this.arkElement = arkElement;
    }

    public void setAvRecordElement(AVRecordElement aVRecordElement) {
        this.avRecordElement = aVRecordElement;
    }

    public void setCalendarElement(CalendarElement calendarElement) {
        this.calendarElement = calendarElement;
    }

    public void setElementId(long j2) {
        this.elementId = j2;
    }

    public void setElementType(int i2) {
        this.elementType = i2;
    }

    public void setExtBufForUI(byte[] bArr) {
        this.extBufForUI = bArr;
    }

    public void setFaceBubbleElement(FaceBubbleElement faceBubbleElement) {
        this.faceBubbleElement = faceBubbleElement;
    }

    public void setFaceElement(FaceElement faceElement) {
        this.faceElement = faceElement;
    }

    public void setFileElement(FileElement fileElement) {
        this.fileElement = fileElement;
    }

    public void setGiphyElement(GiphyElement giphyElement) {
        this.giphyElement = giphyElement;
    }

    public void setGrayTipElement(GrayTipElement grayTipElement) {
        this.grayTipElement = grayTipElement;
    }

    public void setInlineKeyboardElement(InlineKeyboardElement inlineKeyboardElement) {
        this.inlineKeyboardElement = inlineKeyboardElement;
    }

    public void setLiveGiftElement(LiveGiftElement liveGiftElement) {
        this.liveGiftElement = liveGiftElement;
    }

    public void setMarkdownElement(MarkdownElement markdownElement) {
        this.markdownElement = markdownElement;
    }

    public void setMarketFaceElement(MarketFaceElement marketFaceElement) {
        this.marketFaceElement = marketFaceElement;
    }

    public void setMultiForwardMsgElement(MultiForwardMsgElement multiForwardMsgElement) {
        this.multiForwardMsgElement = multiForwardMsgElement;
    }

    public void setPicElement(PicElement picElement) {
        this.picElement = picElement;
    }

    public void setPttElement(PttElement pttElement) {
        this.pttElement = pttElement;
    }

    public void setReplyElement(ReplyElement replyElement) {
        this.replyElement = replyElement;
    }

    public void setShareLocationElement(ShareLocationElement shareLocationElement) {
        this.shareLocationElement = shareLocationElement;
    }

    public void setStructLongMsgElement(StructLongMsgElement structLongMsgElement) {
        this.structLongMsgElement = structLongMsgElement;
    }

    public void setStructMsgElement(StructMsgElement structMsgElement) {
        this.structMsgElement = structMsgElement;
    }

    public void setTextElement(TextElement textElement) {
        this.textElement = textElement;
    }

    public void setTextGiftElement(TextGiftElement textGiftElement) {
        this.textGiftElement = textGiftElement;
    }

    public void setTofuRecordElement(TofuRecordElement tofuRecordElement) {
        this.tofuRecordElement = tofuRecordElement;
    }

    public void setVideoElement(VideoElement videoElement) {
        this.videoElement = videoElement;
    }

    public void setWalletElement(WalletElement walletElement) {
        this.walletElement = walletElement;
    }

    public void setYoloGameResultElement(YoloGameResultElement yoloGameResultElement) {
        this.yoloGameResultElement = yoloGameResultElement;
    }

    public String toString() {
        return "MsgElement{elementType=" + this.elementType + ",elementId=" + this.elementId + ",extBufForUI=" + this.extBufForUI + ",textElement=" + this.textElement + ",faceElement=" + this.faceElement + ",marketFaceElement=" + this.marketFaceElement + ",replyElement=" + this.replyElement + ",picElement=" + this.picElement + ",pttElement=" + this.pttElement + ",videoElement=" + this.videoElement + ",grayTipElement=" + this.grayTipElement + ",arkElement=" + this.arkElement + ",fileElement=" + this.fileElement + ",liveGiftElement=" + this.liveGiftElement + ",markdownElement=" + this.markdownElement + ",structLongMsgElement=" + this.structLongMsgElement + ",multiForwardMsgElement=" + this.multiForwardMsgElement + ",giphyElement=" + this.giphyElement + ",walletElement=" + this.walletElement + ",inlineKeyboardElement=" + this.inlineKeyboardElement + ",textGiftElement=" + this.textGiftElement + ",calendarElement=" + this.calendarElement + ",yoloGameResultElement=" + this.yoloGameResultElement + ",avRecordElement=" + this.avRecordElement + ",structMsgElement=" + this.structMsgElement + ",faceBubbleElement=" + this.faceBubbleElement + ",shareLocationElement=" + this.shareLocationElement + ",tofuRecordElement=" + this.tofuRecordElement + ",}";
    }

    public MsgElement(int i2, long j2, byte[] bArr, TextElement textElement, FaceElement faceElement, MarketFaceElement marketFaceElement, ReplyElement replyElement, PicElement picElement, PttElement pttElement, VideoElement videoElement, GrayTipElement grayTipElement, ArkElement arkElement, FileElement fileElement, LiveGiftElement liveGiftElement, MarkdownElement markdownElement, StructLongMsgElement structLongMsgElement, MultiForwardMsgElement multiForwardMsgElement, GiphyElement giphyElement, WalletElement walletElement, InlineKeyboardElement inlineKeyboardElement, TextGiftElement textGiftElement, CalendarElement calendarElement, YoloGameResultElement yoloGameResultElement, AVRecordElement aVRecordElement, StructMsgElement structMsgElement, FaceBubbleElement faceBubbleElement, ShareLocationElement shareLocationElement, TofuRecordElement tofuRecordElement) {
        this.elementType = i2;
        this.elementId = j2;
        this.extBufForUI = bArr;
        this.textElement = textElement;
        this.faceElement = faceElement;
        this.marketFaceElement = marketFaceElement;
        this.replyElement = replyElement;
        this.picElement = picElement;
        this.pttElement = pttElement;
        this.videoElement = videoElement;
        this.grayTipElement = grayTipElement;
        this.arkElement = arkElement;
        this.fileElement = fileElement;
        this.liveGiftElement = liveGiftElement;
        this.markdownElement = markdownElement;
        this.structLongMsgElement = structLongMsgElement;
        this.multiForwardMsgElement = multiForwardMsgElement;
        this.giphyElement = giphyElement;
        this.walletElement = walletElement;
        this.inlineKeyboardElement = inlineKeyboardElement;
        this.textGiftElement = textGiftElement;
        this.calendarElement = calendarElement;
        this.yoloGameResultElement = yoloGameResultElement;
        this.avRecordElement = aVRecordElement;
        this.structMsgElement = structMsgElement;
        this.faceBubbleElement = faceBubbleElement;
        this.shareLocationElement = shareLocationElement;
        this.tofuRecordElement = tofuRecordElement;
    }
}
