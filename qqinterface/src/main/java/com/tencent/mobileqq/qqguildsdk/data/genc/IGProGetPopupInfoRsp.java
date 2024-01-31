package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public interface IGProGetPopupInfoRsp extends Serializable {
    String getButtonText();

    String getFootText();

    String getGifUrl();

    String getImgUrl();

    String getTitle();

    String toString();
}
