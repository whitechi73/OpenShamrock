package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProAVChannelConfig;
import com.tencent.qqnt.kernel.nativeinterface.GProBusinessNode;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildThemeInfo;

import java.util.ArrayList;
import java.util.Iterator;


public class GGProAVChannelConfig implements IGProAVChannelConfig {
    public final GProAVChannelConfig mInfo;

    public GGProAVChannelConfig(GProAVChannelConfig gProAVChannelConfig) {
        this.mInfo = gProAVChannelConfig;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig
    public ArrayList<IGProBusinessNode> getBusinessList() {
        ArrayList<GProBusinessNode> businessList = this.mInfo.getBusinessList();
        ArrayList<IGProBusinessNode> arrayList = new ArrayList<>();
        Iterator<GProBusinessNode> it = businessList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBusinessNode(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig
    public long getChannelDataVersion() {
        return this.mInfo.getChannelDataVersion();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig
    public long getOriginatorTinyId() {
        return this.mInfo.getOriginatorTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig
    public IGProGuildThemeInfo getThemeInfo() {
        return new GGProGuildThemeInfo(this.mInfo.getThemeInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig
    public ArrayList<IGProGuildThemeInfo> getThemeList() {
        ArrayList<GProGuildThemeInfo> themeList = this.mInfo.getThemeList();
        ArrayList<IGProGuildThemeInfo> arrayList = new ArrayList<>();
        Iterator<GProGuildThemeInfo> it = themeList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildThemeInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig
    public IGProChannelToolBar getToolBar() {
        return new GGProChannelToolBar(this.mInfo.getToolBar());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig
    public String toString() {
        return this.mInfo.toString();
    }
}
