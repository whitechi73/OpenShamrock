package com.tencent.mobileqq.fe;

import android.content.Context;

import com.tencent.mobileqq.sign.QQSecuritySign;
import java.util.List;

public class FEKit {
    public static FEKit getInstance() {
        return null;
    }

    public void init(final Context context, String uin, String guid, String o3did, String q36, String qua) {

    }

    public QQSecuritySign.SignResult getSign(String cmd, byte[] buffer, int seq, String uin) {
        return null;
    }

    public List<String> getCmdWhiteList() {
        return null;
    }
}
