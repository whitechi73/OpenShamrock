package moe.fuqiuluo.shamrock.xposed.ipc.bytedata

import android.os.Parcel
import android.os.Parcelable
import com.tencent.secprotocol.ByteData
import moe.fuqiuluo.shamrock.xposed.ipc.bytedata.IByteData

data class IByteDataSign(
    val sign: ByteArray?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createByteArray()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByteArray(sign)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IByteDataSign> {
        override fun createFromParcel(parcel: Parcel): IByteDataSign {
            return IByteDataSign(parcel)
        }

        override fun newArray(size: Int): Array<IByteDataSign?> {
            return arrayOfNulls(size)
        }
    }
}

internal object ByteDataCreator: IByteData.Stub() {
    override fun sign(uin: String?, data: String?, salt: ByteArray?): IByteDataSign {
        val byteData = ByteData.getInstance()
        byteData.setDataEx(uin, data)
        return IByteDataSign(byteData.getSign(uin, data, salt))
    }

}