package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProConfirmOption extends Serializable {
    String getConfirmMsg();

    ArrayList<Object> getConfirmNodes();

    String toString();
}
