package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;

public class BaseTransProcessor implements IHttpCommunicatorListener {
    public FileMsg file;

    public long getFileStatus() {
        return 0;
    }

    public int cancel() {
        return 0;
    }
}
