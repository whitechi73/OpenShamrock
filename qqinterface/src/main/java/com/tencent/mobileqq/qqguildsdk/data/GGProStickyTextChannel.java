package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProMsgSummary;
import com.tencent.qqnt.kernel.nativeinterface.GProStickyTextChannel;
import com.tencent.qqnt.kernel.nativeinterface.GProUser;
import com.tencent.qqnt.kernel.nativeinterface.MsgAbstract;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProStickyTextChannel implements IGProStickyTextChannel {
    public final GProStickyTextChannel mInfo;

    public GGProStickyTextChannel(GProStickyTextChannel gProStickyTextChannel) {
        this.mInfo = gProStickyTextChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyTextChannel
    public String getActiveMemberCount() {
        return this.mInfo.getActiveMemberCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyTextChannel
    public ArrayList<IGProUserInfo> getActiveMemberList() {
        ArrayList<GProUser> activeMemberList = this.mInfo.getActiveMemberList();
        ArrayList<IGProUserInfo> arrayList = new ArrayList<>();
        Iterator<GProUser> it = activeMemberList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProUserInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyTextChannel
    public ArrayList<IGProMsgSummary> getMsgList() {
        ArrayList<GProMsgSummary> msgList = this.mInfo.getMsgList();
        ArrayList<IGProMsgSummary> arrayList = new ArrayList<>();
        Iterator<GProMsgSummary> it = msgList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMsgSummary(it.next()));
        }
        return arrayList;
    }
}
