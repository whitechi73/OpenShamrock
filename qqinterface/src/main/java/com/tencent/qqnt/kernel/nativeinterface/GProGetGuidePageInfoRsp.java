package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGetGuidePageInfoRsp {
    ArrayList<GProGuidePageInfo> guidePage;
    GProGuidePageInfo mainGuidePage;

    public GProGetGuidePageInfoRsp() {
        this.mainGuidePage = new GProGuidePageInfo();
        this.guidePage = new ArrayList<>();
    }

    public ArrayList<GProGuidePageInfo> getGuidePage() {
        return this.guidePage;
    }

    public GProGuidePageInfo getMainGuidePage() {
        return this.mainGuidePage;
    }

    public String toString() {
        return "GProGetGuidePageInfoRsp{mainGuidePage=" + this.mainGuidePage + ",guidePage=" + this.guidePage + ",}";
    }

    public GProGetGuidePageInfoRsp(GProGuidePageInfo gProGuidePageInfo, ArrayList<GProGuidePageInfo> arrayList) {
        this.mainGuidePage = new GProGuidePageInfo();
        this.guidePage = new ArrayList<>();
        this.mainGuidePage = gProGuidePageInfo;
        this.guidePage = arrayList;
    }
}
