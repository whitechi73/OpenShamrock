package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class GroupGrayElement implements Serializable {
    String adminNick;
    String adminRemark;
    String adminUid;
    CreateGroupGrayElement createGroup;
    String groupName;
    MemberAddGrayElement memberAdd;
    String memberNick;
    String memberRemark;
    String memberUid;
    GroupGrayElementRole role;
    long serialVersionUID;
    GroupShutUpGrayElement shutUp;
    GroupGrayElementType type;

    public GroupGrayElement() {
        this.serialVersionUID = 1L;
        this.type = GroupGrayElementType.values()[0];
        this.role = GroupGrayElementRole.values()[0];
        this.groupName = "";
        this.memberUid = "";
        this.memberNick = "";
        this.memberRemark = "";
        this.adminUid = "";
        this.adminNick = "";
        this.adminRemark = "";
    }

    public String getAdminNick() {
        return this.adminNick;
    }

    public String getAdminRemark() {
        return this.adminRemark;
    }

    public String getAdminUid() {
        return this.adminUid;
    }

    public CreateGroupGrayElement getCreateGroup() {
        return this.createGroup;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public MemberAddGrayElement getMemberAdd() {
        return this.memberAdd;
    }

    public String getMemberNick() {
        return this.memberNick;
    }

    public String getMemberRemark() {
        return this.memberRemark;
    }

    public String getMemberUid() {
        return this.memberUid;
    }

    public GroupGrayElementRole getRole() {
        return this.role;
    }

    public GroupShutUpGrayElement getShutUp() {
        return this.shutUp;
    }

    public GroupGrayElementType getType() {
        return this.type;
    }

    public String toString() {
        return "GroupGrayElement{type=" + this.type + ",role=" + this.role + ",groupName=" + this.groupName + ",memberUid=" + this.memberUid + ",memberNick=" + this.memberNick + ",memberRemark=" + this.memberRemark + ",adminUid=" + this.adminUid + ",adminNick=" + this.adminNick + ",adminRemark=" + this.adminRemark + ",createGroup=" + this.createGroup + ",memberAdd=" + this.memberAdd + ",shutUp=" + this.shutUp + ",}";
    }

    public GroupGrayElement(GroupGrayElementType groupGrayElementType, GroupGrayElementRole groupGrayElementRole, String str, String str2, String str3, String str4, String str5, String str6, String str7, CreateGroupGrayElement createGroupGrayElement, MemberAddGrayElement memberAddGrayElement, GroupShutUpGrayElement groupShutUpGrayElement) {
        this.serialVersionUID = 1L;
        this.type = GroupGrayElementType.values()[0];
        this.role = GroupGrayElementRole.values()[0];
        this.groupName = "";
        this.memberUid = "";
        this.memberNick = "";
        this.memberRemark = "";
        this.adminUid = "";
        this.adminNick = "";
        this.adminRemark = "";
        this.type = groupGrayElementType;
        this.role = groupGrayElementRole;
        this.groupName = str;
        this.memberUid = str2;
        this.memberNick = str3;
        this.memberRemark = str4;
        this.adminUid = str5;
        this.adminNick = str6;
        this.adminRemark = str7;
        this.createGroup = createGroupGrayElement;
        this.memberAdd = memberAddGrayElement;
        this.shutUp = groupShutUpGrayElement;
    }
}
