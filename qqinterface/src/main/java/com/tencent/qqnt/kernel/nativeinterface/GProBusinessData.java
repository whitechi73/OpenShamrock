package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProBusinessData {
    byte[] businessParam;
    int businessType;

    public GProBusinessData() {
        this.businessParam = new byte[0];
    }

    public byte[] getBusinessParam() {
        return this.businessParam;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public String toString() {
        return "GProBusinessData{businessType=" + this.businessType + ",businessParam=" + this.businessParam + ",}";
    }

    public GProBusinessData(int i2, byte[] bArr) {
        this.businessParam = new byte[0];
        this.businessType = i2;
        this.businessParam = bArr;
    }
}
