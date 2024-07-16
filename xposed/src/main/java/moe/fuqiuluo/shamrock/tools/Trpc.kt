package moe.fuqiuluo.shamrock.tools

import com.tencent.mobileqq.pb.MessageMicro
import com.tencent.qphone.base.remote.FromServiceMsg
import moe.fuqiuluo.shamrock.helper.Level
import moe.fuqiuluo.shamrock.helper.LogCenter
import moe.fuqiuluo.shamrock.utils.DeflateTools
import moe.fuqiuluo.symbols.Protobuf
import moe.fuqiuluo.symbols.decodeProtobuf
import protobuf.oidb.TrpcOidb
import tencent.im.oidb.oidb_sso

fun FromServiceMsg.decodeToOidb(): oidb_sso.OIDBSSOPkg {
    return kotlin.runCatching {
        oidb_sso.OIDBSSOPkg().mergeFrom(wupBuffer.slice(4).let {
            if (it[0] == 0x78.toByte()) DeflateTools.uncompress(it) else it
        })
    }.getOrElse {
        oidb_sso.OIDBSSOPkg().mergeFrom(wupBuffer.let {
            if (it[0] == 0x78.toByte()) DeflateTools.uncompress(it) else it
        })
    }
}

fun FromServiceMsg.decodeToTrpcOidb(): TrpcOidb {
    return kotlin.runCatching {
        wupBuffer.slice(4).let {
            if (it[0] == 0x78.toByte()) DeflateTools.uncompress(it) else it
        }.decodeProtobuf<TrpcOidb>()
    }.getOrElse {
        wupBuffer.let {
            if (it[0] == 0x78.toByte()) DeflateTools.uncompress(it) else it
        }.decodeProtobuf<TrpcOidb>()
    }
}

inline fun <reified T: Protobuf<T>> FromServiceMsg.decodeToObject(): T {
    return kotlin.runCatching {
        wupBuffer.slice(4).let {
            if (it[0] == 0x78.toByte()) DeflateTools.uncompress(it) else it
        }.decodeProtobuf<T>()
    }.getOrElse {
        wupBuffer.let {
            if (it[0] == 0x78.toByte()) DeflateTools.uncompress(it) else it
        }.decodeProtobuf<T>()
    }
}

fun <T: MessageMicro<T>> FromServiceMsg.decodeToObject(self: T): T {
    return kotlin.runCatching {
        self.mergeFrom(wupBuffer.slice(4).let {
            if (it[0] == 0x78.toByte()) DeflateTools.uncompress(it) else it
        })
    }.getOrElse {
        self.mergeFrom(wupBuffer.let {
            if (it[0] == 0x78.toByte()) DeflateTools.uncompress(it) else it
        })
    }
}