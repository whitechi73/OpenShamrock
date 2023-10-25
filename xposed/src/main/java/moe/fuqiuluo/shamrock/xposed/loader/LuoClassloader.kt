package moe.fuqiuluo.shamrock.xposed.loader

object LuoClassloader: ClassLoader() {
    lateinit var hostClassLoader: ClassLoader
    lateinit var ctxClassLoader: ClassLoader

    fun load(name: String): Class<*>? {
        return kotlin.runCatching {
            loadClass(name)
        }.getOrNull()
    }

    override fun loadClass(name: String?): Class<*> {
        return kotlin.runCatching {
            hostClassLoader.loadClass(name)
        }.getOrElse {
            kotlin.runCatching {
                ctxClassLoader.loadClass(name)
            }.getOrElse {
                super.loadClass(name)
            }
        }
    }
}