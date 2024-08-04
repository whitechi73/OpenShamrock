package com.tencent.qqnt.trooplist;

import androidx.lifecycle.LifecycleOwner;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRouteApi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public interface ITroopListRepoApi extends QRouteApi {
    void fetchTroopLevelInfo(@NotNull String str, boolean z);

    void fetchTroopList(boolean z);

    //@NotNull
    //a<Boolean> getFetchTroopListResultLiveData();

    @NotNull
    List<TroopInfo> getSortedValidTopTroopInfoFromCache();

    @NotNull
    List<TroopInfo> getSortedValidTroopInfoFromCache();

    @NotNull
    List<TroopInfo> getTopTroopListFromCache();

    @Nullable
    TroopInfo getTroopInfoFromCache(@NotNull String str);

    @NotNull
    List<TroopInfo> getTroopListFromCache();

    //@Nullable
    //a<List<TroopInfo>> getTroopListLiveData();

    void preloadTroopList();

    void requestSetTroopTop(@NotNull LifecycleOwner lifecycleOwner, @NotNull String str, boolean z, @NotNull Function1<? super Boolean, Unit> function1);
}
