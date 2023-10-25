package moe.fuqiuluo.shamrock.remote.action.handlers

import kotlinx.serialization.json.JsonElement
import moe.fuqiuluo.shamrock.utils.FileUtils
import moe.fuqiuluo.shamrock.remote.action.ActionSession
import moe.fuqiuluo.shamrock.remote.action.IActionHandler
import moe.fuqiuluo.shamrock.tools.EmptyJsonString
import moe.fuqiuluo.shamrock.utils.MMKVFetcher

internal object CleanCache: IActionHandler() {
    override suspend fun internalHandle(session: ActionSession): String {
        return invoke(session.echo)
    }

    operator fun invoke(echo: JsonElement = EmptyJsonString): String {
        FileUtils.clearCache()
        MMKVFetcher.mmkvWithId("hash2id")
            .clear()
        MMKVFetcher.mmkvWithId("id2id")
            .clear()
        MMKVFetcher.mmkvWithId("seq2id")
            .clear()
        MMKVFetcher.mmkvWithId("audio2silk")
            .clear()
        return ok("成功", echo)
    }

    override fun path(): String = "clean_cache"
}