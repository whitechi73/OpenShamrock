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

    GProGuild getGuildInfoFromCache(long guildId);

    // 第一次请求: startIndex = 0 , roleIdIndex = 2
    void fetchMemberListWithRole(long guildId, long channelId, long startIndex, long roleIndex, int count, int seq, IGProFetchMemberListWithRoleCallback cb);

    void refreshGuildInfo(long guildId, boolean force, int seq);

    void refreshGuildInfoOnly(long j2, boolean z, int i2);

    void refreshGuildUserProfileInfo(long guildId, long tinyId, int seq);

    void fetchUserInfo(long guildId, long channelId, ArrayList<Long> tinyIdList, int seq, IGProGetUserInfoCallback cb);

    @Deprecated(since = "QQ新版本不支持创建话题子频道")
    void fetchTopFeeds(long guildId, long channelId, IGProFetchTopFeedsCallback cb);

    void fetchChannelInvisibleRoleList(long guildId, long channelId, IGProFetchChannelInvisibleRoleListCallback cb);

    void fetchChannelLiveableRoleList(long guildId, long channelId, IGProFetchChannelLiveableRoleListCallback cb);

    void fetchMemberRoles(long guildId, long channelId, long tinyId, int seq, IGProFetchMemberRolesCallback cb);

    void fetchRoleListWithPermission(long guildId, int seq, IGProFetchRoleListPermissionCallback cb);

    void fetchRoleWithPermission(long guildId, long roleId, int seq, IGProFetchRolePermissionCallback cb);

    GProSimpleProfile getSimpleProfile(long guildId, long tinyId, int seq);

    GProFaceAuthInfo getFaceAuthInfo();

    String getGuildUserAvatarUrl(long guildId, long tinyId, int seq);

    String getGuildUserNickname(long guildId);

    void deleteRole(long guild, long role, IGProResultCallback cb);

    void setMemberRoles(long guild, long u1, long u2, long tinyId, ArrayList<Long> addRoles, ArrayList<Long> removeRoles, IGProResultCallback cb);

    void setRoleInfo(long guild, long role, GProRoleCreateInfo info, IGProResultCallback cb);

    void createRole(long guildId, GProRoleCreateInfo info, ArrayList<Long> initialUsers, IGProCreateRoleCallback cb);
}
