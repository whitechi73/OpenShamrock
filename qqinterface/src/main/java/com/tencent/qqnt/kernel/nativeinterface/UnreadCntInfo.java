package com.tencent.qqnt.kernel.nativeinterface;



public final class UnreadCntInfo {
    UnreadCnt allUnreadCnt;
    UnreadCnt atallUnreadCnt;
    UnreadCnt atmeUnreadCnt;
    byte[] headerUrl;
    GuildGroupOptType lastRelatedToFeedType;
    int lastRelatedToMeType;
    Contact peer;
    int relatedToMeCnt;
    String relatedToMeString;
    long relatedToMeStringTime;
    UnreadCnt showUnreadCnt;

    public UnreadCntInfo() {
        this.showUnreadCnt = new UnreadCnt();
        this.allUnreadCnt = new UnreadCnt();
        this.atmeUnreadCnt = new UnreadCnt();
        this.atallUnreadCnt = new UnreadCnt();
        this.peer = new Contact();
        this.relatedToMeString = "";
        this.lastRelatedToFeedType = GuildGroupOptType.values()[0];
        this.headerUrl = new byte[0];
    }

    public UnreadCnt getAllUnreadCnt() {
        return this.allUnreadCnt;
    }

    public UnreadCnt getAtallUnreadCnt() {
        return this.atallUnreadCnt;
    }

    public UnreadCnt getAtmeUnreadCnt() {
        return this.atmeUnreadCnt;
    }

    public byte[] getHeaderUrl() {
        return this.headerUrl;
    }

    public GuildGroupOptType getLastRelatedToFeedType() {
        return this.lastRelatedToFeedType;
    }

    public int getLastRelatedToMeType() {
        return this.lastRelatedToMeType;
    }

    public Contact getPeer() {
        return this.peer;
    }

    public int getRelatedToMeCnt() {
        return this.relatedToMeCnt;
    }

    public String getRelatedToMeString() {
        return this.relatedToMeString;
    }

    public long getRelatedToMeStringTime() {
        return this.relatedToMeStringTime;
    }

    public UnreadCnt getShowUnreadCnt() {
        return this.showUnreadCnt;
    }

    public String toString() {
        return "UnreadCntInfo{showUnreadCnt=" + this.showUnreadCnt + ",allUnreadCnt=" + this.allUnreadCnt + ",atmeUnreadCnt=" + this.atmeUnreadCnt + ",atallUnreadCnt=" + this.atallUnreadCnt + ",peer=" + this.peer + ",relatedToMeString=" + this.relatedToMeString + ",relatedToMeCnt=" + this.relatedToMeCnt + ",lastRelatedToMeType=" + this.lastRelatedToMeType + ",relatedToMeStringTime=" + this.relatedToMeStringTime + ",lastRelatedToFeedType=" + this.lastRelatedToFeedType + ",headerUrl=" + this.headerUrl + ",}";
    }

    public UnreadCntInfo(UnreadCnt unreadCnt, UnreadCnt unreadCnt2, UnreadCnt unreadCnt3, UnreadCnt unreadCnt4, Contact contact, String str, int i2, int i3, long j2, GuildGroupOptType guildGroupOptType, byte[] bArr) {
        this.showUnreadCnt = new UnreadCnt();
        this.allUnreadCnt = new UnreadCnt();
        this.atmeUnreadCnt = new UnreadCnt();
        this.atallUnreadCnt = new UnreadCnt();
        this.peer = new Contact();
        this.relatedToMeString = "";
        this.lastRelatedToFeedType = GuildGroupOptType.values()[0];
        this.headerUrl = new byte[0];
        this.showUnreadCnt = unreadCnt;
        this.allUnreadCnt = unreadCnt2;
        this.atmeUnreadCnt = unreadCnt3;
        this.atallUnreadCnt = unreadCnt4;
        this.peer = contact;
        this.relatedToMeString = str;
        this.relatedToMeCnt = i2;
        this.lastRelatedToMeType = i3;
        this.relatedToMeStringTime = j2;
        this.lastRelatedToFeedType = guildGroupOptType;
        this.headerUrl = bArr;
    }
}
