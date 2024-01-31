package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProVoiceSmobaGameUserAction {
    long tinyId;
    int userActionType;

    public GProVoiceSmobaGameUserAction() {
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public int getUserActionType() {
        return this.userActionType;
    }

    public String toString() {
        return "GProVoiceSmobaGameUserAction{tinyId=" + this.tinyId + ",userActionType=" + this.userActionType + ",}";
    }

    public GProVoiceSmobaGameUserAction(long j2, int i2) {
        this.tinyId = j2;
        this.userActionType = i2;
    }
}
