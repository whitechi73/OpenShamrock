@file:OptIn(ExperimentalFoundationApi::class)
package moe.fuqiuluo.shamrock.ui.fragment

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import kotlinx.coroutines.CoroutineScope
import moe.fuqiuluo.shamrock.R
import moe.fuqiuluo.shamrock.ui.app.AppRuntime
import moe.fuqiuluo.shamrock.ui.app.Level
import moe.fuqiuluo.shamrock.ui.app.ShamrockConfig
import moe.fuqiuluo.shamrock.ui.theme.GlobalColor
import moe.fuqiuluo.shamrock.ui.theme.ThemeColor
import moe.fuqiuluo.shamrock.ui.tools.InputDialog

@Composable
fun DashboardFragment(
    nick: String,
    uin: String
) {
    val scope = rememberCoroutineScope()
    val ctx = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        AccountCard(nick, uin)
        InformationCard(ctx)
        APIInfoCard(ctx)
        FunctionCard(scope, ctx, "功能设置")
        SSLCard(ctx)
    }
}

@Composable
private fun SSLCard(ctx: Context) {
    ActionBox(
        modifier = Modifier.padding(top = 12.dp),
        painter = painterResource(id = R.drawable.baseline_security_24),
        title = "SSL配置"
    ) {
        Column {
            Divider(
                modifier = Modifier,
                color = GlobalColor.Divider,
                thickness = 0.2.dp
            )

            val sslPort = remember { mutableStateOf(ShamrockConfig.getSSLPort(ctx).toString()) }
            TextItem(
                title = "SSL端口",
                desc = "端口范围在0~65565，并确保可用。",
                text = sslPort,
                hint = "请输入端口号",
                error = "端口范围应在0~65565",
                checker = {
                    it.isNotBlank() && kotlin.runCatching { it.toInt() in 0..65565 }.getOrDefault(false)
                },
                confirm = {
                    val newPort = sslPort.value.toInt()
                    ShamrockConfig.setSSLPort(ctx, newPort)
                    AppRuntime.log("设置SSL(HTTP)端口为$newPort，立即生效尝试中。")
                }
            )

            val keyStore = remember { mutableStateOf(ShamrockConfig.getSSLKeyPath(ctx)) }
            TextItem(
                title = "SSL证书",
                desc = "BKS签名的证书。",
                text = keyStore,
                hint = "输入证书路径",
                error = "证书路径不合法或不存在",
                checker = {
                    it.isNotBlank()
                },
                confirm = {
                    val new = keyStore.value
                    ShamrockConfig.setSSLKeyPath(ctx, new)
                    AppRuntime.log("设置SSL证书为[$new]。")
                }
            )

            val alias = remember { mutableStateOf(ShamrockConfig.getSSLAlias(ctx)) }
            TextItem(
                title = "SSL别名",
                desc = "BKS签名的别名，确保大小写区分正确。",
                text = alias,
                hint = "输入签名别名",
                error = "别名不合法",
                checker = {
                    it.isNotBlank()
                },
                confirm = {
                    val new = alias.value
                    ShamrockConfig.setSSLAlias(ctx, new)
                    AppRuntime.log("设置SSL别名为[$new]。")
                }
            )

            val sslPwd = remember { mutableStateOf(ShamrockConfig.getSSLPwd(ctx)) }
            TextItem(
                title = "SSL密码",
                desc = "BKS签名的密码。",
                text = sslPwd,
                hint = "输入签名密码",
                error = "密码不合法",
                checker = {
                    it.isNotBlank()
                },
                confirm = {
                    val new = sslPwd.value
                    ShamrockConfig.setSSLPwd(ctx, new)
                    AppRuntime.log("设置SSL密码为[$new]。")
                }
            )

            val sslPrivatePwd = remember { mutableStateOf(ShamrockConfig.getSSLPrivatePwd(ctx)) }
            TextItem(
                title = "SSL Private密码",
                desc = "BKS签名的Private密码。",
                text = sslPrivatePwd,
                hint = "输入Private密码",
                error = "密码不合法",
                checker = {
                    it.isNotBlank()
                },
                confirm = {
                    val new = sslPrivatePwd.value
                    ShamrockConfig.setSSLPrivatePwd(ctx, new)
                    AppRuntime.log("设置SSL Private密码为[$new]。")
                }
            )

        }
    }
}

@Composable
private fun APIInfoCard(
    ctx: Context
) {
    ActionBox(
        modifier = Modifier.padding(top = 12.dp),
        painter = painterResource(id = R.drawable.round_info_24),
        title = "接口信息(双击修改)"
    ) {
        Column {
            Divider(
                modifier = Modifier,
                color = GlobalColor.Divider,
                thickness = 0.2.dp
            )

            val wsPort = remember { mutableStateOf(ShamrockConfig.getWsPort(ctx).toString()) }
            val port = remember { mutableStateOf(ShamrockConfig.getHttpPort(ctx).toString()) }
            TextItem(
                title = "主动HTTP端口",
                desc = "端口范围在0~65565，并确保可用。",
                text = port,
                hint = "请输入端口号",
                error = "端口范围应在0~65565",
                checker = {
                    it.isNotBlank() && kotlin.runCatching { it.toInt() in 0..65565 }.getOrDefault(false) && wsPort.value != it
                },
                confirm = {
                    val newPort = port.value.toInt()
                    ShamrockConfig.setHttpPort(ctx, newPort)
                    AppRuntime.log("设置主动HTTP监听端口为$newPort，立即生效尝试中。")
                }
            )

            TextItem(
                title = "主动WebSocket端口",
                desc = "端口范围在0~65565，并确保可用。",
                text = wsPort,
                hint = "请输入端口号",
                error = "端口范围应在0~65565",
                checker = {
                    it.isNotBlank() && kotlin.runCatching { it.toInt() in 0..65565 }.getOrDefault(false) && it != port.value
                },
                confirm = {
                    val newPort = wsPort.value.toInt()
                    ShamrockConfig.setWsPort(ctx, newPort)
                    AppRuntime.log("设置主动WebSocket监听端口为$newPort。")
                }
            )

            val webHookAddress = remember { mutableStateOf(ShamrockConfig.getHttpAddr(ctx)) }
            TextItem(
                title = "回调HTTP地址",
                desc = "例如：http://shamrock.moe:80。",
                text = webHookAddress,
                hint = "请输入回调地址",
                error = "输入的地址不合法",
                checker = {
                    it.isNotBlank()
                },
                confirm = {
                    if (it.startsWith("http://") || it.startsWith("https://")) {
                        ShamrockConfig.setHttpAddr(ctx, webHookAddress.value)
                        AppRuntime.log("设置回调HTTP地址为[${webHookAddress.value}]。")
                    } else {
                        Toast.makeText(ctx, "回调地址不合法", Toast.LENGTH_SHORT).show()
                        webHookAddress.value = ""
                    }
                }
            )

            val wsAddress = remember { mutableStateOf(ShamrockConfig.getWsAddr(ctx)) }
            TextItem(
                title = "被动WebSocket地址",
                desc = "例如：ws://shamrock.moe:81，多个使用逗号分隔。",
                text = wsAddress,
                hint = "请输入被动地址",
                error = "输入的地址不合法",
                checker = {
                    it.startsWith("ws://") || it.startsWith("wss://") || it.isBlank()
                },
                confirm = {
                    if (it.startsWith("ws://") || it.startsWith("wss://") || it.isBlank()) {
                        ShamrockConfig.setWsAddr(ctx, wsAddress.value)
                        AppRuntime.log("设置被动WebSocket地址为[${wsAddress.value}]。")
                    } else {
                        Toast.makeText(ctx, "被动WebSocket地址不合法", Toast.LENGTH_SHORT).show()
                        wsAddress.value = ""
                    }
                }
            )

            val authToken = remember { mutableStateOf(ShamrockConfig.getToken(ctx)) }
            TextItem(
                title = "鉴权Token",
                desc = "用于鉴权的Token。",
                text = authToken,
                hint = "请填写鉴权token",
                error = "输入的参数不合法",
                checker = {
                    it.length in 0 .. 36
                },
                confirm = {
                    ShamrockConfig.setToken(ctx, authToken.value)
                    AppRuntime.log("设置鉴权Token为[${authToken.value}]。")
                }
            )

            InfoItem(
                title = "累计调用次数",
                content = AppRuntime.requestCount.intValue.toString()
            )
        }
    }
}

@Composable
private fun FunctionCard(
    scope: CoroutineScope,
    ctx: Context,
    title: String
) {
    ActionBox(
        modifier = Modifier.padding(top = 12.dp),
        painter = painterResource(id = R.drawable.round_api_24),
        title = title
    ) {
        Column {
            Divider(
                modifier = Modifier,
                color = GlobalColor.Divider,
                thickness = 0.2.dp
            )

            Function(
                title = "强制平板模式",
                desc = "强制QQ使用平板模式，实现共存登录。",
                isSwitch = ShamrockConfig.isTablet(ctx)
            ) {
                ShamrockConfig.setTablet(ctx, it)
                return@Function true
            }

            Function(
                title = "HTTP回调",
                desc = "OneBot标准的HTTPAPI回调，Shamrock作为Client。",
                isSwitch = ShamrockConfig.isWebhook(ctx)
            ) {
                ShamrockConfig.setWebhook(ctx, it)
                return@Function true
            }

            Function(
                title = "消息格式为CQ码",
                desc = "HTTPAPI回调的消息格式，关闭则为消息段。",
                isSwitch = ShamrockConfig.isUseCQCode(ctx)
            ) {
                ShamrockConfig.setUseCQCode(ctx, it)
                return@Function true
            }

            Function(
                title = "主动WebSocket",
                desc = "OneBot标准WebSocket，Shamrock作为Server。",
                isSwitch = ShamrockConfig.isWs(ctx)
            ) {
                ShamrockConfig.setWs(ctx, it)
                return@Function true
            }

            Function(
                title = "被动WebSocket",
                desc = "OneBot标准WebSocket，Shamrock作为Client。",
                isSwitch = ShamrockConfig.isWsClient(ctx)
            ) {
                ShamrockConfig.setWsClient(ctx, it)
                return@Function true
            }

            /*
            Function(
                title = "专业级接口",
                desc = "如果你不知道你在做什么，请不要开启本功能。",
                descColor = Color.Red,
                isSwitch = ShamrockConfig.isPro(ctx)
            ) {
                ShamrockConfig.setPro(ctx, it)
                AppRuntime.log("专业级API = $it", Level.WARN)
                return@Function true
            }*/
        }
    }
}

@Composable
private fun Function(
    title: String,
    desc: String? = null,
    descColor: Color? = GlobalColor.NoticeBoxText,
    isSwitch: Boolean,
    onClick: (Boolean) -> Boolean
) {
    Column(
        modifier = Modifier
            .absolutePadding(left = 8.dp, right = 8.dp, top = 12.dp, bottom = 0.dp)
    ) {
        if (desc != null && descColor != null) {
            Text(
                modifier = Modifier.padding(2.dp),
                text = desc,
                color = descColor,
                fontSize = 11.sp
            )
        }
        ActionSwitch(
            text = title,
            isSwitch = isSwitch,
        ) {
            onClick(it)
        }
    }
}

@Composable
private fun InformationCard(ctx: Context) {
    ActionBox(
        modifier = Modifier.padding(top = 12.dp),
        painter = painterResource(id = R.drawable.round_info_24),
        title = "数据信息"
    ) {
        Column {
            Divider(
                modifier = Modifier,
                color = GlobalColor.Divider,
                thickness = 0.2.dp
            )

            InfoItem(
                title = "系统版本",
                content =  "${Build.VERSION.RELEASE} (API ${Build.VERSION.SDK_INT})"
            )

            InfoItem(title = "设备", content = "${Build.BRAND} ${Build.MODEL}") {
                val cm = ctx.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val mClipData = ClipData.newPlainText("Label", it)
                cm.setPrimaryClip(mClipData)
            }

            InfoItem(title = "系统架构", content = Build.SUPPORTED_ABIS.joinToString())
        }
    }
}

@Composable
private fun InfoItem(
    modifier: Modifier = Modifier,
    titleColor: Color = GlobalColor.NoticeBoxText,
    contentColor: Color = GlobalColor.NoticeBoxText,
    title: String,
    content: String,
    doubleClick: ((String) -> Unit)? = null
) {
    Row(
        modifier = modifier
            .absolutePadding(left = 8.dp, right = 8.dp, top = 12.dp, bottom = 0.dp)
            .fillMaxWidth()
            .combinedClickable(onDoubleClick = {
                doubleClick?.invoke(content)
            }) {
                true
            }
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            color = titleColor
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = content,
                fontSize = 14.sp,
                color = contentColor
            )
        }
    }
}

@Composable
private fun AccountCard(
    nick: String,
    uin: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.linearGradient(
                    listOf(ThemeColor.ColorAccountCardStart, ThemeColor.ColorAccountCardEnd)
                ), shape = RoundedCornerShape(12.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val painter = kotlin.runCatching {
            rememberAsyncImagePainter(model = ImageRequest.Builder(LocalContext.current)
                .data("https://q.qlogo.cn/g?b=qq&nk=$uin&s=100")
                .crossfade(true)
                .size(Size.ORIGINAL)
                .build())
        }.onSuccess {
            when(it.state){
                is AsyncImagePainter.State.Success ->{

                }
                is AsyncImagePainter.State.Loading ->{
                }
                is AsyncImagePainter.State.Error ->{
                    AppRuntime.log("头像拉取失败，请检查网络连接。", Level.ERROR)
                }
                else -> {}
            }
        }.getOrDefault(painterResource(id = R.drawable.ic_letter_q))

        Icon(
            modifier = Modifier
                .padding(
                    start = 15.dp,
                    end = 5.dp
                )
                .width(45.dp)
                .height(45.dp)
                .clip(RoundedCornerShape(36.dp))
            ,
            painter = painter,
            contentDescription = "HeadLogo",
            tint = Color.Unspecified
        )
        Column(
            modifier = Modifier
                .padding(20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = nick,
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                text = "QQ号：$uin",
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
private inline fun TextItem(
    title: String,
    desc: String,
    text: MutableState<String>,
    hint: String,
    error: String,
    noinline checker: (String) -> Boolean,
    crossinline
    confirm: (String) -> Unit,
    crossinline cancel: () -> Unit = {

    }
) {
    val dialogPortInputState = InputDialog(
        openDialog = remember { mutableStateOf(false) },
        title = title,
        desc = desc,
        isError = remember { mutableStateOf(false) },
        text = text,
        hint = hint,
        keyboardType = KeyboardType.Text,
        errorText = error,
        checker = checker
    )
    InfoItem(
        title = title,
        content = text.value.ifEmpty { "未配置" },
        titleColor = GlobalColor.DataBoxTextLight,
        contentColor = if (text.value.isEmpty()) GlobalColor.DataBoxTextDark else GlobalColor.DataBoxTextLight
    ) {
        dialogPortInputState.show(
            confirm = {
                confirm(text.value)
            },
            cancel = {
                cancel()
            }
        )
    }
}

@Preview
@Composable
private fun PreViewDashBoard() {
    DashboardFragment("测试昵称", "100001")
}