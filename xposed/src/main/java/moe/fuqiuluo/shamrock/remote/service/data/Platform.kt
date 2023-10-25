package moe.fuqiuluo.shamrock.remote.service.data

internal enum class PlatformType {
    ANDROID_PAD,
    AOL_CHAOJIHUIYUAN,
    AOL_HUIYUAN,
    AOL_SQQ,
    CAR,
    HRTX_IPHONE,
    HRTX_PC,
    MC_3G,
    MISRO_MSG,
    MOBILE_ANDROID,
    MOBILE_ANDROID_NEW,
    MOBILE_HD,
    MOBILE_HD_NEW,
    MOBILE_IPAD,
    MOBILE_IPAD_NEW,
    MOBILE_IPHONE,
    MOBILE_OTHER,
    MOBILE_PC,
    MOBILE_WINPHONE_NEW,
    QQ_FORELDER,
    QQ_SERVICE,
    TV_QQ,
    WIN8,
    MAC,
    WINDOWS,
    PC_OR_MAC_OR_LINUX,
    WATCH,
    WINPHONE;

    companion object {
        fun valueOf(termType: Int): PlatformType {
            return when(termType) {
                68104 -> ANDROID_PAD
                73730 -> AOL_CHAOJIHUIYUAN
                73474 -> AOL_HUIYUAN
                69378 -> AOL_SQQ
                65806 -> CAR
                66566 -> HRTX_IPHONE
                66561 -> HRTX_PC
                65795 -> MC_3G
                69634 -> MISRO_MSG
                65799 -> MOBILE_ANDROID
                72450 -> MOBILE_ANDROID_NEW
                65805 -> MOBILE_HD
                71426 -> MOBILE_HD_NEW
                68361 -> MOBILE_IPAD
                72194 -> MOBILE_IPAD_NEW
                67586 -> MOBILE_IPHONE
                65794 -> MOBILE_OTHER
                65793 -> MOBILE_PC
                81154, 66818, 66831 -> MAC
                77313 -> WINDOWS
                83714 -> PC_OR_MAC_OR_LINUX
                72706 -> MOBILE_WINPHONE_NEW
                70922 -> QQ_FORELDER
                71170 -> QQ_SERVICE
                69130 -> TV_QQ
                69899 -> WIN8
                65804 -> WINPHONE
                78082, 78096, 75023 -> WATCH
                else -> MOBILE_OTHER
            }
        }
    }
}
