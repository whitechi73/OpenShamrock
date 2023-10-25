package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProLiveRoomRichTitle {
    ArrayList<GProRichTitleElement> elements;

    public GProLiveRoomRichTitle() {
        this.elements = new ArrayList<>();
    }

    public ArrayList<GProRichTitleElement> getElements() {
        return this.elements;
    }

    public String toString() {
        return "GProLiveRoomRichTitle{elements=" + this.elements + ",}";
    }

    public GProLiveRoomRichTitle(ArrayList<GProRichTitleElement> arrayList) {
        this.elements = new ArrayList<>();
        this.elements = arrayList;
    }
}
