package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;


public interface IGProAVChannelConfig extends Serializable {
    ArrayList<IGProBusinessNode> getBusinessList();

    long getChannelDataVersion();

    long getOriginatorTinyId();

    IGProGuildThemeInfo getThemeInfo();

    ArrayList<IGProGuildThemeInfo> getThemeList();

    IGProChannelToolBar getToolBar();

    String toString();
}
