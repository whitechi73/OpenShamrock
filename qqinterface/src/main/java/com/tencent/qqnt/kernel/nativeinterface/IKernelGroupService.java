package com.tencent.qqnt.kernel.nativeinterface;

public interface IKernelGroupService {
    void getTransferableMemberInfo(long uin, IGetTransferableMemberCallback cb);

    long addKernelGroupListener(IKernelGroupListener ln);
}
