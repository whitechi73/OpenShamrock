package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;


public interface IGProVoiceSpeakModeRsp extends Serializable {
    String getConfirmExt();

    String getConfirmMsg();

    int getModCode();

    String toString();
}
