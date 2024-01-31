package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProClientIdentityBytes implements Serializable {
    int clientId;
    ArrayList<GProIdentity> identityList;
    long serialVersionUID;

    public GProClientIdentityBytes() {
        this.serialVersionUID = 1L;
        this.identityList = new ArrayList<>();
    }

    public int getClientId() {
        return this.clientId;
    }

    public ArrayList<GProIdentity> getIdentityList() {
        return this.identityList;
    }

    public String toString() {
        return "GProClientIdentityBytes{clientId=" + this.clientId + ",identityList=" + this.identityList + ",}";
    }

    public GProClientIdentityBytes(int i2, ArrayList<GProIdentity> arrayList) {
        this.serialVersionUID = 1L;
        this.identityList = new ArrayList<>();
        this.clientId = i2;
        this.identityList = arrayList;
    }
}
