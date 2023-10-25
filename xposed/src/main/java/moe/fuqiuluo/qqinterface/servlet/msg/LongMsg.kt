package moe.fuqiuluo.qqinterface.servlet.msg

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import moe.fuqiuluo.proto.ProtoUtils
import moe.fuqiuluo.proto.asUtf8String
import moe.fuqiuluo.proto.protobufOf
import moe.fuqiuluo.qqinterface.servlet.BaseSvc
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.utils.DeflateTools

internal object LongMsgHelper: BaseSvc() {
    private const val GROUP_LONG_MSG_CMD = "trpc.group.long_msg_interface.MsgService.SsoSendLongMsg"

    suspend fun uploadGroupMsg(groupId: String, msgs: List<MsgRecord>): String {
        val reqBody = protobufOf(
            2 to mapOf(
                1 to 3,
                2 to 2 to groupId,
                3 to groupId.toLong(),
                4 to DeflateTools.gzip(toGroupByteArray(msgs))
            ),
            15 to mapOf(
                1 to 4,
                2 to 2,
                3 to 9,
                4 to 0
            )
        ).toByteArray()
        val buffer = sendBufferAW(GROUP_LONG_MSG_CMD, true, reqBody)
            ?: error("获取消息资源ID失败")
        val pb = ProtoUtils.decodeFromByteArray(buffer.slice(4))
        return pb[2, 3].asUtf8String
    }

    private fun toGroupByteArray(msgs: List<MsgRecord>): ByteArray {
        return protobufOf(
            2 to mapOf(
                1 to "MultiMsg",
                2 to 1 to msgs.map { record ->
                    mapOf(
                        1 to mapOf(
                            2 to record.senderUid,
                            8 to mapOf(
                                1 to record.peerUin,
                                4 to record.sendNickName,
                                5 to 2
                            )
                        ),
                        2 to mapOf(
                            1 to 82,
                            4 to record.msgRandom,
                            5 to record.msgSeq,
                            6 to record.msgTime,
                            7 to 1,
                            8 to 0,
                            9 to 0,
                            15 to mapOf(
                                1 to 0,
                                2 to 0,
                                3 to 0,
                                4 to "",
                                5 to ""
                            )
                        ),
                        3 to mapOf(
                            1 to 2 to (record.elements.map {
                                when (val type = it.elementType) {
                                    MsgConstant.KELEMTYPETEXT -> mapOf(1 to 1 to it.textElement.content)

                                    else -> error("不支持的合并转发消息类型: $type")
                                }
                            } as ArrayList<Any>).also {
                                it.add(0, mapOf(
                                    37 to mapOf(
                                        1 to 8,
                                        16 to 0,
                                        17 to 0,
                                        19 to mapOf(
                                            15 to 65536,
                                            25 to 0,
                                            30 to 0,
                                            31 to 0,
                                            34 to 0,
                                            41 to 0,
                                            52 to 64,
                                            54 to 1,
                                            55 to 0,
                                            72 to 0,
                                            73 to 1 to 0,
                                            96 to 0
                                        )
                                    )
                                ))
                            }
                        )
                    )
                }
            )
        ).toByteArray()
    }

}