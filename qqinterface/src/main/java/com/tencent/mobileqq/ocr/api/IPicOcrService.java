package com.tencent.mobileqq.ocr.api;

import mqq.app.api.IRuntimeService;

public interface IPicOcrService extends IRuntimeService {
    void putOcrResult(String str, com.tencent.mobileqq.l0.b.c cVar);

    void requestOcr(com.tencent.mobileqq.ocr.a.a aVar, com.tencent.mobileqq.l0.b.a callback);

}
