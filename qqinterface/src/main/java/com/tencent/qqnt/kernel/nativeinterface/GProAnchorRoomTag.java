package com.tencent.qqnt.kernel.nativeinterface;



/* loaded from: classes2.dex */
public final class GProAnchorRoomTag {
    String text;
    Integer type;
    String url;

    public GProAnchorRoomTag() {
    }

    public String getText() {
        return this.text;
    }

    public Integer getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProAnchorRoomTag{type=" + this.type + ",text=" + this.text + ",url = " + this.url + ",}";
    }

    public GProAnchorRoomTag(Integer num, String str, String str2) {
        this.type = num;
        this.text = str;
        this.url = str2;
    }
}
