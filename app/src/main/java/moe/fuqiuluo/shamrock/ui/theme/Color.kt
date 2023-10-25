@file:Suppress("PropertyName")
package moe.fuqiuluo.shamrock.ui.theme

import androidx.compose.ui.graphics.Color

interface ThemeColor {
    companion object {
        val ColorTabSelected = Color(0xFF5A5A5A)
        val ColorTabUnSelected = Color(0xFF6f6f6f)

        val ColorDarkTabSelected = Color(0xFFc2c2c2)
        val ColorDarkTabUnSelected = Color(0xFF6f6f6f)

        val ColorLightToolbarText = Color(0xFF6f6f6f)
        val ColorDarkToolbarText = Color(0xFFc2c2c2)

        val ColorLightStatusCardStart = Color(0xFF03AA9A)
        val ColorLightStatusCardEnd = Color(0xFF4DB8AD)

        val ColorDarkStatusCardStart = Color(0xFF02685E)
        val ColorDarkStatusCardEnd = Color(0xFF2B6963)

        val ColorNoticeBox = Color(0xFFf4f4f4)
        val ColorNoticeBoxText = Color(0xff6c6c6c)
        val ColorNoticeBoxIcon = Color(0xFF838383)

        val ColorDarkNoticeBox = Color(0xFF272727)
        val ColorDarkNoticeBoxText = Color(0xFFB8B8B8)
        val ColorDarkNoticeBoxIcon = Color(0xFFB8B8B8)

        val ColorAccountCardStart = Color(0xFF2196F3)
        val ColorAccountCardEnd = Color(0xFF00BCD4)
    }

    val StatusBar: Color // 状态栏颜色
    val Toolbar: Color // Toolbar颜色
    val ToolbarText: Color // Toolbar文字颜色
    val TabSelected: Color // Tab选中颜色
    val TabItem: Color // Tab图标/文字颜色

    val StatusCardStart: Color // 状态卡片渐变色开始
    val StatusCardEnd: Color // 状态卡片渐变色结束

    val NoticeBox: Color // 通知BOX颜色
    val NoticeBoxText: Color // 通知BOX文字颜色
    val NoticeBoxIcon: Color // 通知BOX图标颜色

    val DataBoxTextLight: Color // 数据BOX文字颜色
    val DataBoxTextDark: Color

    val Divider: Color // 分割线颜色
}

object LightColor: ThemeColor {
    override val StatusBar: Color = Color.White
    override val Toolbar: Color = Color.White
    override val ToolbarText = ThemeColor.ColorLightToolbarText
    override val TabSelected = ThemeColor.ColorTabSelected
    override val TabItem: Color = ThemeColor.ColorLightToolbarText

    override val StatusCardStart = ThemeColor.ColorLightStatusCardStart
    override val StatusCardEnd = ThemeColor.ColorLightStatusCardEnd

    override val NoticeBox = ThemeColor.ColorNoticeBox
    override val NoticeBoxText = ThemeColor.ColorNoticeBoxText
    override val NoticeBoxIcon = ThemeColor.ColorNoticeBoxIcon

    override val DataBoxTextLight = ThemeColor.ColorTabSelected
    override val DataBoxTextDark = ThemeColor.ColorTabUnSelected

    override val Divider = ThemeColor.ColorTabUnSelected
}

object DarkColor: ThemeColor {
    override val StatusBar: Color = Color.Black
    override val Toolbar: Color = Color.Black
    override val ToolbarText = ThemeColor.ColorDarkToolbarText
    override val TabSelected = ThemeColor.ColorTabSelected
    override val TabItem: Color = ThemeColor.ColorDarkToolbarText

    override val StatusCardStart = ThemeColor.ColorDarkStatusCardStart
    override val StatusCardEnd = ThemeColor.ColorDarkStatusCardEnd

    override val NoticeBox = ThemeColor.ColorDarkNoticeBox
    override val NoticeBoxText = ThemeColor.ColorDarkNoticeBoxText
    override val NoticeBoxIcon = ThemeColor.ColorDarkNoticeBoxIcon

    override val DataBoxTextLight = ThemeColor.ColorDarkTabSelected
    override val DataBoxTextDark = ThemeColor.ColorDarkTabUnSelected

    override val Divider = ThemeColor.ColorDarkTabUnSelected
}






