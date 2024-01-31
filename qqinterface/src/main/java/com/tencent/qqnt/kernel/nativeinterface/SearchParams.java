package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public final class SearchParams implements IKernelModel {
    BusinessType business;
    ArrayList<Long> businessMask;
    byte[] cookie;
    Integer pageSize;

    public SearchParams() {
        this.business = BusinessType.values()[0];
        this.businessMask = new ArrayList<>();
    }

    public BusinessType getBusiness() {
        return this.business;
    }

    public ArrayList<Long> getBusinessMask() {
        return this.businessMask;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setBusiness(BusinessType businessType) {
        this.business = businessType;
    }

    public void setBusinessMask(ArrayList<Long> arrayList) {
        this.businessMask = arrayList;
    }

    public void setCookie(byte[] bArr) {
        this.cookie = bArr;
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }

    public String toString() {
        return "SearchParams{business=" + this.business + ",pageSize=" + this.pageSize + ",businessMask=" + this.businessMask + ",cookie=" + this.cookie + ",}";
    }

    public SearchParams(BusinessType businessType, Integer num, ArrayList<Long> arrayList, byte[] bArr) {
        this.business = BusinessType.values()[0];
        this.businessMask = new ArrayList<>();
        this.business = businessType;
        this.pageSize = num;
        this.businessMask = arrayList;
        this.cookie = bArr;
    }
}
