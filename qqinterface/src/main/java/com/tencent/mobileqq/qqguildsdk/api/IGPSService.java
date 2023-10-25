package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile;

import java.util.List;

import mqq.app.api.IRuntimeService;

public interface IGPSService extends IRuntimeService {
    List<IGProGuildInfo> getGroupGuildList();

    IGProGuildInfo getGuildInfo(String str);

    List<IGProGuildInfo> getGuildList();

    String getGuildMemberName(String str, String str2);

    String getGuildName(String str);

    String getSelfTinyId();

    /* synthetic */ IGProSimpleProfile getSimpleProfile(String str, String str2, int i2);

    /* synthetic */ boolean isGProSDKInitCompleted();
}
