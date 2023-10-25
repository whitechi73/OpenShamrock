package com.tencent.qqnt.kernel.nativeinterface;

public final class GroupSimpleInfo implements IKernelModel {
    String avatarUrl;
    int discussToGroupMaxMsgSeq;
    int discussToGroupTime;
    long discussToGroupUin;
    long groupCode;
    String groupName;
    long groupShutupExpireTime;
    GroupStatus groupStatus;
    boolean hasMemo;
    boolean hasModifyConfGroupFace;
    boolean hasModifyConfGroupName;
    boolean isConf;
    boolean isTop;
    int maxMember;
    int memberCount;
    MemberRole memberRole;
    long personShutupExpireTime;
    int privilegeFlag;
    String remarkName;
    long toppedTimestamp;

    public GroupSimpleInfo() {
        this.groupName = "";
        this.groupStatus = GroupStatus.values()[0];
        this.memberRole = MemberRole.values()[0];
        this.remarkName = "";
        this.avatarUrl = "";
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getDiscussToGroupMaxMsgSeq() {
        return this.discussToGroupMaxMsgSeq;
    }

    public int getDiscussToGroupTime() {
        return this.discussToGroupTime;
    }

    public long getDiscussToGroupUin() {
        return this.discussToGroupUin;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public long getGroupShutupExpireTime() {
        return this.groupShutupExpireTime;
    }

    public GroupStatus getGroupStatus() {
        return this.groupStatus;
    }

    public boolean getHasMemo() {
        return this.hasMemo;
    }

    public boolean getHasModifyConfGroupFace() {
        return this.hasModifyConfGroupFace;
    }

    public boolean getHasModifyConfGroupName() {
        return this.hasModifyConfGroupName;
    }

    public boolean getIsConf() {
        return this.isConf;
    }

    public boolean getIsTop() {
        return this.isTop;
    }

    public int getMaxMember() {
        return this.maxMember;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public MemberRole getMemberRole() {
        return this.memberRole;
    }

    public long getPersonShutupExpireTime() {
        return this.personShutupExpireTime;
    }

    public int getPrivilegeFlag() {
        return this.privilegeFlag;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public long getToppedTimestamp() {
        return this.toppedTimestamp;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setDiscussToGroupMaxMsgSeq(int i2) {
        this.discussToGroupMaxMsgSeq = i2;
    }

    public void setDiscussToGroupTime(int i2) {
        this.discussToGroupTime = i2;
    }

    public void setDiscussToGroupUin(long j2) {
        this.discussToGroupUin = j2;
    }

    public void setGroupCode(long j2) {
        this.groupCode = j2;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setGroupShutupExpireTime(long j2) {
        this.groupShutupExpireTime = j2;
    }

    public void setGroupStatus(GroupStatus groupStatus) {
        this.groupStatus = groupStatus;
    }

    public void setHasMemo(boolean z) {
        this.hasMemo = z;
    }

    public void setHasModifyConfGroupFace(boolean z) {
        this.hasModifyConfGroupFace = z;
    }

    public void setHasModifyConfGroupName(boolean z) {
        this.hasModifyConfGroupName = z;
    }

    public void setIsConf(boolean z) {
        this.isConf = z;
    }

    public void setIsTop(boolean z) {
        this.isTop = z;
    }

    public void setMaxMember(int i2) {
        this.maxMember = i2;
    }

    public void setMemberCount(int i2) {
        this.memberCount = i2;
    }

    public void setMemberRole(MemberRole memberRole) {
        this.memberRole = memberRole;
    }

    public void setPersonShutupExpireTime(long j2) {
        this.personShutupExpireTime = j2;
    }

    public void setPrivilegeFlag(int i2) {
        this.privilegeFlag = i2;
    }

    public void setRemarkName(String str) {
        this.remarkName = str;
    }

    public void setToppedTimestamp(long j2) {
        this.toppedTimestamp = j2;
    }

    public String toString() {
        return "GroupSimpleInfo{groupCode=" + this.groupCode + ",maxMember=" + this.maxMember + ",memberCount=" + this.memberCount + ",groupName=" + this.groupName + ",groupStatus=" + this.groupStatus + ",memberRole=" + this.memberRole + ",isTop=" + this.isTop + ",toppedTimestamp=" + this.toppedTimestamp + ",privilegeFlag=" + this.privilegeFlag + ",isConf=" + this.isConf + ",hasModifyConfGroupFace=" + this.hasModifyConfGroupFace + ",hasModifyConfGroupName=" + this.hasModifyConfGroupName + ",remarkName=" + this.remarkName + ",avatarUrl=" + this.avatarUrl + ",hasMemo=" + this.hasMemo + ",groupShutupExpireTime=" + this.groupShutupExpireTime + ",personShutupExpireTime=" + this.personShutupExpireTime + ",discussToGroupUin=" + this.discussToGroupUin + ",discussToGroupMaxMsgSeq=" + this.discussToGroupMaxMsgSeq + ",discussToGroupTime=" + this.discussToGroupTime + ",}";
    }

    public GroupSimpleInfo(long j2, int i2, int i3, String str, GroupStatus groupStatus, MemberRole memberRole, boolean z, long j3, int i4, boolean z2, boolean z3, boolean z4, String str2, String str3, boolean z5, long j4, long j5, long j6, int i5, int i6) {
        this.groupName = "";
        this.groupStatus = GroupStatus.values()[0];
        this.memberRole = MemberRole.values()[0];
        this.remarkName = "";
        this.avatarUrl = "";
        this.groupCode = j2;
        this.maxMember = i2;
        this.memberCount = i3;
        this.groupName = str;
        this.groupStatus = groupStatus;
        this.memberRole = memberRole;
        this.isTop = z;
        this.toppedTimestamp = j3;
        this.privilegeFlag = i4;
        this.isConf = z2;
        this.hasModifyConfGroupFace = z3;
        this.hasModifyConfGroupName = z4;
        this.remarkName = str2;
        this.avatarUrl = str3;
        this.hasMemo = z5;
        this.groupShutupExpireTime = j4;
        this.personShutupExpireTime = j5;
        this.discussToGroupUin = j6;
        this.discussToGroupMaxMsgSeq = i5;
        this.discussToGroupTime = i6;
    }
}