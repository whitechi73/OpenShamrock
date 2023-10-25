package moe.fuqiuluo.qqinterface.servlet

import com.tencent.biz.map.trpcprotocol.LbsSendInfo
import com.tencent.mobileqq.msf.core.MsfCore
import com.tencent.proto.lbsshare.LBSShare
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant
import moe.fuqiuluo.shamrock.helper.IllegalParamsException
import moe.fuqiuluo.shamrock.tools.slice
import kotlin.math.roundToInt

internal object LbsSvc: BaseSvc() {
    suspend fun tryShareLocation(chatType: Int, peerId: Long, lat: Double, lon: Double): Result<Unit> {
        val req = LbsSendInfo.SendMessageReq()
        req.uint64_peer_account.set(peerId)
        when (chatType) {
            MsgConstant.KCHATTYPEGROUP -> req.enum_relation_type.set(1)
            MsgConstant.KCHATTYPEC2C -> req.enum_relation_type.set(0)
            else -> error("Not supported chat type: $chatType")
        }
        req.str_name.set("位置分享")
        req.str_address.set(getAddressWithLonLat(lat, lon).onFailure {
            return Result.failure(it)
        }.getOrNull())
        req.str_lat.set(lat.toString())
        req.str_lng.set(lon.toString())
        sendPb("trpc.qq_lbs.qq_lbs_ark.LocationArk.SsoSendMessage", req.toByteArray(), MsfCore.getNextSeq())

        return Result.success(Unit)
    }

    suspend fun getAddressWithLonLat(lat: Double, lon: Double): Result<String> {
        if (lat > 90 || lat < 0) {
            return Result.failure(IllegalParamsException("纬度大小错误"))
        }
        if (lon > 180 || lon < 0) {
            return Result.failure(IllegalParamsException("经度大小错误"))
        }
        val latO = (lat * 1000000).roundToInt()
        val lngO = (lon * 1000000).roundToInt()
        val req = LBSShare.LocationReq()
        req.lat.set(latO)
        req.lng.set(lngO)
        req.coordinate.set(1)
        req.keyword.set("")
        req.category.set("")
        req.page.set(0)
        req.count.set(20)
        req.requireMyLbs.set(1)
        req.imei.set("")
        val buffer = sendBufferAW("LbsShareSvr.location", true, req.toByteArray())
            ?: return Result.failure(Exception("获取位置失败"))
        val resp = LBSShare.LocationResp()
        resp.mergeFrom(buffer.slice(4))
        val location = resp.mylbs
        return Result.success(location.addr.get())
    }
}