package moe.fuqiuluo.shamrock.remote.service.listener

import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperNetworkListener
import com.tencent.qqnt.kernel.nativeinterface.NetStatusType
import moe.fuqiuluo.shamrock.helper.LogCenter

internal object NetworkListener: IQQNTWrapperNetworkListener {
    override fun onNetworkStatusChanged(o: NetStatusType, n: NetStatusType) {
        LogCenter.log("网络波动: $o -> $n")
    }
}