package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class GProRoomInfo implements Serializable {
    GProViewerExt ViewerExt;
    ArrayList<GProAudienceInfo> audienceInfos;
    String programId;
    HashMap<String, String> roomIcons;
    long roomId;
    String roomName;
    String roomPv;
    int roomState;
    String screenShot;
    long serialVersionUID;
    long viewer;

    public GProRoomInfo() {
        this.serialVersionUID = 1L;
        this.roomName = "";
        this.ViewerExt = new GProViewerExt();
        this.programId = "";
        this.roomIcons = new HashMap<>();
        this.roomPv = "";
        this.audienceInfos = new ArrayList<>();
        this.screenShot = "";
    }

    public ArrayList<GProAudienceInfo> getAudienceInfos() {
        return this.audienceInfos;
    }

    public String getProgramId() {
        return this.programId;
    }

    public HashMap<String, String> getRoomIcons() {
        return this.roomIcons;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getRoomPv() {
        return this.roomPv;
    }

    public int getRoomState() {
        return this.roomState;
    }

    public String getScreenShot() {
        return this.screenShot;
    }

    public long getViewer() {
        return this.viewer;
    }

    public GProViewerExt getViewerExt() {
        return this.ViewerExt;
    }

    public String toString() {
        return "GProRoomInfo{roomId=" + this.roomId + ",roomName=" + this.roomName + ",viewer=" + this.viewer + ",roomState=" + this.roomState + ",ViewerExt=" + this.ViewerExt + ",programId=" + this.programId + ",roomIcons=" + this.roomIcons + ",roomPv=" + this.roomPv + ",audienceInfos=" + this.audienceInfos + ",screenShot=" + this.screenShot + ",}";
    }

    public GProRoomInfo(long j2, String str, long j3, int i2, GProViewerExt gProViewerExt, String str2, HashMap<String, String> hashMap, String str3, ArrayList<GProAudienceInfo> arrayList, String str4) {
        this.serialVersionUID = 1L;
        this.roomName = "";
        this.ViewerExt = new GProViewerExt();
        this.programId = "";
        this.roomIcons = new HashMap<>();
        this.roomPv = "";
        this.audienceInfos = new ArrayList<>();
        this.screenShot = "";
        this.roomId = j2;
        this.roomName = str;
        this.viewer = j3;
        this.roomState = i2;
        this.ViewerExt = gProViewerExt;
        this.programId = str2;
        this.roomIcons = hashMap;
        this.roomPv = str3;
        this.audienceInfos = arrayList;
        this.screenShot = str4;
    }
}
