package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProLobbyMemberInfo;

/* loaded from: classes33.dex */
public class GGProLobbyMemberInfo implements IGProLobbyMemberInfo {
    public final GProLobbyMemberInfo mInfo;

    public GGProLobbyMemberInfo(GProLobbyMemberInfo gProLobbyMemberInfo) {
        this.mInfo = gProLobbyMemberInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyMemberInfo
    public String getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyMemberInfo
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyMemberInfo
    public boolean getPlaying() {
        return this.mInfo.getPlaying();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyMemberInfo
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyMemberInfo
    public long getUin() {
        return this.mInfo.getUin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyMemberInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
