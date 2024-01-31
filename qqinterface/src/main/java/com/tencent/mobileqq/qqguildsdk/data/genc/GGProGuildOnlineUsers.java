package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildOnlineUsers;
import com.tencent.qqnt.kernel.nativeinterface.GProUser;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGuildOnlineUsers implements IGProGuildOnlineUsers {
    public final GProGuildOnlineUsers mInfo;

    public GGProGuildOnlineUsers(GProGuildOnlineUsers gProGuildOnlineUsers) {
        this.mInfo = gProGuildOnlineUsers;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineUsers
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineUsers
    public int getChannelType() {
        return this.mInfo.getChannelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineUsers
    public String getTotalOnline() {
        return this.mInfo.getTotalOnline();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineUsers
    public ArrayList<IGProUserInfo> getUsers() {
        ArrayList<GProUser> users = this.mInfo.getUsers();
        ArrayList<IGProUserInfo> arrayList = new ArrayList<>();
        Iterator<GProUser> it = users.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProUserInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineUsers
    public String toString() {
        return this.mInfo.toString();
    }
}
