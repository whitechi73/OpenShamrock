package com.tencent.mobileqq.app;

import com.tencent.common.app.business.BaseQQAppInterface;

import mqq.manager.Manager;

public class QQAppInterface extends BaseQQAppInterface {
    public static final int ACCOUNT_MANAGER = 0;
    public static final int WTLOGIN_MANAGER = 1;
    public static final int TICKET_MANAGER = 2;

    @Override
    public String getCurrentAccountUin() {
        return null;
    }

    public void execute(Runnable runnable) {

    }

    @Override
    public String getCurrentNickname() {
       return null;
    }

    public void syncOnlineFriend() {
    }

    public MessageHandler getMsgHandler() {
        return null;
    }

    public Manager getManager(int id) {
        return null;
    }
}
