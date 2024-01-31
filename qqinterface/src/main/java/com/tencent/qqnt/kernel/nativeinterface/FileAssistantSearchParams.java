package com.tencent.qqnt.kernel.nativeinterface;

public  final class FileAssistantSearchParams {
    int pageLimit;
    Order resultSortType;

    public FileAssistantSearchParams() {
        this.resultSortType = Order.values()[0];
    }

    public int getPageLimit() {
        return this.pageLimit;
    }

    public Order getResultSortType() {
        return this.resultSortType;
    }

    public String toString() {
        return "FileAssistantSearchParams{resultSortType=" + this.resultSortType + ",pageLimit=" + this.pageLimit + ",}";
    }

    public FileAssistantSearchParams(Order order, int i2) {
        this.resultSortType = Order.values()[0];
        this.resultSortType = order;
        this.pageLimit = i2;
    }
}
