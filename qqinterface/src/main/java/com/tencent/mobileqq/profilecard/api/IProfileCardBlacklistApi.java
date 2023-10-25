package com.tencent.mobileqq.profilecard.api;

import com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener;
import com.tencent.mobileqq.qroute.QRouteApi;

public interface IProfileCardBlacklistApi extends QRouteApi {
    String getBlacklistTipMsg(String str);

    int getProfileCardBlacklistReportType(String str);

    boolean isBlackOrBlackedUin(String uin, CheckBlacklistListener checkBlacklistListener);
}