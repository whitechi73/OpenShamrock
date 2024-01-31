package com.tencent.qqnt.kernel.nativeinterface;

public  final class FileAssistantListParams {
    int count;
    FileAssistantType fileType;
    Long groupCode;
    Order order;
    FileAssistantRequestType reqType;
    String uid;

    public FileAssistantListParams() {
        this.reqType = FileAssistantRequestType.values()[0];
        this.order = Order.values()[0];
    }

    public int getCount() {
        return this.count;
    }

    public FileAssistantType getFileType() {
        return this.fileType;
    }

    public Long getGroupCode() {
        return this.groupCode;
    }

    public Order getOrder() {
        return this.order;
    }

    public FileAssistantRequestType getReqType() {
        return this.reqType;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "FileAssistantListParams{reqType=" + this.reqType + ",order=" + this.order + ",count=" + this.count + ",uid=" + this.uid + ",groupCode=" + this.groupCode + ",fileType=" + this.fileType + ",}";
    }

    public FileAssistantListParams(FileAssistantRequestType fileAssistantRequestType, Order order, int i2, String str, Long l2, FileAssistantType fileAssistantType) {
        this.reqType = FileAssistantRequestType.values()[0];
        this.order = Order.values()[0];
        this.reqType = fileAssistantRequestType;
        this.order = order;
        this.count = i2;
        this.uid = str;
        this.groupCode = l2;
        this.fileType = fileAssistantType;
    }
}
