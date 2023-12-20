package com.tencent.mobileqq.transfile.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.NetReq;

public interface IOldHttpEngineProcessor extends QRouteApi {
    //void cancelMsg(HttpMsg httpMsg);

    void cancelReq(NetReq netReq);

    //int sendMsg(HttpMsg httpMsg);

    void sendReq(NetReq netReq);
}