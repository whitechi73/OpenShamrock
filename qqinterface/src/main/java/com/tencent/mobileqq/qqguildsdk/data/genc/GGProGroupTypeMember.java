package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGroupTypeMember;
import com.tencent.qqnt.kernel.nativeinterface.GProUser;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGroupTypeMember implements IGProGroupTypeMember {
    public final GProGroupTypeMember mInfo;

    public GGProGroupTypeMember(GProGroupTypeMember gProGroupTypeMember) {
        this.mInfo = gProGroupTypeMember;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGroupTypeMember
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGroupTypeMember
    public int getGroupType() {
        return this.mInfo.getGroupType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGroupTypeMember
    public ArrayList<IGProUserInfo> getMemberList() {
        ArrayList<GProUser> memberList = this.mInfo.getMemberList();
        ArrayList<IGProUserInfo> arrayList = new ArrayList<>();
        Iterator<GProUser> it = memberList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProUserInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGroupTypeMember
    public String toString() {
        return this.mInfo.toString();
    }
}
