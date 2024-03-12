package kritor.service

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.friend.FriendServiceGrpcKt
import io.kritor.friend.GetFriendListRequest
import io.kritor.friend.GetFriendListResponse
import io.kritor.friend.friendData
import io.kritor.friend.friendExt
import io.kritor.friend.getFriendListResponse
import qq.service.contact.ContactHelper
import qq.service.friend.FriendHelper

object FriendService: FriendServiceGrpcKt.FriendServiceCoroutineImplBase() {
    @Grpc("FriendService", "GetFriendList")
    override suspend fun getFriendList(request: GetFriendListRequest): GetFriendListResponse {
        val friendList = FriendHelper.getFriendList(if(request.hasRefresh()) request.refresh else false).onFailure {
            throw StatusRuntimeException(Status.INTERNAL
                .withDescription(it.stackTraceToString())
            )
        }.getOrThrow()

        return getFriendListResponse {
            friendList.forEach {
                this.friendList.add(friendData {
                    uin = it.uin.toLong()
                    uid = ContactHelper.getUidByUinAsync(uin)
                    qid = ""
                    nick = it.name ?: ""
                    remark = it.remark ?: ""
                    age = it.age
                    level = 0
                    gender = it.gender.toInt()
                    groupId = it.groupid
                    ext = friendExt {}.toByteString()
                })
            }
        }
    }

}