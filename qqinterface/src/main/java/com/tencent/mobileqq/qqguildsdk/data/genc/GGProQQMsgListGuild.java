package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProQQMsgListGuild;

import java.io.Serializable;


public class GGProQQMsgListGuild implements Serializable {
    public final GProQQMsgListGuild mInfo;

    public GGProQQMsgListGuild(GProQQMsgListGuild gProQQMsgListGuild) {
        this.mInfo = gProQQMsgListGuild;
    }

    public long getAvatarSeq() {
        return this.mInfo.getAvatarSeq();
    }

    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    public long getTopTimestamp() {
        return this.mInfo.getTopTimestamp();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
