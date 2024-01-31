package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class ProclamationElement implements Serializable {
    int isSetProclamation;
    long serialVersionUID = 1;

    public ProclamationElement() {
    }

    public int getIsSetProclamation() {
        return this.isSetProclamation;
    }

    public String toString() {
        return "ProclamationElement{isSetProclamation=" + this.isSetProclamation + ",}";
    }

    public ProclamationElement(int i2) {
        this.isSetProclamation = i2;
    }
}
