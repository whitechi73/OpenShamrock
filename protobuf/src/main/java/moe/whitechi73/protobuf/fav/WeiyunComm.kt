package moe.whitechi73.protobuf.fav

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class WeiyunComm(
    @ProtoNumber(1) val req: WeiyunCommonReq? = null,
    @ProtoNumber(2) val resp: WeiyunCommonResp? = null
)
