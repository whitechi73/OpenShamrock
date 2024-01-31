package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildRole;

import java.util.ArrayList;
import java.util.Iterator;


public class GProGuildRoleInfo implements IGProGuildRoleInfo {
    public static final String TAG = "GProGuildRoleInfo";
    private GProGuildRole mRole;

    public GProGuildRoleInfo(GProGuildRole gProGuildRole) {
        if (gProGuildRole == null) {
            //this.mRole = new GProGuildRole(0L, 0L, "", 0L, false, 0, false, 0, 0, new ArrayList(), new ArrayList(), 0, 0, ad.b(new GProRolePermission()), false, "", "", 0, "", 0L, 0L, 0L, "", 0L, 0L, 0, 0L, "", new ArrayList());
        } else {
            this.mRole = gProGuildRole;
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public ArrayList<String> getApproveSpeakChannels() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Long> it = this.mRole.getApproveSpeakChannels().iterator();
        while (it.hasNext()) {
            //arrayList.add(com.tencent.mobileqq.qqguildsdk.util.b.U0(it.next().longValue()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public ArrayList<String> getApproveVisibleChannels() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Long> it = this.mRole.getApproveVisibleChannels().iterator();
        while (it.hasNext()) {
            //arrayList.add(com.tencent.mobileqq.qqguildsdk.util.b.U0(it.next().longValue()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getBackgroudColor1() {
        return (int) this.mRole.getBackgroudColor1();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getBackgroudColor2() {
        return (int) this.mRole.getBackgroudColor2();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getCategoryType() {
        return this.mRole.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getColor() {
        return (int) this.mRole.getColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getCount() {
        return this.mRole.getCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public String getDisplayTagName() {
        return this.mRole.getDisplayTagName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getDisplayType() {
        return this.mRole.getDisplayType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public String getGuildId() {
        return null;
        //return com.tencent.mobileqq.qqguildsdk.util.b.U0(this.mRole.getGuildId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public boolean getHoist() {
        return this.mRole.getBHoist();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public boolean getIsNotSort() {
        return this.mRole.getIsNotSort();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public String getLevelBigIcon() {
        return this.mRole.getLevelBigIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public String getLevelDesc() {
        return this.mRole.getLevelDsc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public String getLevelIconUrl() {
        return this.mRole.getLevelIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public String getLevelSimpleDsc() {
        return this.mRole.getLevelSimpleDsc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getLevelSimpleDscColor() {
        return (int) this.mRole.getLevelSimpleDscColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getLevelSplitLineColor() {
        return (int) this.mRole.getLevelSplitLineColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public ArrayList<String> getManageCategoryIdList() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Long> it = this.mRole.getManageCategoryIdList().iterator();
        while (it.hasNext()) {
            //arrayList.add(com.tencent.mobileqq.qqguildsdk.util.b.U0(it.next().longValue()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public long getManageTagPendingColor() {
        return this.mRole.getManageTagPendingColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getMemberLimit() {
        return this.mRole.getMemberLimit();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public String getName() {
        return this.mRole.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getNameplate() {
        return this.mRole.getNameplate();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getOutlineColor() {
        return (int) this.mRole.getOutlineColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    @NonNull
    public GProRolePermission getPermission() {
        return null;
        //return ad.a(this.mRole.getRolePermissions());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public String getRoleId() {
        return null;
        //return com.tencent.mobileqq.qqguildsdk.util.b.U0(this.mRole.getRoleId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getRoleType() {
        long roleId = this.mRole.getRoleId();
        if (roleId <= 7) {
            return (int) roleId;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getSpeakableChannelsCount() {
        return this.mRole.getSpeakableChannelsCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public int getVisibleChannelsCount() {
        return this.mRole.getVisibleChannelsCount();
    }

    public boolean isChannelRole() {
        return this.mRole.getIsChannelRole();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public boolean isLevelRole() {
        return this.mRole.getType() == 100;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo
    public String toString() {
        return "GProGuildRoleInfo{mRole=" + this.mRole + '}';
    }
}
