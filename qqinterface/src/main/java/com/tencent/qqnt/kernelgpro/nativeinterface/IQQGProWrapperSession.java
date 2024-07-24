package com.tencent.qqnt.kernelgpro.nativeinterface;

public interface IQQGProWrapperSession {
    IKernelGuildService getGuildService();

    static class CppProxy {
        public static native IQQGProWrapperSession getGProWrapperSession(String str);
    }
}
