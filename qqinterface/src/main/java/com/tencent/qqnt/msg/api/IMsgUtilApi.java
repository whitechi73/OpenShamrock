package com.tencent.qqnt.msg.api;

import com.tencent.mobileqq.qroute.QRouteApi;

import org.jetbrains.annotations.NotNull;

import kotlin.Pair;

public interface IMsgUtilApi extends QRouteApi {
    Pair<Integer, Integer> getPicSizeByPath(@NotNull String str);

}