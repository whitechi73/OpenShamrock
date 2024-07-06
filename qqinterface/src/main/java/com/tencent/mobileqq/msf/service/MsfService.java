package com.tencent.mobileqq.msf.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.tencent.mobileqq.msf.core.MsfCore;

public class MsfService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static MsfCore getCore() {
        return null;
    }

}
