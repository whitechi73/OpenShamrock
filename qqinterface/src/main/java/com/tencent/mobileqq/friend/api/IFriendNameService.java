package com.tencent.mobileqq.friend.api;

import mqq.app.api.IRuntimeService;

public interface IFriendNameService extends IRuntimeService {
    String getBuddyName(String str, boolean z);

    String getFriendAlias(String str);

    String getFriendName(String str);

    String getFriendName(String str, boolean z);

    String getFriendNick(String str);

    String getFriendRemark(String str);

    String getPhoneContactName(String str);
}