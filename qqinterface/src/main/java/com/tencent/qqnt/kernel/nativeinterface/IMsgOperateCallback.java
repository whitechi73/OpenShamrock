package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IMsgOperateCallback {
    void onResult(int code, String why, ArrayList<MsgRecord> msgs);
}