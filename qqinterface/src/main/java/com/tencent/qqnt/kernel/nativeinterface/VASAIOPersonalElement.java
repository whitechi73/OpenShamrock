package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public final class VASAIOPersonalElement {
    Long troopNameColorId;
    Integer vaDataChangeRand;
    VASPersonalNamePlate vasPersonalNamePlate;
    ArrayList<VASPersonalVipNumberInfo> vipNumbers;

    public VASAIOPersonalElement() {
        this.vipNumbers = new ArrayList<>();
    }

    public Long getTroopNameColorId() {
        return this.troopNameColorId;
    }

    public Integer getVaDataChangeRand() {
        return this.vaDataChangeRand;
    }

    public VASPersonalNamePlate getVasPersonalNamePlate() {
        return this.vasPersonalNamePlate;
    }

    public ArrayList<VASPersonalVipNumberInfo> getVipNumbers() {
        return this.vipNumbers;
    }

    public String toString() {
        return "VASAIOPersonalElement{troopNameColorId=" + this.troopNameColorId + ",vipNumbers=" + this.vipNumbers + ",vaDataChangeRand=" + this.vaDataChangeRand + ",vasPersonalNamePlate=" + this.vasPersonalNamePlate + ",}";
    }

    public VASAIOPersonalElement(Long l2, ArrayList<VASPersonalVipNumberInfo> arrayList, Integer num, VASPersonalNamePlate vASPersonalNamePlate) {
        this.vipNumbers = new ArrayList<>();
        this.troopNameColorId = l2;
        this.vipNumbers = arrayList;
        this.vaDataChangeRand = num;
        this.vasPersonalNamePlate = vASPersonalNamePlate;
    }
}
