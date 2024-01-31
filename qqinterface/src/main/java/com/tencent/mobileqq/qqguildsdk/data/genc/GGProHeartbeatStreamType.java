package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProHeartbeatStreamType {
    public static final int STREAM_TYPE_FLV = 4;
    public static final int STREAM_TYPE_HLS = 5;
    public static final int STREAM_TYPE_NO = 1;
    public static final int STREAM_TYPE_QWERTC = 3;
    public static final int STREAM_TYPE_TRTC = 2;
    public static final int STREAM_TYPE_UNKNOWN = 0;
}
