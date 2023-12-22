package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.qroute.QRouteApi;

public interface IFileManagerUtil extends QRouteApi {
    byte[] getSHA(String str);
}