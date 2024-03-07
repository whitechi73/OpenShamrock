package qq.service.contact

import moe.fuqiuluo.shamrock.utils.FileUtils
import mqq.app.MobileQQ
import qq.service.QQInterfaces
import java.io.File

internal object LocalCacheHelper: QQInterfaces() {
    // 获取外部储存data目录
    private val dataDir = MobileQQ.getContext().getExternalFilesDir(null)!!
        .parentFile!!.resolve("Tencent")

    fun getCurrentPttPath(): File {
        return dataDir.resolve("MobileQQ/${app.currentAccountUin}/ptt").also {
            if (!it.exists()) it.mkdirs()
        }
    }

    fun getCachePttFile(md5: String): File {
        val file = FileUtils.getFileByMd5(md5)
        return if (file.exists()) file else getCurrentPttPath().resolve("$md5.amr")
    }
}