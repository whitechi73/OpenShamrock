package com.tencent.mobileqq.qqguildsdk.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;
import com.tencent.mobileqq.qqguildsdk.data.GProLocationInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProOnlineMember;
import com.tencent.mobileqq.qqguildsdk.data.IGProStickyChannel;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentity;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildUserState;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedal;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPersonalSignatureTemplate;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEssenceSvrRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mqq.app.api.IRuntimeService;


public interface IGPSService extends IRuntimeService {
     void addChannelSubscribeBubbleShow(String str, String str2);

     //void addGuild(String str, GuildSourceId guildSourceId, String str2, bv bvVar);

    // void addGuildStateListener(@NonNull bt btVar);

     //void addGuildWithOption(String str, GuildSourceId guildSourceId, String str2, String str3, String str4, bv bvVar);

    // void addGuilds(ArrayList<bk> arrayList, ca caVar, ci ciVar);

    // void addGuildsForGrowth(String str, ArrayList<bk> arrayList, ci ciVar);

    @Deprecated(since = "不可继承实现GPServiceObserver内部很多混淆类")
     void addObserver(GPServiceObserver gPServiceObserver);

    // void addSpeakOrderByUser(cg cgVar, dd ddVar);

    // void addUserToGuildBlackList(String str, List<String> list, @Nullable fe feVar, cc ccVar);

    // void appAuthorization(String str, com.tencent.mobileqq.i2.a.a aVar);

    // void authScreenShared(String str, String str2, cn cnVar);

    // void batchGetBlockItem(g gVar, com.tencent.mobileqq.i2.a.a.c cVar);

    // void batchGetGuildDetail(am amVar, bm bmVar);

    // void batchGetItemDetail(am amVar, bm bmVar);

    // void batchSetBoolField(String str, HashMap<Integer, Boolean> hashMap, @NonNull cb cbVar);

    // void batchSetIntField(String str, HashMap<Integer, Integer> hashMap, @NonNull cb cbVar);

    // void batchUpdateChannelsMsgNotifyType(String str, List<h> list, com.tencent.mobileqq.i2.a.c cVar);

    // void beforehandGetGuildSpeakPermission(long j2, int i2, com.tencent.mobileqq.i2.a.a.d dVar);

    // void bindAppRole(String str, String str2, int i2, com.tencent.mobileqq.i2.a.d dVar);

    // void cancelChannelTopMsg(String str, String str2, ArrayList<Long> arrayList, @NonNull cb cbVar);

    //@Override // com.tencent.mobileqq.qqguildsdk.api.a
    // void cancelSpeakOrderByAdmin(com.tencent.mobileqq.qqguildsdk.data.genc.e eVar, com.tencent.mobileqq.i2.a.a.b bVar);

    //@Override // com.tencent.mobileqq.qqguildsdk.api.a
    // void cancelUserHandUpForAdmin(com.tencent.mobileqq.qqguildsdk.data.genc.e eVar, com.tencent.mobileqq.i2.a.a.b bVar);

    // void changeChannelCategoryName(String str, long j2, String str2, bh bhVar);

    // void changeGuildAllowSearch(String str, boolean z, cq cqVar);

    // void changeUserDevStateForAdmin(com.tencent.mobileqq.qqguildsdk.data.genc.e eVar, com.tencent.mobileqq.i2.a.a.b bVar);

    //@Override // com.tencent.mobileqq.qqguildsdk.api.a
    // void checkAVState(cg cgVar, dd ddVar);

    // void checkAndEncryptText(r rVar, com.tencent.mobileqq.i2.a.a.f fVar);

    // void checkIsStrangerNewMember(com.tencent.mobileqq.i2.a.a.g gVar);

    // void checkLobbyAppAuthStatus(String str, long j2, long j3, com.tencent.mobileqq.i2.a.a.h hVar);

    // void checkPreventAddiction(bq bqVar, cl clVar);

    //void checkSelfRealNameVerified(com.tencent.mobileqq.i2.a.g gVar);

    // void checkUserBannedSpeakInChannel(String str, String str2, String str3, com.tencent.mobileqq.i2.a.h hVar);

    // void checkUserFreeGiftInfo(com.tencent.mobileqq.qqguildsdk.data.genc.ci ciVar, i iVar);

     void clearGuildRelatedData(ArrayList<Long> arrayList);

    // void clearNoticeRedPoint(int i2, cb cbVar);

    // void closeAVLobbyApp(long j2, long j3, long j4, n nVar);

    // void closeChannelActivitySwitch(long j2, da daVar);

    // void closeChannelTopMsg(String str, String str2, @NonNull cb cbVar);

    // void closeEasySubscribeList(da daVar);

    // void closeSpeakingByUser(cg cgVar, dd ddVar);

    // void convertGuildAndThirdIds(com.tencent.mobileqq.qqguildsdk.data.genc.n nVar, k kVar);

   //  void createChannel(String str, com.tencent.mobileqq.qqguildsdk.data.f fVar, long j2, com.tencent.mobileqq.i2.a.i iVar);

    // void createChannelCategory(String str, String str2, bh bhVar);

    /*
     void createDirectMsgSession(@NonNull j jVar, @NonNull com.tencent.mobileqq.i2.a.j jVar2);

     void createLinkChannel(String str, com.tencent.mobileqq.qqguildsdk.data.f fVar, long j2, bd bdVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.e
     void createRole(String str, @NonNull ff ffVar, @NonNull List<String> list, @NonNull com.tencent.mobileqq.i2.a.k kVar);

     void createSchedule(String str, String str2, GuildScheduleInfo guildScheduleInfo, cd cdVar);

     void createScheduleLimitQuery(String str, ce ceVar);

     void customForumChannelSortMode(String str, String str2, int i2, @NonNull cc ccVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.a
     void dealHandUpRequestForAdmin(com.tencent.mobileqq.qqguildsdk.data.genc.e eVar, boolean z, com.tencent.mobileqq.i2.a.a.b bVar);

     void dealNotice(String str, String str2, l lVar);

     void decodeInviteJumpInfo(String str, m mVar);

     void deleteGuildEssence(bb bbVar, com.tencent.mobileqq.i2.a.a.cg cgVar);

     void deleteGuildGlobalBanner(ay ayVar, com.tencent.mobileqq.i2.a.a.cd cdVar);

     void deleteGuildStickyChannel(String str, String str2, com.tencent.mobileqq.i2.a.bb bbVar);*/

     void deleteObserver(GPServiceObserver gPServiceObserver);

    /*@Override // com.tencent.mobileqq.qqguildsdk.api.e
     void deleteRole(String str, String str2, @NonNull cc ccVar);

     void destroyGuild(String str, cq cqVar);

     void doLikeCommentForFeed(p pVar, o oVar);

     void doLikeForFeed(q qVar, o oVar);

     void doRealNameAuth(int i2, br brVar);

     void domainResolveByLocalDns(String str);

     void editSchedule(String str, String str2, GuildScheduleInfo guildScheduleInfo, int i2, cf cfVar);

     void enterAudioLiveChannel(s sVar, com.tencent.mobileqq.i2.a.a.p pVar);

     void enterAudioLiveChannelAndCallbackDirect(s sVar, com.tencent.mobileqq.i2.a.a.p pVar);

     void exitAudioLiveChannel(long j2, long j3, int i2, ArrayList<String> arrayList, com.tencent.mobileqq.i2.a.a.q qVar);

     void exitRecommendGuild(long j2, da daVar);

     void exitYLGameTeam(String str, String str2, long j2, da daVar);

     void exposeRecommends(v vVar, da daVar);

     void fetchActiveChannels(String str, com.tencent.mobileqq.i2.a.a.r rVar);

     void fetchAddGuildInfo(int i2, long j2, com.tencent.mobileqq.i2.a.a.a aVar);

     void fetchAppInfos(String str, com.tencent.mobileqq.i2.a.a.s sVar);

     void fetchArchiveArkData(String str, String str2, byte[] bArr, int i2, com.tencent.mobileqq.i2.a.n nVar);

     void fetchAudioLiveChannelBlockUserState(long j2, long j3, w wVar);

     void fetchAudioLiveChannelGroupList(com.tencent.mobileqq.qqguildsdk.data.genc.c cVar, u uVar);

     void fetchAudioLiveChannelGroupListAndCallbackDirect(com.tencent.mobileqq.qqguildsdk.data.genc.c cVar, u uVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.a
     void fetchAudioLiveChannelUserList(com.tencent.mobileqq.qqguildsdk.data.genc.f fVar, com.tencent.mobileqq.i2.a.a.v vVar);

     void fetchCategoryAdminInfoList(ab abVar, x xVar);

     void fetchCategoryAdminMemberList(String str, String str2, String str3, int i2, boolean z, @NonNull at atVar);

     void fetchChannelAdminInfoList(String str, @NonNull com.tencent.mobileqq.i2.a.e eVar);

     void fetchChannelAdminInfoList(String str, String str2, @NonNull com.tencent.mobileqq.i2.a.e eVar);

     void fetchChannelAdminMemberList(String str, String str2, String str3, int i2, boolean z, @NonNull at atVar);

     void fetchChannelAuthControlMemberList(long j2, long j3, int i2, byte[] bArr, int i3, y yVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.a
     void fetchChannelAuthControlRoleList(long j2, long j3, int i2, z zVar);

     void fetchChannelAuthControlUnableMemberList(long j2, long j3, int i2, byte[] bArr, int i3, aa aaVar);

     void fetchChannelAuthControlUnableRoleList(long j2, long j3, int i2, com.tencent.mobileqq.i2.a.a.ab abVar);

     void fetchChannelInfoWithCategory(String str, String str2, int i2, com.tencent.mobileqq.i2.a.p pVar);

     void fetchChannelList(String str, com.tencent.mobileqq.i2.a.q qVar);

     void fetchChannelListForJump(long j2, bc bcVar);

     void fetchChannelLiveableMemberList(String str, String str2, int i2, @NonNull byte[] bArr, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.f fVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.c
     void fetchChannelLiveableRoleList(String str, String str2, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.g gVar);

     void fetchChannelUnlivableMemberList(String str, String str2, int i2, @NonNull byte[] bArr, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.j jVar);

     void fetchChannelUnlivableRoleList(String str, String str2, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.k kVar);

     void fetchChannelUserPermission(String str, String str2, int i2, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.n nVar);

     void fetchChannelVisibleRoleListWithoutLevelRole(long j2, long j3, ac acVar);

     void fetchComments(String str, String str2, long j2, long j3, long j4, long j5, com.tencent.mobileqq.i2.a.r rVar);

     void fetchDirectMsgBlack(String str, @NonNull com.tencent.mobileqq.i2.a.s sVar);

     void fetchDirectMsgStatus(@NonNull t tVar);

     void fetchDiscoverRed(com.tencent.mobileqq.qqguildsdk.data.genc.ac acVar, ad adVar);

     void fetchEnterChannelPermission(String str, String str2, String str3, ae aeVar);

     void fetchFeedsNotifySwitch(com.tencent.mobileqq.i2.a.m mVar);

     void fetchGlobalPrivacySwitch(com.tencent.mobileqq.i2.a.a.ce ceVar);

     void fetchGuestGuild(String str, boolean z, com.tencent.mobileqq.i2.a.u uVar);

     void fetchGuestGuildWithChannelListAndJoinSig(String str, String str2, int i2, int i3, String str3, com.tencent.mobileqq.i2.a.v vVar);

     void fetchGuildActiveValue(long j2, com.tencent.mobileqq.i2.a.a.cf cfVar);

     void fetchGuildBlackList(String str, byte[] bArr, af afVar);

     void fetchGuildBottomTabExp(com.tencent.mobileqq.qqguildsdk.data.genc.j jVar, ag agVar);

    void fetchGuildInfoByAppIdentity(bz bzVar, String str, String str2, com.tencent.mobileqq.i2.a.w wVar);

    void fetchGuildInfoByInviteCode(String str, com.tencent.mobileqq.i2.a.ac acVar);

    void fetchGuildInfoByInviteCodeAndContentID(String str, String str2, String str3, int i2, com.tencent.mobileqq.i2.a.ab abVar);

     void fetchGuildInfoOnly(String str, int i2, com.tencent.mobileqq.i2.a.x xVar);

     void fetchGuildInfoWithSource(String str, int i2, com.tencent.mobileqq.i2.a.x xVar);

    void fetchGuildSearchRecommend(byte[] bArr, cp cpVar);

     void fetchGuildSearchSwitch(String str, @NonNull com.tencent.mobileqq.i2.a.y yVar);

     void fetchGuildSpeakableMemberList(String str, boolean z, byte[] bArr, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.p pVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.e
     void fetchGuildSpeakableRoleList(String str, boolean z, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.q qVar);

     void fetchGuildSpeakableRule(String str, aw awVar);

     void fetchGuildSpeakableThreshold(String str, com.tencent.mobileqq.i2.a.z zVar);

     void fetchIsLiveChannelOpen(String str, com.tencent.mobileqq.i2.a.ad adVar);

     void fetchIsVoiceChannelOpen(String str, com.tencent.mobileqq.i2.a.ae aeVar);

     void fetchJumpInfo(long j2, ai aiVar);

     void fetchLatestComments(String str, String str2, long j2, long j3, com.tencent.mobileqq.i2.a.r rVar);

     void fetchLevelRolePermissions(long j2, int i2, aj ajVar);

     void fetchLiveChannelAnchorList(String str, String str2, com.tencent.mobileqq.i2.a.af afVar);

     void fetchLiveChannelBannedUserList(String str, String str2, String str3, com.tencent.mobileqq.i2.a.ag agVar);

     void fetchLiveRoomInfoByChannelIds(String str, List<String> list, ah ahVar);

     void fetchLiveRoomInfoByRoomIds(List<String> list, ah ahVar);

     void fetchLiveSecurityTips(com.tencent.mobileqq.i2.a.ai aiVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.e
     void fetchMemberListWithRole(String str, String str2, int i2, boolean z, @NonNull com.tencent.mobileqq.i2.a.aj ajVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.e
     void fetchMemberRoleList(String str, String str2, String str3, int i2, @NonNull al alVar);

     void fetchMyCreateGuilds(ak akVar);

     void fetchNewestNotice(int i2, @NonNull com.tencent.mobileqq.i2.a.am amVar);

     void fetchNonRoleMemberList(String str, String str2, String str3, String str4, int i2, boolean z, @NonNull an anVar);

     void fetchNoticeRedPoint(List<Integer> list, ap apVar);

     void fetchOnlineUsers(String str, int i2, int i3, ArrayList<Long> arrayList, com.tencent.mobileqq.i2.a.a.al alVar);

     void fetchOtherChannelUserPermission(long j2, long j3, long j4, int i2, int i3, com.tencent.mobileqq.i2.a.a.e eVar);

     void fetchPlusPanelBot(bp bpVar, com.tencent.mobileqq.i2.a.a.am amVar);

     void fetchProfileAddFriendField(String str, String str2, com.tencent.mobileqq.i2.a.a.an anVar);

     void fetchRecommendChannel(int i2, int i3, aq aqVar);

     void fetchRecommendEssenceInfo(long j2, int i2, ao aoVar);

     void fetchRemainAtSetInfo(long j2, com.tencent.mobileqq.i2.a.a.t tVar);

    void fetchRemainAtSetInfo(String str, com.tencent.mobileqq.i2.a.o oVar);

     void fetchRetentionGuildList(int i2, int i3, byte[] bArr, long j2, com.tencent.mobileqq.i2.a.a.ap apVar);

     void fetchRole(String str, String str2, boolean z, int i2, @NonNull ar arVar);

     void fetchRoleList(String str, int i2, int i3, @NonNull as asVar);

     void fetchRoleList(String str, int i2, @NonNull as asVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.c
     void fetchRoleListWithPermission(String str, int i2, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.a aVar);

     void fetchRoleListWithoutLevelRoleWithFilter(long j2, int i2, int i3, com.tencent.mobileqq.i2.a.a.aq aqVar);

     void fetchRoleMemberList(String str, String str2, int i2, boolean z, @NonNull at atVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.c
     void fetchRoleWithPermission(String str, String str2, int i2, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.b bVar);

     void fetchShareButtonReq(ArrayList<Long> arrayList, boolean z, com.tencent.mobileqq.i2.a.a.j jVar);

    void fetchShareInfo(String str, String str2, int i2, byte[] bArr, boolean z, ArrayList<com.tencent.mobileqq.qqguildsdk.data.genc.cd> arrayList, com.tencent.mobileqq.qqguildsdk.data.genc.l lVar, av avVar);

     void fetchShareInfo0x10c3(long j2, long j3, com.tencent.mobileqq.qqguildsdk.data.genc.ad adVar, com.tencent.mobileqq.i2.a.a.ar arVar);

     void fetchShareUrlReq(long j2, long j3, long j4, String str, com.tencent.mobileqq.i2.a.a.j jVar);

     void fetchSpecifiedTypeChannelsOpenState(long j2, ArrayList<Integer> arrayList, int i2, com.tencent.mobileqq.i2.a.a.as asVar);

     void fetchSubscribeUserGuide(com.tencent.mobileqq.i2.a.a.at atVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.a
     void fetchTopFeeds(String str, String str2, au auVar);

     void fetchUserInfo(String str, String str2, List<String> list, boolean z, com.tencent.mobileqq.i2.a.bq bqVar);

     void fetchUserInfo(String str, List<String> list, boolean z, com.tencent.mobileqq.i2.a.bq bqVar);

     void fetchUserInfo(String str, List<String> list, boolean z, boolean z2, com.tencent.mobileqq.i2.a.bq bqVar);

     void fetchUserJoinedGuildList(String str, String str2, String str3, com.tencent.mobileqq.i2.a.a.av avVar);

     void fetchVersionNews(com.tencent.mobileqq.i2.a.a.aw awVar);

     void fetchVisibleMemberListByTinyId(String str, String str2, @NonNull List<String> list, @NonNull ax axVar);

     void fetchXWordInfo(long j2, dl dlVar);

     void getAddGuildOption(String str, int i2, be beVar);

    @Nullable
     IGProGuildUserState getAlreadyEnteredChannel();

     void getAppAuthorizationInfo(String str, int i2, bf bfVar);*/

    @Nullable
     IGProAppChnnPreInfo getAppChannelPreInfo(String str, String str2);

    @Nullable
     ArrayList<IGProAppChnnPreInfo> getAppChannelPreInfos(String str);

    @Nullable
     IGProAppChnnPreInfo getAppChnnPreInfo(String str, String str2);

    @Nullable
     ArrayList<IGProAppInfo> getAppInfos();

    /*
     void getAppRoleList(String str, String str2, byte[] bArr, bg bgVar);

     void getAssociativeWords(String str, com.tencent.mobileqq.i2.a.b bVar);

     void getAtMeMsg(int i2, com.tencent.mobileqq.i2.a.a.ax axVar);*/

     String getAvatarUrl(String str, long j2, int i2);

     /*
     void getBanners(com.tencent.mobileqq.qqguildsdk.data.genc.ae aeVar, com.tencent.mobileqq.i2.a.a.ay ayVar);

     void getBindClientService(int i2, String str, byte[] bArr, bj bjVar);

     void getBlockRecGuilds(com.tencent.mobileqq.qqguildsdk.data.genc.af afVar, az azVar);

     void getCategoryGuilds(com.tencent.mobileqq.qqguildsdk.data.genc.ag agVar, ba baVar);

     void getCategoryPageGuilds(com.tencent.mobileqq.qqguildsdk.data.genc.ah ahVar, com.tencent.mobileqq.i2.a.a.bb bbVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.c
    @NonNull
     ds getCategoryPermission(String str, String str2);

     void getChannelActivity(com.tencent.mobileqq.qqguildsdk.data.genc.ai aiVar, com.tencent.mobileqq.i2.a.a.bc bcVar);

     List<co> getChannelCategoryList(String str);

     void getChannelHeartbeat(String str, String str2, com.tencent.mobileqq.i2.a.ay ayVar);

     IGProChannelInfo getChannelInfo(String str);

     void getChannelInvisibleMemberList(String str, String str2, int i2, @NonNull byte[] bArr, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.d dVar);

     void getChannelInvisibleRoleList(String str, String str2, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.e eVar);*/

    @NonNull
    List<IGProChannelInfo> getChannelList(String str);

    /*
    @Nullable
     List<co> getChannelListForSelector(String str, boolean z);

    @Override // com.tencent.mobileqq.qqguildsdk.api.c
    @NonNull
     ds getChannelPermission(String str, String str2);

     void getChannelSpeakableMemberList(String str, String str2, int i2, @NonNull byte[] bArr, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.h hVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.c
     void getChannelSpeakableRoleList(String str, String str2, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.i iVar);

     void getChannelStateList(ArrayList<Long> arrayList, com.tencent.mobileqq.i2.a.f fVar);

     void getChannelTopMsgState(String str, String str2, @NonNull bi biVar);

     void getChannelUnspeakableMemberList(String str, String str2, int i2, @NonNull byte[] bArr, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.l lVar);

     void getChannelUnspeakableRoleList(String str, String str2, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.m mVar);*/

     int getChannelUserPermission(@NonNull String str, @NonNull String str2);

     //void getChannelVisibleAllMemberList(String str, String str2, int i2, @NonNull byte[] bArr, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.o oVar);

     //void getChannelVisibleMemberList(String str, String str2, int i2, @NonNull byte[] bArr, @NonNull com.tencent.mobileqq.qqguildsdk.data.type.o oVar);

    //@Override // com.tencent.mobileqq.qqguildsdk.api.c
     //void getChannelVisibleRoleList(String str, String str2, @NonNull ac acVar);

    /*
     void getClientInfoList(int i2, byte[] bArr, com.tencent.mobileqq.i2.a.bk bkVar);

     void getCurrPlaySong(long j2, long j3, com.tencent.mobileqq.i2.a.a.bd bdVar);

     void getDiscoverRecommendGuilds(com.tencent.mobileqq.qqguildsdk.data.genc.aj ajVar, com.tencent.mobileqq.i2.a.a.be beVar);

     dg getFaceAuthInfo();

     String getFullAvatarUrl(cm cmVar, int i2);*/

     String getFullGuildUserUserAvatarUrl(String str, String str2, int i2);

     String getFullUserAvatarPendantUrl(String str);

     List<IGProGuildInfo> getGroupGuildList();

     //void getGuidePageInfo(long j2, String str, com.tencent.mobileqq.i2.a.a.bf bfVar);

     String getGuildAvatarUrl(String str, int i2);

     //void getGuildBindingInfo(long j2, com.tencent.mobileqq.i2.a.a.bg bgVar);

    // void getGuildCreatorTasks(String str, boolean z, com.tencent.mobileqq.i2.a.a.bh bhVar);

    @Nullable
     IGProGlobalBanner getGuildGlobalBanner(String str);

     String getGuildIdOf(String str);

     @Nullable
     IGProGuildInfo getGuildInfo(String str);

     //void getGuildLableInfo(com.tencent.mobileqq.qqguildsdk.data.genc.ak akVar, com.tencent.mobileqq.i2.a.a.bi biVar);

     List<IGProGuildInfo> getGuildList();

    @Nullable
     IGProClientIdentityInfo getGuildMemberClientIdentity(String str, String str2, String str3);

    @NonNull
     String getGuildMemberName(String str, String str2);

    @NonNull
     Map<String, String> getGuildMemberNames(String str, List<String> list);

     String getGuildName(String str);

    // void getGuildNum(long j2, com.tencent.mobileqq.i2.a.a.bj bjVar);

    @NonNull
    // ds getGuildPermission(String str);

     //void getGuildRecommend(byte[] bArr, com.tencent.mobileqq.i2.a.bp bpVar);

    @Nullable
     long getGuildRoleLimit(long j2);

     long getGuildRoleLimit(String str);

    // ee getGuildSpeakPermission(String str, int i2);

     IGuildSpeakableThresholdPermission getGuildSpeakableThresholdPermission(String str);

    //@Nullable
    // dn getGuildState(String str);

     IGProStickyChannel getGuildStickyChannel(String str, String str2);

     List<IGProStickyChannel> getGuildStickyChannel(String str);

    @Nullable
     String getGuildUserAvatarPendantUrl(String str);

    @Nullable
     String getGuildUserAvatarUrl(String str, String str2, int i2);

    @Nullable
     Map<String, String> getGuildUserAvatarUrls(String str, List<String> list, int i2);

    @Nullable
     ArrayList<Long> getGuildUserChannelCategoryAdminList(String str, String str2);

    @Nullable
     IGProClientIdentity getGuildUserClientIdentity(String str, String str2);

    @NonNull
     String getGuildUserDisplayName(String str, String str2);

    @NonNull
     String getGuildUserDisplayName(String str, String str2, String str3);

    @NonNull
     String getGuildUserDisplayNameInternal(String str, String str2);

    @Nullable
     int getGuildUserLevelRoleId(String str, String str2);

    @Nullable
     IGProMedal getGuildUserMedal(String str);

    @Nullable
     String getGuildUserMemberName(String str, String str2);

    @NonNull
     String getGuildUserNick(String str, String str2);

    @Nullable
     String getGuildUserNickname(String str);

    @Nullable
     long getGuildUserTopRoleId(String str, String str2);

    @NonNull
     Map<String, String> getGuildUsersNicks(String str, List<String> list);

     //void getHotSearchWords(ArrayList<Integer> arrayList, int i2, com.tencent.mobileqq.i2.a.a.bk bkVar);

     //void getInvitationGuild(com.tencent.mobileqq.qqguildsdk.data.genc.al alVar, bl blVar);

     boolean getIsGuildListFirstLoadingCallbacked();

     List<IGProChannelInfo> getJumpChannelList(String str, String str2);

    @Nullable
     IGProJumpChannelInfo getJumpInfoFromCache(long j2);

    // void getLabelGuilds(com.tencent.mobileqq.qqguildsdk.data.genc.cq cqVar, bn bnVar);

    // void getMemberInfoByOpenId(String str, long j2, boolean z, boolean z2, com.tencent.mobileqq.i2.a.bn bnVar);

     IGProGuildRoleInfo getMemberLevelRole(String str, String str2, String str3);

    @Nullable
     IGProGuildRoleInfo getMemberLevelRoleInfo(long j2, long j3, long j4);

     IGProGuildRoleInfo getMemberTopRole(String str, String str2, String str3, String str4, int i2);

    @Nullable
     IGProGuildRoleInfo getMemberTopRoleInfo(long j2, long j3, long j4, long j5, int i2);

    // void getMoreNoticeList(int i2, int i3, bo boVar);

    @Nullable
     IGProOnlineMember getOnlineMemberInfo(String str);

     //void getOpenShareInfo(cr crVar, com.tencent.mobileqq.i2.a.a.bo boVar);

     int getPermissionChangeFilter(@NonNull String str, @NonNull String str2);

    @Nullable
     ArrayList<IGProPersonalSignatureTemplate> getPersonalSignatureTemplate();

    // com.tencent.mobileqq.qqguildsdk.data.cr getPollingActiveChannelInfo(String str);

    @Nullable
     IGProAppChnnPreInfo getPollingChannelOfApp(String str, String str2);

    @Nullable
     ILiveRoomInfo getPollingChannelOfLive(String str, String str2);

    @Nullable
     IAudioChannelMemberInfos getPollingChannelOfVoice(String str, String str2);

    // void getPopupInfo(long j2, int i2, com.tencent.mobileqq.i2.a.a.bp bpVar);

    // void getPrefetchRecommendGuilds(com.tencent.mobileqq.qqguildsdk.data.genc.an anVar, com.tencent.mobileqq.i2.a.a.bq bqVar);

    //@NotNull
    // fc getQQMsgListChannel(@NotNull String str, @NotNull String str2);

    //@Override // com.tencent.mobileqq.qqguildsdk.api.d
   // @NotNull
    // List<fc> getQQMsgListChannels();

    @Nullable
     ArrayList<Object> getQQMsgListGuilds();

    @Nullable
     IGProRecommendEssenceSvrRsp getRecommendEssenceSvrRsp(String str, String str2);

    //@Nullable
    // void getRecommendGuildInfoFromCache(com.tencent.mobileqq.i2.a.az azVar);

    // void getRecommendHot(com.tencent.mobileqq.qqguildsdk.data.genc.ao aoVar, bs bsVar);

   //  void getRecommendHotAndCallbackNotInUIThread(com.tencent.mobileqq.qqguildsdk.data.genc.ao aoVar, bs bsVar);

    // void getRecommendMyAndCallbackNotInUIThread(com.tencent.mobileqq.qqguildsdk.data.genc.ap apVar, com.tencent.mobileqq.i2.a.a.bt btVar);

    // void getRecommendMyV2(com.tencent.mobileqq.qqguildsdk.data.genc.ap apVar, com.tencent.mobileqq.i2.a.a.bt btVar);

    // void getRecommendPopUpItem(com.tencent.mobileqq.qqguildsdk.data.genc.aq aqVar, bu buVar);

    // void getRecommendPopupAds(com.tencent.mobileqq.qqguildsdk.data.genc.ar arVar, com.tencent.mobileqq.i2.a.a.bv bvVar);

    // void getRecommendQuickJoin(com.tencent.mobileqq.qqguildsdk.data.genc.as asVar, bw bwVar);

    // void getRecommendTagList(com.tencent.mobileqq.qqguildsdk.data.genc.at atVar, bx bxVar);

    // void getRecommendsV2(com.tencent.mobileqq.qqguildsdk.data.genc.au auVar, by byVar);

    // void getRedPointInfo(com.tencent.mobileqq.i2.a.a.bz bzVar);

    // void getRiskMemberRedPoint(com.tencent.mobileqq.qqguildsdk.data.genc.av avVar, com.tencent.mobileqq.i2.a.a.ca caVar);

    @Nullable
     IGProGuildRoleInfo getRoleInfo(long j2, long j3);

    //@Override // com.tencent.mobileqq.qqguildsdk.api.e
    @Nullable
     IGProGuildRoleInfo getRoleInfo(String str, String str2);

    @Nullable
     ArrayList<Integer> getRolePermission(long j2, long j3);

     //void getScheduleDetail(String str, String str2, String str3, com.tencent.mobileqq.i2.a.cg cgVar);

     //void getScheduleList(String str, String str2, long j2, ch chVar);

     //void getScheduleListNew(String str, String str2, int i2, long j2, String str3, com.tencent.mobileqq.i2.a.ci ciVar);

     //void getScheduleUsers(String str, String str2, String str3, int i2, byte[] bArr, ck ckVar);

     //void getSchedulesStatus(String str, String str2, long j2, long j3, cj cjVar);

     //void getSelectChannelIDs(com.tencent.mobileqq.qqguildsdk.data.genc.aw awVar, com.tencent.mobileqq.i2.a.a.cb cbVar);

    @NonNull
     String getSelfGuildMemberName(String str);

    @Nullable
     int getSelfLiveChannelBanStatus(String str, String str2);

    String getSelfTinyId();

    @Nullable
     int getShareButtonFromCache(long j2, long j3, boolean z);

    @Nullable
     IGProSimpleProfile getSimpleProfile(String guildId, String tinyId, int appId);

     List<IGProGuildInfo> getSortedGuildList();

     int getSpeakLimit(String str, String str2);

     List<IGProChannelInfo> getSpecificTypeChannelList(String str, int i2);

     //void getStickyChannelGuildList(ArrayList<String> arrayList, db dbVar);

     //void getSubjectGuilds(com.tencent.mobileqq.qqguildsdk.data.genc.ax axVar, com.tencent.mobileqq.i2.a.a.cc ccVar);

     List<String> getTopGuildList();

    // void getUnBindClientService(byte[] bArr, bj bjVar);

     //void getUserList(String str, long j2, boolean z, int i2, com.tencent.mobileqq.i2.a.br brVar);

     //void getUserList(String str, Object obj, boolean z, int i2, @NonNull com.tencent.mobileqq.i2.a.bl blVar);

     //void getUserLiveInfo(int i2, com.tencent.mobileqq.i2.a.bs bsVar);

     //void guildMsgReadReport(com.tencent.mobileqq.qqguildsdk.data.genc.bd bdVar, da daVar);

     boolean hasSetSpeakableThreshold(String str);

     //void initGetNoticeList(int i2, boolean z, com.tencent.mobileqq.i2.a.bu buVar);

    //@Override // com.tencent.mobileqq.qqguildsdk.api.a
     //void inviteUserHandUpForAdmin(com.tencent.mobileqq.qqguildsdk.data.genc.e eVar, com.tencent.mobileqq.i2.a.a.b bVar);

    //@Override // com.tencent.mobileqq.qqguildsdk.api.a
    // void inviteUserQueueForAdmin(com.tencent.mobileqq.qqguildsdk.data.genc.e eVar, com.tencent.mobileqq.i2.a.a.b bVar);

     boolean isChannelAdmin(String str, String str2);

     boolean isGProSDKInitCompleted();

     boolean isGuest(IGProGuildInfo iGProGuildInfo);

     boolean isGuest(String str);

    @Nullable
     boolean isGuildMember(String str);

     boolean isQQMsgListChannel(@NotNull String str, @NotNull String str2);

    @Nullable
     boolean isQQMsgListGuild(long j2);

    @Nullable
     boolean isQQMsgListReady();

     //void isRecommendNewCard(com.tencent.mobileqq.qqguildsdk.data.genc.bs bsVar, com.tencent.mobileqq.i2.a.a.ch chVar);

     boolean isStickyChannelGuild(String str);

     //void kickAudioChannelUsers(String str, String str2, ArrayList<String> arrayList, com.tencent.mobileqq.i2.a.bw bwVar);

    // void kickGuildUsers(String str, List<String> list, boolean z, @Nullable fe feVar, cc ccVar);

     //void loadGProUserProfileInfo(String str, String str2, com.tencent.mobileqq.i2.a.by byVar);

   // @Override // com.tencent.mobileqq.qqguildsdk.api.e
     //void loadMemberRoleList(String str, String str2, @NonNull com.tencent.mobileqq.i2.a.bx bxVar);

   //  void loadUserInfo(String str, List<String> list, com.tencent.mobileqq.i2.a.bq bqVar, List<IGProUserInfo> list2, boolean z);

     //void loadUserList(String str, long j2, com.tencent.mobileqq.i2.a.br brVar);

    byte[] lz4DecompressBuf(byte[] bArr);

    // void modifyGuildSpeakableMemberList(String str, List<String> list, List<String> list2, @NonNull cq cqVar);


    // void modifyGuildSpeakableRoleList(String str, List<String> list, List<String> list2, cq cqVar);

    // void modifyGuildSpeakableRule(String str, com.tencent.mobileqq.qqguildsdk.data.at atVar, cq cqVar);

    // void modifyScheduleInviteStatus(String str, String str2, String str3, int i2, com.tencent.mobileqq.i2.a.cl clVar);

   // void onSrvPushMsg(int i2, int i3, fa faVar, byte[] bArr);

    //void openAVLobbyApp(com.tencent.mobileqq.qqguildsdk.data.genc.o oVar, com.tencent.mobileqq.i2.a.a.l lVar);

   // @Override // com.tencent.mobileqq.qqguildsdk.api.a
   //  void queryAVState(cg cgVar, dd ddVar);

    // void queryApplyAddGuildStatus(String str, cq cqVar);

    // void queryGuildEssence(bb bbVar, com.tencent.mobileqq.i2.a.a.cg cgVar);

    /*
     void queryGuildVisitor(bb bbVar, com.tencent.mobileqq.i2.a.a.cg cgVar);

     void queryRecommendGuildInfo(com.tencent.mobileqq.i2.a.ba baVar);

     void queryTinyIdByLiveUID(List<String> list, com.tencent.mobileqq.i2.a.bz bzVar);

     void refreshAppChannelPreInfos(String str, boolean z, da daVar);

     void refreshAppChannelPreInfosForVisitor(String str, ArrayList<String> arrayList, boolean z, da daVar);*/

     void refreshChannelInfo(String str, String str2, boolean z, int i2);

     void refreshGuildList(boolean z);

     void refreshGuildUserProfileInfo(String guildId, String userTinyId);

     void refreshPollingData();

     void refreshPollingData(@NonNull String str, int i2);

     void refreshPollingData(@NonNull String str, @NonNull String str2);

     /*
     void registerStrangerIdentity(String str, da daVar);

     void removeBanBeforeBroadcast(String str, String str2, com.tencent.mobileqq.i2.a.ca caVar);

     void removeChannel(String str, String str2, cc ccVar);

     void removeChannelCategory(String str, long j2, boolean z, bh bhVar);

     void removeGuild(String str, cq cqVar);*/

    @Nullable
     boolean removeGuildGlobalBanner(String str);

    /*
     void removeGuildStateListener(@NonNull bt btVar);

     void removeMemberFromGuildBlackList(String str, @NonNull List<String> list, cb cbVar);

     void removeRiskMembers(com.tencent.mobileqq.qqguildsdk.data.genc.bt btVar, com.tencent.mobileqq.i2.a.a.cm cmVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.a
     void removeSpeakOrderByUser(cg cgVar, dd ddVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.a
     void reportAVState(com.tencent.mobileqq.qqguildsdk.data.genc.d dVar, dd ddVar);

     void reportDiscoverStateClickEvent(int i2, int i3, da daVar);

     void reportFeedShareData(String str, String str2, int i2, com.tencent.mobileqq.qqguildsdk.data.genc.z zVar, int i3, com.tencent.mobileqq.i2.a.a.cn cnVar);

     void reportFeedback(com.tencent.mobileqq.qqguildsdk.data.genc.aa aaVar, da daVar);

     void reportJoinRecommendGuild(com.tencent.mobileqq.i2.a.a.co coVar);

     void reportPreventAddictionInstructions(com.tencent.mobileqq.qqguildsdk.data.genc.bo boVar, com.tencent.mobileqq.i2.a.a.ck ckVar);

    void reportShareInfo(String str, String str2, int i2, String str3, int i3, cb cbVar);

     void reportUserViewGuild(ArrayList<String> arrayList, String str, String str2, int i2, da daVar);

     void requestBeginBroadcast(String str, String str2, String str3, int i2, com.tencent.mobileqq.qqguildsdk.data.bg bgVar, cc ccVar);

     void requestPubAccountMsgCount(com.tencent.mobileqq.i2.a.a.cp cpVar);

     void riskMemberList(com.tencent.mobileqq.qqguildsdk.data.genc.bu buVar, com.tencent.mobileqq.i2.a.a.cr crVar);

     void searchBlackUserFromServer(com.tencent.mobileqq.qqguildsdk.data.genc.bw bwVar, cs csVar);

     void searchChannelContent(String str, String str2, String str3, byte[] bArr, com.tencent.mobileqq.qqguildsdk.data.genc.by byVar, com.tencent.mobileqq.qqguildsdk.data.genc.bx bxVar, ct ctVar);

     void searchGuild(String str, byte[] bArr, int i2, int i3, int i4, cu cuVar);

     void searchGuildMembersBySourceId(com.tencent.mobileqq.qqguildsdk.data.genc.bc bcVar, cv cvVar);

     void searchMsgSeqsFromServer(@NonNull com.tencent.mobileqq.qqguildsdk.data.az azVar, @NonNull com.tencent.mobileqq.i2.a.co coVar);

     void searchUnion(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6, com.tencent.mobileqq.i2.a.cq cqVar);

     void sendChannelHeartbeat(com.tencent.mobileqq.qqguildsdk.data.genc.bg bgVar);

     void sendDirectMsgReadReport(@NonNull List<com.tencent.mobileqq.qqguildsdk.data.k> list);

     void sendOperationSaveMsg(com.tencent.mobileqq.qqguildsdk.data.genc.bv bvVar, cw cwVar);

     void sendScheduleArkMessage(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<com.tencent.mobileqq.qqguildsdk.data.ck> arrayList3, com.tencent.mobileqq.qqguildsdk.data.ck ckVar, long j2, int i2, String str, String str2, String str3, com.tencent.mobileqq.i2.a.cm cmVar);

     void setAVChannelInviteSpeakSwitch(long j2, long j3, com.tencent.mobileqq.qqguildsdk.data.genc.bh bhVar, da daVar);

     void setAVChannelSpeakMode(long j2, long j3, String str, com.tencent.mobileqq.qqguildsdk.data.genc.cp cpVar, cz czVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.a
     void setAVChannelSpeakOrder(long j2, long j3, com.tencent.mobileqq.qqguildsdk.data.genc.cj cjVar, da daVar);

     void setAddGuildOption(String str, AddGuildOption addGuildOption, cc ccVar);

     void setAdminMsgNotifyType(String str, String str2, int i2, com.tencent.mobileqq.i2.a.cr crVar);

     void setChannelAuthControl(long j2, long j3, int i2, int i3, cq cqVar);

     void setChannelAuthControlMemberList(long j2, long j3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i2, cq cqVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.a
     void setChannelAuthControlRoleList(long j2, long j3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i2, cq cqVar);

     void setChannelBannedSpeak(String str, int i2, cc ccVar);

     void setChannelCategory(String str, String str2, long j2, bh bhVar);

     void setChannelCategoryInfo(String str, com.tencent.mobileqq.qqguildsdk.data.d dVar, ArrayList<com.tencent.mobileqq.qqguildsdk.data.d> arrayList, bh bhVar);

     void setChannelCategoryOrder(String str, ArrayList<Long> arrayList, bh bhVar);

     void setChannelHeartbeat(com.tencent.mobileqq.qqguildsdk.data.genc.bg bgVar);

     void setChannelLiveable(String str, String str2, int i2, @NonNull cc ccVar);

     void setChannelLiveableMemberList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cc ccVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.c
     void setChannelLiveableRoleList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cc ccVar);

     void setChannelName(String str, String str2, String str3, com.tencent.mobileqq.i2.a.ct ctVar);

     void setChannelSlowMode(String str, int i2, cc ccVar);

     void setChannelSpeakable(String str, String str2, int i2, @NonNull cc ccVar);

     void setChannelSpeakableMemberList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cc ccVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.c
     void setChannelSpeakableRoleList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cc ccVar);

     void setChannelTopMsg(String str, String str2, long j2, int i2, int i3, @NonNull cb cbVar);

     void setChannelUserNumLimit(long j2, long j3, int i2, boolean z, int i3, cq cqVar);

     void setChannelVisible(String str, String str2, int i2, @NonNull cc ccVar);

     void setChannelVisibleMemberList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cc ccVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.c
     void setChannelVisibleRoleList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cc ccVar);

     void setClientShowConfig(String str, int i2, int i3, com.tencent.mobileqq.i2.a.cv cvVar);

     void setDirectMsgBlack(String str, boolean z, @NonNull cc ccVar);

     void setDirectMsgNotifyForGuild(int i2, boolean z, @NonNull cc ccVar);

     void setDirectMsgNotifyType(String str, int i2, @NonNull cc ccVar);

     void setDirectMsgStatus(int i2, int i3, @NonNull cc ccVar);

     void setEnteredChannelState(long j2, long j3, boolean z);

     void setFeedCommentsNotifySwitch(int i2, com.tencent.mobileqq.i2.a.m mVar);

    void setGender(int i2, cb cbVar);

     void setGlobalPrivacySwitch(int i2, int i3, com.tencent.mobileqq.i2.a.a.ce ceVar);

     void setGuildClientId(String str, String str2, com.tencent.mobileqq.i2.a.cw cwVar);

     void setGuildCoverFontColorId(String str, int i2, cx cxVar);

     void setGuildCreatorTaskSkipStatus(String str, da daVar);

     void setGuildGlobalBanner(ay ayVar, com.tencent.mobileqq.i2.a.a.cd cdVar);

     void setGuildIsInteractiveForVisitor(String str, boolean z, da daVar);

     void setGuildListSort(ArrayList<String> arrayList, com.tencent.mobileqq.i2.a.cz czVar);

     void setGuildListTop(String str, int i2, int i3, com.tencent.mobileqq.i2.a.a.cx cxVar);

     void setGuildMemberName(String str, String str2, cq cqVar);

     void setGuildName(String str, String str2, cy cyVar);

     void setGuildNeedRealNameForVisitor(String str, boolean z, da daVar);

     void setGuildProfile(String str, String str2, cc ccVar);

     void setGuildQRCodePeriod(String str, int i2, cc ccVar);

     void setGuildQRCodeSwitch(long j2, int i2, cq cqVar);

     void setGuildShutUp(String str, long j2, @NonNull cc ccVar);

     void setGuildSpeakableThreshold(String str, eu euVar, cq cqVar);

     void setGuildStickyChannel(String str, String str2, com.tencent.mobileqq.i2.a.bb bbVar);

     void setGuildTop(String str, boolean z, com.tencent.mobileqq.i2.a.db dbVar);

     void setGuildUnNotifyFlag(String str, int i2, com.tencent.mobileqq.i2.a.da daVar);

     void setGuildVisibilityForVisitor(String str, boolean z, @NonNull cb cbVar);

     void setGuildWeakNotifyDisplay(String str, int i2, dc dcVar);

     void setJumpChannelId(long j2, long j3, com.tencent.mobileqq.i2.a.a.ah ahVar);

     void setJumpChannelSwitch(long j2, boolean z, com.tencent.mobileqq.i2.a.a.ah ahVar);

     void setListenTogetherPlayOpt(long j2, long j3, int i2, com.tencent.mobileqq.i2.a.a.cj cjVar);

     void setListenTogetherPlayVolumeByAdmin(long j2, long j3, int i2, com.tencent.mobileqq.i2.a.a.cj cjVar);

     void setLiveChannelAnchorList(String str, String str2, List<String> list, List<String> list2, cc ccVar);

     void setLiveChannelBannedUser(String str, String str2, String str3, String str4, int i2, cb cbVar);

    void setLocation(GProLocationInfo gProLocationInfo, cb cbVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.e
     void setMemberRoles(String str, String str2, String str3, String str4, @NonNull List<String> list, @NonNull List<String> list2, @NonNull cc ccVar);

     void setMemberShutUp(String str, String str2, long j2, @NonNull cc ccVar);

     void setMyBirthday(short s, short s2, short s3, da daVar);

     void setMyMsgNotifyType(String str, String str2, int i2, com.tencent.mobileqq.i2.a.cs csVar);

     void setMyPersonalSignature(String str, da daVar);

     void setMyProfileShowTypeSwitch(String str, int i2, int i3, da daVar);

     void setMyVoiceNetworkQuality(String str, String str2, int i2);

     void setMyVoiceScreenShareMicStatus(String str, String str2, int i2);

     void setMyVoiceSysMicStatus(String str, String str2, int i2);

    void setNickName(String str, cb cbVar);

     void setNoSpeakGotoChannel(long j2, long j3, long j4, int i2, cq cqVar);

     void setOnLogin(boolean z);

    @Override // com.tencent.mobileqq.qqguildsdk.api.d
     void setQQMsgListChannel(@NotNull String str, @NotNull String str2, int i2, @NotNull cb cbVar);

     void setQQMsgListGuild(long j2, int i2, int i3, com.tencent.mobileqq.i2.a.a.cy cyVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.e
     void setRoleInfo(String str, String str2, @NonNull ff ffVar, @NonNull cc ccVar);

     void setRoleMembers(String str, String str2, String str3, String str4, @NonNull List<String> list, @NonNull List<String> list2, @NonNull cc ccVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.e
     void setRoleOrder(String str, @NonNull List<String> list, @NonNull cc ccVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.e
     void setRoleSpeakableChannels(String str, String str2, @NonNull List<String> list, @NonNull List<String> list2, @NonNull cb cbVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.e
     void setRoleVisibleChannels(String str, String str2, @NonNull List<String> list, @NonNull List<String> list2, @NonNull cb cbVar);

     void setScreenSharedInGuild(String str, String str2, boolean z, cn cnVar);

    void setSelfTinyId(String str);

     void setShowArchive(String str, boolean z, de deVar);

     void setShowPresence(String str, boolean z, de deVar);

     void setTopicSquareEntranceSwitch(long j2, boolean z, cq cqVar);

     void setUserLiveInfo(int i2, String str, String str2, int i3, com.tencent.mobileqq.i2.a.dd ddVar);

     void setUserMuteSeatInGuild(String str, String str2, String str3, boolean z, cb cbVar);

     void setUserPermissionInGuild(long j2, long j3, long j4, boolean z, cq cqVar);

     void setUserType(String str, dh dhVar);

     void setUserTypeWithUserConfigure(boolean z, df dfVar);

     void setUserVoicelessToMe(String str, boolean z, cb cbVar);

     void setXWordInfo(long j2, long j3, long j4, da daVar);*/

     void startPollingForDiscoverState();

     void startPollingRecommendGuildInfo();

     void startPollingYLGameTeamInfo(int i2);

     void stopPollingForDiscoverState(boolean z);

     void stopPollingRecommendGuildInfo();

     void stopPollingYLGameTeamInfo();

     void subscribePolling(@NonNull String str);

     /*
     void subscribePollingChannels(@NonNull List<fb> list);

     void switchAVLobbyApp(com.tencent.mobileqq.qqguildsdk.data.genc.cb cbVar, com.tencent.mobileqq.i2.a.a.l lVar);

     void terminateLiveStream(String str, String str2, int i2, int i3, com.tencent.mobileqq.i2.a.df dfVar);

     void terminateLiveStream(String str, String str2, int i2, com.tencent.mobileqq.i2.a.df dfVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.a
     void topSpeakOrderByAdmin(com.tencent.mobileqq.qqguildsdk.data.genc.e eVar, com.tencent.mobileqq.i2.a.a.b bVar);

     void tryUnmuteMicrophone(String str, String str2, boolean z, @NonNull cb cbVar);

     void ubsubscribePollingChannels(@NonNull List<fb> list);*/

     void unsubscribePolling(@NonNull String str);

     /*
     void updateArchiveShowSeq(ArrayList<Integer> arrayList, com.tencent.mobileqq.i2.a.dg dgVar);

     void updateAudioLiveChannelTheme(com.tencent.mobileqq.qqguildsdk.data.genc.cf cfVar, da daVar);

     void updateForumChannelSortMode(String str, String str2, int i2, @NonNull cc ccVar);

     void updateGuildEssence(bb bbVar, com.tencent.mobileqq.i2.a.a.cg cgVar);

     void updateGuildVisitor(bb bbVar, com.tencent.mobileqq.i2.a.a.cg cgVar);

     void upgradeGroupFeed(ArrayList<Long> arrayList, int i2, com.tencent.mobileqq.i2.a.a.dc dcVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.a
     void userDealSpeakInvitation(cg cgVar, dd ddVar);

    @Override // com.tencent.mobileqq.qqguildsdk.api.a
     void userHandUp(cg cgVar, dd ddVar);

     void userOnlineReport(com.tencent.mobileqq.qqguildsdk.data.genc.bf bfVar, com.tencent.mobileqq.i2.a.a.de deVar);

     void userShareScreen(cg cgVar, dd ddVar);

     void voiceChannelAuth0x10b6(String str, String str2, int i2, boolean z, int i3, di diVar);

     void voiceInviteUser0x10b9(String str, String str2, String str3, cb cbVar);

     void voiceSmobaGameCreateRoom(com.tencent.mobileqq.qqguildsdk.data.genc.ck ckVar, com.tencent.mobileqq.qqguildsdk.data.genc.co coVar, com.tencent.mobileqq.i2.a.a.dg dgVar);

     void voiceSmobaGameDissmissRoom(com.tencent.mobileqq.qqguildsdk.data.genc.cl clVar, da daVar);

     void voiceSmobaGameEnterRoom(long j2, int i2, long j3, long j4, com.tencent.mobileqq.i2.a.a.dh dhVar);

     void voiceSmobaGameGetRoomByChannel(long j2, long j3, com.tencent.mobileqq.i2.a.a.di diVar);

     void voiceSmobaGameKickOutRoom(com.tencent.mobileqq.qqguildsdk.data.genc.cm cmVar, dk dkVar);

     void voiceSmobaGameQuitRoom(com.tencent.mobileqq.qqguildsdk.data.genc.cn cnVar, dj djVar);*/

     void watchRedPointInfo(boolean z);
}
