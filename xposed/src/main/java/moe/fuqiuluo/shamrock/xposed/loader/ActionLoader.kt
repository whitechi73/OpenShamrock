package moe.fuqiuluo.shamrock.xposed.loader

import android.content.Context
import de.robv.android.xposed.XposedBridge
import moe.fuqiuluo.shamrock.xposed.actions.*
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

object ActionLoader {
    private val ACTION_FIRST_LIST = arrayOf(
        AntiDetection::class,
        DataReceiver::class, // 注册一个接收数据的动态广播
        IpcService::class,
        PullConfig::class, // 从APP进程拉扯配置文件
        ForceTablet::class, // 强制平板模式
        HookWrapperCodec::class, // 注册服务处理器
        HookForDebug::class,
        FixLibraryLoad::class,
        FetchService::class, // 获取服务实例
    )

    private val ACTION_LIST = arrayOf<KClass<*>>(
        InitRemoteService::class, // 创建HTTP API
        NoBackGround::class, // 反QQ后台模式
        GuidLock::class,
    )

    // 先从APP拉取配置文件，再执行其他操作
    fun runFirst(ctx: Context) {
        kotlin.runCatching {
            ACTION_FIRST_LIST.forEach {
                val action = it.createInstance()
                action.invoke(ctx)
            }
        }.onFailure {
            XposedBridge.log(it)
        }
    }

    fun runService(ctx: Context) {
        ACTION_LIST.forEach {
            if (it.java != DataReceiver::class.java) {
                val action = it.createInstance() as IAction
                action.invoke(ctx)
            }
        }
    }
}