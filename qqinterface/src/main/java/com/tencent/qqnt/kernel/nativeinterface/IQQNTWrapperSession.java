package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IQQNTWrapperSession {
    final class CppProxy implements IQQNTWrapperSession {
        @Override
        public IKernelUixConvertService getUixConvertService() {
            return null;
        }

        @Override
        public IKernelGroupService getGroupService() {
            return null;
        }

        @Override
        public ArrayList<String> getCacheErrLog() {
            return null;
        }

        @Override
        public IKernelMsgService getMsgService() {
            return null;
        }

        @Override
        public IKernelRichMediaService getRichMediaService() {
            return null;
        }

        @Override
        public String getSessionId() {
            return null;
        }

        @Override
        public ArrayList<String> getShortLinkBlacklist() {
            return null;
        }

        @Override
        public boolean offLineSync(boolean z) {
            return false;
        }

        @Override
        public void onDispatchPush(int i2, byte[] bArr) {

        }

        @Override
        public void onDispatchRequestReply(long j2, int i2, byte[] bArr) {

        }

        @Override
        public void switchToBackGround() {

        }

        @Override
        public void switchToFront() {

        }

        @Override
        public String startNT() {
            return null;
        }
    }

    //IKernelAvatarService getAvatarService();

    //IKernelBuddyService getBuddyService();

    IKernelUixConvertService getUixConvertService();

    IKernelGroupService getGroupService();

    ArrayList<String> getCacheErrLog();

    //IKernelConfigMgrService getConfigMgrService();

    //IKernelDirectSessionService getDirectSessionService();

    //IKernelFeedService getFeedChannelService();

    //IKernelGroupService getGroupService();

    //IKernelGuildService getGuildService();

    IKernelMsgService getMsgService();

    //IKernelProfileService getProfileService();

    //IKernelRDeliveryService getRDeliveryService();

    //IKernelRecentContactService getRecentContactService();

    IKernelRichMediaService getRichMediaService();

   // IKernelSearchService getSearchService();

    String getSessionId();

    //IKernelSettingService getSettingService();

    ArrayList<String> getShortLinkBlacklist();

    //IKernelStorageCleanService getStorageCleanService();

   // IKernelTestPerformanceService getTestPerformanceService();

   // IKernelTicketService getTicketService();

    //IKernelTipOffService getTipOffService();

    //IKernelUnitedConfigService getUnitedConfigService();

    //IKernelYellowFaceService getYellowFaceService();

    boolean offLineSync(boolean z);

    void onDispatchPush(int i2, byte[] bArr);

    void onDispatchRequestReply(long j2, int i2, byte[] bArr);

    void switchToBackGround();

    void switchToFront();

    String startNT();
}