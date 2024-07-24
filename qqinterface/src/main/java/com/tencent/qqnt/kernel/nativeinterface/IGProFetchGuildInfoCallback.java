package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuild;

public interface IGProFetchGuildInfoCallback {
    void onFetchGuildInfo(int code, String reason, GProGuild gProGuild);
}
