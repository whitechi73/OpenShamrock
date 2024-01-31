package com.tencent.mobileqq.qqguildsdk.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.SOURCE)
public  @interface IFaceAuthStatusType {
    public static final int FACE_AUTH_NEED_VERIFY = 1;
    public static final int FACE_AUTH_NONE = 0;
    public static final int FACE_AUTH_VERIFIED = 2;
}
