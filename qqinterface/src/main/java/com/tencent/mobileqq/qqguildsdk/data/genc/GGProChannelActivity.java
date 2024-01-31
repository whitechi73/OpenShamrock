package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProChannelActivity;

public  class GGProChannelActivity implements IGProChannelActivity {
    public final GProChannelActivity mInfo;

    public GGProChannelActivity(GProChannelActivity gProChannelActivity) {
        this.mInfo = gProChannelActivity;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelActivity
    public String getActivityId() {
        return this.mInfo.getActivityId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelActivity
    public String getImageUrl() {
        return this.mInfo.getImageUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelActivity
    public String getJumpUrl() {
        return this.mInfo.getJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelActivity
    public String toString() {
        return this.mInfo.toString();
    }
}
