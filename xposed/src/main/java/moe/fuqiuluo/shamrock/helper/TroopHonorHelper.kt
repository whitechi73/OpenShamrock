package moe.fuqiuluo.shamrock.helper

import moe.fuqiuluo.shamrock.remote.service.data.GroupMemberHonor

object TroopHonorHelper {
    data class Honor(
        val id: Int,
        val name: String,
        val iconUrl: String,
        val priority: Int
    )

    private val honorList = listOf(
        Honor(1, "龙王", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150116_n4PxCiurbm.png", 1),
        Honor(2, "群聊之火", "https://qzonestyle.gtimg.cn/aoi/sola/20200217190136_92JEGFKC5k.png", 3),
        Honor(3, "群聊炽焰", "https://qzonestyle.gtimg.cn/aoi/sola/20200217190204_zgCTeSrMq1.png", 4),
        Honor(5, "冒尖小春笋", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150335_tUJCAtoKVP.png", 5),
        Honor(6, "快乐源泉", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150434_3tDmsJExCP.png", 7),
        Honor(7, "学术新星", "https://sola.gtimg.cn/aoi/sola/20200515140645_j0X6gbuHNP.png", 8),
        Honor(8, "顶尖学霸", "https://sola.gtimg.cn/aoi/sola/20200515140639_0CtWOpfVzK.png", 9),
        Honor(9, "至尊学神", "https://sola.gtimg.cn/aoi/sola/20200515140628_P8UEYBjMBT.png", 10),
        Honor(10, "一笔当先", "https://sola.gtimg.cn/aoi/sola/20200515140654_4r94tSCdaB.png", 11),
        Honor(11, "奋进小翠竹", "https://sola.gtimg.cn/aoi/sola/20200812151819_wbj6z2NGoB.png", 6),
        Honor(12, "氛围魔杖", "https://sola.gtimg.cn/aoi/sola/20200812151831_4ZJgQCaD1H.png", 2),
        Honor(13, "壕礼皇冠", "https://sola.gtimg.cn/aoi/sola/20200930154050_juZOAMg7pt.png", 12)
    )

    fun decodeHonor(userId: Long, honorId: Int, honorFlag: Byte): GroupMemberHonor? {
        val flag = calcHonorFlag(honorId, honorFlag)
        val honor = if ((honorId != 1 && honorId != 2 && honorId != 3) || flag != 1) {
            honorList.find { it.id == honorId }
        } else {
            val honor = honorList.find { it.id == honorId }
            honor?.let {
                val url = "https://static-res.qq.com/static-res/groupInteract/vas/a/${honorId}_1.png"
                it.copy(iconUrl = url)
            }
        }
        return honor?.let {
            GroupMemberHonor(
                userId,
                "",
                it.iconUrl,
                0,
                it.id,
                it.name
            )
        }
    }

    private fun calcHonorFlag(honorId: Int, honorFlag: Byte): Int {
        val flag = honorFlag.toInt()
        if (flag == 0) {
            return 0
        }
        return when {
            honorId == 1 -> flag
            honorId == 2 || honorId == 3 -> flag shr 2
            honorId != 4 -> 0
            else -> flag shr 4
        } and 3
    }
}