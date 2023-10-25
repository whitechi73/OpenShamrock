package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IKernelGuildService {
    void refreshGuildList(boolean isForced); // 只刷新id，详细信息需要额外获取

    //ArrayList<GProQQMsgListGuild> getQQMsgListGuilds(); 啥也拿不到

    void fetchGuildList(ArrayList<GProGuildReqInfo> reqInfos, byte[] cookie, int i2, IGProFetchGuildListCallback iGProFetchGuildListCallback);

    void fetchRetentionGuildList(int i2, int i3, byte[] cookie, long j2, IGProFetchRetentionGuildListCallback iGProFetchRetentionGuildListCallback);

    void addKernelGuildListener(IKernelGuildListener iKernelGuildListener);
}
