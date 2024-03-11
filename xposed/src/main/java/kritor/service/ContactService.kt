package kritor.service

import android.os.Bundle
import com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst.*
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService
import com.tencent.mobileqq.qroute.QRoute
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.contact.ContactServiceGrpcKt
import io.kritor.contact.GetUidRequest
import io.kritor.contact.GetUidResponse
import io.kritor.contact.GetUinByUidRequest
import io.kritor.contact.GetUinByUidResponse
import io.kritor.contact.IsBlackListUserRequest
import io.kritor.contact.IsBlackListUserResponse
import io.kritor.contact.ProfileCard
import io.kritor.contact.ProfileCardRequest
import io.kritor.contact.SetProfileCardRequest
import io.kritor.contact.SetProfileCardResponse
import io.kritor.contact.StrangerExt
import io.kritor.contact.StrangerInfo
import io.kritor.contact.StrangerInfoRequest
import io.kritor.contact.profileCard
import io.kritor.contact.strangerInfo
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import qq.service.QQInterfaces
import qq.service.contact.ContactHelper
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

object ContactService: ContactServiceGrpcKt.ContactServiceCoroutineImplBase() {
    @Grpc("ContactService", "GetProfileCard")
    override suspend fun getProfileCard(request: ProfileCardRequest): ProfileCard {
        val uin = if (request.hasUin()) request.uin
        else ContactHelper.getUinByUidAsync(request.uid).toLong()
        val contact = ContactHelper.getProfileCard(uin)

        contact.onFailure {
            throw StatusRuntimeException(Status.INTERNAL
                .withDescription(it.stackTraceToString())
            )
        }

        contact.onSuccess {
            return profileCard {
                this.uin = it.uin.toLong()
                this.uid = if (request.hasUid()) request.uid
                else ContactHelper.getUidByUinAsync(it.uin.toLong())
                this.name = it.strNick ?: ""
                this.remark = it.strReMark ?: ""
                this.level = it.iQQLevel
                this.birthday = it.lBirthday
                this.loginDay = it.lLoginDays.toInt()
                this.voteCnt = it.lVoteCount.toInt()
                this.qid = it.qid ?: ""
                this.isSchoolVerified = it.schoolVerifiedFlag
            }
        }

        throw StatusRuntimeException(Status.INTERNAL
            .withDescription("logic failed")
        )
    }

    @Grpc("ContactService", "GetStrangerInfo")
    override suspend fun getStrangerInfo(request: StrangerInfoRequest): StrangerInfo {
        val userId = request.uin
        val info = ContactHelper.refreshAndGetProfileCard(userId).onFailure {
            throw StatusRuntimeException(Status.INTERNAL
                .withCause(it)
                .withDescription("Unable to fetch stranger info")
            )
        }.getOrThrow()

        return strangerInfo {
            this.uid = ContactHelper.getUidByUinAsync(userId)
            this.uin = (info.uin ?: "0").toLong()
            this.name = info.strNick ?: ""
            this.level = info.iQQLevel
            this.loginDay = info.lLoginDays.toInt()
            this.voteCnt = info.lVoteCount.toInt()
            this.qid = info.qid ?: ""
            this.isSchoolVerified = info.schoolVerifiedFlag
            this.ext = StrangerExt.newBuilder()
                .setBigVip(info.bBigClubVipOpen == 1.toByte())
                .setHollywoodVip(info.bHollywoodVipOpen == 1.toByte())
                .setQqVip(info.bQQVipOpen == 1.toByte())
                .setSuperVip(info.bSuperQQOpen == 1.toByte())
                .setVoted(info.bVoted == 1.toByte())
                .build().toByteString()
        }
    }

    @Grpc("ContactService", "GetUid")
    override suspend fun getUid(request: GetUidRequest): GetUidResponse {
        return GetUidResponse.newBuilder().apply {
            request.uinList.forEach {
                putUid(it, ContactHelper.getUidByUinAsync(it))
            }
        }.build()
    }

    @Grpc("ContactService", "GetUinByUid")
    override suspend fun getUinByUid(request: GetUinByUidRequest): GetUinByUidResponse {
        return GetUinByUidResponse.newBuilder().apply {
            request.uidList.forEach {
                putUin(it, ContactHelper.getUinByUidAsync(it).toLong())
            }
        }.build()
    }

    @Grpc("ContactService", "SetProfileCard")
    override suspend fun setProfileCard(request: SetProfileCardRequest): SetProfileCardResponse {
        val bundle = Bundle()
        val service = QQInterfaces.app
            .getRuntimeService(IProfileProtocolService::class.java, "all")
        if (request.hasNickName()) {
            bundle.putString(KEY_NICK, request.nickName)
        }
        if (request.hasCompany()) {
            bundle.putString(KEY_COMPANY, request.company)
        }
        if (request.hasEmail()) {
            bundle.putString(KEY_EMAIL, request.email)
        }
        if (request.hasCollege()) {
            bundle.putString(KEY_COLLEGE, request.college)
        }
        if (request.hasPersonalNote()) {
            bundle.putString(KEY_PERSONAL_NOTE, request.personalNote)
        }

        if (request.hasBirthday()) {
            bundle.putInt(KEY_BIRTHDAY, request.birthday)
        }
        if (request.hasAge()) {
            bundle.putInt(KEY_AGE, request.age)
        }

        service.setProfileDetail(bundle)
        return super.setProfileCard(request)
    }

    @Grpc("ContactService", "IsBlackListUser")
    override suspend fun isBlackListUser(request: IsBlackListUserRequest): IsBlackListUserResponse {
        val blacklistApi = QRoute.api(IProfileCardBlacklistApi::class.java)
        val isBlack = withTimeoutOrNull(5000) {
            suspendCancellableCoroutine { continuation ->
                blacklistApi.isBlackOrBlackedUin(request.uin.toString()) {
                    continuation.resume(it)
                }
            }
        } ?: false
        return IsBlackListUserResponse.newBuilder().setIsBlackListUser(isBlack).build()
    }
}