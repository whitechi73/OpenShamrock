package moe.fuqiuluo.shamrock.ui.fragment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.fuqiuluo.shamrock.R
import moe.fuqiuluo.shamrock.ui.theme.GlobalColor
import moe.fuqiuluo.shamrock.ui.tools.IosSwitch

@Composable
fun NoticeBox(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .indication(remember { MutableInteractionSource() }, null)
            .background(
                color = GlobalColor.NoticeBox,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(enabled = onClick != null) {
                onClick?.invoke()
            }
    ) {
        Row(
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    bottom = 10.dp
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(10.dp)
                    .width(20.dp)
                    .height(20.dp),
                painter = painterResource(id = R.drawable.round_warning_24),
                contentDescription = "WarningIcon",
                tint = GlobalColor.NoticeBoxIcon
            )
            Text(
                text = text,
                fontSize = 11.sp,
                color = GlobalColor.NoticeBoxText
            )
        }
    }
}

@Composable
fun ActionBox(
    modifier: Modifier = Modifier,
    painter: Painter,
    title: String,
    content: @Composable (textColor: Color) -> Unit
) {
    val textColor = GlobalColor.NoticeBoxText
    Box(
        modifier = modifier
            .fillMaxWidth()
            .indication(remember { MutableInteractionSource() }, null)
            .background(
                color = GlobalColor.NoticeBox,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    bottom = 10.dp
                )
                .fillMaxWidth(),
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(20.dp)
                        .height(20.dp),
                    painter = painter,
                    contentDescription = "ActionIcon",
                    tint = Color.Unspecified
                )
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    text = title,
                    fontSize = 12.sp,
                    color = textColor
                )
            }

            Row(
                modifier = Modifier.padding(8.dp)
            ) {
                content.invoke(textColor)
            }
        }
    }
}

@Composable
fun ActionSwitch(
    text: String,
    isSwitch: Boolean,
    onValueChanged: (Boolean) -> Boolean,
) {
    Row(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier,
            text = text,
            fontSize = 13.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IosSwitch(
                switchValue = isSwitch,
                buttonHeight = 22.dp,
                onValueChanged = onValueChanged
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NoticeBoxPreview() {
    NoticeBox(
        text = "该模块仅适用于QQ版本8.9.68及以上的版本。\n" +
                "同时声明本项目仅用于学习与交流，请于24小时内删除。\n" +
                "同时开源贡献者均享受免责条例。"
    )
}

@Preview(showBackground = true)
@Composable
private fun ActionBoxPreview() {
    ActionBox(
        painter = painterResource(id = R.drawable.ic_help_512),
        title = "使用帮助 & 教程"
    ) {
        
    }
}