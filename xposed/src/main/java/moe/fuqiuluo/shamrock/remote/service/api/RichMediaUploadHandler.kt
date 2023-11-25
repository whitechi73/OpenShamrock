package moe.fuqiuluo.shamrock.remote.service.api

import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo

internal object RichMediaUploadHandler {
    private val listeners by lazy {
        mutableMapOf<Long, FileTransNotifyInfo.() -> Boolean>()
    }

    fun registerListener(key: Long, value: FileTransNotifyInfo.() -> Boolean) {
        listeners[key] = value
    }

    fun removeListener(key: Long) {
        listeners.remove(key)
    }

    fun notify(info: FileTransNotifyInfo): Boolean {
        listeners[info.msgId]?.let {
            if (it(info)) {
                listeners.remove(info.msgId)
                return true
            }
        }
        return false
    }
}