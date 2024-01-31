package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;


public  interface IGproGetOpenShareInfoRsp extends Serializable {
    String getFileId();

    String getQueryStr();

    String getSessionId();

    String toString();
}
