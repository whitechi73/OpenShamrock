package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProPersonalSignatureTemplate;


public class GGProPersonalSignatureTemplate implements IGProPersonalSignatureTemplate {
    public final GProPersonalSignatureTemplate mInfo;

    public GGProPersonalSignatureTemplate(GProPersonalSignatureTemplate gProPersonalSignatureTemplate) {
        this.mInfo = gProPersonalSignatureTemplate;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPersonalSignatureTemplate
    public String getAvatarUrl() {
        return this.mInfo.getAvatarUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPersonalSignatureTemplate
    public String getSampleText() {
        return this.mInfo.getSampleText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPersonalSignatureTemplate
    public String toString() {
        return this.mInfo.toString();
    }
}
