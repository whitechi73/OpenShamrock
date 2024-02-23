package protobuf.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import protobuf.message.routing.*

@Serializable
data class RoutingHead(
    @ProtoNumber(1) val c2c: C2C? = null,
    @ProtoNumber(2) val grp: Grp? = null,
    @ProtoNumber(3) val grpTmp: GrpTmp? = null,
    @ProtoNumber(6) val wpaTmp: WPATmp? = null,
    @ProtoNumber(15) val trans0X211: Trans0X211? = null
)
