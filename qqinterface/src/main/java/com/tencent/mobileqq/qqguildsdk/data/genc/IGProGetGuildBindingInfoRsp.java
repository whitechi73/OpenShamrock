package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetGuildBindingInfoRsp extends Serializable {
    ArrayList<IGProBriefAppInfo> getBindableApps();

    ArrayList<IGProBriefAppInfo> getBoundApps();

    String toString();
}
