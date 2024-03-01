@file:OptIn(ExperimentalSerializationApi::class)

package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.qqguildsdk.api.IGPSService
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRole
import com.tencent.qqnt.kernel.nativeinterface.GProRoleCreateInfo
import com.tencent.qqnt.kernel.nativeinterface.GProRoleMemberList
import com.tencent.qqnt.kernel.nativeinterface.GProRolePermission
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.ExperimentalSerializationApi

import moe.fuqiuluo.qqinterface.servlet.structures.GProChannelInfo
import moe.fuqiuluo.qqinterface.servlet.structures.GetGuildMemberListNextToken
import moe.fuqiuluo.qqinterface.servlet.structures.GuildInfo
import moe.fuqiuluo.qqinterface.servlet.structures.GuildStatus
import moe.fuqiuluo.qqinterface.servlet.structures.SlowModeInfo
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.EMPTY_BYTE_ARRAY
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.xposed.helper.NTServiceFetcher
import moe.fuqiuluo.symbols.decodeProtobuf
import protobuf.auto.toByteArray
import protobuf.guild.GetGuildFeedsReq
import protobuf.guild.GetGuildFeedsRsp
import protobuf.oidb.cmd0xf88.GProFilter
import protobuf.oidb.cmd0xf88.GProUserInfo
import protobuf.oidb.cmd0xf88.Oidb0xf88Req
import protobuf.oidb.cmd0xf88.Oidb0xf88Rsp
import protobuf.oidb.cmx0xf57.Oidb0xf57Filter
import protobuf.oidb.cmx0xf57.Oidb0xf57GuildInfo
import protobuf.oidb.cmx0xf57.Oidb0xf57MetaInfo
import protobuf.oidb.cmx0xf57.Oidb0xf57Req
import protobuf.oidb.cmx0xf57.Oidb0xf57Rsp
import protobuf.oidb.cmx0xf57.Oidb0xf57U1
import protobuf.oidb.cmx0xf57.Oidb0xf57U2
import protobuf.qweb.DEFAULT_DEVICE_INFO
import protobuf.qweb.QWebExtInfo
import protobuf.qweb.QWebReq
import protobuf.qweb.QWebRsp
import tencent.im.oidb.oidb_sso
import kotlin.coroutines.resume

internal object GProSvc: BaseSvc() {
    fun getSelfTinyId(): ULong {
        val service = app.getRuntimeService(IGPSService::class.java, "all")
        return service.selfTinyId.toULong()
    }

    suspend fun getGuildInfo(guildId: ULong): Result<Oidb0xf57MetaInfo> {
        val respBuffer = sendOidbAW("OidbSvcTrpcTcp.0xf57_9", 0xf57, 9, Oidb0xf57Req(
            filter = Oidb0xf57Filter(
                u1 = Oidb0xf57U1(1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u),
                u2 = Oidb0xf57U2(1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u)
            ),
            guildInfo = Oidb0xf57GuildInfo(guildId = guildId)
        ).toByteArray())
        val body = oidb_sso.OIDBSSOPkg()
        if (respBuffer == null) {
            return Result.failure(Exception("unable to send packet"))
        }
        body.mergeFrom(respBuffer.slice(4))
        return runCatching {
            body.bytes_bodybuffer.get()
                .toByteArray()
                .decodeProtobuf<Oidb0xf57Rsp>().metaInfo
        }
    }

    suspend fun getGuildFeeds(guildId: ULong, channelId: ULong, startIndex: Int): Result<GetGuildFeedsRsp> {
        val buffer = sendBufferAW("QChannelSvr.trpc.qchannel.commreader.ComReader.GetGuildFeeds", true, QWebReq(
            seq = 10,
            qua = PlatformUtils.getQUA(),
            deviceInfo = DEFAULT_DEVICE_INFO,
            buffer = GetGuildFeedsReq(
                count = 12,
                from = startIndex,
                feedAttchInfo = EMPTY_BYTE_ARRAY,
                guildId = guildId,
                getType = 1,
                u7 = 0,
                u8 = 1,
                u9 = EMPTY_BYTE_ARRAY
            ).toByteArray(),
            traceId = app.account + "_0_0",
            extinfo = listOf(
                QWebExtInfo("fc-appid", "96"),
                QWebExtInfo("environment_id", "shamrock"),
                QWebExtInfo("tiny_id", getSelfTinyId().toString()),
            )
        ).toByteArray()) ?: return Result.failure(Exception("unable to send packet"))
        val webRsp = buffer.slice(4).decodeProtobuf<QWebRsp>()
        if(webRsp.buffer == null) return Result.failure(Exception("server error"))
        val wupBuffer = webRsp.buffer!!
        val feeds = wupBuffer.decodeProtobuf<GetGuildFeedsRsp>()
        return Result.success(feeds)
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
        val respBuffer = sendOidbAW("OidbSvcTrpcTcp.0xf88_1", 0xf88, 1, Oidb0xf88Req(
            filter = GProFilter(1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u),
            memberId = 0uL,
            tinyId = memberTinyId,
            guildId = guildId
        ).toByteArray())
        val body = oidb_sso.OIDBSSOPkg()
        if (respBuffer == null) {
            return Result.failure(Exception("unable to send packet"))
        }
        body.mergeFrom(respBuffer.slice(4))
        return runCatching {
            body.bytes_bodybuffer.get().toByteArray().decodeProtobuf<Oidb0xf88Rsp>().userInfo!!
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

    suspend fun getGuildRoles(guildId: ULong): Result<List<GProGuildRole>> {
        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService
        val roles: List<GProGuildRole> = withTimeoutOrNull(5000) {
            suspendCancellableCoroutine {
                kernelGProService.fetchRoleListWithPermission(guildId.toLong(), 1) { code, _, roles, _, _, _ ->
                    if (code != 0) it.resume(null) else it.resume(roles)
                }
            }
        } ?: return Result.failure(Exception("unable to fetch guild roles"))
        return Result.success(roles)
    }

    fun deleteGuildRole(guildId: ULong, roleId: ULong) {
        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService
        kernelGProService.deleteRole(guildId.toLong(), roleId.toLong()) { code, msg, result ->
            if (code != 0) {
                LogCenter.log("deleteGuildRole failed: $code($msg) => $result", Level.WARN)
            }
        }
    }

    fun setMemberRole(guildId: ULong, tinyId: ULong, roleId: ULong, isSet: Boolean) {
        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService
        val addList = arrayListOf<Long>()
        val rmList = arrayListOf<Long>()
        (if (isSet) addList else rmList).add(roleId.toLong())
        kernelGProService.setMemberRoles(guildId.toLong(), 0, 0, tinyId.toLong(), addList, rmList) { code, msg, result ->
            if (code != 0) {
                LogCenter.log("setMemberRole failed: $code($msg) => $result", Level.WARN)
            }
        }
    }

    suspend fun getGuildRolePermission(guildId: ULong, roleId: ULong): Result<GProGuildRole> {
        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService
        val role:GProGuildRole = withTimeoutOrNull(5000) {
            suspendCancellableCoroutine {
                kernelGProService.fetchRoleWithPermission(guildId.toLong(), roleId.toLong(), 1) { code, msg, role, _, _, _ ->
                    if (code != 0) {
                        LogCenter.log("getGuildRolePermission failed: $code($msg)", Level.WARN)
                        it.resume(null)
                    } else it.resume(role)
                }
            }
        } ?: return Result.failure(Exception("unable to fetch guild role permission"))
        return Result.success(role)
    }

    suspend fun updateGuildRole(guildId: ULong, roleId: ULong, name: String, color: Long): Result<Unit> {
        val oldInfo = getGuildRolePermission(guildId, roleId).onFailure {
            return Result.failure(it)
        }.getOrThrow()
        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService
        val info = GProRoleCreateInfo(
            name, color, oldInfo.bHoist, oldInfo.rolePermissions
        )
        kernelGProService.setRoleInfo(guildId.toLong(), roleId.toLong(), info) { code, msg, result ->
            if (code != 0) {
                LogCenter.log("updateGuildRole failed: $code($msg) => $result", Level.WARN)
            }
        }
        return Result.success(Unit)
    }

    suspend fun createGuildRole(guildId: ULong, name: String, color: Long, initialUsers: ArrayList<Long>): Result<GProGuildRole> {
        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService
        val permission = GProRolePermission(false, arrayListOf())
        val info = GProRoleCreateInfo(name, color, false, permission)
        val role: GProGuildRole = withTimeoutOrNull(5000) {
            suspendCancellableCoroutine {
                kernelGProService.createRole(guildId.toLong(), info, initialUsers) { code, msg, result, role ->
                    if (code != 0) {
                        LogCenter.log("createGuildRole failed: $code($msg) => $result", Level.WARN)
                        it.resume(null)
                    } else it.resume(role)
                }
            }
        } ?: return Result.failure(Exception("unable to create guild role"))
        return Result.success(role)
    }
}