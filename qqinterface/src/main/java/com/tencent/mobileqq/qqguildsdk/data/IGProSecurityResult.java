package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public interface IGProSecurityResult extends Serializable {
    long getActionCode();

     boolean getIsValidSecResult();

    String getStrDetail();

    String getStrPrompt();
}
