package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class FeedCommentsRsp {
    String attchInfo;
    int isFinish;
    int totalNum;
    ArrayList<CommentForRead> vecComment;

    public FeedCommentsRsp() {
        this.vecComment = new ArrayList<>();
        this.attchInfo = "";
    }

    public String getAttchInfo() {
        return this.attchInfo;
    }

    public int getIsFinish() {
        return this.isFinish;
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public ArrayList<CommentForRead> getVecComment() {
        return this.vecComment;
    }

    public String toString() {
        return "FeedCommentsRsp{vecComment=" + this.vecComment + ",totalNum=" + this.totalNum + ",isFinish=" + this.isFinish + ",attchInfo=" + this.attchInfo + ",}";
    }

    public FeedCommentsRsp(ArrayList<CommentForRead> arrayList, int i2, int i3, String str) {
        this.vecComment = new ArrayList<>();
        this.attchInfo = "";
        this.vecComment = arrayList;
        this.totalNum = i2;
        this.isFinish = i3;
        this.attchInfo = str;
    }
}
