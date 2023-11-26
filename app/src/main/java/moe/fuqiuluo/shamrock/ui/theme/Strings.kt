@file:Suppress(
    "SpellCheckingInspection", "unused", "PropertyName",
    "ClassName", "NonAsciiCharacters"
)
package moe.fuqiuluo.shamrock.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import moe.fuqiuluo.shamrock.R

private val LocalStringDefault = Default()
private val LocalString2B = Chūnibyō()

val RANDOM_TITLE = arrayOf(
    "Clover", "CuteKitty", "Shamrock",
    "Threeleaf", "CuteCat", "FuckingCat",
    "XVideos", "Onlyfans", "Pornhub",
    "Xposed", "LittleFox", "Springboot",
    "Kotlin", "Rust & Android", "Dashabi",
    "YYDS", "Amd Yes", "Gayhub",
    "Yuzukkity", "HongKongDoll", "Xinrao"
)
val RANDOM_SUB_TITLE = arrayOf(
    "A Framework Base On Xposed",
    "今天吃什么好呢?",
    "遇事不决，量子力学!",
    "Just kkb?",
    "いいよ，こいよ",
    "伊已逝 吾亦逝",
    "忆久意久 把义领",
    "喵帕斯!",
    "Creeper?",
    "Make American Great Again!",
    "TXHookPro",
    "曾经有人失去了那个她",
    "欲买桂花同载酒，终不似，少年游。",
    "抚千窟为佑 看长安落花",
    "どこにもない",
    "春日和 かかってらしゃい"
)

val LocalString: VarString
    @ReadOnlyComposable
    @Composable
    get() {
        val ctx = LocalContext.current
        val sharedPreferences = ctx.getSharedPreferences("config", 0)
        return if (!sharedPreferences.getBoolean("2B", false)) {
            LocalStringDefault
        } else {
            LocalString2B
        }
    }

private open class Chūnibyō: Default() {
    init {
        TitlesWithIcon = arrayOf(
            "玄天" to R.drawable.round_home_24,
            "天穹" to R.drawable.round_dashboard_24,
            "无极" to R.drawable.round_monitor_heart_24,
            "飘渺" to R.drawable.round_logo_dev_24
        )
        frameworkYes = "仙路已通"
        frameworkNo = "鬼怪横行"
        frameworkYesLite = "五行已备"
        frameworkNoLite = "需待东风"
        legalWarning = "白榆，北辰，曜魄，应星，云川当方位不乱，即可作于无极之域。\n" +
                "执明起，至除免于灾祸。\n" +
                "元冥浩浩，非凡不可动之。"
        labWarning = "寒酥降矣，梅熟日久，莫不可测。"
        logTitle = "无极"
        testName = "未名之人"
        logCentralLoadSuccessfully = "无极开，天地始纷争。"
        logCentralLoadFailed = "无极闭，天地始归宁。"
        functionSetting = "天地法则"
        sslSetting = "天行御令"
        warnTitle = "仙人指路"
        b2Mode = "通仙之路"
        b2ModeDesc = "凡人勿近"
        restartToast = "复关喏哉！"
        showDebugLog = "窥探天机"
        showDebugLogDesc = "迷失自我，走火入魔"
        antiTrace = "鬼影迷踪"
        antiTraceDesc = "唐门绝学，已有取死之道"
        injectPacket = "遮匿无用之禀"
        injectPacketDesc = "试于试之，逆则魂飞魄散"
        persistentText = "丹书铁券"
        persistentTextDesc = ""
    }
}

private open class Default: VarString(
    TitlesWithIcon = arrayOf(
        "主页" to R.drawable.round_home_24,
        "状态" to R.drawable.round_dashboard_24,
        "日志" to R.drawable.round_monitor_heart_24,
        "Lab" to R.drawable.round_logo_dev_24
    ), "框架已激活", "框架未激活",
    "已激活", "未激活",
    legalWarning = "该模块仅适用于目标版本8.9.68及以上的版本。\n" +
            "同时声明本项目仅用于学习与交流，请于24小时内删除。\n" +
            "同时开源贡献者均享受免责条例。",
    labWarning = "实验室功能，可能会导致出乎意料的BUG!",
    logTitle = "日志",
    testName = "测试昵称",
    logCentralLoadSuccessfully = "日志框架激活成功，开放操作许可。",
    logCentralLoadFailed = "日志框架处于未激活状态，请检查。",
    functionSetting = "功能设置",
    sslSetting = "SSL配置",
    warnTitle = "温馨提示",
    b2Mode = "中二病模式",
    b2ModeDesc = "也许会导致奇怪的问题，大抵就是你看不懂罢了。",
    restartToast = "重启生效哦！",
    showDebugLog = "显示调试日志",
    showDebugLogDesc = "会导致日志刷屏。",
    antiTrace = "防止调用栈检测",
    antiTraceDesc = "防止QQ进行堆栈跟踪检测，需要重新启动QQ。",
    injectPacket = "拦截QQ无用收包",
    injectPacketDesc = "测试阶段，可能导致网络异常或掉线。",
    persistentText = "免死金牌",
    persistentTextDesc = "由天地之起也，须复动之。"
)

open class VarString(
    var TitlesWithIcon: Array<Pair<String, Int>>,
    var frameworkYes: String,
    var frameworkNo: String,

    var frameworkYesLite: String,
    var frameworkNoLite: String,

    var legalWarning: String,

    var labWarning: String,

    var logTitle: String,

    var testName: String,

    var logCentralLoadSuccessfully: String,
    var logCentralLoadFailed: String,

    var functionSetting: String,
    var sslSetting: String,

    var warnTitle: String,

    var b2Mode: String,
    var b2ModeDesc: String,

    var restartToast: String,

    var showDebugLog: String,
    var showDebugLogDesc: String,

    var antiTrace: String,
    var antiTraceDesc: String,

    var injectPacket: String,
    var injectPacketDesc: String,

    var persistentText: String,
    var persistentTextDesc: String
)
