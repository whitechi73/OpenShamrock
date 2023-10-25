package com.tencent.mobileqq.app;

import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract class OidbWrapper {
    public abstract ToServiceMsg createToServiceMsg(String str);
}
