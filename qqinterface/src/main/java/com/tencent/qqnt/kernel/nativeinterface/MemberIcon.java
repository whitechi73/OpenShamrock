package com.tencent.qqnt.kernel.nativeinterface;

public class MemberIcon {
    public int bizId;
    public byte[] exInfo = new byte[0];
    public long expireTime;
    public int resId;

    public int getBizId() {
        return this.bizId;
    }

    public byte[] getExInfo() {
        return this.exInfo;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public int getResId() {
        return this.resId;
    }

    public String toString() {
        return "MemberIcon{resId=" + this.resId + ",expireTime=" + this.expireTime + ",bizId=" + this.bizId + ",exInfo=" + this.exInfo + ",}";
    }

}
