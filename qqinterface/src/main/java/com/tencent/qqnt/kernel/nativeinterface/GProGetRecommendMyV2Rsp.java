package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGetRecommendMyV2Rsp {
    GProGetAtMeMsgRsp atMeMsg;
    byte[] cookies;
    GProRecommendExtInfo extInfo;
    ArrayList<GProRecommendItem> recommendList;

    public GProGetRecommendMyV2Rsp() {
        this.recommendList = new ArrayList<>();
        this.extInfo = new GProRecommendExtInfo();
        this.cookies = new byte[0];
        this.atMeMsg = new GProGetAtMeMsgRsp();
    }

    public GProGetAtMeMsgRsp getAtMeMsg() {
        return this.atMeMsg;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public GProRecommendExtInfo getExtInfo() {
        return this.extInfo;
    }

    public ArrayList<GProRecommendItem> getRecommendList() {
        return this.recommendList;
    }

    public String toString() {
        return "GProGetRecommendMyV2Rsp{recommendList=" + this.recommendList + ",extInfo=" + this.extInfo + ",cookies=" + this.cookies + ",atMeMsg=" + this.atMeMsg + ",}";
    }

    public GProGetRecommendMyV2Rsp(ArrayList<GProRecommendItem> arrayList, GProRecommendExtInfo gProRecommendExtInfo, byte[] bArr, GProGetAtMeMsgRsp gProGetAtMeMsgRsp) {
        this.recommendList = new ArrayList<>();
        this.extInfo = new GProRecommendExtInfo();
        this.cookies = new byte[0];
        this.atMeMsg = new GProGetAtMeMsgRsp();
        this.recommendList = arrayList;
        this.extInfo = gProRecommendExtInfo;
        this.cookies = bArr;
        this.atMeMsg = gProGetAtMeMsgRsp;
    }
}
