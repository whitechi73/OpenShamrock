package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;


public  final class LocalGrayTipElement implements Serializable {
    LocalGrayTipDirect direct;
    String extraJson;
    LocalGrayTipRobot robot;
    long serialVersionUID;
    int type;

    public LocalGrayTipElement() {
        this.serialVersionUID = 1L;
        this.extraJson = "";
    }

    public LocalGrayTipDirect getDirect() {
        return this.direct;
    }

    public String getExtraJson() {
        return this.extraJson;
    }

    public LocalGrayTipRobot getRobot() {
        return this.robot;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "LocalGrayTipElement{type=" + this.type + ",robot=" + this.robot + ",direct=" + this.direct + ",extraJson=" + this.extraJson + ",}";
    }

    public LocalGrayTipElement(int i2, LocalGrayTipRobot localGrayTipRobot, LocalGrayTipDirect localGrayTipDirect, String str) {
        this.serialVersionUID = 1L;
        this.extraJson = "";
        this.type = i2;
        this.robot = localGrayTipRobot;
        this.direct = localGrayTipDirect;
        this.extraJson = str;
    }
}
