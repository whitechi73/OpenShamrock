package com.tencent.qqnt.kernel.nativeinterface;

public interface IQQNTWrapperNetworkListener {

    void onNetworkStatusChanged(NetStatusType o, NetStatusType n);
}