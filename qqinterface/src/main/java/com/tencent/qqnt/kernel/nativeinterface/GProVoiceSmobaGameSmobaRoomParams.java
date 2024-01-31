package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProVoiceSmobaGameSmobaRoomParams {
    int gameMode;

    public GProVoiceSmobaGameSmobaRoomParams() {
    }

    public int getGameMode() {
        return this.gameMode;
    }

    public String toString() {
        return "GProVoiceSmobaGameSmobaRoomParams{gameMode=" + this.gameMode + ",}";
    }

    public GProVoiceSmobaGameSmobaRoomParams(int i2) {
        this.gameMode = i2;
    }
}
