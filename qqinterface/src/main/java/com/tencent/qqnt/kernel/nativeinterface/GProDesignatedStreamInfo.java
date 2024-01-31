package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProDesignatedStreamInfo {
    ArrayList<GProLiveGearInfo> GearLIst;
    ArrayList<Integer> LevelList;
    Integer isSwitch;
    ArrayList<GProLiveStream> streams;
    Integer sugLevel;

    public GProDesignatedStreamInfo() {
        this.streams = new ArrayList<>();
        this.LevelList = new ArrayList<>();
        this.GearLIst = new ArrayList<>();
    }

    public ArrayList<GProLiveGearInfo> getGearLIst() {
        return this.GearLIst;
    }

    public Integer getIsSwitch() {
        return this.isSwitch;
    }

    public ArrayList<Integer> getLevelList() {
        return this.LevelList;
    }

    public ArrayList<GProLiveStream> getStreams() {
        return this.streams;
    }

    public Integer getSugLevel() {
        return this.sugLevel;
    }

    public String toString() {
        return "GProDesignatedStreamInfo{streams=" + this.streams + ",isSwitch=" + this.isSwitch + ",LevelList=" + this.LevelList + ",sugLevel=" + this.sugLevel + ",GearLIst=" + this.GearLIst + ",}";
    }

    public GProDesignatedStreamInfo(ArrayList<GProLiveStream> arrayList, Integer num, ArrayList<Integer> arrayList2, Integer num2, ArrayList<GProLiveGearInfo> arrayList3) {
        this.streams = new ArrayList<>();
        this.LevelList = new ArrayList<>();
        this.GearLIst = new ArrayList<>();
        this.streams = arrayList;
        this.isSwitch = num;
        this.LevelList = arrayList2;
        this.sugLevel = num2;
        this.GearLIst = arrayList3;
    }
}
