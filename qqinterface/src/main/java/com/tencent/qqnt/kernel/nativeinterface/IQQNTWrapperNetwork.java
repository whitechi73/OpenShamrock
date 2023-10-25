package com.tencent.qqnt.kernel.nativeinterface;

public interface IQQNTWrapperNetwork {
    final class CppProxy implements IQQNTWrapperNetwork {

        public static native IQQNTWrapperNetwork openNetworkService();

        @Override
        public long addNetworkServiceListener(IQQNTWrapperNetworkListener listener) {
            return 0;
        }
    }

    long addNetworkServiceListener(IQQNTWrapperNetworkListener listener);
}
