package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProClientIdentityBytes;
import com.tencent.qqnt.kernel.nativeinterface.GProIdentity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public  class GProClientIdentityByteInfo implements IGProClientIdentityByteInfo {
    private final GProClientIdentityBytes mGProClientIdentityBytes;
    private final List<IGProIdentityInfo> mGProIdentityList = new ArrayList();

    public GProClientIdentityByteInfo(GProClientIdentityBytes gProClientIdentityBytes) {
        this.mGProClientIdentityBytes = gProClientIdentityBytes;
        if (gProClientIdentityBytes != null) {
            Iterator<GProIdentity> it = gProClientIdentityBytes.getIdentityList().iterator();
            while (it.hasNext()) {
                this.mGProIdentityList.add(new GProIdentityInfo(it.next()));
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo
    public int getClientId() {
        return this.mGProClientIdentityBytes.getClientId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo
    public List<IGProIdentityInfo> getIdentityList() {
        return this.mGProIdentityList;
    }
}
