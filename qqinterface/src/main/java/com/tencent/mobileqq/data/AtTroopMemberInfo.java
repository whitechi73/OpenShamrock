package com.tencent.mobileqq.data;

public class AtTroopMemberInfo {
    public short startPos = 0;
    public short textLen = 0;
    public byte flag = 0;
    public long uin = 0;
    public long channelId = 0;
    public short wExtBufLen = 0;
    public boolean isResvAttr = false;

    public boolean isIncludingAll() {
        return this.flag == 1 && this.uin == 0;
    }

    public boolean isIncludingMe(long j2) {
        return this.flag == 0 && this.uin == j2;
    }

    public boolean isValid() {
        return this.startPos >= 0 && this.textLen > 0;
    }

    public int length() {
        return this.wExtBufLen + 11;
    }
}