package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class InlineKeyboardRow {
    ArrayList<InlineKeyboardButton> buttons;

    public InlineKeyboardRow() {
        this.buttons = new ArrayList<>();
    }

    public ArrayList<InlineKeyboardButton> getButtons() {
        return this.buttons;
    }

    public String toString() {
        return "InlineKeyboardRow{buttons=" + this.buttons + ",}";
    }

    public InlineKeyboardRow(ArrayList<InlineKeyboardButton> arrayList) {
        this.buttons = new ArrayList<>();
        this.buttons = arrayList;
    }
}
