package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGroupTypeList extends Serializable {
    long getChannelId();

    ArrayList<IGProGroupTypeMember> getGroupTypeMembers();

    String toString();
}
