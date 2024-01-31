package com.tencent.qqnt.kernel.nativeinterface;


public  final class GroupNotifyOperateMsg implements IKernelModel {
    GroupNotifyOperateType operateType;
    GroupNotifyTargetMsg targetMsg;

    public GroupNotifyOperateMsg() {
        this.operateType = GroupNotifyOperateType.values()[0];
        this.targetMsg = new GroupNotifyTargetMsg();
    }

    public GroupNotifyOperateType getOperateType() {
        return this.operateType;
    }

    public GroupNotifyTargetMsg getTargetMsg() {
        return this.targetMsg;
    }

    public void setOperateType(GroupNotifyOperateType groupNotifyOperateType) {
        this.operateType = groupNotifyOperateType;
    }

    public void setTargetMsg(GroupNotifyTargetMsg groupNotifyTargetMsg) {
        this.targetMsg = groupNotifyTargetMsg;
    }

    public String toString() {
        return "GroupNotifyOperateMsg{operateType=" + this.operateType + ",targetMsg=" + this.targetMsg + ",}";
    }

    public GroupNotifyOperateMsg(GroupNotifyOperateType groupNotifyOperateType, GroupNotifyTargetMsg groupNotifyTargetMsg) {
        this.operateType = GroupNotifyOperateType.values()[0];
        this.targetMsg = new GroupNotifyTargetMsg();
        this.operateType = groupNotifyOperateType;
        this.targetMsg = groupNotifyTargetMsg;
    }
}
