package com.tencent.qqnt.kernel.nativeinterface;


public final class VASMsgAvatarPendant {
    Integer avatarId;
    Integer pendantDiyInfoId;
    Long pendantId;

    public VASMsgAvatarPendant() {
    }

    public Integer getAvatarId() {
        return this.avatarId;
    }

    public Integer getPendantDiyInfoId() {
        return this.pendantDiyInfoId;
    }

    public Long getPendantId() {
        return this.pendantId;
    }

    public String toString() {
        return "VASMsgAvatarPendant{avatarId=" + this.avatarId + ",pendantId=" + this.pendantId + ",pendantDiyInfoId=" + this.pendantDiyInfoId + ",}";
    }

    public VASMsgAvatarPendant(Integer num, Long l2, Integer num2) {
        this.avatarId = num;
        this.pendantId = l2;
        this.pendantDiyInfoId = num2;
    }
}
