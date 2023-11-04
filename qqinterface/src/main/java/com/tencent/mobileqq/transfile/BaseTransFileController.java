package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;

import java.util.concurrent.atomic.AtomicBoolean;

import mqq.app.AppRuntime;

public class BaseTransFileController implements ITransFileController {
    @Override
    public boolean containsProcessor(String name, long uin) {
        return false;
    }

    @Override
    public IHttpCommunicatorListener findProcessor(String str) {
        return null;
    }

    @Override
    public IHttpCommunicatorListener findProcessor(String str, long j2) {
        return null;
    }

    @Override
    public AtomicBoolean isWorking() {
        return null;
    }

    @Override
    public synchronized boolean transferAsync(TransferRequest transferRequest) {
        return false;
    }

    @Override
    public void onCreate(AppRuntime appRuntime) {

    }

    @Override
    public void onDestroy() {

    }
}
