package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;



public final class TextGiftElement implements Serializable {
    String bgImageUrl;
    int charmValue;
    long giftId;
    String giftName;
    int level;
    boolean needPlayAnimation;
    String orderId;
    String paddingTop;
    long price;
    String receiverNick;
    long receiverUin;
    int sendType;
    String senderNick;
    long senderUin;
    long serialVersionUID;
    ArrayList<VASGiftSpendCoinItem> spendCoins;
    long tianquanId;

    public TextGiftElement() {
        this.serialVersionUID = 1L;
        this.giftName = "";
        this.receiverNick = "";
        this.senderNick = "";
        this.orderId = "";
        this.bgImageUrl = "";
        this.paddingTop = "";
        this.spendCoins = new ArrayList<>();
    }

    public String getBgImageUrl() {
        return this.bgImageUrl;
    }

    public int getCharmValue() {
        return this.charmValue;
    }

    public long getGiftId() {
        return this.giftId;
    }

    public String getGiftName() {
        return this.giftName;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean getNeedPlayAnimation() {
        return this.needPlayAnimation;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPaddingTop() {
        return this.paddingTop;
    }

    public long getPrice() {
        return this.price;
    }

    public String getReceiverNick() {
        return this.receiverNick;
    }

    public long getReceiverUin() {
        return this.receiverUin;
    }

    public int getSendType() {
        return this.sendType;
    }

    public String getSenderNick() {
        return this.senderNick;
    }

    public long getSenderUin() {
        return this.senderUin;
    }

    public ArrayList<VASGiftSpendCoinItem> getSpendCoins() {
        return this.spendCoins;
    }

    public long getTianquanId() {
        return this.tianquanId;
    }

    public String toString() {
        return "TextGiftElement{giftId=" + this.giftId + ",giftName=" + this.giftName + ",receiverUin=" + this.receiverUin + ",senderUin=" + this.senderUin + ",receiverNick=" + this.receiverNick + ",senderNick=" + this.senderNick + ",price=" + this.price + ",orderId=" + this.orderId + ",bgImageUrl=" + this.bgImageUrl + ",tianquanId=" + this.tianquanId + ",level=" + this.level + ",paddingTop=" + this.paddingTop + ",spendCoins=" + this.spendCoins + ",needPlayAnimation=" + this.needPlayAnimation + ",sendType=" + this.sendType + ",charmValue=" + this.charmValue + ",}";
    }

    public TextGiftElement(long j2, String str, long j3, long j4, String str2, String str3, long j5, String str4, String str5, long j6, int i2, String str6, ArrayList<VASGiftSpendCoinItem> arrayList, boolean z, int i3, int i4) {
        this.serialVersionUID = 1L;
        this.giftName = "";
        this.receiverNick = "";
        this.senderNick = "";
        this.orderId = "";
        this.bgImageUrl = "";
        this.paddingTop = "";
        this.spendCoins = new ArrayList<>();
        this.giftId = j2;
        this.giftName = str;
        this.receiverUin = j3;
        this.senderUin = j4;
        this.receiverNick = str2;
        this.senderNick = str3;
        this.price = j5;
        this.orderId = str4;
        this.bgImageUrl = str5;
        this.tianquanId = j6;
        this.level = i2;
        this.paddingTop = str6;
        this.spendCoins = arrayList;
        this.needPlayAnimation = z;
        this.sendType = i3;
        this.charmValue = i4;
    }
}
