package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class InlineKeyboardButton {
    boolean atBotShowChannelList;
    int clickLimit;
    String data;
    String id;
    String label;
    int permissionType;
    ArrayList<String> specifyRoleIds;
    ArrayList<String> specifyTinyids;
    int style;
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

    public String getId() {
        return this.id;
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
        return "InlineKeyboardButton{id=" + this.id + ",label=" + this.label + ",visitedLabel=" + this.visitedLabel + ",style=" + this.style + ",type=" + this.type + ",clickLimit=" + this.clickLimit + ",unsupportTips=" + this.unsupportTips + ",data=" + this.data + ",atBotShowChannelList=" + this.atBotShowChannelList + ",permissionType=" + this.permissionType + ",specifyRoleIds=" + this.specifyRoleIds + ",specifyTinyids=" + this.specifyTinyids + ",}";
    }

    public InlineKeyboardButton(String str, String str2, String str3, int i2, int i3, int i4, String str4, String str5, boolean z, int i5, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.id = "";
        this.label = "";
        this.visitedLabel = "";
        this.unsupportTips = "";
        this.data = "";
        this.specifyRoleIds = new ArrayList<>();
        this.specifyTinyids = new ArrayList<>();
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
    }
}
