package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGuildRole {
    ArrayList<Long> approveSpeakChannels;
    ArrayList<Long> approveVisibleChannels;
    boolean bHoist;
    long backgroudColor1;
    long backgroudColor2;
    long color;
    int count;
    String displayTagName;
    int displayType;
    long guildId;
    boolean isChannelRole;
    boolean isNotSort;
    String levelBigIcon;
    String levelDsc;
    String levelIcon;
    String levelSimpleDsc;
    long levelSimpleDscColor;
    long levelSplitLineColor;
    ArrayList<Long> manageCategoryIdList;
    long manageTagPendingColor;
    int memberLimit;
    String name;
    int nameplate;
    long outlineColor;
    long roleId;
    GProRolePermission rolePermissions;
    int speakableChannelsCount;
    int type;
    int visibleChannelsCount;

    public GProGuildRole() {
        this.name = "";
        this.approveSpeakChannels = new ArrayList<>();
        this.approveVisibleChannels = new ArrayList<>();
        this.rolePermissions = new GProRolePermission();
        this.levelIcon = "";
        this.levelDsc = "";
        this.levelBigIcon = "";
        this.levelSimpleDsc = "";
        this.displayTagName = "";
        this.manageCategoryIdList = new ArrayList<>();
    }

    public ArrayList<Long> getApproveSpeakChannels() {
        return this.approveSpeakChannels;
    }

    public ArrayList<Long> getApproveVisibleChannels() {
        return this.approveVisibleChannels;
    }

    public boolean getBHoist() {
        return this.bHoist;
    }

    public long getBackgroudColor1() {
        return this.backgroudColor1;
    }

    public long getBackgroudColor2() {
        return this.backgroudColor2;
    }

    public long getColor() {
        return this.color;
    }

    public int getCount() {
        return this.count;
    }

    public String getDisplayTagName() {
        return this.displayTagName;
    }

    public int getDisplayType() {
        return this.displayType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getIsChannelRole() {
        return this.isChannelRole;
    }

    public boolean getIsNotSort() {
        return this.isNotSort;
    }

    public String getLevelBigIcon() {
        return this.levelBigIcon;
    }

    public String getLevelDsc() {
        return this.levelDsc;
    }

    public String getLevelIcon() {
        return this.levelIcon;
    }

    public String getLevelSimpleDsc() {
        return this.levelSimpleDsc;
    }

    public long getLevelSimpleDscColor() {
        return this.levelSimpleDscColor;
    }

    public long getLevelSplitLineColor() {
        return this.levelSplitLineColor;
    }

    public ArrayList<Long> getManageCategoryIdList() {
        return this.manageCategoryIdList;
    }

    public long getManageTagPendingColor() {
        return this.manageTagPendingColor;
    }

    public int getMemberLimit() {
        return this.memberLimit;
    }

    public String getName() {
        return this.name;
    }

    public int getNameplate() {
        return this.nameplate;
    }

    public long getOutlineColor() {
        return this.outlineColor;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public GProRolePermission getRolePermissions() {
        return this.rolePermissions;
    }

    public int getSpeakableChannelsCount() {
        return this.speakableChannelsCount;
    }

    public int getType() {
        return this.type;
    }

    public int getVisibleChannelsCount() {
        return this.visibleChannelsCount;
    }

    public String toString() {
        return "GProGuildRole{guildId=" + this.guildId + ",roleId=" + this.roleId + ",name=" + this.name + ",color=" + this.color + ",bHoist=" + this.bHoist + ",count=" + this.count + ",isNotSort=" + this.isNotSort + ",memberLimit=" + this.memberLimit + ",nameplate=" + this.nameplate + ",approveSpeakChannels=" + this.approveSpeakChannels + ",approveVisibleChannels=" + this.approveVisibleChannels + ",speakableChannelsCount=" + this.speakableChannelsCount + ",visibleChannelsCount=" + this.visibleChannelsCount + ",rolePermissions=" + this.rolePermissions + ",isChannelRole=" + this.isChannelRole + ",levelIcon=" + this.levelIcon + ",levelDsc=" + this.levelDsc + ",type=" + this.type + ",levelBigIcon=" + this.levelBigIcon + ",backgroudColor1=" + this.backgroudColor1 + ",backgroudColor2=" + this.backgroudColor2 + ",outlineColor=" + this.outlineColor + ",levelSimpleDsc=" + this.levelSimpleDsc + ",levelSimpleDscColor=" + this.levelSimpleDscColor + ",levelSplitLineColor=" + this.levelSplitLineColor + ",displayType=" + this.displayType + ",manageTagPendingColor=" + this.manageTagPendingColor + ",displayTagName=" + this.displayTagName + ",manageCategoryIdList=" + this.manageCategoryIdList + ",}";
    }

    public GProGuildRole(long j2, long j3, String str, long j4, boolean z, int i2, boolean z2, int i3, int i4, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i5, int i6, GProRolePermission gProRolePermission, boolean z3, String str2, String str3, int i7, String str4, long j5, long j6, long j7, String str5, long j8, long j9, int i8, long j10, String str6, ArrayList<Long> arrayList3) {
        this.name = "";
        this.approveSpeakChannels = new ArrayList<>();
        this.approveVisibleChannels = new ArrayList<>();
        this.rolePermissions = new GProRolePermission();
        this.levelIcon = "";
        this.levelDsc = "";
        this.levelBigIcon = "";
        this.levelSimpleDsc = "";
        this.displayTagName = "";
        this.manageCategoryIdList = new ArrayList<>();
        this.guildId = j2;
        this.roleId = j3;
        this.name = str;
        this.color = j4;
        this.bHoist = z;
        this.count = i2;
        this.isNotSort = z2;
        this.memberLimit = i3;
        this.nameplate = i4;
        this.approveSpeakChannels = arrayList;
        this.approveVisibleChannels = arrayList2;
        this.speakableChannelsCount = i5;
        this.visibleChannelsCount = i6;
        this.rolePermissions = gProRolePermission;
        this.isChannelRole = z3;
        this.levelIcon = str2;
        this.levelDsc = str3;
        this.type = i7;
        this.levelBigIcon = str4;
        this.backgroudColor1 = j5;
        this.backgroudColor2 = j6;
        this.outlineColor = j7;
        this.levelSimpleDsc = str5;
        this.levelSimpleDscColor = j8;
        this.levelSplitLineColor = j9;
        this.displayType = i8;
        this.manageTagPendingColor = j10;
        this.displayTagName = str6;
        this.manageCategoryIdList = arrayList3;
    }
}
