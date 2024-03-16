package kritor.service

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.group.BanMemberRequest
import io.kritor.group.BanMemberResponse
import io.kritor.group.GetGroupHonorRequest
import io.kritor.group.GetGroupHonorResponse
import io.kritor.group.GetGroupInfoRequest
import io.kritor.group.GetGroupInfoResponse
import io.kritor.group.GetGroupListRequest
import io.kritor.group.GetGroupListResponse
import io.kritor.group.GetGroupMemberInfoRequest
import io.kritor.group.GetGroupMemberInfoResponse
import io.kritor.group.GetGroupMemberListRequest
import io.kritor.group.GetGroupMemberListResponse
import io.kritor.group.GetNotJoinedGroupInfoRequest
import io.kritor.group.GetNotJoinedGroupInfoResponse
import io.kritor.group.GetProhibitedUserListRequest
import io.kritor.group.GetProhibitedUserListResponse
import io.kritor.group.GetRemainCountAtAllRequest
import io.kritor.group.GetRemainCountAtAllResponse
import io.kritor.group.GroupServiceGrpcKt
import io.kritor.group.KickMemberRequest
import io.kritor.group.KickMemberResponse
import io.kritor.group.LeaveGroupRequest
import io.kritor.group.LeaveGroupResponse
import io.kritor.group.ModifyGroupNameRequest
import io.kritor.group.ModifyGroupNameResponse
import io.kritor.group.ModifyGroupRemarkRequest
import io.kritor.group.ModifyGroupRemarkResponse
import io.kritor.group.ModifyMemberCardRequest
import io.kritor.group.ModifyMemberCardResponse
import io.kritor.group.PokeMemberRequest
import io.kritor.group.PokeMemberResponse
import io.kritor.group.SetGroupAdminRequest
import io.kritor.group.SetGroupAdminResponse
import io.kritor.group.SetGroupUniqueTitleRequest
import io.kritor.group.SetGroupUniqueTitleResponse
import io.kritor.group.SetGroupWholeBanRequest
import io.kritor.group.SetGroupWholeBanResponse
import io.kritor.group.banMemberResponse
import io.kritor.group.getGroupHonorResponse
import io.kritor.group.getGroupInfoResponse
import io.kritor.group.getGroupListResponse
import io.kritor.group.getGroupMemberInfoResponse
import io.kritor.group.getGroupMemberListResponse
import io.kritor.group.getNotJoinedGroupInfoResponse
import io.kritor.group.getProhibitedUserListResponse
import io.kritor.group.getRemainCountAtAllResponse
import io.kritor.group.groupHonorInfo
import io.kritor.group.groupMemberInfo
import io.kritor.group.kickMemberResponse
import io.kritor.group.leaveGroupResponse
import io.kritor.group.modifyGroupNameResponse
import io.kritor.group.modifyGroupRemarkResponse
import io.kritor.group.modifyMemberCardResponse
import io.kritor.group.notJoinedGroupInfo
import io.kritor.group.pokeMemberResponse
import io.kritor.group.prohibitedUserInfo
import io.kritor.group.setGroupAdminResponse
import io.kritor.group.setGroupUniqueTitleResponse
import io.kritor.group.setGroupWholeBanResponse
import moe.fuqiuluo.shamrock.helper.TroopHonorHelper
import moe.fuqiuluo.shamrock.helper.TroopHonorHelper.decodeHonor
import moe.fuqiuluo.shamrock.tools.ifNullOrEmpty
import qq.service.contact.ContactHelper
import qq.service.group.GroupHelper

internal object GroupService: GroupServiceGrpcKt.GroupServiceCoroutineImplBase() {
    @Grpc("GroupService", "BanMember")
    override suspend fun banMember(request: BanMemberRequest): BanMemberResponse {
        if (!GroupHelper.isAdmin(request.groupId.toString())) {
            throw StatusRuntimeException(Status.PERMISSION_DENIED
                .withDescription("You are not admin of this group")
            )
        }

        GroupHelper.banMember(request.groupId, when(request.targetCase!!) {
            BanMemberRequest.TargetCase.TARGET_UIN -> request.targetUin
            BanMemberRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid).toLong()
            else -> throw StatusRuntimeException(Status.INVALID_ARGUMENT
                .withDescription("target not set")
            )
        }, request.duration)

        return banMemberResponse {
            groupId = request.groupId
        }
    }

    @Grpc("GroupService", "PokeMember")
    override suspend fun pokeMember(request: PokeMemberRequest): PokeMemberResponse {
        GroupHelper.pokeMember(request.groupId, when(request.targetCase!!) {
            PokeMemberRequest.TargetCase.TARGET_UIN -> request.targetUin
            PokeMemberRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid).toLong()
            else -> throw StatusRuntimeException(Status.INVALID_ARGUMENT
                .withDescription("target not set")
            )
        })
        return pokeMemberResponse {  }
    }

    @Grpc("GroupService", "KickMember")
    override suspend fun kickMember(request: KickMemberRequest): KickMemberResponse {
        if (!GroupHelper.isAdmin(request.groupId.toString())) {
            throw StatusRuntimeException(Status.PERMISSION_DENIED
                .withDescription("You are not admin of this group")
            )
        }
        GroupHelper.kickMember(request.groupId, request.rejectAddRequest, if (request.hasKickReason()) request.kickReason else "", when(request.targetCase!!) {
            KickMemberRequest.TargetCase.TARGET_UIN -> request.targetUin
            KickMemberRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid).toLong()
            else -> throw StatusRuntimeException(Status.INVALID_ARGUMENT
                .withDescription("target not set")
            )
        })
        return kickMemberResponse {  }
    }

    @Grpc("GroupService", "LeaveGroup")
    override suspend fun leaveGroup(request: LeaveGroupRequest): LeaveGroupResponse {
        GroupHelper.resignTroop(request.groupId.toString())
        return leaveGroupResponse {  }
    }

    @Grpc("GroupService", "ModifyMemberCard")
    override suspend fun modifyMemberCard(request: ModifyMemberCardRequest): ModifyMemberCardResponse {
        if (!GroupHelper.isAdmin(request.groupId.toString())) {
            throw StatusRuntimeException(Status.PERMISSION_DENIED
                .withDescription("You are not admin of this group")
            )
        }
        GroupHelper.modifyGroupMemberCard(request.groupId, when(request.targetCase!!) {
            ModifyMemberCardRequest.TargetCase.TARGET_UIN -> request.targetUin
            ModifyMemberCardRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid).toLong()
            else -> throw StatusRuntimeException(Status.INVALID_ARGUMENT
                .withDescription("target not set")
            )
        }, request.card)
        return modifyMemberCardResponse {  }
    }

    @Grpc("GroupService", "ModifyGroupName")
    override suspend fun modifyGroupName(request: ModifyGroupNameRequest): ModifyGroupNameResponse {
        if (!GroupHelper.isAdmin(request.groupId.toString())) {
            throw StatusRuntimeException(Status.PERMISSION_DENIED
                .withDescription("You are not admin of this group")
            )
        }

        GroupHelper.modifyTroopName(request.groupId.toString(), request.groupName)

        return modifyGroupNameResponse {  }
    }

    @Grpc("GroupService", "ModifyGroupRemark")
    override suspend fun modifyGroupRemark(request: ModifyGroupRemarkRequest): ModifyGroupRemarkResponse {
        GroupHelper.modifyGroupRemark(request.groupId, request.remark)

        return modifyGroupRemarkResponse {  }
    }

    @Grpc("GroupService", "SetGroupAdmin")
    override suspend fun setGroupAdmin(request: SetGroupAdminRequest): SetGroupAdminResponse {
        if (!GroupHelper.isOwner(request.groupId.toString())) {
            throw StatusRuntimeException(Status.PERMISSION_DENIED
                .withDescription("You are not admin of this group")
            )
        }

        GroupHelper.setGroupAdmin(request.groupId, when(request.targetCase!!) {
            SetGroupAdminRequest.TargetCase.TARGET_UIN -> request.targetUin
            SetGroupAdminRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid).toLong()
            else -> throw StatusRuntimeException(Status.INVALID_ARGUMENT
                .withDescription("target not set")
            )
        }, request.isAdmin)

        return setGroupAdminResponse {  }
    }

    @Grpc("GroupService", "SetGroupUniqueTitle")
    override suspend fun setGroupUniqueTitle(request: SetGroupUniqueTitleRequest): SetGroupUniqueTitleResponse {
        if (!GroupHelper.isAdmin(request.groupId.toString())) {
            throw StatusRuntimeException(Status.PERMISSION_DENIED
                .withDescription("You are not admin of this group")
            )
        }

        GroupHelper.setGroupUniqueTitle(request.groupId.toString(), when(request.targetCase!!) {
            SetGroupUniqueTitleRequest.TargetCase.TARGET_UIN -> request.targetUin
            SetGroupUniqueTitleRequest.TargetCase.TARGET_UID -> ContactHelper.getUinByUidAsync(request.targetUid).toLong()
            else -> throw StatusRuntimeException(Status.INVALID_ARGUMENT
                .withDescription("target not set")
            )
        }.toString(), request.uniqueTitle)

        return setGroupUniqueTitleResponse {  }
    }

    @Grpc("GroupService", "SetGroupWholeBan")
    override suspend fun setGroupWholeBan(request: SetGroupWholeBanRequest): SetGroupWholeBanResponse {
        if (!GroupHelper.isAdmin(request.groupId.toString())) {
            throw StatusRuntimeException(Status.PERMISSION_DENIED
                .withDescription("You are not admin of this group")
            )
        }

        GroupHelper.setGroupWholeBan(request.groupId, request.isBan)
        return setGroupWholeBanResponse {  }
    }

    @Grpc("GroupService", "GetGroupInfo")
    override suspend fun getGroupInfo(request: GetGroupInfoRequest): GetGroupInfoResponse {
        val groupInfo = GroupHelper.getGroupInfo(request.groupId.toString(), true).onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to get group info").withCause(it))
        }.getOrThrow()
        return getGroupInfoResponse {
            this.groupInfo = io.kritor.group.groupInfo {
                groupId = groupInfo.troopcode.toLong()
                groupName = groupInfo.troopname.ifNullOrEmpty { groupInfo.troopRemark }.ifNullOrEmpty { groupInfo.newTroopName } ?: ""
                groupRemark = groupInfo.troopRemark ?: ""
                owner = groupInfo.troopowneruin?.toLong() ?: 0
                admins.addAll(GroupHelper.getAdminList(groupId))
                maxMemberCount = groupInfo.wMemberMax
                memberCount = groupInfo.wMemberNum
                groupUin = groupInfo.troopuin?.toLong() ?: 0
            }
        }
    }

    @Grpc("GroupService", "GetGroupList")
    override suspend fun getGroupList(request: GetGroupListRequest): GetGroupListResponse {
        val groupList = GroupHelper.getGroupList(if (request.hasRefresh()) request.refresh else false).onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to get group list").withCause(it))
        }.getOrThrow()
        return getGroupListResponse {
            groupList.forEach { groupInfo ->
                this.groupInfo.add(io.kritor.group.groupInfo {
                    groupId = groupInfo.troopcode.toLong()
                    groupName = groupInfo.troopname.ifNullOrEmpty { groupInfo.troopRemark }.ifNullOrEmpty { groupInfo.newTroopName } ?: ""
                    groupRemark = groupInfo.troopRemark ?: ""
                    owner = groupInfo.troopowneruin?.toLong() ?: 0
                    admins.addAll(GroupHelper.getAdminList(groupId))
                    maxMemberCount = groupInfo.wMemberMax
                    memberCount = groupInfo.wMemberNum
                    groupUin = groupInfo.troopuin?.toLong() ?: 0
                })
            }
        }
    }

    @Grpc("GroupService", "GetGroupMemberInfo")
    override suspend fun getGroupMemberInfo(request: GetGroupMemberInfoRequest): GetGroupMemberInfoResponse {
        val memberInfo = GroupHelper.getTroopMemberInfoByUin(request.groupId.toString(), when(request.targetCase!!) {
            GetGroupMemberInfoRequest.TargetCase.UIN -> request.uin
            GetGroupMemberInfoRequest.TargetCase.UID -> ContactHelper.getUinByUidAsync(request.uid).toLong()
            else -> throw StatusRuntimeException(Status.INVALID_ARGUMENT
                .withDescription("target not set")
            )
        }.toString()).onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to get group member info").withCause(it))
        }.getOrThrow()
        return getGroupMemberInfoResponse {
            groupMemberInfo = groupMemberInfo {
                uid = if (request.targetCase == GetGroupMemberInfoRequest.TargetCase.UID) request.uid else ContactHelper.getUidByUinAsync(request.uin)
                uin = memberInfo.memberuin?.toLong() ?: 0
                nick = memberInfo.troopnick
                    .ifNullOrEmpty { memberInfo.hwName }
                    .ifNullOrEmpty { memberInfo.troopColorNick }
                    .ifNullOrEmpty { memberInfo.friendnick } ?: ""
                age = memberInfo.age.toInt()
                uniqueTitle = memberInfo.mUniqueTitle ?: ""
                uniqueTitleExpireTime = memberInfo.mUniqueTitleExpire
                card = memberInfo.troopnick.ifNullOrEmpty { memberInfo.friendnick } ?: ""
                joinTime = memberInfo.join_time
                lastActiveTime = memberInfo.last_active_time
                level = memberInfo.level
                shutUpTimestamp = memberInfo.gagTimeStamp

                distance = memberInfo.distance
                honor.addAll((memberInfo.honorList ?: "")
                    .split("|")
                    .filter { it.isNotBlank() }
                    .map { it.toInt() })
                unfriendly = false
                cardChangeable = GroupHelper.isAdmin(request.groupId.toString())
            }
        }
    }

    @Grpc("GroupService", "GetGroupMemberList")
    override suspend fun getGroupMemberList(request: GetGroupMemberListRequest): GetGroupMemberListResponse {
        val memberList = GroupHelper.getGroupMemberList(request.groupId.toString(), if (request.hasRefresh()) request.refresh else false).onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to get group member list").withCause(it))
        }.getOrThrow()
        return getGroupMemberListResponse {
            memberList.forEach { memberInfo ->
                this.groupMemberInfo.add(groupMemberInfo {
                    uid = ContactHelper.getUidByUinAsync(memberInfo.memberuin?.toLong() ?: 0)
                    uin = memberInfo.memberuin?.toLong() ?: 0
                    nick = memberInfo.troopnick
                        .ifNullOrEmpty { memberInfo.hwName }
                        .ifNullOrEmpty { memberInfo.troopColorNick }
                        .ifNullOrEmpty { memberInfo.friendnick } ?: ""
                    age = memberInfo.age.toInt()
                    uniqueTitle = memberInfo.mUniqueTitle ?: ""
                    uniqueTitleExpireTime = memberInfo.mUniqueTitleExpire
                    card = memberInfo.troopnick.ifNullOrEmpty { memberInfo.friendnick } ?: ""
                    joinTime = memberInfo.join_time
                    lastActiveTime = memberInfo.last_active_time
                    level = memberInfo.level
                    shutUpTimestamp = memberInfo.gagTimeStamp

                    distance = memberInfo.distance
                    honor.addAll((memberInfo.honorList ?: "")
                        .split("|")
                        .filter { it.isNotBlank() }
                        .map { it.toInt() })
                    unfriendly = false
                    cardChangeable = GroupHelper.isAdmin(request.groupId.toString())
                })
            }
        }
    }

    @Grpc("GroupService", "GetProhibitedUserList")
    override suspend fun getProhibitedUserList(request: GetProhibitedUserListRequest): GetProhibitedUserListResponse {
        val prohibitedList = GroupHelper.getProhibitedMemberList(request.groupId).onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to get prohibited user list").withCause(it))
        }.getOrThrow()
        return getProhibitedUserListResponse {
            prohibitedList.forEach {
                this.prohibitedUserInfo.add(prohibitedUserInfo {
                    uid = ContactHelper.getUidByUinAsync(it.memberUin)
                    uin = it.memberUin
                    prohibitedTime = it.shutuptimestap
                })
            }
        }
    }

    @Grpc("GroupService", "GetRemainCountAtAll")
    override suspend fun getRemainCountAtAll(request: GetRemainCountAtAllRequest): GetRemainCountAtAllResponse {
        val remainAtAllRsp = GroupHelper.getGroupRemainAtAllRemain(request.groupId).onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to get remain count").withCause(it))
        }.getOrThrow()
        return getRemainCountAtAllResponse {
            accessAtAll = remainAtAllRsp.bool_can_at_all.get()
            remainCountForGroup = remainAtAllRsp.uint32_remain_at_all_count_for_group.get()
            remainCountForSelf = remainAtAllRsp.uint32_remain_at_all_count_for_uin.get()
        }
    }

    @Grpc("GroupService", "GetNotJoinedGroupInfo")
    override suspend fun getNotJoinedGroupInfo(request: GetNotJoinedGroupInfoRequest): GetNotJoinedGroupInfoResponse {
        val groupInfo = GroupHelper.getNotJoinedGroupInfo(request.groupId).onFailure {
            throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to get not joined group info").withCause(it))
        }.getOrThrow()
        return getNotJoinedGroupInfoResponse {
            this.groupInfo = notJoinedGroupInfo {
                groupId = groupInfo.groupId
                groupName = groupInfo.groupName
                owner = groupInfo.owner
                maxMemberCount = groupInfo.maxMember
                memberCount = groupInfo.memberCount
                groupDesc = groupInfo.groupDesc
                createTime = groupInfo.createTime.toInt()
                groupFlag = groupInfo.groupFlag
                groupFlagExt = groupInfo.groupFlagExt
            }
        }
    }

    @Grpc("GroupService", "GetGroupHonor")
    override suspend fun getGroupHonor(request: GetGroupHonorRequest): GetGroupHonorResponse {
        return getGroupHonorResponse {
            GroupHelper.getGroupMemberList(request.groupId.toString(), true).onFailure {
                throw StatusRuntimeException(Status.INTERNAL.withDescription("unable to get group member list").withCause(it))
            }.onSuccess { memberList ->
                memberList.forEach { member ->
                    (member.honorList ?: "").split("|")
                        .filter { it.isNotBlank() }
                        .map { it.toInt() }.forEach {
                            val honor = decodeHonor(member.memberuin.toLong(), it, member.mHonorRichFlag)
                            if (honor != null) {
                                groupHonorInfo.add(groupHonorInfo {
                                    uid = ContactHelper.getUidByUinAsync(member.memberuin.toLong())
                                    uin = member.memberuin.toLong()
                                    nick = member.troopnick
                                        .ifNullOrEmpty { member.hwName }
                                        .ifNullOrEmpty { member.troopColorNick }
                                        .ifNullOrEmpty { member.friendnick } ?: ""
                                    honorName = honor.honorName
                                    avatar = honor.honorIconUrl
                                    id = honor.honorId
                                    description = honor.honorUrl
                                })
                            }
                        }
                }
            }
        }
    }
}