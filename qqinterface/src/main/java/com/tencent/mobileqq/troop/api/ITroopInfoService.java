package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.data.troop.TroopInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mqq.app.api.IRuntimeService;

public interface ITroopInfoService extends IRuntimeService {
    // 从数据库里面获取群聊信息
    // void asyncGetTroopInfo(String str, com.tencent.mobileqq.data.troop.a aVar);

    void deleteTroopList(List<String> groupList);

    void deleteTroopWithoutDB(String str, TroopInfo troopInfo);

    TroopInfo findTroopInfo(String uin);

    TroopInfo findTroopInfo(String str, boolean z);

    TroopInfo findTroopInfo(String str, boolean z, boolean z2);

    List<TroopInfo> getAllTroopList();

    long getInsertJoinTroopMsgTime(String str);

    long getSharedMsgSeq(String str);

    String getTroopCodeByTroopUin(String str);

    //void getTroopCodeByTroopUinAsync(String str, a aVar);

    TroopInfo getTroopInfo(String uin);

    TroopInfo getTroopInfoFromCache(String uin);

    ArrayList<String> getTroopMemberForTroopHead(String str);

    String getTroopNameByID(String uin);

    String getTroopUin(String str);

    String getTroopUinByTroopCode(String code);

    List<Long> getUinList();

    boolean hasNoTroop();

    boolean isCommonlyUsedTroop(String str);

    boolean isHomeworkTroop(String str);

    boolean isQidianPrivateTroop(String str);

    boolean isTroopCacheInited();

    void refreshCommonlyUsedTroop();

    boolean removeCommonlyUsedTroop(String str);

    void saveTroopInfo(TroopInfo troopInfo);

    void saveTroopInfoOnlyCacheAndDB(TroopInfo troopInfo);

    TroopInfo saveTroopName(String str, String str2);

    void saveTroops(ArrayList<TroopInfo> arrayList);

    void saveTroops(ArrayList<TroopInfo> arrayList, long j2);

    void setInsertJoinTroopMsgTime(String str, long j2);

    void setSharedMsgSeq(String str, long j2);
}
