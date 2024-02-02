@file:OptIn(ExperimentalSerializationApi::class)

package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.qqguildsdk.api.IGPSService
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRole
import com.tencent.qqnt.kernel.nativeinterface.GProRoleMemberList
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchMemberListWithRoleCallback
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import moe.fuqiuluo.qqinterface.servlet.structures.GProChannelInfo
import moe.fuqiuluo.qqinterface.servlet.structures.GetGuildMemberListNextToken
import moe.fuqiuluo.qqinterface.servlet.structures.GuildInfo
import moe.fuqiuluo.qqinterface.servlet.structures.GuildStatus
import moe.fuqiuluo.qqinterface.servlet.structures.SlowModeInfo
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import moe.whitechi73.protobuf.oidb.cmd0xf88.GProFilter
import moe.whitechi73.protobuf.oidb.cmd0xf88.GProUserInfo
import moe.whitechi73.protobuf.oidb.cmd0xf88.Oidb0xf88Req
import moe.whitechi73.protobuf.oidb.cmd0xf88.Oidb0xf88Rsp
import moe.whitechi73.protobuf.oidb.cmx0xf57.Oidb0xf57Filter
import moe.whitechi73.protobuf.oidb.cmx0xf57.Oidb0xf57GuildInfo
import moe.whitechi73.protobuf.oidb.cmx0xf57.Oidb0xf57MetaInfo
import moe.whitechi73.protobuf.oidb.cmx0xf57.Oidb0xf57Req
import moe.whitechi73.protobuf.oidb.cmx0xf57.Oidb0xf57Rsp
import moe.whitechi73.protobuf.oidb.cmx0xf57.Oidb0xf57U1
import moe.whitechi73.protobuf.oidb.cmx0xf57.Oidb0xf57U2
import tencent.im.oidb.oidb_sso
import kotlin.coroutines.resume

internal object GProSvc: BaseSvc() {
    fun getSelfTinyId(): ULong {
        val service = app.getRuntimeService(IGPSService::class.java, "all")
        return service.selfTinyId.toULong()
    }

    suspend fun getGuildInfo(guildId: ULong): Result<Oidb0xf57MetaInfo> {
        val respBuffer = sendOidbAW("OidbSvcTrpcTcp.0xf57_9", 0xf57, 9, ProtoBuf.encodeToByteArray(Oidb0xf57Req(
            filter = Oidb0xf57Filter(
                u1 = Oidb0xf57U1(1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u),
                u2 = Oidb0xf57U2(1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u)
            ),
            guildInfo = Oidb0xf57GuildInfo(guildId = guildId)
        )))
        val body = oidb_sso.OIDBSSOPkg()
        if (respBuffer == null) {
            return Result.failure(Exception("unable to send packet"))
        }
        body.mergeFrom(respBuffer.slice(4))
        return runCatching {
            ProtoBuf.decodeFromByteArray<Oidb0xf57Rsp>(
                body.bytes_bodybuffer.get().toByteArray()
            ).metaInfo
        }
    }

    fun getChannelList(guildId: ULong, refresh: Boolean = false): Result<ArrayList<GProChannelInfo>> {
        if (refresh) {
            refreshGuildInfo(guildId)
        }
        val result = arrayListOf<GProChannelInfo>()
        app.getRuntimeService(IGPSService::class.java, "all").getChannelList(guildId.toString()).forEach {
            result.add(GProChannelInfo(
                ownerGuildId = guildId,
                guildId = it.guildId,
                channelId = it.channelUin.toLong(),
                channelUin = it.channelUin.toLong(),
                channelName = it.channelName ?: "",
                channelType = it.type,
                createTime = it.createTime,
                creatorTinyId = it.creatorId.toLong(),
                talkPermission = it.talkPermission,
                visibleType = it.visibleType,
                currentSlowMode = it.slowModeKey,
                slowModes = it.gProSlowModeInfoList.map {
                    SlowModeInfo(it.slowModeKey, it.slowModeText, it.speakFrequency, it.slowModeCircle)
                },
                appIconUrl = it.iconUrl,
                jumpType = it.appChannelJumpType,
                jumpSwitch = it.jumpSwitch,
                jumpUrl = it.appChannelJumpUrl,
                categoryId = it.categoryId,
                myTalkPermission = it.myTalkPermissionType,
                maxMemberCount = it.channelMemberMax
            ))
        }
        return Result.success(result)
    }

    fun refreshGuildInfo(guildId: ULong) {
        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService
        kernelGProService.refreshGuildInfo(guildId.toLong(), true, 1)
    }

    suspend fun getGuildMemberList(
        guildId: ULong,
        startIndex: Long = 0,
        roleIndex: Long = 1,
        count: Int = 50,
        fetchAll: Boolean = false,
        result: ArrayList<GProRoleMemberList> = arrayListOf()
    ): Result<Pair<GetGuildMemberListNextToken, ArrayList<GProRoleMemberList>>> {
        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService

        val fetchGuildMemberListResult: Pair<GetGuildMemberListNextToken, ArrayList<GProRoleMemberList>> = (withTimeoutOrNull(5000) {
            suspendCancellableCoroutine {
                kernelGProService.fetchMemberListWithRole(guildId.toLong(), 0, startIndex, roleIndex, count, 0) { code, reason, finish, nextIndex, nextRoleIdIndex, _, seq, roleList ->
                    if (code == 0) {
                        it.resume(GetGuildMemberListNextToken(nextIndex, nextRoleIdIndex, seq, finish) to roleList)
                    } else {
                        LogCenter.log("fetchMemberListWithRole failed: $code($reason)", Level.WARN)
                        it.resume(null)
                    }
                }
            }
        }) ?: return Result.failure(Exception("unable to fetch guild member list"))

        val nextToken = fetchGuildMemberListResult.first
        val roleList = fetchGuildMemberListResult.second
        result.addAll(roleList)
        return if (fetchAll) {
            if (!fetchGuildMemberListResult.first.finish) {
                getGuildMemberList(guildId, nextToken.startIndex, nextToken.roleIndex, count, true, result)
            } else {
                Result.success(nextToken.copy(finish = true) to result)
            }
        } else {
            Result.success(nextToken to result)
        }
    }

    suspend fun getSelfGuildInfo(): Result<GProUserInfo> {
        val selfTinyId = getSelfTinyId()
        return getUserGuildInfo(0u, selfTinyId)
    }

    suspend fun getUserGuildInfo(
        guildId: ULong,
        memberTinyId: ULong
    ): Result<GProUserInfo> {
        val respBuffer = sendOidbAW("OidbSvcTrpcTcp.0xf88_1", 0xf88, 1, ProtoBuf.encodeToByteArray(Oidb0xf88Req(
            filter = GProFilter(1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u),
            memberId = 0uL,
            tinyId = memberTinyId,
            guildId = guildId
        )))
        val body = oidb_sso.OIDBSSOPkg()
        if (respBuffer == null) {
            return Result.failure(Exception("unable to send packet"))
        }
        body.mergeFrom(respBuffer.slice(4))
        return runCatching {
            ProtoBuf.decodeFromByteArray<Oidb0xf88Rsp>(
                body.bytes_bodybuffer.get().toByteArray()
            ).userInfo!!
        }
    }

    private fun getGuildListByOldApi(result: ArrayList<GuildInfo>) {
        app.getRuntimeService(IGPSService::class.java, "all").guildList?.forEach {
            result.add(GuildInfo(
                guildId = it.guildID.toLong(),
                guildName = it.guildName ?: "",
                guildDisplayId = it.guildNumber ?: "",
                profile = it.profile ?: "",
                status = GuildStatus(
                    isEnable = !it.isFrozen && !it.isBanned,
                    isBanned = it.isBanned,
                    isFrozen = it.isFrozen
                ),
                ownerId = 0,
                shutUpTime = it.shutUpExpireTime,
                allowSearch = it.allowSearch
            ))
        }
    }

    private fun getGuildListByNt(result: ArrayList<GuildInfo>) {
        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService
        kernelGProService.guildListFromCache.forEach {
            if (it.result != 0) return@forEach
            val guildInfo = it.guildInfo
            result.add(GuildInfo(
                guildId = it.guildId,
                guildName = guildInfo.guildName ?: "",
                guildDisplayId = guildInfo.guildNumber ?: "",
                profile = guildInfo.profile ?: "",
                status = GuildStatus(
                    isEnable = guildInfo.guildStatus?.isEnable == 1,
                    isBanned = guildInfo.guildStatus?.isBanned == 1,
                    isFrozen = guildInfo.guildStatus?.isFrozen == 1
                ),
                ownerId = guildInfo.ownerTinyid,
                shutUpTime = guildInfo.shutupExpireTime,
                allowSearch = guildInfo.allowSearch == 1
            ))
        }
    }

    suspend fun fetchGuildMemberRoles(guildId: ULong, tinyId: ULong, refresh: Boolean = false): Result<ArrayList<GProGuildRole>> {
        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService
        if (refresh) {
            kernelGProService.refreshGuildUserProfileInfo(guildId.toLong(), tinyId.toLong(), 1)
        }
        val result: ArrayList<GProGuildRole> = withTimeoutOrNull(5000) {
            suspendCancellableCoroutine {
                kernelGProService.fetchMemberRoles(guildId.toLong(), 0, tinyId.toLong(), 2) { code, reason, roles ->
                    it.resume(roles)
                }
            }
        } ?: return Result.failure(Exception("unable to fetch guild member roles"))
        return Result.success(result)
    }

    fun getGuildList(refresh: Boolean = false, forceOldApi: Boolean): ArrayList<GuildInfo> {
        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService
        if (refresh) {
            kernelGProService.refreshGuildList(true)
            kernelGProService.guildListFromCache.forEach {
                refreshGuildInfo(it.guildId.toULong())
            }
        }
        val result = arrayListOf<GuildInfo>()
        if (PlatformUtils.getQQVersionCode() < PlatformUtils.QQ_9_0_8_VER || forceOldApi) {
            getGuildListByOldApi(result)
        } else {
            runCatching {
                getGuildListByNt(result)
            }.onFailure {
                LogCenter.log("GetGuildListByNt failed: ${it.stackTraceToString()}", Level.ERROR)
                getGuildListByOldApi(result) // 防止QQ更新API导致无法获取
            }
        }

        return result
    }
}