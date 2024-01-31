package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProBlockUserState extends Serializable {
    ArrayList<Long> getBlockUserList();

    String toString();
}
