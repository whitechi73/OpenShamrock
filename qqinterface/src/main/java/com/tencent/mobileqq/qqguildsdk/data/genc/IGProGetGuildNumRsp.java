package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGetGuildNumRsp extends Serializable {
    IGProGuildNumInfo getGuildNumInfo();

    String toString();
}
