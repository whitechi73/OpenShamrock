package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildFeedSearchRes;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildMsgSearchRes;
import com.tencent.qqnt.kernel.nativeinterface.GProUnionResult;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProUnionResult implements IGProUnionResult {
    public final GProUnionResult mInfo;

    public GGProUnionResult(GProUnionResult gProUnionResult) {
        this.mInfo = gProUnionResult;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnionResult
    public byte[] getFeedCookie() {
        return this.mInfo.getFeedCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnionResult
    public boolean getFeedIsEnd() {
        return this.mInfo.getFeedIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnionResult
    public long getFeedTotal() {
        return this.mInfo.getFeedTotal();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnionResult
    public ArrayList<IGProGuildFeedSearchRes> getGuildFeeds() {
        ArrayList<GProGuildFeedSearchRes> guildFeeds = this.mInfo.getGuildFeeds();
        ArrayList<IGProGuildFeedSearchRes> arrayList = new ArrayList<>();
        Iterator<GProGuildFeedSearchRes> it = guildFeeds.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildFeedSearchRes(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnionResult
    public ArrayList<IGProGuildMsgSearchRes> getGuildMsgs() {
        ArrayList<GProGuildMsgSearchRes> guildMsgs = this.mInfo.getGuildMsgs();
        ArrayList<IGProGuildMsgSearchRes> arrayList = new ArrayList<>();
        Iterator<GProGuildMsgSearchRes> it = guildMsgs.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildMsgSearchRes(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnionResult
    public byte[] getMsgCookie() {
        return this.mInfo.getMsgCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnionResult
    public boolean getMsgIsEnd() {
        return this.mInfo.getMsgIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnionResult
    public long getMsgTotal() {
        return this.mInfo.getMsgTotal();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnionResult
    public String toString() {
        return this.mInfo.toString();
    }
}
