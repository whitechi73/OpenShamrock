package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class GroupFileListResult {
    int allFileCount;
    String clientWording;
    boolean isEnd;
    ArrayList<GroupItem> item;
    int nextIndex;
    int reqId;
    int retCode;
    String retMsg;

    public GroupFileListResult() {
        this.retMsg = "";
        this.clientWording = "";
        this.item = new ArrayList<>();
    }

    public int getAllFileCount() {
        return this.allFileCount;
    }

    public String getClientWording() {
        return this.clientWording;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<GroupItem> getItem() {
        return this.item;
    }

    public int getNextIndex() {
        return this.nextIndex;
    }

    public int getReqId() {
        return this.reqId;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public String toString() {
        return "GroupFileListResult{retCode=" + this.retCode + ",retMsg=" + this.retMsg + ",clientWording=" + this.clientWording + ",isEnd=" + this.isEnd + ",item=" + this.item + ",allFileCount=" + this.allFileCount + ",nextIndex=" + this.nextIndex + ",reqId=" + this.reqId + ",}";
    }

    public GroupFileListResult(int i2, String str, String str2, boolean z, ArrayList<GroupItem> arrayList, int i3, int i4, int i5) {
        this.retMsg = "";
        this.clientWording = "";
        this.item = new ArrayList<>();
        this.retCode = i2;
        this.retMsg = str;
        this.clientWording = str2;
        this.isEnd = z;
        this.item = arrayList;
        this.allFileCount = i3;
        this.nextIndex = i4;
        this.reqId = i5;
    }
}
