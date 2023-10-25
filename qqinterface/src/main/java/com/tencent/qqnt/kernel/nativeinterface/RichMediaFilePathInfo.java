package com.tencent.qqnt.kernel.nativeinterface;

public final class RichMediaFilePathInfo {
    int downloadType;
    int elementSubType;
    int elementType;
    String fileName;
    String fileUuid;
    byte[] importRichMediaContext;
    String md5HexStr;
    boolean needCreate;
    int thumbSize;

    public RichMediaFilePathInfo() {
        this.md5HexStr = "";
        this.fileName = "";
        this.fileUuid = "";
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public int getElementSubType() {
        return this.elementSubType;
    }

    public int getElementType() {
        return this.elementType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileUuid() {
        return this.fileUuid;
    }

    public byte[] getImportRichMediaContext() {
        return this.importRichMediaContext;
    }

    public String getMd5HexStr() {
        return this.md5HexStr;
    }

    public boolean getNeedCreate() {
        return this.needCreate;
    }

    public int getThumbSize() {
        return this.thumbSize;
    }

    public RichMediaFilePathInfo(int elementType, int elementSubType, String md5Hex, String fileName, int downloadType, int thumbSiz, byte[] importRichMediaContext, String uuid, boolean needCreate) {
        this.md5HexStr = "";
        this.fileName = "";
        this.fileUuid = "";
        this.elementType = elementType;
        this.elementSubType = elementSubType;
        this.md5HexStr = md5Hex;
        this.fileName = fileName;
        this.downloadType = downloadType;
        this.thumbSize = thumbSiz;
        this.importRichMediaContext = importRichMediaContext;
        this.fileUuid = uuid;
        this.needCreate = needCreate;
    }
}