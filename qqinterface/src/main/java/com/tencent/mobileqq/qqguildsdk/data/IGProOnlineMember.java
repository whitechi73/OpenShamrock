package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.List;


public interface IGProOnlineMember extends Serializable {
    String getGuildId();

    String getHotIcon();

    @Deprecated
    String getMemberCnt();

    @Deprecated
    String getMemberTitle();

    List<String> getOnlineMemberAvatars();

    String getOnlineMemberCnt();

    String toString();
}
