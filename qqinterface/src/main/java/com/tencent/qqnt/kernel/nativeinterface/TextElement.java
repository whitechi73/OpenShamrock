package com.tencent.qqnt.kernel.nativeinterface;

public final class TextElement implements IKernelModel {
    Long atChannelId;
    String atNtUid;
    Integer atRoleColor;
    Long atRoleId;
    String atRoleName;
    long atTinyId;
    int atType;
    long atUid;
    String content;
    LinkInfo linkInfo;
    Integer needNotify;
    Integer subElementType;

    public TextElement() {
        this.content = "";
    }

    public Long getAtChannelId() {
        return this.atChannelId;
    }

    public String getAtNtUid() {
        return this.atNtUid;
    }

    public Integer getAtRoleColor() {
        return this.atRoleColor;
    }

    public Long getAtRoleId() {
        return this.atRoleId;
    }

    public String getAtRoleName() {
        return this.atRoleName;
    }

    public long getAtTinyId() {
        return this.atTinyId;
    }

    public int getAtType() {
        return this.atType;
    }

    public long getAtUid() {
        return this.atUid;
    }

    public String getContent() {
        return this.content;
    }

    public LinkInfo getLinkInfo() {
        return this.linkInfo;
    }

    public Integer getNeedNotify() {
        return this.needNotify;
    }

    public Integer getSubElementType() {
        return this.subElementType;
    }

    public void setAtChannelId(Long l2) {
        this.atChannelId = l2;
    }

    public void setAtNtUid(String str) {
        this.atNtUid = str;
    }

    public void setAtRoleColor(Integer num) {
        this.atRoleColor = num;
    }

    public void setAtRoleId(Long l2) {
        this.atRoleId = l2;
    }

    public void setAtRoleName(String str) {
        this.atRoleName = str;
    }

    public void setAtTinyId(long j2) {
        this.atTinyId = j2;
    }

    public void setAtType(int i2) {
        this.atType = i2;
    }

    public void setAtUid(long j2) {
        this.atUid = j2;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setLinkInfo(LinkInfo linkInfo) {
        this.linkInfo = linkInfo;
    }

    public void setNeedNotify(Integer num) {
        this.needNotify = num;
    }

    public void setSubElementType(Integer num) {
        this.subElementType = num;
    }

    public String toString() {
        return "TextElement{content=" + this.content + ",atType=" + this.atType + ",atUid=" + this.atUid + ",atTinyId=" + this.atTinyId + ",atNtUid=" + this.atNtUid + ",subElementType=" + this.subElementType + ",atChannelId=" + this.atChannelId + ",linkInfo=" + this.linkInfo + ",atRoleId=" + this.atRoleId + ",atRoleColor=" + this.atRoleColor + ",atRoleName=" + this.atRoleName + ",needNotify=" + this.needNotify + ",}";
    }

    public TextElement(String str, int i2, long j2, long j3, String str2, Integer num, Long l2, LinkInfo linkInfo, Long l3, Integer num2, String str3, Integer num3) {
        this.content = "";
        this.content = str;
        this.atType = i2;
        this.atUid = j2;
        this.atTinyId = j3;
        this.atNtUid = str2;
        this.subElementType = num;
        this.atChannelId = l2;
        this.linkInfo = linkInfo;
        this.atRoleId = l3;
        this.atRoleColor = num2;
        this.atRoleName = str3;
        this.needNotify = num3;
    }
}
