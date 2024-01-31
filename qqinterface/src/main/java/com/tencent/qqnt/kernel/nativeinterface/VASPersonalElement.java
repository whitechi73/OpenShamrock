package com.tencent.qqnt.kernel.nativeinterface;


public final class VASPersonalElement {
    Integer colorNickId;
    Integer fontId;
    Integer loveChatId;
    Long loverUin;
    VASPersonalNamePlate personalNamePlateInfo;
    Integer vaDataChangeRand;
    Integer vipPendantId;

    public VASPersonalElement() {
        this.personalNamePlateInfo = new VASPersonalNamePlate();
    }

    public Integer getColorNickId() {
        return this.colorNickId;
    }

    public Integer getFontId() {
        return this.fontId;
    }

    public Integer getLoveChatId() {
        return this.loveChatId;
    }

    public Long getLoverUin() {
        return this.loverUin;
    }

    public VASPersonalNamePlate getPersonalNamePlateInfo() {
        return this.personalNamePlateInfo;
    }

    public Integer getVaDataChangeRand() {
        return this.vaDataChangeRand;
    }

    public Integer getVipPendantId() {
        return this.vipPendantId;
    }

    public String toString() {
        return "VASPersonalElement{personalNamePlateInfo=" + this.personalNamePlateInfo + ",colorNickId=" + this.colorNickId + ",loveChatId=" + this.loveChatId + ",loverUin=" + this.loverUin + ",vipPendantId=" + this.vipPendantId + ",fontId=" + this.fontId + ",vaDataChangeRand=" + this.vaDataChangeRand + ",}";
    }

    public VASPersonalElement(VASPersonalNamePlate vASPersonalNamePlate, Integer num, Integer num2, Long l2, Integer num3, Integer num4, Integer num5) {
        this.personalNamePlateInfo = new VASPersonalNamePlate();
        this.personalNamePlateInfo = vASPersonalNamePlate;
        this.colorNickId = num;
        this.loveChatId = num2;
        this.loverUin = l2;
        this.vipPendantId = num3;
        this.fontId = num4;
        this.vaDataChangeRand = num5;
    }
}
