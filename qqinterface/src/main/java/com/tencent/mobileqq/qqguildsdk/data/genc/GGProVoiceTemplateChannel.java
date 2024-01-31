package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProMemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProVoiceTemplateChannel;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProVoiceTemplateChannel implements IGProVoiceTemplateChannel {
    public final GProVoiceTemplateChannel mInfo;

    public GGProVoiceTemplateChannel(GProVoiceTemplateChannel gProVoiceTemplateChannel) {
        this.mInfo = gProVoiceTemplateChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceTemplateChannel
    public IGProRecommendCoverInfo getCover() {
        return new GGProRecommendCoverInfo(this.mInfo.getCover());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceTemplateChannel
    public int getCurrentNum() {
        return this.mInfo.getCurrentNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceTemplateChannel
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceTemplateChannel
    public int getMaxNum() {
        return this.mInfo.getMaxNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceTemplateChannel
    public ArrayList<IGProMemberInfo> getMembers() {
        ArrayList<GProMemberInfo> members = this.mInfo.getMembers();
        ArrayList<IGProMemberInfo> arrayList = new ArrayList<>();
        Iterator<GProMemberInfo> it = members.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMemberInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceTemplateChannel
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceTemplateChannel
    public String getPlayDesc() {
        return this.mInfo.getPlayDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceTemplateChannel
    public int getStatus() {
        return this.mInfo.getStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceTemplateChannel
    public String getStatusDesc() {
        return this.mInfo.getStatusDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceTemplateChannel
    public String getStatusIcon() {
        return this.mInfo.getStatusIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceTemplateChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
