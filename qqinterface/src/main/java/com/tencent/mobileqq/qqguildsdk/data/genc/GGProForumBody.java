package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProForumBody;
import com.tencent.qqnt.kernel.nativeinterface.GProForumChannel;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProForumBody implements IGProForumBody {
    public final GProForumBody mInfo;

    public GGProForumBody(GProForumBody gProForumBody) {
        this.mInfo = gProForumBody;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumBody
    public int getEveryHours() {
        return this.mInfo.getEveryHours();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumBody
    public ArrayList<IGProForumChannel> getForumChannel() {
        ArrayList<GProForumChannel> forumChannel = this.mInfo.getForumChannel();
        ArrayList<IGProForumChannel> arrayList = new ArrayList<>();
        Iterator<GProForumChannel> it = forumChannel.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProForumChannel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumBody
    public String getRequestId() {
        return this.mInfo.getRequestId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumBody
    public long getUpdateTime() {
        return this.mInfo.getUpdateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumBody
    public String toString() {
        return this.mInfo.toString();
    }
}
