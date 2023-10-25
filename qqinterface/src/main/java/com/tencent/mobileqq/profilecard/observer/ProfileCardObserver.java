package com.tencent.mobileqq.profilecard.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.Card;

public class ProfileCardObserver implements BusinessObserver {
    @Override
    public void onUpdate(int result, boolean success, Object obj) {

    }

    protected void onGetProfileCard(boolean z, Object obj) {
    }

    public void onGetProfileDetail(boolean z, String str, Card card) {
    }

    protected void onSetCardTemplateReturn(boolean z, Object obj) {
    }

    protected void onSetProfileDetail(boolean z, int i2, Card card) {
    }
}
