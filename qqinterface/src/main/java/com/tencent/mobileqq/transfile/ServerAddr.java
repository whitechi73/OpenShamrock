package com.tencent.mobileqq.transfile;

public class ServerAddr {
    public boolean isIpv6;
    public String mIp;
    public int port = 80;
    public boolean isDomain = false;

    public String getServerUrl(String str) {
        String str2 = null;
        if (str != null) {
            if (this.isDomain) {
                if (str.startsWith("http://")) {
                    str2 = "http://" + this.mIp;
                } else if (str.startsWith("https://")) {
                    str2 = "https://" + this.mIp;
                }
                return str2 + "/";
            }
            if (str.startsWith("http://")) {
                if (this.isIpv6 && !this.mIp.startsWith("[")) {
                    str2 = "http://[" + this.mIp + "]";
                } else {
                    str2 = "http://" + this.mIp;
                }
            } else if (str.startsWith("https://")) {
                if (this.isIpv6 && !this.mIp.startsWith("[")) {
                    str2 = "https://[" + this.mIp + "]";
                } else {
                    str2 = "https://" + this.mIp;
                }
            }
            if (this.port != 80) {
                return str2 + ":" + this.port + "/";
            }
            return str2 + "/";
        }
        return null;
    }

    public void onFail() {
    }

    public void onSuccess() {
    }

    public String toString() {
        return this.mIp + ":" + this.port;
    }
}
