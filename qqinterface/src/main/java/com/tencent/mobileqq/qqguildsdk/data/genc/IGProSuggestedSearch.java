package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProSuggestedSearch extends Serializable {
    ArrayList<String> getContentList();

    String getTitle();

    String toString();
}
