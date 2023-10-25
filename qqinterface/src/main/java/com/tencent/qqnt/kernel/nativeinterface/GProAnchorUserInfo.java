package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProAnchorUserInfo {
    String businessUid;
    Long explicitId;
    String head;
    Long id;
    Integer initialClientType;
    String name;
    Long tinyId;

    public GProAnchorUserInfo() {
    }

    public String getBusinessUid() {
        return this.businessUid;
    }

    public Long getExplicitId() {
        return this.explicitId;
    }

    public String getHead() {
        return this.head;
    }

    public Long getId() {
        return this.id;
    }

    public Integer getInitialClientType() {
        return this.initialClientType;
    }

    public String getName() {
        return this.name;
    }

    public Long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProAnchorUserInfo{id=" + this.id + ",explicitId=" + this.explicitId + ",name=" + this.name + ",head=" + this.head + ",initialClientType=" + this.initialClientType + ",businessUid=" + this.businessUid + ",tinyId=" + this.tinyId + ",}";
    }

    public GProAnchorUserInfo(Long l2, Long l3, String str, String str2, Integer num, String str3, Long l4) {
        this.id = l2;
        this.explicitId = l3;
        this.name = str;
        this.head = str2;
        this.initialClientType = num;
        this.businessUid = str3;
        this.tinyId = l4;
    }
}
