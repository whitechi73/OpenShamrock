package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;

import java.util.List;

import mqq.app.api.IRuntimeService;

public interface ITroopMemberInfoService extends IRuntimeService {
    List<TroopMemberInfo> getAllTroopMembers(String groupUin);

    boolean deleteTroopMembers(String groupUin);

    TroopMemberInfo getTroopMember(String groupUin, String memberUin);

    void getTroopsMemberList();

    boolean deleteTroopMember(String groupUin, String memberUin);

    boolean isMemberInCache(String groupUin, String memberUin);
}