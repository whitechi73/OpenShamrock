package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProBatchGetBlockItemRsp extends Serializable {
    byte[] getCookies();

    boolean getIsEnd();

    ArrayList<IGProBlockInfo> getItems();

    String getMsg();

    String getTraceId();

    String toString();
}
