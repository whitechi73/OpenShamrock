package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public final class InlineKeyboardButton {
    int anchor;
    boolean atBotShowChannelList;
    int clickLimit;
    String data;
    boolean enter;
    String id;
    boolean isReply;
    String label;
    int permissionType;
    ArrayList<String> specifyRoleIds;
    ArrayList<String> specifyTinyids;
    int style;
    ArrayList<SubscribeMsgTemplateID> subscribeDataTemplateIds;
    int type;
    String unsupportTips;
    String visitedLabel;

    public InlineKeyboardButton() {
        this.id = "";
        this.label = "";
        this.visitedLabel = "";
        this.unsupportTips = "";
        this.data = "";
        this.specifyRoleIds = new ArrayList<>();
        this.specifyTinyids = new ArrayList<>();
        this.subscribeDataTemplateIds = new ArrayList<>();
    }

    public int getAnchor() {
        return this.anchor;
    }

    public boolean getAtBotShowChannelList() {
        return this.atBotShowChannelList;
    }

    public int getClickLimit() {
        return this.clickLimit;
    }

    public String getData() {
        return this.data;
    }

    public boolean getEnter() {
        return this.enter;
    }

    public String getId() {
        return this.id;
    }

    public boolean getIsReply() {
        return this.isReply;
    }

    public String getLabel() {
        return this.label;
    }

    public int getPermissionType() {
        return this.permissionType;
    }

    public ArrayList<String> getSpecifyRoleIds() {
        return this.specifyRoleIds;
    }

    public ArrayList<String> getSpecifyTinyids() {
        return this.specifyTinyids;
    }

    public int getStyle() {
        return this.style;
    }

    public ArrayList<SubscribeMsgTemplateID> getSubscribeDataTemplateIds() {
        return this.subscribeDataTemplateIds;
    }

    public int getType() {
        return this.type;
    }

    public String getUnsupportTips() {
        return this.unsupportTips;
    }

    public String getVisitedLabel() {
        return this.visitedLabel;
    }

    public String toString() {
        return "InlineKeyboardButton{id=" + this.id + ",label=" + this.label + ",visitedLabel=" + this.visitedLabel + ",style=" + this.style + ",type=" + this.type + ",clickLimit=" + this.clickLimit + ",unsupportTips=" + this.unsupportTips + ",data=" + this.data + ",atBotShowChannelList=" + this.atBotShowChannelList + ",permissionType=" + this.permissionType + ",specifyRoleIds=" + this.specifyRoleIds + ",specifyTinyids=" + this.specifyTinyids + ",isReply=" + this.isReply + ",anchor=" + this.anchor + ",enter=" + this.enter + ",subscribeDataTemplateIds=" + this.subscribeDataTemplateIds + ",}";
    }

    public InlineKeyboardButton(String str, String str2, String str3, int i, int i2, int i3, String str4, String str5, boolean z, int i4, ArrayList<String> arrayList, ArrayList<String> arrayList2) {

    }

    public InlineKeyboardButton(String str, String str2, String str3, int i2, int i3, int i4, String str4, String str5, boolean z, int i5, ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean z2, int i6, boolean z3, ArrayList<SubscribeMsgTemplateID> arrayList3) {
        this.id = "";
        this.label = "";
        this.visitedLabel = "";
        this.unsupportTips = "";
        this.data = "";
        this.specifyRoleIds = new ArrayList<>();
        this.specifyTinyids = new ArrayList<>();
        this.subscribeDataTemplateIds = new ArrayList<>();
        this.id = str;
        this.label = str2;
        this.visitedLabel = str3;
        this.style = i2;
        this.type = i3;
        this.clickLimit = i4;
        this.unsupportTips = str4;
        this.data = str5;
        this.atBotShowChannelList = z;
        this.permissionType = i5;
        this.specifyRoleIds = arrayList;
        this.specifyTinyids = arrayList2;
        this.isReply = z2;
        this.anchor = i6;
        this.enter = z3;
        this.subscribeDataTemplateIds = arrayList3;
    }
}