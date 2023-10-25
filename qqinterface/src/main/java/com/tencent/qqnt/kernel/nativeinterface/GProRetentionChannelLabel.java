package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProRetentionChannelLabel implements Serializable {
    String labelName;
    int labelType;
    int labelValue;
    long serialVersionUID;

    public GProRetentionChannelLabel() {
        this.serialVersionUID = 1L;
        this.labelName = "";
    }

    public String getLabelName() {
        return this.labelName;
    }

    public int getLabelType() {
        return this.labelType;
    }

    public int getLabelValue() {
        return this.labelValue;
    }

    public String toString() {
        return "GProRetentionChannelLabel{labelName=" + this.labelName + ",labelType=" + this.labelType + ",labelValue=" + this.labelValue + ",}";
    }

    public GProRetentionChannelLabel(String str, int i2, int i3) {
        this.serialVersionUID = 1L;
        this.labelName = "";
        this.labelName = str;
        this.labelType = i2;
        this.labelValue = i3;
    }
}
