@file:OptIn(ExperimentalSerializationApi::class)

package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.qqguildsdk.api.IGPSService
import com.tencent.qqnt.kernel.nativeinterface.GProRoleMemberList
import com.tencent.qqnt.kernel.nativeinterface.GProUser
import com.tencent.qqnt.kernel.nativeinterface.IGProGetUserInfoCallback
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import moe.fuqiuluo.qqinterface.servlet.structures.GuildInfo
import moe.fuqiuluo.qqinterface.servlet.structures.GuildStatus
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
import moe.whitechi73.protobuf.oidb.cmx0xf57.Oidb0xf57Meta
import moe.whitechi73.protobuf.oidb.cmx0xf57.Oidb0xf57MetaInfo
import moe.whitechi73.protobuf.oidb.cmx0xf57.Oidb0xf57Req
import moe.whitechi73.protobuf.oidb.cmx0xf57.Oidb0xf57Rsp
import moe.whitechi73.protobuf.oidb.cmx0xf57.Oidb0xf57U1
import moe.whitechi73.protobuf.oidb.cmx0xf57.Oidb0xf57U2
import tencent.im.oidb.cmd0xeac.oidb_0xeac
import tencent.im.oidb.oidb_sso

internal object GProSvc: BaseSvc() {
    fun getSelfTinyId(): ULong {
        val service = app.getRuntimeService(IGPSService::class.java, "all")
        return service.selfTinyId.toULong()
    }

    suspend fun getGuildInfo(guildId: ULong): Result<Oidb0xf57MetaInfo> {
        val respBuffer = sendOidbAW("OidbSvcTrpcTcp.0xf57_9", 0xf57, 9, ProtoBuf.encodeToByteArray(Oidb0xf57Req(
            filter = Oidb0xf57Filter(
                u1 = Oidb0xf57U1(1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u),
                u2 = Oidb0xf57U2(1u, 1u, 1u, 1u, 1u, 1u, 1u, 1u)
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

    suspend fun getGuildMemberList(guildId: ULong): Result<List<GProRoleMemberList>> {
        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService
        //kernelGProService.fetchMemberListWithRole()

        return Result.failure(Exception("todo"))
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

    fun getGuildList(refresh: Boolean = false): ArrayList<GuildInfo> {
        PlatformUtils.requireMinQQVersion(version = PlatformUtils.QQ_9_0_8_VER)

        val kernelGProService = NTServiceFetcher.kernelService.wrapperSession.guildService
        if (refresh) {
            kernelGProService.refreshGuildList(true)
            kernelGProService.guildListFromCache.forEach {
                kernelGProService.refreshGuildInfo(it.guildId, true, 1)
            }
        }

        val result = arrayListOf<GuildInfo>()
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

        return result
    }
}