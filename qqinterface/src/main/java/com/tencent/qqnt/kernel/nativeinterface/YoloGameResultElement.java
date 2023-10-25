package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes.dex */
public final class YoloGameResultElement {
    ArrayList<YoloGameUserInfo> userInfo;

    public YoloGameResultElement() {
        this.userInfo = new ArrayList<>();
    }

    public ArrayList<YoloGameUserInfo> getUserInfo() {
        return this.userInfo;
    }

    public String toString() {
        return "YoloGameResultElement{userInfo=" + this.userInfo + ",}";
    }

    public YoloGameResultElement(ArrayList<YoloGameUserInfo> arrayList) {
        this.userInfo = new ArrayList<>();
        this.userInfo = arrayList;
    }
}
