package com.tencent.qqnt.kernel.nativeinterface;



public final class WalletAio {
    String actionsPriority;
    String aioImageLeft;
    String aioImageRight;
    int background;
    String blackStripe;
    String cftImage;
    String content;
    int contentBgcolor;
    int contentColor;
    int icon;
    String iconUrl;
    String jumpUrl;
    String linkUrl;
    String nativeAndroid;
    String nativeIOS;
    String notice;
    byte[] pbReserve;
    String subTitle;
    int subtitleColor;
    String title;
    int titleColor;

    public WalletAio() {
        this.title = "";
        this.subTitle = "";
        this.content = "";
        this.linkUrl = "";
        this.blackStripe = "";
        this.notice = "";
        this.actionsPriority = "";
        this.jumpUrl = "";
        this.nativeIOS = "";
        this.nativeAndroid = "";
        this.iconUrl = "";
        this.aioImageLeft = "";
        this.aioImageRight = "";
        this.cftImage = "";
        this.pbReserve = new byte[0];
    }

    public String getActionsPriority() {
        return this.actionsPriority;
    }

    public String getAioImageLeft() {
        return this.aioImageLeft;
    }

    public String getAioImageRight() {
        return this.aioImageRight;
    }

    public int getBackground() {
        return this.background;
    }

    public String getBlackStripe() {
        return this.blackStripe;
    }

    public String getCftImage() {
        return this.cftImage;
    }

    public String getContent() {
        return this.content;
    }

    public int getContentBgcolor() {
        return this.contentBgcolor;
    }

    public int getContentColor() {
        return this.contentColor;
    }

    public int getIcon() {
        return this.icon;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String getNativeAndroid() {
        return this.nativeAndroid;
    }

    public String getNativeIOS() {
        return this.nativeIOS;
    }

    public String getNotice() {
        return this.notice;
    }

    public byte[] getPbReserve() {
        return this.pbReserve;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public int getSubtitleColor() {
        return this.subtitleColor;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTitleColor() {
        return this.titleColor;
    }

    public String toString() {
        return "WalletAio{background=" + this.background + ",icon=" + this.icon + ",title=" + this.title + ",subTitle=" + this.subTitle + ",content=" + this.content + ",linkUrl=" + this.linkUrl + ",blackStripe=" + this.blackStripe + ",notice=" + this.notice + ",titleColor=" + this.titleColor + ",subtitleColor=" + this.subtitleColor + ",actionsPriority=" + this.actionsPriority + ",jumpUrl=" + this.jumpUrl + ",nativeIOS=" + this.nativeIOS + ",nativeAndroid=" + this.nativeAndroid + ",iconUrl=" + this.iconUrl + ",contentColor=" + this.contentColor + ",contentBgcolor=" + this.contentBgcolor + ",aioImageLeft=" + this.aioImageLeft + ",aioImageRight=" + this.aioImageRight + ",cftImage=" + this.cftImage + ",pbReserve=" + this.pbReserve + ",}";
    }

    public WalletAio(int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, int i5, String str7, String str8, String str9, String str10, String str11, int i6, int i7, String str12, String str13, String str14, byte[] bArr) {
        this.title = "";
        this.subTitle = "";
        this.content = "";
        this.linkUrl = "";
        this.blackStripe = "";
        this.notice = "";
        this.actionsPriority = "";
        this.jumpUrl = "";
        this.nativeIOS = "";
        this.nativeAndroid = "";
        this.iconUrl = "";
        this.aioImageLeft = "";
        this.aioImageRight = "";
        this.cftImage = "";
        this.pbReserve = new byte[0];
        this.background = i2;
        this.icon = i3;
        this.title = str;
        this.subTitle = str2;
        this.content = str3;
        this.linkUrl = str4;
        this.blackStripe = str5;
        this.notice = str6;
        this.titleColor = i4;
        this.subtitleColor = i5;
        this.actionsPriority = str7;
        this.jumpUrl = str8;
        this.nativeIOS = str9;
        this.nativeAndroid = str10;
        this.iconUrl = str11;
        this.contentColor = i6;
        this.contentBgcolor = i7;
        this.aioImageLeft = str12;
        this.aioImageRight = str13;
        this.cftImage = str14;
        this.pbReserve = bArr;
    }
}
