@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package moe.fuqiuluo.shamrock

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import moe.fuqiuluo.shamrock.ui.app.AppRuntime
import moe.fuqiuluo.shamrock.ui.app.Logger
import moe.fuqiuluo.shamrock.ui.app.RuntimeState
import moe.fuqiuluo.shamrock.ui.fragment.DashboardFragment
import moe.fuqiuluo.shamrock.ui.fragment.HomeFragment
import moe.fuqiuluo.shamrock.ui.fragment.LabFragment
import moe.fuqiuluo.shamrock.ui.fragment.LogFragment
import moe.fuqiuluo.shamrock.ui.service.internal.broadcastToModule
import moe.fuqiuluo.shamrock.ui.theme.GlobalColor
import moe.fuqiuluo.shamrock.ui.theme.LocalString
import moe.fuqiuluo.shamrock.ui.theme.RANDOM_SUB_TITLE
import moe.fuqiuluo.shamrock.ui.theme.RANDOM_TITLE
import moe.fuqiuluo.shamrock.ui.theme.ShamrockTheme
import moe.fuqiuluo.shamrock.ui.tools.NoIndication
import moe.fuqiuluo.shamrock.ui.tools.ShamrockTab
import moe.fuqiuluo.shamrock.ui.tools.getShamrockVersion

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(
                LocalIndication provides NoIndication
            ) {
                AppMainView()
            }
            WindowCompat.getInsetsController(window, LocalView.current).apply {
                isAppearanceLightStatusBars = true
            }
            WindowCompat.setDecorFitsSystemWindows(window, true)
            broadcastToModule { putExtra("__cmd", "fetchPort") }
        }
    }
}

@Composable
private fun AppMainView() {
    val scope = rememberCoroutineScope()

    val systemUiController = rememberSystemUiController()
    val statusBarDarkIcons by remember { mutableStateOf(true) }
    val navigationBarDarkIcons by remember { mutableStateOf(true) }

    LaunchedEffect(systemUiController, statusBarDarkIcons, navigationBarDarkIcons) {
        systemUiController.statusBarDarkContentEnabled = statusBarDarkIcons
        systemUiController.navigationBarDarkContentEnabled = navigationBarDarkIcons
        systemUiController.setStatusBarColor(GlobalColor.StatusBar)
    }

    val context = LocalContext.current

    // Home
    val isFined = remember { mutableStateOf(false) }
    val coreVersion = remember { mutableStateOf(getShamrockVersion(context)) }
    val coreName = remember { mutableStateOf("Xposed") }
    val voiceSwitch = remember { mutableStateOf(false) }
    @Suppress("LocalVariableName") val LocalString = LocalString.init()

    if (!AppRuntime.isInit) {
        AppRuntime.state = remember {
            RuntimeState(isFined, coreVersion, coreName, voiceSwitch)
        }

        AppRuntime.logger = remember {
            Logger(
                StringBuffer(),
                mutableIntStateOf(0),
                mutableListOf(),
                mutableStateOf(AnnotatedString(""))
            )
        }

        AppRuntime.AccountInfo.also {
            it.uin = remember {
                mutableStateOf("2854200454")
            }
            it.nick = remember {
                mutableStateOf(LocalString.testName)
            }
        }

        AppRuntime.requestCount = remember { mutableIntStateOf(0) }

        AppRuntime.isInit = true
    }

    val ctx = LocalContext.current
    LaunchedEffect(isFined.value) {
        if (isFined.value) {
            AppRuntime.log(LocalString.logCentralLoadSuccessfully)
            Toast.makeText(ctx, LocalString.frameworkYes, Toast.LENGTH_SHORT).show()
        } else {
            AppRuntime.log(LocalString.logCentralLoadFailed)
            Toast.makeText(ctx, LocalString.frameworkNo, Toast.LENGTH_SHORT).show()
        }
    }

    ShamrockTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            @Suppress("LocalVariableName") val TitlesWithIcon = LocalString.TitlesWithIcon
            val state = rememberPagerState(
                pageCount = { TitlesWithIcon.size },
                initialPage = 0,
                initialPageOffsetFraction = 0f,
            )

            Scaffold(
                topBar = {
                    ToolBar(
                        title = RANDOM_TITLE.random()
                    )
                }
            ) {
                val topPadding = it.calculateTopPadding()
                Column(
                    modifier = Modifier
                        .padding(top = topPadding)
                ) {
                    TabRow(
                        modifier = Modifier
                            .width(1080.dp)
                            .background(GlobalColor.Toolbar)
                            .absolutePadding(left = 70.dp, right = 70.dp),
                        selectedTabIndex = state.currentPage,
                        divider = { },
                        indicator = {
                            TabRowDefaults.Indicator(
                                Modifier.tabIndicatorOffset(it[state.currentPage]),
                                color = GlobalColor.TabItem,
                                height = (3.3).dp
                            )
                        },
                    ) {
                        TitlesWithIcon.forEachIndexed { index, titleWithIcon ->
                            AnimatedTab(scope, state, index, titleWithIcon)
                        }
                    }

                    Divider(
                        modifier = Modifier
                            .shadow(8.dp),
                        color = Color(0xBFDADADA),
                        thickness = 0.2.dp
                    )

                    HorizontalPager(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        state = state,
                    ) { page ->
                        when (page) {
                            0 -> HomeFragment(AppRuntime.state)
                            1 -> AppRuntime.AccountInfo.let {
                                DashboardFragment(it.nick.value, it.uin.value)
                            }

                            2 -> LogFragment(AppRuntime.logger)
                            3 -> LabFragment()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ToolBar(title: String) {
    TopAppBar(
        title = {
            Column {
                Text(
                    text = title,
                    color = GlobalColor.ToolbarText,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = RANDOM_SUB_TITLE.random(),
                    color = GlobalColor.ToolbarText,
                    fontSize = 14.sp
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = topAppBarColors(
            titleContentColor = Color.Black,
            containerColor = GlobalColor.Toolbar,
            scrolledContainerColor = GlobalColor.Toolbar,
            navigationIconContentColor = GlobalColor.Toolbar
        )
    )
}

private val SELECTED_TABLE = arrayOf(
    1, 2,
    4, 8,
    16, 32,
    64, 128,
    256, 512,
    1024, 2048
)

@Composable
@SuppressLint("AutoboxingStateValueProperty")
private fun AnimatedTab(
    scope: CoroutineScope,
    state: PagerState,
    index: Int,
    titleWithIcon: Pair<String, Int>
) {
    val curSelected = index == state.currentPage
    val lastSelectedState = remember {
        mutableIntStateOf(0)
    }
    val enter = remember {
        scaleIn(animationSpec = TweenSpec(150, easing = FastOutLinearInEasing))
    }
    val exit = remember {
        scaleOut(animationSpec = TweenSpec(150, easing = FastOutSlowInEasing))
    }

    val defaultConst = SELECTED_TABLE[index * 2]
    val selectedConst = SELECTED_TABLE[(index * 2) + 1]
    val isFirst: Boolean = (lastSelectedState.value and defaultConst) != defaultConst

    var icon: @Composable (() -> Unit)? = null
    var text: @Composable (() -> Unit)? = null

    if (curSelected) {
        text = {
            AnimatedVisibility(visibleState = MutableTransitionState(false).also {
                it.targetState =
                    isFirst || lastSelectedState.value and selectedConst == selectedConst
            }, enter = enter, exit = exit, modifier = Modifier) {
                Text(
                    text = titleWithIcon.first,
                    color = GlobalColor.TabItem,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .indication(
                            remember { MutableInteractionSource() },
                            rememberRipple(color = Color.Transparent)
                        )
                )
            }
        }
    } else {
        icon = {
            Icon(
                painter = painterResource(id = titleWithIcon.second),
                contentDescription = titleWithIcon.first,
                tint = Color.Unspecified,
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
                    .padding(bottom = 5.dp)
                    .indication(
                        remember { MutableInteractionSource() },
                        rememberRipple(color = Color.Transparent)
                    )
            )
        }
    }

    ShamrockTab(
        selected = curSelected,
        onClick = {
            scope.launch {
                state.scrollToPage(index, 0f)
            }
        },
        text = text,
        icon = icon,
        selectedContentColor = Color.Transparent,
        unselectedContentColor = Color.Transparent,
        indication = null
    )
    lastSelectedState.value.let {
        var tmp = it
        if (isFirst) {
            tmp = it or defaultConst
        }
        lastSelectedState.value = if (curSelected) tmp or selectedConst else tmp xor selectedConst
    }
}

@Preview(showBackground = true)
@Composable
private fun MainPreview() {
    AppMainView()
}