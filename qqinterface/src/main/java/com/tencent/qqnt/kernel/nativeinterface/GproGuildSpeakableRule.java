package com.tencent.qqnt.kernel.nativeinterface;


public  final class GproGuildSpeakableRule {
    Boolean isProhibiteLink;
    Boolean isProhibiteQrCodePicture;
    Boolean isProhibiteRedEnvelope;

    public GproGuildSpeakableRule() {
    }

    public Boolean getIsProhibiteLink() {
        return this.isProhibiteLink;
    }

    public Boolean getIsProhibiteQrCodePicture() {
        return this.isProhibiteQrCodePicture;
    }

    public Boolean getIsProhibiteRedEnvelope() {
        return this.isProhibiteRedEnvelope;
    }

    public String toString() {
        return "GproGuildSpeakableRule{isProhibiteRedEnvelope=" + this.isProhibiteRedEnvelope + ",isProhibiteLink=" + this.isProhibiteLink + ",isProhibiteQrCodePicture=" + this.isProhibiteQrCodePicture + ",}";
    }

    public GproGuildSpeakableRule(Boolean bool, Boolean bool2, Boolean bool3) {
        this.isProhibiteRedEnvelope = bool;
        this.isProhibiteLink = bool2;
        this.isProhibiteQrCodePicture = bool3;
    }
}
