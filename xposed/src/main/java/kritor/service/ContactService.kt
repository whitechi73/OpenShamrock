package kritor.service

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.kritor.AuthCode
import io.kritor.authRsp
import io.kritor.contact.ContactServiceGrpcKt
import io.kritor.contact.ProfileCard
import io.kritor.contact.ProfileCardRequest
import io.kritor.contact.profileCard
import moe.fuqiuluo.shamrock.config.ActiveTicket
import moe.fuqiuluo.shamrock.config.ShamrockConfig
import qq.service.contact.ContactHelper

object ContactService: ContactServiceGrpcKt.ContactServiceCoroutineImplBase() {
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
}