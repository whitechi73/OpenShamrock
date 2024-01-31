package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProVoiceSmobaGameSmobaRoomInfo {
    int gameMode;
    ArrayList<Integer> gradeList;

    public GProVoiceSmobaGameSmobaRoomInfo() {
        this.gradeList = new ArrayList<>();
    }

    public int getGameMode() {
        return this.gameMode;
    }

    public ArrayList<Integer> getGradeList() {
        return this.gradeList;
    }

    public String toString() {
        return "GProVoiceSmobaGameSmobaRoomInfo{gameMode=" + this.gameMode + ",gradeList=" + this.gradeList + ",}";
    }

    public GProVoiceSmobaGameSmobaRoomInfo(int i2, ArrayList<Integer> arrayList) {
        this.gradeList = new ArrayList<>();
        this.gameMode = i2;
        this.gradeList = arrayList;
    }
}
