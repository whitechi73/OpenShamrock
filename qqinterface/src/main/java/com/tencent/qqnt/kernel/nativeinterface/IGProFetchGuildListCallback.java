package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuild;

import java.util.ArrayList;

public interface IGProFetchGuildListCallback {
    void onFetchGuildList(int code, String reason, boolean z, byte[] cookie, ArrayList<Long> arrayList, ArrayList<GProGuild> arrayList2, ArrayList<Long> arrayList3);
}