package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IKernelGuildService {
    void refreshGuildList(boolean isForced); // 只刷新id，详细信息需要额外获取

    //ArrayList<GProQQMsgListGuild> getQQMsgListGuilds(); 啥也拿不到

    void fetchGuildList(ArrayList<GProGuildReqInfo> reqInfos, byte[] cookie, int i2, IGProFetchGuildListCallback iGProFetchGuildListCallback);

    void fetchRetentionGuildList(int i2, int i3, byte[] cookie, long j2, IGProFetchRetentionGuildListCallback iGProFetchRetentionGuildListCallback);

    void fetchUserJoinedGuildList(long guildId, long tinyId, String cookie, IGProFetchUserJoinedGuildListCallback cb);

    void addKernelGuildListener(IKernelGuildListener iKernelGuildListener);

    void GetMemberInfoByOpenId(String str, long j2, boolean z, boolean z2, IGProGetMemberInfoByOpenIdCallback iGProGetMemberInfoByOpenIdCallback);

    ArrayList<GProGuild> getGroupGuildListFromCache();

    ArrayList<GProGuild> getGuildListFromCache();

    void fetchAddGuildInfo(int appId, long guildId, IGProAddGuildInfoCallBack iGProAddGuildInfoCallBack);

    void fetchGuildInfo(long guildId, int seq, IGProFetchGuildInfoCallback iGProFetchGuildInfoCallback);

    //void fetchGuildInfoByAppIdentity(GProGuildIdentity gProGuildIdentity, String str, String str2, IGProFetchGuildInfoByAppIdentityCallback iGProFetchGuildInfoByAppIdentityCallback);

    void fetchGuildInfoForGuest(long guildId, int seq, IGProFetchGuildInfoCallback cb);

    //void fetchGuestGuildInfoWithChannelList(String guildId, String str2, int i2, int seq, String str3,
    //                                        IGProFetchGuestGuildInfoWithChannelListCallback iGProFetchGuestGuildInfoWithChannelListCallback);

    GProGuild getGuildInfoFromCache(long j2);

    // 第一次请求: startIndex = 0 , roleIdIndex = 2
    void fetchMemberListWithRole(long guildId, long channelId, long startIndex, long roleIndex, int count, int seq, IGProFetchMemberListWithRoleCallback cb);

    void refreshGuildInfo(long guildId, boolean force, int seq);

    void refreshGuildInfoOnly(long j2, boolean z, int i2);

    void fetchUserInfo(long j2, long j3, ArrayList<Long> tinyIdList, int i2, IGProGetUserInfoCallback iGProGetUserInfoCallback);

    GProSimpleProfile getSimpleProfile(long guildId, long tinyId, int seq);

    GProFaceAuthInfo getFaceAuthInfo();

    String getGuildUserAvatarUrl(long guildId, long tinyId, int seq);

    String getGuildUserNickname(long guildId);
}
