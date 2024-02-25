package moe.fuqiuluo.qqinterface.servlet.ark.data

sealed class ArkAppInfo(
    val appId: Long,
    val version: String,
    val packageName: String,
    val signature: String,
    val miniAppId: Long = 0
) {
    data object QQMusic: ArkAppInfo(
        appId = 100497308,
        version = "0.0.0",
        packageName = "com.tencent.qqmusic",
        signature = "cbd27cd7c861227d013a25b2d10f0799"
    )
    data object NetEaseMusic: ArkAppInfo(
        appId = 100495085,
        version = "0.0.0",
        packageName = "com.netease.cloudmusic",
        signature = "da6b069da1e2982db3e386233f68d76d"
    )

    data object DanMaKu: ArkAppInfo(
        appId = 100951776,
        version = "0.0.0",
        packageName = "tv.danmaku.bili",
        signature = "7194d531cbe7960a22007b9f6bdaa38b",
        miniAppId = 1109937557
    )

    data object Docs: ArkAppInfo(
        appId = 0,
        version = "0.0.0",
        packageName = "",
        signature = "f3da3147654d9a21f3237b88f20dce9c",
        miniAppId = 1108338344
    )
}