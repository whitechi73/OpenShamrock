package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;



public interface ILiveRoomAnchorInfo extends Serializable {
    String getAnchorAvatarMeta();

    String getAnchorIcon();

    String getAnchorName();

    String getAnchorTinyId();

    long getIdVerifyTimestamp();
}
