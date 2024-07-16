package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class MsfMessagePair {
    public FromServiceMsg fromServiceMsg;
    public String sendProcess;
    public ToServiceMsg toServiceMsg;

    public MsfMessagePair(String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {

    }

    public MsfMessagePair(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {

    }
}