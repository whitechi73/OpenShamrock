package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qroute.QRouteApi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.Metadata;

public interface IQQGuildUtilApi extends QRouteApi {
    @NotNull
    String getAvatarUrl(@Nullable String str, long j2, int i2);

    boolean isUserOnLine();
}
