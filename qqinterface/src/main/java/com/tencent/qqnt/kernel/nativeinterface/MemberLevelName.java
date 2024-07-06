package com.tencent.qqnt.kernel.nativeinterface;

public class MemberLevelName {
    public int level;
    public String strName = "";

    public int getLevel() {
        return this.level;
    }

    public String getStrName() {
        return this.strName;
    }

    public String toString() {
        return "MemberLevelName{level=" + this.level + ",strName=" + this.strName + ",}";
    }

}
