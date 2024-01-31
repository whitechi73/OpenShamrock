package com.tencent.mobileqq.qqguildsdk.data;

import android.text.TextUtils;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProNavigationInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuild;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildSpeakableThreshold;
import com.tencent.qqnt.kernel.nativeinterface.GProMedalInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProNavigationInfo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;


public class GProGuildInfo implements IGProGuildInfo {
    public static final String TAG = "GProGuildInfo";
    private String guildId;
    private GProGuild mGuild;

    public GProGuildInfo(@NotNull GProGuild gProGuild) {
        this.mGuild = gProGuild;
        //this.guildId = com.tencent.mobileqq.qqguildsdk.util.b.U0(gProGuild.getGuildId());
    }


    public GProGuildInfo reflash(GProGuild gProGuild) {
        this.mGuild = gProGuild;
        //com.tencent.mobileqq.qqguildsdk.util.c.e(TAG, false, "cache", "reflash", "GProGuildInfo reflash", toString());
        return this;
    }

    @Override
    public boolean getAllowSearch() {
        return false;
    }

    @Override
    public long getAvatarSeq() {
        return 0;
    }

    @Override
    public String getAvatarUrl(int i2) {
        return null;
    }

    @Override
    public long getBannedTimeLimit() {
        return 0;
    }

    @Override
    public long getChangeNameInterval() {
        return 0;
    }

    @Override
    public boolean getChannelListChange() {
        return false;
    }

    @Override
    public String getClientId() {
        return null;
    }

    @Override
    public int getCoverFontColorId() {
        return 0;
    }

    @Override
    public String getCoverUrl(int i2, int i3) {
        return null;
    }

    @Override
    public long getCreateTime() {
        return 0;
    }

    @Override
    public String getCreatorId() {
        return null;
    }

    @Override
    public String getErrMsg() {
        return null;
    }

    @Override
    public long getGroupId() {
        return 0;
    }

    @Override
    public boolean getGuildCanShare() {
        return false;
    }

    @Override
    public String getGuildID() {
        return null;
    }

    @Override
    public String getGuildName() {
        return null;
    }

    @Override
    public long getGuildNameChangeTime() {
        return 0;
    }

    @Override
    public String getGuildNumber() {
        return null;
    }

    @Override
    public int getGuildType() {
        return 0;
    }

    @Override
    public int getGuildUnNotifyFlag() {
        return 0;
    }

    @Override
    public boolean getIsBanned() {
        return false;
    }

    @Override
    public boolean getIsFrozen() {
        return false;
    }

    @Override
    public boolean getIsValid() {
        return false;
    }

    @Override
    public long getJoinTime() {
        return 0;
    }

    @Override
    public long getJumpChannelId() {
        return 0;
    }

    @Override
    public boolean getJumpChannelSwitch() {
        return false;
    }

    @Override
    public ArrayList<IGProMedalInfo> getMedalInfoList() {
        return null;
    }

    @Override
    public int getMedalLevel() {
        return 0;
    }

    @Override
    public long getMyShutUpExpireTime() {
        return 0;
    }

    @Override
    public ArrayList<IGProNavigationInfo> getNavigationInfoList() {
        return null;
    }

    @Override
    public String getProfile() {
        return null;
    }

    @Override
    public int getQRCodePeriod() {
        return 0;
    }

    @Override
    public int getQRCodeSwitch() {
        return 0;
    }

    @Override
    public int getResult() {
        return 0;
    }

    @Override
    public String getSearchJoinSig() {
        return null;
    }

    @Override
    public String getShowNumber() {
        return null;
    }

    @Override
    public long getShutUpExpireTime() {
        return 0;
    }

    @Override
    public String getTagDesc() {
        return null;
    }

    @Override
    public long getTagId() {
        return 0;
    }

    @Override
    public boolean getTopicSquareSwitch() {
        return false;
    }

    @Override
    public long getU64guildSeq() {
        return 0;
    }

    @Override
    public String getUIData(String str) {
        return null;
    }

    @Override
    public int getUserNum() {
        return 0;
    }

    @Override
    public int getUserType() {
        return 0;
    }

    @Override
    public int getVisibleChannelMaxNum() {
        return 0;
    }

    @Override
    public int getWeakNotifyDisplay() {
        return 0;
    }

    @Override
    public boolean isGroupGuild() {
        return false;
    }

    @Override
    public boolean isInteractiveForVisitor() {
        return false;
    }

    @Override
    public boolean isMember() {
        return false;
    }

    @Override
    public boolean isNeedRealNameForVisitor() {
        return false;
    }

    @Override
    public boolean isTop() {
        return false;
    }

    @Override
    public boolean isVisibleForVisitor() {
        return false;
    }
}
