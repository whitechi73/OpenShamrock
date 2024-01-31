package com.tencent.mobileqq.qqguildsdk.data.genc;


import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRecommendTextChannel extends Serializable {
    ArrayList<String> getAvatars();

    boolean getIsActive();

    ArrayList<String> getMemberAvatars();

    //ArrayList<ew> getMsgAbstracts();

    String getMsgSummary();

    int getNoreadNum();

    String getTagMsg();

    String toString();
}
