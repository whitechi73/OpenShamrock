package com.tencent.qqnt.aio.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;

public interface IAIOFileTransfer extends QRouteApi {
    void sendLocalFile(Contact contact, String path, IOperateCallback cb);
}