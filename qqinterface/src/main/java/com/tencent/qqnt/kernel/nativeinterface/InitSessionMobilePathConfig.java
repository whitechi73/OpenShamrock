package com.tencent.qqnt.kernel.nativeinterface;

public final class InitSessionMobilePathConfig {
    String mobileQqFilePath;
    String mobileQqMarketPath;
    String mobileQqPicPath;
    String mobileQqPttPath;
    String mobileQqVideoPath;

    public InitSessionMobilePathConfig() {
        this.mobileQqPicPath = "";
        this.mobileQqVideoPath = "";
        this.mobileQqPttPath = "";
        this.mobileQqFilePath = "";
        this.mobileQqMarketPath = "";
    }
}
