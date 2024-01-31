package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGroupTypeList;
import com.tencent.qqnt.kernel.nativeinterface.GProGroupTypeMember;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGroupTypeList implements IGProGroupTypeList {
    public final GProGroupTypeList mInfo;

    public GGProGroupTypeList(GProGroupTypeList gProGroupTypeList) {
        this.mInfo = gProGroupTypeList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGroupTypeList
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGroupTypeList
    public ArrayList<IGProGroupTypeMember> getGroupTypeMembers() {
        ArrayList<GProGroupTypeMember> groupTypeMembers = this.mInfo.getGroupTypeMembers();
        ArrayList<IGProGroupTypeMember> arrayList = new ArrayList<>();
        Iterator<GProGroupTypeMember> it = groupTypeMembers.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGroupTypeMember(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGroupTypeList
    public String toString() {
        return this.mInfo.toString();
    }
}
