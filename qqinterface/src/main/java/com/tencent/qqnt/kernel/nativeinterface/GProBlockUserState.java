package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProBlockUserState {
    ArrayList<Long> blockUserList;

    public GProBlockUserState() {
        this.blockUserList = new ArrayList<>();
    }

    public ArrayList<Long> getBlockUserList() {
        return this.blockUserList;
    }

    public String toString() {
        return "GProBlockUserState{blockUserList=" + this.blockUserList + ",}";
    }

    public GProBlockUserState(ArrayList<Long> arrayList) {
        this.blockUserList = new ArrayList<>();
        this.blockUserList = arrayList;
    }
}
