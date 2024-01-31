package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProEncryptTextRsp extends Serializable {
    String getEncryptedText();

    boolean getIsPassed();

    String toString();
}
