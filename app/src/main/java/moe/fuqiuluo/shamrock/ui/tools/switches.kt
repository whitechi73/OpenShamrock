package moe.fuqiuluo.shamrock.ui.tools

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IosSwitch(
    modifier: Modifier = Modifier,
    buttonHeight: Dp = 40.dp,
    innerPadding: Dp = 3.5.dp,
    shape: RoundedCornerShape = RoundedCornerShape(45.dp),
    switchValue: Boolean,
    positiveColor: Color = Color(0xFF35C759),
    negativeColor: Color = Color(0xFFE9E9EA),
    onValueChanged: (Boolean) -> Boolean,
) {
    var width by remember { (mutableStateOf(0.dp)) }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    var switchClicked by remember {
        mutableStateOf(switchValue)
    }

    var padding by remember {
        mutableStateOf(0.dp)
    }

    padding = if (!switchClicked) 0.dp else width - (width / 2)

    val animateSize by animateDpAsState(
        targetValue = if (!switchClicked) 0.dp else padding,
        tween(
            durationMillis = 300,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        ), label = "DpAnimation"
    )

    val animateBgColor by animateColorAsState(
        targetValue = if (switchClicked) positiveColor else negativeColor,
        tween(
            durationMillis = 300,
            delayMillis = 0,
            easing = FastOutSlowInEasing
        ), label = "ColorAnimation"
    )

    val localDensity = LocalDensity.current
    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = buttonHeight * 2,
                minHeight = buttonHeight
            )
            .onGloballyPositioned {
                width = with(localDensity) {
                    it.size.width.toDp()
                }
            }
            .height(buttonHeight)
            .clip(shape = shape)
            .background(animateBgColor)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                if(onValueChanged(!switchClicked)) {
                    switchClicked = !switchClicked
                }
            }
    ) {
        Row {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(animateSize)
                    .background(Color.Transparent)
            )
            Box(
                modifier = Modifier
                    .size(buttonHeight)
                    .padding(innerPadding)
                    .shadow(elevation = 5.dp, shape)
                    .clip(shape = shape)
                    .background(Color.White)
            )
        }
    }
}

@Preview
@Composable
private fun SwitchPreView() {
    IosSwitch(
        switchValue = false,
        buttonHeight = 22.dp,
        onValueChanged = {
            false
        }
    )
}