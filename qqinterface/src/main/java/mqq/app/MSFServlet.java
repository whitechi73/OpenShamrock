package mqq.app;

import android.content.Intent;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract class MSFServlet extends Servlet {
    public <T> T decodePacket(byte[] bArr, String str, T t) {
        return null;
    }

    public String[] getPreferSSOCommands() {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Intent onReceive(FromServiceMsg fromServiceMsg) {
        return null;
    }

    public abstract void onReceive(Intent intent, FromServiceMsg fromServiceMsg);

    public abstract void onSend(Intent intent, Packet packet);

    Intent removeRequest(int i2) {
        return null;
    }

    public void sendToMSF(Intent intent, ToServiceMsg toServiceMsg) {

    }

    @Override // mqq.app.Servlet
    public void service(Intent intent) {

    }
}
