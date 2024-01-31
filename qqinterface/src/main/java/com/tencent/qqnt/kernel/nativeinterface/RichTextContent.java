package com.tencent.qqnt.kernel.nativeinterface;


public  final class RichTextContent {
    RichTextAtContent atContent;
    RichTextChannelContent channelContent;
    RichTextEmojiContent emojiContent;
    String patternId;
    RichTextTextContent textContent;
    RICHTEXTCONTENTTYPE type;
    RichTextURLContent urlContent;

    public RichTextContent() {
        this.type = RICHTEXTCONTENTTYPE.values()[0];
        this.patternId = "";
    }

    public RichTextAtContent getAtContent() {
        return this.atContent;
    }

    public RichTextChannelContent getChannelContent() {
        return this.channelContent;
    }

    public RichTextEmojiContent getEmojiContent() {
        return this.emojiContent;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public RichTextTextContent getTextContent() {
        return this.textContent;
    }

    public RICHTEXTCONTENTTYPE getType() {
        return this.type;
    }

    public RichTextURLContent getUrlContent() {
        return this.urlContent;
    }

    public String toString() {
        return "RichTextContent{type=" + this.type + ",patternId=" + this.patternId + ",textContent=" + this.textContent + ",emojiContent=" + this.emojiContent + ",atContent=" + this.atContent + ",urlContent=" + this.urlContent + ",channelContent=" + this.channelContent + ",}";
    }

    public RichTextContent(RICHTEXTCONTENTTYPE richtextcontenttype, String str, RichTextTextContent richTextTextContent, RichTextEmojiContent richTextEmojiContent, RichTextAtContent richTextAtContent, RichTextURLContent richTextURLContent, RichTextChannelContent richTextChannelContent) {
        this.type = RICHTEXTCONTENTTYPE.values()[0];
        this.patternId = "";
        this.type = richtextcontenttype;
        this.patternId = str;
        this.textContent = richTextTextContent;
        this.emojiContent = richTextEmojiContent;
        this.atContent = richTextAtContent;
        this.urlContent = richTextURLContent;
        this.channelContent = richTextChannelContent;
    }
}
