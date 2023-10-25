package com.tencent.mobileqq.profilecard.processor;

import android.os.Bundle;

import com.tencent.mobileqq.data.Card;

import java.nio.ByteBuffer;
import java.util.List;

public interface IGetProfileDetailCallback {
    void onGetProfileDetailRequestForLogin(List<Short> list);

    void onGetProfileDetailResponseBegin(Bundle bundle);

    void onGetProfileDetailResponseEnd(Bundle bundle, boolean z, Card card);

    void onGetProfileDetailTLV(Bundle bundle, long j2, Card card, short s, short s2, ByteBuffer byteBuffer);

    void onGetProfileDetailTLVBegin(Bundle bundle, long j2, Card card);

    void onGetProfileDetailTLVEnd(Bundle bundle, long j2, Card card);

    void requestParseProfileLocation(Card card);
}
