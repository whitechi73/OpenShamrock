package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;

public class ProtoReqManagerImpl {
    public interface IProtoRespBack {
        void onProtoResp(ProtoResp protoResp, ProtoReq protoReq);
    }

    public static class ProtoResp {
        public int freeRunnalbleIndex;
        public ProtoReq req;
        public FromServiceMsg resp;
        public ProtoReqRunnable[] runs;
        public long startTime;
        public StatictisInfo statisInfo = new StatictisInfo();
        boolean processed = false;
    }

    public class ProtoReqRunnable implements Runnable {
        long finishTime;
        ProtoResp resp;
        long startTime;
        long timeOut;
        boolean activated = false;
        boolean finished = false;
        boolean scheduled = false;

        public ProtoReqRunnable() {
        }

        @Override
        public void run() {

        }
    }

    public static class ProtoReq {
        public Object busiData;
        public IProtoRespBack callback;
        public byte[] reqBody;
        ProtoResp resp;
        public String ssoCmd;
        public int tryTime = 480000;
        public int tryCount = 9;
        public int fixScheduleCount = 3;
        public int timeSpace = 25;
        public int noMsfSuggestRetryTime = 450000;
        public boolean isFastResendEnable = true;
        public boolean isNeedRemindSlowNetwork = true;

        public void setEasyRetryMode() {
            this.tryTime = 30000;
            this.tryCount = 1;
            this.fixScheduleCount = 1;
        }
    }
}
