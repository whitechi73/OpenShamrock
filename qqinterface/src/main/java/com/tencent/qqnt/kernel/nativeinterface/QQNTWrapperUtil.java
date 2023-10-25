package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

public interface QQNTWrapperUtil {
    final class CppProxy implements QQNTWrapperUtil {
        //public static native ArrayList<RecentContactInfo> DecoderRecentInfo(byte[] bArr);

        public static native ThumbResult calcThumbSize(int i2, int i3, ThumbOpt thumbOpt);

        public static native boolean copyFile(String str, String str2);

        //public static native UnregisterRes decodeOffLine(byte[] bArr);

        public static native void emptyWorkingSet(int i2);

        //public static native byte[] encodeOffLine(UnregisterInfo unregisterInfo);

        public static native boolean fileIsExist(String str);

        public static native String fullWordToHalfWord(String str);

        public static native byte[] genFileMd5Buf(String str);

        public static native String genFileMd5Hex(String str);

        public static native HashMap<Integer, String> genFileShaAndMd5Hex(String str, int i2);

        public static native byte[] genFileShaBuf(String str);

        public static native String genFileShaHex(String str);

        public static native long getFileSize(String str);

        public static native String getNTUserDataInfoConfig();

        //public static native OidbRspInfo getOidbRspInfo(byte[] bArr);

        public static native ArrayList<ArrayList<String>> getPinyin(String str, boolean z);

        public static native String getSoBuildInfo();

        public static native byte[] getSsoBufferOfOidbReq(int i2, int i3, byte[] bArr);

        public static native String getSsoCmdOfOidbReq(int i2, int i3);

        public static native boolean makeDirByPath(String str);

        public static native boolean matchInPinyin(ArrayList<ArrayList<String>> arrayList, String str);

        private native void nativeDestroy(long j2);

        public static native int runProcess(String str, boolean z);
    }
}
