package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.qroute.QRouteApi;

public interface IQRCodeApi extends QRouteApi {
    int getOneResult(StringBuilder sb, StringBuilder sb2);

    int getOneResultForCamera(StringBuilder sb, StringBuilder sb2);

    //ArrayList<QBarResult> getResult();

    //ArrayList<QBarResult> getResultForCamera();

    String getVersion();

    int init(int i2, String str, String str2);

    int initForCamera(int i2, String str, String str2);

    boolean isValidScanImageSize(int i2, int i3);

    boolean isWxCodeSupported();

    int release();

    int releaseForCamera();

    int scanImage(byte[] bArr, int i2, int i3);

    int scanImageForCamera(byte[] bArr, int i2, int i3);

    //int setReaders(k.a aVar);

   // int setReadersForCamera(k.a aVar);
}
