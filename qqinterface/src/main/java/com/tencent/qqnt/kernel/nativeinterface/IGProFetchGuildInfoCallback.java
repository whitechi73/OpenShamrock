package com.tencent.qqnt.kernel.nativeinterface;

public interface IGProFetchGuildInfoCallback {
    void onFetchGuildInfo(int code, String reason, GProGuild gProGuild);
}
