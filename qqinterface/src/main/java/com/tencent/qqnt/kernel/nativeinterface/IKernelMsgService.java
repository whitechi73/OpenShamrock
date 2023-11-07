package com.tencent.qqnt.kernel.nativeinterface;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public interface IKernelMsgService {
    void deleteMsg(Contact contact, ArrayList<Long> msgIdList, IOperateCallback callback);

    void fetchLongMsg(Contact contact, long msgId);

    void fetchLongMsgWithCb(Contact contact, long msgId, IOperateCallback back);

    void getRecallMsgsByMsgId(Contact contact, ArrayList<Long> msgIdList, IMsgOperateCallback callback);

    void recallMsg(Contact contact, ArrayList<Long> msgIdList, IOperateCallback callback);

    void addLocalRecordMsg(Contact contact, long msgId, MsgElement elem, HashMap<Integer, MsgAttributeInfo> hashMap, boolean z, IOperateCallback callback);

    long getMsgUniqueId(long time);

    void addSendMsg(long msgId, Contact contact, ArrayList<MsgElement> msgList, HashMap<Integer, MsgAttributeInfo> hashMap);

    void getMsgs(@NotNull Contact contact, long startMsgId, int cnt, boolean queryOrder, @NotNull IMsgOperateCallback iMsgOperateCallback);

    void getMsgsIncludeSelf(Contact contact, long startMsgId, int count, boolean queryOrder, IMsgOperateCallback iMsgOperateCallback);

    void translatePtt2Text(long j2, Contact contact, MsgElement msgElement, IOperateCallback iOperateCallback);

    void getMultiMsg(Contact contact, long rootMsgId, long parentMsgId, IGetMultiMsgCallback cb);

    void clearMsgRecords(Contact contact, IClearMsgRecordsCallback cb);

    String createUidFromTinyId(long j2, long j3);

    void switchBackGround(BackGroundInfo backGroundInfo, IOperateCallback cb);

    void switchBackGroundForMqq(byte[] bArr, IOperateCallback cb);

    void switchForeGround(IOperateCallback cb);

    void switchForeGroundForMqq(byte[] bArr, IOperateCallback cb);
}
