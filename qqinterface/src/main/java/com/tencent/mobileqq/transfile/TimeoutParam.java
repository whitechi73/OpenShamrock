package com.tencent.mobileqq.transfile;

public class TimeoutParam {
    public static final int TIMEOUT_STEP = 2000;
    private int connectTimeoutBias;
    public int connectTimeoutFor2G;
    public int connectTimeoutFor3G;
    public int connectTimeoutForWifi;
    public int readTimeoutFor2G;
    public int readTimeoutFor3G;
    public int readTimeoutForWifi;

    public TimeoutParam() {
        this.readTimeoutFor2G = 40000;
        this.readTimeoutFor3G = 30000;
        this.readTimeoutForWifi = 20000;
        this.connectTimeoutFor2G = 20000;
        this.connectTimeoutFor3G = 15000;
        this.connectTimeoutForWifi = 10000;
        this.connectTimeoutBias = 0;
    }

    public void adjustConnectTimeout(int i2) {

            this.connectTimeoutBias = i2 * 2000;
    }

    public int getConnectTimeout(int i2) {
        if (i2 != 1) {
            if (i2 == 3) {
                return this.connectTimeoutFor3G + this.connectTimeoutBias;
            }
            if (i2 != 4 && i2 != 5) {
                return this.connectTimeoutFor2G + this.connectTimeoutBias;
            }
        }
        return this.connectTimeoutForWifi + this.connectTimeoutBias;
    }

    public int getReadTimeout(int i2) {
        if (i2 != 1) {
            if (i2 == 3) {
                return this.readTimeoutFor3G;
            }
            if (i2 != 4 && i2 != 5) {
                return this.readTimeoutFor2G;
            }
        }
        return this.readTimeoutForWifi;
    }

    //public TimeoutParam clone() {
    //    IPatchRedirector iPatchRedirector = $redirector_;
    //    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new TimeoutParam(this) : (TimeoutParam) iPatchRedirector.redirect((short) 4, (Object) this);
    //}

    TimeoutParam(TimeoutParam timeoutParam) {
        this.readTimeoutFor2G = 40000;
        this.readTimeoutFor3G = 30000;
        this.readTimeoutForWifi = 20000;
        this.connectTimeoutFor2G = 20000;
        this.connectTimeoutFor3G = 15000;
        this.connectTimeoutForWifi = 10000;
        this.connectTimeoutBias = 0;
        this.readTimeoutFor2G = timeoutParam.readTimeoutFor2G;
        this.readTimeoutFor3G = timeoutParam.readTimeoutFor3G;
        this.readTimeoutForWifi = timeoutParam.readTimeoutForWifi;
        this.connectTimeoutFor2G = timeoutParam.connectTimeoutFor2G;
        this.connectTimeoutFor3G = timeoutParam.connectTimeoutFor3G;
        this.connectTimeoutForWifi = timeoutParam.connectTimeoutForWifi;
    }
}
