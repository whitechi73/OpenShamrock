package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProSimpleProfile {
    String avatarMeta;
    String avatarPendant;
    ArrayList<Long> categoryIds;
    GProClientIdentity clientIdentityBytes;
    String displayName;
    long guildId;
    long levelRoleId;
    String memberName;
    String nickName;
    GProMedal personalMedal;
    long roleId;
    long tinyId;

    public GProSimpleProfile() {
        this.nickName = "";
        this.memberName = "";
        this.displayName = "";
        this.avatarMeta = "";
        this.clientIdentityBytes = new GProClientIdentity();
        this.avatarPendant = "";
        this.personalMedal = new GProMedal();
        this.categoryIds = new ArrayList<>();
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getAvatarPendant() {
        return this.avatarPendant;
    }

    public ArrayList<Long> getCategoryIds() {
        return this.categoryIds;
    }

    public GProClientIdentity getClientIdentityBytes() {
        return this.clientIdentityBytes;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getLevelRoleId() {
        return this.levelRoleId;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public GProMedal getPersonalMedal() {
        return this.personalMedal;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public void setAvatarMeta(String str) {
        this.avatarMeta = str;
    }

    public void setAvatarPendant(String str) {
        this.avatarPendant = str;
    }

    public void setCategoryIds(ArrayList<Long> arrayList) {
        this.categoryIds = arrayList;
    }

    public void setClientIdentityBytes(GProClientIdentity gProClientIdentity) {
        this.clientIdentityBytes = gProClientIdentity;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setGuildId(long j2) {
        this.guildId = j2;
    }

    public void setLevelRoleId(long j2) {
        this.levelRoleId = j2;
    }

    public void setMemberName(String str) {
        this.memberName = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPersonalMedal(GProMedal gProMedal) {
        this.personalMedal = gProMedal;
    }

    public void setRoleId(long j2) {
        this.roleId = j2;
    }

    public void setTinyId(long j2) {
        this.tinyId = j2;
    }

    public String toString() {
        return "GProSimpleProfile{guildId=" + this.guildId + ",tinyId=" + this.tinyId + ",roleId=" + this.roleId + ",levelRoleId=" + this.levelRoleId + ",nickName=" + this.nickName + ",memberName=" + this.memberName + ",displayName=" + this.displayName + ",avatarMeta=" + this.avatarMeta + ",clientIdentityBytes=" + this.clientIdentityBytes + ",avatarPendant=" + this.avatarPendant + ",personalMedal=" + this.personalMedal + ",categoryIds=" + this.categoryIds + ",}";
    }

    public GProSimpleProfile(long j2, long j3, long j4, long j5, String str, String str2, String str3, String str4, GProClientIdentity gProClientIdentity, String str5, GProMedal gProMedal, ArrayList<Long> arrayList) {
        this.nickName = "";
        this.memberName = "";
        this.displayName = "";
        this.avatarMeta = "";
        this.clientIdentityBytes = new GProClientIdentity();
        this.avatarPendant = "";
        this.personalMedal = new GProMedal();
        this.categoryIds = new ArrayList<>();
        this.guildId = j2;
        this.tinyId = j3;
        this.roleId = j4;
        this.levelRoleId = j5;
        this.nickName = str;
        this.memberName = str2;
        this.displayName = str3;
        this.avatarMeta = str4;
        this.clientIdentityBytes = gProClientIdentity;
        this.avatarPendant = str5;
        this.personalMedal = gProMedal;
        this.categoryIds = arrayList;
    }
}
