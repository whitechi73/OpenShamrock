package com.tencent.mobileqq.profilecard.api;

import android.os.Bundle;

import com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor;

import java.util.List;

import mqq.app.api.IRuntimeService;

public interface IProfileProtocolService extends IRuntimeService, IProfileProtocolConst {
    <T extends AbsProfileBusinessProcessor> T getBusinessProcessor(Class<? extends AbsProfileBusinessProcessor> cls);

    void getProfileDetail(String str, List<Short> list, int i2, Bundle bundle);

    void getProfileDetailForEdit();

    void getProfileDetailForLogin();

    void requestProfileCard(Bundle bundle);

    void requestProfileCard(String uin, String target, int i2, long j2, byte b2, long j3, long j4, byte[] bArr, String str3, long j5, int i3, byte[] bArr2, byte b3);

    void setProfileDetail(Bundle bundle);
}
