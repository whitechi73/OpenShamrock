package com.tencent.qqnt.kernel.nativeinterface;



public final class UnreadCnt {
    int cnt;
    int type;

    public UnreadCnt() {
    }

    public int getCnt() {
        return this.cnt;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "UnreadCnt{type=" + this.type + ",cnt=" + this.cnt + ",}";
    }

    public UnreadCnt(int i2, int i3) {
        this.type = i2;
        this.cnt = i3;
    }
}
