package com.tencent.mobileqq.filemanager.api;

import mqq.app.api.IRuntimeService;

public interface IQFileConfigManager extends IRuntimeService {
    boolean getC2CFileIPv6Switch();

    //com.tencent.mobileqq.config.business.qfile.d getDatalineConfig();

    boolean getDatalineFileIPv6Switch();

    boolean getDiscFileIPv6Switch();

    //com.tencent.mobileqq.config.business.qfile.e getExcitingC2CDownloadConfig();
    //f getExcitingC2CUploadConfig();
    //g getExcitingGroupDownloadConfig();
    //h getExcitingGroupUploadConfig();
    //b getFileAssistantTipsConfig();
    //com.tencent.mobileqq.filemanager.data.c getFileAutoDownloadConfig(String str);

    int getFileIPv6Strategy();

    boolean getFileIPv6Switch();

    //IQFileFileReaderConfigBean getFileReaderConfig();

    boolean getGroupFileIPv6Switch();

    String getHarcodeIP();

    //com.tencent.mobileqq.config.business.qfile.a getQFileConfigManager();

    boolean getTroopVideoFileSVIPSwitch();

    boolean getTroopVideoFileSwitch();

    boolean getTroopVideoFileYearSVIPSwitch();

    //com.tencent.mobileqq.config.business.qfile.b getYYBPromoteConfig();
    //com.tencent.mobileqq.config.business.qfile.c getYYBPromoteDialogConfig();

    boolean isHarcodeIP();

    boolean isMMApkFileCheckEnable();

    boolean isMediaPlatformEnabled();

    boolean isMediaPlatformLocalEnabled();

    boolean isUseMediaPlatformLocalConfig();

    boolean isWlanOnly();

    void setDatalineConfig();

    void setDebugDatalineSettingDevice(int i2);

    void setDebugDatalineSettingUin(String str);

    void setDebugTroopAIOVideoDownloadPlay(boolean z);

    void setFileReaderConfig();

    void setHarcodeIP(String str);

    void setHarcodeIP(boolean z);

    void setMMApkFileCheckEnable(boolean z);

    void setMediaPlatformLocalEnabled(boolean z);

    void setUseMediaPlatformLocalConfig(boolean z);

    void setWlanOnly(boolean z);
}
