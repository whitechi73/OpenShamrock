package com.tencent.guild.api.transfile;

import androidx.annotation.Nullable;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.kernel.nativeinterface.BigDataTicket;

public interface IGuildTransFileApi extends QRouteApi {
    //@Nullable
    //ArrayList<ServerAddress> getBigDataIpList(boolean z, @Nullable IpType ipType);

    @Nullable
    BigDataTicket getBigDataTicket();

    //@Nullable
    //ArrayList<ServerAddress> getIpDirectList(@Nullable String str, @Nullable IpType ipType);

    void pullConfigIfNeed();
}