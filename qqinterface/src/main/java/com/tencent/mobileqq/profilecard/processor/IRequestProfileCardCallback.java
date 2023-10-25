package com.tencent.mobileqq.profilecard.processor;

import android.os.Bundle;
import android.util.SparseArray;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;

import java.util.ArrayList;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb;

public interface IRequestProfileCardCallback {
    void onProcessProfile0x5eb(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard, oidb_0x5eb.UdcUinData oidb_0x5eb_udcuindata);

    void onProcessProfileCard(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard);

    void onProcessProfileService(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard, SparseArray<BusinessRespBuffer> sparseArray);

    void onRequestProfileCard(Bundle bundle, ArrayList<BusinessReqBuffer> arrayList, ArrayList<Integer> arrayList2);

    void onResponseProfileCard(boolean z, Bundle bundle, RespHead respHead, RespSummaryCard respSummaryCard);
}
