package com.tencent.mobileqq.activity.photo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class PhotoSendParams implements Parcelable, Serializable {
    public static final Creator<PhotoSendParams> CREATOR = new Creator<PhotoSendParams>() {

        @Override
        public PhotoSendParams createFromParcel(Parcel parcel) {
            return new PhotoSendParams(parcel);
        }

        @Override
        public PhotoSendParams[] newArray(int i) {
            return new PhotoSendParams[i];
        }
    };
    public static final int SEND_PIC_NORMAL = 0;
    public static final int SEND_PIC_QZONE = 1;
    public long fileSize;
    public int picType;
    public String rawDownloadUrl;
    public int rawHeight;
    public String rawMd5;
    public String rawPicPath;
    public int rawWidth;
    public String thumbPath;

    public PhotoSendParams(String str, String str2, String str3, long j2, int i2, int i3, String str4, int i4) {
        this.picType = 0;
        this.thumbPath = str;
        this.rawMd5 = str2;
        this.rawPicPath = str3;
        this.fileSize = j2;
        this.rawHeight = i2;
        this.rawWidth = i3;
        this.rawDownloadUrl = str4;
        this.picType = i4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PhotoSendParams:&thumbPath:" + this.thumbPath + " &rawMd5:" + this.rawMd5 + " &rawPicPath:" + this.rawPicPath + " &rawHeight:" + this.rawHeight + " &rawWidth:" + this.rawWidth + " &rawDownloadUrl:" + this.rawDownloadUrl + " &picType:" + this.picType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.thumbPath);
        parcel.writeString(this.rawMd5);
        parcel.writeString(this.rawPicPath);
        parcel.writeLong(this.fileSize);
        parcel.writeInt(this.rawHeight);
        parcel.writeInt(this.rawWidth);
        parcel.writeString(this.rawDownloadUrl);
        parcel.writeInt(this.picType);
    }

    public PhotoSendParams(Parcel parcel) {
        this.picType = 0;
        this.thumbPath = parcel.readString();
        this.rawMd5 = parcel.readString();
        this.rawPicPath = parcel.readString();
        this.fileSize = parcel.readLong();
        this.rawHeight = parcel.readInt();
        this.rawWidth = parcel.readInt();
        this.rawDownloadUrl = parcel.readString();
        this.picType = parcel.readInt();
    }
}
