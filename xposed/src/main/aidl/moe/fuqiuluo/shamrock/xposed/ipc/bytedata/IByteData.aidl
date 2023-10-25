// IByteData.aidl
package moe.fuqiuluo.shamrock.xposed.ipc.bytedata;

import moe.fuqiuluo.shamrock.xposed.ipc.bytedata.IByteDataSign;

interface IByteData {
    IByteDataSign sign(String uin, String data, in byte[] salt);
}