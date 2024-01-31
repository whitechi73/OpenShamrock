package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProQuickJoinItem;

import java.util.ArrayList;

public  class GGProQuickJoinItem implements IGProQuickJoinItem {
    public final GProQuickJoinItem mInfo;

    public GGProQuickJoinItem(GProQuickJoinItem gProQuickJoinItem) {
        this.mInfo = gProQuickJoinItem;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinItem
    public String getCoverUrl() {
        return this.mInfo.getCoverUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinItem
    public ArrayList<String> getMembersAvatar() {
        return this.mInfo.getMembersAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinItem
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinItem
    public String getOnlineNumTag() {
        return this.mInfo.getOnlineNumTag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinItem
    public int getOrder() {
        return this.mInfo.getOrder();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinItem
    public int getStatusTag() {
        return this.mInfo.getStatusTag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinItem
    public int getVoiceType() {
        return this.mInfo.getVoiceType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinItem
    public String toString() {
        return this.mInfo.toString();
    }
}
