package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class MsgAbstractElement implements Serializable {
    CalendarElement calendarElement;
    ChannelStateElement channelStateElement;
    String content;
    String customContent;
    Integer elementSubType;
    int elementType;
    Integer emojiId;
    Integer emojiType;
    String fileName;
    GrayTipElement grayTiPElement;
    Integer index;
    Boolean isSetEssence;
    Boolean isSetProclamation;
    Integer localGrayTipType;
    Long msgId;
    Long msgSeq;
    Integer onlineFileMsgCnt;
    Integer operatorRole;
    String operatorTinyId;
    long serialVersionUID = 1;
    TextGiftElement textGiftElement;
    Long tinyId;

    public MsgAbstractElement() {
    }

    public CalendarElement getCalendarElement() {
        return this.calendarElement;
    }

    public ChannelStateElement getChannelStateElement() {
        return this.channelStateElement;
    }

    public String getContent() {
        return this.content;
    }

    public String getCustomContent() {
        return this.customContent;
    }

    public Integer getElementSubType() {
        return this.elementSubType;
    }

    public int getElementType() {
        return this.elementType;
    }

    public Integer getEmojiId() {
        return this.emojiId;
    }

    public Integer getEmojiType() {
        return this.emojiType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public GrayTipElement getGrayTiPElement() {
        return this.grayTiPElement;
    }

    public Integer getIndex() {
        return this.index;
    }

    public Boolean getIsSetEssence() {
        return this.isSetEssence;
    }

    public Boolean getIsSetProclamation() {
        return this.isSetProclamation;
    }

    public Integer getLocalGrayTipType() {
        return this.localGrayTipType;
    }

    public Long getMsgId() {
        return this.msgId;
    }

    public Long getMsgSeq() {
        return this.msgSeq;
    }

    public Integer getOnlineFileMsgCnt() {
        return this.onlineFileMsgCnt;
    }

    public Integer getOperatorRole() {
        return this.operatorRole;
    }

    public String getOperatorTinyId() {
        return this.operatorTinyId;
    }

    public TextGiftElement getTextGiftElement() {
        return this.textGiftElement;
    }

    public Long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "MsgAbstractElement{elementType=" + this.elementType + ",elementSubType=" + this.elementSubType + ",content=" + this.content + ",customContent=" + this.customContent + ",index=" + this.index + ",isSetProclamation=" + this.isSetProclamation + ",isSetEssence=" + this.isSetEssence + ",operatorRole=" + this.operatorRole + ",operatorTinyId=" + this.operatorTinyId + ",fileName=" + this.fileName + ",tinyId=" + this.tinyId + ",msgSeq=" + this.msgSeq + ",msgId=" + this.msgId + ",emojiId=" + this.emojiId + ",emojiType=" + this.emojiType + ",localGrayTipType=" + this.localGrayTipType + ",grayTiPElement=" + this.grayTiPElement + ",textGiftElement=" + this.textGiftElement + ",calendarElement=" + this.calendarElement + ",channelStateElement=" + this.channelStateElement + ",onlineFileMsgCnt=" + this.onlineFileMsgCnt + ",}";
    }

    public MsgAbstractElement(int i2, Integer num, String str, String str2, Integer num2, Boolean bool, Boolean bool2, Integer num3, String str3, String str4, Long l2, Long l3, Long l4, Integer num4, Integer num5, Integer num6, GrayTipElement grayTipElement, TextGiftElement textGiftElement, CalendarElement calendarElement, ChannelStateElement channelStateElement, Integer num7) {
        this.elementType = i2;
        this.elementSubType = num;
        this.content = str;
        this.customContent = str2;
        this.index = num2;
        this.isSetProclamation = bool;
        this.isSetEssence = bool2;
        this.operatorRole = num3;
        this.operatorTinyId = str3;
        this.fileName = str4;
        this.tinyId = l2;
        this.msgSeq = l3;
        this.msgId = l4;
        this.emojiId = num4;
        this.emojiType = num5;
        this.localGrayTipType = num6;
        this.grayTiPElement = grayTipElement;
        this.textGiftElement = textGiftElement;
        this.calendarElement = calendarElement;
        this.channelStateElement = channelStateElement;
        this.onlineFileMsgCnt = num7;
    }
}