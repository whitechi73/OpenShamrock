package com.tencent.mobileqq.qroute;

import androidx.annotation.NonNull;

public class QRoute {
    @NonNull
    public static <T extends QRouteApi> T api(Class<T> cls) {
        return null;
    }

    public static <T extends QRouteApi> T apiFromPlugin(Class<T> cls) {
        return null;
    }
}
