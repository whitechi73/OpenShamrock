package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class TofuRecordElement {
    String background;
    int beancurstyle;
    String busiExtra;
    long busiid;
    String busiuuid;
    ArrayList<TofuContent> contentlist;
    long dependedmsgid;
    TofuContent descriptionContent;
    String icon;
    long msgtime;
    boolean onscreennotify;
    int type;
    ArrayList<String> uidlist;
    ArrayList<Long> uinlist;
    long updateTime;

    public TofuRecordElement() {
        this.busiuuid = "";
        this.uinlist = new ArrayList<>();
        this.uidlist = new ArrayList<>();
    }

    public String getBackground() {
        return this.background;
    }

    public int getBeancurstyle() {
        return this.beancurstyle;
    }

    public String getBusiExtra() {
        return this.busiExtra;
    }

    public long getBusiid() {
        return this.busiid;
    }

    public String getBusiuuid() {
        return this.busiuuid;
    }

    public ArrayList<TofuContent> getContentlist() {
        return this.contentlist;
    }

    public long getDependedmsgid() {
        return this.dependedmsgid;
    }

    public TofuContent getDescriptionContent() {
        return this.descriptionContent;
    }

    public String getIcon() {
        return this.icon;
    }

    public long getMsgtime() {
        return this.msgtime;
    }

    public boolean getOnscreennotify() {
        return this.onscreennotify;
    }

    public int getType() {
        return this.type;
    }

    public ArrayList<String> getUidlist() {
        return this.uidlist;
    }

    public ArrayList<Long> getUinlist() {
        return this.uinlist;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String toString() {
        return "TofuRecordElement{type=" + this.type + ",busiid=" + this.busiid + ",busiuuid=" + this.busiuuid + ",beancurstyle=" + this.beancurstyle + ",descriptionContent=" + this.descriptionContent + ",contentlist=" + this.contentlist + ",background=" + this.background + ",icon=" + this.icon + ",uinlist=" + this.uinlist + ",uidlist=" + this.uidlist + ",busiExtra=" + this.busiExtra + ",updateTime=" + this.updateTime + ",dependedmsgid=" + this.dependedmsgid + ",msgtime=" + this.msgtime + ",onscreennotify=" + this.onscreennotify + ",}";
    }

    public TofuRecordElement(int i2, long j2, String str, int i3, TofuContent tofuContent, ArrayList<TofuContent> arrayList, String str2, String str3, ArrayList<Long> arrayList2, ArrayList<String> arrayList3, String str4, long j3, long j4, long j5, boolean z) {
        this.busiuuid = "";
        this.uinlist = new ArrayList<>();
        this.uidlist = new ArrayList<>();
        this.type = i2;
        this.busiid = j2;
        this.busiuuid = str;
        this.beancurstyle = i3;
        this.descriptionContent = tofuContent;
        this.contentlist = arrayList;
        this.background = str2;
        this.icon = str3;
        this.uinlist = arrayList2;
        this.uidlist = arrayList3;
        this.busiExtra = str4;
        this.updateTime = j3;
        this.dependedmsgid = j4;
        this.msgtime = j5;
        this.onscreennotify = z;
    }
}
