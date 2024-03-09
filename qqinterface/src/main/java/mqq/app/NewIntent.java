package mqq.app;

import android.content.Context;
import android.content.Intent;

import com.tencent.mobileqq.app.BusinessObserver;

public class NewIntent extends Intent {
    public boolean runNow;

    public NewIntent(Context context, Class<? extends Servlet> cls) {
        super(context, cls);
    }

    public BusinessObserver getObserver() {
        return null;
    }

    public boolean isWithouLogin() {
        return false;
    }

    public void setObserver(BusinessObserver businessObserver) {

    }

    public void setWithouLogin(boolean z) {
    }
}
