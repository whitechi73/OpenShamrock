package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;


public  interface IGetLabelGuildsRsp extends Serializable {
    IGProLabelInfo getLabelInfo();

    String toString();
}
