package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProFetchShareInfo0x10c3Req {
    byte[] businessParam;
    int businessType;
    GProCmd0x10c3Filter filter;
    boolean isShortLink;
    ArrayList<GProURLParam> urlParams;

    public GProFetchShareInfo0x10c3Req() {
        this.businessParam = new byte[0];
        this.urlParams = new ArrayList<>();
        this.filter = new GProCmd0x10c3Filter();
    }

    public byte[] getBusinessParam() {
        return this.businessParam;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public GProCmd0x10c3Filter getFilter() {
        return this.filter;
    }

    public boolean getIsShortLink() {
        return this.isShortLink;
    }

    public ArrayList<GProURLParam> getUrlParams() {
        return this.urlParams;
    }

    public String toString() {
        return "GProFetchShareInfo0x10c3Req{businessType=" + this.businessType + ",businessParam=" + this.businessParam + ",isShortLink=" + this.isShortLink + ",urlParams=" + this.urlParams + ",filter=" + this.filter + ",}";
    }

    public GProFetchShareInfo0x10c3Req(int i2, byte[] bArr, boolean z, ArrayList<GProURLParam> arrayList, GProCmd0x10c3Filter gProCmd0x10c3Filter) {
        this.businessParam = new byte[0];
        this.urlParams = new ArrayList<>();
        this.filter = new GProCmd0x10c3Filter();
        this.businessType = i2;
        this.businessParam = bArr;
        this.isShortLink = z;
        this.urlParams = arrayList;
        this.filter = gProCmd0x10c3Filter;
    }
}
