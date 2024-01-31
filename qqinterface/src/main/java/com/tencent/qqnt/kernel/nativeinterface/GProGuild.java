package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public final class GProGuild implements Serializable {
    GProCmdUinInfo cmdUinInfo;
    String errMsg;
    long guildId;
    GProGuildInfo guildInfo;
    int privateChannelMemberMaxNum;
    int result;
    long serialVersionUID;

    public GProGuild() {
        this.serialVersionUID = 1L;
        this.errMsg = "";
        //this.guildInfo = new GProGuildInfo();
        //this.cmdUinInfo = new GProCmdUinInfo();
    }

    public GProCmdUinInfo getCmdUinInfo() {
       return null;
    }

    public String getErrMsg() {
        return null;

    }

    public long getGuildId() {
        return 0;

    }

    public GProGuildInfo getGuildInfo() {
        return null;

    }

    public int getPrivateChannelMemberMaxNum() {
        return 0;

    }

    public int getResult() {
        return 0;

    }

    public void setCmdUinInfo(GProCmdUinInfo gProCmdUinInfo) {

    }

    public void setErrMsg(String str) {

    }

    public void setGuildId(long j) {

    }

    public void setGuildInfo(GProGuildInfo gProGuildInfo) {

    }

    public void setPrivateChannelMemberMaxNum(int i) {

    }

    public void setResult(int i) {

    }

    public String toString() {
        return "";
    }
}
