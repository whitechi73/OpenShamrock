@file:OptIn(ExperimentalFoundationApi::class)
package moe.fuqiuluo.shamrock.ui.fragment

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
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
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.delay
import moe.fuqiuluo.shamrock.R
import moe.fuqiuluo.shamrock.ui.app.AppRuntime
import moe.fuqiuluo.shamrock.ui.app.Level
import moe.fuqiuluo.shamrock.app.config.ShamrockConfig
import moe.fuqiuluo.shamrock.config.*
import moe.fuqiuluo.shamrock.ui.theme.GlobalColor
import moe.fuqiuluo.shamrock.ui.theme.LocalString
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
        FunctionCard(scope, ctx, LocalString.functionSetting)
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

            val rpcPort = remember { mutableStateOf(ShamrockConfig[ctx, RPCPort].toString()) }
            TextItem(
                title = "RPC服务端口",
                desc = "端口范围在0~65565，并确保可用。",
                text = rpcPort,
                hint = "请输入端口号",
                error = "端口范围应在0~65565",
                checker = {
                    it.isNotBlank() && kotlin.runCatching { it.toInt() in 0..65565 }
                        .getOrDefault(false) && rpcPort.value != it
                },
                confirm = {
                    val newPort = rpcPort.value.toInt()
                    ShamrockConfig[ctx, RPCPort] = newPort
                    AppRuntime.log("设置主动HTTP监听端口为$newPort，立即生效尝试中。")
                }
            )

            val rpcAddress = remember { mutableStateOf(ShamrockConfig[ctx, RPCAddress]) }
            TextItem(
                title = "回调RPC地址",
                desc = "例如：kritor.support:8081",
                text = rpcAddress,
                hint = "请输入回调地址",
                error = "输入的地址不合法",
                checker = { true },
                confirm = {
                    ShamrockConfig[ctx, RPCAddress] = rpcAddress.value
                    AppRuntime.log("设置回调RPC地址为[${rpcAddress.value}]。")
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
                isSwitch = ShamrockConfig[ctx, ForceTablet]
            ) {
                ShamrockConfig[ctx, ForceTablet] = it
                return@Function true
            }

            Function(
                title = "主动RPC",
                desc = "Kritor协议实现RPC，由Shamrock放出rpc服务",
                isSwitch = ShamrockConfig[ctx, ActiveRPC]
            ) {
                ShamrockConfig[ctx, ActiveRPC] = it
                return@Function true
            }

            Function(
                title = "被动RPC",
                desc = "Kritor协议实现RPC，由客户端提供反向的rpc服务",
                isSwitch = ShamrockConfig[ctx, PassiveRPC]
            ) {
                ShamrockConfig[ctx, PassiveRPC] = it
                return@Function true
            }

            run {
                val uploadResourceGroup = remember { mutableStateOf(ShamrockConfig[ctx, ResourceGroup]) }
                Column(
                    modifier = Modifier
                        .absolutePadding(left = 8.dp, right = 8.dp, top = 12.dp, bottom = 0.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = "用来上传资源的群聊，错误的资源上传终点可能导致封禁，请自建一个群聊并填写在下方。",
                        color = Color.Red,
                        fontSize = 11.sp
                    )
                }
                TextItem(
                    title = "接受资源群聊",
                    desc = "用来上传资源的群聊，请自建一个群聊并填写在下方。",
                    text = uploadResourceGroup,
                    hint = "请输入群号",
                    error = "群号不合法",
                    checker = {
                        it.isNotBlank() && it.toULongOrNull() != null
                    },
                    confirm = {
                        val groupId = uploadResourceGroup.value
                        ShamrockConfig[ctx, ResourceGroup] = groupId
                        AppRuntime.log("设置接受资源群聊为[$groupId]。")
                    }
                )
            }
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
            }) { true }
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