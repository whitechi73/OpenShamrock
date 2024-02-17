package com.tencent.qqnt.aio.api;

import com.tencent.libra.download.ILibraDownloader;
import com.tencent.mobileqq.qroute.QRouteApi;

import org.jetbrains.annotations.NotNull;

public interface IAIOPicDownloaderProvider extends QRouteApi {
    @NotNull
    ILibraDownloader provideDownloader();
}