package mqq.app;

import android.text.TextUtils;

import com.qq.jce.JceStruct;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.ToServiceMsg;

import java.util.HashMap;

public class Packet {
    private String account;
    public boolean autoResend;
    private UniPacket client;
    private boolean noResponse;
    private byte[] sendData;
    private String ssoCommand;
    private String traceInfo;
    private HashMap<String, String> transInfo;
    private long timeout = 30000;
    public boolean quickSendEnable = false;
    public int quickSendStrategy = 0;
    private HashMap<String, Object> attributes = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Packet(String str) {
        this.account = "0";
        UniPacket uniPacket = new UniPacket(true);
        this.client = uniPacket;
        uniPacket.setEncodeName("UTF-8");
        if (str != null) {
            this.account = str;
        }
    }

    public static <T> T decodePacket(byte[] bArr, String str, T t) {
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setEncodeName("utf-8");
        uniPacket.decode(bArr);
        return (T) uniPacket.getByClass(str, t);
    }

    public Object addAttribute(String str, Object obj) {
        return this.attributes.put(str, obj);
    }

    public void addRequestPacket(String str, JceStruct jceStruct) {
        this.client.put(str, jceStruct);
    }

    public HashMap<String, Object> getAttributes() {
        return this.attributes;
    }

    public String getFuncName() {
        return this.client.getServantName();
    }

    public String getServantName() {
        return this.client.getServantName();
    }

    public void putSendData(byte[] bArr) {
        this.sendData = bArr;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAttributes(HashMap<String, Object> hashMap) {
        this.attributes = hashMap;
    }

    public void setFuncName(String str) {
        this.client.setFuncName(str);
    }

    public void setNoResponse() {
        this.noResponse = true;
    }

    public void setQuickSend(boolean z, int i2) {
        this.quickSendEnable = z;
        this.quickSendStrategy = i2;
    }

    public void setSSOCommand(String str) {
        this.ssoCommand = str;
    }

    public void setServantName(String str) {
        this.client.setServantName(str);
    }

    public void setTimeout(long j2) {
        this.timeout = j2;
    }

    public void setTraceInfo(String str) {
        this.traceInfo = str;
    }

    public void setTransInfo(HashMap<String, String> hashMap) {
        this.transInfo = hashMap;
    }

    public ToServiceMsg toMsg() {
        return null;
    }
}
