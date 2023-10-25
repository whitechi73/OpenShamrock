package moe.fuqiuluo.shamrock.xposed.helper

import com.tencent.qqnt.kernel.api.IKernelService
import com.tencent.qqnt.kernel.api.impl.MsgService
import java.lang.reflect.Method

internal object KernelServiceHelper {
    private lateinit var M_GET_MSG_SERVICE: Method

    fun getMsgService(service: IKernelService): MsgService? {
        if (!KernelServiceHelper::M_GET_MSG_SERVICE.isInitialized) {
            M_GET_MSG_SERVICE = IKernelService::class.java.getMethod("getMsgService")
        }
        return M_GET_MSG_SERVICE.invoke(service) as? MsgService
    }
}

internal val IKernelService.msgService: MsgService?
    get() = KernelServiceHelper.getMsgService(this)