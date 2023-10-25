package com.tencent.qqnt.kernel.api;

import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;

import mqq.app.api.IRuntimeService;

public interface IKernelService extends IRuntimeService {
    IQQNTWrapperSession getWrapperSession();

    boolean isInit();
}
