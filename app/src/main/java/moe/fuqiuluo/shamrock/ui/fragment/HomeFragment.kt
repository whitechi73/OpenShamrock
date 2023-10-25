package moe.fuqiuluo.shamrock.ui.fragment

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.fuqiuluo.shamrock.R
import moe.fuqiuluo.shamrock.ui.app.RuntimeState
import moe.fuqiuluo.shamrock.ui.theme.GlobalColor
import moe.fuqiuluo.shamrock.ui.theme.LocalString

@Composable
fun HomeFragment(
    runtime: RuntimeState
) {
    //val scope = rememberCoroutineScope()
    val ctx = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        StatusCardBoard(runtime.isFined, runtime.coreVersion, runtime.coreName)

        NoticeBox(
            modifier = Modifier
                .padding(top = 12.dp),
            text = LocalString.legalWarning,
        ) {
            Toast.makeText(
                ctx, arrayOf(
                    "请严格遵守哦！",
                    "点我又不能下崽...",
                    "家人们谁懂啊!",
                    "别点啦，记得遵守规则啊！",
                    "CRC：06f77ca1"
                ).random(), Toast.LENGTH_SHORT
            ).show()
        }

        ActionBox(
            modifier = Modifier
                .padding(top = 12.dp),
            painter = painterResource(id = R.drawable.ic_help_512),
            title = "使用教程 & 注意事项"
        ) { textColor ->
            Text(
                text = """
                    Q：如何使用呢？
                    A：在Xposed/Lsposed中激活模块，选中目标应用重新后强行停止目标应用并重新启动即可。
                    Q：冻结封号是怎么回事？
                    A：也许未来的某个时刻，会加强检测吧。亦或许你发了什么不干净的东西呢。
                    Q：Shamrock有模块冲突？
                    A：目前没有发现模块冲突。
                    Q：Shamrock需求权限？
                    A：Shamrock使用到了Net权限，去实现HTTPAPI和WebSocket的一些请求，请确保你所设置的端口未被占用。当你使用来自一些Android机器人框架的插件，请确保本APP的存活，否则将无法运行；当你使用来自OneBot标准的相关接口时，无需保证APP的存活。
                    Q：Shamrock运行原理？
                    A：使用Xposed框架，将代码插入到QQ运行时，并在QQ内使用Ktor框架放出外部可用的API接口，采用Provider/DynamicBroadcast与实现模块与目标进程数据交互，无需额外的储存权限。
                    Q：兼容性框架支持有哪些？
                    A：
                       1，支持载入一些Android机器人框架的插件(如QR词库插件)。
                       2，支持OneBot12标准，但不会更新支持之后的OneBot标准(特殊性)。
                       3，原始支持来自Native/Jvm的插件。
                """.trimIndent(),
                color = textColor,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun StatusCardBoard(
    isRight: MutableState<Boolean>,
    version: MutableState<String>,
    core: MutableState<String>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.linearGradient(
                    listOf(GlobalColor.StatusCardStart, GlobalColor.StatusCardEnd)
                ), shape = RoundedCornerShape(12.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .padding(
                    start = 25.dp,
                    end = 5.dp
                )
                .width(20.dp)
                .height(20.dp),
            painter = painterResource(
                id = if (isRight.value) R.drawable.round_near_me_24 else
                    R.drawable.round_near_me_disabled_24
            ),
            contentDescription = "StatusIcon",
            tint = Color.White
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = if (isRight.value) LocalString.frameworkYesLite else LocalString.frameworkNoLite,
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                text = "${version.value} - ${core.value}",
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainPreview() {
    val isFined = remember { mutableStateOf(false) }
    val coreVersion = remember { mutableStateOf("1.0.0") }
    val coreName = remember { mutableStateOf("Xposed") }
    val voiceSwitch = remember {
        mutableStateOf(false)
    }

    val runtime = remember {
        RuntimeState(isFined, coreVersion, coreName, voiceSwitch)
    }

    HomeFragment(runtime)
}