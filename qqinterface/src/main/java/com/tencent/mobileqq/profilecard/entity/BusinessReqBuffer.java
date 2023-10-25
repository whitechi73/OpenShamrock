package com.tencent.mobileqq.profilecard.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class BusinessReqBuffer implements Parcelable {
    public static final Parcelable.Creator<BusinessReqBuffer> CREATOR = new Parcelable.Creator<BusinessReqBuffer>() { // from class: com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer.1
        @Override
        public BusinessReqBuffer createFromParcel(Parcel parcel) {
            return new BusinessReqBuffer(parcel);
        }

        @Override //
        public BusinessReqBuffer[] newArray(int i2) {
            return new BusinessReqBuffer[i2];
        }
    };
    private byte[] buffer;
    private int businessType;

    public BusinessReqBuffer(int i2, byte[] bArr) {
        this.businessType = i2;
        this.buffer = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public void setBuffer(byte[] bArr) {
        this.buffer = bArr;
    }

    public void setBusinessType(int i2) {
        this.businessType = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.businessType);
        parcel.writeByteArray(this.buffer);
    }

    protected BusinessReqBuffer(Parcel parcel) {
        this.businessType = parcel.readInt();
        parcel.readByteArray(this.buffer);
    }
}