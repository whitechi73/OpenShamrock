package com.tencent.mobileqq.profilecard.processor;

import android.os.Bundle;
import android.util.SparseArray;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb;

public abstract class AbsProfileBusinessProcessor implements IRequestProfileCardCallback, IGetProfileDetailCallback {
    public AbsProfileBusinessProcessor(AppRuntime appRuntime) {
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailRequestForLogin(List<Short> list) {
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailResponseBegin(Bundle bundle) {
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailResponseEnd(Bundle bundle, boolean z, Card card) {
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailTLV(Bundle bundle, long j2, Card card, short s, short s2, ByteBuffer byteBuffer) {
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailTLVBegin(Bundle bundle, long j2, Card card) {
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailTLVEnd(Bundle bundle, long j2, Card card) {
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfile0x5eb(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard, oidb_0x5eb.UdcUinData oidb_0x5eb_udcuindata) {
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfileCard(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard) {
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfileService(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard, SparseArray<BusinessRespBuffer> sparseArray) {
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onRequestProfileCard(Bundle bundle, ArrayList<BusinessReqBuffer> arrayList, ArrayList<Integer> arrayList2) {
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onResponseProfileCard(boolean z, Bundle bundle, RespHead respHead, RespSummaryCard respSummaryCard) {
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void requestParseProfileLocation(Card card) {
    }


}
