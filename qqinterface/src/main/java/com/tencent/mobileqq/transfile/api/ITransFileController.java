package com.tencent.mobileqq.transfile.api;

import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import mqq.app.api.IRuntimeService;

public interface ITransFileController extends IRuntimeService {
   // void addHandle(TransProcessorHandler transProcessorHandler);

    //@Deprecated
    //void addProcessor(String str, IHttpCommunicatorListener iHttpCommunicatorListener);

    boolean containsProcessor(String name, long uin);

    IHttpCommunicatorListener findProcessor(String str);

    IHttpCommunicatorListener findProcessor(String str, long j2);

    //TransFileControllerBusHelper getBusHelper();

    //ConcurrentHashMap<String, IHttpCommunicatorListener> getProcessMap();

    AtomicBoolean isWorking();

   // void removeHandle(TransProcessorHandler transProcessorHandler);

   // boolean removeProcessor(String str);

   // void removeProcessorByPeerUin(String str, int i2);

  //  void stop(TransferRequest transferRequest);

    boolean transferAsync(TransferRequest transferRequest);
}
