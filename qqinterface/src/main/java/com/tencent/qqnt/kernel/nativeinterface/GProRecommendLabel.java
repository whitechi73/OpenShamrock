package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProRecommendLabel implements Serializable {
    int bussiLabelType;
    String labelName;
    int labelType;
    int labelValue;
    long serialVersionUID;
    String value;
    ArrayList<String> valueList;

    public GProRecommendLabel() {
        this.serialVersionUID = 1L;
        this.labelName = "";
        this.value = "";
        this.valueList = new ArrayList<>();
    }

    public int getBussiLabelType() {
        return this.bussiLabelType;
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

    public String getValue() {
        return this.value;
    }

    public ArrayList<String> getValueList() {
        return this.valueList;
    }

    public String toString() {
        return "GProRecommendLabel{labelName=" + this.labelName + ",labelType=" + this.labelType + ",labelValue=" + this.labelValue + ",value=" + this.value + ",valueList=" + this.valueList + ",bussiLabelType=" + this.bussiLabelType + ",}";
    }

    public GProRecommendLabel(String str, int i2, int i3, String str2, ArrayList<String> arrayList, int i4) {
        this.serialVersionUID = 1L;
        this.labelName = "";
        this.value = "";
        this.valueList = new ArrayList<>();
        this.labelName = str;
        this.labelType = i2;
        this.labelValue = i3;
        this.value = str2;
        this.valueList = arrayList;
        this.bussiLabelType = i4;
    }
}
