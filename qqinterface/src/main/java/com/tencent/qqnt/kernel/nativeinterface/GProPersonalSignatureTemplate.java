package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProPersonalSignatureTemplate {
    String avatarUrl;
    String sampleText;

    public GProPersonalSignatureTemplate() {
        this.avatarUrl = "";
        this.sampleText = "";
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getSampleText() {
        return this.sampleText;
    }

    public String toString() {
        return "GProPersonalSignatureTemplate{avatarUrl=" + this.avatarUrl + ",sampleText=" + this.sampleText + ",}";
    }

    public GProPersonalSignatureTemplate(String str, String str2) {
        this.avatarUrl = "";
        this.sampleText = "";
        this.avatarUrl = str;
        this.sampleText = str2;
    }
}
