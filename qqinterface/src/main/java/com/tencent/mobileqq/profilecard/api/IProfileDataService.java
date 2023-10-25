package com.tencent.mobileqq.profilecard.api;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;

import mqq.app.api.IRuntimeService;

public interface IProfileDataService extends IRuntimeService {
    ContactCard getContactCardByMobileNo(String uin, boolean isNoSimple);

    Card getProfileCard(String uin, boolean isNoSimple);

    Card getProfileCardFromCache(String str);

    boolean saveContactCard(ContactCard contactCard);

    boolean saveProfileCard(Card card);
}