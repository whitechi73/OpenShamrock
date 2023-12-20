package com.tencent.mobileqq.transfile;

public interface INetEngineListener {
    void onResp(NetResp netResp);

    void onUpdateProgeress(NetReq netReq, long j2, long j3);
}