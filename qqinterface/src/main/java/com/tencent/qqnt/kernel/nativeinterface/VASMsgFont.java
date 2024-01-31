package com.tencent.qqnt.kernel.nativeinterface;



public final class VASMsgFont {
    Integer diyFontCfgUpdateTime;
    Integer diyFontImageId;
    Integer fontId;
    Integer magicFontType;
    Long subFontId;

    public VASMsgFont() {
    }

    public Integer getDiyFontCfgUpdateTime() {
        return this.diyFontCfgUpdateTime;
    }

    public Integer getDiyFontImageId() {
        return this.diyFontImageId;
    }

    public Integer getFontId() {
        return this.fontId;
    }

    public Integer getMagicFontType() {
        return this.magicFontType;
    }

    public Long getSubFontId() {
        return this.subFontId;
    }

    public String toString() {
        return "VASMsgFont{fontId=" + this.fontId + ",subFontId=" + this.subFontId + ",diyFontCfgUpdateTime=" + this.diyFontCfgUpdateTime + ",diyFontImageId=" + this.diyFontImageId + ",magicFontType=" + this.magicFontType + ",}";
    }

    public VASMsgFont(Integer num, Long l2, Integer num2, Integer num3, Integer num4) {
        this.fontId = num;
        this.subFontId = l2;
        this.diyFontCfgUpdateTime = num2;
        this.diyFontImageId = num3;
        this.magicFontType = num4;
    }
}
