package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;


public  final class GroupNotifyMsg implements IKernelModel, Serializable {
    long actionTime;
    GroupNotifyUser actionUser;
    GroupNotifyGroup group;
    GroupInviteExt invitationExt;
    String postscript;
    ArrayList<Long> repeatSeqs;
    long seq;
    long serialVersionUID;
    GroupNotifyMsgStatus status;
    GroupNotifyMsgType type;
    GroupNotifyUser user1;
    GroupNotifyUser user2;
    String warningTips;

    public GroupNotifyMsg() {
        this.serialVersionUID = 1L;
        this.type = GroupNotifyMsgType.values()[0];
        this.status = GroupNotifyMsgStatus.values()[0];
        this.group = new GroupNotifyGroup();
        this.user1 = new GroupNotifyUser();
        this.user2 = new GroupNotifyUser();
        this.actionUser = new GroupNotifyUser();
        this.invitationExt = new GroupInviteExt();
        this.postscript = "";
        this.repeatSeqs = new ArrayList<>();
        this.warningTips = "";
    }

    public long getActionTime() {
        return this.actionTime;
    }

    public GroupNotifyUser getActionUser() {
        return this.actionUser;
    }

    public GroupNotifyGroup getGroup() {
        return this.group;
    }

    public GroupInviteExt getInvitationExt() {
        return this.invitationExt;
    }

    public String getPostscript() {
        return this.postscript;
    }

    public ArrayList<Long> getRepeatSeqs() {
        return this.repeatSeqs;
    }

    public long getSeq() {
        return this.seq;
    }

    public GroupNotifyMsgStatus getStatus() {
        return this.status;
    }

    public GroupNotifyMsgType getType() {
        return this.type;
    }

    public GroupNotifyUser getUser1() {
        return this.user1;
    }

    public GroupNotifyUser getUser2() {
        return this.user2;
    }

    public String getWarningTips() {
        return this.warningTips;
    }

    public void setActionTime(long j2) {
        this.actionTime = j2;
    }

    public void setActionUser(GroupNotifyUser groupNotifyUser) {
        this.actionUser = groupNotifyUser;
    }

    public void setGroup(GroupNotifyGroup groupNotifyGroup) {
        this.group = groupNotifyGroup;
    }

    public void setInvitationExt(GroupInviteExt groupInviteExt) {
        this.invitationExt = groupInviteExt;
    }

    public void setPostscript(String str) {
        this.postscript = str;
    }

    public void setRepeatSeqs(ArrayList<Long> arrayList) {
        this.repeatSeqs = arrayList;
    }

    public void setSeq(long j2) {
        this.seq = j2;
    }

    public void setStatus(GroupNotifyMsgStatus groupNotifyMsgStatus) {
        this.status = groupNotifyMsgStatus;
    }

    public void setType(GroupNotifyMsgType groupNotifyMsgType) {
        this.type = groupNotifyMsgType;
    }

    public void setUser1(GroupNotifyUser groupNotifyUser) {
        this.user1 = groupNotifyUser;
    }

    public void setUser2(GroupNotifyUser groupNotifyUser) {
        this.user2 = groupNotifyUser;
    }

    public void setWarningTips(String str) {
        this.warningTips = str;
    }

    public String toString() {
        return "GroupNotifyMsg{seq=" + this.seq + ",type=" + this.type + ",status=" + this.status + ",group=" + this.group + ",user1=" + this.user1 + ",user2=" + this.user2 + ",actionUser=" + this.actionUser + ",actionTime=" + this.actionTime + ",invitationExt=" + this.invitationExt + ",postscript=" + this.postscript + ",repeatSeqs=" + this.repeatSeqs + ",warningTips=" + this.warningTips + ",}";
    }

    public GroupNotifyMsg(long j2, GroupNotifyMsgType groupNotifyMsgType, GroupNotifyMsgStatus groupNotifyMsgStatus, GroupNotifyGroup groupNotifyGroup, GroupNotifyUser groupNotifyUser, GroupNotifyUser groupNotifyUser2, GroupNotifyUser groupNotifyUser3, long j3, GroupInviteExt groupInviteExt, String str, ArrayList<Long> arrayList, String str2) {
        this.serialVersionUID = 1L;
        this.type = GroupNotifyMsgType.values()[0];
        this.status = GroupNotifyMsgStatus.values()[0];
        this.group = new GroupNotifyGroup();
        this.user1 = new GroupNotifyUser();
        this.user2 = new GroupNotifyUser();
        this.actionUser = new GroupNotifyUser();
        this.invitationExt = new GroupInviteExt();
        this.postscript = "";
        this.repeatSeqs = new ArrayList<>();
        this.warningTips = "";
        this.seq = j2;
        this.type = groupNotifyMsgType;
        this.status = groupNotifyMsgStatus;
        this.group = groupNotifyGroup;
        this.user1 = groupNotifyUser;
        this.user2 = groupNotifyUser2;
        this.actionUser = groupNotifyUser3;
        this.actionTime = j3;
        this.invitationExt = groupInviteExt;
        this.postscript = str;
        this.repeatSeqs = arrayList;
        this.warningTips = str2;
    }
}
