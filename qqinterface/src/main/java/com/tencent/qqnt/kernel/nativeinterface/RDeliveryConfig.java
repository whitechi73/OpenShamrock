package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public final class RDeliveryConfig implements IKernelModel {
    String appId;
    String appKey;
    String appVersion;
    String bundleId;
    ArrayList<String> fixedAfterHitKeys;
    String language;
    String logicEnvironment;
    String osVersion;
    int platform;
    String sdkVersion;
    String serverUrl;
    int systemId;
    String userId;
}