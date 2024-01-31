package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProAuthControlStatus;
import com.tencent.qqnt.kernel.nativeinterface.GProChannel;
import com.tencent.qqnt.kernel.nativeinterface.GProSlowModeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProTopMsg;
import com.tencent.qqnt.kernel.nativeinterface.GProVisibleTypeInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProChannel implements IGProChannel {
    public final GProChannel mInfo;

    public GGProChannel(GProChannel gProChannel) {
        this.mInfo = gProChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getAnchorTinyId() {
        return this.mInfo.getAnchorTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProApplicationChannelInfo getAppChannelInfo() {
        return new GGProApplicationChannelInfo(this.mInfo.getAppChannelInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public ArrayList<Object> getAuthControlStatusList() {
        ArrayList<GProAuthControlStatus> authControlStatusList = this.mInfo.getAuthControlStatusList();
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProAuthControlStatus> it = authControlStatusList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProAuthControlStatus(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProAVChannelExtInfo getAvChannelExtInfo() {
        return new GGProAVChannelExtInfo(this.mInfo.getAvChannelExtInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getBannedSpeak() {
        return this.mInfo.getBannedSpeak();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getChannelLiveableType() {
        return this.mInfo.getChannelLiveableType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getChannelVisibleType() {
        return this.mInfo.getChannelVisibleType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getCreateTime() {
        return this.mInfo.getCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getCreatorTinyId() {
        return this.mInfo.getCreatorTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getCurrentSlowModeKey() {
        return this.mInfo.getCurrentSlowModeKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getFinalNotifyType() {
        return this.mInfo.getFinalNotifyType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getForumSortMode() {
        return this.mInfo.getForumSortMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getGotoChannelId() {
        return this.mInfo.getGotoChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public String getHotIcon() {
        return this.mInfo.getHotIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public String getIconUrl() {
        //return this.mInfo.getIconUrl();
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getIsCategoryAdmin() {
        return this.mInfo.getIsCategoryAdmin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getIsChannelAdmin() {
        return this.mInfo.getIsChannelAdmin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getJumpSwitch() {
        return this.mInfo.getJumpSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getLastCntMsgSeq() {
        return this.mInfo.getLastCntMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getLastCntMsgTime() {
        return this.mInfo.getLastCntMsgTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getLastMsgSeq() {
        return this.mInfo.getLastMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getLastMsgTime() {
        return this.mInfo.getLastMsgTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProMedalInfo getMedalInfo() {
        return new GGProMedalInfo(this.mInfo.getMedalInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public byte[] getMsgMeta() {
        return this.mInfo.getMsgMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getMsgNotifyType() {
        return this.mInfo.getMsgNotifyType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getMyForumSortMode() {
        return this.mInfo.getMyForumSortMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getMySpeakPermission() {
        return this.mInfo.getMySpeakPermission();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public String getOperationTitle() {
        return "this.mInfo.getOperationTitle()";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getOperationType() {
        //return this.mInfo.getOperationType();
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getReadCntMsgSeq() {
        return this.mInfo.getReadCntMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getReadCntMsgTime() {
        return this.mInfo.getReadCntMsgTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public byte[] getReadMsgMeta() {
        return this.mInfo.getReadMsgMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getReadMsgSeq() {
        return this.mInfo.getReadMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getReadMsgTime() {
        return this.mInfo.getReadMsgTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getResult() {
        return this.mInfo.getResult();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getRoomId() {
        return this.mInfo.getRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public String getRoomName() {
        return this.mInfo.getRoomName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public ArrayList<Object> getSlowModeInfo() {
        ArrayList<GProSlowModeInfo> slowModeInfo = this.mInfo.getSlowModeInfo();
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProSlowModeInfo> it = slowModeInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProSlowModeInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public ArrayList<Integer> getSpecialTypes() {
        return this.mInfo.getSpecialTypes();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getTalkPermission() {
        return this.mInfo.getTalkPermission();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getTextChannelSubtypeId() {
        return this.mInfo.getTextChannelSubtypeId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public ArrayList<Object> getTopMsgList() {
        ArrayList<GProTopMsg> topMsgList = this.mInfo.getTopMsgList();
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProTopMsg> it = topMsgList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProTopMsg(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getTopMsgOperatorTinyId() {
        return this.mInfo.getTopMsgOperatorTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getTopMsgSeq() {
        return this.mInfo.getTopMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getTopMsgTime() {
        return this.mInfo.getTopMsgTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getUint32HotIndex() {
        return this.mInfo.getUint32HotIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getVisibleType() {
        return this.mInfo.getVisibleType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public ArrayList<Object> getVisibleTypeInfo() {
        ArrayList<GProVisibleTypeInfo> visibleTypeInfo = this.mInfo.getVisibleTypeInfo();
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProVisibleTypeInfo> it = visibleTypeInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProVisibleTypeInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
