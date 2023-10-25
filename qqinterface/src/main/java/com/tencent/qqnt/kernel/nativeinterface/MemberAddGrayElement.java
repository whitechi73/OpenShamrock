package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class MemberAddGrayElement implements Serializable {
    GrayTipMember otherAdd;
    InviterAndInvited otherAddByOtherQRCode;
    GrayTipMember otherAddByYourQRCode;
    InviterAndInvited otherInviteOther;
    GrayTipMember otherInviteYou;
    long serialVersionUID = 1;
    int showType;
    GrayTipMember youAddByOtherQRCode;
    GrayTipMember youInviteOther;

    public MemberAddGrayElement() {
    }

    public GrayTipMember getOtherAdd() {
        return this.otherAdd;
    }

    public InviterAndInvited getOtherAddByOtherQRCode() {
        return this.otherAddByOtherQRCode;
    }

    public GrayTipMember getOtherAddByYourQRCode() {
        return this.otherAddByYourQRCode;
    }

    public InviterAndInvited getOtherInviteOther() {
        return this.otherInviteOther;
    }

    public GrayTipMember getOtherInviteYou() {
        return this.otherInviteYou;
    }

    public int getShowType() {
        return this.showType;
    }

    public GrayTipMember getYouAddByOtherQRCode() {
        return this.youAddByOtherQRCode;
    }

    public GrayTipMember getYouInviteOther() {
        return this.youInviteOther;
    }

    public String toString() {
        return "MemberAddGrayElement{showType=" + this.showType + ",otherAdd=" + this.otherAdd + ",otherAddByOtherQRCode=" + this.otherAddByOtherQRCode + ",otherAddByYourQRCode=" + this.otherAddByYourQRCode + ",youAddByOtherQRCode=" + this.youAddByOtherQRCode + ",otherInviteOther=" + this.otherInviteOther + ",otherInviteYou=" + this.otherInviteYou + ",youInviteOther=" + this.youInviteOther + ",}";
    }

    public MemberAddGrayElement(int i2, GrayTipMember grayTipMember, InviterAndInvited inviterAndInvited, GrayTipMember grayTipMember2, GrayTipMember grayTipMember3, InviterAndInvited inviterAndInvited2, GrayTipMember grayTipMember4, GrayTipMember grayTipMember5) {
        this.showType = i2;
        this.otherAdd = grayTipMember;
        this.otherAddByOtherQRCode = inviterAndInvited;
        this.otherAddByYourQRCode = grayTipMember2;
        this.youAddByOtherQRCode = grayTipMember3;
        this.otherInviteOther = inviterAndInvited2;
        this.otherInviteYou = grayTipMember4;
        this.youInviteOther = grayTipMember5;
    }
}