package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IGetMultiMsgCallback {
    void onResult(int code, String why, ArrayList<MsgRecord> msgList);
}