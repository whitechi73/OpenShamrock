@file:OptIn(DelicateCoroutinesApi::class)

package qq.service.internals

import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import com.tencent.qqnt.kernel.nativeinterface.TextElement
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.config.AliveReply
import moe.fuqiuluo.shamrock.config.get
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.helper.db.ImageDB
import moe.fuqiuluo.shamrock.helper.db.ImageMapping
import moe.fuqiuluo.shamrock.internals.GlobalEventTransmitter
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.utils.PlatformUtils.QQ_9_0_8_VER
import qq.service.bdh.RichProtoSvc
import qq.service.file.GroupFileHelper
import qq.service.group.GroupHelper
import qq.service.kernel.SimpleKernelMsgListener
import qq.service.msg.MessageHelper

object AioListener : SimpleKernelMsgListener() {
    override fun onRecvMsg(records: ArrayList<MsgRecord>) {
        records.forEach {
            GlobalScope.launch {
                try {
                    onMsg(it)
                } catch (e: Exception) {
                    LogCenter.log("OnMessage: " + e.stackTraceToString(), Level.WARN)
                }
            }
        }
    }

    private suspend fun debugTest(record: MsgRecord, text: String) {
        if (record.chatType == MsgConstant.KCHATTYPEGROUP && text == ".shamrock.members") {
            val contact = MessageHelper.generateContact(record)
            GroupHelper.getGroupMemberList(record.peerUin, true).onSuccess {
                MessageHelper.sendMessage(contact, arrayListOf(
                    MsgElement().apply {
                        elementType = MsgConstant.KELEMTYPETEXT
                        textElement = TextElement().apply {
                            content = "memberCount: ${it.size}"
                        }
                    }
                ), 3, MessageHelper.generateMsgId(record.chatType))
            }.onFailure {
                LogCenter.log("获取群成员列表失败: $it", Level.ERROR)
            }
        } else if (record.chatType == MsgConstant.KCHATTYPEGROUP && text == ".shamrock.root_files") {
            val contact = MessageHelper.generateContact(record)
            val files = GroupFileHelper.getGroupFiles(record.peerUin)
            MessageHelper.sendMessage(contact, arrayListOf(
                MsgElement().apply {
                    elementType = MsgConstant.KELEMTYPETEXT
                    textElement = TextElement().apply {
                        content = "foldersCount: ${files.foldersCount}\nfilesCount: ${files.filesCount}"
                    }
                }
            ), 3, MessageHelper.generateMsgId(record.chatType))
        } else if (record.chatType == MsgConstant.KCHATTYPEGROUP && text == ".shamrock.pic_url") {
            val contact = MessageHelper.generateContact(record)
            val pic = record.elements.filter {
                it.elementType == MsgConstant.KELEMTYPEPIC
            }.map {
                val image = it.picElement
                val md5 = (image.md5HexStr ?: image.fileName
                    .replace("{", "")
                    .replace("}", "")
                    .replace("-", "").split(".")[0])
                    .uppercase()
                var storeId = 0
                if (PlatformUtils.getQQVersionCode() > QQ_9_0_8_VER) {
                    storeId = image.storeID
                }
                val originalUrl = image.originImageUrl ?: ""
                return@map RichProtoSvc.getTempPicDownloadUrl(record.chatType, originalUrl, md5, image, storeId)
            }

            MessageHelper.sendMessage(contact, arrayListOf(
                MsgElement().apply {
                    elementType = MsgConstant.KELEMTYPETEXT
                    textElement = TextElement().apply {
                        content = "picUrl: \n${
                            pic.joinToString("\n")
                        }"
                    }
                }
            ), 3, MessageHelper.generateMsgId(record.chatType))
        }

    }

    private suspend fun onMsg(record: MsgRecord) {
        if (AliveReply.get()) {
            val texts = record.elements.filter { it.elementType == MsgConstant.KELEMTYPETEXT }
            val text = texts.joinToString { it.textElement.content }
            if (texts.isNotEmpty() && text == "ping") {
                val contact = MessageHelper.generateContact(record)
                MessageHelper.sendMessage(contact, arrayListOf(
                    MsgElement().apply {
                        elementType = MsgConstant.KELEMTYPETEXT
                        textElement = TextElement().apply {
                            content = "pong"
                        }
                    }
                ), 3, MessageHelper.generateMsgId(record.chatType))
                return
            }
            debugTest(record, text)
        }
        when (record.chatType) {
            MsgConstant.KCHATTYPEGROUP -> {
                if (record.senderUin == 0L) return

                LogCenter.log("群消息(group = ${record.peerName}(${record.peerUin}), uin = ${record.senderUin}, id = ${record.msgId})")

                if (!GlobalEventTransmitter.MessageTransmitter.transGroupMessage(record, record.elements)) {
                    LogCenter.log("群消息推送失败 -> 推送目标可能不存在", Level.WARN)
                }
            }

            MsgConstant.KCHATTYPEC2C -> {
                LogCenter.log("私聊消息(private = ${record.senderUin}, id = [${record.msgId} | ${record.msgSeq}])")

                if (!GlobalEventTransmitter.MessageTransmitter.transPrivateMessage(
                        record, record.elements
                    )
                ) {
                    LogCenter.log("私聊消息推送失败 -> MessageTransmitter", Level.WARN)
                }
            }

            MsgConstant.KCHATTYPETEMPC2CFROMGROUP -> {
                var groupCode = 0L
                var fromNick = ""
                MessageHelper.getTempChatInfo(record.chatType, record.senderUid).onSuccess {
                    groupCode = it.groupCode.toLong()
                    fromNick = it.fromNick
                }

                LogCenter.log("私聊临时消息(private = ${record.senderUin}, groupId=$groupCode)")

                if (!GlobalEventTransmitter.MessageTransmitter.transTempMessage(
                        record,
                        record.elements,
                        groupCode,
                        fromNick
                    )
                ) {
                    LogCenter.log("私聊临时消息推送失败 -> MessageTransmitter", Level.WARN)
                }
            }

            MsgConstant.KCHATTYPEGUILD -> {
                LogCenter.log("频道消息(guildId = ${record.guildId}, sender = ${record.senderUid}, id = [${record.msgId}])")
                if (!GlobalEventTransmitter.MessageTransmitter
                        .transGuildMessage(record, record.elements)
                ) {
                    LogCenter.log("频道消息推送失败 -> MessageTransmitter", Level.WARN)
                }
            }

            else -> LogCenter.log("不支持PUSH事件: ${record.chatType}")
        }
    }

    override fun onFileMsgCome(arrayList: ArrayList<MsgRecord>?) {
        arrayList?.forEach { record ->
            GlobalScope.launch {
                when (record.chatType) {
                    MsgConstant.KCHATTYPEGROUP -> onGroupFileMsg(record)
                    MsgConstant.KCHATTYPEC2C -> onC2CFileMsg(record)
                    else -> LogCenter.log("不支持该来源的文件上传事件：${record}", Level.WARN)
                }
            }
        }
    }

    private suspend fun onC2CFileMsg(record: MsgRecord) {
        val fileMsg = record.elements.firstOrNull {
            it.elementType == MsgConstant.KELEMTYPEFILE
        }?.fileElement ?: kotlin.run {
            LogCenter.log("消息为私聊文件消息但不包含文件消息，来自：${record.peerUin}", Level.WARN)
            return
        }

        val fileName = fileMsg.fileName
        val fileSize = fileMsg.fileSize
        val expireTime = fileMsg.expireTime ?: 0
        val fileId = fileMsg.fileUuid
        val fileSubId = fileMsg.fileSubId ?: ""
        val url = RichProtoSvc.getC2CFileDownUrl(fileId, fileSubId)

        if (!GlobalEventTransmitter.FileNoticeTransmitter
                .transPrivateFileEvent(record.msgTime, record.senderUid, record.senderUin, fileId, fileSubId, fileName, fileSize, expireTime, url)
        ) {
            LogCenter.log("私聊文件消息推送失败 -> FileNoticeTransmitter", Level.WARN)
        }
    }

    private suspend fun onGroupFileMsg(record: MsgRecord) {
        val groupId = record.peerUin
        val fileMsg = record.elements.firstOrNull {
            it.elementType == MsgConstant.KELEMTYPEFILE
        }?.fileElement ?: kotlin.run {
            LogCenter.log("消息为群聊文件消息但不包含文件消息，来自：${record.peerUin}", Level.WARN)
            return
        }
        //val fileMd5 = fileMsg.fileMd5
        val fileName = fileMsg.fileName
        val fileSize = fileMsg.fileSize
        val uuid = fileMsg.fileUuid
        val bizId = fileMsg.fileBizId

        val url = RichProtoSvc.getGroupFileDownUrl(record.peerUin, uuid, bizId)

        if (!GlobalEventTransmitter.FileNoticeTransmitter
                .transGroupFileEvent(record.msgTime, record.senderUid, record.senderUin, groupId, uuid, fileName, fileSize, bizId, url)
        ) {
            LogCenter.log("群聊文件消息推送失败 -> FileNoticeTransmitter", Level.WARN)
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun onRecvSysMsg(arrayList: ArrayList<Byte>?) {
        LogCenter.log("onRecvSysMsg")
        LogCenter.log(arrayList?.toByteArray()?.toHexString() ?: "")
    }
}