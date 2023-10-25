package com.tencent.qqnt.aio.adapter.api;

import com.tencent.mobileqq.qroute.QRouteApi;

public interface IAIOPttApi extends QRouteApi {
    int getPttFileDuration(String str);
}