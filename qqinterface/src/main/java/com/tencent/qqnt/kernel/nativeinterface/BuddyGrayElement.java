package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class BuddyGrayElement implements Serializable {
    NewBuddyGrayElement elem;
    long serialVersionUID = 1;
    int type;

    public BuddyGrayElement() {
    }

    public NewBuddyGrayElement getElem() {
        return this.elem;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "BuddyGrayElement{type=" + this.type + ",elem=" + this.elem + ",}";
    }

    public BuddyGrayElement(int i2, NewBuddyGrayElement newBuddyGrayElement) {
        this.type = i2;
        this.elem = newBuddyGrayElement;
    }
}