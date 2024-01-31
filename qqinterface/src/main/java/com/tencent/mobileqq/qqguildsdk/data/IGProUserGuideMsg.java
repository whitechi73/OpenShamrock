package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public interface IGProUserGuideMsg extends Serializable {
    IGProUserGuideBubble getBubble();

    int getScene();
}
