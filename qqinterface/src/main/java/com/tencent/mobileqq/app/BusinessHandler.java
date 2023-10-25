package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;

import java.util.Set;

public abstract class BusinessHandler extends BaseBusinessHandler {
    public BusinessHandler(AppInterface appInterface) {
    }

    @Override
    public Set<String> getCommandList() {
        return null;
    }

    @Override
    public Set<String> getPushCommandList() {
        return null;
    }

    @Override
    public Set<String> getPushPBCommandList() {
        return null;
    }
}
