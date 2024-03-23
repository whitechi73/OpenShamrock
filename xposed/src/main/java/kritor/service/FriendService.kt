package kritor.service

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.friend.*
import qq.service.contact.ContactHelper
import qq.service.friend.FriendHelper

internal object FriendService: FriendServiceGrpcKt.FriendServiceCoroutineImplBase() {
    @Grpc("FriendService", "GetFriendList")
    override suspend fun getFriendList(request: GetFriendListRequest): GetFriendListResponse {
        val friendList = FriendHelper.getFriendList(if(request.hasRefresh()) request.refresh else false).onFailure {
            throw StatusRuntimeException(Status.INTERNAL
                .withDescription(it.stackTraceToString())
            )
        }.getOrThrow()

        return GetFriendListResponse.newBuilder().apply {
            friendList.forEach {
                this.addFriendList(FriendData.newBuilder().apply {
                    uin = it.uin.toLong()
                    uid = ContactHelper.getUidByUinAsync(uin)
                    qid = ""
                    nick = it.name ?: ""
                    remark = it.remark ?: ""
                    age = it.age
                    level = 0
                    gender = it.gender.toInt()
                    groupId = it.groupid
                    ext = FriendExt.newBuilder().build().toByteString()
                })
            }
        }.build()
    }

}