package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProVoicePresence0x11bc;

public  class GGProVoicePresence0x11bc implements IGProVoicePresence0x11bc {
    public final GProVoicePresence0x11bc mInfo;

    public GGProVoicePresence0x11bc(GProVoicePresence0x11bc gProVoicePresence0x11bc) {
        this.mInfo = gProVoicePresence0x11bc;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoicePresence0x11bc
    public String getCoverUrl() {
        return this.mInfo.getCoverUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoicePresence0x11bc
    public String toString() {
        return this.mInfo.toString();
    }
}
