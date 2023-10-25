package com.tencent.mobileqq.transfile.api;

import android.content.Intent;

import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.qphone.base.remote.FromServiceMsg;

import mqq.app.api.IRuntimeService;

public interface IProtoReqManager extends IRuntimeService {
    void cancelReq(ProtoReqManagerImpl.ProtoReq protoReq);

    void onReceive(Intent intent, FromServiceMsg fromServiceMsg);

    void scheduleRunnable(ProtoReqManagerImpl.ProtoReqRunnable protoReqRunnable, long j2);

    void sendProtoReq(ProtoReqManagerImpl.ProtoReq protoReq);
}