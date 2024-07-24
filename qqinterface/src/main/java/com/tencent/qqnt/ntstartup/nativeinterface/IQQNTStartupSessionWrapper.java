package com.tencent.qqnt.ntstartup.nativeinterface;

import java.util.HashMap;

public interface IQQNTStartupSessionWrapper {
    HashMap<String, String> getSessionIdList();

    int start();

    int stop();
}
