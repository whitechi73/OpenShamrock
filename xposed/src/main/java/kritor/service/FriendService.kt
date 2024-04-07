package kritor.service

import android.os.Bundle
import com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService
import com.tencent.mobileqq.qroute.QRoute
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.friend.*
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import qq.service.QQInterfaces
import qq.service.contact.ContactHelper
import qq.service.friend.FriendHelper
import kotlin.coroutines.resume

internal object FriendService : FriendServiceGrpcKt.FriendServiceCoroutineImplBase() {
    @Grpc("FriendService", "GetFriendList")
    override suspend fun getFriendList(request: GetFriendListRequest): GetFriendListResponse {
        val friendList = FriendHelper.getFriendList(if (request.hasRefresh()) request.refresh else false).onFailure {
            throw StatusRuntimeException(
                Status.INTERNAL
                    .withDescription(it.stackTraceToString())
            )
        }.getOrThrow()

        return GetFriendListResponse.newBuilder().apply {
            friendList.forEach {
                this.addFriendsInfo(FriendInfo.newBuilder().apply {
                    uin = it.uin.toLong()
                    uid = ContactHelper.getUidByUinAsync(uin)
                    qid = ""
                    nick = it.name ?: ""
                    remark = it.remark ?: ""
                    age = it.age
                    level = 0
                    gender = it.gender.toInt()
                    groupId = it.groupid

                    ext = ExtInfo.newBuilder().build()
                })
            }
        }.build()
    }

    @Grpc("FriendService", "GetFriendProfileCard")
    override suspend fun getFriendProfileCard(request: GetFriendProfileCardRequest): GetFriendProfileCardResponse {
        return GetFriendProfileCardResponse.newBuilder().apply {
            request.targetUinsList.forEach {
                ContactHelper.getProfileCard(it).getOrThrow().let { info ->
                    addFriendsProfileCard(ProfileCard.newBuilder().apply {
                        this.uin = info.uin.toLong()
                        this.uid = ContactHelper.getUidByUinAsync(info.uin.toLong())
                        this.nick = info.strNick
                        this.remark = info.strReMark
                        this.level = info.iQQLevel
                        this.birthday = info.lBirthday
                        this.loginDay = info.lLoginDays.toInt()
                        this.voteCnt = info.lVoteCount.toInt()
                        this.qid = info.qid ?: ""
                        this.isSchoolVerified = info.schoolVerifiedFlag

                        this.ext = ExtInfo.newBuilder().apply {
                            this.bigVip = info.bBigClubVipOpen == 1.toByte()
                            this.hollywoodVip = info.bHollywoodVipOpen == 1.toByte()
                            this.qqVip = info.bQQVipOpen == 1.toByte()
                            this.superVip = info.bSuperQQOpen == 1.toByte()
                            this.voted = info.bVoted == 1.toByte()
                        }.build()
                    }.build())
                }
            }
            request.targetUidsList.forEach {
                ContactHelper.getProfileCard(ContactHelper.getUinByUidAsync(it).toLong()).getOrThrow().let { info ->
                    addFriendsProfileCard(ProfileCard.newBuilder().apply {
                        this.uin = info.uin.toLong()
                        this.uid = it
                        this.nick = info.strNick
                        this.remark = info.strReMark
                        this.level = info.iQQLevel
                        this.birthday = info.lBirthday
                        this.loginDay = info.lLoginDays.toInt()
                        this.voteCnt = info.lVoteCount.toInt()
                        this.qid = info.qid ?: ""
                        this.isSchoolVerified = info.schoolVerifiedFlag

                        this.ext = ExtInfo.newBuilder().apply {
                            this.bigVip = info.bBigClubVipOpen == 1.toByte()
                            this.hollywoodVip = info.bHollywoodVipOpen == 1.toByte()
                            this.qqVip = info.bQQVipOpen == 1.toByte()
                            this.superVip = info.bSuperQQOpen == 1.toByte()
                            this.voted = info.bVoted == 1.toByte()
                        }.build()
                    }.build())
                }
            }
        }.build()
    }

    @Grpc("FriendService", "GetStrangerProfileCard")
    override suspend fun getStrangerProfileCard(request: GetStrangerProfileCardRequest): GetStrangerProfileCardResponse {
        return GetStrangerProfileCardResponse.newBuilder().apply {
            request.targetUinsList.forEach {
                ContactHelper.refreshAndGetProfileCard(it).getOrThrow().let { info ->
                    addStrangersProfileCard(ProfileCard.newBuilder().apply {
                        this.uin = info.uin.toLong()
                        this.uid = ContactHelper.getUidByUinAsync(info.uin.toLong())
                        this.nick = info.strNick
                        this.level = info.iQQLevel
                        this.birthday = info.lBirthday
                        this.loginDay = info.lLoginDays.toInt()
                        this.voteCnt = info.lVoteCount.toInt()
                        this.qid = info.qid ?: ""
                        this.isSchoolVerified = info.schoolVerifiedFlag

                        this.ext = ExtInfo.newBuilder().apply {
                            this.bigVip = info.bBigClubVipOpen == 1.toByte()
                            this.hollywoodVip = info.bHollywoodVipOpen == 1.toByte()
                            this.qqVip = info.bQQVipOpen == 1.toByte()
                            this.superVip = info.bSuperQQOpen == 1.toByte()
                            this.voted = info.bVoted == 1.toByte()
                        }.build()
                    }.build())
                }
            }
            request.targetUidsList.forEach {
                ContactHelper.refreshAndGetProfileCard(ContactHelper.getUinByUidAsync(it).toLong()).getOrThrow()
                    .let { info ->
                        addStrangersProfileCard(ProfileCard.newBuilder().apply {
                            this.uin = info.uin.toLong()
                            this.uid = it
                            this.nick = info.strNick
                            this.level = info.iQQLevel
                            this.birthday = info.lBirthday
                            this.loginDay = info.lLoginDays.toInt()
                            this.voteCnt = info.lVoteCount.toInt()
                            this.qid = info.qid ?: ""
                            this.isSchoolVerified = info.schoolVerifiedFlag

                            this.ext = ExtInfo.newBuilder().apply {
                                this.bigVip = info.bBigClubVipOpen == 1.toByte()
                                this.hollywoodVip = info.bHollywoodVipOpen == 1.toByte()
                                this.qqVip = info.bQQVipOpen == 1.toByte()
                                this.superVip = info.bSuperQQOpen == 1.toByte()
                                this.voted = info.bVoted == 1.toByte()
                            }.build()
                        }.build())
                    }
            }
        }.build()
    }

    @Grpc("FriendService", "SetProfileCard")
    override suspend fun setProfileCard(request: SetProfileCardRequest): SetProfileCardResponse {
        val bundle = Bundle()
        val service = QQInterfaces.app
            .getRuntimeService(IProfileProtocolService::class.java, "all")
        if (request.hasNickName()) {
            bundle.putString(IProfileProtocolConst.KEY_NICK, request.nickName)
        }
        if (request.hasCompany()) {
            bundle.putString(IProfileProtocolConst.KEY_COMPANY, request.company)
        }
        if (request.hasEmail()) {
            bundle.putString(IProfileProtocolConst.KEY_EMAIL, request.email)
        }
        if (request.hasCollege()) {
            bundle.putString(IProfileProtocolConst.KEY_COLLEGE, request.college)
        }
        if (request.hasPersonalNote()) {
            bundle.putString(IProfileProtocolConst.KEY_PERSONAL_NOTE, request.personalNote)
        }

        if (request.hasBirthday()) {
            bundle.putInt(IProfileProtocolConst.KEY_BIRTHDAY, request.birthday)
        }
        if (request.hasAge()) {
            bundle.putInt(IProfileProtocolConst.KEY_AGE, request.age)
        }

        service.setProfileDetail(bundle)
        return super.setProfileCard(request)
    }

    @Grpc("FriendService", "IsBlackListUser")
    override suspend fun isBlackListUser(request: IsBlackListUserRequest): IsBlackListUserResponse {
        val uin = when (request.targetCase!!) {
            IsBlackListUserRequest.TargetCase.TARGET_UIN -> request.targetUin.toString()
            IsBlackListUserRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid)
            IsBlackListUserRequest.TargetCase.TARGET_NOT_SET -> throw StatusRuntimeException(
                Status.INVALID_ARGUMENT
                    .withDescription("account not set")
            )
        }
        val blacklistApi = QRoute.api(IProfileCardBlacklistApi::class.java)
        val isBlack = withTimeoutOrNull(5000) {
            suspendCancellableCoroutine { continuation ->
                blacklistApi.isBlackOrBlackedUin(uin) {
                    continuation.resume(it)
                }
            }
        } ?: false
        return IsBlackListUserResponse.newBuilder().setIsBlackListUser(isBlack).build()
    }

    @Grpc("FriendService", "VoteUser")
    override suspend fun voteUser(request: VoteUserRequest): VoteUserResponse {
        ContactHelper.voteUser(
            when (request.targetCase!!) {
                VoteUserRequest.TargetCase.TARGET_UIN -> request.targetUin
                VoteUserRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid).toLong()
                VoteUserRequest.TargetCase.TARGET_NOT_SET -> throw StatusRuntimeException(
                    Status.INVALID_ARGUMENT
                        .withDescription("account not set")
                )
            }, request.voteCount
        ).onFailure {
            throw StatusRuntimeException(
                Status.INTERNAL
                    .withDescription(it.stackTraceToString())
            )
        }
        return VoteUserResponse.newBuilder().build()
    }

    @Grpc("FriendService", "GetUidByUin")
    override suspend fun getUidByUin(request: GetUidByUinRequest): GetUidByUinResponse {
        return GetUidByUinResponse.newBuilder().apply {
            request.targetUinsList.forEach {
                putUidMap(it, ContactHelper.getUidByUinAsync(it))
            }
        }.build()
    }

    @Grpc("FriendService", "GetUinByUid")
    override suspend fun getUinByUid(request: GetUinByUidRequest): GetUinByUidResponse {
        return GetUinByUidResponse.newBuilder().apply {
            request.targetUidsList.forEach {
                putUinMap(it, ContactHelper.getUinByUidAsync(it).toLong())
            }
        }.build()
    }
}