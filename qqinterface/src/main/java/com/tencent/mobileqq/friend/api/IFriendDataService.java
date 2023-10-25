package com.tencent.mobileqq.friend.api;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;

import java.util.List;

import mqq.app.api.IRuntimeService;

public interface IFriendDataService extends IRuntimeService {
    //List<Groups> asyncGetGroupList(a aVar);

    Friends deleteFriend(String uin);

    List<Friends> getAllFriends();

    List<Friends> getAllFriends(boolean ignoreGirl);

    //void getFriend(String str, b<Friends> bVar);

    int getFriendCount();

    Friends getFriendFromMemoryCache(String str);

    List<Friends> getFriendList(int i2);

    Groups getGroup(int i2);

    Groups getGroup(int i2, boolean z);

    List<Groups> getGroupList();

    void initFriendCache();

   // void initFriendCache(c cVar);

    void initGroupCache();

    boolean isFriend(String str);

    boolean isFriend(String str, boolean z);

    boolean isInitFinished();

    void moveFriendToNewGroup(String str, int i2);

    void moveGroup(int i2, int i3);

    List<Friends> preloadPartFriendCache(List<String> list);

    boolean saveFriend(Friends friends);

    void saveFriendCache(Friends friends);

    boolean saveFriendList(List<Friends> list);

    boolean saveFriendList(List<Friends> list, boolean z, long j2);

    boolean saveGroup(Groups groups);

    boolean saveGroupList(List<Groups> list);

    void setNtRequestFriendListSeq(int i2);

    void updateGroupSortIds(byte[] bArr, byte[] bArr2);
}
