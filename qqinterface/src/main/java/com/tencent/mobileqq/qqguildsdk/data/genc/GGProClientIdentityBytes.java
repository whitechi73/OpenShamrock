package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProClientIdentityBytes;
import com.tencent.qqnt.kernel.nativeinterface.GProIdentity;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProClientIdentityBytes implements IGProClientIdentityBytes {
    public final GProClientIdentityBytes mInfo;

    public GGProClientIdentityBytes(GProClientIdentityBytes gProClientIdentityBytes) {
        this.mInfo = gProClientIdentityBytes;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentityBytes
    public int getClientId() {
        return this.mInfo.getClientId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentityBytes
    public ArrayList<Object> getIdentityList() {
        ArrayList<GProIdentity> identityList = this.mInfo.getIdentityList();
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProIdentity> it = identityList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProIdentity(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentityBytes
    public String toString() {
        return this.mInfo.toString();
    }
}
