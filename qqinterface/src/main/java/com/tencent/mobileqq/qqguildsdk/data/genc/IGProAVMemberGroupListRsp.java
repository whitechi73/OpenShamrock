package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;


public interface IGProAVMemberGroupListRsp extends Serializable {
    IGProChannelUserNum getChannelUserNum();

    IGProGroupTypeList getGroupTypeList();

    long getNextReadInterval();

    String toString();
}
