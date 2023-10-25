package moe.fuqiuluo.shamrock.ui.service.internal

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import moe.fuqiuluo.shamrock.ui.service.ModuleTalker
import moe.fuqiuluo.shamrock.ui.service.handlers.*

class MultifunctionalProvider: ContentProvider() {
    override fun insert(uri: Uri, content: ContentValues?): Uri {
        requireNotNull(content)
        requireNotNull(context)

        val hash = content.getAsInteger("__hash")
        val targetCmd = content.getAsString("__cmd")

        ModuleTalker.HandlerMap.forEach { (cmd, handler) ->
            if (cmd == targetCmd) {
                handler.onReceive(hash, content, context!!)
                return uri
            }
        }
        return uri
    }

    override fun onCreate(): Boolean {
        ModuleTalker.register(InitHandler)
        ModuleTalker.register(FetchPortHandler)
        ModuleTalker.register(LogHandler)
        return true
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        return null
    }

    override fun getType(p0: Uri): String? {
        return null
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        return 0
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        return 0
    }
}

inline fun Context.broadcastToModule(intentBuilder: Intent.() -> Unit) {
    val intent = Intent()
    intent.action = "moe.fuqiuluo.xqbot.dynamic"
    intent.intentBuilder()
    sendBroadcast(intent)
}