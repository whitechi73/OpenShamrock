package com.tencent.mobileqq.emoticon;

import android.text.TextUtils;

public class QQSysFaceUtil {

    public static int convertToServer(int localId) {
        return 0;
    }

    public static boolean isValidFaceId(int locslId) {
        return locslId != 255 && locslId != 511 && locslId != 250 && locslId >= 0 && locslId <= 65535;
    }

    public static int convertToLocal(int serverId) {
        return 0;
    }

    public static String getFaceDescription(int localId) {
        return "";
    }

    public static String getPrueFaceDescription(String str) {
        if (str == null) {
            return null;
        }
        return str.startsWith("/") ? str.substring(1) : str;
    }
}
