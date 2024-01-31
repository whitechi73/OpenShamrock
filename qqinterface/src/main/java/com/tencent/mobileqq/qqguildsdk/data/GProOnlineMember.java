package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProOnlineMemberInfo;

import java.util.List;


public class GProOnlineMember implements IGProOnlineMember {
    private final String mGuildId;
    private final GProOnlineMemberInfo mOnlineMemberInfo;

    public GProOnlineMember(String str, GProOnlineMemberInfo gProOnlineMemberInfo) {
        this.mGuildId = str;
        this.mOnlineMemberInfo = gProOnlineMemberInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProOnlineMember
    public String getGuildId() {
        return this.mGuildId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProOnlineMember
    public String getHotIcon() {
        return null;
        //return this.mOnlineMemberInfo.getHotIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProOnlineMember
    public String getMemberCnt() {
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProOnlineMember
    public String getMemberTitle() {
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProOnlineMember
    public List<String> getOnlineMemberAvatars() {
        return this.mOnlineMemberInfo.getOnlineMemberAvatars();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProOnlineMember
    public String getOnlineMemberCnt() {
        return this.mOnlineMemberInfo.getOnlineMemberCnt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProOnlineMember
    public String toString() {
        return "GProOnlineMember{mGuildId='" + this.mGuildId + "', mOnlineMemberInfo=" + this.mOnlineMemberInfo + '}';
    }
}
