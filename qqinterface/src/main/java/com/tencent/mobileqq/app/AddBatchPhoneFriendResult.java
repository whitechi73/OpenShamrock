package com.tencent.mobileqq.app;

import java.io.Serializable;

public class AddBatchPhoneFriendResult implements Serializable {
    public static final int ALLOW_TYPE_NEED_ANSWER = 2;
    public static final int ALLOW_TYPE_REFUSE_ADD = 1;
    public static final int ALLOW_TYPE_SEND_ADD_REQ = 3;
    public static final int SEND_ADD_UP_LIMIT = 32;
    public static final int SEND_ADD_UP_LIMIT_OTHER = 33;
    public static final int SEND_REQ_ALREAY = 1;
    public static final int SEND_REQ_NO = 2;
    public static final int SEND_REQ_UNKNOWN = 0;
    public static final int SEND_SECURITY_FORCED_FAILED = 37;
    public static final int SEND_SUCCESS = 0;
    public int allowType;
    public String mobile;
    public String remark;
    public int sendReqFlag;
    public int sendResult;
}