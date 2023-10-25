package com.tencent.mobileqq.app;

import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

import java.util.Set;

public abstract class BaseBusinessHandler extends OidbWrapper {

    @Override
    public ToServiceMsg createToServiceMsg(String cmd) {
        return null;
    }

    public final <T> T decodePacket(byte[] data, String name, T obj) {
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(data);
            return (T) uniPacket.getByClass(name, obj);
        } catch (Exception unused) {
            return null;
        }
    }

    protected abstract Set<String> getCommandList();

    protected abstract Set<String> getPushCommandList();

    protected abstract Set<String> getPushPBCommandList();

    public abstract void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj);

    public void send(ToServiceMsg toServiceMsg) {
    }

    public void sendPbReq(ToServiceMsg toServiceMsg) {
    }

    public String getCurrentAccountUin() {
        return "";
    }
}
