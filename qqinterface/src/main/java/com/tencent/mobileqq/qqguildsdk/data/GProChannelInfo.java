package com.tencent.mobileqq.qqguildsdk.data;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProInviteSpeakCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceQueueCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceSpeakModeCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteSpeakCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceQueueCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg;
import com.tencent.qqnt.kernel.nativeinterface.GProAVChannelExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProAuthControlStatus;
import com.tencent.qqnt.kernel.nativeinterface.GProChannel;
import com.tencent.qqnt.kernel.nativeinterface.GProInviteSpeakCfg;
import com.tencent.qqnt.kernel.nativeinterface.GProMedalInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProSlowModeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProTopMsg;
import com.tencent.qqnt.kernel.nativeinterface.GProVisibleTypeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProVoiceQueueCfg;
import com.tencent.qqnt.kernel.nativeinterface.GProVoiceSpeakModeCfg;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GProChannelInfo implements IGProChannelInfo {
    public static final String TAG = "GProChannelInfo";
    private String channelUin;
    private long mCategoryId = 0;
    private String mCategoryName = "";
    private GProChannel mChannel;

    public GProChannelInfo(GProChannel gProChannel) {

    }

    //public static GProChannel getDefalutGProChannel(f fVar) {
    //    return new GProChannel(com.tencent.mobileqq.qqguildsdk.util.b.L0(fVar.e()), com.tencent.mobileqq.qqguildsdk.util.b.L0(fVar.g()), fVar.l(), fVar.o(), 1L, 1L, fVar.m(), fVar.k(), 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, new byte[0], new byte[0], 1, 0L, 0L, "", 0, fVar.r(), new ArrayList(), fVar.f(), 0L, 0L, 0L, 0, null, 0, 0, 0, 0, new ArrayList(), 0, 0, null, null, 0, new ArrayList(), new GProAVChannelExtInfo(), 0L, 0, 0, "", new GProMedalInfo(), 0, 0, "", "");
    //}

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Deprecated
    public int getAllowOtherRaiseHand() {
        return this.mChannel.getAvChannelExtInfo().getAllowOtherRaiseHand();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getAppChannelIconUrl() {
        if (this.mChannel.getAppChannelInfo() == null) {
            return null;
        }
        return this.mChannel.getAppChannelInfo().getAppChannelIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getAppChannelJumpType() {
        if (this.mChannel.getAppChannelInfo() == null) {
            return 0;
        }
        return this.mChannel.getAppChannelInfo().getAppChannelJumpType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getAppChannelJumpUrl() {
        if (this.mChannel.getAppChannelInfo() == null) {
            return null;
        }
        return this.mChannel.getAppChannelInfo().getAppChannelJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getApplicationId() {
        if (this.mChannel.getAppChannelInfo() == null) {
            return 0L;
        }
        return this.mChannel.getAppChannelInfo().getApplicationId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getBannedSpeak() {
        return this.mChannel.getBannedSpeak();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getCategoryId() {
        return this.mCategoryId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getCategoryName() {
        return this.mCategoryName;
    }

    public GProChannel getChannel() {
        return this.mChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getChannelLiveableType() {
        return this.mChannel.getChannelLiveableType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getChannelMemberMax() {
        if (getType() == 2) {
            return this.mChannel.getAvChannelExtInfo().getChannelMaxMember();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getChannelName() {
        return this.mChannel.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getChannelUin() {
        return this.channelUin;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public ArrayList<Object> getChannelVisibleInfo() {
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProVisibleTypeInfo> it = this.mChannel.getVisibleTypeInfo().iterator();
        while (it.hasNext()) {
            arrayList.add(new GProGuildVisibleTypeInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getCreateTime() {
        return this.mChannel.getCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getCreatorId() {
        return "com.tencent.mobileqq.qqguildsdk.util.b.U0(this.mChannel.getCreatorTinyId())";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getFinalMsgNotify() {
        return this.mChannel.getFinalNotifyType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @SuppressLint({"WrongConstant"})
    public int getForumSortMode() {
        return this.mChannel.getForumSortMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public ArrayList<ISlowModeInfo> getGProSlowModeInfoList() {
        ArrayList<ISlowModeInfo> arrayList = new ArrayList<>();
        if (this.mChannel.getSlowModeInfo() != null) {
            Iterator<GProSlowModeInfo> it = this.mChannel.getSlowModeInfo().iterator();
            while (it.hasNext()) {
               // arrayList.add(new SlowModeInfo(it.next()));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getGotoChannelId() {
        return this.mChannel.getGotoChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getGuildId() {
        return "com.tencent.mobileqq.qqguildsdk.util.b.U0(this.mChannel.getGuildId())";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getHotIcon() {
        return this.mChannel.getHotIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getHotIndex() {
        return this.mChannel.getUint32HotIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getIconUrl() {
        return "this.mChannel.getIconUrl()";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public IGProInviteSpeakCfg getInviteSpeakCfg() {
        return new GGProInviteSpeakCfg(this.mChannel.getAvChannelExtInfo().getInviteSpeakCfg());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getIsCategoryAdmin() {
        return this.mChannel.getIsCategoryAdmin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getIsChannelAdmin() {
        return this.mChannel.getIsChannelAdmin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getJumpSwitch() {
        return this.mChannel.getJumpSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLastCntMsgSeq() {
        return this.mChannel.getLastCntMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLastCntMsgTime() {
        return this.mChannel.getLastCntMsgTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLastMsgSeq() {
        return this.mChannel.getLastMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLastMsgTime() {
        return this.mChannel.getLastMsgTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLiveAnchorTinyId() {
        return this.mChannel.getAnchorTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLiveRoomId() {
        return this.mChannel.getRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getLiveRoomName() {
        return this.mChannel.getRoomName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public IGProMedalInfo getMedalInfo() {
        return new GGProMedalInfo(this.mChannel.getMedalInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public byte[] getMsgMeta() {
        return this.mChannel.getMsgMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getMsgNotify() {
        return this.mChannel.getMsgNotifyType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @SuppressLint({"WrongConstant"})
    public int getMyForumSortMode() {
        return this.mChannel.getMyForumSortMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getMyTalkPermissionType() {
        return this.mChannel.getMySpeakPermission();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getNoMemberMaxLimited() {
        return this.mChannel.getAvChannelExtInfo().getNoMemberMaxLimited();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getOperationTitle() {
        return "this.mChannel.getOperationTitle()";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getOperationType() {
        //"this.mChannel.getOperationType()";
        return 10;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getReadCntMsgSeq() {
        return this.mChannel.getReadCntMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getReadCntMsgTime() {
        return this.mChannel.getReadCntMsgTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public byte[] getReadMsgMeta() {
        return this.mChannel.getReadMsgMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getReadMsgSeq() {
        return this.mChannel.getReadMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getReadMsgTime() {
        return this.mChannel.getReadMsgTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getSlowModeKey() {
        return this.mChannel.getCurrentSlowModeKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @NotNull
    public List<Integer> getSpecialType() {
        return this.mChannel.getSpecialTypes();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getTalkPermission() {
        return this.mChannel.getTalkPermission();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getTextChannelSubtypeId() {
        return this.mChannel.getTextChannelSubtypeId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public ArrayList<IGProTopMsg> getTopMsgList() {
        ArrayList<IGProTopMsg> arrayList = new ArrayList<>();
        Iterator<GProTopMsg> it = this.mChannel.getTopMsgList().iterator();
        while (it.hasNext()) {
            arrayList.add(new GProTopMsgInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getTopMsgOperatorTinyId() {
        return "com.tencent.mobileqq.qqguildsdk.util.b.U0(this.mChannel.getTopMsgOperatorTinyId())";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getTopMsgSeq() {
        return this.mChannel.getTopMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getTopMsgTime() {
        return this.mChannel.getTopMsgTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getType() {
        return this.mChannel.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getVisibleType() {
        return this.mChannel.getChannelVisibleType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public IGProVoiceQueueCfg getVoiceQueueCfg() {
        return new GGProVoiceQueueCfg(this.mChannel.getAvChannelExtInfo().getVoiceQueueCfg());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public IGProVoiceSpeakModeCfg getVoiceSpeakModeCfg() {
        return new GGProVoiceSpeakModeCfg(this.mChannel.getAvChannelExtInfo().getVoiceSpeakModeCfg());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public boolean isAllowOtherRaiseHand() {
        return this.mChannel.getAvChannelExtInfo().getAllowOtherRaiseHand() == 1;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public boolean isChannelOrCategoryAdmin() {
        return getIsChannelAdmin() == 1 || getIsCategoryAdmin() == 1;
    }

    public boolean isEqual(IGProChannelInfo iGProChannelInfo) {
        return iGProChannelInfo != null && getChannelName().equals(iGProChannelInfo.getChannelName()) && getType() == iGProChannelInfo.getType() && getTalkPermission() == iGProChannelInfo.getTalkPermission() && getMsgNotify() == iGProChannelInfo.getMsgNotify() && getFinalMsgNotify() == iGProChannelInfo.getFinalMsgNotify();
    }

    public GProChannelInfo reflash(GProChannel gProChannel) {
        this.mChannel = gProChannel;
        this.channelUin = "com.tencent.mobileqq.qqguildsdk.util.b.U0(gProChannel.getChannelId())";
        return this;
    }

    public void setBannedSpeak(int i2) {
        this.mChannel.setBannedSpeak(i2);
    }

    public void setCategory(long j2, String str) {
        this.mCategoryId = j2;
        this.mCategoryName = str;
    }

    public void setChannelLiveableType(int i2) {
        this.mChannel.setChannelLiveableType(i2);
    }

    public void setChannelMemberMax(int i2) {
        if (getType() == 2) {
            this.mChannel.getAvChannelExtInfo().setChannelMaxMember(i2);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public void setFinalMsgNotify(int i2) {
        this.mChannel.setFinalNotifyType(i2);
    }

    public void setForumSortMode(int i2) {
        this.mChannel.setForumSortMode(i2);
    }

    public void setLiveAnchorTinyId(long j2) {
        this.mChannel.setAnchorTinyId(j2);
    }

    public void setLiveRoomId(long j2) {
        this.mChannel.setRoomId(j2);
    }

    public void setLiveRoomName(String str) {
        this.mChannel.setRoomName(str);
    }

    public void setMsgNotify(int i2) {
        this.mChannel.setMsgNotifyType(i2);
    }

    public void setMyForumSortMode(int i2) {
        this.mChannel.setMyForumSortMode(i2);
    }

    public void setName(String str) {
        this.mChannel.setName(str);
    }

    public void setSlowModeKey(int i2) {
        this.mChannel.setCurrentSlowModeKey(i2);
    }

    public void setTalkPermission(int i2) {
        this.mChannel.setTalkPermission(i2);
    }

    public void setTopMsgList(ArrayList<IGProTopMsg> arrayList) {
        ArrayList<GProTopMsg> arrayList2 = new ArrayList<>();
        Iterator<IGProTopMsg> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((GProTopMsgInfo) it.next()).mInfo);
        }
        this.mChannel.setTopMsgList(arrayList2);
    }

    public void setTopMsgOperatorTinyId(String str) {
        //this.mChannel.setTopMsgOperatorTinyId(com.tencent.mobileqq.qqguildsdk.util.b.L0(str));
    }

    public void setTopMsgSeq(long j2) {
        this.mChannel.setTopMsgSeq(j2);
    }

    public void setTopMsgTime(long j2) {
        this.mChannel.setTopMsgTime(j2);
    }

    public void setType(int i2) {
        this.mChannel.setType(i2);
    }

    public void setVisibleType(int i2) {
        this.mChannel.setVisibleType(i2);
        this.mChannel.setChannelVisibleType(i2);
    }

    @NonNull
    public String toString() {
        return "GProChannelInfo:ID: GuildId:" + getGuildId() + ", chanUin:" + getChannelUin() + ", name:" + getChannelName() + ", talkPermission:" + getTalkPermission() + ", type:" + getType() + ", visibleType:" + getVisibleType() + ", msgNotifyType:" + getMsgNotify() + ", finalMsgNotifyType:" + getFinalMsgNotify() + ", createTime:" + getCreateTime() + ", channelMemMax:" + getChannelMemberMax() + ", roomId:" + getLiveRoomId() + ", slowModeKey:" + getSlowModeKey() + ", textChannelSubtypeId:" + getTextChannelSubtypeId() + ", applicationId:" + getApplicationId() + ", appChannelIcon:" + getAppChannelIconUrl() + ", appChannelJumpType:" + getAppChannelJumpType() + ", appChannelJumpUrl:" + getAppChannelJumpUrl() + ", getGotoChannelId:" + getGotoChannelId() + ", getJumpSwitch" + getJumpSwitch() + ", avNoMemberMaxLimited:" + getNoMemberMaxLimited() + ", getHotIcon:" + getHotIcon() + ", getMedalInfo:" + getMedalInfo() + ", getOperationType:" + getOperationType() + ", getOperationTitle:" + getOperationTitle() + ", getIconUrl:" + getIconUrl();
    }
}
