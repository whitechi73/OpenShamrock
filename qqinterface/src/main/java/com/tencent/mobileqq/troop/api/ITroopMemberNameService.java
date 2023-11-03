package com.tencent.mobileqq.troop.api;

import mqq.app.api.IRuntimeService;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;

public interface ITroopMemberNameService extends IRuntimeService {
    String getTroopMemberColorNick(String str, String str2);

    String getTroopMemberName(TroopMemberInfo troopMemberInfo);

    String getTroopMemberName(String str, String str2);

    String getTroopMemberName(String str, String str2, String str3, String str4);

    String getTroopMemberName(String str, String str2, boolean z, boolean z2);

    //void getTroopMemberNameAsync(String str, String str2, a aVar);

    String getTroopMemberNameInUI(String str, String str2);

    String getTroopMemberNameRemarkFirst(String str, String str2);

    String getTroopMemberNameWithoutRemark(String str, String str2);

    String getTroopMemberNick(String str, String str2);

    String getTroopMemberNickByTroopCode(String str, String str2);
}