package com.tencent.qqnt.kernel.nativeinterface;


public  final class MsgSetting implements IKernelModel {
    Integer callRemind;
    Integer careCueTone;
    Integer cueTone;
    Integer groupSound;
    Integer groupVibrate;
    Integer msgNotify;
    Integer msgPreview;
    Integer noDisturbTime;
    Integer sound;
    Integer topRemind;
    Integer vibrate;

    public MsgSetting() {
    }

    public Integer getCallRemind() {
        return this.callRemind;
    }

    public Integer getCareCueTone() {
        return this.careCueTone;
    }

    public Integer getCueTone() {
        return this.cueTone;
    }

    public Integer getGroupSound() {
        return this.groupSound;
    }

    public Integer getGroupVibrate() {
        return this.groupVibrate;
    }

    public Integer getMsgNotify() {
        return this.msgNotify;
    }

    public Integer getMsgPreview() {
        return this.msgPreview;
    }

    public Integer getNoDisturbTime() {
        return this.noDisturbTime;
    }

    public Integer getSound() {
        return this.sound;
    }

    public Integer getTopRemind() {
        return this.topRemind;
    }

    public Integer getVibrate() {
        return this.vibrate;
    }

    public void setCallRemind(Integer num) {
        this.callRemind = num;
    }

    public void setCareCueTone(Integer num) {
        this.careCueTone = num;
    }

    public void setCueTone(Integer num) {
        this.cueTone = num;
    }

    public void setGroupSound(Integer num) {
        this.groupSound = num;
    }

    public void setGroupVibrate(Integer num) {
        this.groupVibrate = num;
    }

    public void setMsgNotify(Integer num) {
        this.msgNotify = num;
    }

    public void setMsgPreview(Integer num) {
        this.msgPreview = num;
    }

    public void setNoDisturbTime(Integer num) {
        this.noDisturbTime = num;
    }

    public void setSound(Integer num) {
        this.sound = num;
    }

    public void setTopRemind(Integer num) {
        this.topRemind = num;
    }

    public void setVibrate(Integer num) {
        this.vibrate = num;
    }

    public String toString() {
        return "MsgSetting{msgNotify=" + this.msgNotify + ",topRemind=" + this.topRemind + ",callRemind=" + this.callRemind + ",msgPreview=" + this.msgPreview + ",sound=" + this.sound + ",groupSound=" + this.groupSound + ",cueTone=" + this.cueTone + ",careCueTone=" + this.careCueTone + ",vibrate=" + this.vibrate + ",groupVibrate=" + this.groupVibrate + ",noDisturbTime=" + this.noDisturbTime + ",}";
    }

    public MsgSetting(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11) {
        this.msgNotify = num;
        this.topRemind = num2;
        this.callRemind = num3;
        this.msgPreview = num4;
        this.sound = num5;
        this.groupSound = num6;
        this.cueTone = num7;
        this.careCueTone = num8;
        this.vibrate = num9;
        this.groupVibrate = num10;
        this.noDisturbTime = num11;
    }
}
