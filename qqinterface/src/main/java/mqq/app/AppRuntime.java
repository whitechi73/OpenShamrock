package mqq.app;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.tencent.qphone.base.remote.ToServiceMsg;

import mqq.app.api.IRuntimeService;

public abstract class AppRuntime {
    public static final int ACCOUNT_MANAGER = 0;
    public static final int WTLOGIN_MANAGER = 1;
    public static final int TICKET_MANAGER = 2;
    public static final int SERVER_CONFIG_MANAGER = 3;
    public static final int END_UN_LOGIN_MANAGER = 4;

    public enum Status {
        online(11),
        offline(21),
        away(31),
        invisiable(41),
        busy(50),
        qme(60),
        dnd(70),
        receiveofflinemsg(95);

        private final int value;

        Status(int i2) {
            this.value = i2;
        }

        public static Status build(int i2) {
            if (i2 != 11) {
                if (i2 != 21) {
                    if (i2 != 31) {
                        if (i2 != 41) {
                            if (i2 != 50) {
                                if (i2 != 60) {
                                    if (i2 != 70) {
                                        if (i2 != 95) {
                                            return null;
                                        }
                                        return receiveofflinemsg;
                                    }
                                    return dnd;
                                }
                                return qme;
                            }
                            return busy;
                        }
                        return invisiable;
                    }
                    return away;
                }
                return offline;
            }
            return online;
        }

        public int getValue() {
            return this.value;
        }
    }

    public <T extends IRuntimeService> T getRuntimeService(Class<T> cls, String namespace) {
        throw new UnsupportedOperationException();
    }

    public <T extends IRuntimeService> T getRuntimeServiceIPCSync(@NonNull Class<T> cls, String str) {
        throw new UnsupportedOperationException();
    }
    public String getAccount() {
        return "";
    }

    public abstract String getCurrentAccountUin();
    public String getCurrentUin() {
        return !"0".equals(getCurrentAccountUin()) ? getCurrentAccountUin() : "";
    }

    public long getLongAccountUin() {
        return 0;
    }

    public boolean isLogin() {
        return false;
    }

    public ServletContainer getServletContainer() {
        return null;
    }

    public void onCreate(Bundle bundle) {

    }
}
