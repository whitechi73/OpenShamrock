package moe.fuqiuluo.qqinterface.servlet.transfile

import com.tencent.mobileqq.pb.ByteStringMicro
import com.tencent.mobileqq.transfile.FileMsg
import com.tencent.mobileqq.transfile.api.IProtoReqManager
import com.tencent.mobileqq.transfile.protohandler.RichProto
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc
import kotlinx.coroutines.suspendCancellableCoroutine
import moe.fuqiuluo.qqinterface.servlet.BaseSvc
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.tools.hex2ByteArray
import moe.fuqiuluo.shamrock.tools.slice
import moe.fuqiuluo.shamrock.tools.toHexString
import moe.fuqiuluo.shamrock.utils.PlatformUtils
import moe.fuqiuluo.shamrock.xposed.helper.AppRuntimeFetcher
import mqq.app.MobileQQ
import tencent.im.cs.cmd0x346.cmd0x346
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6
import tencent.im.oidb.cmd0xe37.cmd0xe37
import tencent.im.oidb.oidb_sso
import kotlin.coroutines.resume

internal object RichProtoSvc: BaseSvc() {
    suspend fun getGroupFileDownUrl(
        peerId: Long,
        fileId: String,
        bizId: Int = 102
    ): String {
        val buffer = sendOidbAW("OidbSvcTrpcTcp.0x6d6_2", 1750, 2, oidb_0x6d6.ReqBody().apply {
            download_file_req.set(oidb_0x6d6.DownloadFileReqBody().apply {
                uint64_group_code.set(peerId)
                uint32_app_id.set(3)
                uint32_bus_id.set(bizId)
                str_file_id.set(fileId)
            })
        }.toByteArray())
        if (buffer == null) {
            return ""
        } else {
            val body = oidb_sso.OIDBSSOPkg()
            body.mergeFrom(buffer.slice(4))
            val result = oidb_0x6d6.RspBody().mergeFrom(body.bytes_bodybuffer.get().toByteArray())
            if (body.uint32_result.get() != 0
                || result.download_file_rsp.int32_ret_code.get() != 0) {
                return ""
            }

            val domain = if (!result.download_file_rsp.str_download_dns.has())
                    ("https://" + result.download_file_rsp.str_download_ip.get())
            else ("http://" + result.download_file_rsp.str_download_dns.get())
            val downloadUrl = result.download_file_rsp.bytes_download_url.get().toByteArray().toHexString()
            val appId = MobileQQ.getMobileQQ().appId
            val version = PlatformUtils.getQQVersion(MobileQQ.getContext())

            return "$domain/ftn_handler/$downloadUrl/?fname=$fileId&client_proto=qq&client_appid=$appId&client_type=android&client_ver=$version&client_down_type=auto&client_aio_type=unk"
        }
    }

    suspend fun getC2CFileDownUrl(
        fileId: String,
        subId: String,
        retryCnt: Int = 0
    ): String {
        val buffer = sendOidbAW("OidbSvc.0xe37_1200", 3639, 1200, cmd0xe37.Req0xe37().apply {
            bytes_cmd_0x346_req_body.set(ByteStringMicro.copyFrom(cmd0x346.ReqBody().apply {
                uint32_cmd.set(1200)
                uint32_seq.set(1)
                msg_apply_download_req.set(cmd0x346.ApplyDownloadReq().apply {
                    uint64_uin.set(app.longAccountUin)
                    bytes_uuid.set(ByteStringMicro.copyFrom(fileId.toByteArray()))
                    uint32_owner_type.set(2)
                    str_fileidcrc.set(subId)

                })
                uint32_business_id.set(3)
                uint32_client_type.set(104)
                uint32_flag_support_mediaplatform.set(1)
                msg_extension_req.set(cmd0x346.ExtensionReq().apply {
                    uint32_download_url_type.set(1)
                })
            }.toByteArray()))
        }.toByteArray())

        if (buffer == null) {
            if (retryCnt < 3) {
                return getC2CFileDownUrl(fileId, subId, retryCnt + 1)
            }
            return ""
        } else {
            val body = oidb_sso.OIDBSSOPkg()
            body.mergeFrom(buffer.slice(4))
            val result = cmd0x346.RspBody().mergeFrom(cmd0xe37.Resp0xe37().mergeFrom(
                body.bytes_bodybuffer.get().toByteArray()
            ).bytes_cmd_0x346_rsp_body.get().toByteArray())
            if (body.uint32_result.get() != 0 ||
                result.msg_apply_download_rsp.int32_ret_code.has() && result.msg_apply_download_rsp.int32_ret_code.get() != 0) {
                return ""
            }

            val oldData = result.msg_apply_download_rsp.msg_download_info
            //val newData = result[14, 40] NTQQ 文件信息

            val domain = if (oldData.str_download_dns.has()) ("https://" + oldData.str_download_dns.get()) else ("http://" + oldData.rpt_str_downloadip_list.get().first())
            val params = oldData.str_download_url.get()
            val appId = MobileQQ.getMobileQQ().appId
            val version = PlatformUtils.getQQVersion(MobileQQ.getContext())

            return "$domain$params&isthumb=0&client_proto=qq&client_appid=$appId&client_type=android&client_ver=$version&client_down_type=auto&client_aio_type=unk"
        }
    }

    fun getGroupPicDownUrl(
        md5: String
    ): String {
        return "http://gchat.qpic.cn/gchatpic_new/0/0-0-${md5.uppercase()}/0?term=2"
    }

    fun getC2CPicDownUrl(
        md5: String
    ): String {
        return "https://c2cpicdw.qpic.cn/offpic_new/0/123-0-${md5.uppercase()}/0?term=2"
    }

    suspend fun getC2CVideoDownUrl(
        peerId: String,
        md5Hex: String,
        fileUUId: String
    ): String {
        return suspendCancellableCoroutine {
            val runtime = AppRuntimeFetcher.appRuntime
            val richProtoReq = RichProto.RichProtoReq()
            val downReq: RichProto.RichProtoReq.ShortVideoDownReq = RichProto.RichProtoReq.ShortVideoDownReq()
            downReq.selfUin = runtime.currentAccountUin
            downReq.peerUin = peerId
            downReq.secondUin = peerId
            downReq.uinType = FileMsg.UIN_BUDDY
            downReq.agentType = 0
            downReq.chatType = 1
            downReq.troopUin = peerId
            downReq.clientType = 2
            downReq.fileId = fileUUId
            downReq.md5 = md5Hex.hex2ByteArray()
            downReq.busiType = FileTransfer.BUSI_TYPE_SHORT_VIDEO
            downReq.subBusiType = 0
            downReq.fileType = FileTransfer.VIDEO_FORMAT_MP4
            downReq.downType = 1
            downReq.sceneType = 1
            richProtoReq.callback = RichProtoProc.RichProtoCallback { _, resp ->
                if (resp.resps.isEmpty() || resp.resps.first().errCode != 0) {
                    LogCenter.log("requestDownPrivateVideo: ${resp.resps.firstOrNull()?.errCode}", Level.WARN)
                    it.resume("")
                } else {
                    val videoDownResp = resp.resps.first() as RichProto.RichProtoResp.ShortVideoDownResp
                    val url = StringBuilder()
                    url.append(videoDownResp.mIpList.random().getServerUrl("http://"))
                    url.append(videoDownResp.mUrl)
                    it.resume(url.toString())
                }
            }
            richProtoReq.protoKey = RichProtoProc.SHORT_VIDEO_DW
            richProtoReq.reqs.add(downReq)
            richProtoReq.protoReqMgr = runtime.getRuntimeService(IProtoReqManager::class.java, "all")
            RichProtoProc.procRichProtoReq(richProtoReq)
        }
    }

    suspend fun getGroupVideoDownUrl(
        peerId: String,
        md5Hex: String,
        fileUUId: String
    ): String {
        return suspendCancellableCoroutine {
            val runtime = AppRuntimeFetcher.appRuntime
            val richProtoReq = RichProto.RichProtoReq()
            val downReq: RichProto.RichProtoReq.ShortVideoDownReq = RichProto.RichProtoReq.ShortVideoDownReq()
            downReq.selfUin = runtime.currentAccountUin
            downReq.peerUin = peerId
            downReq.secondUin = peerId
            downReq.uinType = FileMsg.UIN_TROOP
            downReq.agentType = 0
            downReq.chatType = 1
            downReq.troopUin = peerId
            downReq.clientType = 2
            downReq.fileId = fileUUId
            downReq.md5 = md5Hex.hex2ByteArray()
            downReq.busiType = FileTransfer.BUSI_TYPE_SHORT_VIDEO
            downReq.subBusiType = 0
            downReq.fileType = FileTransfer.VIDEO_FORMAT_MP4
            downReq.downType = 1
            downReq.sceneType = 1
            richProtoReq.callback = RichProtoProc.RichProtoCallback { _, resp ->
                if (resp.resps.isEmpty() || resp.resps.first().errCode != 0) {
                    LogCenter.log("requestDownGroupVideo: ${resp.resps.firstOrNull()?.errCode}", Level.WARN)
                    it.resume("")
                } else {
                    val videoDownResp = resp.resps.first() as RichProto.RichProtoResp.ShortVideoDownResp
                    val url = StringBuilder()
                    url.append(videoDownResp.mIpList.random().getServerUrl("http://"))
                    url.append(videoDownResp.mUrl)
                    it.resume(url.toString())
                }
            }
            richProtoReq.protoKey = RichProtoProc.SHORT_VIDEO_DW
            richProtoReq.reqs.add(downReq)
            richProtoReq.protoReqMgr = runtime.getRuntimeService(IProtoReqManager::class.java, "all")
            RichProtoProc.procRichProtoReq(richProtoReq)
        }
    }

    suspend fun getC2CPttDownUrl(
        peerId: String,
        fileUUId: String
    ): String {
        return suspendCancellableCoroutine {
            val runtime = AppRuntimeFetcher.appRuntime
            val richProtoReq = RichProto.RichProtoReq()
            val pttDownReq: RichProto.RichProtoReq.C2CPttDownReq = RichProto.RichProtoReq.C2CPttDownReq()
            pttDownReq.selfUin = runtime.currentAccountUin
            pttDownReq.peerUin = peerId
            pttDownReq.secondUin = peerId
            pttDownReq.uinType = FileMsg.UIN_BUDDY
            pttDownReq.busiType = 1002
            pttDownReq.uuid = fileUUId
            pttDownReq.storageSource = "pttcenter"
            pttDownReq.isSelfSend = false

            pttDownReq.voiceType = 1
            pttDownReq.downType = 1
            richProtoReq.callback = RichProtoProc.RichProtoCallback { _, resp ->
                if (resp.resps.isEmpty() || resp.resps.first().errCode != 0) {
                    LogCenter.log("requestDownPrivateVoice: ${resp.resps.firstOrNull()?.errCode}", Level.WARN)
                    it.resume("")
                } else {
                    val pttDownResp = resp.resps.first() as RichProto.RichProtoResp.C2CPttDownResp
                    val url = StringBuilder()
                    url.append(pttDownResp.downloadUrl)
                    url.append("&client_proto=qq&client_appid=${MobileQQ.getMobileQQ().appId}&client_type=android&client_ver=${PlatformUtils.getQQVersion(MobileQQ.getContext())}&client_down_type=auto&client_aio_type=unk")
                    it.resume(url.toString())
                }
            }
            richProtoReq.protoKey = RichProtoProc.C2C_PTT_DW
            richProtoReq.reqs.add(pttDownReq)
            richProtoReq.protoReqMgr = runtime.getRuntimeService(IProtoReqManager::class.java, "all")
            RichProtoProc.procRichProtoReq(richProtoReq)
        }
    }

    suspend fun getGroupPttDownUrl(
        peerId: String,
        md5Hex: String,
        fileUUId: String
    ): String {
        return suspendCancellableCoroutine {
            val runtime = AppRuntimeFetcher.appRuntime
            val richProtoReq = RichProto.RichProtoReq()
            val groupPttDownReq: RichProto.RichProtoReq.GroupPttDownReq = RichProto.RichProtoReq.GroupPttDownReq()
            groupPttDownReq.selfUin = runtime.currentAccountUin
            groupPttDownReq.peerUin = peerId
            groupPttDownReq.secondUin = peerId
            groupPttDownReq.uinType = FileMsg.UIN_TROOP
            groupPttDownReq.groupFileID = 0
            groupPttDownReq.groupFileKey = fileUUId
            groupPttDownReq.md5 = md5Hex.hex2ByteArray()
            groupPttDownReq.voiceType = 1
            groupPttDownReq.downType = 1
            richProtoReq.callback = RichProtoProc.RichProtoCallback { _, resp ->
                if (resp.resps.isEmpty() || resp.resps.first().errCode != 0) {
                    LogCenter.log("requestDownGroupVoice: ${resp.resps.firstOrNull()?.errCode}", Level.WARN)
                    it.resume("")
                } else {
                    val pttDownResp = resp.resps.first() as RichProto.RichProtoResp.GroupPttDownResp
                    val url = StringBuilder()
                    url.append("http://")
                    url.append(pttDownResp.domainV4V6)
                    url.append(pttDownResp.urlPath)
                    url.append("&client_proto=qq&client_appid=${MobileQQ.getMobileQQ().appId}&client_type=android&client_ver=${
                        PlatformUtils.getQQVersion(
                            MobileQQ.getContext())}&client_down_type=auto&client_aio_type=unk")
                    it.resume(url.toString())
                }
            }
            richProtoReq.protoKey = RichProtoProc.GRP_PTT_DW
            richProtoReq.reqs.add(groupPttDownReq)
            richProtoReq.protoReqMgr = runtime.getRuntimeService(IProtoReqManager::class.java, "all")
            RichProtoProc.procRichProtoReq(richProtoReq)
        }
    }

}