package qq.service.internals

import com.tencent.qqnt.kernel.nativeinterface.DevInfo
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo
import qq.service.kernel.SimpleKernelMsgListener
import java.util.ArrayList

object LineDevListener: SimpleKernelMsgListener() {
    override fun onKickedOffLine(kickedInfo: KickedInfo) {
    }

    override fun onLineDev(devs: ArrayList<DevInfo>) {
    }
}