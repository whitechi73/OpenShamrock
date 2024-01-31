package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBlockUserState;

import java.util.ArrayList;

public  class GGProBlockUserState implements IGProBlockUserState {
    public final GProBlockUserState mInfo;

    public GGProBlockUserState(GProBlockUserState gProBlockUserState) {
        this.mInfo = gProBlockUserState;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockUserState
    public ArrayList<Long> getBlockUserList() {
        return this.mInfo.getBlockUserList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockUserState
    public String toString() {
        return this.mInfo.toString();
    }
}
