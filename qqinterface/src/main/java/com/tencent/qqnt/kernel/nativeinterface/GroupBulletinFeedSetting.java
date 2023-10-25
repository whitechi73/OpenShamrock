package com.tencent.qqnt.kernel.nativeinterface;

public final class GroupBulletinFeedSetting {
    int confirmRequired;
    int isShowEditCard;
    int remindTs;
    int tipWindowType;

    public GroupBulletinFeedSetting() {
    }

    public int getConfirmRequired() {
        return this.confirmRequired;
    }

    public int getIsShowEditCard() {
        return this.isShowEditCard;
    }

    public int getRemindTs() {
        return this.remindTs;
    }

    public int getTipWindowType() {
        return this.tipWindowType;
    }

    public String toString() {
        return "GroupBulletinFeedSetting{isShowEditCard=" + this.isShowEditCard + ",remindTs=" + this.remindTs + ",tipWindowType=" + this.tipWindowType + ",confirmRequired=" + this.confirmRequired + ",}";
    }

    public GroupBulletinFeedSetting(int i2, int i3, int i4, int i5) {
        this.isShowEditCard = i2;
        this.remindTs = i3;
        this.tipWindowType = i4;
        this.confirmRequired = i5;
    }
}