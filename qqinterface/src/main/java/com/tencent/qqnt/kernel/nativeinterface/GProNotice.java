package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProNotice {
    ArrayList<GProNoticeAction> actionList;
    ArrayList<GProNoticeText> comment;
    GProNoticeCover cover;
    int createTs;
    int expireTs;
    long guildId;
    String handleResult;
    int handleTs;
    String handlerNickName;
    long handlerTinyId;
    long handlerUin;
    String joinSign;
    ArrayList<GProNoticeJump> jumpLink;
    int msgType;
    String noticeId;
    int noticeType;
    ArrayList<GProNoticeText> subTitle;
    int templateId;
    ArrayList<GProNoticeText> title;

    public GProNotice() {
        this.noticeId = "";
        this.title = new ArrayList<>();
        this.subTitle = new ArrayList<>();
        this.comment = new ArrayList<>();
        this.cover = new GProNoticeCover();
        this.actionList = new ArrayList<>();
        this.joinSign = "";
        this.jumpLink = new ArrayList<>();
        this.handleResult = "";
        this.handlerNickName = "";
    }

    public ArrayList<GProNoticeAction> getActionList() {
        return this.actionList;
    }

    public ArrayList<GProNoticeText> getComment() {
        return this.comment;
    }

    public GProNoticeCover getCover() {
        return this.cover;
    }

    public int getCreateTs() {
        return this.createTs;
    }

    public int getExpireTs() {
        return this.expireTs;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getHandleResult() {
        return this.handleResult;
    }

    public int getHandleTs() {
        return this.handleTs;
    }

    public String getHandlerNickName() {
        return this.handlerNickName;
    }

    public long getHandlerTinyId() {
        return this.handlerTinyId;
    }

    public long getHandlerUin() {
        return this.handlerUin;
    }

    public String getJoinSign() {
        return this.joinSign;
    }

    public ArrayList<GProNoticeJump> getJumpLink() {
        return this.jumpLink;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getNoticeId() {
        return this.noticeId;
    }

    public int getNoticeType() {
        return this.noticeType;
    }

    public ArrayList<GProNoticeText> getSubTitle() {
        return this.subTitle;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public ArrayList<GProNoticeText> getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProNotice{noticeId=" + this.noticeId + ",templateId=" + this.templateId + ",createTs=" + this.createTs + ",expireTs=" + this.expireTs + ",handleTs=" + this.handleTs + ",guildId=" + this.guildId + ",title=" + this.title + ",subTitle=" + this.subTitle + ",comment=" + this.comment + ",cover=" + this.cover + ",actionList=" + this.actionList + ",joinSign=" + this.joinSign + ",msgType=" + this.msgType + ",jumpLink=" + this.jumpLink + ",noticeType=" + this.noticeType + ",handlerUin=" + this.handlerUin + ",handleResult=" + this.handleResult + ",handlerTinyId=" + this.handlerTinyId + ",handlerNickName=" + this.handlerNickName + ",}";
    }

    public GProNotice(String str, int i2, int i3, int i4, int i5, long j2, ArrayList<GProNoticeText> arrayList, ArrayList<GProNoticeText> arrayList2, ArrayList<GProNoticeText> arrayList3, GProNoticeCover gProNoticeCover, ArrayList<GProNoticeAction> arrayList4, String str2, int i6, ArrayList<GProNoticeJump> arrayList5, int i7, long j3, String str3, long j4, String str4) {
        this.noticeId = "";
        this.title = new ArrayList<>();
        this.subTitle = new ArrayList<>();
        this.comment = new ArrayList<>();
        this.cover = new GProNoticeCover();
        this.actionList = new ArrayList<>();
        this.joinSign = "";
        this.jumpLink = new ArrayList<>();
        this.handleResult = "";
        this.handlerNickName = "";
        this.noticeId = str;
        this.templateId = i2;
        this.createTs = i3;
        this.expireTs = i4;
        this.handleTs = i5;
        this.guildId = j2;
        this.title = arrayList;
        this.subTitle = arrayList2;
        this.comment = arrayList3;
        this.cover = gProNoticeCover;
        this.actionList = arrayList4;
        this.joinSign = str2;
        this.msgType = i6;
        this.jumpLink = arrayList5;
        this.noticeType = i7;
        this.handlerUin = j3;
        this.handleResult = str3;
        this.handlerTinyId = j4;
        this.handlerNickName = str4;
    }
}
