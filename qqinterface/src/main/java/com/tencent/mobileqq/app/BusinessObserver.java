package com.tencent.mobileqq.app;

public interface BusinessObserver {
    void onUpdate(int result, boolean success, Object obj);
}