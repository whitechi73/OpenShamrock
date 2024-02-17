package com.tencent.mobileqq.perf.block;

import android.os.Bundle;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import epic.EIPCClient;
import epic.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

public final class BinderMethodProxy {
    @NotNull
    public static final BinderMethodProxy INSTANCE;

    static {
        INSTANCE = new BinderMethodProxy();
    }

    @JvmStatic
    public static EIPCResult callServer(@NotNull EIPCClient client, @Nullable String module, @Nullable String action, @Nullable Bundle bundle) {
        //MainBlockMethodMonitor.onMethodStart();
        //EIPCResult callServer = client.callServer(str, str2, bundle);
        //MainBlockMethodMonitor.onMethodEnd();
        //return callServer;
        return null;
    }
}
