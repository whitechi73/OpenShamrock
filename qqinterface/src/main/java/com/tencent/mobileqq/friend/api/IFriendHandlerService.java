package com.tencent.mobileqq.friend.api;

import android.os.Bundle;

import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.data.PhoneContact;

import java.util.ArrayList;
import java.util.List;

import mqq.app.api.IRuntimeService;

public interface IFriendHandlerService extends IRuntimeService {
    void addFriendGroup(byte id, String name);

    void cacheToken(String str, int i2, int i3, byte[] bArr);

    void deleteFriendGroup(byte b2);

    void getOnlyChatPermissionBatchByPage(int i2);

    void getPermissionSelectFriend(List<String> list, int i2, int i3);

    void getSingleFriendPermission(String str);

    boolean isRequestingFriendList();

    void renameFriendGroup(byte b2, String str);

    void requestAddBatchPhoneFriend(ArrayList<PhoneContact> arrayList, String str, int i2, int i3, ArrayList<AddBatchPhoneFriendResult> arrayList2);

    void requestAddFriend(String str, String str2, int i2, byte b2, String str3, int i3, int i4, boolean z, byte[] bArr, boolean z2, String str4, String str5);

    void requestAddFriend(String str, String str2, int i2, byte b2, String str3, int i3, int i4, boolean z, byte[] bArr, boolean z2, String str4, String str5, Bundle bundle, boolean z3);

    void requestAddFriendWithMyCard(String str, String str2, int i2, byte b2, String str3, int i3, int i4, boolean z, byte[] bArr, boolean z2, String str4, String str5, byte b3, String str6, Bundle bundle, boolean z3);

    void requestAddFriendWithMyCard(String str, String str2, int i2, byte b2, String str3, int i3, int i4, byte[] bArr, boolean z, byte[] bArr2, boolean z2, String str4, String str5, byte b3, String str6, Bundle bundle, boolean z3);

    void requestAutoInfo(String str, int i2, int i3);

    void requestFriendInfo(String str);

    void requestFriendList(boolean pullRefresh);

    void requestFriendList(boolean pullRefresh, int ntFriendListSeq);

    void requestInfoWithOpenId(String str, String str2);

    void requestUinSafetyFlag(long j2);

    void requestUserAddFriendSetting(String str, int i2, int i3, String str2);

    void requestUserAddFriendSetting(String str, int i2, int i3, String str2, int i4);

    void resortFriendGroup(byte[] bArr, byte[] bArr2);

    void setBatchFriendPermission(List<String> list, int i2);

    void setFriendPermission(String str, int i2);
}
