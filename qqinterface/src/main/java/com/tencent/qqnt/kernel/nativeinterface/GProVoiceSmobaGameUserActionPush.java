package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProVoiceSmobaGameUserActionPush {
    long currentMemberNum;
    long newLeaderId;
    long roomId;
    long seq;
    ArrayList<GProVoiceSmobaGameUserAction> userAction;

    public GProVoiceSmobaGameUserActionPush() {
        this.userAction = new ArrayList<>();
    }

    public long getCurrentMemberNum() {
        return this.currentMemberNum;
    }

    public long getNewLeaderId() {
        return this.newLeaderId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public long getSeq() {
        return this.seq;
    }

    public ArrayList<GProVoiceSmobaGameUserAction> getUserAction() {
        return this.userAction;
    }

    public String toString() {
        return "GProVoiceSmobaGameUserActionPush{roomId=" + this.roomId + ",userAction=" + this.userAction + ",newLeaderId=" + this.newLeaderId + ",currentMemberNum=" + this.currentMemberNum + ",seq=" + this.seq + ",}";
    }

    public GProVoiceSmobaGameUserActionPush(long j2, ArrayList<GProVoiceSmobaGameUserAction> arrayList, long j3, long j4, long j5) {
        this.userAction = new ArrayList<>();
        this.roomId = j2;
        this.userAction = arrayList;
        this.newLeaderId = j3;
        this.currentMemberNum = j4;
        this.seq = j5;
    }
}
