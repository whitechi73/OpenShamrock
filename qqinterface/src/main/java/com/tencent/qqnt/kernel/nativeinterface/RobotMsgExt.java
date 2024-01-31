package com.tencent.qqnt.kernel.nativeinterface;


public  final class RobotMsgExt {
    boolean robotMsgFlag;

    public RobotMsgExt() {
    }

    public boolean getRobotMsgFlag() {
        return this.robotMsgFlag;
    }

    public String toString() {
        return "RobotMsgExt{robotMsgFlag=" + this.robotMsgFlag + ",}";
    }

    public RobotMsgExt(boolean z) {
        this.robotMsgFlag = z;
    }
}
