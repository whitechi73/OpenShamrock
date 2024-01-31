package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProChannelToolBar;

public  class GGProChannelToolBar implements IGProChannelToolBar {
    public final GProChannelToolBar mInfo;

    public GGProChannelToolBar(GProChannelToolBar gProChannelToolBar) {
        this.mInfo = gProChannelToolBar;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelToolBar
    public String getToolbarListStr() {
        return this.mInfo.getToolbarListStr();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelToolBar
    public String toString() {
        return this.mInfo.toString();
    }
}
