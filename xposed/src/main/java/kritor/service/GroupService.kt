package kritor.service

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.group.*
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.TroopHonorHelper.decodeHonor
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import qq.service.contact.ContactHelper
import qq.service.group.GroupHelper
import tencent.im.troop.honor.troop_honor

internal object GroupService : GroupServiceGrpcKt.GroupServiceCoroutineImplBase() {
    @Grpc("GroupService", "BanMember")
    override suspend fun banMember(request: BanMemberRequest): BanMemberResponse {
        if (!GroupHelper.isAdmin(request.groupId.toString())) {
            throw StatusRuntimeException(
                Status.PERMISSION_DENIED
                    .withDescription("You are not admin of this group")
            )
        }

        GroupHelper.banMember(
            request.groupId, when (request.targetCase!!) {
                BanMemberRequest.TargetCase.TARGET_UIN -> request.targetUin
                BanMemberRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid).toLong()
                else -> throw StatusRuntimeException(
                    Status.INVALID_ARGUMENT
                        .withDescription("target not set")
                )
            }, request.duration
        )

        return BanMemberResponse.newBuilder().apply {
            groupId = request.groupId
        }.build()
    }

    @Grpc("GroupService", "PokeMember")
    override suspend fun pokeMember(request: PokeMemberRequest): PokeMemberResponse {
        GroupHelper.pokeMember(
            request.groupId, when (request.targetCase!!) {
                PokeMemberRequest.TargetCase.TARGET_UIN -> request.targetUin
                PokeMemberRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid).toLong()
                else -> throw StatusRuntimeException(
                    Status.INVALID_ARGUMENT
                        .withDescription("target not set")
                )
            }
        )
        return PokeMemberResponse.newBuilder().build()
    }

    @Grpc("GroupService", "KickMember")
    override suspend fun kickMember(request: KickMemberRequest): KickMemberResponse {
        if (!GroupHelper.isAdmin(request.groupId.toString())) {
            throw StatusRuntimeException(
                Status.PERMISSION_DENIED
                    .withDescription("You are not admin of this group")
            )
        }
        GroupHelper.kickMember(
            request.groupId,
            request.rejectAddRequest,
            if (request.hasKickReason()) request.kickReason else "",
            when (request.targetCase!!) {
                KickMemberRequest.TargetCase.TARGET_UIN -> request.targetUin
                KickMemberRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid).toLong()
                else -> throw StatusRuntimeException(
                    Status.INVALID_ARGUMENT
                        .withDescription("target not set")
                )
            }
        )
        return KickMemberResponse.newBuilder().build()
    }

    @Grpc("GroupService", "LeaveGroup")
    override suspend fun leaveGroup(request: LeaveGroupRequest): LeaveGroupResponse {
        GroupHelper.resignTroop(request.groupId.toString())
        return LeaveGroupResponse.newBuilder().build()
    }

    @Grpc("GroupService", "ModifyMemberCard")
    override suspend fun modifyMemberCard(request: ModifyMemberCardRequest): ModifyMemberCardResponse {
        if (!GroupHelper.isAdmin(request.groupId.toString())) {
            throw StatusRuntimeException(
                Status.PERMISSION_DENIED
                    .withDescription("You are not admin of this group")
            )
        }
        GroupHelper.modifyGroupMemberCard(
            request.groupId, when (request.targetCase!!) {
                ModifyMemberCardRequest.TargetCase.TARGET_UIN -> request.targetUin
                ModifyMemberCardRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid)
                    .toLong()

                else -> throw StatusRuntimeException(
                    Status.INVALID_ARGUMENT
                        .withDescription("target not set")
                )
            }, request.card
        )
        return ModifyMemberCardResponse.newBuilder().build()
    }

    @Grpc("GroupService", "ModifyGroupName")
    override suspend fun modifyGroupName(request: ModifyGroupNameRequest): ModifyGroupNameResponse {
        if (!GroupHelper.isAdmin(request.groupId.toString())) {
            throw StatusRuntimeException(
                Status.PERMISSION_DENIED
                    .withDescription("You are not admin of this group")
            )
        }

        GroupHelper.modifyTroopName(request.groupId.toString(), request.groupName)

        return ModifyGroupNameResponse.newBuilder().build()
    }

    @Grpc("GroupService", "ModifyGroupRemark")
    override suspend fun modifyGroupRemark(request: ModifyGroupRemarkRequest): ModifyGroupRemarkResponse {
        GroupHelper.modifyGroupRemark(request.groupId, request.remark)

        return ModifyGroupRemarkResponse.newBuilder().build()
    }

    @Grpc("GroupService", "SetGroupAdmin")
    override suspend fun setGroupAdmin(request: SetGroupAdminRequest): SetGroupAdminResponse {
        if (!GroupHelper.isOwner(request.groupId.toString())) {
            throw StatusRuntimeException(
                Status.PERMISSION_DENIED
                    .withDescription("You are not admin of this group")
            )
        }

        GroupHelper.setGroupAdmin(
            request.groupId, when (request.targetCase!!) {
                SetGroupAdminRequest.TargetCase.TARGET_UIN -> request.targetUin
                SetGroupAdminRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid).toLong()
                else -> throw StatusRuntimeException(
                    Status.INVALID_ARGUMENT
                        .withDescription("target not set")
                )
            }, request.isAdmin
        )

        return SetGroupAdminResponse.newBuilder().build()
    }

    @Grpc("GroupService", "SetGroupUniqueTitle")
    override suspend fun setGroupUniqueTitle(request: SetGroupUniqueTitleRequest): SetGroupUniqueTitleResponse {
        if (!GroupHelper.isAdmin(request.groupId.toString())) {
            throw StatusRuntimeException(
                Status.PERMISSION_DENIED
                    .withDescription("You are not admin of this group")
            )
        }

        GroupHelper.setGroupUniqueTitle(
            request.groupId.toString(), when (request.targetCase!!) {
                SetGroupUniqueTitleRequest.TargetCase.TARGET_UIN -> request.targetUin
                SetGroupUniqueTitleRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid)
                    .toLong()

                else -> throw StatusRuntimeException(
                    Status.INVALID_ARGUMENT
                        .withDescription("target not set")
                )
            }.toString(), request.uniqueTitle
        )

        return SetGroupUniqueTitleResponse.newBuilder().build()
    }

    @Grpc("GroupService", "SetGroupWholeBan")
    override suspend fun setGroupWholeBan(request: SetGroupWholeBanRequest): SetGroupWholeBanResponse {
        if (!GroupHelper.isAdmin(request.groupId.toString())) {
            throw StatusRuntimeException(
                Status.PERMISSION_DENIED
                    .withDescription("You are not admin of this group")
            )
        }

        GroupHelper.setGroupWholeBan(request.groupId, request.isBan)
        return SetGroupWholeBanResponse.newBuilder().build()
    }

    @Grpc("GroupService", "GetGroupInfo")
    override suspend fun getGroupInfo(request: GetGroupInfoRequest): GetGroupInfoResponse {
        val groupInfo = GroupHelper.getGroupInfo(request.groupId.toString(), true).onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to get group info").withCause(it))
        }.getOrThrow()
        return GetGroupInfoResponse.newBuilder().apply {
            this.groupInfo = GroupInfo.newBuilder().apply {
                groupId = groupInfo.troopcode.toLong()
                groupName =
                    groupInfo.troopname.ifNullOrEmpty { groupInfo.troopRemark }.ifNullOrEmpty { groupInfo.newTroopName }
                        ?: ""
                groupRemark = groupInfo.troopRemark ?: ""
                owner = groupInfo.troopowneruin?.toLong() ?: 0
                addAllAdmins(GroupHelper.getAdminList(groupId))
                maxMemberCount = groupInfo.wMemberMax
                memberCount = groupInfo.wMemberNum
                groupUin = groupInfo.troopuin?.toLong() ?: 0
            }.build()
        }.build()
    }

    @Grpc("GroupService", "GetGroupList")
    override suspend fun getGroupList(request: GetGroupListRequest): GetGroupListResponse {
        val groupList = GroupHelper.getGroupList(if (request.hasRefresh()) request.refresh else false).onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to get group list").withCause(it))
        }.getOrThrow()
        return GetGroupListResponse.newBuilder().apply {
            groupList.forEach { groupInfo ->
                this.addGroupsInfo(GroupInfo.newBuilder().apply {
                    groupId = groupInfo.troopcode.ifNullOrEmpty { groupInfo.uin }.ifNullOrEmpty { groupInfo.troopuin }?.toLong() ?: 0
                    groupName = groupInfo.troopname.ifNullOrEmpty { groupInfo.troopRemark }
                        .ifNullOrEmpty { groupInfo.newTroopName }
                        ?: ""
                    groupRemark = groupInfo.troopRemark ?: ""
                    owner = groupInfo.troopowneruin?.toLong() ?: 0
                    addAllAdmins(GroupHelper.getAdminList(groupId))
                    maxMemberCount = groupInfo.wMemberMax
                    memberCount = groupInfo.wMemberNum
                    groupUin = groupInfo.troopuin?.toLong() ?: 0
                })
            }
        }.build()
    }

    @Grpc("GroupService", "GetGroupMemberInfo")
    override suspend fun getGroupMemberInfo(request: GetGroupMemberInfoRequest): GetGroupMemberInfoResponse {
        val memberInfo = GroupHelper.getTroopMemberInfoByUin(
            request.groupId.toString(), when (request.targetCase!!) {
                GetGroupMemberInfoRequest.TargetCase.TARGET_UID -> request.targetUin
                GetGroupMemberInfoRequest.TargetCase.TARGET_UIN -> ContactHelper.getUinByUidAsync(request.targetUid).toLong()
                else -> throw StatusRuntimeException(
                    Status.INVALID_ARGUMENT
                        .withDescription("target not set")
                )
            }.toString()
        ).onFailure {
            throw StatusRuntimeException(
                Status.INTERNAL.withDescription("unable to get group member info").withCause(it)
            )
        }.getOrThrow()
        return GetGroupMemberInfoResponse.newBuilder().apply {
            groupMemberInfo = GroupMemberInfo.newBuilder().apply {
                uid =
                    if (request.targetCase == GetGroupMemberInfoRequest.TargetCase.TARGET_UID) request.targetUid else ContactHelper.getUidByUinAsync(
                        request.targetUin
                    )
                uin = memberInfo.memberuin?.toLong() ?: 0
                nick = memberInfo.troopnick
                    .ifNullOrEmpty { memberInfo.hwName }
                    .ifNullOrEmpty { memberInfo.troopColorNick }
                    .ifNullOrEmpty { memberInfo.friendnick } ?: ""
                age = memberInfo.age.toInt()
                uniqueTitle = memberInfo.mUniqueTitle ?: ""
                uniqueTitleExpireTime = memberInfo.mUniqueTitleExpire.toLong()
                card = memberInfo.troopnick.ifNullOrEmpty { memberInfo.friendnick } ?: ""
                joinTime = memberInfo.join_time
                lastActiveTime = memberInfo.last_active_time
                level = memberInfo.level
                shutUpTime = memberInfo.gagTimeStamp

                distance = memberInfo.distance
                addAllHonors((memberInfo.honorList ?: "")
                    .split("|")
                    .filter { it.isNotBlank() }
                    .map { it.toInt() })
                unfriendly = false
                cardChangeable = GroupHelper.isAdmin(request.groupId.toString())
            }.build()
        }.build()
    }

    @Grpc("GroupService", "GetGroupMemberList")
    override suspend fun getGroupMemberList(request: GetGroupMemberListRequest): GetGroupMemberListResponse {
        val memberList = GroupHelper.getGroupMemberList(
            request.groupId,
            if (request.hasRefresh()) request.refresh else false
        ).onFailure {
            throw StatusRuntimeException(
                Status.INTERNAL.withDescription("unable to get group member list").withCause(it)
            )
        }.getOrThrow()
        return GetGroupMemberListResponse.newBuilder().apply {
            memberList.values.forEach { memberInfo ->
                this.addGroupMembersInfo(GroupMemberInfo.newBuilder().apply {
                    uid = memberInfo.uid
                    uin = memberInfo.uin
                    nick = memberInfo.nick ?: ""
                    age = 0
                    uniqueTitle = memberInfo.memberSpecialTitle ?: ""
                    uniqueTitleExpireTime = memberInfo.specialTitleExpireTime
                    card = memberInfo.cardName.ifNullOrEmpty { memberInfo.nick } ?: ""
                    joinTime = memberInfo.joinTime.toLong()
                    lastActiveTime = memberInfo.lastSpeakTime.toLong()
                    level = memberInfo.memberLevel
                    shutUpTime = memberInfo.shutUpTime.toLong()

                    distance = 0
                    addAllHonors(memberInfo.groupHonor.let { bytes ->
                        val honor = troop_honor.GroupUserCardHonor()
                        honor.mergeFrom(bytes)
                        honor.id.get()
                    })
                    unfriendly = false
                    cardChangeable = memberInfo.role == com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole.ADMIN
                })
            }
        }.build()
    }

    @Grpc("GroupService", "GetProhibitedUserList")
    override suspend fun getProhibitedUserList(request: GetProhibitedUserListRequest): GetProhibitedUserListResponse {
        val prohibitedList = GroupHelper.getProhibitedMemberList(request.groupId).onFailure {
            throw StatusRuntimeException(
                Status.INTERNAL.withDescription("unable to get prohibited user list").withCause(it)
            )
        }.getOrThrow()
        return GetProhibitedUserListResponse.newBuilder().apply {
            prohibitedList.forEach {
                this.addProhibitedUsersInfo(ProhibitedUserInfo.newBuilder().apply {
                    uid = ContactHelper.getUidByUinAsync(it.memberUin)
                    uin = it.memberUin
                    prohibitedTime = it.shutuptimestap.toLong()
                })
            }
        }.build()
    }

    @Grpc("GroupService", "GetRemainCountAtAll")
    override suspend fun getRemainCountAtAll(request: GetRemainCountAtAllRequest): GetRemainCountAtAllResponse {
        val remainAtAllRsp = GroupHelper.getGroupRemainAtAllRemain(request.groupId).onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to get remain count").withCause(it))
        }.getOrThrow()
        return GetRemainCountAtAllResponse.newBuilder().apply {
            accessAtAll = remainAtAllRsp.bool_can_at_all.get()
            remainCountForGroup = remainAtAllRsp.uint32_remain_at_all_count_for_group.get()
            remainCountForSelf = remainAtAllRsp.uint32_remain_at_all_count_for_uin.get()
        }.build()
    }

    @Grpc("GroupService", "GetNotJoinedGroupInfo")
    override suspend fun getNotJoinedGroupInfo(request: GetNotJoinedGroupInfoRequest): GetNotJoinedGroupInfoResponse {
        val groupInfo = GroupHelper.getNotJoinedGroupInfo(request.groupId).onFailure {
            throw StatusRuntimeException(
                Status.INTERNAL.withDescription("unable to get not joined group info").withCause(it)
            )
        }.getOrThrow()
        return GetNotJoinedGroupInfoResponse.newBuilder().apply {
            this.groupInfo = NotJoinedGroupInfo.newBuilder().apply {
                groupId = groupInfo.groupId
                groupName = groupInfo.groupName
                owner = groupInfo.owner
                maxMemberCount = groupInfo.maxMember
                memberCount = groupInfo.memberCount
                groupDesc = groupInfo.groupDesc
                createTime = groupInfo.createTime
                groupFlag = groupInfo.groupFlag
                groupFlagExt = groupInfo.groupFlagExt
            }.build()
        }.build()
    }

    @Grpc("GroupService", "GetGroupHonor")
    override suspend fun getGroupHonor(request: GetGroupHonorRequest): GetGroupHonorResponse {
        return GetGroupHonorResponse.newBuilder().apply {
            GroupHelper.getGroupMemberList(request.groupId, true).onFailure {
                throw StatusRuntimeException(
                    Status.INTERNAL.withDescription("unable to get group member list").withCause(it)
                )
            }.onSuccess { memberList ->
                memberList.values.forEach { member ->
                    member.groupHonor.let { bytes ->
                        val honor = troop_honor.GroupUserCardHonor()
                        honor.mergeFrom(bytes)
                        honor.id.get()
                    }.forEach {
                            val honor = decodeHonor(member.uin, it, 0)
                            if (honor != null) {
                                addGroupHonorsInfo(GroupHonorInfo.newBuilder().apply {
                                    uid = member.uid
                                    uin = member.uin
                                    nick = member.nick.ifEmpty {
                                        member.cardName
                                    } ?: ""
                                    honorName = honor.honorName
                                    avatar = honor.honorIconUrl
                                    id = honor.honorId
                                    description = honor.honorUrl
                                })
                            }
                        }
                }
            }
        }.build()
    }
}