package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProSearchItem extends Serializable {
    String getDesc();

    ArrayList<String> getGuildLogos();

    String toString();
}
