package com.tencent.mobileqq.profilecard.processor;

import java.util.ArrayList;

import mqq.app.AppRuntime;

public class ProfileBusinessProcessorFactory {
    public static ArrayList<Class<? extends AbsProfileBusinessProcessor>> sInjectProcessorClasses;

    private void initBusinessProcessors(AppRuntime appRuntime) {
    }
}
