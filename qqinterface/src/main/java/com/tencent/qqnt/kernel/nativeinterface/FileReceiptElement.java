package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class FileReceiptElement implements Serializable {
    String fileName;
    long serialVersionUID;

    public FileReceiptElement() {
        this.serialVersionUID = 1L;
        this.fileName = "";
    }

    public String getFileName() {
        return this.fileName;
    }

    public String toString() {
        return "FileReceiptElement{fileName=" + this.fileName + ",}";
    }

    public FileReceiptElement(String str) {
        this.serialVersionUID = 1L;
        this.fileName = "";
        this.fileName = str;
    }
}