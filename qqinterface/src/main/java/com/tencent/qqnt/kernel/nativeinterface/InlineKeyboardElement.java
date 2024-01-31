package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class InlineKeyboardElement {
    long botAppid;
    ArrayList<InlineKeyboardRow> rows;

    public InlineKeyboardElement() {
        this.rows = new ArrayList<>();
    }

    public long getBotAppid() {
        return this.botAppid;
    }

    public ArrayList<InlineKeyboardRow> getRows() {
        return this.rows;
    }

    public String toString() {
        return "InlineKeyboardElement{rows=" + this.rows + ",botAppid=" + this.botAppid + ",}";
    }

    public InlineKeyboardElement(ArrayList<InlineKeyboardRow> arrayList, long j2) {
        this.rows = new ArrayList<>();
        this.rows = arrayList;
        this.botAppid = j2;
    }
}
