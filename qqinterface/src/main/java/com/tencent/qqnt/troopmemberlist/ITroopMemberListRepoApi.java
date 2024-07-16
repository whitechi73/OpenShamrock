package com.tencent.qqnt.troopmemberlist;

import androidx.lifecycle.LifecycleOwner;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qroute.QRouteApi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public interface ITroopMemberListRepoApi extends QRouteApi {
    //void fetchGagTroopMemberInfo(@Nullable String str, @Nullable LifecycleOwner lifecycleOwner, boolean z, @NotNull String str2, @Nullable f fVar);

    //void fetchTroopMemberInfo(@Nullable String str, @Nullable String str2, boolean z, @Nullable LifecycleOwner lifecycleOwner, @NotNull String str3, @Nullable g gVar);

    //void fetchTroopMemberInfoWithExtInfo(@Nullable String str, @Nullable String str2, boolean z, @Nullable LifecycleOwner lifecycleOwner, @NotNull String str3, @Nullable g gVar);

    //void fetchTroopMemberList(@Nullable String str, @Nullable LifecycleOwner lifecycleOwner, boolean z, @NotNull String str2, @Nullable f fVar);

    //void fetchTroopMemberListWithExtInfo(@Nullable String str, @Nullable LifecycleOwner lifecycleOwner, boolean z, @NotNull String str2, @Nullable f fVar);



    void fetchTroopMemberName(@Nullable String str, @Nullable String str2, @Nullable LifecycleOwner lifecycleOwner, @NotNull String str3, @Nullable Function1<? super TroopMemberNickInfo, Unit> cb);

    void fetchTroopMemberName(@Nullable String str, @Nullable String str2, @NotNull String str3, @Nullable Function1<? super TroopMemberNickInfo, Unit> cb);



    void fetchTroopMemberUid(@Nullable String str, @NotNull Function2<? super Boolean, ? super String, Unit> function2);

    void fetchTroopMemberUid(@NotNull List<String> list, @NotNull Function2<? super Boolean, ? super Map<String, String>, Unit> function2);

    void fetchTroopMemberUin(@Nullable String str, @NotNull Function2<? super Boolean, ? super String, Unit> function2);

    void fetchTroopMemberUin(@NotNull List<String> list, @NotNull Function2<? super Boolean, ? super Map<String, String>, Unit> function2);

    //void fetchTroopMemberUinListInfo(@Nullable String str, @Nullable List<String> list, boolean z, @Nullable LifecycleOwner lifecycleOwner, @NotNull String str2, @Nullable f fVar);

    //void fetchTroopMemberUinListInfoWithExtInfo(@Nullable String str, @Nullable List<String> list, boolean z, @Nullable LifecycleOwner lifecycleOwner, @NotNull String str2, @Nullable f fVar);

    //@Nullable
    //TroopMemberInfo getTroopMemberFromCacheOrFetchAsync(@Nullable String str, @Nullable String str2, @Nullable LifecycleOwner lifecycleOwner, @NotNull String str3, @Nullable g gVar);

    int getTroopMemberInfoDBVersion();

    @Deprecated(message = "兼容旧逻辑，过渡用，新逻辑不要使用")
    @Nullable
    TroopMemberInfo getTroopMemberInfoSync(@Nullable String groupId, @Nullable String userId, @Nullable LifecycleOwner lifecycleOwner, @NotNull String from);

    //@Deprecated(message = "兼容旧逻辑，过渡用，新逻辑不要使用")
    //@Nullable
    //TroopMemberInfo getTroopMemberInfoSync(@Nullable String str, @Nullable String str2, @Nullable LifecycleOwner lifecycleOwner, @NotNull String str3, long j);

    //@Deprecated(message = "兼容旧逻辑，过渡用，新逻辑不要使用")
    //@Nullable
    //TroopMemberInfo getTroopMemberWithExtFromCacheOrFetchAsync(@Nullable String str, @Nullable String str2, @Nullable LifecycleOwner lifecycleOwner, @NotNull String str3, @Nullable g gVar);

    //@Deprecated(message = "兼容旧逻辑，过渡用，新逻辑不要使用")
    //@Nullable
    //TroopMemberInfo getTroopMemberWithExtInfoSync(@Nullable String str, @Nullable String str2, @Nullable LifecycleOwner lifecycleOwner, @NotNull String str3);

    boolean isTroopMemberInfoDBInited(@NotNull String str);

    //void preLoadTroopMemberUinListInfo(@Nullable String str, @Nullable List<String> list, boolean z, @Nullable LifecycleOwner lifecycleOwner, @NotNull String str2, @Nullable f fVar);
}
