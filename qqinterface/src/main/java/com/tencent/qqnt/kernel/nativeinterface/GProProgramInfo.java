package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProProgramInfo implements Serializable {
    String anchorName;
    String liveTitle;
    String programId;
    long serialVersionUID;
    long tabId;
    String thirdPartyLogo;

    public GProProgramInfo() {
        this.serialVersionUID = 1L;
        this.programId = "";
        this.liveTitle = "";
        this.anchorName = "";
        this.thirdPartyLogo = "";
    }

    public String getAnchorName() {
        return this.anchorName;
    }

    public String getLiveTitle() {
        return this.liveTitle;
    }

    public String getProgramId() {
        return this.programId;
    }

    public long getTabId() {
        return this.tabId;
    }

    public String getThirdPartyLogo() {
        return this.thirdPartyLogo;
    }

    public String toString() {
        return "GProProgramInfo{programId=" + this.programId + ",liveTitle=" + this.liveTitle + ",anchorName=" + this.anchorName + ",thirdPartyLogo=" + this.thirdPartyLogo + ",tabId=" + this.tabId + ",}";
    }

    public GProProgramInfo(String str, String str2, String str3, String str4, long j2) {
        this.serialVersionUID = 1L;
        this.programId = "";
        this.liveTitle = "";
        this.anchorName = "";
        this.thirdPartyLogo = "";
        this.programId = str;
        this.liveTitle = str2;
        this.anchorName = str3;
        this.thirdPartyLogo = str4;
        this.tabId = j2;
    }
}
