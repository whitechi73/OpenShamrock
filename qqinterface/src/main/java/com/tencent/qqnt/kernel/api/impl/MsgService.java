package com.tencent.qqnt.kernel.api.impl;

import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaFilePathInfo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MsgService {
    public void addMsgListener(IKernelMsgListener listener) {
    }

    public String getRichMediaFilePathForGuild(@NotNull RichMediaFilePathInfo richMediaFilePathInfo) {
        return null;
    }

    @Nullable
    public String getRichMediaFilePathForMobileQQSend(@NotNull RichMediaFilePathInfo richMediaFilePathInfo) {
        return null;
    }
}
