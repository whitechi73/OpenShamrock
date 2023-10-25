package moe.fuqiuluo.shamrock.helper

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import moe.fuqiuluo.qqinterface.servlet.ark.ArkAppInfo
import moe.fuqiuluo.qqinterface.servlet.ark.ArkMsgSvc
import moe.fuqiuluo.shamrock.tools.GlobalClient
import moe.fuqiuluo.shamrock.tools.asInt
import moe.fuqiuluo.shamrock.tools.asJsonArray
import moe.fuqiuluo.shamrock.tools.asJsonObject
import moe.fuqiuluo.shamrock.tools.asString
import moe.fuqiuluo.shamrock.utils.MD5

internal object MusicHelper {
    suspend fun tryShare163MusicById(chatType: Int, peerId: Long, msgId: Long, id: String): Boolean {
        try {
            val respond = GlobalClient.get("https://music.163.com/api/song/detail/?id=$id&ids=[$id]")
            val songInfo = Json.parseToJsonElement(respond.bodyAsText()).asJsonObject["songs"].asJsonArray.first().asJsonObject
            val name = songInfo["name"].asString
            val title = songInfo["name"].asString
            val singerName = songInfo["artists"].asJsonArray.first().asJsonObject["name"].asString
            val previewUrl = songInfo["album"].asJsonObject["picUrl"].asString
            val playUrl = "https://music.163.com/song/media/outer/url?id=$id.mp3"
            val jumpUrl = "https://music.163.com/#/song?id=$id"
            ArkMsgSvc.tryShareMusic(
                chatType,
                peerId,
                msgId,
                ArkAppInfo.NeteaseMusic,
                title.ifBlank { name },
                singerName,
                jumpUrl,
                previewUrl,
                playUrl
            )
            return true
        } catch (e: Throwable) {
            LogCenter.log(e.stackTraceToString(), Level.ERROR)
        }
        return false
    }

    suspend fun tryShareQQMusicById(chatType: Int, peerId: Long, msgId: Long, id: String): Boolean {
        try {
            val respond = GlobalClient.get("https://u.y.qq.com/cgi-bin/musicu.fcg?format=json&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq.json&needNewCode=0&data={%22comm%22:{%22ct%22:24,%22cv%22:0},%22songinfo%22:{%22method%22:%22get_song_detail_yqq%22,%22param%22:{%22song_type%22:0,%22song_mid%22:%22%22,%22song_id%22:$id},%22module%22:%22music.pf_song_detail_svr%22}}")
            val songInfo = Json.parseToJsonElement(respond.bodyAsText()).asJsonObject["songinfo"].asJsonObject
            if (songInfo["code"].asInt != 0) {
                LogCenter.log("获取QQ音乐($id)的歌曲信息失败。")
                return false
            } else {
                val data = songInfo["data"].asJsonObject
                val trackInfo = data["track_info"].asJsonObject
                val mid = trackInfo["mid"].asString
                val previewMid = trackInfo["album"].asJsonObject["mid"].asString
                val name = trackInfo["name"].asString
                val title = trackInfo["title"].asString
                val singerName = trackInfo["singer"].asJsonArray.first().asJsonObject["name"].asString
                val code = MD5.getMd5Hex("${mid}q;z(&l~sdf2!nK".toByteArray()).substring(0 .. 4).uppercase()
                val playUrl = "http://c6.y.qq.com/rsc/fcgi-bin/fcg_pyq_play.fcg?songid=&songmid=$mid&songtype=1&fromtag=50&uin=&code=$code"
                val previewUrl = "http://y.gtimg.cn/music/photo_new/T002R180x180M000$previewMid.jpg"
                val jumpUrl = "https://i.y.qq.com/v8/playsong.html?platform=11&appshare=android_qq&appversion=10030010&hosteuin=oKnlNenz7i-s7c**&songmid=${mid}&type=0&appsongtype=1&_wv=1&source=qq&ADTAG=qfshare"
                ArkMsgSvc.tryShareMusic(
                    chatType,
                    peerId,
                    msgId,
                    ArkAppInfo.QQMusic,
                    title.ifBlank { name },
                    singerName,
                    jumpUrl,
                    previewUrl,
                    playUrl
                )
                return true
            }
        } catch (e: Throwable) {
            LogCenter.log(e.stackTraceToString(), Level.ERROR)
        }
        return false
    }
}