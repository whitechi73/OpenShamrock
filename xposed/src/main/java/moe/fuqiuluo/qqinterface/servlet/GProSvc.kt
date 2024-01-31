package moe.fuqiuluo.qqinterface.servlet

import com.tencent.mobileqq.qqguildsdk.api.IGPSService

internal object GProSvc: BaseSvc() {


    fun getSelfTinyId(): Long {
        val service = app.getRuntimeService(IGPSService::class.java, "all")
        return service.selfTinyId.toLong()
    }
}