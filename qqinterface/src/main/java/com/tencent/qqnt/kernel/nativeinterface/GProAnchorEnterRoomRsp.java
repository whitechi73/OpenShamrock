package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProAnchorEnterRoomRsp {
    ArrayList<GProAnchorTlv> exts;
    GProAnchorMediaInfo media;
    GProAnchorRoomInfo room;
    GProAnchorTrtcInfo trtc;
    GProAnchorUserInfo user;

    public GProAnchorEnterRoomRsp() {
        this.exts = new ArrayList<>();
    }

    public ArrayList<GProAnchorTlv> getExts() {
        return this.exts;
    }

    public GProAnchorMediaInfo getMedia() {
        return this.media;
    }

    public GProAnchorRoomInfo getRoom() {
        return this.room;
    }

    public GProAnchorTrtcInfo getTrtc() {
        return this.trtc;
    }

    public GProAnchorUserInfo getUser() {
        return this.user;
    }

    public String toString() {
        return "GProAnchorEnterRoomRsp{room=" + this.room + ",user=" + this.user + ",media=" + this.media + ",trtc=" + this.trtc + ",exts=" + this.exts + ",}";
    }

    public GProAnchorEnterRoomRsp(GProAnchorRoomInfo gProAnchorRoomInfo, GProAnchorUserInfo gProAnchorUserInfo, GProAnchorMediaInfo gProAnchorMediaInfo, GProAnchorTrtcInfo gProAnchorTrtcInfo, ArrayList<GProAnchorTlv> arrayList) {
        this.exts = new ArrayList<>();
        this.room = gProAnchorRoomInfo;
        this.user = gProAnchorUserInfo;
        this.media = gProAnchorMediaInfo;
        this.trtc = gProAnchorTrtcInfo;
        this.exts = arrayList;
    }
}
