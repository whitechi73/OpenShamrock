package qq.service.internals

import com.tencent.qqnt.kernel.nativeinterface.BroadcastHelperTransNotifyInfo
import com.tencent.qqnt.kernel.nativeinterface.Contact
import com.tencent.qqnt.kernel.nativeinterface.ContactMsgBoxInfo
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig
import com.tencent.qqnt.kernel.nativeinterface.DevInfo
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo
import com.tencent.qqnt.kernel.nativeinterface.FirstViewDirectMsgNotifyInfo
import com.tencent.qqnt.kernel.nativeinterface.FirstViewGroupGuildInfo
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo
import com.tencent.qqnt.kernel.nativeinterface.GroupItem
import com.tencent.qqnt.kernel.nativeinterface.GuildInteractiveNotificationItem
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag
import com.tencent.qqnt.kernel.nativeinterface.GuildNotificationAbstractInfo
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo
import com.tencent.qqnt.kernel.nativeinterface.MsgAbstract
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult
import com.tencent.qqnt.kernel.nativeinterface.TabStatusInfo
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.internals.GlobalEventTransmitter
import qq.service.msg.MessageHelper

object AioListener: IKernelMsgListener {
    override fun onRecvMsg(msgs: ArrayList<MsgRecord>) {
        msgs.forEach {
            GlobalScope.launch {
                try {
                    onMsg(it)
                } catch (e: Exception) {
                    LogCenter.log("OnMessage: " + e.stackTraceToString(), Level.WARN)
                }
            }
        }
    }

    private suspend fun onMsg(record: MsgRecord) {
        when (record.chatType) {
            MsgConstant.KCHATTYPEGROUP -> {
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

                if (!GlobalEventTransmitter.MessageTransmitter.transTempMessage(record, record.elements, groupCode, fromNick)
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

    override fun onMsgRecall(chatType: Int, peerId: String, msgId: Long) {
        LogCenter.log("onMsgRecall($chatType, $peerId, $msgId)")
    }

    override fun onAddSendMsg(record: MsgRecord) {

    }

    override fun onMsgInfoListUpdate(msgList: ArrayList<MsgRecord>?) {

    }

    override fun onTempChatInfoUpdate(tempChatInfo: TempChatInfo) {

    }

    override fun onMsgAbstractUpdate(arrayList: ArrayList<MsgAbstract>?) {
        //arrayList?.forEach {
        //    LogCenter.log("onMsgAbstractUpdate($it)", Level.WARN)
        //}
    }

    override fun onRecvMsgSvrRspTransInfo(
        j2: Long,
        contact: Contact?,
        i2: Int,
        i3: Int,
        str: String?,
        bArr: ByteArray?
    ) {
        LogCenter.log("onRecvMsgSvrRspTransInfo($j2, $contact, $i2, $i3, $str)", Level.DEBUG)
    }

    override fun onRecvS2CMsg(arrayList: ArrayList<Byte>?) {
        LogCenter.log("onRecvS2CMsg(${arrayList.toString()})", Level.DEBUG)
    }

    override fun onRecvSysMsg(arrayList: ArrayList<Byte>?) {
        LogCenter.log("onRecvSysMsg(${arrayList.toString()})", Level.DEBUG)
    }

    override fun onBroadcastHelperDownloadComplete(broadcastHelperTransNotifyInfo: BroadcastHelperTransNotifyInfo?) {}

    override fun onBroadcastHelperProgerssUpdate(broadcastHelperTransNotifyInfo: BroadcastHelperTransNotifyInfo?) {}

    override fun onChannelFreqLimitInfoUpdate(
        contact: Contact?,
        z: Boolean,
        freqLimitInfo: FreqLimitInfo?
    ) {

    }

    override fun onContactUnreadCntUpdate(unreadMap: HashMap<Int, HashMap<String, UnreadCntInfo>>) {
        // 推送未读消息数量
    }

    override fun onCustomWithdrawConfigUpdate(customWithdrawConfig: CustomWithdrawConfig?) {
        LogCenter.log("onCustomWithdrawConfigUpdate: " + customWithdrawConfig.toString(), Level.DEBUG)
    }

    override fun onDraftUpdate(contact: Contact?, arrayList: ArrayList<MsgElement>?, j2: Long) {
        LogCenter.log("onDraftUpdate: " + contact.toString() + "|" + arrayList + "|" + j2.toString(), Level.DEBUG)
    }

    override fun onEmojiDownloadComplete(emojiNotifyInfo: EmojiNotifyInfo?) {

    }

    override fun onEmojiResourceUpdate(emojiResourceInfo: EmojiResourceInfo?) {

    }

    override fun onFeedEventUpdate(firstViewDirectMsgNotifyInfo: FirstViewDirectMsgNotifyInfo?) {

    }

    override fun onFileMsgCome(arrayList: ArrayList<MsgRecord>?) {

    }

    override fun onFirstViewDirectMsgUpdate(firstViewDirectMsgNotifyInfo: FirstViewDirectMsgNotifyInfo?) {

    }

    override fun onFirstViewGroupGuildMapping(arrayList: ArrayList<FirstViewGroupGuildInfo>?) {

    }

    override fun onGrabPasswordRedBag(
        i2: Int,
        str: String?,
        i3: Int,
        recvdOrder: RecvdOrder?,
        msgRecord: MsgRecord?
    ) {

    }

    override fun onKickedOffLine(kickedInfo: KickedInfo?) {
        LogCenter.log("onKickedOffLine($kickedInfo)")
    }

    override fun onRichMediaUploadComplete(notifyInfo: FileTransNotifyInfo) {
        LogCenter.log({ "[BDH] 资源上传完成(${notifyInfo.trasferStatus}, ${notifyInfo.fileId}, ${notifyInfo.msgId}, ${notifyInfo.commonFileInfo})" }, Level.DEBUG)
    }

    override fun onRecvOnlineFileMsg(arrayList: ArrayList<MsgRecord>?) {
        LogCenter.log(("onRecvOnlineFileMsg" + arrayList?.joinToString { ", " }), Level.DEBUG)
    }

    override fun onRichMediaDownloadComplete(fileTransNotifyInfo: FileTransNotifyInfo) {

    }

    override fun onRichMediaProgerssUpdate(fileTransNotifyInfo: FileTransNotifyInfo) {

    }

    override fun onSearchGroupFileInfoUpdate(searchGroupFileResult: SearchGroupFileResult?) {
        LogCenter.log("onSearchGroupFileInfoUpdate($searchGroupFileResult)", Level.DEBUG)
    }

    override fun onGroupFileInfoAdd(groupItem: GroupItem?) {
        LogCenter.log("onGroupFileInfoAdd: " + groupItem.toString(), Level.DEBUG)
    }

    override fun onGroupFileInfoUpdate(groupFileListResult: GroupFileListResult?) {
        LogCenter.log("onGroupFileInfoUpdate: " + groupFileListResult.toString(), Level.DEBUG)
    }

    override fun onGroupGuildUpdate(groupGuildNotifyInfo: GroupGuildNotifyInfo?) {
        LogCenter.log("onGroupGuildUpdate: " + groupGuildNotifyInfo.toString(), Level.DEBUG)
    }

    override fun onGroupTransferInfoAdd(groupItem: GroupItem?) {
        LogCenter.log("onGroupTransferInfoAdd: " + groupItem.toString(), Level.DEBUG)
    }

    override fun onGroupTransferInfoUpdate(groupFileListResult: GroupFileListResult?) {
        LogCenter.log("onGroupTransferInfoUpdate: " + groupFileListResult.toString(), Level.DEBUG)
    }

    override fun onGuildInteractiveUpdate(guildInteractiveNotificationItem: GuildInteractiveNotificationItem?) {

    }

    override fun onGuildMsgAbFlagChanged(guildMsgAbFlag: GuildMsgAbFlag?) {

    }

    override fun onGuildNotificationAbstractUpdate(guildNotificationAbstractInfo: GuildNotificationAbstractInfo?) {

    }

    override fun onHitCsRelatedEmojiResult(downloadRelateEmojiResultInfo: DownloadRelateEmojiResultInfo?) {

    }

    override fun onHitEmojiKeywordResult(hitRelatedEmojiWordsResult: HitRelatedEmojiWordsResult?) {

    }

    override fun onHitRelatedEmojiResult(relatedWordEmojiInfo: RelatedWordEmojiInfo?) {

    }

    override fun onImportOldDbProgressUpdate(importOldDbMsgNotifyInfo: ImportOldDbMsgNotifyInfo?) {

    }

    override fun onInputStatusPush(inputStatusInfo: InputStatusInfo?) {

    }

    override fun onLineDev(devList: ArrayList<DevInfo>?) {
        //LogCenter.log("onLineDev($arrayList)")
    }

    override fun onLogLevelChanged(newLevel: Long) {

    }

    override fun onMsgBoxChanged(arrayList: ArrayList<ContactMsgBoxInfo>?) {

    }

    override fun onMsgDelete(contact: Contact?, arrayList: ArrayList<Long>?) {

    }

    override fun onMsgEventListUpdate(hashMap: HashMap<String, ArrayList<Long>>?) {

    }

    override fun onMsgInfoListAdd(arrayList: ArrayList<MsgRecord>?) {

    }

    override fun onMsgQRCodeStatusChanged(i2: Int) {

    }

    override fun onMsgSecurityNotify(msgRecord: MsgRecord?) {
        LogCenter.log("onMsgSecurityNotify($msgRecord)")
    }

    override fun onMsgSettingUpdate(msgSetting: MsgSetting?) {

    }

    override fun onNtFirstViewMsgSyncEnd() {

    }

    override fun onNtMsgSyncEnd() {
        LogCenter.log("NTKernel同步消息完成", Level.DEBUG)
    }

    override fun onNtMsgSyncStart() {
        LogCenter.log("NTKernel同步消息开始", Level.DEBUG)
    }

    override fun onReadFeedEventUpdate(firstViewDirectMsgNotifyInfo: FirstViewDirectMsgNotifyInfo?) {

    }

    override fun onRecvGroupGuildFlag(i2: Int) {

    }

    override fun onRecvUDCFlag(i2: Int) {
        LogCenter.log("onRecvUDCFlag($i2)", Level.DEBUG)
    }

    override fun onSendMsgError(j2: Long, contact: Contact?, i2: Int, str: String?) {
        LogCenter.log("onSendMsgError($j2, $contact, $j2, $str)", Level.DEBUG)
    }

    override fun onSysMsgNotification(i2: Int, j2: Long, j3: Long, arrayList: ArrayList<Byte>?) {
        LogCenter.log("onSysMsgNotification($i2, $j2, $j3, $arrayList)", Level.DEBUG)
    }

    override fun onUnreadCntAfterFirstView(hashMap: HashMap<Int, ArrayList<UnreadCntInfo>>?) {

    }

    override fun onUnreadCntUpdate(hashMap: HashMap<Int, ArrayList<UnreadCntInfo>>?) {

    }

    override fun onUserChannelTabStatusChanged(z: Boolean) {

    }

    override fun onUserOnlineStatusChanged(z: Boolean) {

    }

    override fun onUserTabStatusChanged(arrayList: ArrayList<TabStatusInfo>?) {
        LogCenter.log("onUserTabStatusChanged($arrayList)", Level.DEBUG)
    }

    override fun onlineStatusBigIconDownloadPush(i2: Int, j2: Long, str: String?) {

    }

    override fun onlineStatusSmallIconDownloadPush(i2: Int, j2: Long, str: String?) {

    }
}