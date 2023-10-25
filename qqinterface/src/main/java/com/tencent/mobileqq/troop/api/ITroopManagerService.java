package com.tencent.mobileqq.troop.api;

import mqq.app.api.IRuntimeService;

public interface ITroopManagerService extends IRuntimeService {
    void getTroopsMemberList(); // 会发送请求
}