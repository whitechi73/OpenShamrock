package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProLiveEnterRoomRequest {
    String bypassData;
    String channelId;
    String extData;
    ArrayList<String> formats;
    String fromSource;
    String machineCode;
    String programId;
    String programNewId;
    Long roomId;

    public GProLiveEnterRoomRequest() {
    }

    public String getBypassData() {
        return this.bypassData;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getExtData() {
        return this.extData;
    }

    public ArrayList<String> getFormats() {
        return this.formats;
    }

    public String getFromSource() {
        return this.fromSource;
    }

    public String getMachineCode() {
        return this.machineCode;
    }

    public String getProgramId() {
        return this.programId;
    }

    public String getProgramNewId() {
        return this.programNewId;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public String toString() {
        return "GProLiveEnterRoomRequest{roomId=" + this.roomId + ",machineCode=" + this.machineCode + ",fromSource=" + this.fromSource + ",formats=" + this.formats + ",extData=" + this.extData + ",programId=" + this.programId + ",channelId=" + this.channelId + ",bypassData=" + this.bypassData + ",programNewId=" + this.programNewId + ",}";
    }

    public GProLiveEnterRoomRequest(Long l2, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5, String str6, String str7) {
        this.roomId = l2;
        this.machineCode = str;
        this.fromSource = str2;
        this.formats = arrayList;
        this.extData = str3;
        this.programId = str4;
        this.channelId = str5;
        this.bypassData = str6;
        this.programNewId = str7;
    }
}
