package com.tencent.qqnt.aio.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.kernel.nativeinterface.Contact;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;

public interface IAIOFileTransfer extends QRouteApi {
    void sendLocalFile(Contact contact, String path, IOperateCallback cb);
}