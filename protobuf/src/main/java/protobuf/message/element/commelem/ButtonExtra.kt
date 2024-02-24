package protobuf.message.element.commelem

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import moe.fuqiuluo.symbols.Protobuf


@Serializable
data class ButtonExtra(
    @ProtoNumber(1) val field1: Object1? = null,
) : Protobuf<ButtonExtra>

@Serializable
data class Object1(
    @ProtoNumber(1) val rows: List<Row>? = null,
    @ProtoNumber(2) val appid: Int? = null,
)

@Serializable
data class Row(
    @ProtoNumber(1) val buttons: List<Button>? = null,
)

@Serializable
data class Button(
    @ProtoNumber(1) val id: String? = null,
    @ProtoNumber(2) val renderData: RenderData? = null,
    @ProtoNumber(3) val action: Action? = null,
)

@Serializable
data class RenderData(
    @ProtoNumber(1) val label: String? = null,
    @ProtoNumber(2) val visitedLabel: String? = null,
    @ProtoNumber(3) val style: Int? = null,
)

@Serializable
data class Action(
    @ProtoNumber(1) val type: Int? = null,
    @ProtoNumber(2) val permission: Permission? = null,
    @ProtoNumber(4) val unsupportTips: String? = null,
    @ProtoNumber(5) val data: String? = null,
    @ProtoNumber(7) val reply: Boolean? = null,
    @ProtoNumber(8) val enter: Boolean? = null,
)

@Serializable
data class Permission(
    @ProtoNumber(1) val type: Int? = null,
    @ProtoNumber(2) val specifyRoleIds: List<String>? = null,
    @ProtoNumber(3) val specifyUserIds: List<String>? = null,
)